package com.vcmarini.trackfaves.manga;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MangaRepository extends JpaRepository<Manga, UUID> {
}
