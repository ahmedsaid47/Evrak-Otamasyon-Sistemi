package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public abstract class Menu {
	
	Stage stage;
	BorderPane borderPane;
	
	@FXML
	public void anaEkran(ActionEvent event) throws IOException {
		Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("Child.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
		stage.setWidth(942.0);
		stage.setHeight(595.0);
		borderPane = Main.getBorderPane();
		borderPane.setCenter(root);
	}
	
	@FXML
	public void girisEkran(ActionEvent event) throws IOException {
		Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
		stage.setWidth(650.0);
		stage.setHeight(450.0);
		borderPane = Main.getBorderPane();
		borderPane.setCenter(root);
	}
	
	@FXML
	public void useradd(ActionEvent event) {
		try {
			Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("Child1.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
			borderPane = Main.getBorderPane();
			borderPane.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void evrakekle(ActionEvent event) {
		try {
			Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("Child2.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
			borderPane = Main.getBorderPane();
			borderPane.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
