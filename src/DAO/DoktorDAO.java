package DAO;

import java.util.List;

import Otomasyon.Doktor;


public interface DoktorDAO {
          
	List<String> doktorlar�Cek(String sorgu);
	
	List<String> poliklinikleriCek();
}
