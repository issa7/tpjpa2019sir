package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import domain.PropositionDate;
import domain.PropositionLieu;
import domain.Sondage;
import jpa.EntityManagerHelper;

public class PropositionLieuDao {

	/**
	 * retourne un sondage de type date
	 * 
	 * @param id du sondage de type date à chercher
	 * @return le sondage
	 * 
	 */
	public Sondage findByDate(String lieu) {
		return EntityManagerHelper.getEntityManager()
				.createQuery("select s from Sondage as s where s.lieu =:lieu and s.sondage_type ='sondageLieu' ",
						Sondage.class)
				.setParameter("lieu", lieu).getSingleResult();
	}

	public PropositionLieu save(PropositionLieu P) {
		EntityManagerHelper.beginTransaction();
		if (P.getNomSondage() != null) {
			EntityManagerHelper.getEntityManager().merge(P);

		} else {
			EntityManagerHelper.getEntityManager().persist(P);

		}
		EntityManagerHelper.commit();
		return P;

	}
	public Sondage findById(long id) {
		return EntityManagerHelper.getEntityManager().find(PropositionLieu.class, id);
	}
	
	public void deletesondage(long id) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(this.findById(id));
		EntityManagerHelper.commit();
	}
	/**
	 * retourne le nombre de ligne supprimer
	 * 
	 * @return int le nombre de ligne retourner
	 */
	public int delete() {
		Query query = EntityManagerHelper.getEntityManager()
				.createQuery("DELETE FROM Sondage e WHERE e.type_sondage IN sondageLieu");
		return query.executeUpdate();
	}

	public List<PropositionLieu> findAll() {
		return EntityManagerHelper.getEntityManager()
				.createQuery("select n from PropositionLieu as n ", PropositionLieu.class).getResultList();
	}
}
