package no.hvl.dat109;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "registrering", urlPatterns = "/registreringsservlet")
public class RegistreringsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private StandOgStemmeDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   if (request.getAttribute("innvalidData") != null) {
		   request.getRequestDispatcher("index.jsp")
    	   .forward(request, response);
       } else {    
    	   request.getRequestDispatcher("registreringsbekreftelse.jsp")
    	   .forward(request, response);
       }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String navn = request.getParameter("navn").trim();
		String arrangement = request.getParameter("arrangement");
		
    	// TILBAKE TIL REGISTRERING MED UGYLDIGE FELTER MARKERT
        if (!Validator.valliderStand(dao, request, navn, arrangement)) {        	
        	request.setAttribute("innvalidData", "innvalidData");
        	doGet(request, response);
        // OPPRETT NY DELTAGER OG LEGG TIL I DATABASE
        } else { 
        	Stand nyttStand = new Stand(navn);
        	dao.lagreNyttStand(nyttStand, arrangement);
            request.setAttribute("nyttStand", nyttStand);
            doGet(request, response);
        }
	}

}
