package no.hvl.dat104.modell;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "dat104obl2", name = "deltaker")
public class Deltaker {
	@Id
	private String mobil;
	private String fornavn;
	private String etternavn;
	private Boolean kjonn;
	private Boolean betalt;
	
	public Deltaker(String mobil, String fornavn, String etternavn, Boolean kjonn, Boolean betalt) {
		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		this.betalt = betalt;
	}
	
	public Deltaker() {
	}
	
	public String getMobil() {
		return mobil;
	}
	public void setMobil(String mobil) {
		this.mobil = mobil;
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
	public Boolean getKjonn() {
		return kjonn;
	}
	public void setKjonn(Boolean kjonn) {
		this.kjonn = kjonn;
	}
	public Boolean getBetalt() {
		return betalt;
	}
	public void setBetalt(Boolean betalt) {
		this.betalt = betalt;
	}

}
