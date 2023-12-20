package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		System.out.println("\nCriação automática de contas para testes\n");
		ContaCorrente c1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100f);
		contas.cadastrarConta(c1);
		ContaCorrente c2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100f);
		contas.cadastrarConta(c2);
		ContaPoupanca c3 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrarConta(c3);
		ContaPoupanca c4 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrarConta(c4);
		contas.listarTodas();
		
		
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
				
				System.out.println("Digite o Número da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					tipo = leia.nextInt();
				} while(tipo < 1 || tipo > 2);
				
				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
					case 1 ->{
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = leia.nextFloat();
						contas.cadastrarConta(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o Dia de Aniversário da Conta: ");
						aniversario = leia.nextInt();
						contas.cadastrarConta(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				
				keyPress();
				break;
				
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas \n\n");
				contas.listarTodas();
				keyPress();
				break;
				
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar Dados da Conta - por número\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
				
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar Dados da Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o Número da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					System.out.println("Digite o Saldo da Conta: ");
					saldo = leia.nextFloat();
					
					switch(tipo) {
						case 1 -> {
							System.out.println("Digite o Limite de Crédito: ");
							limite = leia.nextFloat();
							
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 ->{
							System.out.println("Digite o Dia de Aniversário da Conta: ");
							aniversario = leia.nextInt();
							
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						}
						default -> {
							System.out.println("Tipo de Conta Inválido!");
						}
					}
				} else {
					System.out.println("A conta não foi encontrada!");
				}
				
				keyPress();
				break;
				
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				
				System.out.println("Digite o Número da Conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
				
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
				
				System.out.println("Digite o Número da Conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o Valor do Saque (R$): ");
					valor = leia.nextFloat();
				} while(valor <=0 );
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
				
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				
				System.out.println("Digite o Número da Conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o Valor do Depósito (R$): ");
					valor = leia.nextFloat();
				} while(valor <=0 );
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
				
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");
				
				System.out.println("Digite o Número da Conta de Origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o Número da Conta de Destino: ");
				numeroDestino = leia.nextInt();
				
				do {
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = leia.nextFloat();
				} while(valor <=0 );
				
				contas.transferir(numero, numeroDestino, valor);
				
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
