package com.sava.rentingservice.comunication;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sava.communication.data.BookDTO;
import com.sava.communication.data.UserDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommunicationService {
    private final RestTemplate restTemplate;

    public BookDTO getBookById(String id) {
        ResponseEntity<BookDTO> response = restTemplate.exchange(
                RestClientConfig.BOOK_BASE_URL + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<BookDTO>() {
                });

        return response.getBody();
    }

    public Boolean decreaseBook(String id) {
        ResponseEntity<Boolean> response = restTemplate.exchange(
                RestClientConfig.BOOK_BASE_URL + "/decrease/" + id,
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<Boolean>() {
                });

        return response.getBody();
    }

    public UserDTO getUserId(String id) {
        ResponseEntity<UserDTO> response = restTemplate.exchange(
                RestClientConfig.USER_BASE_URL + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<UserDTO>() {
                });

        return response.getBody();
    }
}
