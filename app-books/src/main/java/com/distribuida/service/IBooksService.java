package com.distribuida.service;

import com.distribuida.dto.BooksDto;
import com.distribuida.model.Books;

import java.util.List;
import java.util.Optional;

public interface IBooksService {
    List<BooksDto> findAllBooks();
    Books saveBook(Books Book);
    Optional<Books> findBookById(Integer id);
    Books updateBook(Books Book);
    void deleteBook(Integer id);
}
