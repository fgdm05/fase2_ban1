package negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import apresentacao.ViewFornecedor;
import apresentacao.ViewFornecimento;
import apresentacao.ViewImpressora;
import apresentacao.ViewMateriaPrima;
import modelos.Fornecedor;
import modelos.Fornecimento;
import modelos.Impressora;
import modelos.MateriaPrima;
import persistencia.AbastecimentoDAO;
import persistencia.FornecedorDAO;
import persistencia.FornecimentoDAO;
import persistencia.ImpressoraDAO;
import persistencia.MateriaPrimaDAO;

public class Sistema {
	private static Connection con = null;
	private static ViewImpressora vi = null;
	private static ViewMateriaPrima vmp = null;
	private static ViewFornecedor vf = null;
	private static ViewFornecimento vfcm = null;
	private static ImpressoraDAO impressoraDAO = null;
	private static FornecedorDAO fornecedorDAO = null;
	private static MateriaPrimaDAO materiaPrimaDAO = null;
	private static FornecimentoDAO fornecimentoDAO = null;
	private static AbastecimentoDAO abastecimentoDAO = null;
	
	public Sistema(Connection con) {
		
		this.con = con;
		
		vi = new ViewImpressora();
		vmp = new ViewMateriaPrima();
		vf = new ViewFornecedor();
		vfcm = new ViewFornecimento();

		impressoraDAO = new ImpressoraDAO(con);
		fornecedorDAO = new FornecedorDAO(con);
		materiaPrimaDAO = new MateriaPrimaDAO(con);
		fornecimentoDAO = new FornecimentoDAO(con);
		abastecimentoDAO = new AbastecimentoDAO(con);
	}

	
	public void criarImpressora() throws SQLException {
		impressoraDAO.create(vi.criar());
	}
	
	public List<Impressora> verImpressoras() throws SQLException {
		List<Impressora> imps = impressoraDAO.selectAll();
		imps.forEach(System.out::println);
		return imps;
	}
	
	public void deletarImpressora() throws SQLException {
		List<Impressora> imps = verImpressoras();
		int escolha = vi.deletar();
		for( Impressora i : imps ) {
			if(i.getId() == escolha) {
				imps.remove(i);
				impressoraDAO.remove(i);
				System.out.println("Impressora " + i + " removida");
				return;
			}
		}
		System.out.println("Id escolhido nao existe");
	}
	
	public void criarMateriaPrima() throws SQLException {
		materiaPrimaDAO.create(vmp.criar());
	}
	
	public List<MateriaPrima> verMateriasPrimas() throws SQLException {
		List<MateriaPrima> mps = materiaPrimaDAO.selectAll();
		mps.forEach(System.out::println);
		return mps;
	}
	
	public void deletarMateriaPrima( ) throws SQLException {
		List<MateriaPrima> mps = verMateriasPrimas();
		int escolha = vmp.deletar();
		for( MateriaPrima mp : mps ) {
			if( mp.getId() == escolha ) {
				mps.remove(mp);
				materiaPrimaDAO.remove(mp);
				System.out.println("Materia prima " + mp + " removida");
				return;
			}
		}
		System.out.println("Id escolhido não existe");
	}
	
	public void criarFornecedor() throws SQLException {
		fornecedorDAO.create(vf.criar());
	}
	
	public List<Fornecedor> verFornecedores( ) throws SQLException {
		List<Fornecedor> fornecedores = fornecedorDAO.selectAll();
		fornecedores.forEach(System.out::println);
		return fornecedores;
	}
	
	public void deletarFornecedor( ) throws SQLException {
		List<Fornecedor> fornecedores = verFornecedores();
		int escolha = vf.deletar();
		for( Fornecedor f : fornecedores ) {
			if( f.getId() == escolha ) {
				fornecedores.remove(f);
				fornecedorDAO.remove(f);
				System.out.println("Fornecedor " + f + " removido");
				return;
			}
		}
		System.out.println("Id escolhido não existe");
	}
	
	public void criarFornecimento() throws SQLException {
		verFornecedores();
		verMateriasPrimas();
		fornecimentoDAO.create(vfcm.criar());
	}
	
	public List<Fornecimento> verFornecimentos() throws SQLException {
		List<Fornecimento> fcms = fornecimentoDAO.selectAll();
		fcms.forEach(System.out::println);
		return fcms;
	}
	
	public void verFornecimentosComFornEmp() throws SQLException {
		List<Fornecimento> fcms = fornecimentoDAO.selectAllWithMpForn();
		fcms.forEach(System.out::println);
	}
	
	public void deletarFornecimento() throws SQLException {
		List<Fornecimento> fcms = verFornecimentos();
		int escolha = vfcm.deletar();
		for( Fornecimento f : fcms ) {
			if( f.getId() == escolha ) {
				fcms.remove(f);
				fornecimentoDAO.remove(f);
				System.out.println("Fornecedor " + f + " removido");
				return;
			}
		}
		System.out.println("Id escolhido não existe");
	}
}