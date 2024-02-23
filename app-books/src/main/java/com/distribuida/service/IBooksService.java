package com.distribuida.service;

import com.distribuida.model.Books;

import java.util.List;
import java.util.Optional;

public interface IBooksService {
    List<Books> findAllBooks();
    Books saveBook(Books Book);
    Optional<Books> findBookById(Integer id);
    Books updateBook(Books Book);
    void deleteBook(Integer id);
}
