
package no.hvl.dat109;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "oversikt", urlPatterns = {"/oversiktservlet"})
public class OversiktServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @EJB
    private StandOgStemmeDAO dao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession sesjon = request.getSession(false);
    	if (sesjon == null) {
            response.sendRedirect("noegikkgale.jsp");
        } else {

        	if ((boolean)sesjon.getAttribute("juryLoggetInn")) {
        		String arrangement = (String) sesjon.getAttribute("arrangement");
            	
            	List<Stand> liste = dao.hentAlleStandFraArrangement(arrangement);
        	    
                request.setAttribute("liste", liste);
                       
                request.getRequestDispatcher("oversikt.jsp").forward(request, response);
			} else {
				response.sendRedirect("noegikkgale.jsp");
			}
        	
        }
    	
    }

}
