package modelos;

public class Impressora {
	private String nome;
	private int id, nvlCiano, nvlMagenta, nvlAmarelo, nvlPreto, folhas;
	public Impressora() {
	}
	
	public Impressora(int id, String nome, int nvlCiano, int nvlMagenta, int nvlAmarelo, int nvlPreto, int quantidade) {
		this.nome = nome;
		this.id = id;
		this.nvlCiano = nvlCiano;
		this.nvlMagenta = nvlMagenta;
		this.nvlAmarelo = nvlAmarelo;
		this.nvlPreto = nvlPreto;
		this.folhas = quantidade;
	}
	
	public int getFolhas() {
		return folhas;
	}

	public void setFolhas(int folhas) {
		this.folhas = folhas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNvlCiano() {
		return nvlCiano;
	}
	public void setNvlCiano(int nvlCiano) {
		this.nvlCiano = nvlCiano;
	}
	public int getNvlMagenta() {
		return nvlMagenta;
	}
	public void setNvlMagenta(int nvlMagenta) {
		this.nvlMagenta = nvlMagenta;
	}
	public int getNvlAmarelo() {
		return nvlAmarelo;
	}
	public void setNvlAmarelo(int nvlAmarelo) {
		this.nvlAmarelo = nvlAmarelo;
	}
	public int getNvlPreto() {
		return nvlPreto;
	}
	public void setNvlPreto(int nvlPreto) {
		this.nvlPreto = nvlPreto;
	}

	@Override
	public String toString() {
		String format = String.format(
				"Impressora "
				+ "\n\tid: %d"
				+ "\n\tnome: %s"
				+ "\n\tnvlCiano: %d"
				+ "\n\tnvlMagenta: %d"
				+ "\n\tnvlAmarelo: %d"
				+ "\n\tnvlPreto: %d"
				+ "\n\tfolhas: %d"
				, id,nome,nvlCiano,nvlMagenta,nvlAmarelo,nvlPreto,folhas);
		return format;
	}
	
	

}
