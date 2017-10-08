package no.hvl.dat104.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import no.hvl.dat104.modell.*;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat104.dataaccess.DeltakerEAO;
import no.hvl.dat104.modell.Deltaker;

@WebServlet(name = "Adminpanel",urlPatterns = "/adminpanel")
public class Adminpanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	DeltakerEAO deltakerEAO;
	List<Deltaker> deltakere;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesjon = request.getSession(false);
        if (sesjon == null || sesjon.getAttribute("loggedInAdmin") == null) {
            response.sendRedirect("adminlogin"  + "?requiresLogin");
        } else {
        	sesjon.setMaxInactiveInterval(60);
    		deltakere = deltakerEAO.alleDelakerTotalt();
    		request.setAttribute("deltakere", deltakere);
    		request.getRequestDispatcher("WEB-INF/betalingsoversikt.jsp").forward(request, response);
        }	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(Deltaker u:deltakere) {
			if (request.getParameterMap().containsKey(u.getMobil())) {
				u.setBetalt(true);
				deltakerEAO.oppdaterDeltaker(u);
			}
		}
		response.sendRedirect("adminpanel");;
	}
}
