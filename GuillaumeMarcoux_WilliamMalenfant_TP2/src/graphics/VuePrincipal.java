package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objects.MySQLDatabase;
import outils.ConstantesAffichage;
import outils.OutilsFichiers;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class VuePrincipal extends JFrame implements ConstantesAffichage {
	
	private MySQLDatabase database;
	
	public MySQLDatabase getDatabase(){
		return database;
	}
	
	private JPanel contentPane;
	private JLabel lblArtiste = new JLabel();
	private JLabel lblAlbum = new JLabel();
	private JButton btnQuitter = new JButton(VIEW_PRINCIPAL_QUITTER);
	
	private ImageIcon artisteOut;
	private ImageIcon albumOut;
	
	public VuePrincipal(MySQLDatabase database, JFrame parentFrame){
		
		this.database = database;
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITLE_PRINCIPAL + " - " + TITLE_PROJECT);
		setSize(450, 516);
		setLocationRelativeTo(parentFrame);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblArtiste.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtiste.setBackground(Color.LIGHT_GRAY);
		lblArtiste.setBounds(99, 11, 233, 177);
		lblArtiste.setOpaque(true);
		
		BufferedImage bImg1 = null;
		try{
			bImg1 = ImageIO.read(OutilsFichiers
					.getFileFromResources("/images/artiste_mouse_out.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		Image img1 = bImg1.getScaledInstance(lblArtiste.getWidth(),
				lblArtiste.getHeight(), Image.SCALE_SMOOTH);
		artisteOut = new ImageIcon(img1);
		lblArtiste.setIcon(artisteOut);
		
		lblArtiste.setName("artiste");
		
		contentPane.add(lblArtiste);
		
		lblAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbum.setBackground(Color.LIGHT_GRAY);
		lblAlbum.setBounds(99, 239, 233, 155);
		lblAlbum.setOpaque(true);
		
		BufferedImage bImg2 = null;
		try{
			bImg2 = ImageIO.read(OutilsFichiers
					.getFileFromResources("/images/album_mouse_out.jpg"));
		}
		catch(IOException e1){
			e1.printStackTrace();
		}
		Image img2 = bImg2.getScaledInstance(lblAlbum.getWidth(),
				lblAlbum.getHeight(), Image.SCALE_SMOOTH);
		albumOut = new ImageIcon(img2);
		lblAlbum.setIcon(albumOut);
		
		lblAlbum.setName("album");
		
		contentPane.add(lblAlbum);
		
		btnQuitter.setBounds(160, 440, 107, 36);
		contentPane.add(btnQuitter);
		
		GestionImage gestionnaire = new GestionImage(this);
		
		lblArtiste.addMouseListener(gestionnaire);
		
		lblAlbum.addMouseListener(gestionnaire);
		
		btnQuitter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		setVisible(true);
		
	}
}

class GestionImage extends MouseAdapter {
	
	VuePrincipal vue;
	
	public GestionImage(VuePrincipal vue){
		this.vue = vue;
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		
		JLabel label = (JLabel)e.getSource();
		
		if(label.getName().equals("artiste")){
			
			new VueArtistes(vue.getDatabase(), vue);
			
		}
		else{
			
			new VueAlbums(vue.getDatabase(), vue).setVisible(true);
			
		}
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e){
		
		JLabel label = (JLabel)e.getSource();
		
		ImageIcon image;
		
		// TODO constante
		if(label.getName().equals("artiste")){
			
			BufferedImage img = null;
			try{
				img = ImageIO.read(OutilsFichiers
						.getFileFromResources("/images/artiste_mouse_on.jpg"));
			}
			catch(IOException e1){
				e1.printStackTrace();
			}
			Image lul = img.getScaledInstance(label.getWidth(),
					label.getHeight(), Image.SCALE_SMOOTH);
			image = new ImageIcon(lul);
			label.setIcon(image);
			
		}
		else{
			
			BufferedImage img = null;
			try{
				img = ImageIO.read(OutilsFichiers
						.getFileFromResources("/images/album_mouse_on.jpg"));
			}
			catch(IOException e1){
				e1.printStackTrace();
			}
			Image lul = img.getScaledInstance(label.getWidth(),
					label.getHeight(), Image.SCALE_SMOOTH);
			image = new ImageIcon(lul);
			label.setIcon(image);
			
		}
		
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	}
	
	@Override
	public void mouseExited(MouseEvent e){
		
		JLabel label = (JLabel)e.getSource();
		
		ImageIcon image;
		
		// TODO constante
		if(label.getName().equals("artiste")){
			
			BufferedImage img = null;
			try{
				img = ImageIO.read(OutilsFichiers
						.getFileFromResources("/images/artiste_mouse_out.jpg"));
			}
			catch(IOException e1){
				e1.printStackTrace();
			}
			Image lul = img.getScaledInstance(label.getWidth(),
					label.getHeight(), Image.SCALE_SMOOTH);
			image = new ImageIcon(lul);
			label.setIcon(image);
			
		}
		else{
			
			BufferedImage img = null;
			try{
				img = ImageIO.read(OutilsFichiers
						.getFileFromResources("/images/album_mouse_out.jpg"));
			}
			catch(IOException e1){
				e1.printStackTrace();
			}
			Image lul = img.getScaledInstance(label.getWidth(),
					label.getHeight(), Image.SCALE_SMOOTH);
			image = new ImageIcon(lul);
			label.setIcon(image);
			
		}
		
		label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		
	}
	
}