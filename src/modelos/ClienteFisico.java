package modelos;

import java.util.List;

public class ClienteFisico extends Cliente {
	private String cpf;
	public ClienteFisico() {
		super();
	}
	
	public ClienteFisico(int id, String nome, String email, List<String> telefones, String cpf) {
		super(id, nome, email, telefones);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
