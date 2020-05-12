package dao;

import java.util.List;

import domain.Alimentation;
import jpa.EntityManagerHelper;

/**
 * @author KEITA
 *
 */
public class AlimentationDao {

	
	/**
	 * @param id of preference food
	 * @return preference food
	 */
	public Alimentation findById(Long id) {
		return EntityManagerHelper.getEntityManager().find(Alimentation.class, id);
	}
	
	public List<Alimentation>findByLiblle(String LibellePreferenceAlimentation){
		return EntityManagerHelper.getEntityManager()
				.createQuery("select a from Alimentation as a where a.LibellePreferenceAlimentation =:LibellePreferenceAlimentation", Alimentation.class)
				.setParameter("LibellePreferenceAlimentation",LibellePreferenceAlimentation )
				.getResultList();
	}
	
	/**
	 * @param A preference food
	 * @return preference food
	 */
	public Alimentation save(Alimentation A) {
		EntityManagerHelper.beginTransaction();
		if (A.getLibellePreferenceAlimentation() != null) {
			EntityManagerHelper.getEntityManager().merge(A);

		} else {
			EntityManagerHelper.getEntityManager().persist(A);

		}
		EntityManagerHelper.commit();
		return A;
	}
	
	/**delete preference food
	 * @param id
	 */
	public void delete(Long id) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(this.findById(id));
		EntityManagerHelper.commit();
	}
	/** 
	 * @return  all preference food
	 */
	public List<Alimentation> findAll() {
		return EntityManagerHelper.getEntityManager().createQuery("select a from Alimentation as a", Alimentation.class)
				.getResultList();
	}
}
