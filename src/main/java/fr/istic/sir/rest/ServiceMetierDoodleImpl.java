package fr.istic.sir.rest;

import java.util.Collection;
import java.util.List;
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

import dao.AlimentationDao;
import dao.AllergiesDao;
import dao.ChoixParticipantsDao;
import dao.CreateurDao;
import dao.DateSondageDao;
import dao.LieuSondageDao;
import dao.ParticipantDao;
import dao.PropositionDateDao;
import dao.PropositionLieuDao;
import dao.SondageDao;
import domain.Alimentation;
import domain.Allergies;
import domain.ChoixParticipants;
import domain.Createur;
import domain.DateSondage;
import domain.LieuSondage;
import domain.Participants;
import domain.PropositionDate;
import domain.PropositionLieu;
import domain.Sondage;
import jpa.EntityManagerHelper;

@Path("doodle")

public class ServiceMetierDoodleImpl implements ServiceMetierDoodle {

	private static final Logger logger = Logger.getLogger(ServiceMetierDoodleImpl.class.getName());
	private SondageDao daoSondage = new SondageDao();
	private PropositionDateDao sondageDate = new PropositionDateDao();
	private PropositionLieuDao sondageLieu = new PropositionLieuDao();
	private CreateurDao createur = new CreateurDao();
	private AlimentationDao Aliment = new AlimentationDao();
	private ParticipantDao participant = new ParticipantDao();
	private AllergiesDao allergies = new AllergiesDao();
    private DateSondageDao dateSondageDao = new DateSondageDao();
    private LieuSondageDao lieusondageDao = new LieuSondageDao();
    private ChoixParticipantsDao choixDao = new ChoixParticipantsDao();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createur/{mail}/sondageDate")
	public void createSondage(@PathParam("mail") String mail, PropositionDate s) {
		// TODO Auto-generated method stub
		String req = "SELECT c FROM Createur c WHERE c.mail = :mail";
		Createur c = (Createur) EntityManagerHelper.getEntityManager().createQuery(req).setParameter("mail", mail)
				.getSingleResult();
		if (c != null) {
			s.setUtilisateur(c);
			this.sondageDate.save(s);
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

	@POST
	@Path("/participant/{mail}/addAliment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addAlimentation(@PathParam("mail") String mail, Alimentation a) {
		String req = "SELECT p FROM Participants as p WHERE p.mail = :mail";
		Participants p = (Participants) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("mail", mail).getSingleResult();
		if (p != null) {
			a.setParticipant(p);
			this.Aliment.save(a);
		}
	}

	@POST
	@Path("/participant/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Participants AddParticipant(Participants P) {
		// TODO Auto-generated method stub

		return this.participant.save(P);
	}

	@GET
	@Path("/participant/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Participants> getAllParticipant() {
		// TODO Auto-generated method stub
		return this.participant.findAll();
	}

	@GET
	@Path("/alimentation/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Alimentation> getAllAlimentation() {
		// TODO Auto-generated method stub
		return this.Aliment.findAll();
	}

	@POST
	@Path("/participant/{mail}/addAllergies")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addAllergie(@PathParam("mail") String mail, Allergies allergie) {
		// TODO Auto-generated method stub
		String req = "SELECT p FROM Participants as p WHERE p.mail = :mail";
		Participants p = (Participants) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("mail", mail).getSingleResult();
		if (p != null) {
			allergie.setParticipant(p);
			this.allergies.save(allergie);
		}
	}

	@GET
	@Path("/sondageDate/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<PropositionDate> getAllSondageDate() {
		// TODO Auto-generated method stub
		return this.sondageDate.findAllSondageDate();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createur/{mail}/sondageLieu")
	public void creatSondageLieu(@PathParam("mail") String mail, PropositionLieu lieu) {
		// TODO Auto-generated method stub
		String req = "SELECT c FROM Createur c WHERE c.mail = :mail";
		Createur c = (Createur) EntityManagerHelper.getEntityManager().createQuery(req).setParameter("mail", mail)
				.getSingleResult();
		if (c != null) {
			lieu.setUtilisateur(c);
			this.sondageLieu.save(lieu);
		}
	}

	@GET
	@Path("/sondagelieu/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<PropositionLieu> getAllSondageLieu() {
		// TODO Auto-generated method stub
		return this.sondageLieu.findAll();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/sondageDate/{idSondage}/participant")
	public void addParticipantSondage(@PathParam("idSondage")long id, Participants participant) {
		// TODO Auto-generated method stub
		String res = "SELECT c FROM  PropositionDate c WHERE c.id = :id";
		PropositionDate p = (PropositionDate) EntityManagerHelper.getEntityManager().createQuery(res).setParameter("id", id)
				.getSingleResult();
		if (p != null) {
			participant.setSondage(p);;
			this.participant.save(participant);
		}
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/sondageDate/{idSondageDate}/datesSondage")
	public void addDateSondageForPropositionDate(@PathParam("idSondageDate") long id, DateSondage date) {
		// TODO Auto-generated method stub
		String res = "SELECT c FROM  PropositionDate c WHERE c.id = :id";
		PropositionDate p = (PropositionDate) EntityManagerHelper.getEntityManager().createQuery(res).setParameter("id", id)
				.getSingleResult();
		if (p != null) {
			date.setPropostiondate(p);
			this.dateSondageDao.save(date);
		}
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/sondagelieu/{idSondageLieu}/lieuxSondage")
	public void addLieuSondageForPropositionLieu(long id, LieuSondage lieu) {
		// TODO Auto-generated method stub
		String res = "SELECT c FROM  PropositionDate c WHERE c.id = :id";
		PropositionLieu p = (PropositionLieu) EntityManagerHelper.getEntityManager().createQuery(res).setParameter("id", id)
				.getSingleResult();
		if (p != null) {
			lieu.setPropoLieu(p);
			this.lieusondageDao.save(lieu);
		}
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/sondageDate/{idsondage}/participant/{mail}/choix")
	public void addChoixforSondageDate(@PathParam("idsondage")long id, @PathParam("mail")String mail, ChoixParticipants choix) {
		// TODO Auto-generated method stub
		String req = "SELECT p FROM Sondage r join r.participants p WHERE r.id = :idsondage AND p.mail = :mail";
		Participants p = (Participants) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idsondage", id)
				.setParameter("mail", mail)
				.getSingleResult();
		if(p != null) {
			choix.setParticipant(p);
			this.choixDao.save(choix);
		}
	}

}
