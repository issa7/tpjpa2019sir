package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import domain.PropositionDate;
import domain.PropositionLieu;
import domain.ResultatSondage;
import domain.Sondage;
import jpa.EntityManagerHelper;

public class PropositionDateDao {
	/**
	 * retourne un sondage de type date
	 * 
	 * @param id du sondage de type date � chercher
	 * @return le sondage
	 * 
	 */
	public Sondage findByDate(Date date) {
		return EntityManagerHelper.getEntityManager()
				.createQuery("select s from Sondage as s where s.date =:date and s.sondage_type = 'SondageDate' ",
						Sondage.class)
				.setParameter("date", date).getSingleResult();
	}

	public PropositionDate save(PropositionDate P) {
		EntityManagerHelper.beginTransaction();
		if (P.getNomSondage() != null) {
			EntityManagerHelper.getEntityManager().merge(P);

		} else {
			EntityManagerHelper.getEntityManager().persist(P);

		}
		EntityManagerHelper.commit();
		return P;

	}

	/**
	 * retourne le nombre de ligne supprimer
	 * 
	 * @return int le nombre de ligne retourner
	 */
	public int delete() {
		Query query = EntityManagerHelper.getEntityManager()
				.createQuery("DELETE FROM Sondage e WHERE e.type_sondage IN sondageDate");
		return query.executeUpdate();
	}

	public List<Sondage> findAllSondage() {
		return EntityManagerHelper.getEntityManager().createQuery("select n from Sondage as n ", Sondage.class)
				.getResultList();
	}

	public List<PropositionDate> findAllSondageDate() {
		return EntityManagerHelper.getEntityManager()
				.createQuery("select n from PropositionDate as n  ", PropositionDate.class).getResultList();
	}

}
