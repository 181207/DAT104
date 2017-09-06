package no.hvl.dat104;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlTagTest {
	String s1 = "<h1>NAVN</h1>";
	String s2 = "<script type=\"text/javascript\">window.location=\"http://www.hvl.no\"</script>";
	String s3 = "navn";
	String s4 = "";

	@Test
	public void testTags() {
		assertEquals(TekstRensing.html(s1),"&lt;h1&gt;NAVN&lt;/h1&gt;");
	}



}
