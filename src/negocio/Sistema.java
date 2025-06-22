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

public class Sistema {
	static ViewCliente vc = null;
	static ViewProduto vp = null;
	static ViewImpressora vi = null;
	static ViewMateriaPrima vmp = null;
	static ViewFornecedor vf = null;
	static List<Cliente> clientes = null;
	static List<Produto> produtos = null;
	static List<Impressora> impressoras = null;
	static List<MateriaPrima> materiasPrimas = null;
	static FornecedorDAO fornecedorDAO = null;
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
		impressoras = new ArrayList<Impressora>();
		materiasPrimas = new ArrayList<MateriaPrima>();
		fornecedorDAO = new FornecedorDAO();
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
				System.out.println("Produto" + p + "removido");
				return;
			}
		}
		System.out.println("Id escolhido nao existe");
	}
	
	public void criarImpressora() {
		impressoras.add(vi.criar());
	}
	
	public void verImpressoras() {
		impressoras.forEach(System.out::println);
	}
	
	public void deletarImpressora() {
		verImpressoras();
		int escolha = vi.deletar();
		for( Impressora i : impressoras ) {
			if(i.getId() == escolha) {
				impressoras.remove(i);
				System.out.println("Impressora" + i + "removida");
				return;
			}
		}
		System.out.println("Id escolhido nao existe");
	}
	
	public void criarMateriaPrima() {
		materiasPrimas.add(vmp.criar());
	}
	
	public void verMateriasPrimas() {
		materiasPrimas.forEach(System.out::println);
	}
	
	public void deletarMateriaPrima() {
		verMateriasPrimas();
		int escolha = vmp.deletar();
		for( MateriaPrima mp : materiasPrimas ) {
			if( mp.getId() == escolha ) {
				materiasPrimas.remove(mp);
				System.out.println("Materia prima" + mp + "removida");
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
				System.out.println("Fornecedor" + f + "removida");
				return;
			}
		}
		System.out.println("Id escolhido não existe");
	}
}