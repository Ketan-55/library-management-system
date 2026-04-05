package com.ketan.library.service;

import com.ketan.library.entity.Book;
import com.ketan.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book savebBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public String deleteBook(int id) {
        bookRepository.deleteById(id);
        return "Book deleted successfully";
    }

    public Book updateBook(int id, Book book) {
        Book existingBook = bookRepository.findById(id).orElse(null);

        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());

            return bookRepository.save(existingBook);
        }

        return null;
    }


    public Book updateBookPartial(int id, Book book) {
        Book existingBook = bookRepository.findById(id).orElse(null);

        if (existingBook != null) {

            if (book.getTitle() != null) {
                existingBook.setTitle(book.getTitle());
            }

            if (book.getAuthor() != null) {
                existingBook.setAuthor(book.getAuthor());
            }

            if (book.getPrice() != 0) {
                existingBook.setPrice(book.getPrice());
            }

            return bookRepository.save(existingBook);
        }

        return null;
    }
}
