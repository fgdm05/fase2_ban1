package apresentacao;

import java.util.Scanner;
import modelos.Cliente;

public class ViewCliente implements View<Cliente> {

	private static Scanner sc = new Scanner(System.in);
	
	
	void perguntaHeranca(Cliente c) {
		switch(c.getTipoCliente()) {
			case 1:
				System.out.println("Formato CPF: 12345678900");
				System.out.println("CPF: ");
				c.setCpf(sc.next("[0-9]{11}"));
			break;
			case 2:
				System.out.println("Formato CNPJ: 12345678900000");
				System.out.println("CNPJ: ");
				c.setCnpj(sc.next("[0-9]{14}"));
				System.out.println("Razao social: ");
				c.setRazaoSocial(sc.next());
			break;
			default:
			break;
		}
	}
	
	public Cliente criar() {
		Cliente c = new Cliente();
		System.out.println("Criando um Cliente");
		System.out.println("Qual é o tipo de cliente?");
		System.out.println("1 - Pessoa Física");
		System.out.println("2 - Pessoa Jurídica");
		int escolha = -1;
		while(!(escolha == 1 || escolha == 2)) {escolha = sc.nextInt(); }
		c.setTipoCliente(escolha);
		
		System.out.println("Nome: ");
		c.setNome(sc.next());
		System.out.println("E-mail: ");
		c.setEmail(sc.next());
		System.out.println("Telefone: ");
		c.addTelefone(sc.next());
		
		perguntaHeranca(c);
		
		System.out.println(String.format("Cliente %s criado!", c));
		return c;
	}
	
}