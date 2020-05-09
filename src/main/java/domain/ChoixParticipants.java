package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChoixParticipants {

	private Long idChoix;
	private Date choix;
	private String Lieu;

	private PropositionDate propo;
	private Participants participant;
     private PropositionLieu note;
	

	public ChoixParticipants(Date choix) {
		this.choix = choix;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdChoix() {
		return idChoix;
	}

	public void setIdChoix(Long idChoix) {
		this.idChoix = idChoix;
	}

	@Temporal(TemporalType.DATE)
	public Date getChoix() {
		return choix;
	}

	public void setChoix(Date choix) {
		this.choix = choix;
	}

	public ChoixParticipants() {
		super();
	}

	@ManyToOne
	public PropositionDate getPropo() {
		return propo;
	}

	public void setPropo(PropositionDate propo) {
		this.propo = propo;
	}

	@ManyToOne
	@JsonIgnore
	public Participants getParticipant() {
		return participant;
	}

	public void setParticipant(Participants participant) {
		this.participant = participant;
	}

	public String getLieu() {
		return Lieu;
	}

	public void setLieu(String lieu) {
		Lieu = lieu;
	}
@ManyToOne
	public PropositionLieu getNote() {
		return note;
	}

	public void setNote(PropositionLieu note) {
		this.note = note;
	}
   
	
}
