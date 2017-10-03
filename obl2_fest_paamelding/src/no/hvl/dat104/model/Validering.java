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
			return "Kan ikke v�re tomt";
		}
		else if (tekst.length()<Validering.tekstMaksLengde) {
			return "M� v�re minst to tegn";
		}
	return "";
	}
	
	static public String mobilFeilmelding(String mobil) {
		if (mobil==null) {
			return "kan ikke v�re tomt";
		}
		if (mobil.length()!=8 || !mobil.matches("[0-9]+")) {
			return "M� best� av �tte tall";
		}
		return "";
	}
	
	static public String boolskFeilmelding(String boolsk) {
		return "M� velge kj�nn";
	}
}
