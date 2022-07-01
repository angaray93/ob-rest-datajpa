package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    //@Autowired
    BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/books")
    public List<Book> findAll(){
        return repository.findAll();
    }

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
        Optional<Book> optBook = repository.findById(id);
        if(optBook.isPresent())
            return ResponseEntity.ok(optBook.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/books")
    public Book create(@RequestBody Book book) {
        return repository.save(book);
    }

}
