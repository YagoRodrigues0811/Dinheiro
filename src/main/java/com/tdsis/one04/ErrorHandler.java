package com.tdsis.one04;

import java.util.Scanner;

public class ErrorHandler {

	public void errorHandling(String[] args, Scanner sc) {
		int op = 0;
		System.err.println("Opção Inválida");
		System.out.println("Tentar Novamente");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		op = sc.nextInt();
		if(op == 1){
	        Main.main(args);
		} else if(op == 2){
			System.exit(0);
		} else {
			errorHandling(args, sc);
		}
	}
}
