package it.polito.tdp.tesi.model;

public class Quotazione {

	private int id;
	private String ruolo;
	private String nome;
	private String squadra;
	private int quotazione;
	public Quotazione(int id, String ruolo, String nome, String squadra, int quotazione) {
		super();
		this.id = id;
		this.ruolo = ruolo;
		this.nome = nome;
		this.squadra = squadra;
		this.quotazione = quotazione;
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
		Quotazione other = (Quotazione) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("Quotazione [id=%s, ruolo=%s, nome=%s, squadra=%s, quotazione=%s]\n", id, ruolo, nome,
				squadra, quotazione);
	}
	public String toStringQuotazione() {
		return String.format("%-19s %-10s %-5s ", nome, squadra, quotazione);
	}
	
	
}
