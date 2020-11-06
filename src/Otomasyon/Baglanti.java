package Otomasyon;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Baglanti {
         
	public static Connection getConnection() {
		Connection connection=null;
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection=  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hastane_otomasyonu?useUnicode=true&characterEncoding=utf8","root","");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
