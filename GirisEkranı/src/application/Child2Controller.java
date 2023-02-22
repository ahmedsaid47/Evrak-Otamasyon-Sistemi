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
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Child2Controller extends Menu implements Initializable{
	    @FXML
	    private TextArea aciklama;
	    @FXML
	    private TextField tur;
	    @FXML
	    private TextField ad;
	    @FXML
	    private TextField kategori;
	    @FXML
	    private TextField numara;
	    @FXML
	    private TextField sahip;
	    @FXML
	    private TextField tarih;
	    @FXML 
	    private ListView<Evrak> evrakListView;
	    @FXML
	    private Button evrakSecButton;
	    @FXML
	    private FileChooser evrakSecChooser;
	    @FXML
	    private TextField adresField;
	    @FXML
	    private Label tarihgLabel;
	    @FXML
		private Label gisimLabel;
		@FXML
		private Label gnumaraLabel;
	    Stage stage;
		Scene scene;
		BorderPane borderPane;
		
		Kullanıcılar kullanıcılar= new Kullanıcılar();
	    Evraklar evrak= new Evraklar();

		
		
		//****************************Menu**********************************
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
		//********************************************************************
		
		//giriş textfield'leri temizleme 
		@FXML
		private void temizleButon() {
			aciklama.clear();
			numara.clear();
			ad.clear();
			adresField.clear();
			tur.clear();
			sahip.clear();
			adresField.clear();
			kategori.clear();
			
		}

		
		
		//pc'den seçilecek dosyanın adresini tutar ve tutulan dosyanın adresi adresFielde yazılır.
		@FXML
	    public void SecButon(ActionEvent event) {
	    	
			Dialog<Object> dialog = new Dialog<Object>();

	    	FileChooser fileChooser = new FileChooser();
	    	fileChooser.setTitle("Dosya Seç");
	    	File selectedFile = fileChooser.showOpenDialog(dialog.getDialogPane().getScene().getWindow());
	    	if (selectedFile != null) {
	    	    String filePath = selectedFile.getAbsolutePath();  
	    	    adresField.setText(filePath);
	    	    String[] adreStrings= filePath.split("\\/");
	    	    //ad.setText(adreStrings[4]);
	    	    
	    	}
	    }
	   
	    
	    //evrak class ından evrakekle metotduna text labellere girilenler yazılır
	    @FXML
		private void EvrakEkleButon() throws IOException {
			evrak.EvrakEkle(numara.getText(), ad.getText(), tur.getText(), tarih.getText(), sahip.getText(), kategori.getText(), aciklama.getText(), adresField.getText());
			evrak.DosyaYazma();
	    }
        @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
        	kullanıcılar.DosyaOkuma();
        	//tarih
        	Date date = new Date();
    	    DateFormat df = DateFormat.getDateInstance();
    	    String strDate = df.format(date);
    	    tarihgLabel.setText(strDate);
    	    tarih.setText(strDate);
        	try {
				evrak.DosyaOkuma();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	
        	//evrak list viewe evraklrı gönderiyoruz
			evrakListView.setItems(evrak.evraks);
			
			gisimLabel.setText(kullanıcılar.arr.get(kullanıcılar.dogruKullancıİndex).getIsim());
			gnumaraLabel.setText(kullanıcılar.arr.get(kullanıcılar.dogruKullancıİndex).getNumara());
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
