package no.hvl.dat104;

import junit.framework.TestCase;

public class ValutaTest extends TestCase {
	ExchangeRateService kalk;
	public void setUp() throws Exception {
        kalk = new ExchangeRateService();
    }
	
    public void testNullErNull() throws Exception {
    	int belop = 0;
    	double forhold = ExchangeRateService.getRate("EUR", "NOK").amount;
    	assertEquals(forhold * belop,0);
    }
}
