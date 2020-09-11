package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRemunerationRepository;

@Service
public class ProfilRemunerationService {

//	FILEDS
	ProfilRemunerationRepository profilRemunerationRepository;

//	CONSTRUCTOR
	public ProfilRemunerationService(ProfilRemunerationRepository profilRemunerationRepository) {
		this.profilRemunerationRepository = profilRemunerationRepository;
	}

//	METHODS
	public Optional<ProfilRemuneration> findById(Integer id) {
		return profilRemunerationRepository.findById(id);
	}

}
