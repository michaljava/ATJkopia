package atj;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CiastkoServlet")
public class CiastkoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for (int i = 0; i < 10; i++) {
			Cookie cookie = new Cookie("NAME_" + i, String.valueOf(i));
			cookie.setMaxAge(300);
			response.addCookie(cookie);
		}

		request.getProtocol();
		request.getRequestURL();

		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String name = headers.nextElement();
			String value = request.getHeader(name);
			response.getWriter().println(name + ": " + value);
		}

		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			response.getWriter().println(c.getName() + ": " + c.getValue());
		}

	}

}
