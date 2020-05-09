package dao;

import java.util.List;

import domain.Allergies;
import domain.DateSondage;
import jpa.EntityManagerHelper;

public class DateSondageDao {

	/**
	 * @param id
	 * @return
	 */
	public DateSondage findById(Long id) {
		return EntityManagerHelper.getEntityManager().find(DateSondage.class, id);
	}
	
//	public List<Allergies>findByLiblle(String libelleAllergie){
//		return EntityManagerHelper.getEntityManager()
//				.createQuery("select a from Alimentation as a where a.libelleAllergie =:libelleAllergie", Allergies.class)
//				.setParameter("libelleAllergie",libelleAllergie )
//				.getResultList();
//	}
	public DateSondage save(DateSondage A) {
		EntityManagerHelper.beginTransaction();
		if (A.getDate() != null) {
			EntityManagerHelper.getEntityManager().merge(A);

		} else {
			EntityManagerHelper.getEntityManager().persist(A);

		}
		EntityManagerHelper.commit();
		return A;
	}
	
	/**
	 * @param id
	 */
	public void delete(Long id) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(this.findById(id));
		EntityManagerHelper.commit();
	}
	
	public List<DateSondage> findAll() {
		return EntityManagerHelper.getEntityManager().createQuery("select a from DateSondage as a", DateSondage.class)
				.getResultList();
	}
}
