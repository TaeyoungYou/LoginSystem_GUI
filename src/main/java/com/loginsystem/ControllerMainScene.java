package com.loginsystem;

import com.save.SaveAccount;
import com.sign.AccountInfo;
import com.sign.in.SignInAccount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ControllerMainScene {
	@FXML
	TextField idText;
	@FXML
	PasswordField pwText;

	SaveAccount saveAccount = SaveAccount.getInstance();
	SignInAccount signInAccount = new SignInAccount();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Alert alert;
	
	private static int countLogin = 0;

	Image icon = new Image("file:image/iconImage.png");
	
	public void submitAction(ActionEvent event) throws Exception {
		String id = idText.getText();
		String pw = pwText.getText();
		
		if(countLogin >=3 ) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Typed 3 times more");
			alert.setHeaderText("Going back to menu");
			alert.show();
			countLogin=0;
		}else {
			if(signInAccount.checkIDExist(id)&&signInAccount.checkPWExist(pw)) {
				countLogin = 0;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/loginsystem/LoginedScene.fxml"));
				root = loader.load();
				
				Controller_LoginedScene lScene = loader.getController();
				for(AccountInfo i: saveAccount.accList) {
					if((i.getUserID()).equals(id)) {
						lScene.helloUser(i.getNickName());
					}
				}
				
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.getIcons().add(icon);
				stage.setTitle("Hello!");
				stage.setResizable(false);
				stage.show();
			}else {
				countLogin++;
			}
		}
		
		
		
		
	}
	
	public void signUpAction(ActionEvent event) throws Exception{
		root = FXMLLoader.load(getClass().getResource("SignUp_Scene.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.getIcons().add(icon);
		stage.setTitle("Sign Up");
		stage.setResizable(false);
		stage.show();
	}
}
