package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONObject;

public class ConnectionFactory {
	public Connection createConnection() throws SQLException {
		String server = "";
		String database = "";
		String login = "";
		String senha = "";
		
		try {
			JSONObject jobject = readDatabaseConfiguration();
			server = jobject.getString("server");
			database = jobject.getString("database");
			login = jobject.getString("login");
			senha = jobject.getString("senha");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(String.format("jdbc:postgresql://%s:5432/%s", server, database), login, senha);
	}
	
	private JSONObject readDatabaseConfiguration() throws FileNotFoundException, IOException {
		var file = new File("database-config.json");
		try (var fr = new FileReader(file);
		var br = new BufferedReader(fr)) {
			System.out.println("INICIANDO LEITURA database-config.json");
			
			Stream<String> lines = br.lines();
			List<String> collect = lines.collect(Collectors.toList());
			StringBuilder builder = new StringBuilder();
			for(int i = 0; collect.size() > i; i++) {
				builder.append(collect.get(i));
			}
			String linhas = builder.toString();
			System.out.println("TERMINANDO LEITURA database-config.json");
			return new JSONObject(linhas);
		}
	}
	
	
	
}