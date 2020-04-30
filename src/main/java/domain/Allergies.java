package domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Allergies {
	
	private Long id;
	private String libelleAllergie;
	private Participants participant;
	
	public Allergies( String libelleAllergie) {
		this.libelleAllergie = libelleAllergie;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelleAllergie() {
		return libelleAllergie;
	}
	public void setLibelleAllergie(String libelleAllergie) {
		this.libelleAllergie = libelleAllergie;
	}
	/*lazy permet de recuperer les donnée si cela est necessaire
	 * les associations se termine par one ont besoin de Lazy*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "participantAllergie_id")
	public Participants getParticipant() {
		return participant;
	}
	public void setParticipant(Participants participant) {
		this.participant = participant;
	}
}
