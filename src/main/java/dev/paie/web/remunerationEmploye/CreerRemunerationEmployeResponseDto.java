package dev.paie.web.remunerationEmploye;

import dev.paie.entite.RemunerationEmploye;

public class CreerRemunerationEmployeResponseDto extends CreerRemunerationEmployeRequestDto {

//	FIELDS
	private Integer id;

//	CONSTRUCTOR
	public CreerRemunerationEmployeResponseDto(RemunerationEmploye remunerationEmploye) {
		this.id = remunerationEmploye.getId();
		this.setEntrepriseId(remunerationEmploye.getEntreprise().getId());
		this.setMatricule(remunerationEmploye.getMatricule());
		this.setGradeId(remunerationEmploye.getGrade().getId());
		this.setProfilRenumerationId(remunerationEmploye.getProfilRemuneration().getId());
	}

//	GETTERS & SETTERS
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
