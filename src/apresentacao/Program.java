package apresentacao;

import java.util.Scanner;

import negocio.Sistema;

public class Program {
	
	static Scanner sc = new Scanner(System.in);
	static Sistema sys = new Sistema();
	public static void main(String[] args) {
		System.out.println("Começando programa...");
		
		while(true) {
			try {
			System.out.println("1 - Criar um cliente");
			System.out.println("2 - Visualizar todos os clientes");
			System.out.println("0 - Sair");
			int escolha = -1000;
			while(escolha < 0 || escolha > 2) {escolha = sc.nextInt(); }
			if(escolha == 1) {
				sys.criarCliente();
			} else if(escolha == 2) {
				sys.verClientes();
			} else if(escolha == 0) {
				break;
			} else {
				throw new RuntimeException("Não existe a opção " + escolha);
			}
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		System.out.println("Terminando programa...");
	}

}
