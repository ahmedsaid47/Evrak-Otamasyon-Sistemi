package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.Initializable;
public class SampleController implements Initializable{
	@FXML
	private ImageView myImageView;
	@FXML
	private Button girisYapButton;
	@FXML
	private TextField mailField;
	@FXML
	private TextField sifreField;
	@FXML
	private Label girisLabel;
	@FXML
	private Button kaydolButton;
	@FXML
	private Label tarihgLabel;
	Scene scene;
    Stage stage;
	BorderPane borderPane;
	
	
    //eğer giriş yanlışsa imageviewe atanan resim çıkar
	File file = new File("C:\\Users\\said\\Desktop\\GirisEkranı\\resim\\unlem.png");
    Image image = new Image(file.toURI().toString());
    ImageView imageView= new ImageView(image);
    
    Kullanıcılar kullanıcılar=new Kullanıcılar();
    Evraklar evraklar = new Evraklar();
    
   
    
    
    //sistemde olmayan kullanıcı kaydı alma
    @FXML
    private void kayıtButon(ActionEvent event) {
    	
		try {
			
			Stage stage = new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Child3.fxml"));
			stage.setScene(new Scene(root));
			stage.initModality(Modality.WINDOW_MODAL);
		    stage.initOwner(((Node)event.getSource()).getScene().getWindow() );
		    stage.show();
		    
		} catch (IOException e) {
			e.printStackTrace();
		}    	
    }

	@FXML
	private void butonKod(ActionEvent event) throws IOException {
		//kullanıcı doğrulaması
		if(kullanıcılar.DogruKullanici(mailField.getText(), sifreField.getText())) {
			
			girisLabel.setText("Giriş Yapıldı");
			
			//ikinci ekran başlatılır
			try {
				Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("Child.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
				stage.setWidth(947.0);
				stage.setHeight(595.0);
				borderPane = Main.getBorderPane();
				borderPane.setCenter(root);
			} catch(Exception e) {
				System.out.println("****************9)9999***********");
		      }
			
	    }
		else {
			myImageView.setImage(image);
		    girisLabel.setText("Hatalı Giriş");
		}	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		kullanıcılar.DosyaOkuma();
		
	}

}
