package com.example.catalogfilm.service.impl;

import com.example.catalogfilm.model.Film;
import com.example.catalogfilm.repository.FilmRepository;
import com.example.catalogfilm.service.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;

    @SneakyThrows(NotFoundException.class)
    @Override
    public Film getFilm(Integer filmId) {
        return filmRepository.findById(filmId).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }
}
