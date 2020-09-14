package dev.paie.web.bulletinSalaire;

import dev.paie.entite.BulletinSalaire;

public class BulletinSalaireResponseDto extends BulletinSalaireRequestDto {

//	FIELDS
	private Integer id;

//	CONSTRUCTOR
	public BulletinSalaireResponseDto(BulletinSalaire bulletinSalaire) {
		this.id = bulletinSalaire.getId();
		this.setPeriodeId(bulletinSalaire.getPeriode().getId());
		this.setPrimeExceptionnelle(bulletinSalaire.getPrimeExceptionnelle());
		this.setRemunerationEmployeId(bulletinSalaire.getRemunerationEmploye().getId());
		this.setDateHeureCreation(bulletinSalaire.getDateHeureCreation());
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
