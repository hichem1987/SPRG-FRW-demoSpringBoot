package com.example.demo.metier;

import com.example.demo.dao.Personne;
import com.example.demo.dao.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {

    @Autowired
    PersonneRepository personneRepository;

    public List<Personne> getPersonnes(){
        return personneRepository.findAll();
    }

    public void addPersonne(Personne newPersonne){
        personneRepository.save(newPersonne);
    }
}
