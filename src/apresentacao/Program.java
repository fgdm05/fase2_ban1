package apresentacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import negocio.Sistema;
import persistencia.ConnectionFactory;

public class Program {
	
	static Scanner sc = new Scanner(System.in);
	static Sistema sys = null;
	static Connection con = null;
	
	private static void pausaTela() {
		System.out.println("Aperte enter para continuar... ");
		sc.nextLine();
	}
	private static void delegar(int escolha) throws Exception {
		switch(escolha) {
		case 0:
			break;
		case 1:
			sys.criarFornecedor();
			break;
		case 2:
			sys.verFornecedores();
			break;
		case 3:
			sys.deletarFornecedor();
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
		case 7:
			sys.criarImpressora();
			break;
		case 8:
			sys.verImpressoras();
			break;
		case 9:
			sys.deletarImpressora();
			break;
		case 10:
			sys.criarFornecimento();
			break;
		case 11:
			sys.verFornecimentos();
			break;
		case 12:
			sys.verFornecimentosComFornEmp();
			break;
		case 13:
			sys.deletarFornecimento();
			break;
		case 14:
			sys.criarAbastecimento();
			break;
		case 15:
			sys.verAbastecimentos();
			break;
		case 16:
			sys.deletarAbastecimento();
			break;
		case 17:
			sys.verAbastecimentosCompleto();
			break;
		case 18:
			sys.verAbastecimentosAgregacao();
			break;
		default:
				throw new RuntimeException("Não existe a opção " + escolha);
		}
		
	}
	private static void menu() {
		System.out.println("1 - Criar um fornecedor");
		System.out.println("2 - Visualizar todos os fornecedores");
		System.out.println("3 - Deletar fornecedor");
		System.out.println("4 - Criar uma materia prima");
		System.out.println("5 - Visualizar materias primas");
		System.out.println("6 - Excluir materia prima");
		System.out.println("7 - Criar uma impressora");
		System.out.println("8 - Visualizar todas as impressoras");
		System.out.println("9 - Excluir uma impressora");
		System.out.println("10 - Criar fornecimento");
		System.out.println("11 - Visualizar historico de fornecimento");
		System.out.println("12 - Visualizar historico de fornecimento com fornecedores e materias primas");
		System.out.println("13 - Excluir fornecimento");
		System.out.println("14 - Criar abastecimento");
		System.out.println("15 - Visualizar todos os abastecimentos");
		System.out.println("16 - Deletar abastecimento");
		System.out.println("17 - Visualizar todos os abastecimentos com impressoras e materias primas");
		System.out.println("0 - Sair");
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		System.out.println("Começando programa...");
		
		try {
			con = new ConnectionFactory().createConnection();
			sys = new Sistema(con);
			int escolha = -1000;
			while(escolha != 0) {
				try {
					menu();
					do {escolha = sc.nextInt(); } while(escolha < 0);
					sc.nextLine();
					delegar(escolha);
					pausaTela();
				} catch(Exception e) {
					System.err.println(e.getMessage());
				}
					
			}
		} catch(Throwable t) {
			System.err.println(t.getMessage());
			t.printStackTrace();
		}
		
		System.out.println("Terminando programa...");
	}

}
