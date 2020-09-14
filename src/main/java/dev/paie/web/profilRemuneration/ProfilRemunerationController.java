package dev.paie.web.profilRemuneration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.service.ProfilRemunerationService;

@RestController
@RequestMapping("profilRemuneration")
public class ProfilRemunerationController {

//	FIELS
	ProfilRemunerationService profilRemunerationService;

//	CONSTRUCTOR
	public ProfilRemunerationController(ProfilRemunerationService profilRemunerationService) {
		this.profilRemunerationService = profilRemunerationService;
	}

//	METHODS
	@GetMapping
	public List<ProfilRemunerationResponseDto> findAll() {

		List<ProfilRemuneration> listProfilRemu = profilRemunerationService.findAll();

		List<ProfilRemunerationResponseDto> listDto = new ArrayList<>();

		for (ProfilRemuneration profilRemuneration : listProfilRemu) {
			listDto.add(new ProfilRemunerationResponseDto(profilRemuneration.getId(), profilRemuneration.getCode()));
		}

		return listDto;
	}

}
