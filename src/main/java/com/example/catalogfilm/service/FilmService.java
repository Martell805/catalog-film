package com.example.catalogfilm.service;

import com.example.catalogfilm.model.Film;
import java.util.List;

public interface FilmService {
    Film getFilm(Integer filmId);
    List<Film> getAllFilms();
    Film saveFilm(Film film);
}
