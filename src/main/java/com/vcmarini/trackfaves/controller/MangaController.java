package com.vcmarini.trackfaves.controller;

import com.vcmarini.trackfaves.model.manga.Manga;
import com.vcmarini.trackfaves.model.manga.MangaRepository;
import com.vcmarini.trackfaves.model.manga.MangaRequestDTO;
import com.vcmarini.trackfaves.model.manga.MangaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manga")
public class MangaController {

    @Autowired
    private MangaRepository mangaRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<MangaResponseDTO> getAll(){

        List<MangaResponseDTO> mangaList = mangaRepository.findAll().stream()
                .map(MangaResponseDTO::new).toList();
        return mangaList;

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveManga(@RequestBody MangaRequestDTO data){
        Manga mangaData = new Manga(data);
        mangaRepository.save(mangaData);
        return;
    }
}
