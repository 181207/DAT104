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
import no.hvl.dat104.modell.Deltaker;


@WebServlet(name = "Login",urlPatterns = "/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltakerEAO deltakerEAO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	//jsp bruker request-parameter for å angi feilmelding
		request.getRequestDispatcher("WEB-INF/mobillogin.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobil = request.getParameter("mobil");
		Deltaker deltaker = deltakerEAO.finnDeltaker(mobil);
        HttpSession sesjon = request.getSession(false);
        if (sesjon != null) {
            sesjon.invalidate();
        }
        sesjon = request.getSession(true);
        
        //måtte legge til skjema, fordi jeg ikke fikk til å legge inn deltaker, kanskje fordi deltaker er entity klasse
        if (deltaker!=null) {
            SignupSkjema skjema = new SignupSkjema();
            skjema.setFornavn(deltaker.getFornavn());
            skjema.setEtternavn(deltaker.getEtternavn());
            skjema.setMobil(deltaker.getMobil());
            skjema.setKjonn(deltaker.getKjonn().toString());
            sesjon.setAttribute("skjema", skjema);
            sesjon.setMaxInactiveInterval(60);

	        response.sendRedirect("deltakerliste");
		}
		else {
	        response.sendRedirect("login" + "?invalidUsername");
		}
		
	}
	
	private HttpSession nySesjon(HttpServletRequest request, Deltaker deltaker) {
        HttpSession sesjon = request.getSession(false);
        if (sesjon != null) {
            sesjon.invalidate();
        }
        sesjon = request.getSession(true);
        
        //måtte legge til skjema, fordi jeg ikke fikk til å legge inn deltaker, kanskje fordi deltaker er entity klasse
        SignupSkjema skjema = new SignupSkjema();
        skjema.setFornavn(deltaker.getFornavn());
        skjema.setEtternavn(deltaker.getEtternavn());
        skjema.setMobil(deltaker.getMobil());
        skjema.setKjonn(deltaker.getKjonn().toString());
        sesjon.setAttribute("skjema", skjema);
        sesjon.setMaxInactiveInterval(60);
        return sesjon;
	}
}
