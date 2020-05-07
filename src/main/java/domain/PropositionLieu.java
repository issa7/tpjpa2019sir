package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("SondageLieu")
public class PropositionLieu extends Sondage{
   
	private String Lieu;
	private List<ChoixParticipants> choix;
	
	public String getLieu() {
		return Lieu;
	}
	public void setLieu(String lieu) {
		Lieu = lieu;
	}
	public PropositionLieu(String nomSondage) {
		super();
		// TODO Auto-generated constructor stub
	}
	@OneToMany(mappedBy = "note")
	public List<ChoixParticipants> getChoix() {
		return choix;
	}
	public void setChoix(List<ChoixParticipants> choix) {
		this.choix = choix;
	}
}