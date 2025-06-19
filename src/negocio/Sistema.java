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
}