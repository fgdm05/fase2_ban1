package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Fornecedor;

public class FornecedorDAO {

	public FornecedorDAO() {
		
	}
	
	private int createId(Connection con) throws SQLException {
		PreparedStatement novoId;
			novoId = con.prepareStatement("SELECT NEXTVAL('idForn')");
			ResultSet rs = novoId.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return -1;
	}
	
	public void create(Fornecedor f, Connection con) throws SQLException {
		f.setId(createId(con));
		PreparedStatement st;
			st = con.prepareStatement("INSERT INTO fornecedores (idForn, nome, cnpj, razaoSocial)" +
									 "VALUES (?,?,?,?)");
			st.setInt(1, f.getId());
			st.setString(2, f.getNome());
			st.setString(3, f.getCnpj());
			st.setString(4, f.getRazaoSocial());
			st.execute();
			st.close();
	}
	
	public List<Fornecedor> selectAll (Connection con) throws SQLException {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		PreparedStatement st;
			st = con.prepareStatement("SELECT * FROM fornecedores");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String cnpj = rs.getString(3);
				String razaoSocial = rs.getString(4);
				Fornecedor f = new Fornecedor(id, nome, cnpj, razaoSocial);
				fornecedores.add(f);
			}
			return fornecedores;
	}
	
	public void remove(Fornecedor f, Connection con) throws SQLException {
		PreparedStatement st;
			st = con.prepareStatement("DELETE FROM fornecedores WHERE idForn = ?");
			// TODO: exclusão em fornecimentos tb
			st.setInt(1, f.getId());
			st.executeUpdate();
	}

}
