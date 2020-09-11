package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;

@Service
public class GradeService {

//	FIELDS
	GradeRepository gradeRepository;

//	CONSTRUCTORS
	public GradeService(GradeRepository gradeRepository) {
		this.gradeRepository = gradeRepository;
	}

//	METHODS
	public Optional<Grade> findById(Integer id) {
		return gradeRepository.findById(id);
	}

}
