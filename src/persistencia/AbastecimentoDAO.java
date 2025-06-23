package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.AbastecimentoException;
import modelos.Abastecimento;

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
				"SELECT quantidade, nome "
				+ "FROM materiasprimas "
				+ "WHERE idMp = ?";
		try (var check = connection.prepareStatement(checkQuantidade);){
			check.setInt(1, abs.getIdMateriaPrima());
			ResultSet rs = check.executeQuery();
			
			if(rs.next()) {
				int disponivel = rs.getInt(1);
				String nome = rs.getString(2);
				if(disponivel < abs.getQuantidade()) {
					
					String msg = String.format(
					"Quantidade %d indisponível de matéria prima %s "
					+ "que contém apenas %d, abortando operação!", abs.getQuantidade(), nome, disponivel);
					throw new AbastecimentoException(msg);
				}
				return nome;
			}
		}
		return null;
	}
	
	public void create(Abastecimento abs) throws SQLException, AbastecimentoException {
		
		String campo = checkAbastecimento(abs);
		abs.setIdAbastecimento(createId());
		String query = 
			"INSERT INTO abastecimento "
			+ "(idAbastecimento, idMateriaPrima, idImpressora, dataHora, quantidade) VALUES "
			+ "(?, ?, ?, ?, ?)";
		
		String queryUpdate = 
			"UPDATE materiasprimas "
			+ "SET quantidade = quantidade - ? "
			+ "WHERE idMp = ?";
		
		String qUpdateImp = 
			"UPDATE impressoras " + String.format(
			"SET %s = %s + ?", campo, campo) 
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
						rs.getDate("dataHora"), 
						rs.getInt("quantidade")));
			}
			return l_abs;
		}
	}
}