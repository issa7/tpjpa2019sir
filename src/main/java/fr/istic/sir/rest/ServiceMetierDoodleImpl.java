package fr.istic.sir.rest;

import java.util.ArrayList;
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

/**
 * @author KEITA
 *
 */
@Path("doodle")
@Produces("application/json")
@Consumes("application/json")
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

	/**
	 * create sondage de type de date
	 * 
	 * @param email du createur qui creer le sondage
	 */
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

	/**
	 * get all createur
	 * 
	 * @return list of all sondage
	 */
	@GET
	@Path("/user/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Createur> getAllCreateurs() {
		// TODO Auto-generated method stub
		return this.createur.findAll();
	}

	/**
	 * create creator
	 * 
	 * @return creator who was create
	 */
	@POST
	@Path("/createur/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Createur createCreateur(Createur U) {
		// TODO Auto-generated method stub
		return this.createur.save(U);
	}

	/**
	 * get a creator
	 * 
	 * @param createurId
	 * @return creator who was as the createurId in the param
	 */
	@GET
	@Path("/Createur/{CreateurID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Createur getCreateur(@PathParam("CreateurID") String mail) {
		// TODO Auto-generated method stub
		return this.createur.findCreateurByMail(mail);

	}
	@GET
	@Path("/Participant/{idparticipant}")
	@Produces(MediaType.APPLICATION_JSON)
	public Participants getParticipants(@PathParam("idparticipant")String mail) {
		// TODO Auto-generated method stub
		return this.participant.findByMailParticipants(mail);
	}

	/**
	 * Delete the creator by Id of Creator
	 * 
	 * @param creatorId
	 * @return response if the createur is delete
	 */
	@DELETE
	@Path("/Createur/delete/{CreateurID}")
	public Response deleteCreateur(@PathParam("CreateurID") String mail) {
		// TODO Auto-generated method stub
		this.createur.delete(mail);
		String result = "le createur qui a pour " + mail + "  est  Supprimé";
		return Response.status(201).entity(result).build();
	}

	/**
	 * Add the aliment of participant
	 * 
	 * @param mail of particpant
	 *
	 */
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

	/**
	 * add participant
	 * 
	 * @return participant who was create
	 */
	@POST
	@Path("/participant/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Participants AddParticipant(Participants P) {
		// TODO Auto-generated method stub

		return this.participant.save(P);
	}

	/**
	 * get all participant
	 * 
	 * @return list of all participant
	 */
	@GET
	@Path("/participant/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Participants> getAllParticipant() {
		// TODO Auto-generated method stub
		return this.participant.findAll();
	}

	/**
	 * get all food preference
	 * 
	 * @return list of all food preference
	 */
	@GET
	@Path("/alimentation/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Alimentation> getAllAlimentation() {
		// TODO Auto-generated method stub
		return this.Aliment.findAll();
	}

	/**
	 * add allergies for a participant
	 * 
	 * @param mail of participant
	 */
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

	/**
	 * get all sondage
	 * 
	 * @return list of all sondage of type date
	 */
	@GET
	@Path("/sondageDate/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<PropositionDate> getAllSondageDate() {
		// TODO Auto-generated method stub
		return this.sondageDate.findAllSondageDate();
	}

	/**
	 * create the sondage date by createur
	 * 
	 * @param mail of createur
	 */
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

	/**
	 * get all sondage of type lieu
	 * 
	 * @return list of all sondage of type date
	 */
	@GET
	@Path("/sondagelieu/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<PropositionLieu> getAllSondageLieu() {
		// TODO Auto-generated method stub
		return this.sondageLieu.findAll();
	}

	/**
	 * Add particpants in sondage of type date
	 * 
	 * @param idSondage of type date
	 */
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

	/**
	 * Add date in sondage of type date
	 * 
	 * @param idSondage of type sondage date
	 */
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

	/**
	 * Add lieu in sondage of type lieu
	 * 
	 * @param id of type sondage lieu
	 */
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

	/**
	 * Add choix in sondage by participant
	 * 
	 * @param idSondage of type date
	 * @param mail      of participant
	 */
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
	
	/**
	 * get prference food by mail of participant
	 * 
	 * @param idSondage 
	 * @param mail  of participant
	 * @return List all food of participant
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/sondage/{idsondage}/participant/{mail}/alimention")
	public Collection<Alimentation> getAlimentationByMailForSondage(@PathParam("idsondage")long id, @PathParam("mail") String mail) {
		// TODO Auto-generated method stub
		String req = "SELECT p.preferenceAliment FROM Sondage r join r.participants p  WHERE r.id = :idsondage AND p.mail = :mail";
		return  EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idsondage", id).setParameter("mail", mail).getResultList();
	}
	
	
	/**
	 * get allergie food by mail of participant
	 * 
	 * @param idSondage 
	 * @param mail  of participant
	 * @return List all allergies of participant
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/sondage/{idsondage}/participant/{mail}/allergies")
	public Collection<Allergies> getAllergiesByMailForSondage(@PathParam("idsondage") long id, @PathParam("mail") String mail) {
		// TODO Auto-generated method stub
		String req = "SELECT p.allergie FROM Sondage r join r.participants p  WHERE r.id = :idsondage AND p.mail = :mail";
		return  EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idsondage", id).setParameter("mail", mail).getResultList();
	}
	/**
	 * Add reunion in sondageDate
	 * 
	 * @param idSondage of type date
	 * 
	 */
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

	/**
	 * get all reunion
	 *
	 * @return List of all reunion
	 */
	@GET
	@Path("/reunion/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Reunion> getAllreunion() {
		// TODO Auto-generated method stub
		return this.reunion.findAll();
	}

	/**
	 * get all sondage of creator
	 * 
	 * @param mail of createur
	 * @return List of all sondage of creator
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Path("/createur/{mail}/reunions")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Sondage> getAllSondageForCreateur(@PathParam("mail") String mail) {
		// TODO Auto-generated method stub
		String req = "SELECT r FROM Createur c join c.sondage r WHERE c.mail = :mail";
		return EntityManagerHelper.getEntityManager().createQuery(req).setParameter("mail", mail).getResultList();
	}

	/**
	 * get all choix of sondage
	 *
	 * @return List of all choix of sondagedate
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Path("/SondageDate/{idSondageDate}/choix")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ChoixParticipants> getAllChoixforSondageDate(@PathParam("idSondageDate") long id) {
		// TODO Auto-generated method stub
		String req = "SELECT n FROM PropositionDate r join r.participants p join p.choix n WHERE r.id = :idSondageDate";
		return EntityManagerHelper.getEntityManager().createQuery(req).setParameter("idSondageDate", id)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/SondageLieu/{idSondagelieu}/choix")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ChoixParticipants> getAllChoixforSondageLieu(@PathParam("idSondagelieu") long id) {
		// TODO Auto-generated method stub
		String req = "SELECT n FROM PropositionLieu r join r.participants p join p.choix n WHERE r.id = :idSondagelieu";
		return EntityManagerHelper.getEntityManager().createQuery(req).setParameter("idSondagelieu", id)
				.getResultList();
	}

	/**
	 * get all Participant of sondageDate
	 *
	 * @return List of all Participant of sondageDate
	 */

	@GET
	@Path("/SondageDate/{id}/participantsForSondage")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Participants> getAllParticipantsForSondageDate(@PathParam("id") long id) {
		// TODO Auto-generated method stub
		String req = "SELECT p FROM PropositionDate r join r.participants p WHERE r.id = :id";
		ArrayList<Participants> p =(ArrayList<Participants>)EntityManagerHelper.getEntityManager().createQuery(req).setParameter("id", id)
				.getResultList();
		return p;
	}

	/**
	 * get all Participant of sondageLieu
	 *
	 * @return List of all Participant of sondageLieu
	 */
	@SuppressWarnings("unchecked")
	@GET
	@Path("/SondageLieu/{idSondagelieu}/participants")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Participants> getAllParticipantsForSondageLieu(@PathParam("idSondagelieu") long id) {
		// TODO Auto-generated method stub
		String req = "SELECT p FROM PropositionLieu r join r.participants p WHERE r.id = :idSondagelieu";
		return EntityManagerHelper.getEntityManager().createQuery(req).setParameter("idSondagelieu", id)
				.getResultList();
	}

	/**
	 * get sondageDate
	 * 
	 * @param idSondageDate
	 * @return sondageDate of type PropositionDate
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/SondageDate/{idSondageDate}")
	public PropositionDate getSondageDate(@PathParam("idSondageDate") long id) {
		// TODO Auto-generated method stub
		String req = "SELECT r FROM PropositionDate r WHERE r.id = :idSondageDate";
		return (PropositionDate) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idSondageDate", id).getSingleResult();
	}

	/**
	 * get sondageLieu
	 * 
	 * @param idSondageLieu
	 * @return sondageDate of type PropositionDate
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/SondageLieu/{idSondageLieu}")
	public PropositionLieu getSondageLieu(@PathParam("idSondageLieu") long id) {
		// TODO Auto-generated method stub
		String req = "SELECT r FROM PropositionLieu r WHERE r.id = :idSondageDate";
		return (PropositionLieu) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idSondageLieu", id).getSingleResult();
	}

	/**
	 * delete sondageDate
	 * 
	 * @param idSondage
	 *
	 */
	@DELETE
	@Path("/SondageDate/delete/{idsondage}")
	public void deleteSondageDateById(@PathParam("idsondage") long idsondage) {
		// TODO Auto-generated method stub
		String req = "SELECT r FROM PropositionDate r WHERE r.id = :idsondage";
		PropositionDate p = (PropositionDate) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idsondage", idsondage).getSingleResult();
		if (p != null) {
			List<Participants> ps = p.getParticipants();
			for (Participants pa : ps) {
				pa.setSondage(null);
				;
			}
			this.sondageDate.deletesondage(idsondage);
			;
		}
	}

	/**
	 * delete SondageLieu by id
	 * 
	 * @param idSondage
	 *
	 */
	@DELETE
	@Path("/SondageLieu/delete/{idsondage}")
	public void deleteSondageLieuById(@PathParam("idsondage") long idsondage) {
		// TODO Auto-generated method stub
		String req = "SELECT r FROM PropositionLieu r WHERE r.id = :idsondage";
		PropositionLieu p = (PropositionLieu) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idsondage", idsondage).getSingleResult();
		if (p != null) {
			List<Participants> ps = p.getParticipants();
			for (Participants pa : ps) {
				pa.setSondage(null);
				;
			}
			this.sondageLieu.deletesondage(idsondage);
			;
		}
	}

	/**
	 * add choix by participant in the sondage
	 * 
	 * @param idchoix
	 * @param mail
	 *
	 */
	@DELETE
	@Path("participant/{mail}/choix/delete/{idChoix}")
	public void deleteChoixById(@PathParam("mail") String mail, @PathParam("idChoix") long idChoix) {
		// TODO Auto-generated method stub
		String req = "SELECT p FROM Participants r join r.choix p WHERE r.mail = :mail and p.idChoix= :idChoix";
		ChoixParticipants cp = (ChoixParticipants) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idChoix", idChoix).setParameter("mail", mail).getSingleResult();
		if (cp != null) {

			Participants participant = cp.getParticipant();
			participant.setChoix(null);
			this.choixDao.delete(idChoix);
			;
		}
	}

	/**
	 * delete participant in the sondagedate
	 * 
	 * @param idSondageDate
	 * @param mail
	 *
	 */
	@DELETE
	@Path("/participant/SondageDate/{idSondageDate}/participant/{mail}")
	public void deleteParticipantByMailForSondageDate(@PathParam("idSondageDate") long idSondageDate,
			@PathParam("mail") String mail) {
		// TODO Auto-generated method stub
		String req = "SELECT p FROM PropositionDate r join r.participants p WHERE p.mail = :mail and r.id= :idSondageDate";

		Participants cp = (Participants) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("idSondageDate", idSondageDate).setParameter("mail", mail).getSingleResult();
		if (cp != null) {

			PropositionDate sondageDate = (PropositionDate) cp.getSondage();
			sondageDate.setParticipants(null);
			this.participant.deleteParticipants(mail);
		}
	}


	/**
	 * delete participant in the sondagedate
	 * 
	 * @param idSondageDate
	 * @param mail
	 *
	 */
	
	@DELETE
	@Path("/participant/SondageLieu/{idSondageLieu}/participant/{mail}")
	public void deleteParticipantByMailForSondageLieu(long idSondagelieu, String mail) {
		// TODO Auto-generated method stub
		String req = "SELECT p FROM PropositionLieu r join r.participants p WHERE p.mail = :mail and r.id= :idSondageLieu";
		Participants cp = (Participants) EntityManagerHelper.getEntityManager().createQuery(req)
				.setParameter("id", idSondagelieu).setParameter("mail", mail).getSingleResult();
		if (cp != null) {

			PropositionLieu sondagelieu = (PropositionLieu) cp.getSondage();
			sondagelieu.setParticipants(null);
			this.participant.deleteParticipants(mail);
		}
	}

	
	

	

}
