package it.polito.tdp.tesi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.tesi.model.CalciatoreStatistiche;
import it.polito.tdp.tesi.model.Quotazione;

public class StatisticheDAO {
	
/*
 * Ritorna la media dei giocatori presenti nelle tre tabelle
 * che hanno giocato in tutte e tre le stagioni
 */
	public Map<Integer, CalciatoreStatistiche> getMediaTreAnni(){
		
		Map<Integer, CalciatoreStatistiche> calciatori= new HashMap<Integer, CalciatoreStatistiche>();

		String sql= "SELECT q.Id, q.Ruolo , q.Nome, q.Squadra, q.Quotazione , ((s1.PartiteGiocate+ s2.PartiteGiocate + s3.PartiteGiocate) /3) AS PartiteGiocate, " + 
			"((s1.MediaVoto+ s2.MediaVoto + s3.MediaVoto) /3) AS MediaVoto , ((s1.MediaFanta+ s2.MediaFanta + s3.MediaFanta) /3) AS MediaFanta , " + 
			"((s1.GolFatti+ s2.GolFatti + s3.GolFatti) /3) AS GolFatti , ((s1.GolSubiti+ s2.GolSubiti + s3.GolSubiti) /3) AS GolSubiti, " + 
			"((s1.RigoriParati+ s2.RigoriParati + s3.RigoriParati) /3) AS RigoriParati , ((s1.RigoriCalciati+ s2.RigoriCalciati + s3.RigoriCalciati) /3) AS RigoriCalciati , " + 
			"((s1.RigoriSegnati+ s2.RigoriSegnati + s3.RigoriSegnati) /3) AS RigoriSegnati , ((s1.RigoriSbagliati+ s2.RigoriSbagliati + s3.RigoriSbagliati) /3) AS RigoriSbagliati , " + 
			"((s1.Assist+ s2.Assist + s3.Assist) /3) AS Assist , ((s1.AssistFermo+ s2.AssistFermo + s3.AssistFermo) /3) AS AssistFermo, " + 
			"((s1.Ammonizioni+ s2.Ammonizioni + s3.Ammonizioni) /3) AS Ammonizioni , ((s1.Espulsioni+ s2.Espulsioni + s3.Espulsioni) /3) AS Espulsioni , " + 
			"((s1.Autogol+ s2.Autogol + s3.Autogol) /3) AS Autogol " + 
			"FROM quotazioni q, statistiche20162017 s1, statistiche20172018 s2, statistiche20182019 s3 " + 
			"WHERE q.id = s1.Id AND  q.Id = s2.Id AND  q.Id= s3.Id " + 
			"AND s1.PartiteGiocate>0 and s2.PartiteGiocate>0 and s3.PartiteGiocate >0 " ;

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
			
				calciatori.put(rs.getInt("Id"),(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
						rs.getString("Squadra"),rs.getInt("Quotazione"), rs.getDouble("PartiteGiocate"), rs.getDouble("MediaVoto"),rs.getDouble("MediaFanta"),
						rs.getDouble("GolFatti"), rs.getDouble("GolSubiti"), rs.getDouble("RigoriParati"), rs.getDouble("RigoriCalciati"), 
						rs.getDouble("RigoriSegnati"), rs.getDouble("RigoriSbagliati"), rs.getDouble("Assist"), 
						rs.getDouble("AssistFermo"), rs.getDouble("Ammonizioni"), rs.getDouble("Espulsioni"), rs.getDouble("Autogol"))));
				
			
				
			}
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore DB");
		}
			return calciatori;
	}
