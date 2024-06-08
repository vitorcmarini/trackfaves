package com.vcmarini.trackfaves.manga;

public record MangaRequestDTO(
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
}
