package it.polito.tdp.tesi.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import it.polito.tdp.tesi.db.StatisticheDAO;

public class Model {

	private StatisticheDAO dao;
	private int budgetTotale;
	private int budgetRimanente;
	private int budgetPortieri;
	private int budgetDifensori;
	private int budgetCentrocampisti;
	private int budgetAttaccanti;
	private int spesi;
	private boolean portieriStessaSquadra;
	
	private List<CalciatoreStatistiche> media;
	private List<PunteggioCalciatore> punteggi;
	private List<Quotazione> quotazioni;
	private List<CalciatoreStatistiche> portieri;
	private List<CalciatoreStatistiche> difensori;
	private List<CalciatoreStatistiche> centrocampisti;
	private List<CalciatoreStatistiche> attaccanti;
	private List<CalciatoreStatistiche> nomeCalciatori;
	private List<CalciatoreStatistiche> calciatori;
	private List<PunteggioCalciatore> parzialeP;
	private List<PunteggioCalciatore> parzialeD;	
	private List<PunteggioCalciatore> parzialeC;	
	private List<PunteggioCalciatore> parzialeA;
	private List<PunteggioCalciatore> ottima;
	private List<PunteggioCalciatore> punt;
	
	
	public Model() {
		dao = new StatisticheDAO();
		quotazioni = dao.getQuotazioni();
		nomeCalciatori= dao.getNomeCalciatori();
		this.calcolaMedia();
		this.calcolaPunteggio();
		parzialeP = new ArrayList<PunteggioCalciatore>();
		parzialeD = new ArrayList<PunteggioCalciatore>();
		parzialeC = new ArrayList<PunteggioCalciatore>();
		parzialeA = new ArrayList<PunteggioCalciatore>();
	}
	
