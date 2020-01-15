
package jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Sondage {

	private Long id;
	@Temporal( TemporalType.DATE)
	private Date resulttSondage;
	@Temporal( TemporalType.DATE)
	 
	private List<Dates> dates  = new ArrayList <Dates>(); 
	private List<Participants> participants = new ArrayList<Participants>();
	private User utilisateur; 



	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getResulttSondage() {
		return resulttSondage;
	}

	public void setResulttSondage(Date resulttSondage) {
		this.resulttSondage = resulttSondage;
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

	@OneToMany(mappedBy = "sondage")
	public List<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
	}
	
	@OneToMany(mappedBy = "sondages")
	public List<Dates> getDates() {
		return dates;
	}
	public void setDates(List<Dates> dates) {
		this.dates = dates;
	}
	
    @OneToOne 
	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}

}
