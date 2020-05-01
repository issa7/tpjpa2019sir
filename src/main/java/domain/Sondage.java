
package domain;

import domain.Createur;
import domain.Participants;
import domain.PropositionDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Sondage {

	private Long id;
	private String nomSondage;

	private List<PropositionDate> dates = new ArrayList<PropositionDate>();
	private List<Participants> participants = new ArrayList<Participants>();
	private Createur utilisateur;

	public Sondage(String nomSondage, List<PropositionDate> dates) {
		this.nomSondage = nomSondage;
		this.dates = dates;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	@Column
//	@ElementCollection(targetClass=Dates.class)
//	@OneToMany(mappedBy = "sondages", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//	public List<Date> getDatesProposes() {
//		return dates;
//	}

//	public void setDatesProposes(List<Date> datesProposes) {
//		this.dates = datesProposes;
//	}

	public String getNomSondage() {
		return nomSondage;
	}

	public void setNomSondage(String nomSondage) {
		this.nomSondage = nomSondage;
	}

@ManyToMany(mappedBy = "sondage")
	public List<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
	}

	@OneToMany(mappedBy = "sondages", cascade = CascadeType.PERSIST)
	public List<PropositionDate> getDates() {
		return dates;
	}

	public void setDates(List<PropositionDate> dates) {
		this.dates = dates;
	}

	/*
	 * lazy permet de recuperer les donnée si cela est necessaire les associations
	 * se termine par one ont besoin de Lazy
	 */
	@ManyToOne
	public Createur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Createur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
