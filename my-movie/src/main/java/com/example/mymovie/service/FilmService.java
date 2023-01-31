package com.example.mymovie.service;

import com.example.mymovie.model.Acteur;
import com.example.mymovie.model.Film;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private final List<Film> films;

    public FilmService() {
        this.films = new ArrayList<>();
        // Initialize some sample data for demonstration purposes
        Acteur actor1 = new Acteur("Tom", "Cruise", "03-07-1962", Collections.emptyList());
        Acteur actor2 = new Acteur("Robert", "Downey Jr.", "13-12-1950", Collections.emptyList());
        this.films.add(new Film("Matrix", "Tony Scott", actor1, new Date(1986, 5, 16)));
        this.films.add(new Film("IronMan", "Jon Favreau", actor2, new Date(2008, 5, 2)));
    }

    public List<Film> getAllFilms() {
        return Collections.unmodifiableList(films);
    }

    public List<Film> getFilmsByTitre(String titre) {
        return films.stream().filter(film -> film.getTitre().contains(titre)).collect(Collectors.toList());
    }

    public List<Film> getFilmsByReleaseYear(int annee) {
        return films.stream().filter(film -> film.getDateSortie().getYear() == annee).collect(Collectors.toList());
    }

    public void deleteFilm(long id) {
    }

    /** public Film updateFilm(String titre, Film film) {
        Film filmExistant = filmRepository.findByTitre(titre)
                .orElseThrow(() -> new MovieNotFoundException("Movie with title " + titre + " not found"));
        filmExistant.setTitre(film.getTitre());
        filmExistant.setRealisateur(film.getRealisateur());
        filmExistant.setActeurPrincipal(film.getActeurPrincipal());
        filmExistant.setDateSortie(film.getDateSortie());
        return filmRepository.save(filmExistant);
    }**/
}
