package com.distribuida.service;

import com.distribuida.model.Authors;

import java.util.List;
import java.util.Optional;

public interface IAuthorsService {
    List<Authors> findAllAuthors();
    Authors saveAuthor(Authors author);
    Optional<Authors> findAuthorById(Integer id);
    Authors updateAuthor(Authors author);
    void deleteAuthor(Integer id);
}
