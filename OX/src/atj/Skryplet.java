package atj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Skryplet
 */
@WebServlet("/Skryplet")
public class Skryplet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Double value1=Double.parseDouble(request.getParameter("value1"));
		Double value2=Double.parseDouble(request.getParameter("value2"));
		String operation=request.getParameter("operation");
		double wynik=oblicz(value1,value2,operation);
//		PrintWriter printWriter=response.getWriter();
//		printWriter.println("<h1>Wynik:  " + wynik +"</h1>"); 
		
		request.setAttribute("result",new Double(wynik));
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("res.jsp");
		requestDispatcher.forward(request,response);
	}

	public double oblicz(double x, double y, String oper) {
		double wynik = 0;
		
		if (oper.equalsIgnoreCase("+")){
			return wynik = x + y;
		}
		if (oper.equalsIgnoreCase("-")){
			return wynik = x - y;
		}
		if (oper.equalsIgnoreCase("*")){
			return wynik = x * y;
		} else {
			System.out.println("nie wybrales typu obliczenia");
			return 0;
		}
	}
}
