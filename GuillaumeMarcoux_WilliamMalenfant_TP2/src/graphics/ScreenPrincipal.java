package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objects.Artiste;
import objects.MySQLDatabase;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

public class ScreenPrincipal extends JFrame {
	
	private MySQLDatabase database;
	private JPanel contentPane;
	private JLabel lblArtiste = new JLabel("Artiste");
	private JLabel lblAlbum = new JLabel("Album");
	private JButton btnQuitter = new JButton("Quitter");
	
	/**
	 * Create the frame.
	 */
	public ScreenPrincipal(MySQLDatabase database){
		
		this.database = database;
		
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
		
		lblArtiste.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				
				setVisible(false);
				
				new ScreenVueArtistes(database, ScreenPrincipal.this);
				
				setVisible(true);
				
			}
		});
		
		lblAlbum.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				
				//new ScreenVueAlbums(database);
				
			}
		});
		
		btnQuitter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		setVisible(true);
		
		//TODO Remove test data
		
		Artiste artiste = new Artiste(database, "Pierre", "Jean", true,
				"test.png");
		
		artiste.addToDatabase();
		
	}
}
