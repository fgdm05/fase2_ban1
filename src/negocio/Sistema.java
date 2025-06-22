package negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import apresentacao.ViewCliente;
import apresentacao.ViewFornecedor;
import apresentacao.ViewImpressora;
import apresentacao.ViewMateriaPrima;
import apresentacao.ViewProduto;
import modelos.Cliente;
import modelos.Fornecedor;
import modelos.Impressora;
import modelos.MateriaPrima;
import modelos.Produto;
import persistencia.FornecedorDAO;
import persistencia.ImpressoraDAO;
import persistencia.MateriaPrimaDAO;

public class Sistema {
	static ViewCliente vc = null;
	static ViewProduto vp = null;
	static ViewImpressora vi = null;
	static ViewMateriaPrima vmp = null;
	static ViewFornecedor vf = null;
	static List<Cliente> clientes = null;
	static List<Produto> produtos = null;
	static ImpressoraDAO impressoraDAO = null;
	static FornecedorDAO fornecedorDAO = null;
	static MateriaPrimaDAO materiaPrimaDAO = null;
	static {
		clientes = new ArrayList<Cliente>();
		vc = new ViewCliente();
		Cliente c = new Cliente(1, "A", "A", new ArrayList<String>());
		clientes.add(c);
		c.addTelefone("23456789");
	}
	public Sistema() {
		vc = new ViewCliente();
		vp = new ViewProduto();
		vi = new ViewImpressora();
		vmp = new ViewMateriaPrima();
		vf = new ViewFornecedor();
		produtos = new ArrayList<Produto>();
		impressoraDAO = new ImpressoraDAO();
		fornecedorDAO = new FornecedorDAO();
		materiaPrimaDAO = new MateriaPrimaDAO();
	}
	public void verClientes() {
		clientes.forEach(System.out::println);
	}
	
	public void criarCliente() {
		clientes.add(vc.criar());
	}
	public void deletarCliente() {
		verClientes();
		int escolha = vc.deletar();
		for(int i = 0; i < clientes.size(); i++) {
			if(escolha == clientes.get(i).getId()) {
				Cliente c = clientes.remove(i);
				System.out.println("Cliente " + c + " removido");
				return;
			}
		}
		System.out.println("Id escolhido nao existe");
	}
	
	public void criarProduto() {
		produtos.add(vp.criar());
	}
	
	public void verProdutos() {
		produtos.forEach(System.out::println);
	}
	public void deletarProduto() {
		verProdutos();
		int escolha = vp.deletar();
		for (Produto p : produtos) {
			if(p.getId() == escolha) {
				produtos.remove(p);
				System.out.println("Produto " + p + " removido");
				return;
			}
		}
		System.out.println("Id escolhido nao existe");
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
}