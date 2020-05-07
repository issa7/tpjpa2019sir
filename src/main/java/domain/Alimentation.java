package domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Alimentation {

	private Long id;
	private String LibellePreferenceAlimentation;

	private Participants participant = new Participants();
    
	public Alimentation() {
	
	}

	public Alimentation(String libellePreferenceAlimentation, Participants participant) {
		super();
		LibellePreferenceAlimentation = libellePreferenceAlimentation;
		this.participant = participant;
	}

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

	/*
	 * lazy permet de recuperer les donnée si cela est necessaire les associations
	 * se termine par one ont besoin de Lazy
	 */
	@JsonProperty(value = "participant_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "participant_id")
	public Participants getParticipant() {
		return participant;
	}

	public void setParticipant(Participants participant) {
		this.participant = participant;
	}

}