/*
 * Ritorna le medie dei calciatori sempre presenti nelle tre tabelle 
 * che hanno giocato solo nella stagione 2018-2019
 */
	public Map<Integer, CalciatoreStatistiche> getCalciatori20182019(){
		
		Map<Integer, CalciatoreStatistiche> calciatori= new HashMap<Integer, CalciatoreStatistiche>();
		
		final String sql = "SELECT q.Id, q.Ruolo, q.Nome, q.Squadra,q.Quotazione, s3.PartiteGiocate,s3.MediaVoto,s3.MediaFanta,s3.GolFatti,s3.GolSubiti , " + 
				"				s3.RigoriParati,s3.RigoriCalciati,s3.RigoriSegnati, s3.RigoriSbagliati, s3.Assist, s3.AssistFermo, s3.Ammonizioni, s3.Espulsioni, s3.Autogol " + 
				"FROM quotazioni q, statistiche20162017 s1, statistiche20172018 s2, statistiche20182019 s3 " + 
				"WHERE q.id = s1.Id AND  q.Id = s2.Id AND  q.Id= s3.Id " + 
				"AND s1.PartiteGiocate=0 and s2.PartiteGiocate=0 and s3.PartiteGiocate>0 ";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
			
				calciatori.put(rs.getInt("Id"),(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
						rs.getString("Squadra"),rs.getInt("Quotazione"), rs.getDouble("PartiteGiocate"), rs.getDouble("MediaVoto"),rs.getDouble("MediaFanta"),
						rs.getDouble("GolFatti"), rs.getDouble("GolSubiti"), rs.getDouble("RigoriParati"), rs.getDouble("RigoriCalciati"), 
						rs.getDouble("RigoriSegnati"), rs.getDouble("RigoriSbagliati"), rs.getDouble("Assist"), 
						rs.getDouble("AssistFermo"), rs.getDouble("Ammonizioni"), rs.getDouble("Espulsioni"), rs.getDouble("Autogol"))));
				
			
				
			}
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore DB");
		}
		return calciatori;
	}

/*
* Ritorna le medie dei calciatori sempre presenti nelle tre tabelle 
* che hanno giocato solo nella stagione 2017-2018
*/
public Map<Integer, CalciatoreStatistiche> getCalciatori20172018(){
		
		Map<Integer, CalciatoreStatistiche> calciatori= new HashMap<Integer, CalciatoreStatistiche>();
		
		final String sql = "SELECT q.Id, q.Ruolo, q.Nome, q.Squadra,q.Quotazione, s2.PartiteGiocate,s2.MediaVoto,s2.MediaFanta,s2.GolFatti,s2.GolSubiti , " + 
				"s2.RigoriParati,s2.RigoriCalciati,s2.RigoriSegnati, s2.RigoriSbagliati, s2.Assist, s2.AssistFermo, s2.Ammonizioni, s2.Espulsioni, s2.Autogol " + 
				"FROM quotazioni q, statistiche20162017 s1, statistiche20172018 s2, statistiche20182019 s3 " + 
				"WHERE q.id = s1.Id AND  q.Id = s2.Id AND  q.Id= s3.Id " + 
				"AND s1.PartiteGiocate=0 and s2.PartiteGiocate>0 and s3.PartiteGiocate =0 ";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
			
				calciatori.put(rs.getInt("Id"),(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
						rs.getString("Squadra"),rs.getInt("Quotazione"), rs.getDouble("PartiteGiocate"), rs.getDouble("MediaVoto"),rs.getDouble("MediaFanta"),
						rs.getDouble("GolFatti"), rs.getDouble("GolSubiti"), rs.getDouble("RigoriParati"), rs.getDouble("RigoriCalciati"), 
						rs.getDouble("RigoriSegnati"), rs.getDouble("RigoriSbagliati"), rs.getDouble("Assist"), 
						rs.getDouble("AssistFermo"), rs.getDouble("Ammonizioni"), rs.getDouble("Espulsioni"), rs.getDouble("Autogol"))));
				
			
				
			}
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore DB");
		}
		return calciatori;
	}

/*
 * Ritorna le medie dei calciatori sempre presenti nelle tre tabelle 
 * che hanno giocato solo nella stagione 2016-2017
 */
public Map<Integer, CalciatoreStatistiche> getCalciatori20162017(){
	
	Map<Integer, CalciatoreStatistiche> calciatori= new HashMap<Integer, CalciatoreStatistiche>();
	
	final String sql = "SELECT q.Id, q.Ruolo, q.Nome, q.Squadra,q.Quotazione, s1.PartiteGiocate,s1.MediaVoto,s1.MediaFanta,s1.GolFatti,s1.GolSubiti , " + 
			"s1.RigoriParati,s1.RigoriCalciati,s1.RigoriSegnati, s1.RigoriSbagliati, s1.Assist, s1.AssistFermo, s1.Ammonizioni, s1.Espulsioni, s1.Autogol " + 
			"FROM quotazioni q, statistiche20162017 s1, statistiche20172018 s2, statistiche20182019 s3 "+ 
			"WHERE q.id = s1.Id AND  q.Id = s2.Id AND  q.Id= s3.Id  " +
			"AND s1.PartiteGiocate>0 and s2.PartiteGiocate=0 and s3.PartiteGiocate =0 ";
	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
		
			calciatori.put(rs.getInt("Id"),(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
					rs.getString("Squadra"),rs.getInt("Quotazione"), rs.getDouble("PartiteGiocate"), rs.getDouble("MediaVoto"),rs.getDouble("MediaFanta"),
					rs.getDouble("GolFatti"), rs.getDouble("GolSubiti"), rs.getDouble("RigoriParati"), rs.getDouble("RigoriCalciati"), 
					rs.getDouble("RigoriSegnati"), rs.getDouble("RigoriSbagliati"), rs.getDouble("Assist"), 
					rs.getDouble("AssistFermo"), rs.getDouble("Ammonizioni"), rs.getDouble("Espulsioni"), rs.getDouble("Autogol"))));
			
		
			
		}
		conn.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Errore DB");
	}
	return calciatori;
}
/*
 * Ritorna le medie dei calciatori sempre presenti nelle tre tabelle 
 * che hanno giocato solo nelle stagioni 2016-2017 e 2017-2018
 */
