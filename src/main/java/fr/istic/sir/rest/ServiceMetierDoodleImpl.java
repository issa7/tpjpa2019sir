package fr.istic.sir.rest;

import java.util.Collection;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.CreateurDao;
import dao.SondageDao;
import domain.Createur;
import domain.Sondage;
import jpa.EntityManagerHelper;

@Path("doodle")

public class ServiceMetierDoodleImpl implements ServiceMetierDoodle {

	private static final Logger logger = Logger.getLogger(ServiceMetierDoodleImpl.class.getName());
	private SondageDao daoSondage;
	private CreateurDao createur = new CreateurDao();

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

	@GET
	@Path("/user/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Createur> getAllCreateurs() {
		// TODO Auto-generated method stub
		return this.createur.findAll();
	}

	@POST
	@Path("/createur/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Createur createCreateur(Createur U) {
		// TODO Auto-generated method stub
		return this.createur.save(U);
	}

	@GET
	@Path("/Createur/{CreateurID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Createur getCreateur(@PathParam("CreateurID") String mail) {
		// TODO Auto-generated method stub
		return this.createur.findCreateurByMail(mail);

	}

	@DELETE
	@Path("/Createur/delete/{CreateurID}")
	public Response deleteCreateur(@PathParam("CreateurID") String mail) {
		// TODO Auto-generated method stub
		this.createur.delete(mail);
		String result = "le createur qui a pour " + mail + "  est  Supprimé";
		return Response.status(201).entity(result).build();
	}

}
