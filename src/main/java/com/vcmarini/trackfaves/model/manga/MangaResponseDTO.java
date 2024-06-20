package com.vcmarini.trackfaves.model.manga;

import com.vcmarini.trackfaves.model.GenreJikan;

import java.util.UUID;

public record MangaResponseDTO(
        UUID id,
        String title,
        String author,
        String description,
        String image,
        Integer year,
        Integer chapters,
        GenreJikan genre,
        String status,
        double score,
        String link
) {
    public MangaResponseDTO(Manga manga){
        this(manga.getId(), manga.getTitle(), manga.getAuthor(), manga.getDescription(), manga.getImage(), manga.getYear(), manga.getChapters(), manga.getGenre(), manga.getStatus(), manga.getScore(), manga.getLink());
    }
}
