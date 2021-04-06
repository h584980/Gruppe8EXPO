package no.hvl.dat109;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "arrangement", urlPatterns = "/arrangementservlet")
public class ArrangementServlet extends HttpServlet {
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
		Date startDato = Date.valueOf(request.getParameter("startDato"));
		Date sluttDato = Date.valueOf(request.getParameter("sluttDato"));
		Time startTid = Time.valueOf(request.getParameter("startTid")+":00");
		Time sluttTid = Time.valueOf(request.getParameter("sluttTid")+":00");
		
		// TILBAKE TIL REGISTRERING MED UGYLDIGE FELTER MARKERT
        if (!Validator.valliderArrangement(dao, request, navn)) {        	
        	request.setAttribute("innvalidData", "innvalidData");
        	doGet(request, response);
        // OPPRETT NY DELTAGER OG LEGG TIL I DATABASE
        } else { 
        	Arrangement nyttArrangement = new Arrangement(navn, startDato, sluttDato, startTid, sluttTid);
        	dao.lagreNyttArrangement(nyttArrangement);
        	request.setAttribute("nyttArrangement", nyttArrangement);
        	doGet(request, response);
        }
		
	}

}
