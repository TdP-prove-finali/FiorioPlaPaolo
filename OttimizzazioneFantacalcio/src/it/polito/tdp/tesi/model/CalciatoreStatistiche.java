package it.polito.tdp.tesi.model;

public class CalciatoreStatistiche {

	private int id;
	private String ruolo;
	private String nome;
	private String squadra;
	
	private float partiteGiocate;
	private float mediaVoto;
	private float mediaFanta;
	
	private float golFatti;
	private float golSubiti;
	
	private float rigoriParati;
	private float rigoriCalciati;
	private float rigoriSegnati;
	private float rigoriSbagliati;
	
	private float assist;
	private float assistFermo;
	
	private float ammonizioni;
	private float espulsioni;
	private float autogol;
	
	public CalciatoreStatistiche(int id, String ruolo, String nome, String squadra, float partiteGiocate, float mediaVoto,
			float mediaFanta, float golFatti, float golSubiti, float rigoriParati, float rigoriCalciati, float rigoriSegnati,
			float rigoriSbagliati, float assist, float assistFermo, float ammonizioni, float espulsioni, float autogol) {
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
	public float getPartiteGiocate() {
		return partiteGiocate;
	}
	public float getMediaVoto() {
		return mediaVoto;
	}
	public float getMediaFanta() {
		return mediaFanta;
	}
	public float getGolFatti() {
		return golFatti;
	}
	public float getGolSubiti() {
		return golSubiti;
	}
	public float getRigoriParati() {
		return rigoriParati;
	}
	public float getRigoriCalciati() {
		return rigoriCalciati;
	}
	public float getRigoriSegnati() {
		return rigoriSegnati;
	}
	public float getRigoriSbagliati() {
		return rigoriSbagliati;
	}
	public float getAssist() {
		return assist;
	}
	public float getAssistFermo() {
		return assistFermo;
	}
	public float getAmmonizioni() {
		return ammonizioni;
	}
	public float getEspulsioni() {
		return espulsioni;
	}
	public float getAutogol() {
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
				"id=%s, ruolo=%s, nome=%s, squadra=%s, partiteGiocate=%s, mediaVoto=%s, mediaFanta=%s, golFatti=%s, golSubiti=%s, rigoriParati=%s, rigoriCalciati=%s, rigoriSegnati=%s, rigoriSbagliati=%s, assist=%s, assistFermo=%s, ammonizioni=%s, espulsioni=%s, autogol=%s\n",
				id, ruolo, nome, squadra, partiteGiocate, mediaVoto, mediaFanta, golFatti, golSubiti, rigoriParati,
				rigoriCalciati, rigoriSegnati, rigoriSbagliati, assist, assistFermo, ammonizioni, espulsioni, autogol);
	}
	
	
	
	
	
	
	
	
}
