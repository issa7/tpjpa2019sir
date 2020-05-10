package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("SondageLieu")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropositionLieu extends Sondage {

	private List<LieuSondage> lieu = new ArrayList<LieuSondage>();
	private List<ChoixParticipants> choix;
	private Reunion reunion = new Reunion();

	
	public PropositionLieu() {
		super();
	}
	@OneToMany(mappedBy = "propoLieu",fetch = FetchType.LAZY )
	public List<LieuSondage> getLieu() {
		return lieu;
	}

	public void setLieu(List<LieuSondage> lieu) {
		this.lieu = lieu;
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
	@OneToOne(fetch=FetchType.LAZY, mappedBy="lieux")
	public Reunion getReunion() {
		return reunion;
	}
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
}
