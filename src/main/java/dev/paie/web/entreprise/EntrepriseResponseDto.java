package dev.paie.web.entreprise;

public class EntrepriseResponseDto {

//	FIELDS
	private String siret;

	private String denomination;

//	CONSTRUCTORS
	public EntrepriseResponseDto() {
	}

	public EntrepriseResponseDto(String siret, String denomination) {
		this.siret = siret;
		this.denomination = denomination;
	}

//	GETTERS & SETTERS
	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
}
