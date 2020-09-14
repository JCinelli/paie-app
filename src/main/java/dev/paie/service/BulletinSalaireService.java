package dev.paie.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.exception.BulletinSalaireException;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.web.bulletinSalaire.BulletinSalaireRequestDto;

@Service
public class BulletinSalaireService {

//	FIELDS
	BulletinSalaireRepository bulletinSalaireRepository;
	RemunerationEmployeService remunerationEmployeService;
	PeriodeService periodeService;

//	CONSTRUCTOR
	public BulletinSalaireService(BulletinSalaireRepository bulletinSalaireRepository,
			RemunerationEmployeService remunerationEmployeService, PeriodeService periodeService) {
		this.bulletinSalaireRepository = bulletinSalaireRepository;
		this.remunerationEmployeService = remunerationEmployeService;
		this.periodeService = periodeService;
	}

//	METHODS
	public List<BulletinSalaire> findAll() {
		return bulletinSalaireRepository.findAll();
	}

	@Transactional
	public BulletinSalaire newBulletinSalaire(BulletinSalaireRequestDto bulletinSalaireDto) {

		List<String> messagesErrors = new ArrayList<>();

		Optional<RemunerationEmploye> optRemunerationEmploye = remunerationEmployeService
				.findById(bulletinSalaireDto.getRemunerationEmployeId());

		if (!optRemunerationEmploye.isPresent()) {
			messagesErrors.add("L'employé d'id => '" + bulletinSalaireDto.getRemunerationEmployeId()
					+ "' est introuvable ou inexistant ..");
		}

		Optional<Periode> optPeriode = periodeService.findByid(bulletinSalaireDto.getPeriodeId());

		if (!optPeriode.isPresent()) {
			messagesErrors.add(
					"La période d'id => '" + bulletinSalaireDto.getPeriodeId() + "' est introuvable ou inexistante ..");
		}

		if (!messagesErrors.isEmpty()) {
			throw new BulletinSalaireException(messagesErrors);
		}

		BulletinSalaire newBulletinSalaire = new BulletinSalaire();
		newBulletinSalaire.setPeriode(optPeriode.get());
		newBulletinSalaire.setPrimeExceptionnelle(bulletinSalaireDto.getPrimeExceptionnelle());
		newBulletinSalaire.setRemunerationEmploye(optRemunerationEmploye.get());
		newBulletinSalaire.setDateHeureCreation(LocalDateTime.now());

		return bulletinSalaireRepository.save(newBulletinSalaire);
	}
}
