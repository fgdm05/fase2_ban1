package modelos;

public class MateriaPrima {
	private int id, quantidade;
	private String nome;
	private String tipoMateriaPrima;
	public MateriaPrima() {
		// TODO Auto-generated constructor stub
	}
	public MateriaPrima(int id, String nome, int quantidade, String tipoMp) {
		this.id = id;
		this.quantidade = quantidade;
		this.nome = nome;
		tipoMateriaPrima = tipoMp;
	}
	
	public String getTipoMateriaPrima() {
		return tipoMateriaPrima;
	}
	public void setTipoMateriaPrima(String tipoMateriaPrima) {
		this.tipoMateriaPrima = tipoMateriaPrima;
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
	@Override
	public String toString() {	
			return "MateriaPrima [id=" + id + ", quantidade=" + quantidade + ", nome=" + nome + "]";
	}
}