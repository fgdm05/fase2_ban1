package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Impressora;

public class ImpressoraDAO {

	public ImpressoraDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private int createId(Connection con) throws SQLException {
		PreparedStatement novoId;
			novoId = con.prepareStatement("SELECT NEXTVAL('idImp')");
			ResultSet rs = novoId.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return -1;
	}
	
	public void create(Impressora i, Connection con) throws SQLException {
		i.setId(createId(con));
		PreparedStatement st;
			st = con.prepareStatement("INSERT INTO impressoras (idImp, nome, nvlCiano, nvlMagenta, " +
									 "nvlAmarelo, nvlPreto) VALUES (?,?,?,?,?,?)");
			st.setInt(1, i.getId());
			st.setString(2, i.getNome());
			st.setInt(3, i.getNvlCiano());
			st.setInt(4, i.getNvlMagenta());
			st.setInt(5, i.getNvlAmarelo());
			st.setInt(6, i.getNvlPreto());
			st.execute();
			st.close();
	}
	
	public List<Impressora> selectAll(Connection con) throws SQLException {
		List<Impressora> imps = new ArrayList<Impressora>();
		PreparedStatement st;
			st = con.prepareStatement("SELECT * FROM impressoras");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				int nvlCiano = rs.getInt(3);
				int nvlMagenta = rs.getInt(4);
				int nvlAmarelo = rs.getInt(5);
				int nvlPreto = rs.getInt(6);
				Impressora imp = new Impressora(id, nome, nvlCiano, nvlMagenta, nvlAmarelo, nvlPreto);
				imps.add(imp);
			}
			return imps;
	}
	
	public void remove(Impressora i, Connection con) throws SQLException {
		PreparedStatement st;
			st = con.prepareStatement("DELETE FROM impressoras WHERE idImp = ?");
			st.setInt(1, i.getId());
			st.executeUpdate();
	}

}
