package no.hvl.dat104.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Adminlogin",urlPatterns = "/adminlogin")
public class Adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/adminlogin.jsp").forward(request, response);
	}

	private String initPw;
	private String userPw;
	
	@Override
	public void init() throws ServletException {
		initPw = getServletConfig().getInitParameter("pw");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userPw = request.getParameter("password");
		boolean correctPwd = initPw.equals(userPw);

		if (!correctPwd) {
			response.sendRedirect("adminlogin" + "?invalidPassword");
		} else {
	        HttpSession sesjon = request.getSession(false);
	        if (sesjon != null) {
	            sesjon.invalidate();
	        }
	        sesjon = request.getSession(true);
	        sesjon.setMaxInactiveInterval(60);
	        sesjon.setAttribute("loggedInAdmin", correctPwd);
	        
	        
			response.sendRedirect("adminpanel");
		}
	}

}
