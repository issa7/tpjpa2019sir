package dao;


import java.util.List;

import domain.Alimentation;
import domain.Reunion;
import jpa.EntityManagerHelper;

public class ReunionDao {
	/**
	 * @param id
	 * @return
	 */
	public Reunion findById(Long id) {
		return EntityManagerHelper.getEntityManager().find(Reunion.class, id);
	}
	
	/**
	 * @param A
	 * @return
	 */
	public Reunion save(Reunion A) {
		EntityManagerHelper.beginTransaction();
		if (A.getIntitule() != null) {
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
	
	public List<Reunion> findAll() {
		return EntityManagerHelper.getEntityManager().createQuery("select a from Reunion as a", Reunion.class)
				.getResultList();
	}
}
