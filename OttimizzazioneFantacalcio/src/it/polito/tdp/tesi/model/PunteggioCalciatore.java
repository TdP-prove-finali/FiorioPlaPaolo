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
	@Override
	public String toString() {
		return String.format("PunteggioCalciatore [id=%s, ruolo=%s, nome=%s, squadra=%s, quotazione=%s, punteggio=%s]\n",
				id, ruolo, nome, squadra, quotazione, punteggio);
	}
	
	
}
