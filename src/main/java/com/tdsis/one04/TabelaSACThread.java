package com.tdsis.one04;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class TabelaSACThread implements Runnable {
	private Scanner sc = new Scanner(System.in);
	private int qtdPrestacoes = 0;
	private double taxa;
	
	private BigDecimal 
	valorPrestacoes = new BigDecimal(0),
	valorAmortizacao = new BigDecimal(0),
	valorInicial = new BigDecimal(0),
	valorPago = new BigDecimal(0),
	saldoDevedor = new BigDecimal(0),
	juros = new BigDecimal(0);

	public void run() {
		
		receberValores();
		calcularAmortizacao();
		calcularPrestacoes();
		calcularJuros();
		montarTabelaSAC();
        
	}

	private void receberValores() {
		System.out.println("Tabela SAC");
		System.out.println("Digite o Valor a Ser Financiado");
		valorInicial = sc.nextBigDecimal();
		System.out.println("Digite a Quantidade de Prestações");
		qtdPrestacoes = sc.nextInt();
		System.out.println("Digite a Taxa de Juros");
		taxa = sc.nextDouble() / 100;
	}

	private void calcularAmortizacao() {
		valorAmortizacao = valorInicial.divide(new BigDecimal(qtdPrestacoes),
				RoundingMode.HALF_EVEN);
	}

	private void calcularPrestacoes() {
		valorPrestacoes = valorAmortizacao.add(valorInicial.multiply(new BigDecimal(taxa)));
	}
	
	private void calcularJuros(){
		saldoDevedor = valorInicial.subtract(valorAmortizacao);
		juros = saldoDevedor.multiply(new BigDecimal(taxa));
	}
	
	private void montarTabelaSAC(){
		System.out.println(
				"Num Prestação -------- Valor Prestação ----------------- Amortização ----------------- Juros ------------ Saldo Devedor");
		for (int i = 1; i <= qtdPrestacoes; i++) {
			System.out.println("----" + i + "---------------------"
					+ NumberFormat.getCurrencyInstance().format(valorPrestacoes.setScale(2, BigDecimal.ROUND_DOWN))
					+ "-------------------"
					+ NumberFormat.getCurrencyInstance()
							.format(valorAmortizacao.setScale(2, BigDecimal.ROUND_HALF_DOWN))
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
		

	}

}
