package com.tdsis.one04;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class TabelaPriceThread implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int qtdPrestacoes = 0;
		double taxa, coeficiente;
		BigDecimal valorPrestacoes = new BigDecimal(0);
		System.out.println("Tabela Price");
		System.out.println("Digite o Valor a Ser Financiado");
		BigDecimal valorInicial = sc.nextBigDecimal();
		System.out.println("Digite a Quantidade de Prestações");
		qtdPrestacoes = sc.nextInt();
		System.out.println("Digite a Taxa de Juros");
		taxa = sc.nextDouble();
		// Cálculo do Valor das Prestações
		coeficiente = (Math.pow(1 + (taxa / 100), qtdPrestacoes) * (taxa / 100))
				/ (Math.pow(1 + (taxa / 100), qtdPrestacoes) - 1);
		valorPrestacoes = valorInicial.multiply(new BigDecimal(coeficiente));
		// Tabela Price
		BigDecimal juros = new BigDecimal(0);
		BigDecimal amortizacao = new BigDecimal(0);
		BigDecimal saldoDevedor = valorInicial;
		System.out.println(
				"Num Prestação -------- Valor Prestação -------- Juros --------- Amortização ---------- Saldo Devedor");
		for (int i = 0; i <= qtdPrestacoes; i++) {
			System.out
					.println("----" + i + "---------------------" + valorPrestacoes.setScale(2, BigDecimal.ROUND_CEILING)
							+ "-------------------" + juros.setScale(2, BigDecimal.ROUND_HALF_DOWN) + "-------------------"
							+ amortizacao.setScale(2, BigDecimal.ROUND_CEILING) + "------------"
							+ saldoDevedor.setScale(2, BigDecimal.ROUND_HALF_DOWN));
			juros = saldoDevedor.multiply(new BigDecimal(taxa / 100));
			amortizacao = valorPrestacoes.subtract(juros);
			saldoDevedor = saldoDevedor.subtract(amortizacao);
		}
	}

}