public Map<Integer, CalciatoreStatistiche> getMedia2016_2017_2018(){
	
	Map<Integer, CalciatoreStatistiche> calciatori= new HashMap<Integer, CalciatoreStatistiche>();

	String sql= "SELECT q.Id, q.Ruolo , q.Nome, q.Squadra, q.Quotazione , ((s1.PartiteGiocate+ s2.PartiteGiocate) /2) AS PartiteGiocate,  " + 
			"((s1.MediaVoto+ s2.MediaVoto) /2) AS MediaVoto , ((s1.MediaFanta+ s2.MediaFanta) /2) AS MediaFanta , " + 
			"((s1.GolFatti+ s2.GolFatti) /2) AS GolFatti , ((s1.GolSubiti+ s2.GolSubiti)/2) AS GolSubiti, " + 
			"((s1.RigoriParati+ s2.RigoriParati) /2) AS RigoriParati , ((s1.RigoriCalciati+ s2.RigoriCalciati) /2) AS RigoriCalciati , " + 
			"((s1.RigoriSegnati+ s2.RigoriSegnati) /2) AS RigoriSegnati , ((s1.RigoriSbagliati+ s2.RigoriSbagliati) /2) AS RigoriSbagliati ,  " + 
			"((s1.Assist+ s2.Assist) /2) AS Assist , ((s1.AssistFermo+ s2.AssistFermo) /2) AS AssistFermo, " + 
			"((s1.Ammonizioni+ s2.Ammonizioni) /2) AS Ammonizioni , ((s1.Espulsioni+ s2.Espulsioni) /2) AS Espulsioni , " + 
			"((s1.Autogol+ s2.Autogol) /2) AS Autogol " + 
			"FROM quotazioni q, statistiche20162017 s1, statistiche20172018 s2, statistiche20182019 s3 " + 
			"WHERE q.id = s1.Id AND  q.Id = s2.Id AND  q.Id= s3.Id " + 
			"AND s1.PartiteGiocate>0 and s2.PartiteGiocate>0 and s3.PartiteGiocate =0 " ;

	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
		
			calciatori.put(rs.getInt("Id"),(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
					rs.getString("Squadra"),rs.getInt("Quotazione"), rs.getDouble("PartiteGiocate"), rs.getDouble("MediaVoto"),rs.getDouble("MediaFanta"),
					rs.getDouble("GolFatti"), rs.getDouble("GolSubiti"), rs.getDouble("RigoriParati"), rs.getDouble("RigoriCalciati"), 
					rs.getDouble("RigoriSegnati"), rs.getDouble("RigoriSbagliati"), rs.getDouble("Assist"), 
					rs.getDouble("AssistFermo"), rs.getDouble("Ammonizioni"), rs.getDouble("Espulsioni"), rs.getDouble("Autogol"))));
			
		
			
		}
		conn.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Errore DB");
	}
		return calciatori;
}

/*
 * Ritorna le medie dei calciatori sempre presenti nelle tre tabelle 
 * che hanno giocato solo nelle stagioni 2016-2017 e 2018-2019
 */
