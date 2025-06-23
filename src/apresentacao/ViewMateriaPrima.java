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
		System.out.println("Digite 1, caso a materia prima possua volume ou 0, caso nao possua");
		System.out.println("Ex de materia prima que possui volume: Tinta p/impressora");
		int opt = sc.nextInt();
		sc.nextLine();
		switch(opt) {
		case 1:
			System.out.println("Digite o volume da materia prima: ");
			sc.nextLine();
			break;
		default:
			break;
		}
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
