package com.example.obrestdatajpa.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String autor;
    private Integer pages;
    private Double price;
    private LocalDate releaseDate;
    private Boolean onLine;

    //constructor
    public Book() {
    }

    public Book(Long id, String title, String autor, Integer pages, Double price, LocalDate releaseDate, Boolean onLine) {
        this.id = id;
        this.title = title;
        this.autor = autor;
        this.pages = pages;
        this.price = price;
        this.releaseDate = releaseDate;
        this.onLine = onLine;
    }

    //getter y setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getOnLine() {
        return onLine;
    }

    public void setOnLine(Boolean onLine) {
        this.onLine = onLine;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    //toString

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", onLine=" + onLine +
                '}';
    }
}
