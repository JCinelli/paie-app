package dev.paie.web.remunerationEmploye;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.exception.RemunerationEmployeException;
import dev.paie.service.RemunerationEmployeService;

@RestController
@RequestMapping("employes")
public class RemunerationEmployeController {

//	FIELDS
	RemunerationEmployeService remunerationEmployeService;

//	CONSTRUCTORS
	public RemunerationEmployeController(RemunerationEmployeService remunerationEmployeService) {
		this.remunerationEmployeService = remunerationEmployeService;
	}

//	METHODS
	@PostMapping
	public ResponseEntity<?> creeRremunerationEmploye(@RequestBody @Valid CreerRemunerationEmployeRequestDto employe,
			BindingResult resultatValidation) {

		if (!resultatValidation.hasErrors()) {

			RemunerationEmploye newRemunerationEmploye = remunerationEmployeService.newRemunerationEmploye(
					employe.getMatricule(), employe.getEntrepriseId(), employe.getProfilRenumerationId(),
					employe.getGradeId());

			return ResponseEntity.ok(newRemunerationEmploye);

		} else {

			return ResponseEntity.badRequest().body(" Tous les champs sont obligatoires !");

		}

	}

	@ExceptionHandler(RemunerationEmployeException.class)
	public ResponseEntity<List<String>> onRemunerationEmployeException(RemunerationEmployeException ex) {

		return ResponseEntity.badRequest().body(ex.getMessagesErreurs());

	}

}
