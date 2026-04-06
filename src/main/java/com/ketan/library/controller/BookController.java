package com.ketan.library.controller;

import com.ketan.library.dto.BookDTO;
import com.ketan.library.entity.Book;
import com.ketan.library.service.BookService;
import com.ketan.library.util.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    public static final Logger logger = LoggerFactory.getLogger(BookController.class);


    @Autowired
    BookService bookService;



    @GetMapping("/hello")
    public ApiResponse<String> hello() {
        logger.info("Inside controller");
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus("SUCCESS");
        response.setMessage("Hello");
        response.setData("Library App Running Successfully 🚀");
        return response;
    }

    @PostMapping("/book")
    public ApiResponse<BookDTO> saveBook(@Valid @RequestBody BookDTO bookDTO) {
        logger.info("Inside controller");
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        
        Book savedBook = bookService.savebBook(book);
        
        ApiResponse<BookDTO> response = new ApiResponse<>();
        response.setStatus("SUCCESS");
        response.setMessage("Book saved successfully");
        response.setData(bookService.convertToDTO(savedBook));
        return response;
    }

    @GetMapping("/getAllBooks")
    public ApiResponse<List<BookDTO>> getAllBooks() {
        logger.info("Inside controller");
        List<Book> books = bookService.getAllBooks();
        List<BookDTO> dtoList = new ArrayList<>();

        for (Book book : books) {
            dtoList.add(bookService.convertToDTO(book));
        }

        ApiResponse<List<BookDTO>> response = new ApiResponse<>();
        response.setStatus("SUCCESS");
        response.setMessage("Books fetched successfully");
        response.setData(dtoList);
        return response;
    }

    @GetMapping
    public ApiResponse<List<BookDTO>> getAllBookslist() {
        logger.info("Inside controller");

        List<Book> books = bookService.getAllBooks();
        List<BookDTO> dtoList = new ArrayList<>();

        for (Book book : books) {
            dtoList.add(bookService.convertToDTO(book));
        }

        ApiResponse<List<BookDTO>> response = new ApiResponse<>();
        response.setStatus("SUCCESS");
        response.setMessage("Books fetched successfully");
        response.setData(dtoList);

        return response;
    }

    @GetMapping("/{id}")
    public ApiResponse<BookDTO> getBookById(@PathVariable int id) {
        logger.info("Inside controller");
        Book book = bookService.getBookById(id);
        
        ApiResponse<BookDTO> response = new ApiResponse<>();
        response.setStatus("SUCCESS");
        response.setMessage("Book fetched successfully");
        response.setData(bookService.convertToDTO(book));
        return response;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteBook(@PathVariable int id) {
        logger.info("Inside controller");
        String message = bookService.deleteBook(id);
        
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus("SUCCESS");
        response.setMessage(message);
        response.setData(null);
        return response;
    }

    @PutMapping("/{id}")
    public ApiResponse<BookDTO> updateBook(@PathVariable int id, @Valid @RequestBody BookDTO bookDTO) {
        logger.info("Inside controller");
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        
        Book updatedBook = bookService.updateBook(id, book);
        
        ApiResponse<BookDTO> response = new ApiResponse<>();
        response.setStatus("SUCCESS");
        response.setMessage("Book updated successfully");
        response.setData(bookService.convertToDTO(updatedBook));
        return response;
    }

    @PatchMapping("/{id}")
    public ApiResponse<BookDTO> updateBookPartial(@PathVariable int id, @RequestBody BookDTO bookDTO) {
        logger.info("Inside controller");
        Book book = new Book();
        if (bookDTO.getTitle() != null && !bookDTO.getTitle().isEmpty()) {
            book.setTitle(bookDTO.getTitle());
        }
        if (bookDTO.getAuthor() != null && !bookDTO.getAuthor().isEmpty()) {
            book.setAuthor(bookDTO.getAuthor());
        }
        if (bookDTO.getPrice() > 0) {
            book.setPrice(bookDTO.getPrice());
        }
        
        Book updatedBook = bookService.updateBookPartial(id, book);
        
        ApiResponse<BookDTO> response = new ApiResponse<>();
        response.setStatus("SUCCESS");
        response.setMessage("Book updated partially successfully");
        response.setData(bookService.convertToDTO(updatedBook));
        return response;
    }
}
