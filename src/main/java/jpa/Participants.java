package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Participants {

	private String nom;
	private String prenom;

	private String mail;
	private String alergie;
	private String aliment;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Id
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAlergie() {
		return alergie;
	}

	public void setAlergie(String alergie) {
		this.alergie = alergie;
	}

	public String getAliment() {
		return aliment;
	}

	public void setAliment(String aliment) {
		this.aliment = aliment;
	}

}
