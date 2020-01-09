package jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Sondage {
	
	private Long id;
	private Date resulttSondage;
	private Collection <Dates> datesProposes;
	private List<Participants> participants = new ArrayList<Participants>();
    
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
	@OneToMany(mappedBy = " dates")
	public Collection<Dates> getDatesProposes() {
		return datesProposes;
	}
	public void setDatesProposes(Collection<Dates> datesProposes) {
		this.datesProposes = datesProposes;
	}
	@OneToMany (mappedBy = " participant")
	public List<Participants> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
	}


}
