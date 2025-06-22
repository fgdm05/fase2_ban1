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
				System.out.println("7 - Criar um impressora");
				System.out.println("8 - Visualizar todas as impressoras");
				System.out.println("9 - Excluir uma impressora");
				System.out.println("10 - Criar fornecimento");
				System.out.println("11 - Visualizar historico de fornecimento");
				System.out.println("12 - Visualizar historico de fornecimento com fornecedores e materias primas");
				System.out.println("13 - Excluir fornecimento");
				System.out.println("0 - Sair");
				do {escolha = sc.nextInt(); } while(escolha < 0 || escolha > 13);
				sc.nextLine();
				
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
					sys.criarMateriaPrima(con);
					break;
				case 5:
					sys.verMateriasPrimas(con);
					break;
				case 6:
					sys.deletarMateriaPrima(con);
					break;
				case 7:
					sys.criarImpressora(con);
					break;
				case 8:
					sys.verImpressoras(con);
					break;
				case 9:
					sys.deletarImpressora(con);
					break;
				case 10:
					sys.criarFornecimento(con);
					break;
				case 11:
					sys.verFornecimentos(con);
					break;
				case 12:
					sys.verFornecimentosComFornEmp(con);
					break;
				case 13:
					sys.deletarFornecimento(con);
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
