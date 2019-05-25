package com.triton.springbootappenginestandard.controller;

import com.google.common.collect.Lists;
import com.triton.springbootappenginestandard.entity.Book;
import com.triton.springbootappenginestandard.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/api/{title}/{author}/{year}")
    public String saveBook(@PathVariable String title, @PathVariable String author, @PathVariable int year) {
        Book savedBook = this.bookRepository.save(new Book(title, author, year));
        return savedBook.toString();
    }

    @GetMapping("/api")
    public String findAllBooks() {
        Iterable<Book> books = this.bookRepository.findAll();
        return Lists.newArrayList(books).toString();
    }

    @GetMapping("/api")
    public String findByAuthor(@RequestParam String author) {
        List<Book> books = this.bookRepository.findByAuthor(author);
        return books.toString();
    }

    @GetMapping("/api")
    public String findByYearAfter(@RequestParam int year) {
        List<Book> books = this.bookRepository.findByYearGreaterThan(year);
        return books.toString();
    }

    @GetMapping("/api")
    public String findByAuthorYear(@RequestParam String author, @RequestParam int year) {
        List<Book> books = this.bookRepository.findByAuthorAndYear(author, year);
        return books.toString();
    }

    @DeleteMapping("/api")
    public void removeAllBooks() {
        this.bookRepository.deleteAll();
    }
}
