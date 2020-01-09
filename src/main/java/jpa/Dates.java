package jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Dates {
	
	private Long id;
	private Date date1;
	private Sondage sondages;
	
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
	

}
