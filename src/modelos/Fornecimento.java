package modelos;

import java.sql.Time;
import java.text.SimpleDateFormat;

public class Fornecimento {
	private int id, quantidade, idFornecedor, idMateriaPrima;
	private java.sql.Date data;
	private Fornecedor fornecedor = null;
	private MateriaPrima materiaPrima = null;
	private Time time;
	public Fornecimento() {

	}
	public Fornecimento(int id, int quantidade, java.sql.Date data, int idFornecedor, int idMateriaPrima, Time time) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.idFornecedor = idFornecedor;
		this.idMateriaPrima = idMateriaPrima;
		this.data = data;
		this.time = time;
	}
	
	public void convertData(java.util.Date data) {
		this.data = new java.sql.Date(data.getTime());
	}
	public Time getTime() {
		return time;
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
	public java.sql.Date getData() {
		return data;
	}
	public void setDataHoraForn(java.sql.Date dataHoraForn) {
		this.data = dataHoraForn;
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String format = String.format("Fornecimento"
				+ "\n\tid: %d"
				+ "\n\tquantidade: %d"
				+ "\n\tdata: %s,"
				+ "\n\thora: %s"
				, id, quantidade, sdf.format(data), time);
		
		
		if( fornecedor != null && materiaPrima != null ) {
			format += String.format(
					"\n\tfornecedor: %s" +
					"\n\tmateriaprima: %s"
					, fornecedor, materiaPrima);
		}
		return format;
	}
	public void setTime(Time time) {
		this.time=time;
	}
	
	

}
