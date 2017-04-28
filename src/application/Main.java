package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Gestion Des Offres de Stages" );
		Parent root=FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
		Scene scene= new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);	
	}
	
	public Stage getPrimaryStage() {
    return getPrimaryStage();
}

}
/*
 * AuthAOControl : Ajouter offre
 * AuthVOControl : Voir offres
 * 
 * Authentification : pour l'espace connexion
 */
 
