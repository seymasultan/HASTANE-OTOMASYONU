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
	public List<String> doktorlarýCek(String sorgu) {
		
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
                
            	
                String isim=rs.getString("adý");       
                String soyisim = rs.getString("soyadý");
                doktor.add(isim+ " "+soyisim);             //veritabanýndaki doktorun adý,soyadý listeye eklenir.
                
                  
             }
             
         } catch (SQLException ex) {
             ex.printStackTrace();
       
         }
		
		return doktor;
	}

	public List<String> poliklinikleriCek() {
		
		Connection con=null;
		List<String> poliklinikler = new ArrayList<>();
		String sorgu="SELECT bolum_adý FROM bolum ";
	     
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
                
                String isim=rs.getString("bolum_adý");
                poliklinikler.add(isim); //veritabanýndaki poliklinikler listeye eklenir.
                
             }
             
         } catch (SQLException ex) {
             ex.printStackTrace();
       
         }
		
		return poliklinikler;
		
		
	}
               
}
