package dao;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Participants;
import jpa.EntityManagerHelper;

public class ParticipantDao {
	
	public Participants findByMailParticipants(String mail) {
		return EntityManagerHelper.getEntityManager().find(Participants.class, mail);
	}

	public Participants save(Participants p) {
		EntityManagerHelper.beginTransaction();
		if (p.getMail() != null) {
			EntityManagerHelper.getEntityManager().merge(p);
		} else {
			EntityManagerHelper.getEntityManager().persist(p);
		}
		EntityManagerHelper.commit();
		return p;
	}

	public void deleteParticipants(String mail) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(this.findByMailParticipants(mail));
		EntityManagerHelper.commit();
	}

	public List<Participants> findByName(String Name) {
		return EntityManagerHelper.getEntityManager()
				.createQuery("select p from Participants as  p where p.nom = :Name", Participants.class)
				.setParameter("Name", Name).getResultList();
	}

	public List<Participants> findAll() {
		return EntityManagerHelper.getEntityManager()
				.createQuery("select p from Participants as p ", Participants.class).getResultList();
	}
}
