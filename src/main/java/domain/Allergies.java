package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Allergies {
	
	private Long id;
	private String libelleAllergie;
	
	public Allergies( String libelleAllergie) {
		this.libelleAllergie = libelleAllergie;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelleAllergie() {
		return libelleAllergie;
	}
	public void setLibelleAllergie(String libelleAllergie) {
		this.libelleAllergie = libelleAllergie;
	}
}
