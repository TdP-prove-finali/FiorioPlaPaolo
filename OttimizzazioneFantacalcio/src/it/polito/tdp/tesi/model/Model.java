package it.polito.tdp.tesi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.tesi.db.StatisticheDAO;

public class Model {

	private StatisticheDAO dao;
	private Map<Integer,CalciatoreStatistiche> stat20162017;
	private Map<Integer,CalciatoreStatistiche> stat20172018;
	private Map<Integer,CalciatoreStatistiche> stat20182019;
	private List<CalciatoreStatistiche> media;
	private List<PunteggioCalciatore> punteggi;
	private int budgetTotale;
	private int budgetRimanente;
	private int budgetPortieri;
	private int budgetDifensori;
	private int budgetCentrocampisti;
	private int budgetAttaccanti;
	private List<Quotazione> quotazioni;
	
	public Model() {
		 dao = new StatisticheDAO();
		// quotazioni = dao.getQuotazioni();
	}
	
	public void calcolaMedia() {
		stat20162017 = dao.getCalciatori20162017();
		stat20172018 = dao.getCalciatori20172018();
		stat20182019 = dao.getCalciatori20182019();
		
		
		media = new ArrayList<CalciatoreStatistiche>();
		media.addAll(dao.getCalciatori20162017().values());
		media.addAll(dao.getCalciatori20172018().values());
		media.addAll(dao.getCalciatori20182019().values());
		media.addAll(dao.getMedia2016_2017_2018().values());
		media.addAll(dao.getMedia2016_2018_2019().values());
		media.addAll(dao.getMedia2017_2018_2019().values());
		media.addAll(dao.getMediaSolo20162017().values());
		media.addAll(dao.getMediaSolo2016_2017_2018().values());
		media.addAll(dao.getMediaSolo2016_2018_2019().values());
		media.addAll(dao.getMediaSolo20172018().values());
		media.addAll(dao.getMediaSolo2017_2018_2019().values());
		media.addAll(dao.getMediaSolo20182019().values());
		media.addAll(dao.getMediaTreAnni().values());
							
	}
	public List<CalciatoreStatistiche> getMedia(){
		return media;
	}

	public void calcolaPunteggio() {
		
		punteggi = new ArrayList<PunteggioCalciatore>();
		double punteggio;
		for(CalciatoreStatistiche c : this.media) {
			punteggio=0;
			punteggio+= c.getPartiteGiocate()+c.getMediaFanta()+c.getMediaVoto()+c.getAssist()+2*c.getRigoriSegnati()-3*c.getRigoriSbagliati()+3*c.getGolFatti()-c.getGolSubiti()-2*c.getAmmonizioni()-3*c.getEspulsioni()-3*c.getAutogol();
			PunteggioCalciatore p = new PunteggioCalciatore(c.getId(),c.getSquadra(), c.getNome(), c.getSquadra(), c.getQuotazione(), punteggio);
			punteggi.add(p);
			
		}
		
	}
	public List<PunteggioCalciatore> getListaPunteggi(){
		return this.punteggi;
	}

	

	public int getBudgetTotale() {
		return budgetTotale;
	}


	public void setBudgetTotale(int budgetTotale) {
		this.budgetTotale = budgetTotale;
	}


	public int getBudgetRimanente() {
		return budgetRimanente;
	}


	public void setBudgetRimanente(int budgetRimanente) {
		this.budgetRimanente = budgetRimanente;
	}


	public int getBudgetPortieri() {
		return budgetPortieri;
	}


	public void setBudgetPortieri(int budgetPortieri) {
		this.budgetPortieri = budgetPortieri;
	}


	public int getBudgetDifensori() {
		return budgetDifensori;
	}


	public void setBudgetDifensori(int budgetDifensori) {
		this.budgetDifensori = budgetDifensori;
	}


	public int getBudgetCentrocampisti() {
		return budgetCentrocampisti;
	}


	public void setBudgetCentrocampisti(int budgetCentrocampisti) {
		this.budgetCentrocampisti = budgetCentrocampisti;
	}


	public int getBudgetAttaccanti() {
		return budgetAttaccanti;
	}


	public void setBudgetAttaccanti(int budgetAttaccanti) {
		this.budgetAttaccanti = budgetAttaccanti;
	}


	public void calcolaMigliorRosa() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
