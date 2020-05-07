package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("createur")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Createur extends Personne {
	private String mail;
	private String nom;
	private String prenom;
	private String pass;
  
	// private
	private List<Sondage> sondage = new ArrayList<Sondage>();

	public Createur(List<Sondage> sondage) {
		super();
		this.sondage = sondage;

	}

	public Createur(String mail, String nom, String prenom,String pass) {
		super();
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.pass = pass;
	}

	public Createur() {
		
	}

	@Id
	@Column(name = "CREATEUR_ID")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@OneToMany(mappedBy = "utilisateur")
//	@JoinTable(name = "CREATEUR_SONDAGE", joinColumns = {
//			@JoinColumn(name = "CREATEUR_ID", referencedColumnName = "CREATEUR_ID") }, inverseJoinColumns = {
//					@JoinColumn(name = "Sondage_id", referencedColumnName = "ID", unique = true) })
	public List<Sondage> getSondage() {
		return sondage;
	}

	public void setSondage(List<Sondage> sondage) {
		this.sondage = sondage;
	}
	 public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getMotPass() {
			return pass;
		}

		public void setMotPass(String motPass) {
			pass = motPass;
		}

}
