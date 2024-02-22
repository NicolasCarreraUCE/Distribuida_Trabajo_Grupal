package com.distribuida.repository;

import com.distribuida.model.Authors;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AuthorsRepository extends JpaRepository<Authors, Integer> {
}
