package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Periode;
import dev.paie.repository.PeriodeRepository;

@Service
public class PeriodeService {

//	FIELDS
	PeriodeRepository periodeRepository;

//	CONSTRUCTOR
	public PeriodeService(PeriodeRepository periodeRepository) {
		super();
		this.periodeRepository = periodeRepository;
	}

//	METHODS
	public Optional<Periode> findByid(Integer id) {
		return periodeRepository.findById(id);
	}

}
