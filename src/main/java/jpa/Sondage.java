
package jpa;

import java.util.ArrayList;
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
	private List<Dates> dates;
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

	@OneToMany(mappedBy = "sondages")
	public List<Dates> getDatesProposes() {
		return dates;
	}

	public void setDatesProposes(List<Dates> datesProposes) {
		this.dates = datesProposes;
	}

	@OneToMany(mappedBy = "sondage")
	public List<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
	}

}
