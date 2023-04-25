package com.example.catalogfilm.controller;

import com.example.catalogfilm.model.Film;
import com.example.catalogfilm.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/film")
public class FilmController {
    private final FilmService filmService;

    @PostMapping
    public ResponseEntity<Film> addFilm(@RequestBody Film film) {
        return ResponseEntity.ok(filmService.saveFilm(film));
    }

    @GetMapping
    public ResponseEntity<Film> getFilm(@RequestParam Integer filmId) {
        return ResponseEntity.ok(filmService.getFilm(filmId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Film>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    @GetMapping("/hello")
    public String hello(Authentication authentication) {
        return "hello " + ((authentication != null) ? authentication.getName() : "no one");
    }
}
