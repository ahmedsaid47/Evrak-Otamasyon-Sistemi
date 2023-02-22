package Model;

public class Evrak {
	public String numara;
	public String ad;
	public String tur;
	public String tarih;
	public String sahip;
	public String kategori;
	public String açıklama;
	public String adres;
	
	public Evrak(String numara, String ad, String tur, String tarih, String sahip, String kategori, String açıklama,String adres) {
		this.numara = numara;
		this.ad = ad;
		this.tur = tur;
		this.tarih = tarih;
		this.sahip = sahip;
		this.kategori = kategori;
		this.açıklama = açıklama;
		this.adres=adres;
	}
	public String getNumara() {
		return numara;
	}
	public String getAd() {
		return ad;
	}
	public String getTur() {
		return tur;
	}
	public String getTarih() {
		return tarih;
	}
	
	public String getSahip() {
		return sahip;
	}
	public String getKategori() {
		return kategori;
	}
	public String getAciklama() {
		return açıklama;
	}
	public String getAdres() {
		return adres;
	}
	
	
	public void setNumara(String numara) {
		this.numara = numara;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public void setTur(String tur) {
		this.tur = tur;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public void setSahip(String sahip) {
		this.sahip = sahip;
	}
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	public void setAciklama(String açıklama) {
		this.açıklama = açıklama;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	@Override
	public String toString() {
		return ad+"       "+sahip;
	}
	
	
	

}
