package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		//Teste da classe ContaCorrente
		ContaCorrente contaC = new ContaCorrente(2, 123, 1, "Reinaldo", 10000.0f, 1000.0f);
		contaC.visualizar();
		contaC.sacar(3000.0f);
		contaC.visualizar();
		contaC.depositar(5000.0f);
		contaC.visualizar();
		
		//Teste da classe ContaPoupanca
		ContaPoupanca contaP = new ContaPoupanca(3, 123, 2, "Flávia", 150000.0f, 16);
		contaP.visualizar();
		contaP.sacar(2000.0f);
		contaP.visualizar();
		contaP.depositar(4000.0f);
		contaP.visualizar();
		
		while(true){
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "************************************");
			System.out.println("                                    ");
			System.out.println("       Banco do Brazil com Z        ");
			System.out.println("                                    ");
			System.out.println("************************************");
			System.out.println("                                    ");
			System.out.println("          1 - Criar Conta           ");
			System.out.println("     2 - Listar Todas as Contas     ");
			System.out.println("     3 - Buscar Conta por Número    ");
			System.out.println("    4 - Atualizar Dados da Conta    ");
			System.out.println("          5 - Apagar Conta          ");
			System.out.println("            6 - Sacar               ");
			System.out.println("          7 - Depositar             ");
			System.out.println(" 8 - Transferir Valores entre Contas");
			System.out.println("            9 - Sair                ");
			System.out.println("                                    ");
			System.out.println("************************************");
			System.out.println("                                    ");
			System.out.println("Entre com a opção desejada:         ");
			System.out.println("                                    " + Cores.TEXT_RESET);
			
			try {
				opcao = leia.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");
				keyPress();
				break;
				
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas \n\n");
				keyPress();
				break;
				
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar Dados da Conta - por número\n\n");
				keyPress();
				break;
				
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar Dados da Conta\n\n");
				keyPress();
				break;
				
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				keyPress();
				break;
				
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
				keyPress();
				break;
				
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				keyPress();
				break;
				
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");
				keyPress();
				break;
				
			case 9:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\n Banco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
				break;
				
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "Opção Inválida. Por favor, tente novamente.");
					keyPress();
			}
		}
		
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione ENTER para Continuar...");
			System.in.read();
		} catch(IOException e) {
			System.out.println("Você pressionou uma tecla diferente de ENTER!");
		}
	}
	
	private static void sobre() {
		System.out.println("\n************************************");
		System.out.println("Projeto desenvolvido por: ");
		System.out.println("Fernando Lopes");
		System.out.println("https://github.com/plasmus777");
		System.out.println("\n************************************");
	}

}
