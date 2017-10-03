package no.hvl.dat104.test;

import no.hvl.dat104.model.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ValideringTest {
	String s1;
	String s2;
	String s3;
	String s4;
	String s5;
	String s6;
	
	String m1;
	String m2;
	String m3;
	String m4;
	String m5;
	
	String b1;
	String b2;
	String b3;
	String b4;
	String b5;
	
	@Before
	public void setUp() throws Exception {
		s1 = "hei";
		s2 = "HEI";
		s3 = "Ja";
		s4 = "N";
		s5 = "";
		s6 = null;
		
		m1="11223344";
		m2="aaaaaaaa";
		m3="1245678";
		m4="";
		m5=null;
		
		b1="true";
		b2="false";
		b3="feedas";
		b4="";
		b5=null;
		
	}

	@Test
	public void tekst() {
		assertTrue(Validering.tekst(s1));
		assertTrue(Validering.tekst(s2));
		assertTrue(Validering.tekst(s3));
		assertFalse(Validering.tekst(s4));
		assertFalse(Validering.tekst(s5));
		assertFalse(Validering.tekst(s6));
	}
	
	@Test
	public void mobil() {
		assertTrue(Validering.mobil(m1));
		assertFalse(Validering.mobil(m2));
		assertFalse(Validering.mobil(m3));
		assertFalse(Validering.mobil(m4));
		assertFalse(Validering.mobil(m5));
	}
	
	@Test
	public void bool() {
		assertTrue(Validering.boolsk(b1));
		assertTrue(Validering.boolsk(b2));
		assertFalse(Validering.boolsk(b3));
		assertFalse(Validering.boolsk(b4));
		assertFalse(Validering.boolsk(b5));
	}
	
	
}
