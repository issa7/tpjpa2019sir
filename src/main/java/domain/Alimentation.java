package domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Alimentation {

	private Long id;
	private String LibellePreferenceAlimentation;
	
    private Participants participant;
	

	public Alimentation(String libellePreferenceAlimentation) {
		LibellePreferenceAlimentation = libellePreferenceAlimentation;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibellePreferenceAlimentation() {
		return LibellePreferenceAlimentation;
	}

	public void setLibellePreferenceAlimentation(String libellePreferenceAlimentation) {
		LibellePreferenceAlimentation = libellePreferenceAlimentation;
	}
	/*lazy permet de recuperer les donnée si cela est necessaire
	 * les associations se termine par one ont besoin de Lazy*/
	@ManyToOne
	public Participants getParticipant() {
		return participant;
	}

	public void setParticipant(Participants participant) {
		this.participant = participant;
	}

}
