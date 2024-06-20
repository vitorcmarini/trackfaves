package com.vcmarini.trackfaves.service;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.vcmarini.trackfaves.model.GenreJikan;
import com.vcmarini.trackfaves.model.manga.Manga;
import com.vcmarini.trackfaves.model.manga.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    public void loadMangaDataFromCSV(String filePath) throws IOException, CsvValidationException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                    .build();

            String[] line;
            boolean isFirstLine = true;

            while ((line = csvReader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                Manga manga = new Manga();
                manga.setAuthor(line[0]);
                manga.setTitle(line[1]);
                manga.setDescription(line[2]);
                manga.setImage(line[3]);
                manga.setYear(parseInteger(line[4], 1900));
                manga.setChapters(parseInteger(line[5], 0));
                manga.setGenre(GenreJikan.fromJikanGenre(line[6]));
                manga.setStatus(line[7]);
                manga.setScore(parseDouble(line[8], 0.0));
                manga.setLink(line[9]);

                mangaRepository.save(manga);
            }
        }
    }

    private Integer parseInteger(String value, int defaultValue) {
        try {
            return (value != null && !value.isEmpty() && !value.equalsIgnoreCase("null")) ? Integer.valueOf(value) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private Double parseDouble(String value, double defaultValue) {
        try {
            return (value != null && !value.isEmpty() && !value.equalsIgnoreCase("null")) ? Double.valueOf(value) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public boolean isMangaTableEmpty() {
        return mangaRepository.count() == 0;
    }
}
