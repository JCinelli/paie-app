package dev.paie.web.grade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.Grade;
import dev.paie.service.GradeService;

@RestController
@RequestMapping("grades")
public class GradeController {

//	FIELDS
	GradeService gradeService;

//	CONSTRUCTORS
	public GradeController(GradeService gradeService) {
		this.gradeService = gradeService;
	}

//	METHODS
	@GetMapping
	public List<GradeResponseDto> findAll() {

		List<GradeResponseDto> listDto = new ArrayList<>();

		List<Grade> listGrade = gradeService.findAll();

		for (Grade grade : listGrade) {

			BigDecimal salaireAnnuel = grade.getNbHeuresBase().multiply(grade.getTauxBase())
					.multiply(new BigDecimal("12"));

			listDto.add(new GradeResponseDto(grade.getCode(), salaireAnnuel));

		}

		return listDto;

	}

}
