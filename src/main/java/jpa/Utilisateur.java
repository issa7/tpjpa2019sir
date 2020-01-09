package jpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("U")
public class Utilisateur extends Personne  {

	private Long id; 
	private Sondage sondage;
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}
	
	
	
}
