package dao;

import java.util.List;

import domain.DateSondage;
import domain.LieuSondage;
import jpa.EntityManagerHelper;

public class LieuSondageDao {
	/**
	 * @param id
	 * @return
	 */
	public LieuSondage findById(Long id) {
		return EntityManagerHelper.getEntityManager().find(LieuSondage.class, id);
	}

//	public List<Allergies>findByLiblle(String libelleAllergie){
//		return EntityManagerHelper.getEntityManager()
//				.createQuery("select a from Alimentation as a where a.libelleAllergie =:libelleAllergie", Allergies.class)
//				.setParameter("libelleAllergie",libelleAllergie )
//				.getResultList();
//	}
	public LieuSondage save(LieuSondage A) {
		EntityManagerHelper.beginTransaction();
		if (A.getLieuSondage() != null) {
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

	public List<LieuSondage> findAll() {
		return EntityManagerHelper.getEntityManager().createQuery("select a from LieuSondage as a", LieuSondage.class)
				.getResultList();
	}
}
