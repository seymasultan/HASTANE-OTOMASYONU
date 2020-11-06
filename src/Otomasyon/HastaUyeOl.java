package Otomasyon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAOImp.HastaDAOImp;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HastaUyeOl extends JFrame {

	private JPanel contentPane;
	private JTextField kimlik_ekraný;
	private JTextField parola_ekraný;
	private JTextField hst_syd_ekraný;
	private JTextField hst_adý_ekraný;
	private JTextField kangrubu_ekraný;

	public HastaUyeOl() {
		setTitle("\u00DCYEL\u0130K EKRANI");
	
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKullancAd = new JLabel("T.C. Kimlik :");
		lblKullancAd.setBounds(340, 220, 113, 26);
		contentPane.add(lblKullancAd);
		
		JLabel lblParola = new JLabel("Parola:");
		lblParola.setBounds(340, 257, 72, 26);
		contentPane.add(lblParola);
		
		kimlik_ekraný = new JTextField();
		kimlik_ekraný.setBounds(463, 223, 86, 20);
		contentPane.add(kimlik_ekraný);
		kimlik_ekraný.setColumns(10);
		
		parola_ekraný = new JTextField();
		parola_ekraný.setBounds(463, 260, 86, 20);
		contentPane.add(parola_ekraný);
		parola_ekraný.setColumns(10);
		
		JButton uye_ol_buton = new JButton("\u00DCYE OL");
		uye_ol_buton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				HastaDAOImp imp = new HastaDAOImp();
				String kimlik=kimlik_ekraný.getText();
		        String parola=parola_ekraný.getText();  //hasta bilgilerini girer
		        String adý = hst_adý_ekraný.getText();
		        String soyadý = hst_syd_ekraný.getText();
		        String kangrubu = kangrubu_ekraný.getText();
		        
		          
		        imp.sifreAl(adý,soyadý,kimlik,parola,kangrubu);  
		        
		      
				Hasta hasta = imp.girisYap(kimlik, parola);
				if(hasta!=null) {
					RandevuEkraný frame = new RandevuEkraný(hasta);
					frame.setVisible(true);
				}
				else
					System.out.print("GÝRÝS yapilamadý.");
				
				
			}
		});

		uye_ol_buton.setBounds(406, 294, 92, 23);
		contentPane.add(uye_ol_buton);
		
		hst_syd_ekraný = new JTextField();
		hst_syd_ekraný.setBounds(165, 252, 86, 20);
		contentPane.add(hst_syd_ekraný);
		hst_syd_ekraný.setColumns(10);
		
		hst_adý_ekraný = new JTextField();
		hst_adý_ekraný.setBounds(165, 223, 86, 20);
		contentPane.add(hst_adý_ekraný);
		hst_adý_ekraný.setColumns(10);
		
		JLabel lblAd = new JLabel("Ad\u0131 :");
		lblAd.setBounds(81, 226, 60, 14);
		contentPane.add(lblAd);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131 :");
		lblSoyad.setBounds(81, 255, 60, 14);
		contentPane.add(lblSoyad);
		
		kangrubu_ekraný = new JTextField();
		kangrubu_ekraný.setBounds(165, 283, 86, 20);
		contentPane.add(kangrubu_ekraný);
		kangrubu_ekraný.setColumns(10);
		
		JLabel lblKanGrubu = new JLabel("Kan Grubu :");
		lblKanGrubu.setBounds(81, 286, 74, 14);
		contentPane.add(lblKanGrubu);
		ImageIcon pp = new ImageIcon("back.jpg");
		JLabel label = new JLabel(pp);
		label.setBounds(10, 0, 650, 400);
		contentPane.add(label);
		
		setLocationRelativeTo(null);
	}
}
