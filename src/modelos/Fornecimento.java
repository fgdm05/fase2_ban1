package modelos;

import java.util.Date;

public class Fornecimento {
	private int id, quantidade, idFornecedor, idMateriaPrima;
	private Date dataHoraForn;
	public Fornecimento() {

	}
	public Fornecimento(int id, int quantidade, int idFornecedor, int idMateriaPrima, Date dataHoraForn) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.idFornecedor = idFornecedor;
		this.idMateriaPrima = idMateriaPrima;
		this.dataHoraForn = dataHoraForn;
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
	public Date getDataHoraForn() {
		return dataHoraForn;
	}
	public void setDataHoraForn(Date dataHoraForn) {
		this.dataHoraForn = dataHoraForn;
	}
	
	

}
