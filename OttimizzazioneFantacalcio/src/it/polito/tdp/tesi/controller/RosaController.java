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
    private ComboBox<?> cmbPortieri;

    @FXML
    private Button btnGeneraPortieri;

    @FXML
    private ComboBox<?> cmbDifensori;

    @FXML
    private Button btnGeneraDifensori;

    @FXML
    private ComboBox<?> cmbCentrocampisti;

    @FXML
    private Button btnGeneraCentrocampisti;

    @FXML
    private ComboBox<?> cmbAttaccanti;

    @FXML
    private Button btnGeneraAttaccanti;

    @FXML
    void btnGeneraDifensori(ActionEvent event) {

    }

    @FXML
    void doGeneraAttaccanti(ActionEvent event) {

    }

    @FXML
    void doGeneraCentrocampisti(ActionEvent event) {

    }

    @FXML
    void doGeneraPortieri(ActionEvent event) {

    }
    
    @FXML
    void doAggiungi(ActionEvent event) {
    	String aggiungi = txtListe.getSelectedText();
    	txtTuaRosa.appendText(aggiungi);
    	
    	//budgetRimanente = budgetTotale-costoSelezionato
    }

    @FXML
    void doRimuovi(ActionEvent event) {

    	String rimuovi = txtTuaRosa.getSelectedText();
    	//lista.remove(rimuovi);
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
    }
}

