package no.hvl.dat104;

import java.util.Currency;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ValutaServlet")
public class ValutaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fra  =request.getParameter("fra");
		String til  =request.getParameter("til");
		int belop = Integer.parseInt(request.getParameter("belop"));
		double forhold = ExchangeRateService.getRate(fra, til).amount;
		double resultat = forhold * belop;
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Lab1_Hilseapplikasjon</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Valutaveksling resultat</h1>");
		out.println("<p>Resultat: " + belop + " " + fra + " blir " + resultat + " " + til  +"</p>");
		out.println("<p><a href=\"index.html\">Veksl en gang til</a></p>");
		out.println("</body>");
		out.println("</html>");	
		
	}

}
