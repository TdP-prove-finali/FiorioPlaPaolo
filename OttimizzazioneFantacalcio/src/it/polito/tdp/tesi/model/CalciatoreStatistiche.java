package it.polito.tdp.tesi.model;

public class CalciatoreStatistiche {

	private int id;
	private String ruolo;
	private String nome;
	private String squadra;
	private int quotazione;
	
	private double partiteGiocate;
	private double mediaVoto;
	private double mediaFanta;
	
	private double golFatti;
	private double golSubiti;
	
	private double rigoriParati;
	private double rigoriCalciati;
	private double rigoriSegnati;
	private double rigoriSbagliati;
	
	private double assist;
	private double assistFermo;
	
	private double ammonizioni;
	private double espulsioni;
	private double autogol;
	public CalciatoreStatistiche(int id, String ruolo, String nome, String squadra, int quotazione,
			double partiteGiocate, double mediaVoto, double mediaFanta, double golFatti, double golSubiti,
			double rigoriParati, double rigoriCalciati, double rigoriSegnati, double rigoriSbagliati, double assist,
			double assistFermo, double ammonizioni, double espulsioni, double autogol) {
		super();
		this.id = id;
		this.ruolo = ruolo;
		this.nome = nome;
		this.squadra = squadra;
		this.quotazione = quotazione;
		this.partiteGiocate = partiteGiocate;
		this.mediaVoto = mediaVoto;
		this.mediaFanta = mediaFanta;
		this.golFatti = golFatti;
		this.golSubiti = golSubiti;
		this.rigoriParati = rigoriParati;
		this.rigoriCalciati = rigoriCalciati;
		this.rigoriSegnati = rigoriSegnati;
		this.rigoriSbagliati = rigoriSbagliati;
		this.assist = assist;
		this.assistFermo = assistFermo;
		this.ammonizioni = ammonizioni;
		this.espulsioni = espulsioni;
		this.autogol = autogol;
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
	public double getPartiteGiocate() {
		return partiteGiocate;
	}
	public double getMediaVoto() {
		return mediaVoto;
	}
	public double getMediaFanta() {
		return mediaFanta;
	}
	public double getGolFatti() {
		return golFatti;
	}
	public double getGolSubiti() {
		return golSubiti;
	}
	public double getRigoriParati() {
		return rigoriParati;
	}
	public double getRigoriCalciati() {
		return rigoriCalciati;
	}
	public double getRigoriSegnati() {
		return rigoriSegnati;
	}
	public double getRigoriSbagliati() {
		return rigoriSbagliati;
	}
	public double getAssist() {
		return assist;
	}
	public double getAssistFermo() {
		return assistFermo;
	}
	public double getAmmonizioni() {
		return ammonizioni;
	}
	public double getEspulsioni() {
		return espulsioni;
	}
	public double getAutogol() {
		return autogol;
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
		CalciatoreStatistiche other = (CalciatoreStatistiche) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format(
				"Calciatore [id=%s, ruolo=%s, nome=%s, squadra=%s, quotazione=%s, partiteGiocate=%s, mediaVoto=%s, mediaFanta=%s, golFatti=%s, golSubiti=%s, rigoriParati=%s, rigoriCalciati=%s, rigoriSegnati=%s, rigoriSbagliati=%s, assist=%s, assistFermo=%s, ammonizioni=%s, espulsioni=%s, autogol=%s]\n",
				id, ruolo, nome, squadra, quotazione, partiteGiocate, mediaVoto, mediaFanta, golFatti, golSubiti,
				rigoriParati, rigoriCalciati, rigoriSegnati, rigoriSbagliati, assist, assistFermo, ammonizioni,
				espulsioni, autogol);
	}

	public String toStringPortieriRetiSubite() {
		return String.format("%-14s %-10s %-12.4s %-5s ", nome, squadra, golSubiti/partiteGiocate, quotazione);
	}
	public String toStringMediaVoto() {
		return String.format("%-19s %-10s %-10.4s %-5s ", nome, squadra, mediaVoto, quotazione);
	}
	public String toStringRigoriParati() {
		return String.format("%-14s %-10s %-13.4s %-5s ", nome, squadra, rigoriParati, quotazione);
	}
	public String toStringGolFatti() {
		return String.format("%-19s %-10s %-4.4s %-5s ", nome, squadra, golFatti+rigoriSegnati, quotazione);
		
	}
	public String toStringAssist() {
		return String.format("%-19s %-10s %-6.4s %-5s ", nome, squadra, assist, quotazione);
	}
	public String toStringCartellini() {
		return String.format("%-19s %-10s %-6.4s %-6.4s %-5s ", nome, squadra, ammonizioni,espulsioni, quotazione);
	}
	public String toStringRigoristi() {
		return String.format("%-19s %-10s %-9.4s %-9.4s %-5s ", nome, squadra, rigoriSegnati,rigoriCalciati, quotazione);

	}
	
	
	
}