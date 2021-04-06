package no.hvl.dat109;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(schema = "expo2020", name = "arrangement")
public class Arrangement {
	
	@Transient
	private String juryPassord;
	
	@Id
	private String navn;
		
	private Date startDato, sluttDato;
	
	private Time startTid, sluttTid;
	
	@OneToMany(mappedBy = "arrangement")
	private List<Stand> alleStand;
	
	public Arrangement(String navn, Date startDato, Date sluttDato, Time startTid, Time sluttTid) {
		this.navn = navn;
		this.startDato = startDato;
		this.sluttDato = sluttDato;
		this.startTid = startTid;
		this.sluttTid = sluttTid;
	}
	
	public Arrangement() {
		super();
	}
	
	public List<Stand> getStand() {
		return alleStand;
	}
	
	public void setStemmer(List<Stand> alleStand) {
		this.alleStand = alleStand;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public Date getStartDato() {
		return startDato;
	}

	public void setStartDato(Date startDato) {
		this.startDato = startDato;
	}

	public Date getSluttDato() {
		return sluttDato;
	}

	public void setSluttDato(Date sluttDato) {
		this.sluttDato = sluttDato;
	}

	public Time getStartTid() {
		return startTid;
	}

	public void setStartTid(Time startTid) {
		this.startTid = startTid;
	}

	public Time getSluttTid() {
		return sluttTid;
	}

	public void setSluttTid(Time sluttTid) {
		this.sluttTid = sluttTid;
	}

	@Override
	public String toString() {
		return "Arrangement [navn=" + navn + ", startDato=" + startDato.toString() + ", sluttDato=" + sluttDato.toString() + ", startTid="
				+ startTid.toString() + ", sluttTid=" + sluttTid.toString() + "]";
	}
	
	

	
}
