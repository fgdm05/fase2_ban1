package modelos;

public class Fornecedor {
	private int id;
	private String nome, cnpj, razaoSocial;
	public Fornecedor() {
	}
	
	public Fornecedor(int id, String nome, String cnpj, String razaoSocial) {
		super();
		this.id = id;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		String format = String.format("Fornecedor"
				+ "\n\tid: %d"
				+ "\n\tnome: %s"
				+ "\n\tcnpj: %s"
				+ "\n\trazaoSocial: %s"
				, id, nome, cnpj, razaoSocial);
		return format;
	}
	
	
	
	
}
