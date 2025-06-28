package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.AbastecimentoException;
import exceptions.TipoAbastecimentoException;
import modelos.Abastecimento;
import modelos.Impressora;
import modelos.MateriaPrima;

public class AbastecimentoDAO {
	private Connection connection = null;
	public AbastecimentoDAO(Connection connection) {
		this.connection = connection;
	}
	private int createId() throws SQLException {
		try(var novoId = connection.prepareStatement("SELECT NEXTVAL('idAbastecimento')");
			var rs = novoId.executeQuery()) {
			if(rs.next()) {
				return rs.getInt(1);
			}
		}
		return -1;
	}
	private String checkAbastecimento(Abastecimento abs) throws SQLException, AbastecimentoException {
		String checkQuantidade = 
				"SELECT quantidade, tipoAbs, nome "
				+ "FROM materiasprimas "
				+ "WHERE idMp = ?";
		try (var check = connection.prepareStatement(checkQuantidade);){
			check.setInt(1, abs.getIdMateriaPrima());
			ResultSet rs = check.executeQuery();
			
			if(rs.next()) {
				int disponivel = rs.getInt(1);
				String tipoAbs = rs.getString(2);
				String nome = rs.getString(3);
				if(disponivel < abs.getQuantidade()) {
					
					String msg = String.format(
					"Quantidade %d indisponível de matéria prima %s "
					+ "que contém apenas %d, abortando operação!", abs.getQuantidade(), nome, disponivel);
					throw new AbastecimentoException(msg);
				}
				return tipoAbs;
			}
		}
		return null;
	}
	
	public void create(Abastecimento abs) throws Exception {
		String tipoAbs;
		try {
		tipoAbs = checkAbastecimento(abs);
		abs.setIdAbastecimento(createId());
		} catch(NullPointerException e) {
			throw new Exception("Id de materia prima inexistente!", e);
		}
		
		String query = 
			"INSERT INTO abastecimento "
			+ "(idAbastecimento, idMateriaPrima, idImpressora, data, quantidade, hora) VALUES "
			+ "(?, ?, ?, ?, ?, ?)";
		
		String queryUpdate = 
			"UPDATE materiasprimas "
			+ "SET quantidade = quantidade - ? "
			+ "WHERE idMp = ?";
		
		String campo = getCampo(tipoAbs);
		
		
		String qUpdateImp = 
			"UPDATE impressoras " + 
			"SET " + campo + " = " + campo + " + ? "
			+ "WHERE idImp = ?";
		
		connection.setAutoCommit(false);
		try (
			var insert = connection.prepareStatement(query);
			var update = connection.prepareStatement(queryUpdate);
			var updateImp = connection.prepareStatement(qUpdateImp);
		){
			
			insert.setInt(1, abs.getIdAbastecimento());
			insert.setInt(2, abs.getIdMateriaPrima());
			insert.setInt(3, abs.getIdImpressora());
			insert.setDate(4, abs.getData());
			insert.setInt(5, abs.getQuantidade());
			insert.setTime(6, abs.getTime());
			
			update.setInt(1, abs.getQuantidade());
			update.setInt(2, abs.getIdMateriaPrima());
			
			updateImp.setInt(1, abs.getQuantidade());
			updateImp.setInt(2, abs.getIdImpressora());
			
			
			insert.execute();
			update.execute();
			updateImp.execute();
			connection.commit();
		} finally {
			connection.setAutoCommit(true);
		}
	}

	private String getCampo(String tipoAbs) throws TipoAbastecimentoException {
		switch(tipoAbs) {
			case "c":
				return "nvlciano";
			case "a":
				return "nvlamarelo";
			case "m":
				return "nvlmagenta";
			case "p":
				return "nvlpreto";
			case "f":
				return "folhas";
			default:
				throw new TipoAbastecimentoException("Tipo inexistente!");
		}
	}
	public List<Abastecimento> select() throws SQLException {
		String query = "SELECT * FROM abastecimento";
		try (var select = connection.prepareStatement(query)){
			ResultSet rs = select.executeQuery();
			List<Abastecimento> l_abs = new ArrayList<>();
			while(rs.next()) {
				l_abs.add(new Abastecimento(
						rs.getInt("idAbastecimento"), 
						rs.getInt("idImpressora"), 
						rs.getInt("idMateriaPrima"), 
						rs.getDate("data"), 
						rs.getInt("quantidade"),
						rs.getTime("hora")));
			}
			return l_abs;
		}
	}
	
	public boolean delete(Abastecimento abs) throws SQLException {
		String query = "DELETE FROM abastecimento WHERE idAbastecimento = ?";
		try(var ps = connection.prepareStatement(query)) {
			ps.setInt(1, abs.getIdAbastecimento());
			return ps.execute();
		}
	}
	
	
	
	public List<Abastecimento> selectAll() throws SQLException {
		List<Abastecimento> list = new ArrayList<>();
		
		String query = "SELECT "
				+ "abs.idAbastecimento, "
				+ "abs.quantidade, "
				+ "abs.data, "
				+ "hora, "
				+ "imp.*, "
				+ "mp.* "
				+ "FROM abastecimento abs "
				+ "JOIN impressoras imp ON imp.idimp = abs.idImpressora "
				+ "JOIN materiasprimas mp ON mp.idmp = abs.idMateriaPrima";
		
		try (var st = connection.prepareStatement(query)){
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				var abs = new Abastecimento(rs.getInt(1), rs.getInt("idImp"), rs.getInt("idMp"), rs.getDate(3), rs.getInt(2), rs.getTime("hora"));
				var impr = new Impressora(
						rs.getInt("idimp"), 
						rs.getString("nome"), 
						rs.getInt("nvlciano"), 
						rs.getInt("nvlmagenta"), 
						rs.getInt("nvlamarelo"), 
						rs.getInt("nvlpreto"), 
						rs.getInt("folhas"));
				abs.setImpressora(impr);
				var mp = new MateriaPrima(rs.getInt("idmp"), rs.getString("nome"), rs.getInt("quantidade"), rs.getString("tipoAbs"));
				abs.setMateriaPrima(mp);
				list.add(abs);
			}
			return list;
		}
	}
	
	public List<Abastecimento> selectAgregacao() throws SQLException {
		String query = "SELECT * FROM abastecimento "
				+ "WHERE data >= ALL(SELECT data FROM abastecimento)"
				+ "ORDER BY hora DESC";
		
		try (var ps = connection.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			List<Abastecimento> labs = new ArrayList<>();
			while(rs.next()) {
				labs.add(new Abastecimento(
						rs.getInt("idAbastecimento"), 
						rs.getInt("idImpressora"), 
						rs.getInt("idMateriaPrima"), 
						rs.getDate("data"), 
						rs.getInt("quantidade"), 
						rs.getTime("hora")));
			}
			return labs;
		}
	}
}