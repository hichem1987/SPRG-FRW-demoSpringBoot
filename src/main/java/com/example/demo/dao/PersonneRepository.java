package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {

    // SELECT * FROM personnes WHERE nom = ?
    List<Personne> findAllByNom(String nom);

    // SELECT * FROM personnes WHERE nom = ? AND adresse_postale
    //List<Personne> findAllByNomAndAdresse(String nom, String adresse);

    // JPQL
    @Query("SELECT p FROM Personne p WHERE p.nom = ?1 ")
    List<Personne> retourneMoiLesPersonnesAPartirDuNom(String nom);

    // SQL natif
    @Query(value = "select * from personnes where adresse_postale = 'rue de la paix, Paris'"
            , nativeQuery = true)
    List<Personne> executeDuSQL();
}
