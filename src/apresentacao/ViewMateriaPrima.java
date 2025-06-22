package apresentacao;

import java.util.Scanner;

import modelos.MateriaPrima;

public class ViewMateriaPrima implements View<MateriaPrima> {
	private static Scanner sc = new Scanner(System.in);
	public ViewMateriaPrima() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public MateriaPrima criar() {
		MateriaPrima mp = new MateriaPrima();
		System.out.println("Nome da materia prima: ");
		mp.setNome(sc.nextLine());
		System.out.println("Quantidade: ");
		mp.setQuantidade(Integer.parseInt(sc.next()));
		System.out.println("Materia prima " + mp + " criada com sucesso!");
		return mp;
	}
	@Override
	public int deletar() {
		System.out.println("Escolha o id da materia prima que deseja deletar: ");
		int escolha = sc.nextInt();
		sc.nextLine();
		return escolha;
	}
	
	
	
}
