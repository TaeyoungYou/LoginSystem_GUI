package com.loginsystem;
	
import java.util.Optional;

import com.save.SaveAccount;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class App extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		SaveAccount saveAccount = SaveAccount.getInstance();
		Image icon = new Image("file:image/iconImage.png");
		Parent root = FXMLLoader.load(getClass().getResource("/com/loginsystem/MainScene.fxml"));
		
		
		stage.setOnCloseRequest(e->{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Close");
			alert.setHeaderText("Really want to close");
			Optional<ButtonType> result = alert.showAndWait();
			if(result.isPresent()&&result.get()==ButtonType.OK) {
				saveAccount.saveAccountInfo();
			}
		});
		
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.getIcons().add(icon);
		stage.setTitle("Login");
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
