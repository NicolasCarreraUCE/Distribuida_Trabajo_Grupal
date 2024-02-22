package com.distribuida.controller;

import com.distribuida.model.Authors;
import com.distribuida.service.IAuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorsController {
    @Autowired
    private IAuthorsService authorsService;

    @GetMapping
    public ResponseEntity<List<Authors>> findAllAuthors() {
        return ResponseEntity.ok(authorsService.findAllAuthors());
    }

    @PostMapping
    public ResponseEntity<Authors> saveAuthor(Authors author) {
        return ResponseEntity.ok(authorsService.saveAuthor(author));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Authors> findAuthorById (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(authorsService.findAuthorById(id).get());
    }

    @PutMapping
    public ResponseEntity<Authors> updateAuthor(@PathVariable("id") Integer id, @RequestBody Authors author){
        Authors result = authorsService.findAuthorById(id).get();
        result.setFirstName(author.getFirstName());
        result.setLastName(author.getLastName());
        return ResponseEntity.ok(authorsService.updateAuthor(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable("id") Integer id){
        authorsService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }
}
