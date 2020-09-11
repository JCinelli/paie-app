package dev.paie.web.remunerationEmploye;

import com.sun.istack.NotNull;

public class CreerRemunerationEmployeRequestDto {

//	FIELDS
	@NotNull
	private String matricule;

	@NotNull
	private Integer entrepriseId;

	@NotNull
	private Integer profilRenumerationId;

	@NotNull
	private Integer gradeId;

//	GETTERS & SETTERS
	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the entrepriseId
	 */
	public Integer getEntrepriseId() {
		return entrepriseId;
	}

	/**
	 * @param entrepriseId the entrepriseId to set
	 */
	public void setEntrepriseId(Integer entrepriseId) {
		this.entrepriseId = entrepriseId;
	}

	/**
	 * @return the profilRenumerationId
	 */
	public Integer getProfilRenumerationId() {
		return profilRenumerationId;
	}

	/**
	 * @param profilRenumerationId the profilRenumerationId to set
	 */
	public void setProfilRenumerationId(Integer profilRenumerationId) {
		this.profilRenumerationId = profilRenumerationId;
	}

	/**
	 * @return the gradeId
	 */
	public Integer getGradeId() {
		return gradeId;
	}

	/**
	 * @param gradeId the gradeId to set
	 */
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

}
