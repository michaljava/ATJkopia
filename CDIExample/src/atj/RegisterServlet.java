package atj;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private User user;

	@Inject
	@QStrongPasswordGenerator
	private IPasswordGenerator strong;

	@Inject
	@QWeakPasswordGenerator
	private IPasswordGenerator weak;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] access = { request.getParameter("access1"), request.getParameter("access2"),
				request.getParameter("access3") };
		String rights = request.getParameter("rights");
		String email = request.getParameter("email");
		user.setAccess(access);
		user.setEmail(email);
		user.setRights(rights);
		
		if (rights.equals("User"))
			user.generatePassword(weak);
		else
			user.generatePassword(strong);
		
		RequestDispatcher rp=request.getRequestDispatcher("default.jsp");
		request.setAttribute("user", user);
		rp.forward(request, response);
		
		
	}
}