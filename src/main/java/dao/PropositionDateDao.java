package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import domain.PropositionDate;
import domain.ResultatSondage;
import domain.Sondage;
import jpa.EntityManagerHelper;

public class PropositionDateDao {
	/** retourne un sondage de type date 
	 * @param id du sondage de type date à chercher 
	 * @return le sondage
	 * 
	 */
	public Sondage findByDate(Date date) {
		return EntityManagerHelper.getEntityManager().createQuery("select s from Sondage as s where s.date =:date and s.sondage_type = 'SondageDate' ",Sondage.class)
				.setParameter("date", date).getSingleResult();
	}
	/** retourne le nombre de ligne supprimer
	 * @return int le nombre de ligne retourner
	 * */
	public int delete() {
		Query query= EntityManagerHelper.getEntityManager().createQuery("DELETE FROM Sondage e WHERE e.type_sondage IN sondageDate");
		return query.executeUpdate();
	}

	 public List<Sondage> findAll() {
	       return EntityManagerHelper.getEntityManager().createQuery("select n from Sondage as n where n.sondage_type ='sondageDate'", Sondage.class)
	       .getResultList();
		}
	 

	
}