public Map<Integer, CalciatoreStatistiche> getMedia2016_2018_2019(){
	
	Map<Integer, CalciatoreStatistiche> calciatori= new HashMap<Integer, CalciatoreStatistiche>();

	String sql= "SELECT q.Id, q.Ruolo , q.Nome, q.Squadra, q.Quotazione , ((s1.PartiteGiocate+ s3.PartiteGiocate) /2) AS PartiteGiocate, " + 
			"((s1.MediaVoto+ s3.MediaVoto) /2) AS MediaVoto , ((s1.MediaFanta+ s3.MediaFanta) /2) AS MediaFanta , " + 
			"((s1.GolFatti+ s3.GolFatti) /2) AS GolFatti , ((s1.GolSubiti+ s3.GolSubiti)/2) AS GolSubiti, " + 
			"((s1.RigoriParati+ s3.RigoriParati) /2) AS RigoriParati , ((s1.RigoriCalciati+ s3.RigoriCalciati) /2) AS RigoriCalciati , " + 
			"((s1.RigoriSegnati+ s3.RigoriSegnati) /2) AS RigoriSegnati , ((s1.RigoriSbagliati+ s3.RigoriSbagliati) /2) AS RigoriSbagliati , " + 
			"((s1.Assist+ s3.Assist) /2) AS Assist , ((s1.AssistFermo+ s3.AssistFermo) /2) AS AssistFermo, " + 
			"((s1.Ammonizioni+ s3.Ammonizioni) /2) AS Ammonizioni , ((s1.Espulsioni+ s3.Espulsioni) /2) AS Espulsioni , " + 
			"((s1.Autogol+ s3.Autogol) /2) AS Autogol " + 
			"FROM quotazioni q, statistiche20162017 s1, statistiche20172018 s2, statistiche20182019 s3  " + 
			"WHERE q.id = s1.Id AND  q.Id = s2.Id AND  q.Id= s3.Id  " + 
			"AND s1.PartiteGiocate>0 and s2.PartiteGiocate=0 and s3.PartiteGiocate >0 " ;

	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
		
			calciatori.put(rs.getInt("Id"),(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
					rs.getString("Squadra"),rs.getInt("Quotazione"), rs.getDouble("PartiteGiocate"), rs.getDouble("MediaVoto"),rs.getDouble("MediaFanta"),
					rs.getDouble("GolFatti"), rs.getDouble("GolSubiti"), rs.getDouble("RigoriParati"), rs.getDouble("RigoriCalciati"), 
					rs.getDouble("RigoriSegnati"), rs.getDouble("RigoriSbagliati"), rs.getDouble("Assist"), 
					rs.getDouble("AssistFermo"), rs.getDouble("Ammonizioni"), rs.getDouble("Espulsioni"), rs.getDouble("Autogol"))));
			
		
			
		}
		conn.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Errore DB");
	}
		return calciatori;
}
/*
 * Ritorna le medie dei calciatori sempre presenti nelle tre tabelle 
 * che hanno giocato solo nelle stagioni 2017-2018 e 2018-2019
 */
public Map<Integer, CalciatoreStatistiche> getMedia2017_2018_2019(){
	
	Map<Integer, CalciatoreStatistiche> calciatori= new HashMap<Integer, CalciatoreStatistiche>();

	String sql= "SELECT q.Id, q.Ruolo , q.Nome, q.Squadra, q.Quotazione , ((s2.PartiteGiocate+ s3.PartiteGiocate) /2) AS PartiteGiocate, " + 
			"((s2.MediaVoto+ s3.MediaVoto) /2) AS MediaVoto , ((s2.MediaFanta+ s3.MediaFanta) /2) AS MediaFanta , " + 
			"((s2.GolFatti+ s3.GolFatti) /2) AS GolFatti , ((s2.GolSubiti+ s3.GolSubiti)/2) AS GolSubiti, " + 
			"((s2.RigoriParati+ s3.RigoriParati) /2) AS RigoriParati , ((s2.RigoriCalciati+ s3.RigoriCalciati) /2) AS RigoriCalciati , " + 
			"((s2.RigoriSegnati+ s3.RigoriSegnati) /2) AS RigoriSegnati , ((s2.RigoriSbagliati+ s3.RigoriSbagliati) /2) AS RigoriSbagliati , " + 
			"((s2.Assist+ s3.Assist) /2) AS Assist , ((s2.AssistFermo+ s3.AssistFermo) /2) AS AssistFermo, " + 
			"((s2.Ammonizioni+ s3.Ammonizioni) /2) AS Ammonizioni , ((s2.Espulsioni+ s3.Espulsioni) /2) AS Espulsioni , " + 
			"((s2.Autogol+ s3.Autogol) /2) AS Autogol " + 
			"FROM quotazioni q, statistiche20162017 s1, statistiche20172018 s2, statistiche20182019 s3 " + 
			"WHERE q.id = s1.Id AND  q.Id = s2.Id AND  q.Id= s3.Id " + 
			"AND s1.PartiteGiocate=0 and s2.PartiteGiocate>0 and s3.PartiteGiocate >0 " ;

	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
		
			calciatori.put(rs.getInt("Id"),(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
					rs.getString("Squadra"),rs.getInt("Quotazione"), rs.getDouble("PartiteGiocate"), rs.getDouble("MediaVoto"),rs.getDouble("MediaFanta"),
					rs.getDouble("GolFatti"), rs.getDouble("GolSubiti"), rs.getDouble("RigoriParati"), rs.getDouble("RigoriCalciati"), 
					rs.getDouble("RigoriSegnati"), rs.getDouble("RigoriSbagliati"), rs.getDouble("Assist"), 
					rs.getDouble("AssistFermo"), rs.getDouble("Ammonizioni"), rs.getDouble("Espulsioni"), rs.getDouble("Autogol"))));
			
		
			
		}
		conn.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Errore DB");
	}
		return calciatori;
}
/*
 * Ritorna le statistiche dei giocatori attualmente presenti nelle quotazioni che sono
 * stati presenti ed hanno giocato solo nella stagione 2018-2019
 */
