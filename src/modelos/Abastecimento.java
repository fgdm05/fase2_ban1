package modelos;

import java.sql.Date;

public class Abastecimento {
	private int idAbastecimento, idImpressora, idMateriaPrima;
	private java.sql.Date data;
	private int quantidade;
	private Impressora impressora = null;
	private MateriaPrima materiaPrima = null;
	
	public Abastecimento() {}
	
	public Abastecimento(int idAbastecimento, int idImpressora, int idMateriaPrima, Date data, int quantidade) {
		super();
		this.idAbastecimento = idAbastecimento;
		this.idImpressora = idImpressora;
		this.idMateriaPrima = idMateriaPrima;
		this.data = data;
		this.quantidade = quantidade;
	}

	public int getIdAbastecimento() {
		return idAbastecimento;
	}

	public void setIdAbastecimento(int idAbastecimento) {
		this.idAbastecimento = idAbastecimento;
	}

	public int getIdImpressora() {
		return idImpressora;
	}

	public void setIdImpressora(int idImpressora) {
		this.idImpressora = idImpressora;
	}

	public int getIdMateriaPrima() {
		return idMateriaPrima;
	}

	public void setIdMateriaPrima(int idMateriaPrima) {
		this.idMateriaPrima = idMateriaPrima;
	}

	public java.sql.Date getData() {
		return data;
	}

	public void setData(java.sql.Date data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Impressora getImpressora() {
		return impressora;
	}

	public void setImpressora(Impressora impressora) {
		this.impressora = impressora;
	}

	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	
	
	
}