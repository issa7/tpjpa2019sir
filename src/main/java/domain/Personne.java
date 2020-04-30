package domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Personne {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
}
