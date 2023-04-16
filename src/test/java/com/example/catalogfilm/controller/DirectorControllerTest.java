package com.example.catalogfilm.controller;

import com.example.catalogfilm.cosntant.GenreEnum;
import com.example.catalogfilm.model.Director;
import com.example.catalogfilm.model.Film;
import com.example.catalogfilm.service.DirectorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DirectorControllerTest {
    @InjectMocks
    private DirectorController directorController;

    @Mock
    private DirectorService directorService;

    private Integer id1;
    private Director director1;

    @BeforeEach
    public void setOut() {
        id1 = 1;
        director1 = new Director(id1, "Director1", 30, "Country", List.of(
                new Film(id1, "Film1", GenreEnum.HORROR, 5)
        ));
    }

    @Test
    public void getExistingFilmTest() {
        when(directorService.getDirector(id1)).thenReturn(director1);

        Director actual = directorController.getDirector(id1).getBody();
        Director expected = director1;

        assertThat(actual).isNotNull();
        assertThat(actual.toString()).isEqualTo(expected.toString());

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getAge()).isEqualTo(expected.getAge());
        assertThat(actual.getCountry()).isEqualTo(expected.getCountry());
        assertThat(actual.getFilmList()).isEqualTo(expected.getFilmList());
    }

    @Test
    public void getNonExistingFilmTest() {
        when(directorController.getDirector(id1)).thenReturn(null);

        Director actual = directorController.getDirector(id1).getBody();

        assertThat(actual).isNull();
    }

    @Test
    public void addFilmTest() {
        when(directorService.saveDirector(director1)).thenReturn(director1);

        Director actual = directorController.addDirector(director1).getBody();
        Director expected = director1;

        assertThat(actual).isNotNull();
        assertThat(actual.toString()).isEqualTo(expected.toString());

        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getAge()).isEqualTo(expected.getAge());
        assertThat(actual.getCountry()).isEqualTo(expected.getCountry());
        assertThat(actual.getFilmList()).isEqualTo(expected.getFilmList());
    }
}
