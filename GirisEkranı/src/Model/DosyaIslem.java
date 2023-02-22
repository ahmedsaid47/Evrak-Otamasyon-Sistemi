package Model;

import java.io.IOException;

public interface DosyaIslem {
	
	//kayıtlı verileri içe aktarma
	public void DosyaOkuma() throws IOException;
	//verileri dışa aktarıp kaydetme
	public void DosyaYazma() throws IOException;
	

}
