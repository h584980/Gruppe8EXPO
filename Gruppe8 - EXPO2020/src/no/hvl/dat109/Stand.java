package no.hvl.dat109;

import java.util.List;

import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "expo2020", name = "stand")
public class Stand {

    @Id
    private String navn;
   
    @OneToMany(mappedBy = "stand") //, fetch = FetchType.EAGER)
    private List<Stemme> stemmer;
    
    private double snittStemme;
    private int antallStemmer;
    
    public Stand(String navn) {
		this.navn = navn;
		snittStemme = 0;
		antallStemmer = 0;
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
	
	public double getSnittStemme() {
		return snittStemme;
	}
	

	public int getAntallStemmer() {
		return antallStemmer;
	}

	public void kalkulerSnittStemmer() {
		this.snittStemme = getAverageScore();
	}
	
	public void kalkulerAntallStemmer() {
		this.antallStemmer = getVoteCount();
	}
	
	private double getAverageScore() {
		double totalScore = 0;
		int antallNuller = 0;
		if (!(getVoteCount() == 0)) {
			for (Stemme stemme : stemmer) {
				if (stemme.getVerdi() == 0) {
					antallNuller++;
				} else {
					totalScore += stemme.getVerdi();
				}
			}
			return Math.round(totalScore/(getVoteCount()-antallNuller)*100.0)/100.0;
		}
		return 0;
	}
	
	private int getVoteCount() {
		return stemmer.size();
	}

}
