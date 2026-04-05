package com.ketan.library.service;

import com.ketan.library.entity.Book;
import com.ketan.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book savebBook(Book book){
        return bookRepository.save(book);
    }
}
