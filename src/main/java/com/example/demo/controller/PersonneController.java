package com.example.demo.controller;

import com.example.demo.dao.Personne;
import com.example.demo.metier.PersonneService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonneController {

    @Autowired
    PersonneService personneService;

    /*
        GET     /personnes
            -> Service qui permet de LIRE l'ensemble des personnes

        POST    /personnes
            -> Service qui permet de CREER une nouvelle personne

        GET     /personnes/{id}
            -> Service qui permet de LIRE 1 personne

        PUT     /personnes/{id}
            -> Service UPDATE d'une ressource

        DELETE  /personnes/{id}
            -> Service pour DELETE une ressource
     */

    @GetMapping("personnes")
    public List<Personne> getPersonnes(){
        return personneService.getPersonnes();
    }

    @PostMapping("personnes")
    public ResponseEntity addPersonne(@RequestBody Personne personne){
        if(personne.getNom() == null || personne.getNom().isBlank())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le nom ne peut etre vide");
        else {
            personneService.addPersonne(personne);
            return ResponseEntity.status(201).build();
        }
    }

    @GetMapping("personnes/{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id ){
        Optional<Personne> optional = personneService.findById(id);
        if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(optional.get());
    }

    // Exemple de Query Param:
    // personnes?page=2
    // @RequestParam("page")

}