public Map<Integer, CalciatoreStatistiche> getMediaSolo20182019(){
	
	Map<Integer, CalciatoreStatistiche> calciatori= new HashMap<Integer, CalciatoreStatistiche>();

	String sql= "SELECT q.Id, q.Ruolo, q.Nome, q.Squadra,q.Quotazione, s3.PartiteGiocate,s3.MediaVoto,s3.MediaFanta,s3.GolFatti,s3.GolSubiti , " + 
			"s3.RigoriParati,s3.RigoriCalciati,s3.RigoriSegnati, s3.RigoriSbagliati, s3.Assist, s3.AssistFermo, s3.Ammonizioni, s3.Espulsioni, s3.Autogol " + 
			"FROM quotazioni q, statistiche20182019 s3 " + 
			"WHERE q.Id= s3.Id " + 
			"AND s3.Id NOT IN (SELECT s1.Id " + 
			"						FROM quotazioni q, statistiche20162017 s1 " + 
			"						WHERE q.id=s1.id) " + 
			"AND s3.Id NOT IN (SELECT s2.Id " + 
			"						FROM quotazioni q, statistiche20172018 s2 " + 
			"						WHERE q.id=s2.id) " + 
			"AND s3.PartiteGiocate >0 " ;

	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
		
			calciatori.put(rs.getInt("Id"),(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
					rs.getString("Squadra"),rs.getInt("Quotazione"), rs.getDouble("PartiteGiocate"), rs.getDouble("MediaVoto"),rs.getDouble("MediaFanta"),
					rs.getDouble("GolFatti"), rs.getDouble("GolSubiti"), rs.getDouble("RigoriParati"), rs.getDouble("RigoriCalciati"), 
					rs.getDouble("RigoriSegnati"), rs.getDouble("RigoriSbagliati"), rs.getDouble("Assist"), 
					rs.getDouble("AssistFermo"), rs.getDouble("Ammonizioni"), rs.getDouble("Espulsioni"), rs.getDouble("Autogol"))));
			
		
			
		}
		conn.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Errore DB");
	}
		return calciatori;
}
/*
 * Ritorna le statistiche dei giocatori attualmente presenti nelle quotazioni che sono
 * stati presenti ed hanno giocato solo nella stagione 2017-2018
 * Attualmente mappa vuota
 */
public Map<Integer, CalciatoreStatistiche> getMediaSolo20172018(){
	
	Map<Integer, CalciatoreStatistiche> calciatori= new HashMap<Integer, CalciatoreStatistiche>();

	String sql= "SELECT q.Id, q.Ruolo, q.Nome, q.Squadra,q.Quotazione, s2.PartiteGiocate,s2.MediaVoto,s2.MediaFanta,s2.GolFatti,s2.GolSubiti , " + 
			" 			s2.RigoriParati,s2.RigoriCalciati,s2.RigoriSegnati, s2.RigoriSbagliati, s2.Assist, s2.AssistFermo, s2.Ammonizioni, s2.Espulsioni, s2.Autogol " + 
			"FROM quotazioni q, statistiche20172018 s2 " + 
			"WHERE q.Id= s2.Id " + 
			"AND s2.Id NOT IN (SELECT s1.Id " + 
			"						FROM quotazioni q, statistiche20162017 s1 " + 
			"						WHERE q.id=s1.id) " + 
			"AND s2.Id NOT IN (SELECT s3.Id " + 
			"						FROM quotazioni q, statistiche20182019 s3 " + 
			"						WHERE q.id=s3.id) " + 
			"AND s2.PartiteGiocate >0 " ;

	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
		
			calciatori.put(rs.getInt("Id"),(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
					rs.getString("Squadra"),rs.getInt("Quotazione"), rs.getDouble("PartiteGiocate"), rs.getDouble("MediaVoto"),rs.getDouble("MediaFanta"),
					rs.getDouble("GolFatti"), rs.getDouble("GolSubiti"), rs.getDouble("RigoriParati"), rs.getDouble("RigoriCalciati"), 
					rs.getDouble("RigoriSegnati"), rs.getDouble("RigoriSbagliati"), rs.getDouble("Assist"), 
					rs.getDouble("AssistFermo"), rs.getDouble("Ammonizioni"), rs.getDouble("Espulsioni"), rs.getDouble("Autogol"))));
			
		
			
		}
		conn.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Errore DB");
	}
		return calciatori;
}
/*
 * Ritorna le statistiche dei giocatori attualmente presenti nelle quotazioni che sono
 * stati presenti ed hanno giocato solo nella stagione 2016-2017
 * Attualmente mappa vuota
 */
