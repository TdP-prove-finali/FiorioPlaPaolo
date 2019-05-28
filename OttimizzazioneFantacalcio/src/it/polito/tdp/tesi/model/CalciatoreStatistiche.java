package it.polito.tdp.tesi.model;

public class CalciatoreStatistiche {

	private int id;
	private String ruolo;
	private String nome;
	private String squadra;
	
	private int partiteGiocate;
	private float mediaVoto;
	private float mediaFanta;
	
	private int golFatti;
	private int golSubiti;
	
	private int rigoriParati;
	private int rigoriCalciati;
	private int rigoriSegnati;
	private int rigoriSbagliati;
	
	private int assist;
	private int assistFermo;
	
	private int ammonizioni;
	private int espulsioni;
	private int autogol;
	public CalciatoreStatistiche(int id, String ruolo, String nome, String squadra, int partiteGiocate, float mediaVoto,
			float mediaFanta, int golFatti, int golSubiti, int rigoriParati, int rigoriCalciati, int rigoriSegnati,
			int rigoriSbagliati, int assist, int assistFermo, int ammonizioni, int espulsioni, int autogol) {
		super();
		this.id = id;
		this.ruolo = ruolo;
		this.nome = nome;
		this.squadra = squadra;
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
	public int getPartiteGiocate() {
		return partiteGiocate;
	}
	public float getMediaVoto() {
		return mediaVoto;
	}
	public float getMediaFanta() {
		return mediaFanta;
	}
	public int getGolFatti() {
		return golFatti;
	}
	public int getGolSubiti() {
		return golSubiti;
	}
	public int getRigoriParati() {
		return rigoriParati;
	}
	public int getRigoriCalciati() {
		return rigoriCalciati;
	}
	public int getRigoriSegnati() {
		return rigoriSegnati;
	}
	public int getRigoriSbagliati() {
		return rigoriSbagliati;
	}
	public int getAssist() {
		return assist;
	}
	public int getAssistFermo() {
		return assistFermo;
	}
	public int getAmmonizioni() {
		return ammonizioni;
	}
	public int getEspulsioni() {
		return espulsioni;
	}
	public int getAutogol() {
		return autogol;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format(
				"[ruolo=%s, nome=%s, squadra=%s]\n",
				ruolo, nome, squadra);
	}
	
	
	
	
	
	
	
	
}
