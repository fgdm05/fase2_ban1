package apresentacao;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import exceptions.DeleteException;
import negocio.Sistema;
import persistencia.ConnectionFactory;

public class Program {
	
	static Scanner sc = new Scanner(System.in);
	static Sistema sys = null;
	static Connection con = null;
	static boolean pausa = true;
	private static int getEscolha(int l, int r) {
		int esc = -1000;
		while(esc < l || esc > r) {
			esc = sc.nextInt();
			sc.nextLine();
		}
		return esc;
	}
	
	private static void pausaTela() {
		System.out.println("Aperte enter para continuar... ");
		sc.nextLine();
	}
	private static void delegarFornecedor(int escolha) throws SQLException, DeleteException {
		switch(escolha) {
			case 1:
				sys.criarFornecedor();
			break;
			case 2:
				sys.verFornecedores();
			break;
			case 3:
				sys.deletarFornecedor();
			break;
			case 0:
				pausa = false;
			break;
		}
	}
	
	private static void delegarMP(int escolha) throws SQLException, DeleteException {
		switch(escolha) {
			case 1:
				sys.criarMateriaPrima();
			break;
			case 2:
				sys.verMateriasPrimas();
			break;
			case 3:
				sys.deletarMateriaPrima();
			break;
			case 0:
				pausa = false;
			break;
		}
	}	
	

	private static void delegarIMP(int escolha) throws SQLException, DeleteException {
		switch(escolha) {
			case 1:
				sys.criarImpressora();
			break;
			case 2:
				sys.verImpressoras();
			break;
			case 3:
				sys.deletarImpressora();
			break;
			case 0:
				pausa = false;
			break;
		}
	}	
	

	private static void delegarFornm(int escolha) throws Exception {
		switch(escolha) {
			case 1:
				sys.criarFornecimento();
			break;
			case 2:
				sys.verFornecimentos();
			break;
			case 3:
				sys.deletarFornecimento();
			break;
			case 4:
				sys.verFornecimentosComFornEmp();
				break;
			case 0:
				pausa = false;
			break;
		}
	}	
	

	private static void delegarABS(int escolha) throws Exception {
		switch(escolha) {
			case 1:
				sys.criarAbastecimento();
			break;
			case 2:
				sys.verAbastecimentos();
			break;
			case 3:
				sys.deletarAbastecimento();
			break;
			case 4:
				sys.verAbastecimentosCompleto();
			break;
			case 5:
				sys.verAbastecimentosAgregacao();
			break;
			case 0:
				pausa = false;
			break;
		}
	}	
	
	private static void delegarGeral(int escolha) throws Exception {
		switch(escolha) {
			case 1:
				menuCRUD();
				delegarFornecedor(getEscolha(0, 3));
				
			break;
			case 2:
				menuCRUD();
				delegarMP(getEscolha(0, 3));
			break;
			case 3:
				menuCRUD();	
				delegarIMP(getEscolha(0, 3));
			break;
			case 4:
				menuCRUD();
				menuAbs();
				delegarABS(getEscolha(0,5));
			break;
			case 5:
				menuCRUD();
				menuForn();
				delegarFornm(getEscolha(0, 4));
			break;
			case 0:
				System.out.println("Terminando programa...");
				System.exit(0);
			break;
			default:
				throw new UnsupportedOperationException("Não existe a opção " + escolha);
		}
		
	}

	private static void menuGeral() {
		System.out.println("Menu geral, selecione o que quer alterar!!!");
		System.out.println("1 - Fornecedores");
		System.out.println("2 - Matérias primas");
		System.out.println("3 - Impressoras");
		System.out.println("4 - Abastecimento das impressoras");
		System.out.println("5 - Fornecimento das matérias primas");
		System.out.println("0 - Sair");
	}
	
	private static void menuCRUD() {
		System.out.println("Menu de alterações");
		System.out.println("0 - Voltar");
		System.out.println("1 - Criar");
		System.out.println("2 - Visualizar");
		System.out.println("3 - Excluir");
	}
	
	private static void menuForn() {
		System.out.println("4 - Visualizar fornecimento junto com fornecedor e materia prima");
	}
	private static void menuAbs() {
		System.out.println("4 - Visualizar abastecimentos junto com a impressora e a materia prima");
		System.out.println("5 - Visualizar a maior quantidade abastecida na data mais recente");
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		System.out.println("Começando programa...");
		
		try {
			con = new ConnectionFactory().createConnection();
			sys = new Sistema(con);
			int escolha = -1000;
			while(escolha != 0) {
				try {
					menuGeral();
					do {escolha = sc.nextInt(); } while(escolha < 0);
					sc.nextLine();
					delegarGeral(escolha);
					if(pausa) {pausaTela();}
					pausa = true;
				} catch(Exception e) {
					System.err.println(e.getMessage());
				}
					
			}
		} catch(Throwable t) {
			System.err.println(t.getMessage());
			t.printStackTrace();
		}
		

	}

}
