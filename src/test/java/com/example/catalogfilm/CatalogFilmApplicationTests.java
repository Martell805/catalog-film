package com.example.catalogfilm;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor
class CatalogFilmApplicationTests {
    @LocalServerPort
    private Integer port;

    @Test
    void accessApplication() {
        System.out.println(port);
    }
}
