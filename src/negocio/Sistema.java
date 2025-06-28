package negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import apresentacao.ViewAbastecimento;
import apresentacao.ViewFornecedor;
import apresentacao.ViewFornecimento;
import apresentacao.ViewImpressora;
import apresentacao.ViewMateriaPrima;
import exceptions.DeleteException;
import modelos.Abastecimento;
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
	private static ViewAbastecimento vabs = null;
	
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
		vabs = new ViewAbastecimento();

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
	
	public void deletarImpressora() throws SQLException, DeleteException {
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
		throw new DeleteException("Id escolhido não existe");
	}
	
	public void criarMateriaPrima() throws SQLException {
		materiaPrimaDAO.create(vmp.criar());
	}
	
	public List<MateriaPrima> verMateriasPrimas() throws SQLException {
		List<MateriaPrima> mps = materiaPrimaDAO.selectAll();
		mps.forEach(System.out::println);
		return mps;
	}
	
	public void deletarMateriaPrima( ) throws SQLException, DeleteException {
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
		throw new DeleteException("Id escolhido não existe");
	}
	
	public void criarFornecedor() throws SQLException {
		fornecedorDAO.create(vf.criar());
	}
	
	public List<Fornecedor> verFornecedores( ) throws SQLException {
		List<Fornecedor> fornecedores = fornecedorDAO.selectAll();
		fornecedores.forEach(System.out::println);
		return fornecedores;
	}
	
	public void deletarFornecedor( ) throws SQLException, DeleteException {
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
		throw new DeleteException("Id escolhido não existe");
	}
	
	public void criarFornecimento() throws Exception {
		List<Fornecedor> forns = verFornecedores();
		List<MateriaPrima> mps = verMateriasPrimas();
		Fornecimento criar = vfcm.criar();
		
		int i = 0;
		for(; i < forns.size(); i++) {
			if(criar.getIdFornecedor() == forns.get(i).getId()) {
				break;
			}
		}
		if(i == forns.size()) { throw new Exception(String.format("Não existe fornecedor com id %d", criar.getIdFornecedor()));}
		
		i = 0;
		for(; i < mps.size(); i++) {
			if(criar.getIdMateriaPrima() ==  mps.get(i).getId()) {
				break;
			}
		}
		if(i == mps.size()) {throw new Exception(String.format("Nao existe materia prima com id %d", criar.getIdMateriaPrima()));}
		
		
		
		fornecimentoDAO.create(criar);
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
	
	public void deletarFornecimento() throws SQLException, DeleteException {
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
		throw new DeleteException("Id escolhido não existe");
	}


	public void criarAbastecimento() throws Exception {
		List<Impressora> imps = verImpressoras();
		List<MateriaPrima> mps = verMateriasPrimas();
		Abastecimento abs = vabs.criar();
		int i = 0;
		for(; i < imps.size(); i++) {
			if(abs.getIdImpressora() == imps.get(i).getId()) {
				break;
			}
		}
		if(i == imps.size()) { throw new Exception(String.format("Não existe impressora com id %d", abs.getIdImpressora()));}
		
		i = 0;
		for(; i < mps.size(); i++) {
			if(abs.getIdMateriaPrima() ==  mps.get(i).getId()) {
				break;
			}
		}
		if(i == mps.size()) {throw new Exception(String.format("Nao existe materia prima com id %d", abs.getIdMateriaPrima()));}
		
		
		abastecimentoDAO.create(abs);
	}


	public List<Abastecimento> verAbastecimentos() throws SQLException {
		List<Abastecimento> list = abastecimentoDAO.select();
		list.forEach(System.out::println);
		return list;
	}


	public void deletarAbastecimento() throws SQLException, DeleteException {
		List<Abastecimento> list = verAbastecimentos();
		int deletar = vabs.deletar();
		for( Abastecimento abs : list ) {
			if( abs.getIdAbastecimento() == deletar ) {
				list.remove(abs);
				abastecimentoDAO.delete(abs);
				System.out.println(abs + " removido");
				return;
			}
		}
		throw new DeleteException("Id escolhido nao existe");
	}


	public List<Abastecimento> verAbastecimentosCompleto() throws SQLException {
		List<Abastecimento> selectAll = abastecimentoDAO.selectAll();
		selectAll.forEach(System.out::println);
		return selectAll;
	}


	public List<Abastecimento> verAbastecimentosAgregacao() throws SQLException {
		var valor = abastecimentoDAO.selectAgregacao();
		valor.forEach(System.out::println);
		return valor;
	}
}