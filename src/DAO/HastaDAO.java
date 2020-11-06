package DAO;

import java.util.List;
import Otomasyon.Hasta;

public interface HastaDAO {	
	
	Hasta girisYap(String tc_kimlik,String parola);
	
	List<Hasta> hstListele();
	
	void hastaEkle(Hasta hasta);
	
	void hastaSil(Hasta hasta); 
	
	Hasta hastaAra(String kimlik);
	
	void hstGuncelle(Hasta hasta,long kimlik); 
	
	List<String> randevuGörüntüle(Hasta hasta);
	
	void sifreAl(String adý, String soyadý, String tc_kimlik,String parola, String kangrubu);
	
	boolean randevuAl(String dok_adý,String hasta_adý,String tarih,String saat);
	
}
