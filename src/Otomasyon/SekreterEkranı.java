package Otomasyon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAOImp.HastaDAOImp;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class SekreterEkraný extends JFrame {

	private JPanel contentPane;
	private JTextField hstad_ekraný;
	private JTextField hstsoyad_ekraný;
	private JTextField tc_ekraný;
	private JTextField kan_ekraný;
	JList<Hasta> hastaListesi;
	JList<String> randevuListesi;
	private JPasswordField parola_ekraný;
	private JTextField arama_ekraný;

	
	public SekreterEkraný() {
		setTitle("SEKRETER EKRANI");
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 29, 257, 197);
		contentPane.add(scrollPane);
		
		hastaListesi = new JList();
		scrollPane.setViewportView(hastaListesi);
		hastaListesi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				HastaDAOImp imp =new HastaDAOImp();
				Hasta hasta = (Hasta) hastaListesi.getSelectedValue();
				hstad_ekraný.setText(hasta.getAd());
				hstsoyad_ekraný.setText(hasta.getSoyad());
				tc_ekraný.setText(""+hasta.getTc_kimlik());
				kan_ekraný.setText(hasta.getKan_grubu());
				parola_ekraný.setText(hasta.getParola());
				randevuGüncelle(imp.randevuGörüntüle(hasta));
				
			}
		});
		HastaDAOImp imp =new HastaDAOImp();
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 260, 257, 90);
		contentPane.add(scrollPane_1);
		
		randevuListesi = new JList();
		scrollPane_1.setViewportView(randevuListesi);
		
		JLabel lblNewLabel = new JLabel("Ad\u0131 :");
		lblNewLabel.setBounds(368, 56, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Soyad\u0131:");
		lblNewLabel_1.setBounds(368, 81, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TC Kimlik:");
		lblNewLabel_2.setBounds(368, 106, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Kan Grubu");
		lblNewLabel_3.setBounds(368, 131, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		hstad_ekraný = new JTextField();
		hstad_ekraný.setBounds(464, 50, 119, 20);
		contentPane.add(hstad_ekraný);
		hstad_ekraný.setColumns(10);
		
		hstsoyad_ekraný = new JTextField();
		hstsoyad_ekraný.setBounds(464, 75, 119, 20);
		contentPane.add(hstsoyad_ekraný);
		hstsoyad_ekraný.setColumns(10);
		
		tc_ekraný = new JTextField();
		tc_ekraný.setBounds(464, 100, 119, 20);
		contentPane.add(tc_ekraný);
		tc_ekraný.setColumns(10);
		
		kan_ekraný = new JTextField();
		kan_ekraný.setBounds(464, 128, 119, 20);
		contentPane.add(kan_ekraný);
		kan_ekraný.setColumns(10);
		listeyiGüncelle(imp.hstListele());
		
		JButton btnHastaEkle = new JButton("HASTA EKLE");
		btnHastaEkle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				HastaDAOImp imp = new HastaDAOImp();
				long kimlik= Long.parseLong(tc_ekraný.getText());
			       
		        String adý = hstad_ekraný.getText();
		        String soyadý = hstsoyad_ekraný.getText();
		        String kangrubu = kan_ekraný.getText();
		        String parola=  String.valueOf( parola_ekraný.getPassword());
		        Hasta hasta =new Hasta(adý,soyadý,kimlik,kangrubu,parola);
		          
		        imp.hastaEkle(hasta);
		        listeyiGüncelle(imp.hstListele());
		        JOptionPane.showMessageDialog(null, "Hasta Eklendi.");
				
				
			}
		});
		btnHastaEkle.setBounds(312, 327, 142, 23);
		contentPane.add(btnHastaEkle);
		
		JButton btnHastaSil = new JButton("HASTA S\u0130L");
		btnHastaSil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			  HastaDAOImp imp = new HastaDAOImp();
			  Hasta hasta = (Hasta) hastaListesi.getSelectedValue();
		       
		      imp.hastaSil(hasta);
		      listeyiGüncelle(imp.hstListele());
		      JOptionPane.showMessageDialog(null, "Hasta Silindi.");
		      List<String> list = new ArrayList<>();
		      randevuGüncelle(list);
				
			}
		});
		btnHastaSil.setBounds(464, 327, 149, 23);
		contentPane.add(btnHastaSil);
		
		JButton btnHastaGncelle = new JButton("HASTA B\u0130LG\u0130S\u0130 G\u00DCNCELLE");
		btnHastaGncelle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				HastaDAOImp imp = new HastaDAOImp();
				
				long kimlik= Long.parseLong(tc_ekraný.getText());
		        String adý = hstad_ekraný.getText();
		        String soyadý = hstsoyad_ekraný.getText();
		        String kangrubu = kan_ekraný.getText();
		        String parola=  String.valueOf( parola_ekraný.getPassword());
		        Hasta hasta =new Hasta(adý,soyadý,kimlik,kangrubu,parola);
		          
		        imp.hstGuncelle(hasta, kimlik);
		        listeyiGüncelle(imp.hstListele());
		        JOptionPane.showMessageDialog(null, "Hasta Bilgisi Güncellendi.");
			}
		});
		btnHastaGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnHastaGncelle.setBounds(368, 285, 179, 23);
		contentPane.add(btnHastaGncelle);
		
		JLabel lblParola = new JLabel("Parola:");
		lblParola.setBounds(368, 156, 75, 14);
		contentPane.add(lblParola);
		
		parola_ekraný = new JPasswordField();
		parola_ekraný.setBounds(464, 153, 119, 20);
		contentPane.add(parola_ekraný);
		
		arama_ekraný = new JTextField();
		arama_ekraný.setBounds(368, 232, 86, 20);
		contentPane.add(arama_ekraný);
		arama_ekraný.setColumns(10);
		
		JButton btnAra = new JButton("ARA");
	
		btnAra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				HastaDAOImp imp = new HastaDAOImp();
				String kimlik = arama_ekraný.getText();
				Hasta hasta = imp.hastaAra(kimlik);
				if(hasta!=null) {
					hstad_ekraný.setText(hasta.getAd());
					hstsoyad_ekraný.setText(hasta.getSoyad());
					tc_ekraný.setText(""+hasta.getTc_kimlik());
					kan_ekraný.setText(hasta.getKan_grubu());
					parola_ekraný.setText(hasta.getParola());
					randevuGüncelle(imp.randevuGörüntüle(hasta));
				}
				else {
					JOptionPane.showMessageDialog(null, "Hasta Bulunamadý.");
				}
				
			}
		});
		btnAra.setBounds(475, 231, 89, 23);
		contentPane.add(btnAra);
		
		JLabel lblHastaListesi = new JLabel("HASTA L\u0130STES\u0130");
		lblHastaListesi.setBounds(22, 4, 257, 14);
		contentPane.add(lblHastaListesi);
		
		JLabel lblRandevuListesi = new JLabel("RANDEVU L\u0130STES\u0130");
		lblRandevuListesi.setBounds(22, 235, 257, 14);
		contentPane.add(lblRandevuListesi);
		ImageIcon pp = new ImageIcon("back.jpg");
		JLabel label = new JLabel(pp);
		label.setBounds(0, 0, 650, 400);
		contentPane.add(label);
		
		setLocationRelativeTo(null);
		
	}
	
	
	private void listeyiGüncelle(List<Hasta> liste) { 
		DefaultListModel<Hasta> listModel = new DefaultListModel<Hasta>() {

			private static final long serialVersionUID = -5820179847193350577L;

			public int getSize() {
				return liste.size();
			}                            //bu fonksiyon her çaðrýldýðýnda hasta listesi güncellenir.

			public Hasta getElementAt(int i) {
				return liste.get(i);
			}
		};
		hastaListesi.setModel(listModel);
	}
	private void randevuGüncelle(List<String> liste) { 
		DefaultListModel<String> listModel = new DefaultListModel<String>() {
			private static final long serialVersionUID = 6034188603117271249L;

			public int getSize() {
				return liste.size();
			}                       //bu fonksiyon her çaðrýldýðýnda randevu listesi güncellenir.

			public String getElementAt(int i) {
				return liste.get(i);
			}
		};
		randevuListesi.setModel(listModel);
	}
}
