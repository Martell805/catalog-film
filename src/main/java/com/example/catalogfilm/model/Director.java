package com.example.catalogfilm.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private Integer age;
    private String country;

    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Film> filmList;
}
