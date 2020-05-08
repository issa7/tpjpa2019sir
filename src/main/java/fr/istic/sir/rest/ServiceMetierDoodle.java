package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.core.Response;

import domain.Alimentation;
import domain.Allergies;
import domain.Createur;
import domain.Participants;
import domain.PropositionDate;
import domain.PropositionLieu;
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
}
