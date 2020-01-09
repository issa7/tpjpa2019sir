package jpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("P")
public class Participants extends Personne {

	private String nom;
	private String prenom;
    private Sondage sondage;


	private String mail;
	private String alergie;
	private String aliment;
	
    private Reunion reunion;
    
    @ManyToOne
	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

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
	@ManyToOne
	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

}
