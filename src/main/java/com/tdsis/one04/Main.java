package com.tdsis.one04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ErrorHandler errorHandler = new ErrorHandler();
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		System.out.println("Bem Vindo Ao Sistema de Cálculo de Financiamento");
		System.out.println("Escolha uma das Funcionalidades Abaixo");
		System.out.println("1 - Calculo de Juros Simples");
		System.out.println("2 - Tabela de Juros Compostos");
		System.out.println("3 - Tabela Price");
		System.out.println("4 - Tabela SAC");
		opcao = receberOpcao(scanner, args);

		switch (opcao) {
		case 1:
			JurosSimplesThread js = new JurosSimplesThread();
			try {
				js.run();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("A Operação não pôde ser concluída");
			}
			continuarNoSistema(scanner, args, errorHandler);
			break;
		case 2:
			JurosCompostosThread jc = new JurosCompostosThread();
			try {
				jc.run();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("A Operação não pôde ser concluida");
			}
			continuarNoSistema(scanner, args, errorHandler);
			break;
		case 3:
			TabelaPriceThread tp = new TabelaPriceThread();
			try {
				tp.run();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("A Operação não pôde ser concluida");
			}

			continuarNoSistema(scanner, args, errorHandler);
			break;
		case 4:
			TabelaSACThread ts = new TabelaSACThread();
			try {
				ts.run();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("A Operação não pôde ser concluida");
			}

			continuarNoSistema(scanner, args, errorHandler);
			break;
		default:
			break;
		}

	}

	public static int receberOpcao(Scanner scanner, String[] args) {
		int opcao = 5;
		try {
			opcao = scanner.nextInt();
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.err.println("Opção Inválida");
			System.out.println("-");
			main(args);
		}
		return opcao;

	}

	public static void continuarNoSistema(Scanner scanner, String[] args, ErrorHandler errorHandler) {
		int op = 0;
		try {
			System.out.println("Quer Continuar no Sistema");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			op = scanner.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
			errorHandler.errorHandling(args, scanner);
		}
		if (op == 1) {
			main(args);
		} else if (op == 2) {
			System.out.println("Até Mais");
			System.exit(0);
		} else {
			System.out.println("");
			errorHandler.errorHandling(args, scanner);

		}
	}

}
