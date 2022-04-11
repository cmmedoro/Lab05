package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AnagrammaDAO {
	
	public boolean isCorrect(String anagramma) {
		
		String sql = "SELECT nome "
				+ "FROM parola "
				+ "WHERE nome=?;";
		String name = "";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				name = rs.getString("nome");
			}
			conn.close();
			if(name.equals("")) {
				return false; //vuol dire che non ho trovato la parola nel dizionario
			}
			else 
				return true; //la parola è presente nel dizionario
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

}
