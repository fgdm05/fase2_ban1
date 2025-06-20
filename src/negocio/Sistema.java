package negocio;

import java.util.ArrayList;
import java.util.List;

import apresentacao.ViewCliente;
import apresentacao.ViewProduto;
import modelos.Cliente;
import modelos.Produto;

public class Sistema {
	static ViewCliente vc = null;
	static ViewProduto vp = null;
	static List<Cliente> clientes = null;
	static List<Produto> produtos = null;
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
		produtos = new ArrayList<Produto>();
	}
	public void verClientes() {
		clientes.forEach(System.out::println);
	}
	
	public void criarCliente() {
		clientes.add(vc.criar());
	}
	public void deletarCliente() {
		verClientes();
		int escolha = vc.deletar(clientes.size());
		for(int i = 0; i < clientes.size(); i++) {
			if(escolha == clientes.get(i).getId()) {
				Cliente c = clientes.remove(i);
				System.out.println("Cliente " + c + " removido");
				break;
			}
		}
	}
	
	public void criarProduto() {
		produtos.add(vp.criar());
	}
	
	public void verProdutos() {
		produtos.forEach(System.out::println);
	}
	public void deletarProduto() {
		verProdutos();
		int escolha = vp.deletar(produtos.size());
		for (Produto p : produtos) {
			if(p.getId() == escolha) {
				produtos.remove(p);
				System.out.println("Produto" + p + "removido");
				break;
			}
		}
	}
}