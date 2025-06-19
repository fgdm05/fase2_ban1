package modelos;

public class Fornecedor {
	private int id;
	private String cnpj, razaoSocial;
	public Fornecedor() {
	}
	
	public Fornecedor(int id, String cnpj, String razaoSocial) {
		this.id = id;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	
}
