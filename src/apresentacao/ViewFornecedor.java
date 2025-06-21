package apresentacao;

import java.util.Scanner;

import modelos.Fornecedor;

public class ViewFornecedor implements View<Fornecedor> {
	private static Scanner sc = new Scanner(System.in);
	public ViewFornecedor() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Fornecedor criar() {
		Fornecedor f = new Fornecedor();
		System.out.println("Nome: ");
		f.setNome(sc.nextLine());
		System.out.println("Formato CNPJ: 12345678900000");
		System.out.println("CNPJ: ");
		f.setCnpj(sc.next("[0-9]{14}"));
		System.out.println("Razao social: ");
		f.setRazaoSocial(sc.nextLine());
		return f;
	}
	@Override
	public int deletar() {
		System.out.println("Escolha o id do fornecedor que deseja deletar: ");
		int escolha = sc.nextInt();
		return escolha;
	}
	
}
