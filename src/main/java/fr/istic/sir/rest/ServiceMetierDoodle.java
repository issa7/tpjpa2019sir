package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.core.Response;

import domain.Alimentation;
import domain.Createur;
import domain.Participants;
import domain.Sondage;

public interface ServiceMetierDoodle {
	void createSondage(String mail, Sondage s);
	Collection<Createur> getAllCreateurs();
	Createur createCreateur(Createur U);
	Createur getCreateur(String mail);
	Response deleteCreateur(String mail);
	Alimentation addAlimentation(Alimentation A);
	Participants AddParticipant(Participants P);
}
