package apresentacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import negocio.Sistema;
import persistencia.ConnectionFactory;

public class Program {
	
	static Scanner sc = new Scanner(System.in);
	static Sistema sys = new Sistema();
	public static void main(String[] args) {
		System.out.println("Começando programa...");
		
		try {
			// Connection con = new ConnectionFactory().createConnection();
			while(true) {
				
				System.out.println("1 - Criar um cliente");
				System.out.println("2 - Visualizar todos os clientes");
				System.out.println("3 - Deletar cliente");
				System.out.println("0 - Sair");
				int escolha = -1000;
				while(escolha < 0 || escolha > 3) {escolha = sc.nextInt(); }
				if(escolha == 1) {
					sys.criarCliente();
				} else if(escolha == 2) {
					sys.verClientes();
				} else if(escolha == 3) {
					sys.deletarCliente();
				}
				else if(escolha == 0) {
					break;
				} else {
					throw new RuntimeException("Não existe a opção " + escolha);
				}
				
			}
		} catch(Throwable t) {
			System.err.println(t.getMessage());
		}
		
		System.out.println("Terminando programa...");
	}

}
