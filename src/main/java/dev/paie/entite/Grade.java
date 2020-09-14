package dev.paie.entite;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Grade {

//	FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String code;

	private BigDecimal nbHeuresBase;

	private BigDecimal tauxBase;

	@OneToMany(mappedBy = "grade")
	private List<RemunerationEmploye> remunerationEmployes;

//	GETTERS & SETTERS
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}

	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}

	public BigDecimal getTauxBase() {
		return tauxBase;
	}

	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the employes
	 */
	public List<RemunerationEmploye> getEmployes() {
		return remunerationEmployes;
	}

	/**
	 * @param employes the employes to set
	 */
	public void setEmployes(List<RemunerationEmploye> remunerationEmployes) {
		this.remunerationEmployes = remunerationEmployes;
	}

	/**
	 * @return the remunerationEmployes
	 */
	public List<RemunerationEmploye> getRemunerationEmployes() {
		return remunerationEmployes;
	}

	/**
	 * @param remunerationEmployes the remunerationEmployes to set
	 */
	public void setRemunerationEmployes(List<RemunerationEmploye> remunerationEmployes) {
		this.remunerationEmployes = remunerationEmployes;
	}

}
