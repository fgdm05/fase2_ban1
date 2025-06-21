package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelos.Fornecedor;

public class FornecedorDAO {

	public FornecedorDAO() {
		
	}
	
	public int createId(Connection con) throws SQLException {
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

}
