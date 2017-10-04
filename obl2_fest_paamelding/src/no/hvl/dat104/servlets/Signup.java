package no.hvl.dat104.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat104.SignupSkjema;;


@WebServlet(name = "Signup",urlPatterns = "/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SignupSkjema skjema = new SignupSkjema(request);
		skjema.feilSjekk();
		
		//Oppretter et sesjonsobjekt (evt. null om det ikke eksisterer noen):
        HttpSession sesjon = request.getSession(false);
        if (sesjon != null) {
            sesjon.invalidate();
        }
		//Oppretter et sesjonsobjekt (evt. få et eksisterende gyldig hvis det finnes):
        sesjon = request.getSession(true);
		sesjon.setAttribute("skjema", skjema);
		
		if(!skjema.Valider()) {
			response.sendRedirect("signup");
		}
		else {
	        sesjon.setMaxInactiveInterval(10);
	        response.sendRedirect("bekreftelse");
		}
	}

}
