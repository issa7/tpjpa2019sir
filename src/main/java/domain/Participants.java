package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("PARTICIPANT")
public class Participants extends Personne {
	
	private String mail;
	private List<Sondage> sondage;
	private List<ChoixParticipants> choix;
	private List<Alimentation>PreferenceAliment;
	private List<Allergies> allergie;
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
	@Transient
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
	
	
}
