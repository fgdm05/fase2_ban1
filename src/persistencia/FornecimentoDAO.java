package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Fornecimento;

public class FornecimentoDAO {

	public FornecimentoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private int createId(Connection con) throws SQLException {
		PreparedStatement novoId;
			novoId = con.prepareStatement("SELECT NEXTVAL('idFcm')");
			ResultSet rs = novoId.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return -1;
	}
	
	public void create(Fornecimento f, Connection con) throws SQLException {
		f.setId(createId(con));
		PreparedStatement inserir;
			inserir = con.prepareStatement("INSERT INTO fornecimentos (idFcm, quantidade, dataHora, idForn, " +
										  "idMp) VALUES (?,?,?,?,?)");
			inserir.setInt(1, f.getId());
			inserir.setInt(2, f.getQuantidade());
			inserir.setDate(3, f.getDataHoraForn());
			inserir.setInt(4, f.getIdFornecedor());
			inserir.setInt(5, f.getIdMateriaPrima());
			inserir.execute();
			inserir.close();
		PreparedStatement aumentaQtd;
			aumentaQtd = con.prepareStatement("UPDATE materiasPrimas SET quantidade = quantidade + ? WHERE"
											+ " idMp = ?");
			aumentaQtd.setInt(1, f.getQuantidade());
			aumentaQtd.setInt(2, f.getIdMateriaPrima());
			aumentaQtd.executeUpdate();
	}
	
	public List<Fornecimento> selectAll(Connection con) throws SQLException {
		List<Fornecimento> fcms = new ArrayList<Fornecimento>();
		PreparedStatement st;
			st = con.prepareStatement("SELECT * FROM fornecimentos");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				int quantidade = rs.getInt(2);
				java.sql.Date data = rs.getDate(3);
				int idForn = rs.getInt(4);
				int idMp = rs.getInt(5);
				Fornecimento f = new Fornecimento(id, quantidade, data, idForn, idMp);
				fcms.add(f);
			}
		return fcms;
	}
	
	public void remove(Fornecimento f, Connection con ) throws SQLException {
		PreparedStatement st;
			st = con.prepareStatement("DELETE FROM fornecimentos WHERE idFcm = ?");
			st.setInt(1, f.getId());
			st.executeUpdate();
	}
}
