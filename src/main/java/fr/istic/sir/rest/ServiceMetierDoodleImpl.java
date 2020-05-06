package fr.istic.sir.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.SondageDao;
import domain.Createur;
import domain.Sondage;
import jpa.EntityManagerHelper;

@Path("doodle")

public class ServiceMetierDoodleImpl implements ServiceMetierDoodle {

	private SondageDao daoSondage;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("Sondage/{email}/sondage")
	public void createSondage(@PathParam("mail") String mail, Sondage s) {
		// TODO Auto-generated method stub
		String req = "SELECT c FROM Createur c WHERE c.mail = :mail";
		Createur c = (Createur) EntityManagerHelper.getEntityManager().createQuery(req).setParameter("mail", mail)
				.getSingleResult();
		if (c != null) {
			s.setUtilisateur(c);
			this.daoSondage.save(s);
		}
	}

}
