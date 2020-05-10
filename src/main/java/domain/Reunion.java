package domain;

import domain.Createur;
import domain.Participants;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Reunion {
	private Long id;
	private String intitule;
	private String resume;
	

    private PropositionLieu lieux;
    private PropositionDate dates;
	

	public Reunion(PropositionDate dates) {
		super();
		this.dates = dates;
	}

	public Reunion(PropositionLieu lieux) {
		super();
		this.lieux = lieux;
	}

	public Reunion() {
		super();
	}

	public Reunion(String intitule, String resume) {
		super();
		this.intitule = intitule;
		this.resume = resume;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	@Transient
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
   
	
	 @OneToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="SondageLieuID")
	 @JsonIgnore
	public PropositionLieu getLieux() {
		return lieux;
	}

	public void setLieux(PropositionLieu lieux) {
		this.lieux = lieux;
	}
	 @OneToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="SondageDateID")
	 @JsonIgnore
	public PropositionDate getDates() {
		return dates;
	}

	public void setDates(PropositionDate dates) {
		this.dates = dates;
	}
	
}
