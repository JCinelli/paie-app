package dev.paie.web.bulletinSalaire;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.BulletinSalaire;
import dev.paie.exception.BulletinSalaireException;
import dev.paie.service.BulletinSalaireService;

@RestController
@RequestMapping("bulletins")
public class BulletinSalaireController {

//	FIELDS
	BulletinSalaireService bulletinSalaireService;

//	CONSTRUCTOR
	public BulletinSalaireController(BulletinSalaireService bulletinSalaireService) {
		this.bulletinSalaireService = bulletinSalaireService;
	}

//	METHODS
	@GetMapping
	public List<BulletinSalaireDetailDto> findAll() {

		List<BulletinSalaireDetailDto> listBulletinSalaireDto = new ArrayList<>();

		List<BulletinSalaire> listBulletinSalaire = bulletinSalaireService.findAll();

		for (BulletinSalaire bulletinSalaire : listBulletinSalaire) {
			listBulletinSalaireDto.add(new BulletinSalaireDetailDto(bulletinSalaire));
		}

		return listBulletinSalaireDto;

	}

	@PostMapping
	public ResponseEntity<?> creeBulletinSalaire(@RequestBody @Valid BulletinSalaireRequestDto bulletinSalaireDto,
			BindingResult resultatValidation) {

		if (!resultatValidation.hasErrors()) {

			BulletinSalaire newBulletinSalaire = bulletinSalaireService.newBulletinSalaire(bulletinSalaireDto);

			BulletinSalaireResponseDto responseDto = new BulletinSalaireResponseDto(newBulletinSalaire);

			return ResponseEntity.ok(responseDto);

		} else {

			return ResponseEntity.badRequest().body(" Tous les champs sont obligatoires !");

		}

	}

	@ExceptionHandler(BulletinSalaireException.class)
	public ResponseEntity<List<String>> onBulletinSalaireException(BulletinSalaireException ex) {

		return ResponseEntity.badRequest().body(ex.getMessagesErreurs());

	}

}
