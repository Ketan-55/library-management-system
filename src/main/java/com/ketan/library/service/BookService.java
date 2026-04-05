package com.ketan.library.service;

import com.ketan.library.entity.Book;
import com.ketan.library.exception.BookNotFoundException;
import com.ketan.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
    }
    public String deleteBook(int id) {
      Optional<Book>optionalBook = bookRepository.findById(id);
      if(optionalBook.isPresent()){
          bookRepository.deleteById(id);
      }else{
          throw new BookNotFoundException("Book not found with id: "+id);
      }
        return "Book deleted successfully";
    }

    public Book updateBook(int id, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();

            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());

            return bookRepository.save(existingBook);
        } else {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
    }

    public Book updateBookPartial(int id, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();

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
        } else {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
    }
}
