package com.example.catalogfilm.repository;

import com.example.catalogfilm.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
