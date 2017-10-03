package no.hvl.dat104.model;

public class Validering {
	static private int tekstMaksLengde = 2;
	
	static public boolean tekst(String tekst) {
		return  tekst!=null && tekst.length()>=Validering.tekstMaksLengde;
	}
	static public boolean mobil(String mobil) {
		return mobil!=null && mobil.length()==8 && mobil.matches("[0-9]+");
	}
	static public boolean boolsk(String boolsk) {
		return boolsk!=null && (boolsk.equals("true") || boolsk.equals("false"));
	}
	
	static public String tekstFeilmelding(String tekst) {
		if (tekst==null) {
			return "Kan ikke være tomt";
		}
		else if (tekst.length()<Validering.tekstMaksLengde) {
			return "Må være minst to tegn";
		}
	return "";
	}
	
	static public String mobilFeilmelding(String mobil) {
		if (mobil==null) {
			return "kan ikke være tomt";
		}
		if (mobil.length()!=8 || !mobil.matches("[0-9]+")) {
			return "Må bestå av åtte tall";
		}
		return "";
	}
	
	static public String boolskFeilmelding(String boolsk) {
		return "Må velge kjønn";
	}
}
