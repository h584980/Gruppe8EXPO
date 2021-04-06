package no.hvl.dat109;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "jurylogin", urlPatterns = "/juryloginservlet")
public class JuryLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getAttribute("innvalidData") != null) {
			
		request.getRequestDispatcher("noegikkgale.jsp")
	    	   .forward(request, response);
	    } else {   
	    	   
	    	response.sendRedirect("oversiktservlet");
	       }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String passord = request.getParameter("passord");
		String arrangement = request.getParameter("arrangement");

        if (passord == null || !BrukerValidator.validerJuryPassord(passord, request)) {
        	request.setAttribute("innvalidData", "innvalidData");
			doGet(request, response);
        } else {

            HttpSession sesjon = request.getSession(false);
            if (sesjon != null) {
                sesjon.invalidate();
            }
            sesjon = request.getSession(true);
            sesjon.setMaxInactiveInterval(10);
            sesjon.setAttribute("arrangement", arrangement);
            sesjon.setAttribute("juryLoggetInn", true);

            doGet(request, response);
        }
	}

}
