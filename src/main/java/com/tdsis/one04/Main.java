package com.tdsis.one04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ErrorHandler eh= new ErrorHandler();
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		System.out.println("Bem Vindo Ao Sistema de Cálculo de Financiamento");
		System.out.println("Escolha uma das Funcionalidades Abaixo");
		System.out.println("1 - Tabela de Juros Simples");
		System.out.println("2 - Tabela de Juros Compostos");
		opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			  JurosSimplesThread js = new JurosSimplesThread();
			  js.run();
			  int op = 0;
			  try{
			  System.out.println("Quer Continuar no Sistema");
			  System.out.println("1 - Sim");
			  System.out.println("2 - Não");
			  op = sc.nextInt();
			  }catch (Exception e) {
				// TODO: handle exception
				  eh.errorHandling(args, sc);
			}
			  if(op == 1){
			     main(args);
			  } else if(op == 2){
				 System.exit(0);  
			  } else {
				  System.out.println("");
				  eh.errorHandling(args, sc);
				  
			  }
			break;
        case 2:
        	JurosCompostosThread jc = new JurosCompostosThread();
			  jc.run();
			  op = 0;
			  try{
			  System.out.println("Quer Continuar no Sistema");
			  System.out.println("1 - Sim");
			  System.out.println("2 - Não");
			  op = sc.nextInt();
			  }catch (Exception e) {
				// TODO: handle exception
				  eh.errorHandling(args, sc);
			}
			  if(op == 1){
			     main(args);
			  } else if(op == 2){
				  System.out.println("Até Mais");
				 System.exit(0);  
			  } else {
				  System.out.println("");
				  eh.errorHandling(args, sc);
				  
			  }
			break;

		default:
			break;
		}

	}
	
	
}
