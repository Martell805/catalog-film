package com.example.catalogfilm.controller;

import com.example.catalogfilm.model.Director;
import com.example.catalogfilm.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/director")
public class DirectorController {
    private final DirectorService directorService;

    @PostMapping
    public ResponseEntity<Director> addDirector(@RequestBody Director director) {
        return ResponseEntity.ok(directorService.saveDirector(director));
    }

    @GetMapping
    public ResponseEntity<Director> getDirector(@RequestParam("directorUuid") UUID directorUuid) {
        return ResponseEntity.ok(directorService.getDirector(directorUuid));
    }
}
