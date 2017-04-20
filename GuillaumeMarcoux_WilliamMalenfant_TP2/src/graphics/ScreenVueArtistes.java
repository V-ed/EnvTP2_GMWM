package graphics;

import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class ScreenVueArtistes extends JFrame {
	private JLabel labelNoArtisteSelected = new JLabel(
			"Veuillez s\u00E9lectionner un artiste!");
	
	ImageIcon imageArtiste = new ImageIcon();
	private JCheckBox checkBoxEstMembre = new JCheckBox("");
	private JLabel labelArtisteMembre = new JLabel(
			"Membre de l\u2019Association des artistes?");
	private JLabel textArtisteNom = new JLabel("[dynamic]");
	private JLabel textArtisteNumero = new JLabel("[dynamic]");
	private JLabel labelArtisteNumero = new JLabel("Num\u00E9ro :");
	private JLabel labelArtisteNom = new JLabel("Nom :");
	private JLabel imageArtisteAffichage = new JLabel(imageArtiste,
			SwingConstants.CENTER);
	private JPanel panelAffichageArtiste = new JPanel();
	private JButton btnAjouter = new JButton("Ajouter");
	private JButton btnModifier = new JButton("Modifier");
	private JButton btnSupprimer = new JButton("Supprimer");
	private JButton btnRechercher = new JButton("Rechercher");
	private JButton btnQuitter = new JButton("Quitter");
	
	public ScreenVueArtistes(){
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{
			199, 341, 0
		};
		gridBagLayout.rowHeights = new int[]
		{
			158, 177, 0
		};
		gridBagLayout.columnWeights = new double[]
		{
			1.0, 0.0, Double.MIN_VALUE
		};
		gridBagLayout.rowWeights = new double[]
		{
			1.0, 0.0, Double.MIN_VALUE
		};
		getContentPane().setLayout(gridBagLayout);
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(15, 15, 15, 15);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(createOperationsPanel(), gbc_panel);
		
		GridBagConstraints gbc_panelAffichageArtiste = new GridBagConstraints();
		gbc_panelAffichageArtiste.fill = GridBagConstraints.BOTH;
		gbc_panelAffichageArtiste.insets = new Insets(0, 0, 5, 0);
		gbc_panelAffichageArtiste.gridx = 1;
		gbc_panelAffichageArtiste.gridy = 0;
		getContentPane().add(panelAffichageArtiste, gbc_panelAffichageArtiste);
		
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
		GridBagConstraints gbc_panelChoixArtiste = new GridBagConstraints();
		gbc_panelChoixArtiste.fill = GridBagConstraints.BOTH;
		gbc_panelChoixArtiste.gridx = 1;
		gbc_panelChoixArtiste.gridy = 1;
		getContentPane().add(panelChoixArtiste, gbc_panelChoixArtiste);
		
		labelNoArtisteSelected.setHorizontalAlignment(SwingConstants.CENTER);
		labelNoArtisteSelected.setBounds(357, 70, 180, 29);
		
	}
	
	public JPanel createOperationsPanel(){
		
		JPanel panelOperations = new JPanel();
		panelOperations.setLayout(new GridLayout(5, 1, 0, 0));
		
		panelOperations.add(btnAjouter);
		panelOperations.add(btnModifier);
		panelOperations.add(btnSupprimer);
		panelOperations.add(btnRechercher);
		panelOperations.add(btnQuitter);
		
		return panelOperations;
		
	}
	
}
