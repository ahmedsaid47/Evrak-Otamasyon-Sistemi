package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;

import java.util.Date;
import java.util.ResourceBundle;

import Model.Evrak;
import Model.Evraklar;
import Model.Kullanıcılar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ChildController extends Menu implements Initializable{
	@FXML
	private Button userAddButton;
	@FXML
	private Button silButton;
	@FXML
	private Button acButton;
	@FXML
	private Button evrakButton;
	@FXML
	private TableView<Evrak> tableView;
	@FXML
	private TableColumn<Evrak, String> numaraColumn;
	@FXML
	private TableColumn<Evrak, String> adColumn;
	@FXML
	private TableColumn<Evrak, String> turColumn;
	@FXML
	private TableColumn<Evrak, String> tarihColumn;
	@FXML
	private TableColumn<Evrak, String> sahipColumn;
	@FXML
	private TableColumn<Evrak, String> kategoriColumn;
	@FXML
	private TableColumn<Evrak, String> aciklamaColumn;
	@FXML
	private ImageView kullanıcImageView;
	@FXML
	private Label tarihgLabel;
	@FXML
	private Label gisimLabel;
	@FXML
	private Label gnumaraLabel;
	
	
	Stage stage;
	Scene scene;
	BorderPane borderPane;
	
	Evraklar evraklar= new Evraklar();
	Kullanıcılar kullanıcılar =new Kullanıcılar();
	
	
	//*******************************Menu*************************
	//menü astract class dan overidde edildi
	@Override
	public void anaEkran(ActionEvent event) throws IOException {
		super.anaEkran(event);
	}
	@Override
	public void girisEkran(ActionEvent event) throws IOException {
		super.girisEkran(event);
	}
	@Override
	public void useradd(ActionEvent event) {
		super.useradd(event);
	}
	@Override
	public void evrakekle(ActionEvent event) {
		super.evrakekle(event);
	}
	//****************************************************************
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Kullanıcılar kullanıcılar =new Kullanıcılar();
		kullanıcılar.DosyaOkuma();
		try {
			evraklar.DosyaOkuma();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Sistem tarihini string olarak alınır
		Date date = new Date();
	    DateFormat df = DateFormat.getDateInstance();
	    String strDate = df.format(date);
	    tarihgLabel.setText(strDate);
	    
		//tableView in sutunları oluşturuldu
		numaraColumn.setCellValueFactory(new PropertyValueFactory<Evrak,String>("numara"));
		adColumn.setCellValueFactory(new PropertyValueFactory<Evrak,String>("ad"));
		turColumn.setCellValueFactory(new PropertyValueFactory<Evrak,String>("tur"));
		tarihColumn.setCellValueFactory(new PropertyValueFactory<Evrak,String>("tarih"));
		sahipColumn.setCellValueFactory(new PropertyValueFactory<Evrak,String>("sahip"));
		kategoriColumn.setCellValueFactory(new PropertyValueFactory<Evrak,String>("kategori"));
		aciklamaColumn.setCellValueFactory(new PropertyValueFactory<Evrak,String>("aciklama"));
		
		//evrak obserablelist tableView e aktarılır.
		tableView.setItems(evraklar.evraks);
		
		//sistemdeki kullanıcının ismini görmek için
		gisimLabel.setText(kullanıcılar.arr.get(kullanıcılar.dogruKullancıİndex).getIsim());
		gnumaraLabel.setText(kullanıcılar.arr.get(kullanıcılar.dogruKullancıİndex).getNumara());

	}
	
	//seçilen dosyaları açmaya yarar
	@FXML
    private void AcButon(javafx.event.ActionEvent e) throws IOException {
		evraklar.DosyaAc(evraklar.evraks.get(tableView.getSelectionModel().getSelectedIndex()).adres);;
		
    }
	//seçilen dosyaları silmeye yarar
	@FXML
    private void SilButon(javafx.event.ActionEvent e) {
		//table view den seçilen dosyanın listeden kaldırılmasını sağlar
		evraklar.evraks.remove(tableView.getSelectionModel().getSelectedIndex());
		try {
			evraklar.DosyaYazma();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
}
	
	
	


