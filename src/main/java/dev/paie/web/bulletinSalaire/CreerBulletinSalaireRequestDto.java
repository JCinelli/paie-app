package dev.paie.web.bulletinSalaire;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class CreerBulletinSalaireRequestDto {

//	FIELDS
	@NotNull
	Integer remunerationEmployeId;

	@NotNull
	Integer periodeId;

	@NotNull
	BigDecimal primeExceptionnelle;

//	GETTERS & SETTERS
	/**
	 * @return the remunerationEmployeId
	 */
	public Integer getRemunerationEmployeId() {
		return remunerationEmployeId;
	}

	/**
	 * @param remunerationEmployeId the remunerationEmployeId to set
	 */
	public void setRemunerationEmployeId(Integer remunerationEmployeId) {
		this.remunerationEmployeId = remunerationEmployeId;
	}

	/**
	 * @return the periodeId
	 */
	public Integer getPeriodeId() {
		return periodeId;
	}

	/**
	 * @param periodeId the periodeId to set
	 */
	public void setPeriodeId(Integer periodeId) {
		this.periodeId = periodeId;
	}

	/**
	 * @return the primeExceptionnelle
	 */
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}

	/**
	 * @param primeExceptionnelle the primeExceptionnelle to set
	 */
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
}
