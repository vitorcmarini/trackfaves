package com.vcmarini.trackfaves.controller;

import com.vcmarini.trackfaves.model.GenreJikan;
import com.vcmarini.trackfaves.model.manga.Manga;
import com.vcmarini.trackfaves.model.manga.MangaRepository;
import com.vcmarini.trackfaves.model.manga.MangaRequestDTO;
import com.vcmarini.trackfaves.model.manga.MangaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public ResponseEntity saveManga(@RequestBody MangaRequestDTO data){
        var mangaData = new Manga(data);
        mangaRepository.save(mangaData);
        return ResponseEntity.ok(new MangaResponseDTO(mangaData));
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity updateManga(@RequestBody MangaRequestDTO data, @PathVariable UUID id){
        var mangaData = mangaRepository.findById(id);
        if(mangaData.isPresent()){
            Manga manga = mangaData.get();
            manga.mangaDataUpdate(data);

            mangaRepository.save(manga);

            return ResponseEntity.ok(new MangaResponseDTO(manga));

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Manga not found!");
        }
    }




    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteManga(@PathVariable UUID id) {
        // Verifica se o manga existe
        Optional<Manga> mangaData = mangaRepository.findById(id);
        if (mangaData.isPresent()) {
            mangaRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Manga not found!");
        }
    }


}
