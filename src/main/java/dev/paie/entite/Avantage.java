package dev.paie.entite;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "profilRemunerations" })
public class Avantage {

//	FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String code;

	private String nom;

	@Column(columnDefinition = "Decimal(6,6)")
	private BigDecimal montant;

	@ManyToMany(mappedBy = "avantages")
	List<ProfilRemuneration> profilRemunerations;

//	GETTERS & SETTERS
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the profilRemunerations
	 */
	public List<ProfilRemuneration> getProfilRemunerations() {
		return profilRemunerations;
	}

	/**
	 * @param profilRemunerations the profilRemunerations to set
	 */
	public void setProfilRemunerations(List<ProfilRemuneration> profilRemunerations) {
		this.profilRemunerations = profilRemunerations;
	}
}
