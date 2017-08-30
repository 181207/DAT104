package no.hib.dat104;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LogInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date naa = new Date();
		String dato = DateFormat.getDateInstance(DateFormat.LONG).format(naa);
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		String username = "verden";
		String password = "123";
		if (request.getParameter("username") != null) {
			username= request.getParameter("username");
		}
		if (request.getParameter("password") != null) {
			password= request.getParameter("password");
		}

		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Lab1_Hilseapplikasjon</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Login result</h1>");
		out.println("<p>Logged in from: " + request.getRequestURL()  +"</p>");
		out.println("<p>username: " + username +"</p>");
		out.println("<p>password: " + password +"</p>");
		out.println("</body>");
		out.println("</html>");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
