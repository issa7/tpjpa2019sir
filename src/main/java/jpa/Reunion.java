package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reunion {
	private Long id;
	private String intitule;
	private String resume;
	private List<Participants> participant = new ArrayList<Participants>();
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	@OneToMany(mappedBy="reunion")
	public List<Participants> getParticipant() {
		return participant;
	}
	public void setParticipant(List<Participants> participant) {
		this.participant = participant;
	}

	

}
