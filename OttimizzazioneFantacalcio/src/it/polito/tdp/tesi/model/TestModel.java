package it.polito.tdp.tesi.model;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Model m = new Model();
	//	System.out.println("medie ottenute: \n");
		m.calcolaMedia();
		
	//	System.out.println(m.getMedia());
	
		m.calcolaPunteggio();
	//	System.out.println(m.getListaPunteggi());
		
	//	m.getPortieriRetiSubite();
	//	String.format("%s %s %s %s", "Nome", "Squadra", "Partite Giocate", "RetiSubite");
	//	System.out.println(m.getPortieriRetiSubite());
		System.out.println(m.getPortieriPunteggio());
	}

}
