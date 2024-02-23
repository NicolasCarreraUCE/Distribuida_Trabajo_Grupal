package com.distribuida.repository;

import com.distribuida.model.Books;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BooksRepository extends JpaRepository<Books, Integer> {
}
