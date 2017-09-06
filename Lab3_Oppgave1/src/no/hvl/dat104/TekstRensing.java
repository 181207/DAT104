package no.hvl.dat104;

public class TekstRensing {
	static public String html(String tekst) {
	
		return tekst.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;").replaceAll("\"", "&quot;");
		
	}
}
