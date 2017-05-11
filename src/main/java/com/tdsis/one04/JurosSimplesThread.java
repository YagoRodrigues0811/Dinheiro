package com.tdsis.one04;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class JurosSimplesThread implements Runnable {

	Scanner sc = new Scanner(System.in);
	int prestacoes = 0;
	double taxa = 0;
	BigDecimal valorInicial, montante, valorPrestacao;

	public void run() {

		receberValores();
		mostrarMontanteEPrestacao();

	}

	public void receberValores() {
		System.out.println("Cálculo de Juros Simples");
		System.out.println("Digite o Valor a ser Financiado");
		valorInicial = sc.nextBigDecimal();
		System.out.println("Digite o Número de Prestações");
		prestacoes = sc.nextInt();
		System.out.println("Digite a Taxa de Juros do Financiamento");
		taxa = sc.nextDouble();
	}

	public void mostrarMontanteEPrestacao() {
		montante = calcularMontante(valorInicial, taxa);
		valorPrestacao = calcularPrestacao(montante, prestacoes);
		System.out.println("Valor do Montante -------------- " + NumberFormat.getCurrencyInstance().format(montante));
		System.out.println(
				"Valor da Prestação -------------- " + NumberFormat.getCurrencyInstance().format(valorPrestacao));
	}

	public BigDecimal calcularMontante(BigDecimal valorInicial, double taxa) {
		BigDecimal valorFinal = new BigDecimal(0);
		valorFinal = valorInicial.add(valorInicial.multiply(new BigDecimal(taxa / 100)));
		System.out.println("--------------------------------------------------");
		return valorFinal;
	}

	public BigDecimal calcularPrestacao(BigDecimal montante, int prestacoes) {
		BigDecimal valorPrestacao = new BigDecimal(0);
		valorPrestacao = montante.divide(new BigDecimal(prestacoes), RoundingMode.HALF_EVEN);
		System.out.println("--------------------------------------------------");
		return valorPrestacao;
	}

}
