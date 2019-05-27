package it.polito.tdp.tesi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.tesi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomeController {

	private Model model;
	private Stage stage;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTotale;

    @FXML
    private TextField txtPortieri;

    @FXML
    private TextField txtDifensori;

    @FXML
    private TextField txtCentrocampisti;

    @FXML
    private TextField txtAttaccanti;

    @FXML
    private Button btnMigliorRosa;

    @FXML
    private TextField txtRimanenti;

    @FXML
    private TextArea txtRosa;

    @FXML
    private Button btnCreaRosa;

    @FXML
    private Button btnReset;

    @FXML
    void doCreaRosa(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doTrovaMigliorRosa(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtTotale != null : "fx:id=\"txtTotale\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtPortieri != null : "fx:id=\"txtPortieri\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtDifensori != null : "fx:id=\"txtDifensori\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtCentrocampisti != null : "fx:id=\"txtCentrocampisti\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtAttaccanti != null : "fx:id=\"txtAttaccanti\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnMigliorRosa != null : "fx:id=\"btnMigliorRosa\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtRimanenti != null : "fx:id=\"txtRimanenti\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtRosa != null : "fx:id=\"txtRosa\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnCreaRosa != null : "fx:id=\"btnCreaRosa\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Home.fxml'.";

    }
    
    public void setModel(Model model, Stage stage) {
    	this.model=model;
    	this.stage=stage;
    }
}
