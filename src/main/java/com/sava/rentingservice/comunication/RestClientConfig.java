package com.sava.rentingservice.comunication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {
    public static final String BOOK_BASE_URL = "http://localhost:8081/api/books";
    public static final String USER_BASE_URL = "http://localhost:8082/api/users";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
