package com.tdsis.one04;

import java.math.BigDecimal;

import junit.framework.TestCase;

public class JurosSimplesTest extends TestCase{
	
	public void testCalcMontante() {
		JurosSimplesThread js = new JurosSimplesThread();
		BigDecimal expResult = new BigDecimal(5500);
		BigDecimal result = js.calcMontante(new BigDecimal(5000), 10);
		assertEquals("Falha na Conta", expResult, result.setScale(0, BigDecimal.ROUND_HALF_DOWN));
	}

}
