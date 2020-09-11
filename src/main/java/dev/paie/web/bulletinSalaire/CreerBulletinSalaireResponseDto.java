package dev.paie.web.bulletinSalaire;

import dev.paie.entite.BulletinSalaire;

public class CreerBulletinSalaireResponseDto extends CreerBulletinSalaireRequestDto {

//	FIELDS
	Integer id;

//	CONSTRUCTOR
	public CreerBulletinSalaireResponseDto(BulletinSalaire bulletinSalaire) {
		this.id = bulletinSalaire.getId();
		this.setPeriodeId(bulletinSalaire.getPeriode().getId());
		this.setPrimeExceptionnelle(bulletinSalaire.getPrimeExceptionnelle());
		this.setRemunerationEmployeId(bulletinSalaire.getRemunerationEmploye().getId());
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
