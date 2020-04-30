
package domain;

import domain.Createur;
import domain.Participants;
import domain.PropositionDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private Reunion reunion;
    private ResultatSondage resultatSondage;
	

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
	@Transient
	public ResultatSondage getResultatSondage() {
		return resultatSondage;
	}

	public void setResultatSondage(ResultatSondage resultatSondage) {
		this.resultatSondage = resultatSondage;
	}
	public String getNomSondage() {
		return nomSondage;
	}

	public void setNomSondage(String nomSondage) {
		this.nomSondage = nomSondage;
	}
@Transient
	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

//	@OneToMany(mappedBy = "sondage")
	@Transient
	public List<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
	}

//	@OneToMany(mappedBy = "sondages")
	@Transient
	public List<PropositionDate> getDates() {
		return dates;
	}

	public void setDates(List<PropositionDate> dates) {
		this.dates = dates;
	}

//	@OneToOne
	@Transient
	public Createur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Createur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
