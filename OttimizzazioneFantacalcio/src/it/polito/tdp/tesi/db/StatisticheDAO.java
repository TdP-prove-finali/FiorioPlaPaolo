package it.polito.tdp.tesi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.tesi.model.CalciatoreStatistiche;
import it.polito.tdp.tesi.model.Quotazione;

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
						rs.getString("Squadra"), rs.getFloat("PartiteGiocate"), rs.getFloat("MediaVoto"),rs.getFloat("MediaFanta"),
						rs.getFloat("GolFatti"), rs.getFloat("GolSubiti"), rs.getFloat("RigoriParati"), rs.getFloat("RigoriCalciati"), 
						rs.getFloat("RigoriSegnati"), rs.getFloat("RigoriSbagliati"), rs.getFloat("Assist"), 
						rs.getFloat("AssistFermo"), rs.getFloat("Ammonizioni"), rs.getFloat("Espulsioni"), rs.getFloat("Autogol")));
				
			
				
			}
			conn.close();
			
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
						rs.getString("Squadra"), rs.getFloat("PartiteGiocate"), rs.getFloat("MediaVoto"),rs.getFloat("MediaFanta"),
						rs.getFloat("GolFatti"), rs.getFloat("GolSubiti"), rs.getFloat("RigoriParati"), rs.getFloat("RigoriCalciati"), 
						rs.getFloat("RigoriSegnati"), rs.getFloat("RigoriSbagliati"), rs.getFloat("Assist"), 
						rs.getFloat("AssistFermo"), rs.getFloat("Ammonizioni"), rs.getFloat("Espulsioni"), rs.getFloat("Autogol")));
					
			
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore DB");
		}
		return calciatori;
	}
public List<CalciatoreStatistiche> getCalciatori20182019(){
	
	List<CalciatoreStatistiche> calciatori= new LinkedList<CalciatoreStatistiche>();
	
	final String sql = "SELECT * FROM  statistiche20182019 ";
	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
		
			calciatori.add(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
					rs.getString("Squadra"), rs.getFloat("PartiteGiocate"), rs.getFloat("MediaVoto"),rs.getFloat("MediaFanta"),
					rs.getFloat("GolFatti"), rs.getFloat("GolSubiti"), rs.getFloat("RigoriParati"), rs.getFloat("RigoriCalciati"), 
					rs.getFloat("RigoriSegnati"), rs.getFloat("RigoriSbagliati"), rs.getFloat("Assist"), 
					rs.getFloat("AssistFermo"), rs.getFloat("Ammonizioni"), rs.getFloat("Espulsioni"), rs.getFloat("Autogol")));
				
		
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore DB");
		}
		return calciatori;
	}
	

public List<Quotazione> getQuotazioni(){
	
	List<Quotazione> quotazioni= new LinkedList<Quotazione>();
	
	final String sql = "SELECT * FROM  quotazioni ";
	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
		
			quotazioni.add(new Quotazione(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
					rs.getString("Squadra"), rs.getInt("Quotazione")));
				
		
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore DB");
		}
		return quotazioni;
	}
	
	
}
