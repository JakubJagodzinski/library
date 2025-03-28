package com.example.library.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final GenreService genreService;

    @Autowired
    public GenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    public List<Genre> findAll() {
        return genreService.findAll();
    }

    public Optional<Genre> findById(Long id) {
        return genreService.findById(id);
    }

    public Genre save(Genre genre) {
        return genreService.save(genre);
    }

    public void deleteById(Long id) {
        genreService.deleteById(id);
    }

}
