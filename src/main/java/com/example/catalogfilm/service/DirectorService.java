package com.example.catalogfilm.service;

import com.example.catalogfilm.model.Director;

public interface DirectorService {
    Director getDirector(Integer directorId);
    Director saveDirector (Director director);
}
