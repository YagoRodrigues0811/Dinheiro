package com.tdsis.one04;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class JurosSimplesThread implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int prestacoes = 0;
		double taxa = 0;
		System.out.println("Cálculo de Juros Simples");
		System.out.println("Digite o Valor a ser Financiado");
		BigDecimal valorInicial = sc.nextBigDecimal();
		System.out.println("Digite o Número de Prestações");
		prestacoes = sc.nextInt();
		System.out.println("Digite a Taxa de Juros do Financiamento");
		taxa = sc.nextDouble();
		BigDecimal montante = calcMontante(valorInicial,  taxa);
		BigDecimal valorPrestacao = calcPrestacao(montante, prestacoes);
		System.out.println("Valor do Montante -------------- "+NumberFormat.getCurrencyInstance().format(montante));
		System.out.println("Valor da Prestação -------------- "+NumberFormat.getCurrencyInstance().format(valorPrestacao));
	}
	
	public BigDecimal calcMontante(BigDecimal valorInicial, double taxa) {
		BigDecimal valorFinal = new BigDecimal(0);
		valorFinal = valorInicial.add(valorInicial.multiply(new BigDecimal(taxa/100)));
		System.out.println("--------------------------------------------------");
		return valorFinal;
	}
	
	public BigDecimal calcPrestacao(BigDecimal montante, int prestacoes) {
		BigDecimal valorPrestacao = new BigDecimal(0);
		valorPrestacao = montante.divide(new BigDecimal(prestacoes));
		System.out.println("--------------------------------------------------");
		return valorPrestacao;
	}

	
}
