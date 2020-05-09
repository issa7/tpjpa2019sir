package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DateSondage {
	private long id;
	private Date date;
    private PropositionDate propostiondate;
	

	public DateSondage(Date date, PropositionDate propostiondate) {
		super();
		this.date = date;
		this.propostiondate = propostiondate;
	}

	public DateSondage() {
		super();
	}

	public DateSondage(Date date) {
		super();
		this.date = date;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    @ManyToOne
    @JsonIgnore
	public PropositionDate getPropostiondate() {
		return propostiondate;
	}

	public void setPropostiondate(PropositionDate propostiondate) {
		this.propostiondate = propostiondate;
	}
}
