package dev.paie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.repository.EntrepriseRepository;

@Service
public class EntrepriseService {

//	FIELDS
	EntrepriseRepository entrepriseRepository;

//	CONSTRUCTOR
	public EntrepriseService(EntrepriseRepository entrepriseRepository) {
		this.entrepriseRepository = entrepriseRepository;
	}

//	METHODS
	public Optional<Entreprise> findById(Integer id) {
		return entrepriseRepository.findById(id);
	}

	public List<Entreprise> findAll() {
		return entrepriseRepository.findAll();
	}

}
