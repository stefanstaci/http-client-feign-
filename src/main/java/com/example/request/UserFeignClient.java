package com.example.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Repository
@FeignClient(name = "request", url = "http://localhost:9999/api/clients", configuration = FeignClientConfig.class)
public interface UserFeignClient {
    @GetMapping(value = "/clients", consumes = MediaType.APPLICATION_JSON_VALUE)
     List<Client> getClients();

}
