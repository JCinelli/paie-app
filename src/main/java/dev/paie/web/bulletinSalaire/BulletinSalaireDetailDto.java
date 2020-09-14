package dev.paie.web.bulletinSalaire;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;

public class BulletinSalaireDetailDto {

//	FIELDS
	private Integer id;

	private LocalDateTime dateHeureCreation;

	private LocalDate dateDebut;

	private LocalDate dateFin;

	private String matricule;

	private BigDecimal salaireBrut;

	private BigDecimal netImposable;

	private BigDecimal netAPayer;

	private BigDecimal salaireBase;

	private BigDecimal totalRetenueSalariale;

//	CONSTRUCTOR
	public BulletinSalaireDetailDto(BulletinSalaire bulletinSalaire) {
		this.setId(bulletinSalaire.getId());
		this.setDateHeureCreation(bulletinSalaire.getDateHeureCreation());
		this.setDateDebut(bulletinSalaire.getPeriode().getDateDebut());
		this.setDateFin(bulletinSalaire.getPeriode().getDateFin());
		this.setMatricule(bulletinSalaire.getRemunerationEmploye().getMatricule());
		this.setSalaireBase(bulletinSalaire.getRemunerationEmploye().getGrade().getNbHeuresBase()
				.multiply(bulletinSalaire.getRemunerationEmploye().getGrade().getTauxBase()));
		this.setSalaireBrut(bulletinSalaire.getPrimeExceptionnelle().add(this.salaireBase));

		List<Cotisation> listCot = bulletinSalaire.getRemunerationEmploye().getProfilRemuneration().getCotisations();

		BigDecimal bd = new BigDecimal("0");

		for (Cotisation cotisation : listCot) {
			if (!cotisation.getImposable()) {
				if (cotisation.getTauxSalarial() != null) {
					bd = bd.add(cotisation.getTauxSalarial().multiply(this.salaireBrut));
				}
			}
		}

		this.setTotalRetenueSalariale(bd);
		this.setNetImposable(this.salaireBrut.subtract(this.totalRetenueSalariale));

		BigDecimal bd2 = new BigDecimal("0");

		for (Cotisation cotisation : listCot) {
			if (cotisation.getImposable()) {
				if (cotisation.getTauxSalarial() != null) {
					bd2 = bd2.add(cotisation.getTauxSalarial().multiply(this.salaireBrut));
				}
			}
		}

		this.setNetAPayer(this.netImposable.subtract(bd2));

	}

//	GETTERS & SETTERS
	/**
	 * @return the dateHeureCreation
	 */
	public LocalDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	/**
	 * @param dateHeureCreation the dateHeureCreation to set
	 */
	public void setDateHeureCreation(LocalDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	/**
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

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
	 * @return the salaireBrut
	 */
	public BigDecimal getSalaireBrut() {
		return salaireBrut;
	}

	/**
	 * @param salaireBrut the salaireBrut to set
	 */
	public void setSalaireBrut(BigDecimal salaireBrut) {
		this.salaireBrut = salaireBrut;
	}

	/**
	 * @return the netImposable
	 */
	public BigDecimal getNetImposable() {
		return netImposable;
	}

	/**
	 * @param netImposable the netImposable to set
	 */
	public void setNetImposable(BigDecimal netImposable) {
		this.netImposable = netImposable;
	}

	/**
	 * @return the netAPayer
	 */
	public BigDecimal getNetAPayer() {
		return netAPayer;
	}

	/**
	 * @param netAPayer the netAPayer to set
	 */
	public void setNetAPayer(BigDecimal netAPayer) {
		this.netAPayer = netAPayer;
	}

	/**
	 * @return the salaireBase
	 */
	public BigDecimal getSalaireBase() {
		return salaireBase;
	}

	/**
	 * @param salaireBase the salaireBase to set
	 */
	public void setSalaireBase(BigDecimal salaireBase) {
		this.salaireBase = salaireBase;
	}

	/**
	 * @return the totalRetenueSalariale
	 */
	public BigDecimal getTotalRetenueSalariale() {
		return totalRetenueSalariale;
	}

	/**
	 * @param totalRetenueSalariale the totalRetenueSalariale to set
	 */
	public void setTotalRetenueSalariale(BigDecimal totalRetenueSalariale) {
		this.totalRetenueSalariale = totalRetenueSalariale;
	}

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

}
