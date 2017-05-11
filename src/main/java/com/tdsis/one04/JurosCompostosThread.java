package com.tdsis.one04;

import java.math.BigDecimal;
import java.util.Scanner;

public class JurosCompostosThread implements Runnable {

	Scanner sc = new Scanner(System.in);
	int qtdPrestacoes = 0;
	double taxa;
	BigDecimal valorInicial, capital, juros = new BigDecimal(0), montante = new BigDecimal(0);

	public void run() {

		receberValores();
		montagemTabela();

	}

	public void receberValores() {

		System.out.println("Tabela Juros Compostos");
		System.out.println("Digite o Valor a Ser Financiado");
		valorInicial = sc.nextBigDecimal();
		System.out.println("Digite a Quantidade de Prestações");
		qtdPrestacoes = sc.nextInt();
		System.out.println("Digite a Taxa de Juros");
		taxa = sc.nextDouble();
	}

	public void montagemTabela() {
		capital = valorInicial;
		System.out.println("Prestação -------- Capital -------- Juros --------- Montante");
		for (int i = 0; i < qtdPrestacoes; i++) {
			juros = capital.multiply(new BigDecimal(taxa / 100));
			montante = capital.add(juros);
			System.out.println("---" + (i + 1) + " --------------" + capital.setScale(2, BigDecimal.ROUND_CEILING)
					+ "-----------" + juros.setScale(2, BigDecimal.ROUND_CEILING) + "----------- "
					+ montante.setScale(2, BigDecimal.ROUND_CEILING));
			capital = montante;
		}

	}

}
