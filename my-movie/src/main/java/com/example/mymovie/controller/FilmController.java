package com.example.mymovie.controller;

import com.example.mymovie.model.Film;
import com.example.mymovie.service.FilmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Films Management System")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    @ApiOperation(value = "Get all films")
    public ResponseEntity<List<Film>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    @GetMapping("/titre/{titre}")
    @ApiOperation(value = "Get film by titre")
    public ResponseEntity<Film> getFilmByTitre(@PathVariable String titre) {
        return ResponseEntity.ok((Film) filmService.getFilmsByTitre(titre));
    }

    @GetMapping("/annee/{annee}")
    @ApiOperation(value = "Get film by annee")
    public ResponseEntity<List<Film>> getFilmsByAnnee(@PathVariable int annee) {
        return ResponseEntity.ok(filmService.getFilmsByReleaseYear(annee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
    /**
    @ApiOperation(value = "Delete a film by ID")
    @DeleteMapping("/{id}")
    public void deleteMovie(@ApiParam(value = "Film ID", required = true) @PathVariable long id) {
        filmService.deleteFilm(id);
    }


    @ApiOperation(value = "Update a film by titre")
    @PutMapping("/{titre}")
    public Film updateFilm(@ApiParam(value = "Film titre", required = true) @PathVariable String titre,
                             @ApiParam(value = "Film object", required = true) @RequestBody Film film) {
        return filmService.updateFilm(titre, film);
    }**/

}
