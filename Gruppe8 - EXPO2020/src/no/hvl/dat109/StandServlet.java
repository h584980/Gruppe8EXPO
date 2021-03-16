package no.hvl.dat109;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "stand", urlPatterns = "/standservlet")
public class StandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private StandOgStemmeDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getAttribute("innvalidData") != null) {
			
			request.getRequestDispatcher("noegikkgale.jsp")
	    	   .forward(request, response);
	       } else {   
	    	   
	    	   String standNavn = request.getParameter("navn");
	    	   Stand stand = dao.hentStand(standNavn);
	    	   
	    	   List<Stemme> stemmer= dao.hentAlleStemmerForStand(stand);
	   		   stand.setStemmer(stemmer);
	   		   
	    	   stand.kalkulerAntallStemmer();
	    	   stand.kalkulerSnittStemmer();
	    	   
	    	   request.setAttribute("stand", stand);
	    	   request.getRequestDispatcher("stand.jsp")
	    	   .forward(request, response);
	    	   
	       }
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String standNavn = request.getParameter("navn");
		Integer stemmeVerdi = Integer.parseInt(request.getParameter("vote"));
			
		//Sjekk om det er kommet cookies
		String besoktCookie = CookieUtil.getCookieFromRequest(request, standNavn.replace(" ", "_")
				.replace("ø", "oe")
				.replace("Ø", "Oe")
				.replace("æ", "ae")
				.replace("Æ", "Ae")
				.replace("å", "aa")
				.replace("Å", "Aa"));
		 				
		if (besoktCookie == null) { 
			
			if (stemmeVerdi == null || !dao.finnesStand(standNavn) ) {
				
				request.setAttribute("innvalidData", "innvalidData");
				doGet(request, response);
				
			} else {
				
				String uniqueId = UUID.randomUUID().toString();
				
				CookieUtil.addCookieToResponse(response, standNavn.replace(" ", "_").replace("ø", "oe")
						.replace("Ø", "Oe")
						.replace("æ", "ae")
						.replace("Æ", "Ae")
						.replace("å", "aa")
						.replace("Å", "Aa")
						, uniqueId);
								
				Stemme nyStemme = new Stemme(standNavn, stemmeVerdi, uniqueId);
		    	dao.lagreNyStemme(nyStemme);
		    	
		    	request.setAttribute("tilbakemelding", "Din stemme har blitt avgitt!");
		    	doGet(request, response);
			}
			
		} else {
				dao.oppdaterStemmeVerdi(besoktCookie, stemmeVerdi);
				if (stemmeVerdi == 0) {
					request.setAttribute("tilbakemelding", "Å stemme 0 er det samme som å ikke stemme");

				} else {
					request.setAttribute("tilbakemelding", "Din stemme har blitt oppdatert til verdi " + stemmeVerdi);

				}
				doGet(request, response);

		}
	}
		
}






