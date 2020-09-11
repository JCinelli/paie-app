package dev.paie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.exception.RemunerationEmployeException;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
public class RemunerationEmployeService {

//	FIELDS
	RemunerationEmployeRepository remunerationEmployeRepository;
	EntrepriseService entrepriseService;
	ProfilRemunerationService profilRemunerationService;
	GradeService gradeService;

//	CONSTRUCTOR
	public RemunerationEmployeService(RemunerationEmployeRepository remunerationEmployeRepository,
			EntrepriseService entrepriseService, ProfilRemunerationService profilRemunerationService,
			GradeService gradeService) {
		this.remunerationEmployeRepository = remunerationEmployeRepository;
		this.entrepriseService = entrepriseService;
		this.profilRemunerationService = profilRemunerationService;
		this.gradeService = gradeService;
	}

//	METHODS
	public Optional<RemunerationEmploye> findById(Integer id) {
		return remunerationEmployeRepository.findById(id);
	}

	@Transactional
	public RemunerationEmploye newRemunerationEmploye(String matricule, Integer entrepriseId,
			Integer profilRenumerationId, Integer gradeId) {

		List<String> messagesErrors = new ArrayList<>();

		Optional<Entreprise> optEntreprise = entrepriseService.findById(entrepriseId);

		if (!optEntreprise.isPresent()) {
			messagesErrors.add("L'entreprise d'id => '" + entrepriseId + "' est introuvable ou inexistante ..");
		}

		Optional<ProfilRemuneration> optProfilRemuneration = profilRemunerationService.findById(profilRenumerationId);

		if (!optProfilRemuneration.isPresent()) {
			messagesErrors.add("Le profil de rémunétation d'id => '" + profilRenumerationId
					+ "' est introuvable ou inexistant ..");
		}

		Optional<Grade> optGrade = gradeService.findById(gradeId);

		if (!optGrade.isPresent()) {
			messagesErrors.add("Le grade d'id => '" + gradeId + "' est introuvable ou inexistant ..");
		}

		if (!messagesErrors.isEmpty()) {
			throw new RemunerationEmployeException(messagesErrors);
		}

		RemunerationEmploye newRemunerationEmploye = new RemunerationEmploye();
		newRemunerationEmploye.setMatricule(matricule);
		newRemunerationEmploye.setEntreprise(optEntreprise.get());
		newRemunerationEmploye.setProfilRemuneration(optProfilRemuneration.get());
		newRemunerationEmploye.setGrade(optGrade.get());

		return remunerationEmployeRepository.save(newRemunerationEmploye);

	}

}
