package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class ChoixParticipants {
	
    private Long idChoix;
    private Date choix;
    private PropositionDate propo;
    
	public ChoixParticipants(Date choix) {
		this.choix = choix;
	}
	@Id
    @GeneratedValue
	public Long getIdChoix() {
		return idChoix;
	}
	public void setIdChoix(Long idChoix) {
		this.idChoix = idChoix;
	}
	 @Temporal(TemporalType.DATE)
	public Date getChoix() {
		return choix;
	}
	public void setChoix(Date choix) {
		this.choix = choix;
	}
	@Transient
	public PropositionDate getPropo() {
		return propo;
	}
	public void setPropo(PropositionDate propo) {
		this.propo = propo;
	}
}
