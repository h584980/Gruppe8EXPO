package no.hvl.dat109;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loggut", urlPatterns = "/loggutservlet")
public class LoggUtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);
        if (sesjon != null) {
            sesjon.invalidate();
        }
        
        response.sendRedirect("index.jsp");
	}

}
