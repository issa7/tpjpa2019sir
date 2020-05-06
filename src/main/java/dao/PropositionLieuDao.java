package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import domain.Sondage;
import jpa.EntityManagerHelper;

public class PropositionLieuDao {
	
	/** retourne un sondage de type date 
	 * @param id du sondage de type date à chercher 
	 * @return le sondage
	 * 
	 */
	public Sondage findByDate(String lieu) {
		return EntityManagerHelper.getEntityManager().createQuery("select s from Sondage as s where s.lieu =:lieu and s.sondage_type ='sondageLieu' ",Sondage.class)
				.setParameter("lieu", lieu).getSingleResult();
	}
	
	/** retourne le nombre de ligne supprimer
	 * @return int le nombre de ligne retourner
	 * */
	public int delete() {
		Query query= EntityManagerHelper.getEntityManager().createQuery("DELETE FROM Sondage e WHERE e.type_sondage IN sondageLieu");
		return query.executeUpdate();
	}
	 public List<Sondage> findAll() {
	       return EntityManagerHelper.getEntityManager().createQuery("select n from Sondage as n where n.sondage_type ='sondageLieu'", Sondage.class)
	       .getResultList();
		}
}
