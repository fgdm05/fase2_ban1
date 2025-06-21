package apresentacao;

import java.util.Scanner;

import modelos.Impressora;

public class ViewImpressora implements View<Impressora> {
	private static Scanner sc = new Scanner(System.in);
	public ViewImpressora() {
		// TODO Auto-generated constructor stub
	}
	
	public Impressora criar() {
		Impressora imp = new Impressora();
		System.out.println("Digite o nome da impressora");
		imp.setNome(sc.nextLine());
		System.out.println("Digite o nível de tinta Ciano");
		imp.setNvlCiano(Integer.parseInt(sc.next()));
		System.out.println("Digite o nível de tinta Amarelo");
		imp.setNvlAmarelo(Integer.parseInt(sc.next()));
		System.out.println("Digite o nível de tinta Magenta");
		imp.setNvlMagenta(Integer.parseInt(sc.next()));
		System.out.println("Digite o nível de tinta Preta");
		imp.setNvlPreto(Integer.parseInt(sc.next()));
		System.out.println("Impressora " + imp + " Criada com sucesso!" );
		return imp;
	}
	
	public int deletar() {
		System.out.println("Escolha o id da impressora que deseja deletar: ");
		int escolha = sc.nextInt();
		return escolha;
	}

}
