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
			int escolha = -1000;
			while(escolha != 0) {
				
				System.out.println("1 - Criar um cliente");
				System.out.println("2 - Visualizar todos os clientes");
				System.out.println("3 - Deletar cliente");
				System.out.println("4 - Criar um produto");
				System.out.println("5 - Visualizar catálogo");
				System.out.println("6 - Excluir produto");
				System.out.println("0 - Sair");
				while(escolha < 0 || escolha > 6) {escolha = Integer.parseInt(sc.nextLine()); }
				
				switch(escolha) {
				case 0:
					break;
				case 1:
					sys.criarCliente();
					break;
				case 2:
					sys.verClientes();
					break;
				case 3:
					sys.deletarCliente();
					break;
				case 4:
					sys.criarProduto();
					break;
				case 5:
					sys.verProdutos();
					break;
				case 6:
					sys.deletarProduto();
					break;
				default:
						throw new RuntimeException("Não existe a opção " + escolha);
				}
			}
		} catch(Throwable t) {
			System.err.println(t.getMessage());
		}
		
		System.out.println("Terminando programa...");
	}

}
