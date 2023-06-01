package com.example.request;

import feign.Feign;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class Request {

    private final RestTemplate restTemplate;
//    private final ClientService clientService;


    @GetMapping("/clients")
    public List<Object> getClients() {
        String url = "http://localhost:9999/api/clients";
        Object[] objects = restTemplate.getForObject(url, Object[].class);

        assert objects != null;
        return Arrays.asList(objects);
    }


    @GetMapping("client/head")
    public HttpHeaders retrieveHeaders() {
        String url = "http://localhost:9999/api/clients";

        // send HEAD request
        return this.restTemplate.headForHeaders(url);
    }

    @GetMapping("client/options")
    public Set<HttpMethod> allowedOperations() {
        String url = "http://localhost:9999/api/clients";

        // send HEAD request
        return this.restTemplate.optionsForAllow(url);
    }

//@GetMapping("/clients")
//public ResponseEntity<List<Client>> getAllPosts() {
//    return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
//}

//    @PostMapping("/save")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Client> saveUser(@RequestBody Client client){
//        return new ResponseEntity<>(clientService.saveClient(client), HttpStatus.OK);
//    }

    @PostMapping("/save")
    public Client createClients(@RequestBody Client client) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Client> entity = new HttpEntity<>(client, headers);

        ResponseEntity<Client> response = restTemplate.exchange(
                "http://localhost:9999/api/save", HttpMethod.POST, entity, Client.class);

        return response.getBody();
    }

    @PostMapping("/save/all")
    public List<Client> createAllClients(@RequestBody List<Client> client) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        client.forEach(c -> executorService.submit(() -> {
            HttpEntity<Client> entity = new HttpEntity<>(c, headers);
            restTemplate.exchange(
                    "http://localhost:9999/api/save", HttpMethod.POST, entity, c.getClass());
        }));
//        for (Client c : client) {
//            executorService.submit(() -> {
//                HttpEntity<Client> entity = new HttpEntity<>(c,headers);
//                restTemplate.exchange(
//                        "http://localhost:9999/api/save", HttpMethod.POST, entity, c.getClass());
//            });
//
//        }
        return client;

    }
}
