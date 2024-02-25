package com.distribuida.service;

import com.distribuida.client.AuthorsClient;
import com.distribuida.dto.AuthorsDto;
import com.distribuida.dto.BooksDto;
import com.distribuida.model.Books;
import com.distribuida.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BooksServiceImp implements IBooksService {
    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorsClient authorsClient;

    @Override
    public List<BooksDto> findAllBooks() {
        return booksRepository.findAll().stream().map(book -> {
            AuthorsDto author = authorsClient.findAuthorById(book.getAuthorId());
            BooksDto bookDto = BooksDto.from(book);
            String authorName = String.format("%s %s", author.lastName(), author.firstName());
            bookDto.setAuthorName(authorName);
            return bookDto;
        }).collect(Collectors.toList());
    }

    @Override
    public Books saveBook(Books Book) {
        return booksRepository.save(Book);
    }

    public Optional<Books> findBookById(Integer id) {
        return booksRepository.findById(id);
    }

    @Override
    public Books updateBook(Books Book) {
        Books result = booksRepository.findById(Book.getId()).get();
        return booksRepository.save(result);
    }

    @Override
    public void deleteBook(Integer id) {
        Books result = booksRepository.findById(id).get();
        booksRepository.delete(result);
    }
}
