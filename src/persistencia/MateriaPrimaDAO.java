package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.MateriaPrima;

public class MateriaPrimaDAO {

	private static Connection con = null;
	
	public MateriaPrimaDAO(Connection con) {
		this.con = con;
	}
	
	private int createId() throws SQLException {
		PreparedStatement novoId;
			novoId = con.prepareStatement("SELECT NEXTVAL('idMp')");
			ResultSet rs = novoId.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return -1;
	}
	
	public void create(MateriaPrima mp) throws SQLException {
		mp.setId(createId());
		PreparedStatement st;
			st = con.prepareStatement("INSERT INTO materiasPrimas (idMp, nome, quantidade, volume, vol)" +
									 "VALUES (?,?,?,?,?)");
			st.setInt(1, mp.getId());
			st.setString(2, mp.getNome());
			st.setInt(3, mp.getQuantidade());
			st.setInt(4, mp.getVolume());
			st.setBoolean(5, mp.isVol());
			st.execute();
			st.close();
	}
	
	public List<MateriaPrima> selectAll() throws SQLException {
		List<MateriaPrima> mps = new ArrayList<MateriaPrima>();
		PreparedStatement st;
			st = con.prepareStatement("SELECT * FROM materiasPrimas");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				int quantidade = rs.getInt(3);
				int volume = rs.getInt(4);
				boolean vol = rs.getBoolean(5);
				MateriaPrima mp = new MateriaPrima(id, nome, quantidade, volume, vol);
				mps.add(mp);
			}
			return mps;
	}
	
	public void remove( MateriaPrima mp) throws SQLException {
		PreparedStatement st;
			st = con.prepareStatement("DELETE FROM materiasPrimas WHERE idMp = ?");
			// TODO: exclusão em fornecimentos tb
			st.setInt(1, mp.getId());
			st.executeUpdate();
	}

}
