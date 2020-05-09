package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("SondageDate")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropositionDate extends Sondage {

	private List<DateSondage> date1 = new ArrayList<DateSondage>();
	private List<ChoixParticipants> choix;

	public PropositionDate() {
		super();
	}

	public PropositionDate(List<DateSondage> date1) {
		super();
		this.date1 = date1;
	}

//	@Temporal(TemporalType.DATE)
//	public Date getDate1() {
//		return date1;
//	}
//
//	public void setDate1(Date date1) {
//		this.date1 = date1;
//	}

	@OneToMany(mappedBy = "propo")
	public List<ChoixParticipants> getChoix() {
		return choix;
	}
	@OneToMany(mappedBy = "propostiondate",fetch = FetchType.LAZY )
	public List<DateSondage> getDate1() {
		return date1;
	}

	public void setDate1(List<DateSondage> date1) {
		this.date1 = date1;
	}

	public void setChoix(List<ChoixParticipants> choix) {
		this.choix = choix;
	}

}
