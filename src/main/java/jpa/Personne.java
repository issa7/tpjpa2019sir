package jpa;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Personne {
	
	private Long id;
	private String nom;
	private String prenom;
    private String mail;
	private String alergie;
	private String aliment;
}
