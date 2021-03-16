package no.hvl.dat109;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

@Stateless
public class InndataValidator {
	
	/**
	 * Metode for å validere inndata (navn og registreringskode) ved registrering av nytt Stand
	 * 
	 * @param dao
	 * @param request
	 * @param navn
	 * @param kode
	 * @return 'true' hvis alle inndata er gyldig, 
	 * 		   'false' hvis minst en av inndatavariablene er ugyldig
	 */
	
	public static boolean valliderAllData(StandOgStemmeDAO dao, HttpServletRequest request, String navn, String kode) {
		
		boolean allDataErGyldig = true;

		if (navn != null && navn.matches("^[A-Za-z0-9ÆØÅæøå]+(((-| )[A-Za-z0-9ÆØÅæøå]+)+)?$") // sjekker at Navn på nytt Stand kunn inneholder gyldig tegn og er av riktig lengde
    			&& navn.length() <= 30 && navn.length() >= 2) {
    		if (!dao.finnesStand(navn)) {	// Sjekker at Stand med samme navn ikke allerede finnes
    			request.setAttribute("gyldigNavn", navn);
			} else {
				request.setAttribute("ugyldigNavn", "Et stand med dette navnet finnes allerede");
    			allDataErGyldig = false;
			}
		} else {
			request.setAttribute("ugyldigNavn", "Navn må være over 2 tegn");
			allDataErGyldig = false;
		}
   
    	if (kode != null && kode.equals("regkode")) { // Sjekker at registreringskode stemmer overens med gyldig hardkodet kode
    		request.setAttribute("gyldigKode", kode);
		} else {
			request.setAttribute("ugyldigKode", "Registreringskoden stemmer ikke");
			allDataErGyldig = false;
		}
   
    	return allDataErGyldig;
	}

}
