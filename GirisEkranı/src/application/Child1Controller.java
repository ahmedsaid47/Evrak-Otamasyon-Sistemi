package application;


import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Child1Controller extends Menu implements Initializable {
	@FXML
	private TableView<Kullanıcı> tableView=new TableView<>();
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
	private RadioButton adminRadioButton;
	@FXML
	private Label tarihgLabel;
	@FXML
	private Label gisimLabel;
	@FXML
	private Label gnumaraLabel;
	@FXML
	private RadioButton userButton;
	@FXML
    private javafx.scene.control.ListView<Kullanıcı> kullanıcılarListView;
    @FXML
    private Button userAddButton;
    
	public Kullanıcılar kullanıcılar=new Kullanıcılar();
	String sınıfString;
	Stage stage;
	BorderPane borderPane;
	
	
	
	//****************************Menu**********************************
	@Override
	public void anaEkran(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		super.anaEkran(event);
	}


	@Override
	public void girisEkran(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		super.girisEkran(event);
	}


	@Override
	public void useradd(ActionEvent event) {
		// TODO Auto-generated method stub
		super.useradd(event);
	}


	@Override
	public void evrakekle(ActionEvent event) {
		// TODO Auto-generated method stub
		super.evrakekle(event);
	}
	//********************************************************************


	
	//kullanıcı ekleme
	@FXML
	private void EkleButon() throws IOException {
		
		if(adminRadioButton.isSelected()) {
			sınıfString="Admin";
		}
		else if(userButton.isSelected()){
			sınıfString="User";
		}
		else {
			sınıfString="User";
		}
		kullanıcılar.KullanıcıEkle(isimField.getText(), numaraField.getText(), sifreField.getText(), mailField.getText(), sınıfString);
		kullanıcılar.DosyaYazma();
	}
	
	
	//giriş textfield'leri temizleme 
	@FXML
	private void temizleButon() {
		isimField.clear();
		numaraField.clear();
		sifreField.clear();
		mailField.clear();
		adminRadioButton.setSelected(false);
		userButton.setSelected(false);
	}
	
	
	//seçilen kullanıcıları listeden kaldırma
	@FXML
	private void silButon(javafx.event.ActionEvent e) {
	    kullanıcılar.arr.remove(kullanıcılarListView.getSelectionModel().getSelectedIndex());
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
				
		//sistem tarihini string olarak ekleme
		Date date = new Date();
	    DateFormat df = DateFormat.getDateInstance();
	    String strDate = df.format(date);
	    tarihgLabel.setText(strDate);
		kullanıcılar.DosyaOkuma();
		
		//kullanıcıları list view e eklemek
		kullanıcılarListView.setItems(kullanıcılar.arr);
		
		
		gisimLabel.setText(kullanıcılar.arr.get(kullanıcılar.dogruKullancıİndex).getIsim());
		gnumaraLabel.setText(kullanıcılar.arr.get(kullanıcılar.dogruKullancıİndex).getNumara());
		
		
	}
		
}
