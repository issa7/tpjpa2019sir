package jpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("U")
public class User extends Personne  {

	private Long id; 
	private Sondage sondage;
	private Reunion reunion;
	
	@OneToOne
	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    @OneToOne(mappedBy="utilisateur")
	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}
	
	
	
}
