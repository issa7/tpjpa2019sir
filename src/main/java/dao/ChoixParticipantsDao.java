package dao;

import java.util.List;

import domain.Alimentation;
import domain.ChoixParticipants;
import jpa.EntityManagerHelper;

public class ChoixParticipantsDao {
	/**
	 * @param id
	 * @return
	 */
	public ChoixParticipants findById(Long id) {
		return EntityManagerHelper.getEntityManager().find(ChoixParticipants.class, id);
	}
	
	
	
	/**
	 * @param A
	 * @return
	 */
	public ChoixParticipants save(ChoixParticipants A) {
		EntityManagerHelper.beginTransaction();
		if (A.getChoix() != null) {
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
	/**
	 * @return
	 */
	public List<ChoixParticipants> findAll() {
		return EntityManagerHelper.getEntityManager().createQuery("select a from ChoixParticipants as a", ChoixParticipants.class)
				.getResultList();
	}
}
