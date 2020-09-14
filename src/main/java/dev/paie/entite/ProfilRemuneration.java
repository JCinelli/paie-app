package dev.paie.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ProfilRemuneration {

//	FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String code;

	@ManyToMany
	@JoinTable(name = "profil_remuneration_cotisation", joinColumns = @JoinColumn(name = "profil_remuneration_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "cotisation_id", referencedColumnName = "id"))
	private List<Cotisation> cotisations;

	@ManyToMany
	@JoinTable(name = "profil_remuneration_avantage", joinColumns = @JoinColumn(name = "profil_remuneration_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "avantage_id", referencedColumnName = "id"))
	private List<Avantage> avantages;

	@OneToMany(mappedBy = "profilRemuneration")
	private List<RemunerationEmploye> remunerationEmployes;

//	GETTERS & SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisations() {
		return cotisations;
	}

	public void setCotisations(List<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
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