	public void calcolaMedia() {
		
		
		media = new ArrayList<CalciatoreStatistiche>();
		media.addAll(dao.getCalciatori20162017());
		media.addAll(dao.getCalciatori20172018());
		media.addAll(dao.getCalciatori20182019());
		media.addAll(dao.getMedia2016_2017_2018());
		media.addAll(dao.getMedia2016_2018_2019());
		media.addAll(dao.getMedia2017_2018_2019());
		media.addAll(dao.getMediaSolo20162017());
		media.addAll(dao.getMediaSolo2016_2017_2018());
		media.addAll(dao.getMediaSolo2016_2018_2019());
		media.addAll(dao.getMediaSolo20172018());
		media.addAll(dao.getMediaSolo2017_2018_2019());
		media.addAll(dao.getMediaSolo20182019());
		media.addAll(dao.getMediaTreAnni());
							
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
				punteggio+= 0.40*(2*c.getPartiteGiocate()+2*(c.getMediaFanta()*c.getMediaVoto())+2*c.getAssist()+3*c.getRigoriSegnati()-3*c.getRigoriSbagliati()+3*c.getRigoriParati()+5*c.getGolFatti()-c.getGolSubiti()-c.getAmmonizioni()-2*c.getEspulsioni()-3*c.getAutogol());
			}
			else {
				punteggio+= 2*c.getPartiteGiocate()+2*(c.getMediaFanta()*c.getMediaVoto())+2*c.getAssist()+3*c.getRigoriSegnati()-3*c.getRigoriSbagliati()+3*c.getRigoriParati()+5*c.getGolFatti()-c.getGolSubiti()-c.getAmmonizioni()-2*c.getEspulsioni()-3*c.getAutogol();
					
			}
			PunteggioCalciatore p = new PunteggioCalciatore(c.getId(),c.getRuolo(), c.getNome(), c.getSquadra(), c.getQuotazione(), punteggio);
			punteggi.add(p);
			
		}
		//se esistono calciatori con 0 statistiche presenti nelle valutazioni  il punteggio viene posto uguale a 0
		for(Quotazione q: this.quotazioni) {
			for(CalciatoreStatistiche c: this.media) {
				if(c.getId()!=q.getId()) {
					PunteggioCalciatore p = new PunteggioCalciatore(q.getId(),q.getRuolo(),q.getNome(),q.getSquadra(),q.getQuotazione(),0.0);
					if(!punteggi.contains(p)) {
						punteggi.add(p);
					}
				}
			}
			
		}
		
	}
	
	public List<PunteggioCalciatore> getListaPunteggi(){
		Collections.sort(punteggi,new Comparator<PunteggioCalciatore>() {

			@Override
			public int compare(PunteggioCalciatore o1, PunteggioCalciatore o2) {
				// TODO Auto-generated method stub
				return -Double.compare(o1.getPunteggio(), o2.getPunteggio());
			}
		
		});
		return this.punteggi;
	}


	public List<PunteggioCalciatore> calcolaMigliorRosa() {

		ottima=null;
		ottima = new ArrayList<PunteggioCalciatore>();
		punt = this.getListaPunteggi();
		this.resetOttima();
		ricorsione(this.getParzialeP(),3,"P",this.getBudgetPortieri());
		ricorsione(this.getParzialeD(),8,"D",this.getBudgetDifensori());
		ricorsione(this.getParzialeC(),8,"C",this.getBudgetCentrocampisti());
		ricorsione(this.getParzialeA(),6,"A",this.getBudgetAttaccanti());

		//calcolo della spesa e stampa a console dei vari passaggi
		String res="";
		spesi=0;
		for(PunteggioCalciatore c: ottima) {
		//	res+= c.toStringQuotaz()+"\n";
			spesi+=c.getQuotazione();
		//	System.out.println(res);
		}
		this.setBudgetRimanente(this.getBudgetTotale()-spesi);
		return ottima;
	}
	
	
	private void ricorsione(List<PunteggioCalciatore> parziale,int i,String ruolo, int budget) {
		
		//condizione di terminazione
		if(parziale.size()>=i) {
			this.ottima.addAll(parziale);
			return;
		}
		//se viene selezionato il bottone "Portieri stessa squadra"
		if(portieriStessaSquadra==true) {
			if(ruolo.equals("P")) {
				if(parziale.size()>0 && parziale.size()<i ) {
					String squadra = parziale.get(0).getSquadra();
					for(PunteggioCalciatore c:this.punt) {
						if(!parziale.contains(c)) {
							if(c.getSquadra().equals(squadra) &&c.getRuolo().equals("P")&&c.getQuotazione()+(i-parziale.size()-1)<=budget) {
								parziale.add(c);
								ricorsione(parziale,i,ruolo,budget-c.getQuotazione());
							}
						}	
					
					}
				}
			}
		}
			
		//lavoro nella lista già ordinata per punteggi decrescenti
		
		for(PunteggioCalciatore c:this.punt) {
			if(parziale.size()<i) {
				if(!parziale.contains(c)) {
					if(c.getRuolo().equals(ruolo)){
						
						
						if(c.getQuotazione()+(i-parziale.size()-1)<=budget) {
							parziale.add(c);
							ricorsione(parziale,i,ruolo,budget-c.getQuotazione());
						}
						
					}
				}
						
			
			}
			
		}
		
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
		difensori = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals("D")) {
				difensori.add(c);
			}
		}
	}
	public void selezionaCentrocampisti() {
		centrocampisti = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals("C")) {
				centrocampisti.add(c);
			}
		}
	}
	public void selezionaAttaccanti() {
			attaccanti = new ArrayList<CalciatoreStatistiche>();
			for(CalciatoreStatistiche c: this.media) {
				if(c.getRuolo().equals("A")) {
					attaccanti.add(c);
				}
			}
		}

	public List<CalciatoreStatistiche> getPortieriRetiSubite() {
		calciatori = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.portieri) {
			if(c.getGolSubiti()>0 && c.getPartiteGiocate()>10) {
				calciatori.add(c);
			}
		}	
		Collections.sort(calciatori, new Comparator<CalciatoreStatistiche>() {

			@Override
			public int compare(CalciatoreStatistiche o1, CalciatoreStatistiche o2) {
				// TODO Auto-generated method stub
				return Double.compare((o1.getGolSubiti()/o1.getPartiteGiocate()),(o2.getGolSubiti()/o2.getPartiteGiocate()));
				}
			
		});

		return calciatori;
	}


	public List<CalciatoreStatistiche> getPortieriRigoriParati() {
		calciatori = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.portieri) {
			if(c.getRigoriParati()>0) {
				calciatori.add(c);
			}
		}	
		Collections.sort(calciatori, new Comparator<CalciatoreStatistiche>() {

			@Override
			public int compare(CalciatoreStatistiche o1, CalciatoreStatistiche o2) {
				// TODO Auto-generated method stub
				return -Double.compare(o1.getRigoriParati(),o2.getRigoriParati());
				}
			
		});

		return calciatori;
	}


	public List<CalciatoreStatistiche> getSquadra(String ruolo) {

			
		List<PunteggioCalciatore> punt = new ArrayList<PunteggioCalciatore>();
		for(PunteggioCalciatore s: this.getListaPunteggi()) {
			if(s.getRuolo().equals(ruolo)) {
				punt.add(s);
			}
		
		}
		Collections.sort(punt, new Comparator<PunteggioCalciatore>() {

			@Override
			public int compare(PunteggioCalciatore o1, PunteggioCalciatore o2) {
				// TODO Auto-generated method stub
		
				int c;
			    c = o1.getSquadra().compareTo(o2.getSquadra());
			    if (c == 0)
			       c = -Double.compare(o1.getQuotazione(),o2.getQuotazione());
			    return c;
				
				
			}
		
		});

		
		List<CalciatoreStatistiche> risultato = new ArrayList<CalciatoreStatistiche>();
		for(PunteggioCalciatore s: punt) {
			for(CalciatoreStatistiche c: this.nomeCalciatori) {
				if(c.getId()==s.getId()) {
					risultato.add(c);
				}
			}
		}
		
		return risultato;
	}

	
	public List<CalciatoreStatistiche> getMediaVoto(String ruolo) {
	
	calciatori = new ArrayList<CalciatoreStatistiche>();
	for(CalciatoreStatistiche c: this.media) {
		if(c.getRuolo().equals(ruolo)&&c.getPartiteGiocate()>10) {
			//media diminuita per giocatori provenienti dalla Serie B
			if(c.getSquadra().equals("Lecce")||c.getSquadra().equals("Brescia")||c.getSquadra().equals("Verona")) {
				c.setMediaVoto(c.getMediaVoto()*0.95);
			}
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

	return calciatori;
	}
	
	public List<CalciatoreStatistiche> getFantaMedia(String ruolo) {
		
		calciatori = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals(ruolo)&&c.getPartiteGiocate()>10) {
				//FantaMedia diminuita per giocatori provenienti dalla Serie B
				if(c.getSquadra().equals("Lecce")||c.getSquadra().equals("Brescia")||c.getSquadra().equals("Verona")) {
					c.setMediaFanta(c.getMediaFanta()*0.85);
				}
				calciatori.add(c);
			}
		}	
		Collections.sort(calciatori, new Comparator<CalciatoreStatistiche>() {

				@Override
				public int compare(CalciatoreStatistiche o1, CalciatoreStatistiche o2) {
					// TODO Auto-generated method stub
					return -Double.compare(o1.getMediaFanta(),o2.getMediaFanta());
					}
				
		});

		return calciatori;
		}
	
	public List<CalciatoreStatistiche> getQuotazioni(String ruolo) {

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
					return -Double.compare(o1.getQuotazione(),o2.getQuotazione());
					}
				
		});
		return calciatori;
	}
	
	
	public List<CalciatoreStatistiche> getPunteggio(String ruolo) {

		List<PunteggioCalciatore> punt = new ArrayList<PunteggioCalciatore>();

			for(PunteggioCalciatore s: this.punteggi) {
				if(s.getRuolo().equals(ruolo)) {
					punt.add(s);
				}
			
		}
		Collections.sort(punt, new Comparator<PunteggioCalciatore>() {

			@Override
			public int compare(PunteggioCalciatore o1, PunteggioCalciatore o2) {
				// TODO Auto-generated method stub
				return -Double.compare(o1.getPunteggio(), o2.getPunteggio());
			}
		
		});
		List<CalciatoreStatistiche> risultato = new ArrayList<CalciatoreStatistiche>();
		for(PunteggioCalciatore s: punt) {
			for(CalciatoreStatistiche c: this.nomeCalciatori) {
				if(c.getId()==s.getId()) {
					risultato.add(c);
				}
			}
		}
		
		return risultato;
		
	}


	public List<CalciatoreStatistiche> getGoleador(String ruolo) {

		calciatori = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals(ruolo)&&(c.getGolFatti()>0||c.getRigoriSegnati()>0)) {
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
		return calciatori;
		}

	public List<CalciatoreStatistiche> getAssistman(String ruolo) {
		calciatori = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals(ruolo)&&(c.getAssist()>0||c.getAssistFermo()>0)) {
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
		return calciatori;

	}

	public List<CalciatoreStatistiche> getCartellini(String ruolo) {
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
		
		return calciatori;
	}

	public List<CalciatoreStatistiche> getRigoristi(String ruolo) {
	
		calciatori = new ArrayList<CalciatoreStatistiche>();
		for(CalciatoreStatistiche c: this.media) {
			if(c.getRuolo().equals(ruolo) &&c.getRigoriSegnati()>0) {
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
		return calciatori;
	}

	public void setPortieriStessaSquadra(boolean b) {
		this.portieriStessaSquadra=b;
		if(parzialeP.size()==3) {
		this.resetParzialeP();}
	}
	
	public List<PunteggioCalciatore> getParzialeP() {
		return parzialeP;
	}

	public List<PunteggioCalciatore> getParzialeD() {
		return parzialeD;
	}

	

	public List<PunteggioCalciatore> getParzialeC() {
		return parzialeC;
	}

	public List<PunteggioCalciatore> getParzialeA() {
		return parzialeA;	}

	public void addParzialeP(List<CalciatoreStatistiche> lista) {
		for(CalciatoreStatistiche c: lista) {
			PunteggioCalciatore d = this.getSimile(c);
			if(!this.parzialeP.contains(d)) {
				this.parzialeP.add(d);
				budgetRimanente= budgetRimanente-d.getQuotazione();
				}
			}
	}

	public void addParzialeD(List<CalciatoreStatistiche> lista) {
		for(CalciatoreStatistiche c: lista) {
			PunteggioCalciatore d = this.getSimile(c);
			if(!this.parzialeD.contains(d)) {
				this.parzialeD.add(d);
				budgetRimanente= budgetRimanente-d.getQuotazione();
			}
		}
		
	}

	public void addParzialeC(List<CalciatoreStatistiche> lista) {
		for(CalciatoreStatistiche c: lista) {
			PunteggioCalciatore d = this.getSimile(c);
			if(!this.parzialeC.contains(d)) {
				this.parzialeC.add(d);
				budgetRimanente= budgetRimanente-d.getQuotazione();

			}
		}
	}
	public void addParzialeA(List<CalciatoreStatistiche> lista) {
		for(CalciatoreStatistiche c: lista) {
			PunteggioCalciatore d = this.getSimile(c);
			if(!this.parzialeA.contains(d)) {
				this.parzialeA.add(d);
				budgetRimanente= budgetRimanente-d.getQuotazione();
			}
		}
	}
	

	public void resetParzialeP() {
		this.parzialeP.removeAll(parzialeP);
	}

	public void resetParzialeD() {
		this.parzialeD.removeAll(parzialeD);
	}

	public void resetParzialeC() {
		this.parzialeC.removeAll(parzialeC);
	}

	public void resetParzialeA() {
		this.parzialeA.removeAll(parzialeA);
	}
	public void resetOttima() {
		this.ottima.removeAll(ottima);
		
	}
	

	public List<PunteggioCalciatore> getOttima() {
		return ottima;
	}

	public PunteggioCalciatore getSimile(CalciatoreStatistiche c) {
		for(PunteggioCalciatore p:punteggi) {
			if(p.getId()==c.getId())
				return p;
			
		}
		return null;
		
	}
	

	public int getBudgetTotale() {
		return budgetTotale;
	}


	public void setBudgetTotale(int budgetTotale) {
		this.budgetTotale = budgetTotale;
	}


	public int getBudgetRimanente() {
		return	budgetRimanente;
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
