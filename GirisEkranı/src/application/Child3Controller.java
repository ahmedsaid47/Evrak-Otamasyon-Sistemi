package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Kullanıcılar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Child3Controller implements Initializable{
	
	@FXML
	private Button userEkleButton;
	@FXML
	private Button temizleButton;
	@FXML
	private TextField isimField;
	@FXML
	private TextField numaraField;
	@FXML
	private TextField sifreField;
	@FXML
	private TextField mailField;
	@FXML
	private Pane pane;
	@FXML
	private Label onayLabel;
	
	
	public Kullanıcılar kullanıcılar=new Kullanıcılar();
	
	

	//kullanıcı ekleme
	@FXML
	private void EkleButon() throws IOException {
		kullanıcılar.KullanıcıEkle(isimField.getText(), numaraField.getText(), sifreField.getText(), mailField.getText(), "User");
		kullanıcılar.DosyaYazma();
		userEkleButton.setText("KAYIT YAPILDI PENCEREYİ KAPATIN");
		isimField=null;
		numaraField=null;
		sifreField=null;
		mailField=null;
	}
	
	
	//giriş textfield'leri temizleme 
	@FXML
	private void temizleButon() {
		isimField.clear();
		numaraField.clear();
		sifreField.clear();
		mailField.clear();
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		kullanıcılar.DosyaOkuma();
		
	}
		


}
