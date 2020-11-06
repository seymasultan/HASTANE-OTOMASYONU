package DAO;

import java.util.List;

import Otomasyon.Doktor;


public interface DoktorDAO {
          
	List<String> doktorlarýCek(String sorgu);
	
	List<String> poliklinikleriCek();
}
