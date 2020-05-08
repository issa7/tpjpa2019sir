package domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
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

	public Alimentation(Participants participant) {
		super();
		this.participant = participant;
	}

	public Alimentation(String libellePreferenceAlimentation) {
		LibellePreferenceAlimentation = libellePreferenceAlimentation;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	//@JsonIgnore
	//@JsonProperty("participant")
	 
	@ManyToOne
	@JsonIgnore
	public Participants getParticipant() {
		return participant;
	}

	public void setParticipant(Participants participant) {
		this.participant = participant;
	}

}
