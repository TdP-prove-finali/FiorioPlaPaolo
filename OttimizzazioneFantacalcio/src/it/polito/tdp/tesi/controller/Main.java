package it.polito.tdp.tesi.controller;
	
import it.polito.tdp.tesi.model.Model;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
			BorderPane root = (BorderPane) loader.load();
			
			HomeController controller = loader.getController();
			Model model= new Model();
			controller.setModel(model,primaryStage);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
		//	primaryStage.setAlwaysOnTop(true);
			primaryStage.setTitle("Ottimizza la rosa del tuo Fantacalcio");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
