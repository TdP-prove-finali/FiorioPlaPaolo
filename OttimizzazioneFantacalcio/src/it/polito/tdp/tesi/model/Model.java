package it.polito.tdp.tesi.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
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
	
	private Map<Integer,Quotazione> quotazioni;
	private List<CalciatoreStatistiche> portieri;
	private List<CalciatoreStatistiche> difensori;
	private List<CalciatoreStatistiche> centrocampisti;
	private List<CalciatoreStatistiche> attaccanti;
	
	private List<CalciatoreStatistiche> calciatori;
	
	
	public Model() {
		 dao = new StatisticheDAO();
		 quotazioni = dao.getQuotazioni();
		 this.calcolaMedia();
		 this.calcolaPunteggio();
		 
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
			//punteggio depotenziato per giocatori provenienti dalla Serie B
			if(c.getSquadra().equals("Lecce")||c.getSquadra().equals("Brescia")||c.getSquadra().equals("Verona")) {
				punteggio+= 0.60*(2*c.getPartiteGiocate()+c.getMediaFanta()+c.getMediaVoto()+c.getAssist()+3*c.getRigoriSegnati()-3*c.getRigoriSbagliati()+3*c.getGolFatti()-c.getGolSubiti()-2*c.getAmmonizioni()-3*c.getEspulsioni()-3*c.getAutogol());
			}
			else {
				punteggio+= 2*c.getPartiteGiocate()+c.getMediaFanta()+c.getMediaVoto()+c.getAssist()+3*c.getRigoriSegnati()-3*c.getRigoriSbagliati()+3*c.getGolFatti()-c.getGolSubiti()-2*c.getAmmonizioni()-3*c.getEspulsioni()-3*c.getAutogol();
			}
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
	
	public void selezionaPortieri() {
		this.calcolaMedia();
		portieri = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals("P")) {
				portieri.add(c);
			}
		}
		
	}
	public void selezionaDifensori() {
	//	this.calcolaMedia();
		difensori = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals("D")) {
				difensori.add(c);
			}
		}
	}
	public void selezionaCentrocampisti() {
	//	this.calcolaMedia();
		centrocampisti = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals("C")) {
				centrocampisti.add(c);
			}
		}
	}
	public void selezionaAttaccanti() {
		//	this.calcolaMedia();
			attaccanti = new ArrayList<CalciatoreStatistiche>();
			for(CalciatoreStatistiche c: this.media) {
				if(c.getRuolo().equals("A")) {
					attaccanti.add(c);
				}
			}
		}

	public String getPortieriRetiSubite() {
		
		
		Collections.sort(portieri, new Comparator<CalciatoreStatistiche>() {

			@Override
			public int compare(CalciatoreStatistiche o1, CalciatoreStatistiche o2) {
				// TODO Auto-generated method stub
				return Double.compare((o1.getGolSubiti()/o1.getPartiteGiocate()),(o2.getGolSubiti()/o2.getPartiteGiocate()));
				}
			
		});
		String risultato = "";
		for(CalciatoreStatistiche c: portieri) {
			risultato+= c.toStringPortieriRetiSubite()+"\n";
		}
		return risultato;
	}


	public String getPortieriRigoriParati() {
		Collections.sort(this.portieri, new Comparator<CalciatoreStatistiche>() {

			@Override
			public int compare(CalciatoreStatistiche o1, CalciatoreStatistiche o2) {
				// TODO Auto-generated method stub
				return -Double.compare(o1.getRigoriParati(),o2.getRigoriParati());
				}
			
		});
		String risultato = "";
		for(CalciatoreStatistiche c: portieri) {
			risultato+= c.toStringRigoriParati()+"\n";
		}
		return risultato;
	}


	
	
	public String getMediaVoto(String ruolo) {
	
	calciatori = new ArrayList<CalciatoreStatistiche>();
	for(CalciatoreStatistiche c: this.media) {
		if(c.getRuolo().equals(ruolo)) {
			calciatori.add(c);
		}
	}	
	Collections.sort(calciatori, new Comparator<CalciatoreStatistiche>() {

			@Override
			public int compare(CalciatoreStatistiche o1, CalciatoreStatistiche o2) {
				// TODO Auto-generated method stub
				return -Double.compare(o1.getMediaVoto(),o2.getMediaVoto());
				}
			
	});
	String risultato = "";
	for(CalciatoreStatistiche c: calciatori) {
		risultato+= c.toStringMediaVoto()+"\n";
	}
	return risultato;
	}
	
	
	
	public String getQuotazioni(String ruolo) {
		List<Quotazione> calciatoriquot;
		calciatoriquot = new ArrayList<Quotazione>();
		for(Quotazione c: this.quotazioni.values()) {
			if(c.getRuolo().equals(ruolo)) {
				calciatoriquot.add(c);
			}
		}

		
		Collections.sort(calciatoriquot, new Comparator<Quotazione>() {
			@Override
			public int compare(Quotazione o1, Quotazione o2) {
				// TODO Auto-generated method stub
				return -Double.compare(o1.getQuotazione(), o2.getQuotazione());
				}	
		});
		String risultato = "";
		for(Quotazione c: calciatoriquot) {
			risultato+= c.toStringQuotazione()+"\n";
		}
		return risultato;
	}
	
	
	public String getPunteggio(String ruolo) {
	//	this.calcolaPunteggio();
		calciatori = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals(ruolo)) {
				calciatori.add(c);
			}
		}
		List<PunteggioCalciatore> punt = new ArrayList<PunteggioCalciatore>();
		for(CalciatoreStatistiche c: this.calciatori) {
			for(PunteggioCalciatore s: this.punteggi) {
				if(c.getId()==s.getId()) {
					punt.add(s);
				}
			}
		}
		Collections.sort(punt, new Comparator<PunteggioCalciatore>() {

			@Override
			public int compare(PunteggioCalciatore o1, PunteggioCalciatore o2) {
				// TODO Auto-generated method stub
				return -Double.compare(o1.getPunteggio(), o2.getPunteggio());
			}
		
		});
		String risultato = "";
		for(PunteggioCalciatore c: punt) {
			risultato+= c.toStringPunteggio()+"\n";
		}
		return risultato;
		
	}


	public String getGoleador(String ruolo) {

		calciatori = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals(ruolo)) {
				calciatori.add(c);
			}
		}	
		Collections.sort(calciatori, new Comparator<CalciatoreStatistiche>() {

				@Override
				public int compare(CalciatoreStatistiche o1, CalciatoreStatistiche o2) {
					// TODO Auto-generated method stub
					return -Double.compare(o1.getGolFatti()+o1.getRigoriSegnati(),o2.getGolFatti()+o2.getRigoriSegnati());
					}
				
		});
		String risultato = "";
		for(CalciatoreStatistiche c: calciatori) {
			risultato+= c.toStringGolFatti()+"\n";
		}
		return risultato;
		}

	public String getAssistman(String ruolo) {
		calciatori = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals(ruolo)) {
				calciatori.add(c);
			}
		}	
		Collections.sort(calciatori, new Comparator<CalciatoreStatistiche>() {

				@Override
				public int compare(CalciatoreStatistiche o1, CalciatoreStatistiche o2) {
					// TODO Auto-generated method stub
					return -Double.compare(o1.getAssist(),o2.getAssist());
					}
				
		});
		String risultato = "";
		for(CalciatoreStatistiche c: calciatori) {
			risultato+= c.toStringAssist()+"\n";
		}
		return risultato;

	}

	public String getCartellini(String ruolo) {
		calciatori = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals(ruolo)) {
				calciatori.add(c);
			}
		}	
		Collections.sort(calciatori, new Comparator<CalciatoreStatistiche>() {

				@Override
				public int compare(CalciatoreStatistiche o1, CalciatoreStatistiche o2) {
					// TODO Auto-generated method stub
					return -Double.compare((o1.getAmmonizioni()+o1.getEspulsioni()),(o2.getAmmonizioni()+o2.getEspulsioni()));
					}
				
		});
		String risultato = "";
		for(CalciatoreStatistiche c: calciatori) {
			risultato+= c.toStringCartellini()+"\n";
		}
		return risultato;
	}

	public String getRigoristi(String ruolo) {
	
		calciatori = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals(ruolo)) {
				calciatori.add(c);
			}
		}	
		Collections.sort(calciatori, new Comparator<CalciatoreStatistiche>() {

				@Override
				public int compare(CalciatoreStatistiche o1, CalciatoreStatistiche o2) {
					// TODO Auto-generated method stub
					return -Double.compare(o1.getRigoriSegnati(),o2.getRigoriSegnati());
					}
				
		});
		String risultato = "";
		for(CalciatoreStatistiche c: calciatori) {
			risultato+= c.toStringRigoristi()+"\n";
		}
		return risultato;
	}
	
}
