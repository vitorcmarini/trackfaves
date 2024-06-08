package com.vcmarini.trackfaves.manga;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "mangas")
@Entity(name = "mangas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Manga {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String author;
    private String description;
    private String image;
    private Integer year;
    private Integer chapters;
    private String genre;
    private String status;
    private double score;


    public Manga(MangaRequestDTO data) {
        this.title = data.title();
        this.author = data.author();
        this.description = data.description();
        this.image = data.image();
        this.year = data.year();
        this.chapters = data.chapters();
        this.genre = data.genre();
        this.status = data.status();
        this.score = data.score();
    }
}
