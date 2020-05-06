package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("PARTICIPANT")
public class Participants extends Personne {
	
	private String mail;
	private String nom;
	private String prenom;
	private String Motpass;
	
	private List<Sondage> sondage;
	private List<ChoixParticipants> choix = new ArrayList<ChoixParticipants>();
	private List<Alimentation>PreferenceAliment = new ArrayList<Alimentation>();
	private List<Allergies> allergie = new ArrayList<Allergies>();
	public Participants(List<Sondage> sondage, List<ChoixParticipants> choix, List<Alimentation> preferenceAliment,
			List<Allergies> allergie) {
		super();
		this.sondage = sondage;
		this.choix = choix;
		PreferenceAliment = preferenceAliment;
		this.allergie = allergie;
	}
	@Id
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@ManyToMany
	public List<Sondage> getSondage() {
		return sondage;
	}
	public void setSondage(List<Sondage> sondage) {
		this.sondage = sondage;
	}
	@OneToMany(mappedBy="participant", cascade = CascadeType.PERSIST)
	public List<ChoixParticipants> getChoix() {
		return choix;
	}
	public void setChoix(List<ChoixParticipants> choix) {
		this.choix = choix;
	}
	@OneToMany(mappedBy = "participant",cascade = CascadeType.PERSIST)
	public List<Alimentation> getPreferenceAliment() {
		return PreferenceAliment;
	}
	public void setPreferenceAliment(List<Alimentation> preferenceAliment) {
		PreferenceAliment = preferenceAliment;
	}
	@OneToMany(mappedBy="participant", cascade = CascadeType.PERSIST)
	public List<Allergies> getAllergie() {
		return allergie;
	}
	public void setAllergie(List<Allergies> allergie) {
		this.allergie = allergie;
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
	public String getMotpass() {
		return Motpass;
	}
	public void setMotpass(String motpass) {
		Motpass = motpass;
	}
	public void addChoix(ChoixParticipants choix1) {
		choix.add(choix1);
		choix1.setParticipant(this);
	}
	public void removechoix(ChoixParticipants choix2) {
		choix.remove(choix2);
		choix2.setChoix(null);
	}
	public void addpreferAlimenataire(Alimentation preference) {
		PreferenceAliment.add(preference);
		preference.setParticipant(this);
	}
	public void removePreferAlimenataire(Alimentation preference) {
		PreferenceAliment.add(preference);
		preference.setParticipant(null);
	}
	public void addAllergie(Allergies allergies) {
		allergie.add(allergies);
		allergies.setParticipant(this);
	}
}
