package com.vcmarini.trackfaves.manga;

import java.util.UUID;

public record MangaResponseDTO(
        UUID id,
        String title,
        String author,
        String description,
        String image,
        Integer year,
        Integer chapters,
        String genre,
        String status,
        double score
) {
    public MangaResponseDTO(Manga manga){
        this(manga.getId(), manga.getTitle(), manga.getAuthor(), manga.getDescription(), manga.getImage(), manga.getYear(), manga.getChapters(), manga.getGenre(), manga.getStatus(), manga.getScore());
    }
}
