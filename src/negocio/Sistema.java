package negocio;

import java.util.ArrayList;
import java.util.List;

import apresentacao.ViewCliente;
import modelos.Cliente;

public class Sistema {
	static ViewCliente vc = null;
	static List<Cliente> clientes = null;
	static {
		clientes = new ArrayList<Cliente>();
		vc = new ViewCliente();
		Cliente c = new Cliente(1, "A", "A", new ArrayList<String>());
		clientes.add(c);
		c.addTelefone("23456789");
	}
	public Sistema() {	}
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
}