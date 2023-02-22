package Model;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

public class Evraklar implements Initializable,DosyaIslem{
	
	// ObservableList ile ArrayList arasındaki en önemli fark ObservableList'in değişikliklerin izlenebilir olmasıdır
	public ObservableList<Evrak> evraks= FXCollections.observableArrayList();


	
	public ObservableList<Evrak> getEvraks() {
		return evraks;
	}

	public void setEvraks(ObservableList<Evrak> evraks) {
		this.evraks = evraks;
	}

	public void EvrakEkle(String numara,String ad, String tur,String tarih,String sahip,String kategori,String aciklama,String adres) {
		Evrak evrak = new Evrak(numara, ad, tur, tarih, sahip, kategori, aciklama, adres);
		evraks.add(evrak);
	}
	
    @Override
	public void DosyaOkuma() throws IOException {
		File dosyaFile =new File("C:\\Users\\said\\Desktop\\GirisEkranı\\src\\Model\\Evraklar.txt");
		Scanner oku = new Scanner(dosyaFile);
		while (oku.hasNextLine()) {
			String string=oku.nextLine();
			String[] satır = string.split("\\*");
			EvrakEkle(satır[0],satır[1],satır[2],satır[3],satır[4],satır[5],satır[6],satır[7]);
		} 
		
		oku.close();
	}
    
    @Override
	public void DosyaYazma() throws IOException {
		File dosya = new File("C:\\Users\\said\\Desktop\\GirisEkranı\\src\\Model\\Evraklar.txt");
		FileWriter yazici = new FileWriter(dosya);
		if(!dosya.exists()) {
			dosya.createNewFile();
		}
		for(int i=0;i<evraks.size();i++) {
			yazici.write(evraks.get(i).getNumara()+"*"+evraks.get(i).getAd()+"*"+evraks.get(i).getTur()+"*"+evraks.get(i).getTarih()+"*"+evraks.get(i).getSahip()+"*"+evraks.get(i).getKategori()+"*"+evraks.get(i).getAciklama()+"*"+evraks.get(i).getAdres()+"\n");

	     }
		yazici.close();
	}

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			DosyaOkuma();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//adresi bilinen dosya burdan açılır
	public void DosyaAc(String path) throws IOException {
	    Desktop desktop = Desktop.getDesktop();
    	desktop.open(new File(path));
	}


	
	
	

}
