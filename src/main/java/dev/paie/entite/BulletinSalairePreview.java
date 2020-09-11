package dev.paie.entite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BulletinSalairePreview {

	private BigDecimal salaireBrut = new BigDecimal("0.0");

	private BigDecimal salaireNetImposable = new BigDecimal("0.0");

	private BigDecimal salaireNetAPayer = new BigDecimal("0.0");

	public List<BulletinSalairePreview> toPreview(List<BulletinSalaire> bulletinsSalaireList) {

		List<BulletinSalairePreview> bulletinSalairePreviewList = new ArrayList<>();

		for (BulletinSalaire bulletinSalaire : bulletinsSalaireList) {

			BigDecimal salaireBase = bulletinSalaire.getRemunerationEmploye().getGrade().getNbHeuresBase()
					.multiply(bulletinSalaire.getRemunerationEmploye().getGrade().getTauxBase());

			this.salaireBrut = salaireBase.add(bulletinSalaire.getPrimeExceptionnelle());

//			TOTAL_RETENUE_SALARIALE = SOMME(COTISATION_NON_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)

			BigDecimal totalRetenueSalariale = new BigDecimal("0.0");

			for (Cotisation cotisation : bulletinSalaire.getRemunerationEmploye().getProfilRemuneration()
					.getCotisations()) {
				if (!cotisation.getImposable()) {
					totalRetenueSalariale = totalRetenueSalariale
							.add(cotisation.getTauxSalarial().multiply(this.salaireBrut));
				}
			}

			this.salaireNetImposable = this.salaireBrut.subtract(totalRetenueSalariale);

			BigDecimal t = new BigDecimal("0.0");

			for (Cotisation cotisation : bulletinSalaire.getRemunerationEmploye().getProfilRemuneration()
					.getCotisations()) {
				if (cotisation.getImposable()) {
					t = t.add(cotisation.getTauxSalarial().multiply(salaireBrut));
				}
			}

			this.salaireNetAPayer = this.salaireNetImposable.subtract(t);

			BulletinSalairePreview newBSP = new BulletinSalairePreview();
			newBSP.setSalaireBrut(salaireBrut);
			newBSP.setSalaireNetAPayer(salaireNetAPayer);
			newBSP.setSalaireNetImposable(salaireNetImposable);

			bulletinSalairePreviewList.add(newBSP);

		}

		return bulletinSalairePreviewList;

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
	 * @return the salaireNetImposable
	 */
	public BigDecimal getSalaireNetImposable() {
		return salaireNetImposable;
	}

	/**
	 * @param salaireNetImposable the salaireNetImposable to set
	 */
	public void setSalaireNetImposable(BigDecimal salaireNetImposable) {
		this.salaireNetImposable = salaireNetImposable;
	}

	/**
	 * @return the salaireNetAPayer
	 */
	public BigDecimal getSalaireNetAPayer() {
		return salaireNetAPayer;
	}

	/**
	 * @param salaireNetAPayer the salaireNetAPayer to set
	 */
	public void setSalaireNetAPayer(BigDecimal salaireNetAPayer) {
		this.salaireNetAPayer = salaireNetAPayer;
	}

}
