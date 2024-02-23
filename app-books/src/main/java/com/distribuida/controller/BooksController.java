package com.distribuida.controller;

import com.distribuida.model.Books;
import com.distribuida.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BooksController {
    @Autowired
    private IBooksService BooksService;

    @GetMapping
    public ResponseEntity<List<Books>> findAllBooks() {
        return ResponseEntity.ok(BooksService.findAllBooks());
    }

    @PostMapping
    public ResponseEntity<Books> saveBook(Books Book) {
        return ResponseEntity.ok(BooksService.saveBook(Book));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> findBookById (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(BooksService.findBookById(id).get());
    }

    @PutMapping
    public ResponseEntity<Books> updateBook(@PathVariable("id") Integer id, @RequestBody Books book){
        Books result = BooksService.findBookById(id).get();
        result.setAuthorId(book.getAuthorId());
        result.setIsbn(book.getIsbn());
        result.setPrice(book.getPrice());
        result.setTitle(book.getTitle());
        return ResponseEntity.ok(BooksService.updateBook(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") Integer id){
        BooksService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
