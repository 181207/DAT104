package no.hvl.dat104.servlets;

import java.io.IOException;
import java.util.List;
import no.hvl.dat104.dataaccess.*;
import no.hvl.dat104.modell.*;

import javax.ejb.EJB;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DeltakerListe",urlPatterns = "/deltakerliste")
public class Deltakerliste extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	DeltakerEAO deltakerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesjon = request.getSession(false);
        if (sesjon == null || sesjon.getAttribute("skjema") == null) {
            response.sendRedirect("login"  + "?requiresLogin");
        } else {
    		List<Deltaker> deltakere = deltakerEAO.alleDelakerTotalt();
    		request.setAttribute("deltakere", deltakere);
        	sesjon.setMaxInactiveInterval(60);
    		request.getRequestDispatcher("WEB-INF/deltakerliste.jsp").forward(request, response);
        }
	}
}
