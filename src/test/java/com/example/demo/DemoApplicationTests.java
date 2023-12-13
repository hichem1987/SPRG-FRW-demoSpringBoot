package com.example.demo;

import com.example.demo.dao.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	PersonneRepository personneRepository;

	@Autowired
	AdresseRepository adresseRepository;

	@Autowired
	FormationRepository formationRepository;

	@Test
	void testPersonneRepository() {
		Personne personne = new Personne("JC", "Dominguez");
		//personne.setAdresse("rue de la paix, Paris");
		personneRepository.save(personne);
	}

	@Test
	void testReadPersonneRepository() {
		List<Personne> personnes = personneRepository.findAll();
		for(Personne p : personnes){
			System.out.println(p.toString());
		}
	}

	@Test
	void testGetOnePersonne(){
		Optional<Personne> optional = personneRepository.findById(22);

		if(optional.isPresent()){
			Personne personne = optional.get();
			System.out.println(personne.getNom());
		}else {
			System.out.println("ID inexistant");
		}
	}

	@Test
	void testFindByNom(){
		List<Personne> personnes = personneRepository.findAllByNom("Dominguez");
		for(Personne p : personnes){
			System.out.println(p.toString());
		}
	}

	/*@Test
	void testFindByNomAndAdresse(){
		List<Personne> personnes = personneRepository
				.findAllByNomAndAdresse("Dominguez","rue de la paix, Paris" );
		for(Personne p : personnes){
			System.out.println(p.toString());
		}
	}*/

	@Test
	void testQuery(){
		List<Personne> personnes = personneRepository
				.retourneMoiLesPersonnesAPartirDuNom("Dominguez");
		for(Personne p : personnes){
			System.out.println(p.toString());
		}
	}

	@Test
	void testNativeSql(){
		List<Personne> personnes = personneRepository
				.executeDuSQL();
		for(Personne p : personnes){
			System.out.println(p.toString());
		}
	}

 	@Test
	void testAdresse(){
		Adresse adresse = new Adresse(2, "rue de la paix", "Paris");
		adresseRepository.save(adresse);

		Personne personne = new Personne("JC", "Dominguez");
		personne.setAdresse(adresse);
		personneRepository.save(personne);
	}

	@Test
	void testFormation(){
		Personne personne1 = new Personne("JC", "Dominguez");
		personneRepository.save(personne1);

		Personne personne2 = new Personne("Alain", "Delon");
		personneRepository.save(personne2);

		Personne personne3 = new Personne("Marie", "Dupont");
		personneRepository.save(personne3);

		Formation formation1 = new Formation("Java débutant");
		formation1.addStagiaire(personne1);
		formation1.addStagiaire(personne2);
		formationRepository.save(formation1);

		Formation formation2 = new Formation("SQL avancé");
		formation2.addStagiaire(personne2);
		formation2.addStagiaire(personne3);
		formationRepository.save(formation2);
	}
}
