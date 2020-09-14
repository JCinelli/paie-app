package dev.paie.web.profilRemuneration;

public class ProfilRemunerationResponseDto {

//	FIELDS
	private Integer id;

	private String code;

//	CONSTRUCTORS
	public ProfilRemunerationResponseDto() {
	}

	public ProfilRemunerationResponseDto(Integer id, String code) {
		this.id = id;
		this.code = code;
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

}
