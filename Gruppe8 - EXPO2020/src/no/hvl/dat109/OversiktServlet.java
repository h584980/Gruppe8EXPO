
package no.hvl.dat109;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "oversikt", urlPatterns = {"/oversiktservlet"})
public class OversiktServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @EJB
    private StandOgStemmeDAO dao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	    List<Stand> liste = dao.hentAlleStand();
    	    
    	    for (Stand stand : liste) {
    	    	List<Stemme> stemmer= dao.hentAlleStemmerForStand(stand);
    			stand.setStemmer(stemmer);
				stand.kalkulerAntallStemmer();
				stand.kalkulerSnittStemmer();
			}
    	    
    	    liste = liste
        			.stream()
        			.sorted(Comparator.comparing(Stand::getSnittStemme)
        					.thenComparing(Stand::getAntallStemmer)
        					.thenComparing(Stand::getNavn))
        			.collect(Collectors.toList()); 
    	    
    	    Collections.reverse(liste);
    	    
            request.setAttribute("liste", liste);
                   
            request.getRequestDispatcher("oversikt.jsp").forward(request, response);

    }

}
