package jpa;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Personne {
	@Id
	private Long id;
	private String nom;
	private String prenom;
    private String mail;
	private String alergie;
	private String aliment;
}
