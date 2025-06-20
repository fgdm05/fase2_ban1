package modelos;

public class Impressao {
	private int id;
	private boolean colorido;
	private String tipoFolha;
	private Produto prod;
	private Impressora imp;
	public Impressao() {
		// TODO Auto-generated constructor stub
	}
	public Impressao(int id, boolean colorido, String tipoFolha, Produto prod, Impressora imp) {
		super();
		this.id = id;
		this.colorido = colorido;
		this.tipoFolha = tipoFolha;
		this.prod = prod;
		this.imp = imp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isColorido() {
		return colorido;
	}
	public void setColorido(boolean colorido) {
		this.colorido = colorido;
	}
	public String getTipoFolha() {
		return tipoFolha;
	}
	public void setTipoFolha(String tipoFolha) {
		this.tipoFolha = tipoFolha;
	}
	public Produto getProd() {
		return prod;
	}
	public void setProd(Produto prod) {
		this.prod = prod;
	}
	public Impressora getImp() {
		return imp;
	}
	public void setImp(Impressora imp) {
		this.imp = imp;
	}
	
	

}
