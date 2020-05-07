package dao;

import java.util.List;

import domain.Alimentation;
import domain.Allergies;
import jpa.EntityManagerHelper;

public class AllergiesDao {
				
	
	
	/**
	 * @param id
	 * @return
	 */
	public Allergies findById(Long id) {
		return EntityManagerHelper.getEntityManager().find(Allergies.class, id);
	}
	
	public List<Allergies>findByLiblle(String libelleAllergie){
		return EntityManagerHelper.getEntityManager()
				.createQuery("select a from Alimentation as a where a.libelleAllergie =:libelleAllergie", Allergies.class)
				.setParameter("libelleAllergie",libelleAllergie )
				.getResultList();
	}
	public Allergies save(Allergies A) {
		EntityManagerHelper.beginTransaction();
		if (A.getLibelleAllergie() != null) {
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
	
	public List<Allergies> findAll() {
		return EntityManagerHelper.getEntityManager().createQuery("select a from Allergies as a", Allergies.class)
				.getResultList();
	}
}
