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

@WebServlet(name = "adminlogin", urlPatterns = "/adminloginservlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private StandOgStemmeDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getAttribute("innvalidData") != null) {
			response.sendRedirect("noegikkgale.jsp");
	    } else {    
            request.getRequestDispatcher("menyAdmin.jsp").forward(request, response);
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String passord = request.getParameter("passord");

        if (passord == null || !BrukerValidator.validerAdminPassord(passord, request)) {
        	request.setAttribute("innvalidData", "innvalidData");
			doGet(request, response);
        } else {

            HttpSession sesjon = request.getSession(false);
            if (sesjon != null) {
                sesjon.invalidate();
            }
            sesjon = request.getSession(true);
            sesjon.setMaxInactiveInterval(10);
            sesjon.setAttribute("adminLoggetInn", true);
                   	
        	List<Arrangement> liste = dao.hentAlleArrangement();
    	    
            request.setAttribute("liste", liste);

            doGet(request, response);
        }
	}

}
