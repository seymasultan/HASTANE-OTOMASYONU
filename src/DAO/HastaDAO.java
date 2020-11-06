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
	
	List<String> randevuG�r�nt�le(Hasta hasta);
	
	void sifreAl(String ad�, String soyad�, String tc_kimlik,String parola, String kangrubu);
	
	boolean randevuAl(String dok_ad�,String hasta_ad�,String tarih,String saat);
	
}
