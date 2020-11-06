package DAOImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import DAO.DoktorDAO;
import Otomasyon.Baglanti;
import Otomasyon.Doktor;

public class DoktorDAOImp implements DoktorDAO {

	@Override
	public List<String> doktorlar�Cek(String sorgu) {
		
		List<String> doktor = new ArrayList<>();
		
		Connection con=null;
	     
	     try {
	    	 con = Baglanti.getConnection();
	     }
	     catch (Exception e) {
	    	 e.printStackTrace(); 
	    	 
	     }
	     
	     Statement statement=null;
	     
		 try {
             statement =(Statement) con.createStatement();
             
             ResultSet rs=statement.executeQuery(sorgu);
             
             while(rs.next()){
                
            	
                String isim=rs.getString("ad�");       
                String soyisim = rs.getString("soyad�");
                doktor.add(isim+ " "+soyisim);             //veritaban�ndaki doktorun ad�,soyad� listeye eklenir.
                
                  
             }
             
         } catch (SQLException ex) {
             ex.printStackTrace();
       
         }
		
		return doktor;
	}

	public List<String> poliklinikleriCek() {
		
		Connection con=null;
		List<String> poliklinikler = new ArrayList<>();
		String sorgu="SELECT bolum_ad� FROM bolum ";
	     
	     try {
	    	 con = Baglanti.getConnection();
	     }
	     catch (Exception e) {
	    	 e.printStackTrace(); 
	    	 
	     }
	     
	     Statement statement=null;
	     
		 try {
             statement =(Statement) con.createStatement();
             
             ResultSet rs=statement.executeQuery(sorgu);
             
             while(rs.next()){
                
                String isim=rs.getString("bolum_ad�");
                poliklinikler.add(isim); //veritaban�ndaki poliklinikler listeye eklenir.
                
             }
             
         } catch (SQLException ex) {
             ex.printStackTrace();
       
         }
		
		return poliklinikler;
		
		
	}
               
}
