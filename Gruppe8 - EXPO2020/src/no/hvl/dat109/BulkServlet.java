package no.hvl.dat109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



@MultipartConfig
@WebServlet(name = "bulk", urlPatterns = "/bulkservlet")
public class BulkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private StandOgStemmeDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getAttribute("innvalidData") != null) {
			   request.getRequestDispatcher("lastoppcsv.jsp")
	    	   .forward(request, response);
	       } else {    
	    	   request.getRequestDispatcher("registreringsbekreftelse.jsp")
	    	   .forward(request, response);
	       }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Part filePart = request.getPart("filename");
		String arrangement = request.getParameter("arrangement");
		
		if (filePart.getContentType().equals("text/csv")) {
			InputStream fileContent = filePart.getInputStream();
	        InputStreamReader isReader = new InputStreamReader(fileContent);
	        BufferedReader reader = new BufferedReader(isReader);
	        String hele = "";
	        String linje;
	        while((linje = reader.readLine())!= null){
	        	hele += linje;
	        }
	        List<Stand> liste = new ArrayList<>();
	        String[] deler = hele.split(";\\d;"); // ;
	        for (int i = 1; i < deler.length; i++) {
	        	String standNavn = deler[i].split(";")[0];
	        	if (standNavn.length() > 3) {
	        		Stand nyttStand = new Stand(standNavn.trim().replace("\"", ""));
			        dao.lagreNyttStand(nyttStand, arrangement);
			        liste.add(nyttStand);
				}
			}
            request.setAttribute("liste", liste);
            doGet(request, response);
		} else {
			request.setAttribute("ugyldigFil", "Velg en csv. fil");
			request.setAttribute("innvalidData", "innvalidData");
        	doGet(request, response);
		}
		

    
	}
	
	

}