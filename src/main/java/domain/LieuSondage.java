package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class LieuSondage {
	private long id;
	private String lieuSondage;
	private PropositionLieu propoLieu;

	public LieuSondage(String lieuSondage, PropositionLieu propoLieu) {
		super();
		this.lieuSondage = lieuSondage;
		this.propoLieu = propoLieu;
	}

	public LieuSondage(String lieuSondage) {
		super();
		this.lieuSondage = lieuSondage;
	}

	public LieuSondage(PropositionLieu propoLieu) {
		super();
		this.propoLieu = propoLieu;
	}

	public LieuSondage() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getLieuSondage() {
		return lieuSondage;
	}

	public void setLieuSondage(String lieuSondage) {
		this.lieuSondage = lieuSondage;
	}
	@ManyToOne
    @JsonIgnore
	public PropositionLieu getPropoLieu() {
		return propoLieu;
	}

	public void setPropoLieu(PropositionLieu propoLieu) {
		this.propoLieu = propoLieu;
	}

}
