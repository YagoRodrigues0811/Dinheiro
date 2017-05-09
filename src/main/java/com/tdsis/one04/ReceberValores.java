package com.tdsis.one04;

import java.math.BigDecimal;
import java.util.Scanner;

public interface ReceberValores {
	
	public BigDecimal receberBigDecimal(Scanner scanner);

	public int receberInt(Scanner scanner);
	
	public double receberDouble(Scanner scanner);
	
	public void continuarNoSistema(Scanner scanner, ErrorHandler errorHandler); 
}
