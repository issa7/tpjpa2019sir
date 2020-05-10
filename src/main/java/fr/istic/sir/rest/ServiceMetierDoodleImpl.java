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
import dao.ReunionDao;
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
import domain.Reunion;
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
	private ReunionDao reunion = new ReunionDao();

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
	public void addParticipantSondage(@PathParam("idSondage") long id, Participants participant) {
		// TODO Auto-generated method stub
		String res = "SELECT c FROM  PropositionDate c WHERE c.id = :id";
		PropositionDate p = (PropositionDate) EntityManagerHelper.getEntityManager().createQuery(res)
				.setParameter("id", id).getSingleResult();
		if (p != null) {
			participant.setSondage(p);
			;
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
		PropositionDate p = (PropositionDate) EntityManagerHelper.getEntityManager().createQuery(res)
				.setParameter("id", id).getSingleResult();
		if (p != null) {
			date.setPropostiondate(p);
			this.dateSondageDao.save(date);
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/sondagelieu/{id}/lieuxSondage")
	public void addLieuSondageForPropositionLieu(long id, LieuSondage lieu) {
		// TODO Auto-generated method stub
		String res = "SELECT c FROM  PropositionLieu c WHERE c.id = :id";
		PropositionLieu p = (PropositionLieu) EntityManagerHelper.getEntityManager().createQuery(res)
				.setParameter("id", id).getSingleResult();
		if (p != null) {
			lieu.setPropoLieu(p);
			this.lieusondageDao.save(lieu);
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/sondageDate/{idsondage}/participant/{mail}/choix")
	public void addChoixforSondageDate(@PathParam("idsondage") long id, @PathParam("mail") String mail,
			ChoixParticipants choix) {
		// TODO Auto-generated method stub
		String req = "SELECT p FROM Sondage r join r.participants p WHERE r.id = :idsondage AND p.mail = :mail";
		Participants p = (Participants) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idsondage", id).setParameter("mail", mail).getSingleResult();
		if (p != null) {
			choix.setParticipant(p);
			this.choixDao.save(choix);
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/sondageDate/{id}/reunion")
	public void addReunionForSondageDate(@PathParam("id") long id, Reunion r) {
		// TODO Auto-generated method stub
		String res = "SELECT c FROM  PropositionDate c WHERE c.id = :id";
		PropositionDate p = (PropositionDate) EntityManagerHelper.getEntityManager().createQuery(res)
				.setParameter("id", id).getSingleResult();
		if (p != null) {
			r.setDates(p);
			;
			this.reunion.save(r);
		}
	}

	@GET
	@Path("/reunion/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Reunion> getAllreunion() {
		// TODO Auto-generated method stub
		return this.reunion.findAll();
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/createur/{mail}/reunions")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Sondage> getAllSondageForCreateur(@PathParam("mail") String mail) {
		// TODO Auto-generated method stub
		String req = "SELECT r FROM Createur c join c.sondage r WHERE c.mail = :mail";
		return EntityManagerHelper.getEntityManager().createQuery(req).setParameter("mail", mail).getResultList();
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/SondageDate/{idSondageDate}/choix")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ChoixParticipants> getAllChoixforSondageDate(@PathParam("idSondageDate") long id) {
		// TODO Auto-generated method stub
		String req = "SELECT n FROM PropositionDate r join r.participants p join p.choix n WHERE r.id = :idSondageDate";
		return EntityManagerHelper.getEntityManager().createQuery(req).setParameter("idSondageDate", id).getResultList();
	}
	@SuppressWarnings("unchecked")
	@GET
	@Path("/SondageLieu/{idSondagelieu}/choix")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ChoixParticipants> getAllChoixforSondageLieu(@PathParam("idSondagelieu") long id) {
		// TODO Auto-generated method stub
		String req = "SELECT n FROM PropositionLieu r join r.participants p join p.choix n WHERE r.id = :idSondagelieu";
		return EntityManagerHelper.getEntityManager().createQuery(req).setParameter("idSondagelieu", id).getResultList();
	}
	@SuppressWarnings("unchecked")
	@GET
	@Path("/SondageDate/{idSondageDate}/participants")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Participants> getAllParticipantsForSondageDate(@PathParam("idSondageDate") long id) {
		// TODO Auto-generated method stub
		String req = "SELECT p FROM PropositionDate r join r.participants p WHERE r.id = :idSondageDate";
		return EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idSondageDate", id)
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	@GET
	@Path("/SondageLieu/{idSondagelieu}/participants")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Participants> getAllParticipantsForSondageLieu(@PathParam("idSondagelieu") long id) {
		// TODO Auto-generated method stub
		String req = "SELECT p FROM PropositionLieu r join r.participants p WHERE r.id = :idSondagelieu";
		return EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idSondagelieu", id)
				.getResultList();
	}
    
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/SondageDate/{idSondageDate}")
	public PropositionDate getSondageDate(@PathParam("idSondageDate") long id) {
		// TODO Auto-generated method stub
		String req = "SELECT r FROM PropositionDate r WHERE r.id = :idSondageDate";
		return (PropositionDate) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idSondageDate", id)
				.getSingleResult();
	}
	@DELETE
	@Path("/SondageDate/delete/{idsondage}")
	public void deleteSondageDateById(@PathParam("idsondage") long idsondage) {
		// TODO Auto-generated method stub
		String req = "SELECT r FROM PropositionDate r WHERE r.id = :idsondage";
		PropositionDate p = (PropositionDate) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idsondage", idsondage)
				.getSingleResult();
		if(p != null) {
			List<Participants> ps = p.getParticipants();
			for(Participants pa : ps) {
				pa.setSondage(null);;
			}
			this.sondageDate.deletesondage(idsondage);;
		}
	}
	@DELETE
	@Path("participant/{mail}/choix/delete/{idChoix}")
	public void deleteChoixById(@PathParam("mail") String mail, @PathParam("idChoix")long idChoix) {
		// TODO Auto-generated method stub
		String req = "SELECT p FROM Participants r join r.choix p WHERE r.mail = :mail and p.idChoix= :idChoix";
		ChoixParticipants cp = (ChoixParticipants) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idChoix", idChoix).setParameter("mail", mail).getSingleResult();
		if (cp != null) {
			
			Participants participant = cp.getParticipant();
			  participant.setChoix(null);
			this.choixDao.delete(idChoix);;
		}
	}

	
	
	
}
