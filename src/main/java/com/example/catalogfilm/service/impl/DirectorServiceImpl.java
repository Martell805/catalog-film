package com.example.catalogfilm.service.impl;

import com.example.catalogfilm.model.Director;
import com.example.catalogfilm.repository.DirectorRepository;
import com.example.catalogfilm.service.DirectorService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {
    private final DirectorRepository directorRepository;

    @SneakyThrows(NotFoundException.class)
    @Override
    public Director getDirector(Integer directorId) {
        return directorRepository.findById(directorId).orElseThrow(NotFoundException::new);
    }

    @Override
    public Director saveDirector(Director director) {
        return directorRepository.save(director);
    }
}
