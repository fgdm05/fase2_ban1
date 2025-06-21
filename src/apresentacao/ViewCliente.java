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
				c.setRazaoSocial(sc.nextLine());
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
		while(!(escolha == 1 || escolha == 2)) {escolha = Integer.parseInt(sc.nextLine()); }
		c.setTipoCliente(escolha);
		
		System.out.println("Nome: ");
		c.setNome(sc.nextLine());
		System.out.println("E-mail: ");
		c.setEmail(sc.next());
		System.out.println("Telefone: ");
		c.addTelefone(sc.next());
//		System.out.println("Telefones (digite -1 p/sair): ");
//		String tel = "0";
//		while (!tel.equals("-1")) {
//			tel = sc.next();
//			if(!tel.equals("-1")) {
//				c.addTelefone(tel);
//			}
//		}
		perguntaHeranca(c);
		
		System.out.println(String.format("Cliente %s criado!", c));
		return c;
	}

	public int deletar() {
		System.out.println("Escolha o id para deletar o cliente");
		int escolha = Integer.parseInt(sc.nextLine());
		return escolha;
	}
	
}