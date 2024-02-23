package com.distribuida.service;

import com.distribuida.model.Books;
import com.distribuida.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImp implements IBooksService {
    @Autowired
    private BooksRepository BooksRepository;

    @Override
    public List<Books> findAllBooks() {
        return BooksRepository.findAll();
    }

    @Override
    public Books saveBook(Books Book) {
        return BooksRepository.save(Book);
    }

    public Optional<Books> findBookById(Integer id) {
        return BooksRepository.findById(id);
    }

    @Override
    public Books updateBook(Books Book) {
        Books result = BooksRepository.findById(Book.getId()).get();
        return BooksRepository.save(result);
    }

    @Override
    public void deleteBook(Integer id) {
        Books result = BooksRepository.findById(id).get();
        BooksRepository.delete(result);
    }
}
