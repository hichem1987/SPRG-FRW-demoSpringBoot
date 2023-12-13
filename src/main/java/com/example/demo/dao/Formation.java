package com.example.demo.dao;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="formations")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titre;
    private LocalDateTime horaire;

    @ManyToMany
    private List<Personne> stagiaires = new ArrayList<>();

    public Formation() {
    }

    public Formation(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDateTime getHoraire() {
        return horaire;
    }

    public void setHoraire(LocalDateTime horaire) {
        this.horaire = horaire;
    }

    public List<Personne> getStagiaires() {
        return stagiaires;
    }

    public void setStagiaires(List<Personne> stagiaires) {
        this.stagiaires = stagiaires;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addStagiaire(Personne stagiaire){
        stagiaires.add(stagiaire);
    }

}
