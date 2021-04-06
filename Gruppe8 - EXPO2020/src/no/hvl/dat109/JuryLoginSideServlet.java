package no.hvl.dat109;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "juryloginside", urlPatterns = "/juryloginsideservlet")
public class JuryLoginSideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
    private StandOgStemmeDAO dao;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Arrangement> liste = dao.hentAlleArrangement();
 	    
        request.setAttribute("liste", liste);
               
        request.getRequestDispatcher("loginJury.jsp").forward(request, response);
	}

}
