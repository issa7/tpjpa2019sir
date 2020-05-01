package domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PropositionDate {
	
	private Long id;
	private Date date1;
	private Sondage sondages;
	private List<ChoixParticipants> choix;
	

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	
	@ManyToOne
	public Sondage getSondages() {
		return sondages;
	}
	public void setSondages(Sondage sondage) {
		this.sondages = sondage;
	}
	@OneToMany(mappedBy = "propo")
	public List<ChoixParticipants> getChoix() {
		return choix;
	}

	public void setChoix(List<ChoixParticipants> choix) {
		this.choix = choix;
	}
	
	

}
