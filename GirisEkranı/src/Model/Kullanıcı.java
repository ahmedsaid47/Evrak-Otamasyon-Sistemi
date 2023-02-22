package Model;

public class Kullanıcı {
	private String isim;
	private String numara;
	private String sifre;
	private String mail;
	private String sınıf;
	
	//constrauctor
	public Kullanıcı(String isim, String numara, String sifre, String mail, String sınıf) {
		this.isim = isim;
		this.numara = numara;
		this.sifre = sifre;
		this.mail = mail;
		this.sınıf = sınıf;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getNumara() {
		return numara;
	}

	public void setNumara(String numara) {
		this.numara = numara;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSınıf() {
		return sınıf;
	}

	public void setSınıf(String sınıf) {
		this.sınıf = sınıf;
	}
	
	//listView için to String
	@Override
	public String toString() {
		return isim+" "+numara+"  "+mail+"  "+sınıf;
	}
	
	
	
	
	

	
	
}
