package com.example.request;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;

@SpringBootApplication
@EnableFeignClients
public class RequestApplication {

//    @Bean
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }

    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("47.254.90.125", 8000));
        requestFactory.setProxy(proxy);

        return new RestTemplate(requestFactory);
    }

    public static void main(String[] args) {
        SpringApplication.run(RequestApplication.class, args);
//
//        try (
//                CloseableHttpClient client = HttpClients.createDefault();
//                CloseableHttpResponse response = client.execute(new HttpGet("http://localhost:9999/api/clients"))
//        ){
//
//            HttpEntity entity = response.getEntity();
//
//            if (entity != null) {
//                String data = entity.getContent().toString();
//                System.out.println(data);
//            }
//
//        }  catch (Throwable cause) {
//            cause.printStackTrace();
//        }
    }

}
