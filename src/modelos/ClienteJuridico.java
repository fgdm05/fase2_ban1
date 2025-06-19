package modelos;

import java.util.List;

public class ClienteJuridico extends Cliente {
	private String cnpj, razaoSocial;
	public ClienteJuridico() {
		super();
	}

	public ClienteJuridico(int id, String nome, String email, List<String> telefones, String cnpj,
						   String razaoSocial) {
		super(id, nome, email, telefones);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
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
