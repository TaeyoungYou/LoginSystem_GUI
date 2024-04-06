package com.loginsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller_LoginedScene {
	@FXML
	Label userText;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void helloUser(String name) {
		userText.setText(String.format("Hello! %s",name));
	}
	public void backMenu(ActionEvent event) throws Exception {
		root = FXMLLoader.load(getClass().getResource("/com/loginsystem/MainScene.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.setResizable(false);
		stage.show();
	}

}
