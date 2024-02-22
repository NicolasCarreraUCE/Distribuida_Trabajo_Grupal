package com.distribuida.service;

import com.distribuida.model.Authors;
import com.distribuida.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsServiceImp implements IAuthorsService {
    @Autowired
    private AuthorsRepository authorsRepository;

    @Override
    public List<Authors> findAllAuthors() {
        return authorsRepository.findAll();
    }

    @Override
    public Authors saveAuthor(Authors author) {
        return authorsRepository.save(author);
    }

    public Optional<Authors> findAuthorById(Integer id) {
        return authorsRepository.findById(id);
    }

    @Override
    public Authors updateAuthor(Authors author) {
        Authors result = authorsRepository.findById(author.getId()).get();
        return authorsRepository.save(result);
    }

    @Override
    public void deleteAuthor(Integer id) {
        Authors result = authorsRepository.findById(id).get();
        authorsRepository.delete(result);
    }
}
