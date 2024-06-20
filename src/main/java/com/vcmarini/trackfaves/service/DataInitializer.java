package com.vcmarini.trackfaves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private MangaService mangaService;

    @Value("${manga.csv.file.path}")
    private String mangaCsvFilePath;

    @Override
    public void run(String... args) throws Exception {
        if (mangaService.isMangaTableEmpty()){
            mangaService.loadMangaDataFromCSV(mangaCsvFilePath);
        }
    }
}
