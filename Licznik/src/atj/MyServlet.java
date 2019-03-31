package atj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Moj Serwlet", urlPatterns = { "/MyServlet" })
public class MyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer counter = (Integer)request.getSession().getAttribute("sessionCounter");
		response.getWriter().append("<h1>Liczba	sesji: " + counter + "</h1>");
		
	}
}
