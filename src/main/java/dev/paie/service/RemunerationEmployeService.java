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
import dev.paie.web.remunerationEmploye.RemunerationEmployeRequestDto;

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
	public RemunerationEmploye newRemunerationEmploye(RemunerationEmployeRequestDto remunerationEmployeDto) {

		List<String> messagesErrors = new ArrayList<>();

		Optional<Entreprise> optEntreprise = entrepriseService.findById(remunerationEmployeDto.getEntrepriseId());

		if (!optEntreprise.isPresent()) {
			messagesErrors.add("L'entreprise d'id => '" + remunerationEmployeDto.getEntrepriseId()
					+ "' est introuvable ou inexistante ..");
		}

		Optional<ProfilRemuneration> optProfilRemuneration = profilRemunerationService
				.findById(remunerationEmployeDto.getProfilRenumerationId());

		if (!optProfilRemuneration.isPresent()) {
			messagesErrors.add("Le profil de rémunétation d'id => '" + remunerationEmployeDto.getProfilRenumerationId()
					+ "' est introuvable ou inexistant ..");
		}

		Optional<Grade> optGrade = gradeService.findById(remunerationEmployeDto.getGradeId());

		if (!optGrade.isPresent()) {
			messagesErrors.add(
					"Le grade d'id => '" + remunerationEmployeDto.getGradeId() + "' est introuvable ou inexistant ..");
		}

		if (!messagesErrors.isEmpty()) {
			throw new RemunerationEmployeException(messagesErrors);
		}

		RemunerationEmploye newRemunerationEmploye = new RemunerationEmploye();
		newRemunerationEmploye.setMatricule(remunerationEmployeDto.getMatricule());
		newRemunerationEmploye.setEntreprise(optEntreprise.get());
		newRemunerationEmploye.setProfilRemuneration(optProfilRemuneration.get());
		newRemunerationEmploye.setGrade(optGrade.get());

		return remunerationEmployeRepository.save(newRemunerationEmploye);

	}

	public List<RemunerationEmploye> findAll() {
		return remunerationEmployeRepository.findAll();
	}

}
