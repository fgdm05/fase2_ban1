package apresentacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import modelos.Abastecimento;

@SuppressWarnings("unused")
public class ViewAbastecimento implements View<Abastecimento> {

	private static Scanner sc = new Scanner(System.in);
	
	public ViewAbastecimento() {}
	
	@Override
	public Abastecimento criar() {
		throw new UnsupportedOperationException("Implementando");
		/*
		Abastecimento abs = new Abastecimento();
		System.out.println("Impressora (digite o id):");
		abs.setIdMateriaPrima(sc.nextInt());
		sc.nextLine();
		System.out.println("Materia Prima (digite o id):");
		abs.setIdImpressora(sc.nextInt());
		sc.nextLine();
		System.out.println("Quantidade: ");
		abs.setQuantidade(sc.nextInt());
		System.out.println("Data (DD/MM/AAAA): ");
		String data = sc.next();
		sc.nextLine();
		SimpleDateFormat conv = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.sql.Date sData = new java.sql.Date(conv.parse(data).getTime());
			abs.setData(sData);
			return abs;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		*/
	}

	@Override
	public int deletar() {
		throw new UnsupportedOperationException("Função ainda não implementada!");
	}

}