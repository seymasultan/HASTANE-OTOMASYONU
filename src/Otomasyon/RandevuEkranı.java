package Otomasyon;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import DAOImp.DoktorDAOImp;
import DAOImp.HastaDAOImp;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class RandevuEkraný extends JFrame {

	private JPanel contentPane;
	private List<String> poliklinikler;
	private List<String> doktorlar;

	
	public RandevuEkraný(Hasta hasta) {
		setTitle("Randevu Ekran\u0131");
		setBounds(100, 100,650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UtilDateModel model = new UtilDateModel();
		Calendar cal = Calendar.getInstance();
		model.setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
		model.setSelected(true);
		JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(125, 261, 180, 29);
		datePicker.getJFormattedTextField().setBounds(0, 0, 152, 149);
		getContentPane().add(datePicker);
		
		DoktorDAOImp imp = new DoktorDAOImp();
		
		JComboBox doktor_ekraný = new JComboBox();
		doktor_ekraný.setBounds(433, 200, 178, 20);
		contentPane.add(doktor_ekraný);
		
		JComboBox poliklinik_ekraný = new JComboBox();
		poliklinik_ekraný.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				doktor_ekraný.removeAllItems();
		        String bolum = poliklinik_ekraný.getSelectedItem().toString();
		        String sorgu = "SELECT adý,soyadý FROM doktorlar,bolum WHERE doktorlar.bolum_id=bolum.id AND bolum_adý='" + bolum +"'";
		        doktorlar=imp.doktorlarýCek(sorgu);
		        for(int i=0;i<doktorlar.size();i++)
		        	doktor_ekraný.addItem(doktorlar.get(i));  //doktor listesinden dönen sonuçlar doktor ekranýna eklenir.
			}
		});
		
		poliklinik_ekraný.setBounds(125, 200, 178, 20);
		contentPane.add(poliklinik_ekraný);
		
		
		JLabel lblPoliklinikAd = new JLabel("Poliklinik Ad\u0131:");
		lblPoliklinikAd.setBounds(37, 203, 72, 14);
		contentPane.add(lblPoliklinikAd);
		
		JLabel lblDoktorAd = new JLabel("Doktor Ad\u0131:");
		lblDoktorAd.setBounds(351, 203, 72, 14);
		contentPane.add(lblDoktorAd);
		
		JLabel lblTarih = new JLabel("Tarih:");
		lblTarih.setBounds(37, 261, 72, 29);
		contentPane.add(lblTarih);
		
		JComboBox saat_ekraný = new JComboBox();
		saat_ekraný.setBounds(433, 261, 105, 20);
		contentPane.add(saat_ekraný);
		
		for(int i=8;i<18;i++) {
			for(int j=0;j<46;j+=15) {
				String saat = (i < 10 ? "0" : "") + i + ":" + (j < 10 ? "0" : "") + j;
				saat_ekraný.addItem(saat);
			}
		}
		
		JLabel lblSaat = new JLabel("Saat:");
		lblSaat.setBounds(352, 261, 46, 14);
		contentPane.add(lblSaat);
		
		JButton btnRandevuAl = new JButton("RANDEVU AL");
		btnRandevuAl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				HastaDAOImp imp = new HastaDAOImp();
				String dok_adý = doktor_ekraný.getSelectedItem().toString();
				String hasta_adý= hasta.isimSoyisim();
				Calendar cal = Calendar.getInstance();
				cal.setTime((Date) datePicker.getModel().getValue());
				String tarih = cal.get(Calendar.YEAR) +"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH);
				String saat = saat_ekraný.getSelectedItem().toString();		
				System.out.println(tarih+ "     "+saat);
				
				boolean bosMu =  imp.randevuAl(dok_adý, hasta_adý, tarih, saat);
				if(bosMu) 
					JOptionPane.showMessageDialog(null, "Randevu Alýndý.");				
				else
					JOptionPane.showMessageDialog(null, "Seçtiðiniz zaman aralýðý dolu.");
			}
		});
		btnRandevuAl.setBounds(247, 316, 137, 23);
		contentPane.add(btnRandevuAl);
		
		JLabel hst_adý_ekraný = new JLabel("Hoþgeldiniz " + hasta.isimSoyisim());
		hst_adý_ekraný.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		hst_adý_ekraný.setBounds(37, 11, 263, 35);
		contentPane.add(hst_adý_ekraný);
		
		ImageIcon pp = new ImageIcon("back.jpg");
		JLabel label = new JLabel(pp);
		label.setBounds(0, 0, 650, 400);
		contentPane.add(label);
		
		
		poliklinikler = imp.poliklinikleriCek();
		for(int i=0; i<poliklinikler.size(); i++)
			poliklinik_ekraný.addItem(poliklinikler.get(i)); //poliklinik listesinden dönen sonuçlar poliklinik ekranýna eklenir.
		
		setLocationRelativeTo(null);
		
		
	}
}
