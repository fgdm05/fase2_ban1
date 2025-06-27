package apresentacao;

import java.sql.Time;
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
		try {
			Abastecimento abs = new Abastecimento();
			System.out.println("Impressora (digite o id):");
			abs.setIdImpressora(sc.nextInt());
			sc.nextLine();
			
			System.out.println("Materia Prima (digite o id):");
			abs.setIdMateriaPrima(sc.nextInt());
			sc.nextLine();
			
			System.out.println("Quantidade: ");
			abs.setQuantidade(sc.nextInt());
			sc.nextLine();
			
			System.out.println("Data (DD/MM/AAAA): ");
			String data = sc.next();
			sc.nextLine();
			SimpleDateFormat conv = new SimpleDateFormat("dd/MM/yyyy");
			
			java.sql.Date sData = new java.sql.Date(conv.parse(data).getTime());
			abs.setData(sData);
			
			System.out.println("Hora (hh:MM:ss):");
			String hora = sc.next();
			sc.nextLine();
			
			
			java.sql.Time a = java.sql.Time.valueOf(hora);
			System.out.println(a);
			
			abs.setTime(a);
			
			return abs;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public int deletar() {
		System.out.println("Escolha o id do abastecimento a ser removido: ");
		int id = sc.nextInt();
		sc.nextLine();
		return id;
		
		
	}

}