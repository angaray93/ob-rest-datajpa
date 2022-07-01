package com.example.obrestdatajpa.services;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePrice() {

        //configuracion de la prueba
        Book book = new Book(null, "Harry Potter", "J.K. Rowling", 450, 29.99, LocalDate.of(1993,04,21),true);
        BookPriceCalculator bookPriceCalculator = new BookPriceCalculator();

        //se ejecuta el comportamiento a testear
        double price = bookPriceCalculator.calculatePrice(book);
        System.out.println(price);

        //comprobaciones aserciones
        assertTrue(price > 0);
        assertEquals(57.98000000000004,price);
    }
}