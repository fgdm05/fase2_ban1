package apresentacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import negocio.Sistema;
import persistencia.ConnectionFactory;

public class Program {
	
	static Scanner sc = new Scanner(System.in);
	static Sistema sys = new Sistema();
	public static void main(String[] args) throws SQLException {
		System.out.println("Começando programa...");
		ConnectionFactory c = new ConnectionFactory();
		Connection con = c.createConnection();
		
		try {
			// Connection con = new ConnectionFactory().createConnection();
			int escolha = -1000;
			while(escolha != 0) {
				
				System.out.println("1 - Criar um fornecedor");
				System.out.println("2 - Visualizar todos os fornecedores");
				System.out.println("3 - Deletar fornecedor");
				System.out.println("4 - Criar uma materia prima");
				System.out.println("5 - Visualizar materias primas");
				System.out.println("6 - Excluir materia prima");
				System.out.println("0 - Sair");
				do {escolha = Integer.parseInt(sc.next()); } while(escolha < 0 || escolha > 6);
				
				switch(escolha) {
				case 0:
					break;
				case 1:
					sys.criarFornecedor(con);
					break;
				case 2:
					sys.verFornecedores(con);
					break;
				case 3:
					sys.deletarFornecedor(con);
					break;
				case 4:
					sys.criarMateriaPrima();
					break;
				case 5:
					sys.verMateriasPrimas();
					break;
				case 6:
					sys.deletarMateriaPrima();
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
