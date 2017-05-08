package com.tdsis.one04;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class TabelaSACThread implements Runnable{
	
	public void run() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int qtdPrestacoes = 0;
		double taxa, coeficiente;
		BigDecimal valorPrestacoes = new BigDecimal(0);
		BigDecimal valorAmortizacao = new BigDecimal(0);
		System.out.println("Tabela SAC");
		System.out.println("Digite o Valor a Ser Financiado");
		BigDecimal valorInicial = sc.nextBigDecimal();
		System.out.println("Digite a Quantidade de Prestações");
		qtdPrestacoes = sc.nextInt();
		System.out.println("Digite a Taxa de Juros");
		taxa = sc.nextDouble()/100;
		// Cálculo do Valor da Amortizaçãp
		valorAmortizacao = valorInicial.divide(new BigDecimal(qtdPrestacoes), RoundingMode.HALF_EVEN);
		// Tabela SAC
		BigDecimal valorPago = new BigDecimal(0);
		valorPrestacoes = valorAmortizacao.add(valorInicial.multiply(new BigDecimal(taxa)));
		BigDecimal saldoDevedor = valorInicial.subtract(valorAmortizacao);
		BigDecimal juros = saldoDevedor.multiply(new BigDecimal(taxa));
		System.out.println(
				"Num Prestação -------- Valor Prestação ----------------- Amortização ----------------- Juros ------------ Saldo Devedor");
		for (int i = 1; i <= qtdPrestacoes; i++) {
			System.out.println("----" + i + "---------------------"
					+ NumberFormat.getCurrencyInstance().format(valorPrestacoes.setScale(2, BigDecimal.ROUND_DOWN))
					+ "-------------------"
					+ NumberFormat.getCurrencyInstance().format(valorAmortizacao.setScale(2, BigDecimal.ROUND_HALF_DOWN))
					+ "-------------------"
					+ NumberFormat.getCurrencyInstance().format(juros.setScale(2, BigDecimal.ROUND_DOWN))
					+ "------------"
					+ NumberFormat.getCurrencyInstance().format(saldoDevedor.setScale(2, BigDecimal.ROUND_HALF_DOWN)));

			juros = saldoDevedor.multiply(new BigDecimal(taxa));
			saldoDevedor = saldoDevedor.subtract(valorAmortizacao);
			valorPago = valorPago.add(valorPrestacoes); 
			valorPrestacoes = valorAmortizacao.add(juros);
			
		}
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------");
		System.out.println("Valor Pago ----------------"
				+ NumberFormat.getCurrencyInstance().format(valorPago.setScale(2, BigDecimal.ROUND_HALF_EVEN))
				+ "--------------------------------------------------------------------------------");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
	}

}
