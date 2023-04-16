package com.example.catalogfilm.controller;

import com.example.catalogfilm.cosntant.GenreEnum;
import com.example.catalogfilm.model.Film;
import com.example.catalogfilm.service.FilmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FilmControllerTest {
    @InjectMocks
    private FilmController filmController;

    @Mock
    private FilmService filmService;

    private UUID uuid1;
    private Film film1;

    @BeforeEach
    public void setOut() {
        uuid1 = UUID.randomUUID();
        film1 = new Film(uuid1, "Film1", GenreEnum.HORROR, 5);
    }

    @Test
    public void getExistingFilmTest() {
        when(filmService.getFilm(uuid1)).thenReturn(film1);

        Film actual = filmController.getFilm(uuid1).getBody();
        Film expected = film1;

        assertThat(actual).isNotNull();
        assertThat(actual.toString()).isEqualTo(expected.toString());

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
        assertThat(actual.getGenre()).isEqualTo(expected.getGenre());
        assertThat(actual.getRating()).isEqualTo(expected.getRating());
    }

    @Test
    public void getNonExistingFilmTest() {
        when(filmService.getFilm(uuid1)).thenReturn(null);

        Film actual = filmController.getFilm(uuid1).getBody();

        assertThat(actual).isNull();
    }

    @Test
    public void addFilmTest() {
        when(filmService.saveFilm(film1)).thenReturn(film1);

        Film actual = filmController.addFilm(film1).getBody();
        Film expected = film1;

        assertThat(actual).isNotNull();
        assertThat(actual.toString()).isEqualTo(expected.toString());

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
        assertThat(actual.getGenre()).isEqualTo(expected.getGenre());
        assertThat(actual.getRating()).isEqualTo(expected.getRating());
    }
}