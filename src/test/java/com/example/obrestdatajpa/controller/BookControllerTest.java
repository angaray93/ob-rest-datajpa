package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookControllerTest {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;

    void setUp(){
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void hello(){
        ResponseEntity<String> response =
                testRestTemplate.getForEntity("/hola", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Hola mundo que tal vamos!! Hasta luego", response.getBody());
    }

    @Test
    void findAll(){
        ResponseEntity<Book[]> response =
        testRestTemplate.getForEntity("/api/books", Book[].class);
    }

    @Test
    void findOneById() {
        ResponseEntity<Book> response =
                testRestTemplate.getForEntity("/api/books/1", Book.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                    {
                       "title":"Homo Deus",
                       "author":"Yuval Noah",
                       "pages":450,
                       "price":29.99,
                       "releaseDate":"2019-12-01",
                       "onLine":false
                    }
                    """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        //ResponseEntity<Book> response = testRestTemplate.exchange("/api/books", HttpMethod.POST, Book.class);

    }

}