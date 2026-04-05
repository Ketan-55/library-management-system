package com.ketan.library.controller;
import com.ketan.library.entity.Book;
import com.ketan.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

        @GetMapping("/hello")
        public String hello() {
            return "Library App Running Successfully 🚀";
        }
        @PostMapping("/book")
        public Book saveBook(@RequestBody Book book){
            return bookService.savebBook(book);
        }
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
