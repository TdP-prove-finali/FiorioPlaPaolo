package it.polito.tdp.tesi.controller;

import java.net.URL;
import java.util.ResourceBundle;


import it.polito.tdp.tesi.model.CalciatoreStatistiche;
import it.polito.tdp.tesi.model.Model;
import it.polito.tdp.tesi.model.PunteggioCalciatore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class HomeController {

	private Model model;   
	private Stage stage;
	private Stage s;
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
    private TableView<PunteggioCalciatore> tabella;

    @FXML
    private TableColumn<PunteggioCalciatore, String> colNome;

    @FXML
    private TableColumn<PunteggioCalciatore, String> colRuolo;
    
    @FXML
    private TableColumn<PunteggioCalciatore, String> colSquadra;

    @FXML
    private TableColumn<PunteggioCalciatore, Integer> colQuota;

    @FXML
    private Button btnCreaRosa;

    @FXML
    private Button btnReset;
    
 

    @FXML
    void doCreaRosa(ActionEvent event) {

    	btnCreaRosa.setDisable(true);
    	btnReset.setDisable(false);
    	int budgetTotale;
    	int budgetPortieri;
    	int budgetDifensori;
    	int budgetCentrocampisti;
    	int budgetAttaccanti;
     	model.resetParzialeP();
    	model.resetParzialeD();
    	model.resetParzialeC();
    	model.resetParzialeA();
    	model.resetOttima();
    	
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
        		txtRimanenti.setText("ERR");
        		return;
        	}
        	if(budgetPortieri<3 ||budgetDifensori<8 ||budgetCentrocampisti<8 ||budgetAttaccanti<6) {
        		txtRimanenti.setText("ERR");
        		return;
        	}
		} catch (NumberFormatException e ) {
			txtRimanenti.setText("ERR");
			return;
		}
    	try {
    		if(s==null) {
    			
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Rosa.fxml"));
			BorderPane root = (BorderPane) loader.load();
			Scene scene = new Scene(root);
			RosaController controller = loader.getController();
 			controller.setModel(model);
 			s= new Stage();
 			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			s.setScene(scene);
			s.setTitle("Costruisci la tua rosa");
			s.setX(+565.00);
			s.setY(20.00);
			s.show();
    		}
    		else {
    			s.toFront();
    
    		}
    	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	btnReset.setDisable(true);
    	checkPortieri.setSelected(false);
    	btnCreaRosa.setDisable(true);
    	txtTotale.clear();
    	txtAttaccanti.clear();
    	txtCentrocampisti.clear();
    	txtDifensori.clear();
    	txtPortieri.clear();
    	txtRimanenti.clear();
    	
		model.setBudgetTotale(0);
    	model.setBudgetPortieri(0);
    	model.setBudgetDifensori(0);	
    	model.setBudgetCentrocampisti(0);
       	model.setBudgetAttaccanti(0);
    	model.setBudgetRimanente(0);
    	
    	tabella.setItems(null);
    	model.setPortieriStessaSquadra(false);
   
    	model.resetParzialeP();
    	model.resetParzialeD();
    	model.resetParzialeC();
    	model.resetParzialeA();
    	
    	model.calcolaMigliorRosa();
    	if(model.getOttima().size()>0) { 
    		model.resetOttima();    		
    	}
 
    	if(s.getScene()!=null) {
    		s.close();
    		s=null;
    		
    	}
        
    	
    	
    	
    	
    }

    @FXML
    public void doTrovaMigliorRosa(ActionEvent event) {
    	
    	
    	btnCreaRosa.setDisable(false);
    	txtRimanenti.clear();

    	model.setPortieriStessaSquadra(false);
    	
    	if(checkPortieri.isSelected()) {	
    		checkPortieri.setSelected(true);
    		model.setPortieriStessaSquadra(true);
    	}
    	
    	int budgetTotale;
    	int budgetPortieri;
    	int budgetDifensori;
    	int budgetCentrocampisti;
    	int budgetAttaccanti;

    	try {
      
    		budgetTotale = Integer.parseInt(txtTotale.getText());
    		if(model.getBudgetTotale()==0) {
    		model.setBudgetTotale(budgetTotale);}
    		
        	budgetPortieri = Integer.parseInt(txtPortieri.getText());
        	if(model.getBudgetPortieri()==0) {
        		model.setBudgetPortieri(budgetPortieri);}
        	
        	budgetDifensori = Integer.parseInt(txtDifensori.getText());
        	if(model.getBudgetDifensori()==0) {
        	model.setBudgetDifensori(budgetDifensori);}
        	
        	budgetCentrocampisti = Integer.parseInt(txtCentrocampisti.getText());
        	if(model.getBudgetCentrocampisti()==0) {
        	model.setBudgetCentrocampisti(budgetCentrocampisti);}
        	
        	budgetAttaccanti = Integer.parseInt(txtAttaccanti.getText());
        	if(model.getBudgetAttaccanti()==0) {
        	model.setBudgetAttaccanti(budgetAttaccanti);}
        	
        	if((budgetPortieri+budgetDifensori+budgetCentrocampisti+budgetAttaccanti)>budgetTotale) {
        		txtRimanenti.setText("ERR");
        		return;
        		
        	}
        	if(budgetPortieri<3 ||budgetDifensori<8 ||budgetCentrocampisti<8 ||budgetAttaccanti<6) {
        		txtRimanenti.setText("ERR");
        		return;
        	}

        	

        	ObservableList<PunteggioCalciatore> values = FXCollections.observableArrayList(model.calcolaMigliorRosa());
        	tabella.setItems(values);
        	txtRimanenti.setText(String.valueOf(model.getBudgetRimanente()));


		} catch (NumberFormatException e) {
			txtRimanenti.setText("ERR");
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
        assert tabella != null : "fx:id=\"tabella\" was not injected: check your FXML file 'Home.fxml'.";
        assert colNome != null : "fx:id=\"colNome\" was not injected: check your FXML file 'Home.fxml'.";
        assert colRuolo != null : "fx:id=\"colRuolo\" was not injected: check your FXML file 'Home.fxml'.";
        assert colSquadra != null : "fx:id=\"colSquadra\" was not injected: check your FXML file 'Home.fxml'.";
        assert colQuota != null : "fx:id=\"colQuota\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnCreaRosa != null : "fx:id=\"btnCreaRosa\" was not injected: check your FXML file 'Home.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Home.fxml'.";

        
        
        colNome.setCellValueFactory(new PropertyValueFactory<PunteggioCalciatore, String>("nome"));
        colRuolo.setCellValueFactory(new PropertyValueFactory<PunteggioCalciatore, String>("ruolo"));
        colSquadra.setCellValueFactory(new PropertyValueFactory<PunteggioCalciatore, String>("squadra"));
        colQuota.setCellValueFactory(new PropertyValueFactory<PunteggioCalciatore, Integer>("quotazione"));
        
        btnCreaRosa.setDisable(true);
        btnReset.setDisable(true);
    }
    
    public void setModel(Model model, Stage stage) {
    	this.model=model;
    	this.stage=stage;
    	model.calcolaMedia();
    	model.calcolaPunteggio();
    }
}