public Map<Integer, CalciatoreStatistiche> getMediaSolo20162017(){
	
	Map<Integer, CalciatoreStatistiche> calciatori= new HashMap<Integer, CalciatoreStatistiche>();

	String sql= "SELECT q.Id, q.Ruolo, q.Nome, q.Squadra,q.Quotazione, s1.PartiteGiocate,s1.MediaVoto,s1.MediaFanta,s1.GolFatti,s1.GolSubiti , " + 
			" 		s1.RigoriParati,s1.RigoriCalciati,s1.RigoriSegnati, s1.RigoriSbagliati, s1.Assist, s1.AssistFermo, s1.Ammonizioni, s1.Espulsioni, s1.Autogol " + 
			"FROM quotazioni q, statistiche20162017 s1 " + 
			"WHERE q.Id= s1.Id " + 
			"AND s1.Id NOT IN (SELECT s2.Id " + 
			"						FROM quotazioni q, statistiche20172018 s2 " + 
			"						WHERE q.id=s2.id) " + 
			"AND s1.Id NOT IN (SELECT s3.Id " + 
			"						FROM quotazioni q, statistiche20182019 s3 " + 
			"						WHERE q.id=s3.id) " + 
			"AND s1.PartiteGiocate >0 " ;

	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
		
			calciatori.put(rs.getInt("Id"),(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
					rs.getString("Squadra"),rs.getInt("Quotazione"), rs.getDouble("PartiteGiocate"), rs.getDouble("MediaVoto"),rs.getDouble("MediaFanta"),
					rs.getDouble("GolFatti"), rs.getDouble("GolSubiti"), rs.getDouble("RigoriParati"), rs.getDouble("RigoriCalciati"), 
					rs.getDouble("RigoriSegnati"), rs.getDouble("RigoriSbagliati"), rs.getDouble("Assist"), 
					rs.getDouble("AssistFermo"), rs.getDouble("Ammonizioni"), rs.getDouble("Espulsioni"), rs.getDouble("Autogol"))));
			
		
			
		}
		conn.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Errore DB");
	}
		return calciatori;
}
/*
 * Ritorna le statistiche dei giocatori attualmente presenti nelle quotazioni che sono
 * stati presenti ed hanno giocato solo nelle stagioni 2016-2017 e 2017-2018
 * Attualmente mappa vuota
 */
