package dev.paie.entite;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Periode {

//	FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private LocalDate dateDebut;

	private LocalDate dateFin;

	@OneToMany(mappedBy = "periode")
	List<BulletinSalaire> bulletins;

//	GETTERS & SETTERS
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
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
