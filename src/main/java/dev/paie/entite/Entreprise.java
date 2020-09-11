package dev.paie.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "remunerationEmployes" })
public class Entreprise {

//	FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String siret;

	private String denomination;

	private String adresse;

	private String urssaf;

	private String codeNaf;

	@OneToMany(mappedBy = "entreprise")
	private List<RemunerationEmploye> remunerationEmployes;

//	GETTERS & SETTERS
	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getUrssaf() {
		return urssaf;
	}

	public void setUrssaf(String urssaf) {
		this.urssaf = urssaf;
	}

	public String getCodeNaf() {
		return codeNaf;
	}

	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
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
