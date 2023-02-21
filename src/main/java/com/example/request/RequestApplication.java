package com.example.request;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class RequestApplication {

//    @Bean
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }

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
