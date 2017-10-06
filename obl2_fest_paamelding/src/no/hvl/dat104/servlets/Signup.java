package no.hvl.dat104.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat104.SignupSkjema;
import no.hvl.dat104.dataaccess.DeltakerEAO;
import no.hvl.dat104.modell.Deltaker;;


@WebServlet(name = "Signup",urlPatterns = "/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}
	
	@EJB
	private DeltakerEAO deltakerEAO;

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
			Deltaker deltaker = new Deltaker(skjema.getMobil(),skjema.getFornavn(),
					skjema.getEtternavn(),Boolean.valueOf(skjema.getKjonn()),false);
			deltakerEAO.leggTilDeltaker(deltaker);
	        sesjon.setMaxInactiveInterval(60);//60 sekunder
	        response.sendRedirect("bekreftelse");
		}
	}

}
