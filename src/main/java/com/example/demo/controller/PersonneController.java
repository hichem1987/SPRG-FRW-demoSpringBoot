package com.example.demo.controller;

import com.example.demo.dao.Personne;
import com.example.demo.metier.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
