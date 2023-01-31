package com.example.mymovie.controller;

import com.example.mymovie.model.Acteur;
import com.example.mymovie.service.ActeurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Api(value = "Acteurs Management System")
public class ActeurController {

    private final ActeurService acteurService;

    @Autowired
    public ActeurController(ActeurService acteurService) {
        this.acteurService = acteurService;
    }

    @GetMapping("/acteurs")
    @ApiOperation(value = "Get all acteurs")
    public ResponseEntity<List<Acteur>> getActeurs() {
        return ResponseEntity.ok(acteurService.getActeurs());
    }

    @GetMapping("/nom/{nom}")
    @ApiOperation(value = "Get acteur by nom")
    public ResponseEntity<List<Acteur>> getActeurByNom(@PathVariable String nom) {
        return ResponseEntity.ok(acteurService.getActeursByNom(nom));
    }

    @GetMapping("/film/{titre}")
    @ApiOperation(value = "Get acteur by film")
    public ResponseEntity<List<Acteur>> getActeursByFilm(@PathVariable String titre) {
        return ResponseEntity.ok(acteurService.getActeursByFilm(titre));
    }
}