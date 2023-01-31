package com.example.mymovie.service;

import com.example.mymovie.model.Acteur;
import com.example.mymovie.model.Film;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActeurService {

    private final List<Acteur> acteurs;

    public ActeurService() {
        this.acteurs = new ArrayList<>();
        // Initialize some sample data for demonstration purposes
        Film film1 = new Film("Top Gun", "Tony Scott", new Acteur("Tom", "Cruise", "14-12-1950", Collections.emptyList()), new Date(1986, 5, 16));
        Film film2 = new Film("Iron Man", "Jon Favreau", new Acteur("Robert", "Downey Jr.", "12-01-1960", Collections.emptyList()), new Date(2008, 5, 2));
        this.acteurs.add(film1.getActeurPrincipal());
        this.acteurs.add(film2.getActeurPrincipal());
    }

    public List<Acteur> getActeurs() {
        return Collections.unmodifiableList(acteurs);
    }

    public List<Acteur> getActeursByNom(String name) {
        return acteurs.stream().filter(acteur -> acteur.getNom().contains(name) || acteur.getPrenom().contains(name)).collect(Collectors.toList());
    }

    public List<Acteur> getActeursByFilm(String filmTitle) {
        return acteurs.stream().filter(acteur -> acteur.getFilmography().stream().anyMatch(film -> film.getTitre().equals(filmTitle))).collect(Collectors.toList());
    }
}

