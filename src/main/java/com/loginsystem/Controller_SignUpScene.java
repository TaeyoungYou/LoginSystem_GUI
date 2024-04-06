package com.loginsystem;

import com.save.SaveAccount;
import com.sign.up.SignUpAccount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Controller_SignUpScene {
	@FXML
	TextField userNameText;
	@FXML
	TextField useridText;
	@FXML
	TextField userPwText;
	
	SignUpAccount signUpAccount;
	SaveAccount saveAccount;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Alert alert;
	
	public void signUpSubmit(ActionEvent event) throws Exception{
		saveAccount = SaveAccount.getInstance();
		signUpAccount = new SignUpAccount();
		
		String signUpName = userNameText.getText();
		String signUpId = useridText.getText();
		String signUpPw = userPwText.getText();
		
		if(!(signUpName.equals("") || signUpId.equals("") || signUpPw.equals(""))) {
			signUpAccount.createNickName(signUpName);
			if(!signUpAccount.createID(signUpId)||!signUpAccount.createPW(signUpPw)) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Wrong ID/PW");
				alert.setHeaderText("ID or PW is duplicated/typed wrong or less than 8 letters");
				alert.showAndWait();
			}else {
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Success");
				alert.setHeaderText("Complete to create account!");
				alert.show();
				saveAccount.addAccount(signUpAccount.returnSignUpInfo());
				gotoMain(event);
			}
		}
	}
	public void signUpBack(ActionEvent event) throws Exception{
		gotoMain(event);
	}
	
	private void gotoMain(ActionEvent event) throws Exception {
		Image icon = new Image("file:image/iconImage.png");
		root = FXMLLoader.load(getClass().getResource("/com/loginsystem/MainScene.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.getIcons().add(icon);
		stage.setTitle("Login");
		stage.setResizable(false);
		stage.show();
	}

}
