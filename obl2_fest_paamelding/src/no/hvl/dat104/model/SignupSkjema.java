package no.hvl.dat104.model;

import javax.servlet.http.HttpServletRequest;

public class SignupSkjema {
	private String fornavn;
	private String fornavnFeilmelding;
	private String etternavn;
	private String etternavnFeilmelding;
	private String mobil;
	private String mobilFeilmelding;
	private String kjonn;
	private String kjonnFeilmelding;

	public SignupSkjema(){
	}
	
	public SignupSkjema(HttpServletRequest request) {
		fornavn = request.getParameter("fornavn");
		etternavn = request.getParameter("etternavn");
		mobil = request.getParameter("mobil");
		kjonn = request.getParameter("kjonn");
	}

	
	public String getFornavnFeilmelding() {
		return fornavnFeilmelding;
	}

	public void setFornavnFeilmelding(String fornavnFeilmelding) {
		this.fornavnFeilmelding = fornavnFeilmelding;
	}

	public String getEtternavnFeilmelding() {
		return etternavnFeilmelding;
	}

	public void setEtternavnFeilmelding(String etternavnFeilmelding) {
		this.etternavnFeilmelding = etternavnFeilmelding;
	}

	public String getMobilFeilmelding() {
		return mobilFeilmelding;
	}

	public void setMobilFeilmelding(String mobilFeilmelding) {
		this.mobilFeilmelding = mobilFeilmelding;
	}

	public String getKjonnFeilmelding() {
		return kjonnFeilmelding;
	}

	public void setKjonnFeilmelding(String kjonnFeilmelding) {
		this.kjonnFeilmelding = kjonnFeilmelding;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	
	public boolean Valider() {
		return Validering.tekst(fornavn) && Validering.tekst(etternavn)
				&& Validering.mobil(mobil) && Validering.boolsk(kjonn);
	}
	
	public void feilSjekk(){
		if (!Validering.tekst(fornavn)) {
			fornavn="";
			fornavnFeilmelding = Validering.tekstFeilmelding(fornavn);
		}
		if (!Validering.tekst(etternavn)) {
			etternavn="";
			etternavnFeilmelding = Validering.tekstFeilmelding(etternavn);
		}
		if (!Validering.mobil(mobil)) {
			mobil="";
			mobilFeilmelding = Validering.mobilFeilmelding(mobil);
		}
		if (!Validering.boolsk(kjonn)) {
			kjonn="";
			mobilFeilmelding = Validering.boolskFeilmelding(kjonn);
		}
	}
}
