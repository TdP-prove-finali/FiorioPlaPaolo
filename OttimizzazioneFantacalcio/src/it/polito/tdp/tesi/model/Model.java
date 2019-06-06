package it.polito.tdp.tesi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.tesi.db.StatisticheDAO;

public class Model {

	private StatisticheDAO dao;
	private List<CalciatoreStatistiche> stat20162017;
	private List<CalciatoreStatistiche> stat20172018;
	private List<CalciatoreStatistiche> media;
	private int budgetTotale;
	private int budgetRimanente;
	private int budgetPortieri;
	private int budgetDifensori;
	private int budgetCentrocampisti;
	private int budgetAttaccanti;
	
	public Model() {
		 dao = new StatisticheDAO();
	}
	
	
	public List<CalciatoreStatistiche> getMedia(){
		stat20162017 = dao.getCalciatori20162017();
		stat20172018 = dao.getCalciatori20172018();
		media = new ArrayList<CalciatoreStatistiche>();
		
		for(CalciatoreStatistiche c : stat20162017)
			for(CalciatoreStatistiche c1: stat20172018)
				if(c.getNome().equals(c1.getNome()))
					if(c.getPartiteGiocate()>0 && c1.getPartiteGiocate()>0) {
						media.add(new CalciatoreStatistiche(c.getId(), c.getRuolo(), c.getNome(), c.getSquadra(),(c.getPartiteGiocate()+c1.getPartiteGiocate())/2,
								(c.getMediaVoto()+c1.getMediaVoto())/2, (c.getMediaFanta()+c1.getMediaFanta())/2, (c.getGolFatti()+c1.getGolFatti())/2,
								(c.getGolSubiti()+c1.getGolSubiti())/2, (c.getRigoriParati()+c1.getRigoriParati())/2, (c.getRigoriCalciati()+c1.getRigoriCalciati())/2, 
								(c.getRigoriSegnati()+c1.getRigoriSegnati())/2, (c.getRigoriSbagliati()+c1.getRigoriSbagliati())/2,(c.getAssist()+c1.getAssist())/2,
								(c.getAssistFermo()+c1.getAssistFermo())/2, (c.getAmmonizioni()+c1.getAmmonizioni())/2, (c.getEspulsioni()+c1.getEspulsioni())/2, (c.getAutogol()+c1.getAutogol())/2));
					}else if(c.getPartiteGiocate()==0) {
						media.add(new CalciatoreStatistiche(c1.getId(), c1.getRuolo(), c1.getNome(), c1.getSquadra(), c1.getPartiteGiocate(),
								c1.getMediaVoto(), c1.getMediaFanta(), c1.getGolFatti(),
								c1.getGolSubiti(), c1.getRigoriParati(), c1.getRigoriCalciati(), 
								c1.getRigoriSegnati(), c1.getRigoriSbagliati(),c1.getAssist(),
								c1.getAssistFermo(), c1.getAmmonizioni(), c1.getEspulsioni(), c1.getAutogol()));
			
					}else if(c1.getPartiteGiocate()==0) {
						media.add(new CalciatoreStatistiche(c.getId(), c.getRuolo(), c.getNome(), c.getSquadra(), c.getPartiteGiocate(),
								c.getMediaVoto(), c.getMediaFanta(), c.getGolFatti(),
								c.getGolSubiti(), c.getRigoriParati(), c.getRigoriCalciati(), 
								c.getRigoriSegnati(), c.getRigoriSbagliati(),c.getAssist(),
								c.getAssistFermo(), c.getAmmonizioni(), c.getEspulsioni(), c.getAutogol()));
			
					}
				
		
		
		return media;
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
	
	
	
	
	
	
}
