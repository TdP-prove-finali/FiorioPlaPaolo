package it.polito.tdp.tesi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.tesi.model.CalciatoreStatistiche;

public class StatisticheDAO {

	
	public List<CalciatoreStatistiche> getCalciatori20162017(){
		
		List<CalciatoreStatistiche> calciatori= new LinkedList<CalciatoreStatistiche>();
		
		final String sql = "SELECT * FROM  statistiche20162017 ";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
			
				calciatori.add(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
						rs.getString("Squadra"), rs.getInt("PartiteGiocate"), rs.getFloat("MediaVoto"),rs.getFloat("MediaFanta"),
						rs.getInt("GolFatti"), rs.getInt("GolSubiti"), rs.getInt("RigoriParati"), rs.getInt("RigoriCalciati"), 
						rs.getInt("RigoriSegnati"), rs.getInt("RigoriSbagliati"), rs.getInt("Assist"), 
						rs.getInt("AssistFermo"), rs.getInt("Ammonizioni"), rs.getInt("Espulsioni"), rs.getInt("Autogol")));
				
			
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore DB");
		}
		return calciatori;
	}
	
public List<CalciatoreStatistiche> getCalciatori20172018(){
		
		List<CalciatoreStatistiche> calciatori= new LinkedList<CalciatoreStatistiche>();
		
		final String sql = "SELECT * FROM  statistiche20172018 ";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
			
				calciatori.add(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
						rs.getString("Squadra"), rs.getInt("PartiteGiocate"), rs.getFloat("MediaVoto"),rs.getFloat("MediaFanta"),
						rs.getInt("GolFatti"), rs.getInt("GolSubiti"), rs.getInt("RigoriParati"), rs.getInt("RigoriCalciati"), 
						rs.getInt("RigoriSegnati"), rs.getInt("RigoriSbagliati"), rs.getInt("Assist"), 
						rs.getInt("AssistFermo"), rs.getInt("Ammonizioni"), rs.getInt("Espulsioni"), rs.getInt("Autogol")));
				
			
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore DB");
		}
		return calciatori;
	}
	
	
	
	
}
