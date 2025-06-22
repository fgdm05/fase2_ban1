package modelos;

import java.util.Date;

public class Fornecimento {
	private int id, quantidade, idFornecedor, idMateriaPrima;
	private java.sql.Date dataHoraForn;
	private Fornecedor fornecedor = null;
	private MateriaPrima materiaPrima = null;
	public Fornecimento() {

	}
	public Fornecimento(int id, int quantidade, java.sql.Date dataHoraForn, int idFornecedor, int idMateriaPrima) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.idFornecedor = idFornecedor;
		this.idMateriaPrima = idMateriaPrima;
		this.dataHoraForn = dataHoraForn;
	}
	
	public void convertData(java.util.Date data) {
		dataHoraForn = new java.sql.Date(data.getTime());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public int getIdMateriaPrima() {
		return idMateriaPrima;
	}
	public void setIdMateriaPrima(int idMateriaPrima) {
		this.idMateriaPrima = idMateriaPrima;
	}
	public java.sql.Date getDataHoraForn() {
		return dataHoraForn;
	}
	public void setDataHoraForn(java.sql.Date dataHoraForn) {
		this.dataHoraForn = dataHoraForn;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	@Override
	public String toString() {
		if( fornecedor != null && materiaPrima != null ) {
			return "Fornecimento [id=" + id + ", quantidade=" + quantidade + ", " + fornecedor
					+ ", " + materiaPrima + ", dataHoraForn=" + dataHoraForn + "]";
		}
		return "Fornecimento [id=" + id + ", quantidade=" + quantidade + ", idFornecedor=" + idFornecedor
				+ ", idMateriaPrima=" + idMateriaPrima + ", dataHoraForn=" + dataHoraForn + "]";
	}
	
	

}
