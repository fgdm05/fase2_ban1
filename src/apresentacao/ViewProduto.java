package apresentacao;

import java.util.Scanner;

import modelos.Produto;

public class ViewProduto implements View<Produto> {
	private static Scanner sc = new Scanner(System.in);
	
	public Produto criar() {
		Produto p = new Produto();
		System.out.println("Nome: ");
		p.setNome(sc.nextLine());
		System.out.println("Preço: ");
		p.setPreco(Double.parseDouble(sc.nextLine()));
		
		System.out.println(String.format("Produto %s criado!", p));
		
		return p;
	}
	
	public int deletar(int size) {
		System.out.println("Escolha o id do produto que deseja deletar: ");
		int escolha = -1;
		while(escolha < 0 || escolha > size) {escolha = sc.nextInt(); }
		return escolha;
	}
}
