package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		Book b1 = new Book(null, "Homo Deus", "Yuval Noah", 450, 29.99, LocalDate.of(1993,04,21),true);
		Book b2 = new Book(null, "Homo Sapiens", "Yuval Noah", 450, 19.99, LocalDate.of(1990,05,8),true);

		repository.save(b1);
		repository.save(b2);
		//CRUD
		//crear

		//almacenar

		//recuperar todos

		//eliminar
	}



}
