package com.ketan.library.controller;
import com.ketan.library.entity.Book;
import com.ketan.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
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

       @GetMapping("/{id}")
        public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
        }

       @DeleteMapping("/{id}")
        public String deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
        }

      @PutMapping("/{id}")
        public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
       }

       @PatchMapping("/{id}")
        public Book updateBookPartial(@PathVariable int id, @RequestBody Book book) {
        return bookService.updateBookPartial(id, book);
        }
}
