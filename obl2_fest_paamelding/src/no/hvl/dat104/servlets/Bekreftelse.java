package no.hvl.dat104.servlets;

import java.io.IOException;

import no.hvl.dat104.*;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Bekreftelse",urlPatterns = "/bekreftelse")
public class Bekreftelse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesjon = request.getSession(false);
        if (sesjon == null || sesjon.getAttribute("skjema") == null) {
            response.sendRedirect("login"  + "?requiresLogin");
        } else {
    		request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
        }
	}
}