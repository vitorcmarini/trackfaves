package com.vcmarini.trackfaves.model.manga;

import com.vcmarini.trackfaves.model.GenreJikan;
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
    private GenreJikan genre;
    private String status;
    private double score;


    public Manga(MangaRequestDTO data) {
        this.title = data.title();
        this.author = data.author();
        this.description = data.description();
        this.image = data.image();
        this.year = data.year();
        this.chapters = data.chapters();
        this.genre = GenreJikan.fromJikanGenre(data.genre());
        this.status = data.status();
        this.score = data.score();
    }

    @Override
    public String toString() {
        return "Manga{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", year=" + year +
                ", chapters=" + chapters +
                ", genre='" + genre + '\'' +
                ", status='" + status + '\'' +
                ", score=" + score +
                '}';
    }
}
