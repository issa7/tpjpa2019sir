package domain;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class ResultatSondage {
	private Long id;
	private Date Resulat;
	private Sondage sondage;

	public ResultatSondage(Date resulat, Sondage sondage) {
		Resulat = resulat;
		this.sondage = sondage;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getResulat() {
		return Resulat;
	}

	public void setResulat(Date resulat) {
		Resulat = resulat;
	}
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SONDAGE_ID")
	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

}
