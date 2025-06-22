package negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import apresentacao.ViewFornecedor;
import apresentacao.ViewFornecimento;
import apresentacao.ViewImpressora;
import apresentacao.ViewMateriaPrima;
import modelos.Fornecedor;
import modelos.Fornecimento;
import modelos.Impressora;
import modelos.MateriaPrima;
import persistencia.FornecedorDAO;
import persistencia.FornecimentoDAO;
import persistencia.ImpressoraDAO;
import persistencia.MateriaPrimaDAO;

public class Sistema {
	private static ViewImpressora vi = null;
	private static ViewMateriaPrima vmp = null;
	private static ViewFornecedor vf = null;
	private static ViewFornecimento vfcm = null;
	private static ImpressoraDAO impressoraDAO = null;
	private static FornecedorDAO fornecedorDAO = null;
	private static MateriaPrimaDAO materiaPrimaDAO = null;
	private static FornecimentoDAO fornecimentoDAO = null;

	public Sistema() {

		vi = new ViewImpressora();
		vmp = new ViewMateriaPrima();
		vf = new ViewFornecedor();
		vfcm = new ViewFornecimento();

		impressoraDAO = new ImpressoraDAO();
		fornecedorDAO = new FornecedorDAO();
		materiaPrimaDAO = new MateriaPrimaDAO();
		fornecimentoDAO = new FornecimentoDAO();
	}

	
	public void criarImpressora(Connection con) throws SQLException {
		impressoraDAO.create(vi.criar(),con);
	}
	
	public List<Impressora> verImpressoras(Connection con) throws SQLException {
		List<Impressora> imps = impressoraDAO.selectAll(con);
		imps.forEach(System.out::println);
		return imps;
	}
	
	public void deletarImpressora(Connection con) throws SQLException {
		List<Impressora> imps = verImpressoras(con);
		int escolha = vi.deletar();
		for( Impressora i : imps ) {
			if(i.getId() == escolha) {
				imps.remove(i);
				impressoraDAO.remove(i, con);
				System.out.println("Impressora " + i + " removida");
				return;
			}
		}
		System.out.println("Id escolhido nao existe");
	}
	
	public void criarMateriaPrima( Connection con ) throws SQLException {
		materiaPrimaDAO.create(vmp.criar(), con);
	}
	
	public List<MateriaPrima> verMateriasPrimas( Connection con ) throws SQLException {
		List<MateriaPrima> mps = materiaPrimaDAO.selectAll(con);
		mps.forEach(System.out::println);
		return mps;
	}
	
	public void deletarMateriaPrima( Connection con ) throws SQLException {
		List<MateriaPrima> mps = verMateriasPrimas(con);
		int escolha = vmp.deletar();
		for( MateriaPrima mp : mps ) {
			if( mp.getId() == escolha ) {
				mps.remove(mp);
				materiaPrimaDAO.remove(mp, con);
				System.out.println("Materia prima " + mp + " removida");
				return;
			}
		}
		System.out.println("Id escolhido não existe");
	}
	
	public void criarFornecedor(Connection con) throws SQLException {
		fornecedorDAO.create(vf.criar(), con);
	}
	
	public List<Fornecedor> verFornecedores( Connection con ) throws SQLException {
		List<Fornecedor> fornecedores = fornecedorDAO.selectAll(con);
		fornecedores.forEach(System.out::println);
		return fornecedores;
	}
	
	public void deletarFornecedor( Connection con ) throws SQLException {
		List<Fornecedor> fornecedores = verFornecedores( con );
		int escolha = vf.deletar();
		for( Fornecedor f : fornecedores ) {
			if( f.getId() == escolha ) {
				fornecedores.remove(f);
				fornecedorDAO.remove(f, con);
				System.out.println("Fornecedor " + f + " removido");
				return;
			}
		}
		System.out.println("Id escolhido não existe");
	}
	
	public void criarFornecimento(Connection con) throws SQLException {
		verFornecedores(con);
		verMateriasPrimas(con);
		fornecimentoDAO.create(vfcm.criar(), con);
	}
	
	public List<Fornecimento> verFornecimentos(Connection con) throws SQLException {
		List<Fornecimento> fcms = fornecimentoDAO.selectAll(con);
		fcms.forEach(System.out::println);
		return fcms;
	}
	
	public void verFornecimentosComFornEmp(Connection con) throws SQLException {
		List<Fornecimento> fcms = fornecimentoDAO.selectAllWithMpForn(con);
		fcms.forEach(System.out::println);
	}
	
	public void deletarFornecimento( Connection con ) throws SQLException {
		List<Fornecimento> fcms = verFornecimentos( con );
		int escolha = vfcm.deletar();
		for( Fornecimento f : fcms ) {
			if( f.getId() == escolha ) {
				fcms.remove(f);
				fornecimentoDAO.remove(f, con);
				System.out.println("Fornecedor " + f + " removido");
				return;
			}
		}
		System.out.println("Id escolhido não existe");
	}
}