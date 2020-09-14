package dev.paie.web.entreprise;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.Entreprise;
import dev.paie.service.EntrepriseService;

@RestController
@RequestMapping("entreprises")
public class EntrepriseController {

//	FIELDS
	EntrepriseService entrepriseService;

//	CONSTRUCTOR
	public EntrepriseController(EntrepriseService entrepriseService) {
		super();
		this.entrepriseService = entrepriseService;
	}

//	METHODS
	@GetMapping
	public List<EntrepriseResponseDto> getAllEntreprises() {

		List<Entreprise> listeEntreprises = entrepriseService.findAll();

		List<EntrepriseResponseDto> listeEntreprisesDto = new ArrayList<>();

		for (Entreprise e : listeEntreprises) {
			listeEntreprisesDto.add(new EntrepriseResponseDto(e.getSiret(), e.getDenomination()));
		}
		return listeEntreprisesDto;
	}

}
