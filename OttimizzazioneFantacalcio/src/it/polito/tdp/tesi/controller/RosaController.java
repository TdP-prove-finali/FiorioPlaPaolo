package it.polito.tdp.tesi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.tesi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RosaController {

	private Model model;
	private int budgetTotale;
	private int budgetRimanente;
	private int costoSelezionato;
	
	public void setModel(Model model) {
		this.model = model;	
		budgetTotale= model.getBudgetTotale();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtListe;
    
    @FXML
    private TextField txtResiduo;

    @FXML
    private Button btnAggiungi;

    @FXML
    private Button btnRimuovi;

    @FXML
    private TextArea txtTuaRosa;

    @FXML
    private ComboBox<String> cmbPortieri;

    @FXML
    private Button btnGeneraPortieri;

    @FXML
    private ComboBox<String> cmbDifensori;

    @FXML
    private Button btnGeneraDifensori;

    @FXML
    private ComboBox<String> cmbCentrocampisti;

    @FXML
    private Button btnGeneraCentrocampisti;

    @FXML
    private ComboBox<String> cmbAttaccanti;

    @FXML
    private Button btnGeneraAttaccanti;

    @FXML
    void doGeneraDifensori(ActionEvent event) {

    	model.selezionaDifensori();
    	String caratteristica = cmbDifensori.getValue();
    	if(caratteristica.equals("Media voto")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-14s %-10s %-10s %-5s\n", "Nome", "Squadra", "MediaVoto", "Quota"));
    		txtListe.appendText(model.getMediaVoto("D"));
    	}
    	if(caratteristica.equals("Quotazione")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-14s %-10s %-5s\n", "Nome", "Squadra",  "Quota"));
    		txtListe.appendText(model.getQuotazioni("D"));
    	}
    	if(caratteristica.equals("Punteggio")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-14s %-10s %-9s %-5s\n", "Nome", "Squadra",  "Punteggio", "Quota"));
    		txtListe.appendText(model.getPunteggio("D"));
    	}
    	if(caratteristica.equals("Goleador")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-14s %-10s %-4s %-5s\n", "Nome", "Squadra",  "Gol", "Quota"));
    		txtListe.appendText(model.getGoleador("D"));
    	}
    	if(caratteristica.equals("Assistman")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-14s %-10s %-6s %-5s\n", "Nome", "Squadra",  "Assist", "Quota"));
    		txtListe.appendText(model.getAssistman("D"));
    	}
    	if(caratteristica.equals("Più cartellini")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-14s %-10s %-5s %-5s %-5s\n", "Nome", "Squadra",  "Gialli","Rossi", "Quota"));
    		txtListe.appendText(model.getCartellini("D"));
    	}
    	if(caratteristica.equals("Rigoristi")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-14s %-10s %-9s %-9s %-5s\n", "Nome", "Squadra",  "Segnati","Calciati", "Quota"));
    		txtListe.appendText(model.getRigoristi("D"));
    	}
    	
    }

    @FXML
    void doGeneraAttaccanti(ActionEvent event) {
    	model.selezionaAttaccanti();
    	String caratteristica = cmbAttaccanti.getValue();
    	if(caratteristica.equals("Media voto")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-19s %-10s %-10s %-5s\n", "Nome", "Squadra", "MediaVoto", "Quota"));
    		txtListe.appendText(model.getMediaVoto("A"));
    	}
    	if(caratteristica.equals("Quotazione")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-19s %-10s %-5s\n", "Nome", "Squadra",  "Quota"));
    		txtListe.appendText(model.getQuotazioni("A"));
    	}
    	if(caratteristica.equals("Punteggio")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-19s %-10s %-9s %-5s\n", "Nome", "Squadra",  "Punteggio", "Quota"));
    		txtListe.appendText(model.getPunteggio("A"));
    	}
    	if(caratteristica.equals("Goleador")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-19s %-10s %-4s %-5s\n", "Nome", "Squadra",  "Gol", "Quota"));
    		txtListe.appendText(model.getGoleador("A"));
    	}
    	if(caratteristica.equals("Assistman")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-19s %-10s %-6s %-5s\n", "Nome", "Squadra",  "Assist", "Quota"));
    		txtListe.appendText(model.getAssistman("A"));
    	}
    	if(caratteristica.equals("Più cartellini")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-19s %-10s %-5s %-5s %-5s\n", "Nome", "Squadra",  "Gialli","Rossi", "Quota"));
    		txtListe.appendText(model.getCartellini("A"));
    	}
    	if(caratteristica.equals("Rigoristi")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-19s %-10s %-9s %-9s %-5s\n", "Nome", "Squadra",  "Segnati","Calciati", "Quota"));
    		txtListe.appendText(model.getRigoristi("A"));
    	}
    	
    }

    @FXML
    void doGeneraCentrocampisti(ActionEvent event) {
    	model.selezionaCentrocampisti();
    	String caratteristica = cmbCentrocampisti.getValue();
    	if(caratteristica.equals("Media voto")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-18s %-10s %-10s %-5s\n", "Nome", "Squadra", "MediaVoto", "Quota"));
    		txtListe.appendText(model.getMediaVoto("C"));
    	}
    	if(caratteristica.equals("Quotazione")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-18s %-10s %-5s\n", "Nome", "Squadra",  "Quota"));
    		txtListe.appendText(model.getQuotazioni("C"));
    	}
    	if(caratteristica.equals("Punteggio")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-18s %-10s %-9s %-5s\n", "Nome", "Squadra",  "Punteggio", "Quota"));
    		txtListe.appendText(model.getPunteggio("C"));
    	}
    	if(caratteristica.equals("Goleador")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-18s %-10s %-4s %-5s\n", "Nome", "Squadra",  "Gol", "Quota"));
    		txtListe.appendText(model.getGoleador("C"));
    	}
    	if(caratteristica.equals("Assistman")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-18s %-10s %-6s %-5s\n", "Nome", "Squadra",  "Assist", "Quota"));
    		txtListe.appendText(model.getAssistman("C"));
    	}
    	if(caratteristica.equals("Più cartellini")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-18s %-10s %-5s %-5s %-5s\n", "Nome", "Squadra",  "Gialli","Rossi", "Quota"));
    		txtListe.appendText(model.getCartellini("C"));
    	}
    	if(caratteristica.equals("Rigoristi")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-18s %-10s %-9s %-9s %-5s\n", "Nome", "Squadra",  "Segnati","Calciati", "Quota"));
    		txtListe.appendText(model.getRigoristi("C"));
    	}
    	
    	
    }

    @FXML
    void doGeneraPortieri(ActionEvent event) {
    	
    	model.selezionaPortieri();
    	String caratteristica = cmbPortieri.getValue();
    	if(caratteristica.equals("Media reti subite a partita")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-14s %-10s %-12s %-5s\n", "Nome", "Squadra", "Reti/Partita", "Quota"));
    		txtListe.appendText(model.getPortieriRetiSubite());
    	}
    	if(caratteristica.equals("Media voto")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-14s %-10s %-10s %-5s\n", "Nome", "Squadra", "MediaVoto", "Quota"));
    		txtListe.appendText(model.getMediaVoto("P"));
    	}
    	if(caratteristica.equals("Quotazioni")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-14s %-10s %-5s\n", "Nome", "Squadra",  "Quota"));
    		txtListe.appendText(model.getQuotazioni("P"));
    	}
    	if(caratteristica.equals("Punteggio")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-14s %-10s %-9s %-5s\n", "Nome", "Squadra",  "Punteggio", "Quota"));
    		txtListe.appendText(model.getPunteggio("P"));
    	}
    	if(caratteristica.equals("Rigori parati")) {
    		txtListe.clear();
    		txtListe.appendText(String.format("%-14s %-10s %-13s %-5s\n", "Nome", "Squadra",  "Rigori parati", "Quota"));
    		txtListe.appendText(model.getPortieriRigoriParati());
    	}
    	
    }
    
    @FXML
    void doAggiungi(ActionEvent event) {
    	String aggiungi = txtListe.getSelectedText();
    	txtTuaRosa.appendText(aggiungi+"\n");
    	
    	//budgetRimanente = budgetTotale-costoSelezionato
    }

    @FXML
    void doRimuovi(ActionEvent event) {

    	//String rimuovi = txtTuaRosa.getSelectedText();
    	//lista.remove(rimuovi);
    	txtTuaRosa.replaceSelection("");
    }

    @FXML
    void initialize() {
        assert txtListe != null : "fx:id=\"txtListe\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert btnAggiungi != null : "fx:id=\"btnAggiungi\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert btnRimuovi != null : "fx:id=\"btnRimuovi\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert txtTuaRosa != null : "fx:id=\"txtTuaRosa\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert cmbPortieri != null : "fx:id=\"cmbPortieri\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert btnGeneraPortieri != null : "fx:id=\"btnGeneraPortieri\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert cmbDifensori != null : "fx:id=\"cmbDifensori\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert btnGeneraDifensori != null : "fx:id=\"btnGeneraDifensori\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert cmbCentrocampisti != null : "fx:id=\"cmbCentrocampisti\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert btnGeneraCentrocampisti != null : "fx:id=\"btnGeneraCentrocampisti\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert cmbAttaccanti != null : "fx:id=\"cmbAttaccanti\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert btnGeneraAttaccanti != null : "fx:id=\"btnGeneraAttaccanti\" was not injected: check your FXML file 'Rosa.fxml'.";
        
        txtTuaRosa.setStyle("-fx-font-family: monospace");
        txtListe.setStyle("-fx-font-family: monospace");
        cmbPortieri.getItems().addAll("Media voto", "Media reti subite a partita","Quotazioni", "Punteggio migliore"
        		,"Rigori parati");
        cmbDifensori.getItems().addAll("Media voto", "Quotazione", "Punteggio","Goleador", "Assistman", "Più cartellini", "Rigoristi");
        cmbCentrocampisti.getItems().addAll("Media voto", "Quotazione", "Punteggio","Goleador", "Assistman", "Più cartellini", "Rigoristi");
        cmbAttaccanti.getItems().addAll("Media voto", "Quotazione", "Punteggio","Goleador", "Assistman", "Più cartellini", "Rigoristi");
    }
}

