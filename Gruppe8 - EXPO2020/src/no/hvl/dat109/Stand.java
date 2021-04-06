package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(schema = "expo2020", name = "stand")
public class Stand {

    @Id
    private String navn;
   
    @OneToMany(mappedBy = "stand")
    private List<Stemme> stemmer;
    
    @ManyToOne
	@PrimaryKeyJoinColumn(name="arrangementNavn", referencedColumnName = "navn")
	private Arrangement arrangement;
    
    private String arrangementNavn;
    
    @Transient
    private double snittStemme;
    
    @Transient
	private int totalsum, antallStemmer, antall0, antall1, antall2, antall3, antall4, antall5, flestStemmer;
    
    public Stand(String navn) {
		this.navn = navn;
	}
    
	public Stand() {
		super();
	}

	public String getNavn() {
		return navn;
	}

	public List<Stemme> getStemmer() {
		return stemmer;
	}
	
	public void setStemmer(List<Stemme> stemmer) {
		this.stemmer = stemmer;
	}
	
	public String getArrangementNavn() {
		return arrangementNavn;
	}

	public int getFlestStemmer() {
		return flestStemmer;
	}

	public double getSnittStemme() {
		return snittStemme;
	}
	
	public int getAntallStemmer() {
		return antallStemmer;
	}
	
	public int getTotalsum() {
		return totalsum;
	}

	public int getAntall0() {
		return antall0;
	}

	public int getAntall1() {
		return antall1;
	}

	public int getAntall2() {
		return antall2;
	}

	public int getAntall3() {
		return antall3;
	}

	public int getAntall4() {
		return antall4;
	}

	public int getAntall5() {
		return antall5;
	}

	public void kalkulerPoengdata() {
		kalkulerSnittStemmer();
		kalkulerAntallStemmer();
		kalkulerTotalsum();
		kalkulerAntallAvHverVerdi();
		kalkulerVerdiMedFlestStemmer();
	}

	private void kalkulerVerdiMedFlestStemmer() {
		
		List<Integer> verdier = new ArrayList<Integer>();
		verdier.add(antall1);
		verdier.add(antall2);
		verdier.add(antall3);
		verdier.add(antall4);
		verdier.add(antall5);
		flestStemmer = verdier.stream().mapToInt(i -> i).max().orElse(1);
	}

	private void kalkulerSnittStemmer() {
		this.snittStemme = Math.round(stemmer.stream()
				.mapToInt(Stemme::getVerdi)
				.filter(s -> s != 0)
				.average()
				.orElse(0)
				*100.0
				)/100.0;
	}
	
	private void kalkulerAntallStemmer() {
		this.antallStemmer = (int) stemmer
				.stream()
				.map(Stemme::getVerdi)
				.filter(s -> s != 0)
				.count();
	}
	
	private void kalkulerTotalsum() {
		totalsum = stemmer.stream().mapToInt(Stemme::getVerdi).sum();

	}
	
	private void kalkulerAntallAvHverVerdi() {
		antall0 = antallAvVerdi(0);
		antall1 = antallAvVerdi(1);
		antall2 = antallAvVerdi(2);
		antall3 = antallAvVerdi(3);
		antall4 = antallAvVerdi(4);
		antall5 = antallAvVerdi(5);
		
	}
	
	private int antallAvVerdi(int verdi) {
		return (int) stemmer.stream().mapToInt(Stemme::getVerdi).filter(s -> s==verdi).count();
	}
	
	@Override
	public String toString() {
		return "Stand:" + navn;
	}
	

}
