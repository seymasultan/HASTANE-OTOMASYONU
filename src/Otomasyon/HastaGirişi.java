package Otomasyon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAOImp.HastaDAOImp;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class HastaGiriþi extends JFrame {

	private JPanel contentPane;
	private JTextField kullanýcýadý_ekraný;
	private JPasswordField parola_ekraný;

	public HastaGiriþi() {
		setTitle("HASTA G\u0130R\u0130\u015E EKRANI");
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKullancAd = new JLabel("T.C. Kimlik:");
		lblKullancAd.setBounds(211, 196, 113, 26);
		contentPane.add(lblKullancAd);
		
		JLabel lblParola = new JLabel("Parola:");
		lblParola.setBounds(211, 233, 72, 26);
		contentPane.add(lblParola);
		
		kullanýcýadý_ekraný = new JTextField();
		kullanýcýadý_ekraný.setBounds(334, 199, 86, 20);
		contentPane.add(kullanýcýadý_ekraný);
		kullanýcýadý_ekraný.setColumns(10);
		
		JButton btnGiriYap = new JButton("G\u0130R\u0130\u015E YAP");
		btnGiriYap.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String kimlik = kullanýcýadý_ekraný.getText();
				String parola=  String.valueOf( parola_ekraný.getPassword()); //getPassword char aldýðýndan Stringe dönüþtürüyoruz
				HastaDAOImp imp = new HastaDAOImp();
				Hasta hasta = imp.girisYap(kimlik, parola); 
				if(hasta!=null) {
					RandevuEkraný frame = new RandevuEkraný(hasta);
					frame.setVisible(true);
					dispose();
					
				}
				else
					JOptionPane.showMessageDialog(null, "T.C. kimlik veya parola yanlýþ!");
				
				
			}
		});

		btnGiriYap.setBounds(276, 295, 92, 23);
		contentPane.add(btnGiriYap);
		ImageIcon pp = new ImageIcon("back.jpg");
		
		parola_ekraný = new JPasswordField();
		parola_ekraný.setBounds(334, 236, 86, 20);
		contentPane.add(parola_ekraný);
		JLabel label = new JLabel(pp);
		label.setBounds(0, 0, 650, 400);
		contentPane.add(label);
		
		setLocationRelativeTo(null);
	}
}
