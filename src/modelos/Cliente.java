package modelos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private int id;
	private int tipoCliente;
	private String nome, email;
	private List<String> telefones;
	private String cpf;
	private String cnpj, razaoSocial;
	
	public Cliente() {
		tipoCliente = -1;
		telefones = new ArrayList<String>();
	}
	
	public Cliente(int id, String nome, String email, List<String> telefones) {
		this();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefones = telefones;
	}
	public String getCnpj() {
		return cnpj;
	}
	public String getCpf() {
		return cpf;
	}
	public int getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(int tipoCliente) {
		if(this.tipoCliente == -1)
			this.tipoCliente = tipoCliente;
	}
	public void setCnpj(String cnpj) {
		if(tipoCliente == 2)
			this.cnpj = cnpj;
	}
	public void setRazaoSocial(String razaoSocial) {
		if(tipoCliente == 2)
			this.razaoSocial = razaoSocial;
	}
	public void setCpf(String cpf) {
		if(tipoCliente == 1)
			this.cpf = cpf;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}
	
	public void addTelefone(String telefone) {
		telefones.add(telefone);
	}
	
	public void rmvTelefone(String telefone) {
		telefones.remove(telefone);
	}
	
	@Override
	public String toString() {
		if(tipoCliente == 1) {
			return String.format("[Cliente %s, %s, %s, %s]", nome, email, telefones.get(0), cpf);
		} else if(tipoCliente == 2) {
			return String.format("[Cliente %s, %s, %s, %s, %s]", nome, email, telefones.get(0), cnpj, razaoSocial);
		} else {
			return String.format("[Cliente %s, %s, %s]", nome, email, telefones.get(0));
		}
	}
}
