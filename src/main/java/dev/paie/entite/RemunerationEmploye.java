package dev.paie.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class RemunerationEmploye {

//	FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String matricule;

	@ManyToOne
	@JoinColumn(name = "entreprise_id")
	private Entreprise entreprise;

	@ManyToOne
	@JoinColumn(name = "profilRemuneration_id")
	private ProfilRemuneration profilRemuneration;

	@ManyToOne
	@JoinColumn(name = "grade_id")
	private Grade grade;

	@OneToMany(mappedBy = "remunerationEmploye")
	List<BulletinSalaire> bulletins;

//	GETTERS & SETTERS
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}

	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the bulletins
	 */
	public List<BulletinSalaire> getBulletins() {
		return bulletins;
	}

	/**
	 * @param bulletins the bulletins to set
	 */
	public void setBulletins(List<BulletinSalaire> bulletins) {
		this.bulletins = bulletins;
	}

}
