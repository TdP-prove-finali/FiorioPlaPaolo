package it.polito.tdp.tesi.model;

public class PunteggioCalciatore {

	private int id;
	private String ruolo;
	private String nome;
	private String squadra;
	private int quotazione;
	private double punteggio;
	public PunteggioCalciatore(int id, String ruolo, String nome, String squadra, int quotazione, double punteggio) {
		super();
		this.id = id;
		this.ruolo = ruolo;
		this.nome = nome;
		this.squadra = squadra;
		this.quotazione = quotazione;
		this.punteggio = punteggio;
	}
	
	
	
	public int getId() {
		return id;
	}



	public String getRuolo() {
		return ruolo;
	}



	public String getNome() {
		return nome;
	}



	public String getSquadra() {
		return squadra;
	}



	public int getQuotazione() {
		return quotazione;
	}



	public double getPunteggio() {
		return punteggio;
	}
	
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PunteggioCalciatore other = (PunteggioCalciatore) obj;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return String.format("PunteggioCalciatore [id=%s, ruolo=%s, nome=%s, squadra=%s, quotazione=%s, punteggio=%s]\n",
				id, ruolo, nome, squadra, quotazione, punteggio);
	}



	public String toStringPunteggio() {
		return String.format("%-19s %-10s %-9.5s %-3s ", nome, squadra,punteggio, quotazione);
	}
	public String toStringQuotaz() {
		return String.format("%-19s %-10s %-3s ", nome, squadra, quotazione);
	}



	public String toStringNomeQuota() {
		return String.format("%-19s %-3s ", nome,  quotazione);
	}
	
}
