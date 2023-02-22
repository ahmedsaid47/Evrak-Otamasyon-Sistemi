package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kullanıcılar implements DosyaIslem{
	
	//kullanıcı sın9fından obserable list oluşturuldu
	public ObservableList<Kullanıcı> arr= FXCollections.observableArrayList();
	
	
	public int dogruKullancıİndex;
	

	//Bu metot kullanıcı sınıfıdan nesne oluşturur bunu arrayliste ekler
	public void KullanıcıEkle(String isim, String numara, String sifre, String mail, String sınıf) {
		Kullanıcı kullanıcı=new Kullanıcı(isim, numara, sifre, mail, sınıf);
		arr.add(kullanıcı);
	
	}
	
	//giriş için şifre ve mail kontrolu yapar
	public boolean DogruKullanici(String mail, String sifre) throws IOException {
		DosyaOkuma();
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i).getMail().equals(mail) && arr.get(i).getSifre().equals(sifre) ) {
				dogruKullancıİndex=i;
				return true;
		      }
	     }
		return false;
	}
	
	
	//verileri dosyadan alma
	@Override
	public void DosyaOkuma() {
		try {		
			File dosyaFile =new File("C:\\Users\\said\\Desktop\\GirisEkranı\\src\\Model\\Kullanıcılar.txt");
			Scanner oku = new Scanner(dosyaFile);
			while(oku.hasNextLine()) {
				String string=oku.nextLine();
				String[] satır = string.split("\\*");
				KullanıcıEkle(satır[0], satır[1], satır[2], satır[3], satır[4]);
				
			}
			oku.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//array listte herhangi bir işlem yapılırsa verileri kaydetmede kullanılır
	@Override
	public void DosyaYazma() {
		try {
			File dosya = new File("C:\\Users\\said\\Desktop\\GirisEkranı\\src\\Model\\Kullanıcılar.txt");
			FileWriter yazici = new FileWriter("C:\\Users\\said\\Desktop\\GirisEkranı\\src\\Model\\Kullanıcılar.txt");
			if(!dosya.exists()) {
				dosya.createNewFile();
			}
			for(int i=0;i<arr.size();i++) {
				yazici.write(arr.get(i).getIsim()+"*"+arr.get(i).getNumara()+"*"+arr.get(i).getSifre()+"*"+arr.get(i).getMail()+"*"+arr.get(i).getSınıf()+"\n");
				
		     }
			yazici.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
}
