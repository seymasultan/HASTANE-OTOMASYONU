package DAOImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import DAO.HastaDAO;
import Otomasyon.Baglanti;
import Otomasyon.Hasta;
import Otomasyon.RandevuEkran�;

public class HastaDAOImp implements HastaDAO {

	@Override
	public Hasta girisYap(String tc_kimlik, String parola) {
		
		Connection con=null;
		
	     
	     try {
	    	 con = Baglanti.getConnection();
	     }
	     catch (Exception e) {
	    	 e.printStackTrace();  	 
	     }
		
		PreparedStatement preparedStatement=null;
		Statement statement=null;
	     
	     String sorgu="Select*From hastalar where tc_kimlik=? and parola=?"; //veritaban�nda girilen kimlik ve parola var m�?
	        try {
	            preparedStatement=(PreparedStatement) con.prepareStatement(sorgu);
				preparedStatement.setString(1,tc_kimlik);
	            preparedStatement.setString(2,parola);
	            
	            
	            ResultSet rs=preparedStatement.executeQuery();
	            
	          
	            while(rs.next()) {
	            	String sorgu2="Select*From hastalar where tc_kimlik=?";  //girilen tc_kimlik ile kimli�i ayn� olan hastay� buluruz.
	            	preparedStatement=(PreparedStatement) con.prepareStatement(sorgu2);
					preparedStatement.setString(1,tc_kimlik);

		            
		            
		            rs=preparedStatement.executeQuery();
		            while(rs.next()) {  //veritaban�ndaki tablo �zerinde gezilir.
	            	
	 	            long id=rs.getLong("id");
	 	            String isim = rs.getString("ad");
	 	            String soyisim=rs.getString("soyad"); //hastan�n bilgileri al�n�r
	 	            long kimlik=rs.getLong("tc_kimlik");
	 	            String kan_grubu=rs.getString("kan_grubu");
	 	         
	 	            
	 	            Hasta hasta = new Hasta(id,isim,soyisim,kimlik,kan_grubu);
	 	            return hasta;             //randevu ekran�nda hastan�n bilgilerini tutmak i�in hasta d�nd�r�l�r
		            }
	 	            
	 	            
	            }
	        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
			
		return null;
	}
	
	public void sifreAl(String ad�, String soyad�, String tc_kimlik,String parola, String kangrubu){
		
		Connection con=null;
		
	     
	     try {
	    	 con = Baglanti.getConnection();
	     }
	     catch (Exception e) {
	    	 e.printStackTrace();  	 
	     }
		
		PreparedStatement preparedStatement=null;
		
	      String sorgu="Insert Into hastalar(ad,soyad,tc_kimlik,kan_grubu,parola) VALUES(?,?,?,?,?)";
	                      //yeni kay�t olan hastan�n bilgileri veritaban�na eklenir.
	        try {
	            preparedStatement=(PreparedStatement) con.prepareStatement(sorgu);
	            
	            preparedStatement.setString(1,ad�);
	            preparedStatement.setString(2,soyad�);    
	            preparedStatement.setString(3,tc_kimlik);
	            preparedStatement.setString(4,kangrubu);
	            preparedStatement.setString(5,parola);
	            
	            
	            
	            preparedStatement.executeUpdate();
	           
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	

	@Override
	public boolean randevuAl(String dok_ad�, String hasta_ad�, String tarih, String saat) {
		 Connection con=null;
		
	     
	     try {
	    	 con = Baglanti.getConnection();
	     }
	     catch (Exception e) {
	    	 e.printStackTrace();  	 
	     }
		
		PreparedStatement preparedStatement=null;
		
		String sorgu="SELECT*From randevular Where tarih=? AND saat=?"; //se�ilen tarih ve saatte kay�tl� randevu var m�?
		 try {
	            preparedStatement=(PreparedStatement) con.prepareStatement(sorgu);
				preparedStatement.setString(1,tarih);
	            preparedStatement.setString(2,saat);
	            
	            
	            ResultSet rs=preparedStatement.executeQuery();
	            
	           
	            while(!rs.next()) {  //randevu yoksa 
	            	
	            	String sorgu2="Insert Into randevular(hst_ad,dok_ad,tarih,saat) VALUES(?,?,?,?)"; 
	            	                //yeni randevuyu veritaban�na ekler.
	            	preparedStatement=(PreparedStatement) con.prepareStatement(sorgu2);
					preparedStatement.setString(1,hasta_ad�);
					preparedStatement.setString(2,dok_ad�);
					preparedStatement.setString(3,tarih);
					preparedStatement.setString(4,saat);

		            
					preparedStatement.executeUpdate();
			           
		            
		            return true;
		            
		            }
	 	            
	 	            
	            }
	       catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		
		return false;  //randevu varsa false d�ner ve  hasta o tarihe randevu alamaz
	}

	@Override
	public List<Hasta> hstListele() {
        Connection con=null;
		List<Hasta> hastalar = new ArrayList<>();
	     
	     try {
	    	 con = Baglanti.getConnection();
	     }
	     catch (Exception e) {
	    	 e.printStackTrace();  	 
	     }
		
		PreparedStatement preparedStatement=null;
		String sorgu="SELECT*From hastalar";
		 try {
	            preparedStatement=(PreparedStatement) con.prepareStatement(sorgu);
	            ResultSet rs=preparedStatement.executeQuery();
	            
	   
	            while(rs.next()) {
	            	    
		 	            String isim = rs.getString("ad");
		 	            String soyisim=rs.getString("soyad");
		 	            long kimlik=rs.getLong("tc_kimlik");
		 	            String kan_grubu=rs.getString("kan_grubu");
		 	            String parola=rs.getString("parola");
		 	           
		 	            
		 	            Hasta hasta = new Hasta(isim,soyisim,kimlik,kan_grubu,parola);
		 	            hastalar.add(hasta);  //hastalar bilgileri ile hasta listesine eklenir.
		            }
	 	         return hastalar;   
	            }
	       catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		
		
		return null;
	}

	@Override
	public void hastaEkle(Hasta hasta) {
		Connection con=null;
		
	     
	     try {
	    	 con = Baglanti.getConnection();
	     }
	     catch (Exception e) {
	    	 e.printStackTrace();  	 
	     }
		
		PreparedStatement preparedStatement=null;
		
	      String sorgu="Insert Into hastalar(ad,soyad,tc_kimlik,kan_grubu,parola) VALUES(?,?,?,?,?)";
	              
	        try {
	            preparedStatement=(PreparedStatement) con.prepareStatement(sorgu);
	            
	            preparedStatement.setString(1,hasta.getAd());
	            preparedStatement.setString(2,hasta.getSoyad());
	            preparedStatement.setString(3,""+hasta.getTc_kimlik());
	            preparedStatement.setString(4,hasta.getKan_grubu());
	            preparedStatement.setString(5,hasta.getParola());
	            
	            
	            
	            preparedStatement.executeUpdate();
	           
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	}

	@Override
	public void hastaSil(Hasta hasta) { 
		Connection con=null;
		
	     
	     try {
	    	 con = Baglanti.getConnection();
	     }
	     catch (Exception e) {
	    	 e.printStackTrace();  	 
	     }
		
		PreparedStatement preparedStatement=null;
		
	      String sorgu="DELETE FROM hastalar WHERE tc_kimlik=?";  //Sekreterin se�ti�i kimlik numaral� hasta veritaban�ndan silinir.
	              
	        try {
	            preparedStatement=(PreparedStatement) con.prepareStatement(sorgu);
	            
	            preparedStatement.setString(1,""+hasta.getTc_kimlik()); 
	          
	            
	            preparedStatement.executeUpdate();
	           
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        String sorgu2="DELETE FROM randevular WHERE hst_ad=?";  //silinen hastan�n veritaban�ndaki randevular�da silinir.
            
	        try {
	            preparedStatement=(PreparedStatement) con.prepareStatement(sorgu2);
	            
	            preparedStatement.setString(1,hasta.getAd()+" "+hasta.getSoyad()); 
	          
	            
	            preparedStatement.executeUpdate();
	           
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	}

	@Override
	public void hstGuncelle(Hasta hasta,long kimlik) {
		Connection con=null;
		
	     
	     try {
	    	 con = Baglanti.getConnection();
	     }
	     catch (Exception e) {
	    	 e.printStackTrace();  	 
	     }
		
		PreparedStatement preparedStatement=null;
		
	      String sorgu="UPDATE hastalar SET ad=?,soyad=?,kan_grubu=?,parola=? WHERE tc_kimlik=?";
	              //kimlik numaras�na g�re se�ilen hastan�n de�i�en bilgileri varsa veritaban�nda da de�i�tirilir.
	        try {
	            preparedStatement=(PreparedStatement) con.prepareStatement(sorgu);
	            
	            preparedStatement.setString(1,hasta.getAd());
	            preparedStatement.setString(2,hasta.getSoyad());
	            preparedStatement.setLong(5,kimlik);
	            preparedStatement.setString(3,hasta.getKan_grubu());
	            preparedStatement.setString(4,hasta.getParola());
	            
	            
	            
	            preparedStatement.executeUpdate();
	           
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
		
	}

	@Override
	public List<String> randevuG�r�nt�le(Hasta hasta) {
		Connection con=null;
		List<String> randevular = new ArrayList<>();
	     
	     try {
	    	 con = Baglanti.getConnection();
	     }
	     catch (Exception e) {
	    	 e.printStackTrace();  	 
	     }
		
		PreparedStatement preparedStatement=null;
		
	      String sorgu="SELECT dok_ad,tarih,saat From randevular WHERE hst_ad=?";
	              
	        try {
	            preparedStatement=(PreparedStatement) con.prepareStatement(sorgu);
	            
	            preparedStatement.setString(1,hasta.getAd()+" "+hasta.getSoyad());
	            
	            
	             ResultSet rs = preparedStatement.executeQuery();
	             
	            
	            while(rs.next()) {
	            	randevular.add(rs.getString("dok_ad")+"-->"+rs.getString("tarih")+"-->"+rs.getString("saat"));
	            	//se�ilen hastan�n randevu bilgileri randevu listesine eklenir.
	            }
	           return randevular;
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
		return null;
	}

	@Override
	public Hasta hastaAra(String kimlik) {
		Connection con=null;
		
	     
	     try {
	    	 con = Baglanti.getConnection();
	     }
	     catch (Exception e) {
	    	 e.printStackTrace();  	 
	     }
		
		PreparedStatement preparedStatement=null;
		String sorgu="SELECT*From hastalar WHERE tc_kimlik=? "; 
		 try {
	            preparedStatement=(PreparedStatement) con.prepareStatement(sorgu);
	            preparedStatement.setString(1,kimlik);
	            ResultSet rs=preparedStatement.executeQuery();
	            
	   
	            while(rs.next()) {
	            	       //girilen kimlik numaral� hastan�n bilgileri ekrana getirilir.
		 	            String isim = rs.getString("ad");
		 	            String soyisim=rs.getString("soyad");  
		 	            String kan_grubu=rs.getString("kan_grubu");
		 	            String parola=rs.getString("parola");
		 	           
		 	            
		 	            Hasta hasta = new Hasta(isim,soyisim,Long.parseLong(kimlik),kan_grubu,parola);
		 	            return hasta;
		            }
	 	            
	            }
	       catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		
		
		return null;
	}

}
