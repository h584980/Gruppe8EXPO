package no.hvl.dat109;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StandOgStemmeDAO {
	
	@PersistenceContext(name = "expo2020PU")
    private EntityManager em;
	
	public List<Stand> hentAlleStandFraArrangement(String arrangement) {
		List<Stand> liste = em.createQuery("SELECT s FROM Stand s", Stand.class).getResultList();
		
		liste = liste.stream().filter(s -> s.getArrangementNavn().equals(arrangement)).collect(Collectors.toList()); 
		
		for (Stand stand : liste) {
	    	List<Stemme> stemmer= hentAlleStemmerForStand(stand);
			stand.setStemmer(stemmer);
			stand.kalkulerPoengdata();
		}
	    
	    liste = liste
    			.stream()
    			.sorted(Comparator.comparing(Stand::getSnittStemme)
    					.thenComparing(Stand::getAntallStemmer))
    			.collect(Collectors.toList()); 
	    //
		Collections.reverse(liste);
		//
		liste = liste
	    			.stream()
	    			.sorted(Comparator.comparing(Stand::getNavn))
	    			.collect(Collectors.toList()); 
	    
	    return liste;
	}
	
	public boolean finnesStand(String navn, String arrangement) {
		return hentAlleStandFraArrangement(arrangement)
				.stream()
				.anyMatch(stand -> stand.getNavn().equals(navn));
	}
	
	public Stand hentStand(String navn, String arrangement) {
		if(finnesStand(navn, arrangement)) {
			Stand stand = em.find(Stand.class, navn);
			List<Stemme> stemmer = hentAlleStemmerForStand(stand);
			stand.setStemmer(stemmer);
			stand.kalkulerPoengdata();
			return stand;
		}
		return null;
	}
	
	public void lagreNyttStand(Stand nyttStand, String arrangement) {
		if (!finnesStand(nyttStand.getNavn(), arrangement)) {
			em.persist(nyttStand);
		}
	}
	
	// prøv å gjøre denne som i F17
	public List<Stemme> hentAlleStemmerForStand(Stand stand) {
		List<Stemme> alleStemmerList = em.createQuery("SELECT s FROM Stemme s", Stemme.class).getResultList();
		return alleStemmerList.stream().filter(s -> s.getStandNavn().equals(stand.getNavn())).collect(Collectors.toList());   
	}
	
	public List<Stemme> hentAlleStemmer() {
		return em.createQuery("SELECT s FROM Stemme s", Stemme.class).getResultList();

	}
	
	public boolean finnesStemme(String uniqueID) {
		return hentAlleStemmer()
				.stream()
				.anyMatch(stemme -> stemme.getId().equals(uniqueID));
	}
	
	public void oppdaterStemmeVerdi(String uniqueId, Integer verdi) {
		
		Stemme stemme = em.find(Stemme.class, uniqueId);

		stemme.setVerdi(verdi);
		em.merge(stemme);
	}
	

	public void lagreNyStemme(Stemme nyStemme) {
			em.persist(nyStemme);
	}
	
	public void lagreNyttArrangement(Arrangement nyttArrangement) {
		em.persist(nyttArrangement);
	}
	
	public List<Arrangement> hentAlleArrangement() {
		List<Arrangement> liste = em.createQuery("SELECT s FROM Arrangement s", Arrangement.class).getResultList();
	    
	    return liste;
	}
	
	public boolean finnesArrangement(String navn) {
		return hentAlleArrangement()
				.stream()
				.anyMatch(a -> a.getNavn().equals(navn));
	}
	
	public Arrangement hentArrangement(String navn) {
		if(finnesArrangement(navn)) {
			Arrangement a = em.find(Arrangement.class, navn);
			return a;
		}
		return null;
	}

}
