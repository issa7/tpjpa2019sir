package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("createur")
public class Createur extends Personne {
	private String mail;
	

	
	private Collection<Sondage> sondage = new ArrayList<Sondage>();

	public Createur(List<Sondage> sondage) {
		super();
		this.sondage = sondage;

	}
	@Id
	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
	@OneToMany(mappedBy = "createur",cascade = CascadeType.PERSIST)
	public Collection<Sondage> getSondage() {
		return sondage;
	}

	public void setSondage(Collection<Sondage> sondage) {
		this.sondage = sondage;
	}

}
