
package domain;

import domain.Createur;
import domain.Participants;
import domain.PropositionDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="sondage_type")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sondage {

	private Long id;
	protected String nomSondage;

	protected List<Participants> participants = new ArrayList<Participants>();
	protected Createur utilisateur;
	public Sondage () {
		
	}
	public Sondage(String nomSondage) {
		this.nomSondage = nomSondage;
	}
	
	public Sondage(String nomSondage, Createur utilisateur) {
		super();
		this.nomSondage = nomSondage;
		this.utilisateur = utilisateur;
	}

	public Sondage(String nomSondage, List<Participants> participants,
			Createur utilisateur) {
		super();
		this.nomSondage = nomSondage;
		
		this.participants = participants;
		this.utilisateur = utilisateur;
	}

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "sondage")
	public List<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
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
