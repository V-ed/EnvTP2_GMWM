package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ScreenPrincipal extends JFrame {
	
	private JPanel contentPane;
	private JLabel lblArtiste = new JLabel("Artiste");
	private JLabel lblAlbum = new JLabel("Album");
	private JButton btnQuitter = new JButton("Quitter");
	
	/**
	 * Create the frame.
	 */
	public ScreenPrincipal(){
		setBounds(100, 100, 450, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblArtiste.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtiste.setBackground(Color.LIGHT_GRAY);
		lblArtiste.setBounds(99, 11, 233, 84);
		lblArtiste.setOpaque(true);
		contentPane.add(lblArtiste);
		
		lblAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbum.setBackground(Color.LIGHT_GRAY);
		lblAlbum.setBounds(99, 120, 233, 84);
		lblAlbum.setOpaque(true);
		contentPane.add(lblAlbum);
		
		btnQuitter.setBounds(167, 245, 107, 36);
		contentPane.add(btnQuitter);
	}
}
