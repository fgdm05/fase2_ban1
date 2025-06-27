package apresentacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import modelos.Fornecimento;

public class ViewFornecimento implements View<Fornecimento> {
	
	private static Scanner sc = new Scanner(System.in);

	public ViewFornecimento() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fornecimento criar() {
		try {
			Fornecimento f = new Fornecimento();
			System.out.println("Fornecedor (Digite o id): ");
			f.setIdFornecedor(sc.nextInt());
			sc.nextLine();
			System.out.println("Materia Prima (Digite o id): ");
			f.setIdMateriaPrima(sc.nextInt());
			sc.nextLine();
			System.out.println("Quantidade: ");
			f.setQuantidade(sc.nextInt());
			sc.nextLine();
			System.out.println("Data (DD/MM/AAAA): ");
			String data = sc.next();
			sc.nextLine();
			SimpleDateFormat conversao = new SimpleDateFormat("dd/MM/yyyy");
			
			java.sql.Date sData = new java.sql.Date(conversao.parse(data).getTime());
			f.setDataHoraForn(sData);
			System.out.println("Hora (hh:MM:ss)");
			String hora = sc.next();
			sc.nextLine();
			java.sql.Time time = java.sql.Time.valueOf(hora);
			f.setTime(time);
			
			return f;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deletar() {
		System.out.println("Escolha o id do fornecimento que deseja deletar: ");
		int escolha = sc.nextInt();
		sc.nextLine();
		return escolha;
	}

}
