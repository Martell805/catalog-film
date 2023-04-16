package com.example.catalogfilm.repository;

import com.example.catalogfilm.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}
