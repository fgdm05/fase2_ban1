package modelos;

public class Impressora {
	private int id, nvlCiano, nvlMagenta, nvlAmarelo, nvlPreto;
	public Impressora() {
	}
	
	public Impressora(int id, int nvlCiano, int nvlMagenta, int nvlAmarelo, int nvlPreto) {
		this.id = id;
		this.nvlCiano = nvlCiano;
		this.nvlMagenta = nvlMagenta;
		this.nvlAmarelo = nvlAmarelo;
		this.nvlPreto = nvlPreto;
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
	
	

}
