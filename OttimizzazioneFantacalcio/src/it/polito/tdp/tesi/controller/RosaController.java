package it.polito.tdp.tesi.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.tesi.model.CalciatoreStatistiche;
import it.polito.tdp.tesi.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class RosaController {

	private Model model;
	private int budgetTotale;
	private int res;
	private List<CalciatoreStatistiche> portieriRosa;
	private List<CalciatoreStatistiche> difensoriRosa;
	private List<CalciatoreStatistiche> centrocampistiRosa;
	private List<CalciatoreStatistiche> attaccantiRosa;
	
	public void setModel(Model model) {
		
		this.model = model;	
		budgetTotale= model.getBudgetTotale();
		txtResiduo.appendText(String.valueOf(budgetTotale));
    	portieriRosa = new ArrayList<CalciatoreStatistiche>();
    	difensoriRosa = new ArrayList<CalciatoreStatistiche>();
    	centrocampistiRosa = new ArrayList<CalciatoreStatistiche>();
    	attaccantiRosa = new ArrayList<CalciatoreStatistiche>(); 	
    	res = Integer.parseInt(txtResiduo.getText());
    
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<CalciatoreStatistiche> tabellaCaratteristiche;

    @FXML
    private TableColumn<CalciatoreStatistiche, String> colNomeCaratt;

    @FXML
    private TableColumn<CalciatoreStatistiche, String> colRuoloCaratt; 
    
    @FXML
    private TableColumn<CalciatoreStatistiche, String> colSquadraCaratt;

    @FXML
    private TableColumn<CalciatoreStatistiche, Integer> colQuotaCaratt;
    
    @FXML
    private TableView<CalciatoreStatistiche> tabellaRosa;

    @FXML
    private TableColumn<CalciatoreStatistiche, String> colNomeRosa;

    @FXML
    private TableColumn<CalciatoreStatistiche, String> colRuoloRosa;
    
    @FXML
    private TableColumn<CalciatoreStatistiche, String> colSquadraRosa;

    @FXML
    private TableColumn<CalciatoreStatistiche, Integer> colQuotaRosa;
    
    @FXML
    private TextField txtResiduo;

    @FXML
    private Button btnAggiungi;

    @FXML
    private Button btnAggiornaRosa;
    
    @FXML
    private Button btnRimuovi;


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
    void doGeneraPortieri(ActionEvent event) {
       	tabellaCaratteristiche.setItems(null);
    	model.selezionaPortieri();
    	String caratteristica = cmbPortieri.getValue();
    	if(caratteristica.equals("Squadra")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getSquadra("P"));
        	tabellaCaratteristiche.setItems(values);
 			}
    	if(caratteristica.equals("Minor media reti subite a partita")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getPortieriRetiSubite());
        	tabellaCaratteristiche.setItems(values);
 			}
       	if(caratteristica.equals("Media voto decrescente")) {
           	ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getMediaVoto("P"));
        	tabellaCaratteristiche.setItems(values);
    	}
       	if(caratteristica.equals("FantaMedia decrescente")) {
           	ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getFantaMedia("P"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Quotazione decrescente")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getQuotazioni("P"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Punteggio decrescente")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getPunteggio("P"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Rigori parati")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getPortieriRigoriParati());
        	tabellaCaratteristiche.setItems(values);
    	}
    	
    }
    @FXML
    void doGeneraDifensori(ActionEvent event) {
    	tabellaCaratteristiche.setItems(null);
    	String caratteristica = cmbDifensori.getValue();
    	if(caratteristica.equals("Squadra")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getSquadra("D"));
        	tabellaCaratteristiche.setItems(values);
 			}
    	if(caratteristica.equals("Media voto decrescente")) {
           	ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getMediaVoto("D"));
        	tabellaCaratteristiche.setItems(values);
    	}
       	if(caratteristica.equals("FantaMedia decrescente")) {
           	ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getFantaMedia("D"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Quotazione decrescente")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getQuotazioni("D"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Punteggio decrescente")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getPunteggio("D"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Goleador")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getGoleador("D"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Assistman")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getAssistman("D"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Più cartellini")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getCartellini("D"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Rigoristi")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getRigoristi("D"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	
    }

  

    @FXML
    void doGeneraCentrocampisti(ActionEvent event) {
       	tabellaCaratteristiche.setItems(null);
    	String caratteristica = cmbCentrocampisti.getValue();
    	if(caratteristica.equals("Squadra")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getSquadra("C"));
        	tabellaCaratteristiche.setItems(values);
 			}
    	if(caratteristica.equals("Media voto decrescente")) {
           	ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getMediaVoto("C"));
        	tabellaCaratteristiche.setItems(values);
    	}
       	if(caratteristica.equals("FantaMedia decrescente")) {
           	ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getFantaMedia("C"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Quotazione decrescente")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getQuotazioni("C"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Punteggio decrescente")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getPunteggio("C"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Goleador")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getGoleador("C"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Assistman")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getAssistman("C"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Più cartellini")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getCartellini("C"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Rigoristi")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getRigoristi("C"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	
    }

    @FXML
    void doGeneraAttaccanti(ActionEvent event) {
       	tabellaCaratteristiche.setItems(null);
    	String caratteristica = cmbAttaccanti.getValue();
    	if(caratteristica.equals("Squadra")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getSquadra("A"));
        	tabellaCaratteristiche.setItems(values);
 			}
    	if(caratteristica.equals("Media voto decrescente")) {
           	ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getMediaVoto("A"));
        	tabellaCaratteristiche.setItems(values);
    	}
       	if(caratteristica.equals("FantaMedia decrescente")) {
           	ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getFantaMedia("A"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Quotazione decrescente")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getQuotazioni("A"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Punteggio decrescente")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getPunteggio("A"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Goleador")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getGoleador("A"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Assistman")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getAssistman("A"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Più cartellini")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getCartellini("A"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	if(caratteristica.equals("Rigoristi")) {
    		ObservableList<CalciatoreStatistiche> values = FXCollections.observableArrayList(model.getRigoristi("A"));
        	tabellaCaratteristiche.setItems(values);
    	}
    	
    }
    
    @FXML
    void doAggiungi(ActionEvent event) {
    	model.resetOttima();
    	CalciatoreStatistiche c =tabellaCaratteristiche.getSelectionModel().getSelectedItem();
    	if (!tabellaRosa.getItems().contains(c)) {
    		if(c.getRuolo().equals("P")&&portieriRosa.size()<3&&(res-c.getQuotazione()>=0)) {
    			tabellaRosa.getItems().add(c);
    			portieriRosa.add(c);
    			res= res-c.getQuotazione();
    			model.setBudgetTotale(res);			
    			txtResiduo.setText(String.valueOf(res));
    		}
    		if(c.getRuolo().equals("D")&&difensoriRosa.size()<8&&(res-c.getQuotazione()>=0)) {
    			tabellaRosa.getItems().add(c);
    			difensoriRosa.add(c);
    			res= res-c.getQuotazione();
    			model.setBudgetTotale(res);
    			txtResiduo.setText(String.valueOf(res));
    		}
    		if(c.getRuolo().equals("C")&&centrocampistiRosa.size()<8&&(res-c.getQuotazione()>=0)) {
    			tabellaRosa.getItems().add(c);
    			centrocampistiRosa.add(c);
    			res= res-c.getQuotazione();
    			model.setBudgetTotale(res);
    			txtResiduo.setText(String.valueOf(res));
    		}
    		if(c.getRuolo().equals("A")&&attaccantiRosa.size()<6&&(res-c.getQuotazione()>=0)) {
    			tabellaRosa.getItems().add(c);
    			attaccantiRosa.add(c);
    			res= res-c.getQuotazione();
    			model.setBudgetTotale(res);
    			txtResiduo.setText(String.valueOf(res));
    		}
    	}

    }

    @FXML
    void doAggiornaRosa(ActionEvent event) {

    	model.resetOttima();
    	model.addParzialeP(portieriRosa);
    	model.addParzialeD(difensoriRosa);
    	model.addParzialeC(centrocampistiRosa);
    	model.addParzialeA(attaccantiRosa);
    	model.calcolaMigliorRosa();

    }
    @FXML
    void doRimuovi(ActionEvent event) {
    	model.resetOttima();
    	CalciatoreStatistiche c =tabellaRosa.getSelectionModel().getSelectedItem();
    	if(c.getRuolo().equals("P")) {
			tabellaRosa.getItems().remove(c);
			portieriRosa.remove(c);
			res= res+c.getQuotazione();
			model.getParzialeP().remove(model.getSimile(c));
			model.setBudgetTotale(res);
			model.setBudgetPortieri(model.getBudgetPortieri()+c.getQuotazione());
			txtResiduo.setText(String.valueOf(res));
		}
		if(c.getRuolo().equals("D")) {
			tabellaRosa.getItems().remove(c);
			difensoriRosa.remove(c);
			res= res+c.getQuotazione();
			model.getParzialeD().remove(model.getSimile(c));
			model.setBudgetTotale(res);
			model.setBudgetDifensori(model.getBudgetDifensori()+c.getQuotazione());
			txtResiduo.setText(String.valueOf(res));
		}
		if(c.getRuolo().equals("C")) {
			tabellaRosa.getItems().remove(c);
			centrocampistiRosa.remove(c);
			res= res+c.getQuotazione();
			model.getParzialeC().remove(model.getSimile(c));
			model.setBudgetTotale(res);
			model.setBudgetCentrocampisti(model.getBudgetCentrocampisti()+c.getQuotazione());
			txtResiduo.setText(String.valueOf(res));
		}
		if(c.getRuolo().equals("A")) {
			tabellaRosa.getItems().remove(c);
			attaccantiRosa.remove(c);
			res= res+c.getQuotazione();
			model.getParzialeA().remove(model.getSimile(c));
			model.setBudgetTotale(res);
			model.setBudgetAttaccanti(model.getBudgetAttaccanti()+c.getQuotazione());
			txtResiduo.setText(String.valueOf(res));
		}

    }

    @FXML
    void initialize() {
        assert tabellaCaratteristiche != null : "fx:id=\"tabellaCaratteristiche\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert colNomeCaratt != null : "fx:id=\"colNomeCaratt\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert colRuoloCaratt != null : "fx:id=\"colRuoloCaratt\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert colSquadraCaratt != null : "fx:id=\"colSquadraCaratt\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert colQuotaCaratt != null : "fx:id=\"colQuotaCaratt\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert tabellaRosa != null : "fx:id=\"tabellaRosa\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert colNomeRosa != null : "fx:id=\"colNomeRosa\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert colRuoloRosa != null : "fx:id=\"colRuoloRosa\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert colSquadraRosa != null : "fx:id=\"colSquadraRosa\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert colQuotaRosa != null : "fx:id=\"colQuotaRosa\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert btnAggiungi != null : "fx:id=\"btnAggiungi\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert btnAggiornaRosa != null : "fx:id=\"btnAggiornaRosa\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert btnRimuovi != null : "fx:id=\"btnRimuovi\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert cmbPortieri != null : "fx:id=\"cmbPortieri\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert btnGeneraPortieri != null : "fx:id=\"btnGeneraPortieri\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert cmbDifensori != null : "fx:id=\"cmbDifensori\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert btnGeneraDifensori != null : "fx:id=\"btnGeneraDifensori\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert cmbCentrocampisti != null : "fx:id=\"cmbCentrocampisti\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert btnGeneraCentrocampisti != null : "fx:id=\"btnGeneraCentrocampisti\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert cmbAttaccanti != null : "fx:id=\"cmbAttaccanti\" was not injected: check your FXML file 'Rosa.fxml'.";
        assert btnGeneraAttaccanti != null : "fx:id=\"btnGeneraAttaccanti\" was not injected: check your FXML file 'Rosa.fxml'.";
        

        cmbPortieri.getItems().addAll("Squadra","Media voto decrescente","FantaMedia decrescente", "Minor media reti subite a partita","Quotazione decrescente", "Punteggio decrescente"
        		,"Rigori parati");
        cmbDifensori.getItems().addAll("Squadra","Media voto decrescente","FantaMedia decrescente", "Quotazione decrescente", "Punteggio decrescente","Goleador", "Assistman", "Più cartellini", "Rigoristi");
        cmbCentrocampisti.getItems().addAll("Squadra","Media voto decrescente","FantaMedia decrescente", "Quotazione decrescente", "Punteggio decrescente","Goleador", "Assistman", "Più cartellini", "Rigoristi");
        cmbAttaccanti.getItems().addAll("Squadra","Media voto decrescente","FantaMedia decrescente", "Quotazione decrescente", "Punteggio decrescente","Goleador", "Assistman", "Più cartellini", "Rigoristi");
 
        colNomeCaratt.setCellValueFactory(new PropertyValueFactory<CalciatoreStatistiche, String>("nome"));
        colNomeRosa.setCellValueFactory(new PropertyValueFactory<CalciatoreStatistiche, String>("nome"));      
        colRuoloCaratt.setCellValueFactory(new PropertyValueFactory<CalciatoreStatistiche, String>("ruolo"));
        colRuoloRosa.setCellValueFactory(new PropertyValueFactory<CalciatoreStatistiche, String>("ruolo"));      

        colSquadraCaratt.setCellValueFactory(new PropertyValueFactory<CalciatoreStatistiche, String>("squadra"));
        colSquadraRosa.setCellValueFactory(new PropertyValueFactory<CalciatoreStatistiche, String>("squadra"));
        colQuotaCaratt.setCellValueFactory(new PropertyValueFactory<CalciatoreStatistiche, Integer>("quotazione"));
        colQuotaRosa.setCellValueFactory(new PropertyValueFactory<CalciatoreStatistiche, Integer>("quotazione"));
        
        
    }
}

