package dao;

import java.util.List;

import domain.Createur;
import jpa.EntityManagerHelper;

/**
 * @author KEITA
 *
 */
/**
 * @author KEITA
 *
 */
/**
 * @author KEITA
 *
 */
public class CreateurDao {

	/**
	 * @param Mail
	 * @return
	 */
	public Createur findCreateurByMail(String Mail) {
		return EntityManagerHelper.getEntityManager().find(Createur.class, Mail);
	}

	/**
	 * @param nom
	 * @return
	 */
	public List<Createur> findCreateurByName(String nom) {
		return EntityManagerHelper.getEntityManager()
				.createQuery("select c from Createur as c where c.nom =:nom", Createur.class).setParameter("nom", nom)
				.getResultList();
	}

	/**
	 * @param c
	 * @return
	 */
	public Createur save(Createur c) {
		EntityManagerHelper.beginTransaction();
		if (c.getMail() != null) {
			EntityManagerHelper.getEntityManager().merge(c);

		} else {
			EntityManagerHelper.getEntityManager().persist(c);

		}
		EntityManagerHelper.commit();
		return c;

	}

	/**
	 * @param mail
	 */
	public void delete(String mail) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(this.findCreateurByMail(mail));
		EntityManagerHelper.commit();
	}

	/**
	 * @return
	 */
	public List<Createur> findAll() {
		return EntityManagerHelper.getEntityManager().createQuery("select c from Createur as c", Createur.class)
				.getResultList();
	}
	
}
