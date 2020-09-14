package dev.paie.web.bulletinSalaire;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class BulletinSalaireRequestDto {

//	FIELDS
	@NotNull
	private Integer remunerationEmployeId;

	@NotNull
	private Integer periodeId;

	@NotNull
	private BigDecimal primeExceptionnelle;

	@NotNull
	private LocalDateTime dateHeureCreation;

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

	/**
	 * @return the dateHeureCreation
	 */
	public LocalDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	/**
	 * @param dateHeureCreation the dateHeureCreation to set
	 */
	public void setDateHeureCreation(LocalDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}
}
