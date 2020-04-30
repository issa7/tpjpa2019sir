package domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("createur")
public class Createur extends Personne {
    
	private Long id; 
	
	private List<Sondage> sondage;
	
	private List <Reunion>  reunion;
	
	
public Createur(List<Sondage> sondage, List<Reunion> reunion) {
		super();
		this.sondage = sondage;
		this.reunion = reunion;
	}
//	/* cette relation est le proprietaire car il contient la clé etrangère le nom de 
//	 * l'assiation est createurReunion*/
//	@OneToMany(mappedBy = "createurReunion",cascade = CascadeType.PERSIST)
   @Transient
	public List<Reunion> getReunion() {
		return reunion;
	}
	public void setReunion(List<Reunion> reunion) {
		this.reunion = reunion;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
//	/* cette relation est le proprietaire car il contient la clé etrangère le nom de 
//	 * l'assiation est createur*/
//   @OneToMany(mappedBy = "createur",cascade = CascadeType.PERSIST)
	@Transient
	public List<Sondage> getSondage() {
		return sondage;
	}

	public void setSondage(List<Sondage> sondage) {
		this.sondage = sondage;
	}

}


