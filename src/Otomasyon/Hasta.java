package Otomasyon;

public class Hasta {
	
	private long id;
	private String ad;
	private String soyad;
	private final long tc_kimlik;
	private String kan_grubu;
	private String parola;
	
	public Hasta(long id,String ad,String soyad,long tc_kimlik,String kan_grubu) {
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.tc_kimlik = tc_kimlik;
		this.kan_grubu = kan_grubu;
	}
	
	public Hasta(String ad,String soyad,long tc_kimlik,String kan_grubu,String parola) {
		
		this.ad = ad;
		this.soyad = soyad;
		this.tc_kimlik = tc_kimlik;
		this.kan_grubu = kan_grubu;
		this.parola=parola;
	}
	
	public String isimSoyisim() {
		return ad+" "+soyad;
	}
	
	public String getAd() {
		return ad;
	}
	
	public long getId() {
		return id;
	}
	public String getKan_grubu() {
		return kan_grubu;
	}
	public String getSoyad() {
		return soyad;
	}
	public long getTc_kimlik() {
		return tc_kimlik;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}

	public void setKan_grubu(String kan_grubu) {
		this.kan_grubu = kan_grubu;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	
	@Override
	public String toString() {	
		return ad +" "+soyad + "-->TC: " + tc_kimlik+ "-->KG:" +kan_grubu;
	}

}
