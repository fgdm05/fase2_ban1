package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Fornecedor;
import modelos.Fornecimento;
import modelos.MateriaPrima;

public class FornecimentoDAO {

	private Connection con;

	public FornecimentoDAO(Connection con) {
		this.con = con;
	}
	
	private int createId() throws SQLException {
		PreparedStatement novoId;
			novoId = con.prepareStatement("SELECT NEXTVAL('idFcm')");
			ResultSet rs = novoId.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return -1;
	}
	
	public void create(Fornecimento f) throws SQLException {
		f.setId(createId());
		PreparedStatement inserir;
			inserir = con.prepareStatement("INSERT INTO fornecimentos (idFcm, quantidade, data, idForn, " +
										  "idMp, hora) VALUES (?,?,?,?,?,?)");
			inserir.setInt(1, f.getId());
			inserir.setInt(2, f.getQuantidade());
			inserir.setDate(3, f.getData());
			inserir.setInt(4, f.getIdFornecedor());
			inserir.setInt(5, f.getIdMateriaPrima());
			inserir.setTime(6, f.getTime());
			inserir.execute();
			inserir.close();
		PreparedStatement aumentaQtd;
			aumentaQtd = con.prepareStatement("UPDATE materiasPrimas SET quantidade = quantidade + ? WHERE"
											+ " idMp = ?");
			aumentaQtd.setInt(1, f.getQuantidade());
			aumentaQtd.setInt(2, f.getIdMateriaPrima());
			aumentaQtd.executeUpdate();
	}
	
	public List<Fornecimento> selectAll() throws SQLException {
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
				java.sql.Time time = rs.getTime(6);
				Fornecimento f = new Fornecimento(id, quantidade, data, idForn, idMp, time);
				fcms.add(f);
			}
		return fcms;
	}
	
	public List<Fornecimento> selectAllWithMpForn() throws SQLException {
		List<Fornecimento> fcms = new ArrayList<Fornecimento>();
		PreparedStatement st;
			st = con.prepareStatement("SELECT idFcm, fcm.quantidade, data, hora, f.*, mp.* FROM fornecimentos fcm "
					+ "JOIN fornecedores f ON fcm.idForn = f.idForn JOIN materiasPrimas mp ON fcm.idMp = mp.idMp");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Fornecimento fcm = new Fornecimento(rs.getInt("idFcm"), rs.getInt(2), rs.getDate(3), rs.getInt(5), 
						rs.getInt(9), rs.getTime("hora"));
				Fornecedor f = new Fornecedor(rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8));
				MateriaPrima mp = new MateriaPrima(rs.getInt(9), rs.getString(10), rs.getInt(11), rs.getString(12));
				fcm.setFornecedor(f);
				fcm.setMateriaPrima(mp);
				fcms.add(fcm);
			}
			return fcms;
	}
	
	public void remove(Fornecimento f) throws SQLException {
		PreparedStatement st;
			st = con.prepareStatement("DELETE FROM fornecimentos WHERE idFcm = ?");
			st.setInt(1, f.getId());
			st.executeUpdate();
	}
}
