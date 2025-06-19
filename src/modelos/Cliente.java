package modelos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private int id;
	private String nome, email;
	private List<String> telefones;
	
	public Cliente() {
		telefones = new ArrayList<String>();
	}
	
	public Cliente(int id, String nome, String email, List<String> telefones) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefones = telefones;
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
}
