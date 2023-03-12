package com.example.catalogfilm.controller;

import com.example.catalogfilm.model.Film;
import com.example.catalogfilm.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

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
    public ResponseEntity<Film> getFilm(@RequestParam("filmUuid") UUID filmUuid) {
        return ResponseEntity.ok(filmService.getFilm(filmUuid));
    }
}
