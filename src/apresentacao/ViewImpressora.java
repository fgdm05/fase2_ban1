package apresentacao;

import java.util.Scanner;

import modelos.Impressora;

public class ViewImpressora implements View<Impressora> {
	private static Scanner sc = new Scanner(System.in);
	public ViewImpressora() {
		// TODO Auto-generated constructor stub
	}
	
	private static int checkQuantidade() {
		int tinta = sc.nextInt();
		while(tinta < 0) {
			System.out.println("Quantidade não pode ser negativa!");
			tinta = sc.nextInt();
			sc.nextLine();
		}
		return tinta;
	}
	
	public Impressora criar() {
		Impressora imp = new Impressora();
		System.out.println("Digite o nome da impressora");
		imp.setNome(sc.nextLine());
		System.out.println("Digite o nível de tinta Ciano");
		imp.setNvlCiano(checkQuantidade());
		System.out.println("Digite o nível de tinta Amarelo");
		imp.setNvlAmarelo(checkQuantidade());
		System.out.println("Digite o nível de tinta Magenta");
		imp.setNvlMagenta(checkQuantidade());
		System.out.println("Digite o nível de tinta Preta");
		imp.setNvlPreto(checkQuantidade());
		
		System.out.println("Digite quantas folhas tem: ");
		imp.setFolhas(checkQuantidade());
		
		System.out.println(imp + " Criada com sucesso!" );
		return imp;
	}
	
	public int deletar() {
		System.out.println("Escolha o id da impressora que deseja deletar: ");
		int escolha = sc.nextInt();
		return escolha;
	}

}
