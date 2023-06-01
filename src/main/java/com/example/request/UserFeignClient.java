//package com.example.request;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//@FeignClient(name = "request", url = "http://localhost:9999/api", configuration = FeignClientConfig.class)
//public interface UserFeignClient {
//    @GetMapping(value = "/clients", consumes = MediaType.APPLICATION_JSON_VALUE)
//     List<Client> getClients();
//
//    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
//    Client saveClient(@RequestBody Client client);
//}