public Map<Integer, CalciatoreStatistiche> getMediaSolo2016_2017_2018(){
	
	Map<Integer, CalciatoreStatistiche> calciatori= new HashMap<Integer, CalciatoreStatistiche>();

	String sql= "SELECT q.Id, q.Ruolo, q.Nome, q.Squadra,q.Quotazione, ((s1.PartiteGiocate+ s2.PartiteGiocate)/2)AS PartiteGiocate, ((s1.MediaVoto+ s2.MediaVoto)/2) AS MediaVoto , " + 
			"		((s1.MediaFanta+ s2.MediaVoto)/2) AS MediaFanta , ((s1.GolFatti+ s2.GolFatti)/2) AS GolFatti ,(( s1.GolSubiti+ s2.GolSubiti)/2) AS GolSubiti , " + 
			" 		((s1.RigoriParati+ s2.RigoriParati)/2) AS RigoriParati ,((s1.RigoriCalciati+ s2.RigoriCalciati)/2) AS RigoriCalciati, ((s1.RigoriSegnati+ s2.RigoriSegnati)/2) AS RigoriSegnati, " + 
			"		((s1.RigoriSbagliati+ s2.RigoriSbagliati)/2) AS RigoriSbagliati , ((s1.Assist+ s2.Assist)/2) AS Assist , ((s1.AssistFermo+ s2.AssistFermo)/2) AS AssistFermo, " + 
			"		((s1.Ammonizioni+ s2.Ammonizioni)/2)AS Ammonizioni ,(( s1.Espulsioni+ s2.Espulsioni)/2) AS Espulsioni, ((s1.Autogol+ s2.Autogol)/2) AS Autogol " + 
			"FROM quotazioni q, statistiche20162017 s1 ,statistiche20172018 s2 " + 
			"WHERE q.Id= s1.Id  and q.Id=s2.Id\r\n" + 
			"AND s1.Id NOT IN (SELECT s3.Id\r\n" + 
			"						FROM quotazioni q, statistiche20182019 s3 " + 
			"						WHERE q.id=s3.id) " + 
			"AND s2.Id NOT IN (SELECT s3.Id " + 
			"						FROM quotazioni q, statistiche20182019 s3 " + 
			"						WHERE q.id=s3.id) " + 
			"AND s1.PartiteGiocate >0 AND s2.PartiteGiocate>0 " ;

	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
		
			calciatori.put(rs.getInt("Id"),(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
					rs.getString("Squadra"),rs.getInt("Quotazione"), rs.getDouble("PartiteGiocate"), rs.getDouble("MediaVoto"),rs.getDouble("MediaFanta"),
					rs.getDouble("GolFatti"), rs.getDouble("GolSubiti"), rs.getDouble("RigoriParati"), rs.getDouble("RigoriCalciati"), 
					rs.getDouble("RigoriSegnati"), rs.getDouble("RigoriSbagliati"), rs.getDouble("Assist"), 
					rs.getDouble("AssistFermo"), rs.getDouble("Ammonizioni"), rs.getDouble("Espulsioni"), rs.getDouble("Autogol"))));
			
		
			
		}
		conn.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Errore DB");
	}
		return calciatori;
}
/*
 * Ritorna le statistiche dei giocatori attualmente presenti nelle quotazioni che sono
 * stati presenti ed hanno giocato solo nelle stagioni 2016-2017 e 2018-2019
 */
public Map<Integer, CalciatoreStatistiche> getMediaSolo2016_2018_2019(){
	
	Map<Integer, CalciatoreStatistiche> calciatori= new HashMap<Integer, CalciatoreStatistiche>();

	String sql= "SELECT q.Id, q.Ruolo, q.Nome, q.Squadra,q.Quotazione, ((s1.PartiteGiocate+ s3.PartiteGiocate)/2)AS PartiteGiocate, ((s1.MediaVoto+ s3.MediaVoto)/2) AS MediaVoto , " + 
			"		((s1.MediaFanta+ s3.MediaVoto)/2) AS MediaFanta , ((s1.GolFatti+ s3.GolFatti)/2) AS GolFatti ,(( s1.GolSubiti+ s3.GolSubiti)/2) AS GolSubiti , " + 
			" 		((s1.RigoriParati+ s3.RigoriParati)/2) AS RigoriParati ,((s1.RigoriCalciati+ s3.RigoriCalciati)/2) AS RigoriCalciati, ((s1.RigoriSegnati+ s3.RigoriSegnati)/2) AS RigoriSegnati, " + 
			"		((s1.RigoriSbagliati+ s3.RigoriSbagliati)/2) AS RigoriSbagliati , ((s1.Assist+ s3.Assist)/2) AS Assist , ((s1.AssistFermo+ s3.AssistFermo)/2) AS AssistFermo, " + 
			"		((s1.Ammonizioni+ s3.Ammonizioni)/2)AS Ammonizioni ,(( s1.Espulsioni+ s3.Espulsioni)/2) AS Espulsioni, ((s1.Autogol+ s3.Autogol)/2) AS Autogol " + 
			"FROM quotazioni q, statistiche20162017 s1 ,statistiche20182019 s3 " + 
			"WHERE q.Id= s1.Id  and q.Id=s3.Id " + 
			"AND s1.Id NOT IN (SELECT s2.Id " + 
			"						FROM quotazioni q, statistiche20172018 s2 " + 
			"						WHERE q.id=s2.id) " + 
			"AND s3.Id NOT IN (SELECT s2.Id " + 
			"						FROM quotazioni q, statistiche20172018 s2 " + 
			"						WHERE q.id=s2.id) " + 
			"AND s1.PartiteGiocate >0 AND s3.PartiteGiocate>0 " ;

	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
		
			calciatori.put(rs.getInt("Id"),(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
					rs.getString("Squadra"),rs.getInt("Quotazione"), rs.getDouble("PartiteGiocate"), rs.getDouble("MediaVoto"),rs.getDouble("MediaFanta"),
					rs.getDouble("GolFatti"), rs.getDouble("GolSubiti"), rs.getDouble("RigoriParati"), rs.getDouble("RigoriCalciati"), 
					rs.getDouble("RigoriSegnati"), rs.getDouble("RigoriSbagliati"), rs.getDouble("Assist"), 
					rs.getDouble("AssistFermo"), rs.getDouble("Ammonizioni"), rs.getDouble("Espulsioni"), rs.getDouble("Autogol"))));
			
		
			
		}
		conn.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Errore DB");
	}
		return calciatori;
}
/*
 * Ritorna le statistiche dei giocatori attualmente presenti nelle quotazioni che sono
 * stati presenti ed hanno giocato solo nelle stagioni 2017-2018 e 2018-2019
 */
