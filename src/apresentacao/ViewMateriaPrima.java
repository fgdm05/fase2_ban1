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
		
		System.out.println("Tipo de materia prima");
		System.out.println("F - folhas");
		System.out.println("A - tinta amarela");
		System.out.println("C - tinta ciano");
		System.out.println("M - tinta magenta");
		System.out.println("P - tinta preta");
		
		String tipo = sc.next().toLowerCase();
		while(!(tipo.equals("f") || tipo.equals("a") || tipo.equals("c") || tipo.equals("m") || tipo.equals("p"))) {
			tipo = sc.next().toLowerCase();
		}
 		mp.setTipoMateriaPrima(tipo);
		sc.nextLine();
		
		System.out.println(mp + " criada com sucesso!");
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
