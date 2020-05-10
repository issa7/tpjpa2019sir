package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.core.Response;

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

public interface ServiceMetierDoodle {
	void createSondage(String mail, PropositionDate s);
	Collection<Createur> getAllCreateurs();
	Createur createCreateur(Createur U);
	Createur getCreateur(String mail);
	Response deleteCreateur(String mail);
	void addAlimentation(String mail,Alimentation A);
	void addAllergie(String Mail,Allergies allergie);
	Participants AddParticipant(Participants P);
	Collection<Participants>getAllParticipant();
	Collection<Alimentation> getAllAlimentation();
	Collection<PropositionDate> getAllSondageDate();
	void creatSondageLieu(String mail, PropositionLieu lieu);
	Collection<PropositionLieu> getAllSondageLieu();
	void addParticipantSondage(long id,Participants participant);
	void addDateSondageForPropositionDate(long id, DateSondage date);
	void addLieuSondageForPropositionLieu(long id, LieuSondage lieu);
	void addChoixforSondageDate(long id,String mail,ChoixParticipants choix);
	void addReunionForSondageDate(long id, Reunion r);
	Collection<Reunion>getAllreunion();
	Collection<Sondage>getAllSondageForCreateur(String mail);
	Collection<ChoixParticipants>getAllChoixforSondageDate(long id);
	Collection<ChoixParticipants>getAllChoixforSondageLieu(long id);
	Collection<Participants> getAllParticipantsForSondageDate(long id);
	Collection<Participants> getAllParticipantsForSondageLieu(long id);
	PropositionDate getSondageDate(long id);
	void deleteSondageDateById(long idsondage);
	void deleteChoixById(String mail, long idChoix);
	
}