public Map<Integer, CalciatoreStatistiche> getMediaSolo2017_2018_2019(){
	
	Map<Integer, CalciatoreStatistiche> calciatori= new HashMap<Integer, CalciatoreStatistiche>();

	String sql= "SELECT q.Id, q.Ruolo, q.Nome, q.Squadra,q.Quotazione, ((s2.PartiteGiocate+ s3.PartiteGiocate)/2)AS PartiteGiocate, ((s2.MediaVoto+ s3.MediaVoto)/2) AS MediaVoto , " + 
			"		((s2.MediaFanta+ s3.MediaVoto)/2) AS MediaFanta , ((s2.GolFatti+ s3.GolFatti)/2) AS GolFatti ,(( s2.GolSubiti+ s3.GolSubiti)/2) AS GolSubiti , " + 
			" 		((s2.RigoriParati+ s3.RigoriParati)/2) AS RigoriParati ,((s2.RigoriCalciati+ s3.RigoriCalciati)/2) AS RigoriCalciati, ((s2.RigoriSegnati+ s3.RigoriSegnati)/2) AS RigoriSegnati, " + 
			"		((s2.RigoriSbagliati+ s3.RigoriSbagliati)/2) AS RigoriSbagliati , ((s2.Assist+ s3.Assist)/2) AS Assist , ((s2.AssistFermo+ s3.AssistFermo)/2) AS AssistFermo, " + 
			"		((s2.Ammonizioni+ s3.Ammonizioni)/2)AS Ammonizioni ,(( s2.Espulsioni+ s3.Espulsioni)/2) AS Espulsioni, ((s2.Autogol+ s3.Autogol)/2) AS Autogol " + 
			"FROM quotazioni q, statistiche20172018 s2 ,statistiche20182019 s3 " + 
			"WHERE q.Id= s2.Id  and q.Id=s3.Id " + 
			"AND s2.Id NOT IN (SELECT s1.Id " + 
			"						FROM quotazioni q, statistiche20162017 s1 " + 
			"						WHERE q.id=s1.id) " + 
			"AND s3.Id NOT IN (SELECT s1.Id " + 
			"						FROM quotazioni q, statistiche20162017 s1 " + 
			"						WHERE q.id=s1.id) " + 
			"AND s2.PartiteGiocate >0 AND s3.PartiteGiocate>0 " ;

	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs= st.executeQuery();
		
		while(rs.next()) {
		
			calciatori.put(rs.getInt("Id"),(new CalciatoreStatistiche(rs.getInt("Id"), rs.getString("Ruolo"), rs.getString("Nome"), 
					rs.getString("Squadra"),rs.getInt("Quotazione"), rs.getDouble("PartiteGiocate"), rs.getDouble("MediaVoto"),rs.getDouble("MediaFanta"),
					rs.getDouble("GolFatti"), rs.getDouble("GolSubiti"), rs.getDouble("RigoriParati"), rs.getDouble("RigoriCalciati"), 
					rs.getDouble("RigoriSegnati"), rs.getDouble("RigoriSbagliati"), rs.getDouble("Assist"), 
					rs.getDouble("AssistFermo"), rs.getDouble("Ammonizioni"), rs.getDouble("Espulsioni"), rs.getDouble("Autogol"))));
			
		
			
		}
		conn.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Errore DB");
	}
		return calciatori;
}

	
}
