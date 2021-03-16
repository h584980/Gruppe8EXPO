package no.hvl.dat109;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StandOgStemmeDAO {
	
	@PersistenceContext(name = "expo2020PU")
    private EntityManager em;
	
	public List<Stand> hentAlleStand() {
		return em.createQuery("SELECT s FROM Stand s", Stand.class).getResultList();
	}
	
	public boolean finnesStand(String navn) {
		return hentAlleStand()
				.stream()
				.anyMatch(stand -> stand.getNavn().equals(navn));
	}
	
	public Stand hentStand(String navn) {
		if(finnesStand(navn)) {
			return em.find(Stand.class, navn);
		}
		return null;
	}
	
	public void lagreNyttStand(Stand nyttStand) {
		if (!finnesStand(nyttStand.getNavn())) {
			em.persist(nyttStand);
		}
	}
	
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

}
