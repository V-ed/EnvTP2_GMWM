package graphics;

import javax.swing.*;

import objects.*;

public class ScreenVueArtistes extends JFrame {
	private JLabel labelNoArtisteSelected = new JLabel(
			"Veuillez s\u00E9lectionner un artiste!");
	
	ImageIcon imageArtiste = new ImageIcon();
	private final JCheckBox checkBoxEstMembre = new JCheckBox("");
	private final JLabel labelArtisteMembre = new JLabel(
			"Membre de l\u2019Association des artistes?");
	private final JLabel textArtisteNom = new JLabel("[dynamic]");
	private final JLabel textArtisteNumero = new JLabel("[dynamic]");
	private final JLabel labelArtisteNumero = new JLabel("Num\u00E9ro :");
	private final JLabel labelArtisteNom = new JLabel("Nom :");
	private final JLabel imageArtisteAffichage = new JLabel((Icon)null,
			SwingConstants.CENTER);
	private final JPanel panelAffichageArtiste = new JPanel();
	
	public ScreenVueArtistes(){
		getContentPane().setLayout(null);
		panelAffichageArtiste.setBounds(219, 25, 341, 155);
		
		getContentPane().add(panelAffichageArtiste);
		panelAffichageArtiste.setLayout(null);
		checkBoxEstMembre.setBounds(204, 117, 20, 20);
		panelAffichageArtiste.add(checkBoxEstMembre);
		labelArtisteMembre.setBounds(10, 117, 188, 20);
		panelAffichageArtiste.add(labelArtisteMembre);
		textArtisteNom.setBounds(74, 87, 161, 20);
		panelAffichageArtiste.add(textArtisteNom);
		textArtisteNumero.setBounds(74, 35, 69, 20);
		panelAffichageArtiste.add(textArtisteNumero);
		labelArtisteNumero.setBounds(10, 35, 54, 20);
		panelAffichageArtiste.add(labelArtisteNumero);
		labelArtisteNom.setBounds(10, 87, 54, 20);
		panelAffichageArtiste.add(labelArtisteNom);
		imageArtisteAffichage.setBounds(153, 11, 178, 65);
		panelAffichageArtiste.add(imageArtisteAffichage);
		
		JButton buttonArtisteAlbums = new JButton("Albums");
		buttonArtisteAlbums.setBounds(241, 87, 90, 51);
		panelAffichageArtiste.add(buttonArtisteAlbums);
		
		JPanel panelChoixArtiste = new JPanel();
		panelChoixArtiste.setBounds(219, 191, 341, 166);
		getContentPane().add(panelChoixArtiste);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 25, 199, 332);
		getContentPane().add(panel);
		
		labelNoArtisteSelected.setHorizontalAlignment(SwingConstants.CENTER);
		labelNoArtisteSelected.setBounds(357, 70, 180, 29);
		
	}
}
