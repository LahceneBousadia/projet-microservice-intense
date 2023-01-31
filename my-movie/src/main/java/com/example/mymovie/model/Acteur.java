package com.example.mymovie.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ApiModel(description="Details about the actor")
public class Acteur {

    @ApiModelProperty(notes="Le nom de l'acteur")
    private String nom;
    @ApiModelProperty(notes="Le prénom de l'acteur")
    private String prenom;
    @ApiModelProperty(notes="La date de naissance de l'acteur")
    private String dateNaissance;
    @ApiModelProperty(notes="La filmography de l'acteur")
    private List<Film> filmography;

    public Acteur(
            String nom,
            String prenom,
            String dateNaissance,
            List<Film> filmography
    ) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.filmography = filmography;
    }

    // Getters and Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Film> getFilmography() {
        return filmography;
    }

    public void setFilmography(List<Film> filmography) {
        this.filmography = filmography;
    }
}
