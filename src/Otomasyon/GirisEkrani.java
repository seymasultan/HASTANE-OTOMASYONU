package Otomasyon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GirisEkrani extends JFrame {

	private JPanel contentPane;

	public GirisEkrani() {
		setTitle("G\u0130R\u0130\u015E EKRANI");
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnHastaGirii = new JButton("HASTA G\u0130R\u0130\u015E\u0130");
		btnHastaGirii.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				HastaGiriþi frame = new HastaGiriþi();
				frame.setVisible(true);
			}
		});
		btnHastaGirii.setBounds(240, 262, 157, 23);
		contentPane.add(btnHastaGirii);

		JButton btnNewButton = new JButton("SEKRETER G\u0130R\u0130\u015E\u0130");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				SekreterEkraný frame = new SekreterEkraný();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(240, 295, 157, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u00DCYE OL");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				HastaUyeOl frame = new HastaUyeOl();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(240, 228, 157, 23);
		contentPane.add(btnNewButton_1);

		ImageIcon pp = new ImageIcon("back.jpg");
		JLabel label = new JLabel(pp);
		label.setBounds(0, 0, 650, 400);
		contentPane.add(label);

		setLocationRelativeTo(null);

	}
}
