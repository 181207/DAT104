package no.hvl.dat104;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/TempServlet")
public class TempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double verdi;
		Integer fraTil;
		String fra;
		String til;

		Double minC = -273.15;
		Double minF = -459.67;
		String tekst = "";
		Double res;
		DecimalFormat enDes = new DecimalFormat("#0.0"); //formaterer Double
		
		if (request.getParameter("verdi")!="" && request.getParameter("fraTil")!=null) {
			fraTil = Integer.parseInt(request.getParameter("fraTil"));//0=Celsius til Fahrenheit - 1=Fahrenheit til Celsius
			String verdiS = request.getParameter("verdi");
			verdiS = verdiS.replace(",", ".");
			verdi = Double.parseDouble(verdiS);
			if (fraTil == 0 && verdi >= minC || fraTil == 1 && verdi >= minF) { //godkjent verdier
				
				if (fraTil==0) { //C til F
					res = verdi * 9/5 + 32;
					fra = "°C";
					til = "°F";
				}
				else { //F til C
					res = (verdi - 32) / 1.8;
					fra = "°F";
					til = "°C";
				}
				
				tekst = "" + enDes.format(verdi) + fra + " = " + enDes.format(res) + til;
			}
			else { //ugyldige verdier
				tekst =  "<font color=\"red\">Ugyldig brukerinput. Verdien må være et "
						+ "tall (lik eller over det absolutte nullpunkt). Pass også på at du har valgt en av radi"
						+ "oknappene før du trykker regn om </font>";
			}
		}
		else { //ugyldige verdier
			tekst =  "<font color=\"red\">Ugyldig brukerinput. Verdien må være et "
					+ "tall (lik eller over det absolutte nullpunkt). Pass også på at du har valgt en av radi"
					+ "oknappene før du trykker regn om </font>";
		}

		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Temp kalk</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Temperatur omregning resultat</h1>");
		out.println("<p>" + tekst +"</p>");
		out.println("<p><a href=\"index.html\">Ny omregning</a></p>");
		out.println("</body>");
		out.println("</html>");		
	}
	
}
