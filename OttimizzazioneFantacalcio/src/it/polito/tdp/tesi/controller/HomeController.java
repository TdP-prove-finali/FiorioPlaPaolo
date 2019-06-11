package it.polito.tdp.tesi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.tesi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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
    private CheckBox checkPortieri;
    
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


    	try {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Rosa.fxml"));
			BorderPane root = (BorderPane) loader.load();
			Scene scene = new Scene(root);
			
			RosaController controller = loader.getController();
 			controller.setModel(model);
 			Stage s= new Stage();
			
 			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			s.setScene(scene);
			
			s.setTitle("Costruisci la tua rosa");
			s.setX(+565.00);
			s.setY(20.00);
			s.show();
			
		} catch(Exception e) {
			e.printStackTrace();
}
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtTotale.clear();
    	txtAttaccanti.clear();
    	txtCentrocampisti.clear();
    	txtDifensori.clear();
    	txtPortieri.clear();
    	txtRimanenti.clear();
    	txtRosa.clear();

    }

    @FXML
    void doTrovaMigliorRosa(ActionEvent event) {
    	
    	txtRosa.clear();
    	if(checkPortieri.isSelected()) {
    		// dopo aver selezionato il miglior portiere,
    		// aggiungi i 2 portieri della sua stessa squadra
    		// prova txtRosa.appendText("portieri stessa squadra");
    	}
    	;
    	int budgetTotale;
    	int budgetPortieri;
    	int budgetDifensori;
    	int budgetCentrocampisti;
    	int budgetAttaccanti;
    	int budgetRimanente;
    	try {
    		budgetTotale = Integer.parseInt(txtTotale.getText());
    		model.setBudgetTotale(budgetTotale);
        	budgetPortieri = Integer.parseInt(txtPortieri.getText());
        	model.setBudgetPortieri(budgetPortieri);
        	budgetDifensori = Integer.parseInt(txtDifensori.getText());
        	model.setBudgetDifensori(budgetDifensori);
        	budgetCentrocampisti = Integer.parseInt(txtCentrocampisti.getText());
        	model.setBudgetCentrocampisti(budgetCentrocampisti);
        	budgetAttaccanti = Integer.parseInt(txtAttaccanti.getText());
        	model.setBudgetAttaccanti(budgetAttaccanti);
        	
        	if((budgetPortieri+budgetDifensori+budgetCentrocampisti+budgetAttaccanti)>budgetTotale) {
        		txtRosa.appendText("ERRORE!\nI budget inseriti superano quello totale");
        		return;
        	}
        	budgetRimanente=budgetTotale-budgetPortieri-budgetDifensori-budgetCentrocampisti-budgetAttaccanti;
        	System.out.format("Budget totale: %d \nBudget portieri: %d \n"
        			+ "Budget difensori %d: \nBudget centrocampisti: %d \nBudget attaccanti: %d \nBudget rimanente: %d \n",
        			budgetTotale,budgetPortieri,budgetDifensori, budgetCentrocampisti, budgetAttaccanti, budgetRimanente);
        	txtRosa.appendText("Ecco la miglior rosa possibile: \n");
        	model.calcolaMigliorRosa();
        	/*for(int i=0; i<25 ; i++) {
        		txtRosa.appendText("i\n" );
        	}*/
        	
		} catch (NumberFormatException e) {
			txtRosa.appendText("ERRORE : inserire il budget in cifre");
			return;
		}
    	
    }

    @FXML
    void initialize() {
        assert txtTotale != null : "fx:id=\"txtTotale\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtPortieri != null : "fx:id=\"txtPortieri\" was not injected: check your FXML file 'Home.fxml'.";
        assert checkPortieri != null : "fx:id=\"checkPortieri\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtDifensori != null : "fx:id=\"txtDifensori\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtCentrocampisti != null : "fx:id=\"txtCentrocampisti\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtAttaccanti != null : "fx:id=\"txtAttaccanti\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnMigliorRosa != null : "fx:id=\"btnMigliorRosa\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtRimanenti != null : "fx:id=\"txtRimanenti\" was not injected: check your FXML file 'Home.fxml'.";
        assert txtRosa != null : "fx:id=\"txtRosa\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnCreaRosa != null : "fx:id=\"btnCreaRosa\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Home.fxml'.";

        txtRosa.setStyle("-fx-font-family: monospace");
    }
    
    public void setModel(Model model, Stage stage) {
    	this.model=model;
    	this.stage=stage;
    }
}
