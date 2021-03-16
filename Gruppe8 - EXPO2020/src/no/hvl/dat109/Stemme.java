package no.hvl.dat109;


import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity 
@Table(schema = "expo2020", name = "Stemme")
public class Stemme {
	
	@Id
	String id;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="standNavn", referencedColumnName = "navn")
	private Stand stand;
	
	private String standNavn;
	
	private Integer verdi;
	 
	public Stemme(String standNavn, Integer verdi, String id) {
		this.standNavn = standNavn;
		this.id = id;
		this.verdi = verdi;
	}

	public Stemme() {
		super();
	}
	
	public String getStandNavn() {
		return standNavn;
	}
	
	public String getId() {
		return id;
	}
	
	public Integer getVerdi() {
		return verdi;
	}
	
	public void setVerdi(Integer verdi) {
		this.verdi = verdi;
	}
	 
	
}
