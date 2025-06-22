package modelos;

public class MateriaPrima {
	private int id, quantidade, volume;
	private String nome;
	private boolean vol;
	public MateriaPrima() {
		// TODO Auto-generated constructor stub
	}
	public MateriaPrima(int id, String nome, int quantidade, int volume, boolean vol) {
		this.id = id;
		this.quantidade = quantidade;
		this.nome = nome;
		this.volume = volume;
		this.vol = vol;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public boolean isVol() {
		return vol;
	}
	public void setVol(boolean vol) {
		this.vol = vol;
	}
	@Override
	public String toString() {
		if(vol == false) {
			return "MateriaPrima [id=" + id + ", quantidade=" + quantidade + ", nome=" + nome + "]";
		} else {
			return "MateriaPrima [id=" + id + ", quantidade=" + quantidade + ", nome=" + nome + ", volume=" +
					volume + "]";
		}
	}
	
	

}
