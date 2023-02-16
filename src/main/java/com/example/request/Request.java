package com.example.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class Request implements Runnable {

    private final RestTemplate restTemplate;


    @GetMapping("/clients")
    public List<Object> getClients() {
        String url = "http://localhost:9999/api/clients";
        Object[] objects = restTemplate.getForObject(url, Object[].class);

        assert objects != null;
        return Arrays.asList(objects);
    }

    @PostMapping("/save")
    public Client createClients(@RequestBody Client client) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Client> entity = new HttpEntity<Client>(client, headers);

        ResponseEntity<Client> response = restTemplate.exchange(
                "http://localhost:9999/api/save", HttpMethod.POST, entity, Client.class);

        return response.getBody();
    }

    @PostMapping("/save/all")
    public List<Client> createAllClients(@RequestBody List<Client> client) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        for (Client c : client) {
            HttpEntity<Client> entity = new HttpEntity<>(c,headers);
            restTemplate.exchange(
                    "http://localhost:9999/api/save", HttpMethod.POST, entity, c.getClass());
        }
        return client;
    }


    @Override
    public void run() {
        try {
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}
