package dev.paie.web.grade;

import java.math.BigDecimal;

public class GradeResponseDto {

//	FIELDS
	private String code;

	private BigDecimal salaireAnnuel;

//	CONSTRUCTORS
	public GradeResponseDto() {
	}

	public GradeResponseDto(String code, BigDecimal salaireAnnuel) {
		this.code = code;
		this.salaireAnnuel = salaireAnnuel;
	}

//	GETTERS & SETTERS
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the salaireAnnuel
	 */
	public BigDecimal getSalaireAnnuel() {
		return salaireAnnuel;
	}

	/**
	 * @param salaireAnnuel the salaireAnnuel to set
	 */
	public void setSalaireAnnuel(BigDecimal salaireAnnuel) {
		this.salaireAnnuel = salaireAnnuel;
	}
}
