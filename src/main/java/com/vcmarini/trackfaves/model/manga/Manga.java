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
    private String link;


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
        this.link = data.link();
    }

    public void mangaDataUpdate(MangaRequestDTO data) {
        if (data.title() != null){
            this.title = data.title();
        }
        if (data.author() != null){
            this.author = data.author();
        }
        if (data.description() != null){
            this.description = data.description();
        }
        if (data.image() != null){
            this.image = data.image();
        }
        if (data.year() != null){
            this.year = data.year();
        }
        if (data.chapters() != null){
            this.chapters = data.chapters();
        }
        if (data.genre() != null){
            this.genre = GenreJikan.fromJikanGenre(data.genre());
        }
        if (data.status() != null){
            this.status = data.status();
        }
        this.score = data.score();
        if (data.link() != null){
            this.link = data.link();
        }
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
                ", genre=" + genre +
                ", status='" + status + '\'' +
                ", score=" + score +
                ", link='" + link + '\'' +
                '}';
    }
}
