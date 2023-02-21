package com.example.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final UserFeignClient userFeignClient;

    public List<Client> getClients() {
        return userFeignClient.getClients();
    }
}
