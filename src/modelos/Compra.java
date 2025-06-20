package modelos;

import java.util.Date;
import java.util.List;

public class Compra {
	private int id;
	private Impressao imp;
	private int quantidade;
	private Date datetime;
	
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Compra(int id, Impressao imp, int quantidade, Date datetime) {
		super();
		this.id = id;
		this.imp = imp;
		this.quantidade = quantidade;
		this.datetime = datetime;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Impressao getImp() {
		return imp;
	}


	public void setImp(Impressao imp) {
		this.imp = imp;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public Date getDatetime() {
		return datetime;
	}


	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	
}
