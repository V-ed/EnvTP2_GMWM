package graphics;

import javax.swing.*;

import objects.*;

public class ScreenPrincipal extends JFrame {
	
	private JPanel panneauPrincipal = new JPanel();
	
	private JComboBox<?> choixArtiste = new JComboBox<Artiste>();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFichier = new JMenu("Fichier");
	private JMenuItem menuFichierOuvrir = new JMenuItem("Ouvrir");
	private JLabel labelNoArtisteSelected = new JLabel(
			"Veuillez s\u00E9lectionner un artiste!");
	private JLabel labelSelectionArtistes = new JLabel("Artistes");
	private JMenu menuOperations = new JMenu("Op\u00E9rations");
	private JMenuItem menuOperationsNewArtiste = new JMenuItem("Nouvel Artiste");
	private JMenuItem menuOperationsNewAlbum = new JMenuItem("Nouvel Album");
	private JLabel labelArtisteNom = new JLabel("Nom de l'artiste :");
	private JLabel labelArtistePrenom = new JLabel("Pr\u00E9nom de l'artiste :");
	private JLabel textArtisteNom = new JLabel("[dynamic]");
	private JLabel textArtistePrenom = new JLabel("[dynamic]");
	private JLabel labelArtisteMembre = new JLabel(
			"Membre de l\u2019Association des artistes?");
	private JCheckBox checkBoxEstMembre = new JCheckBox("");
	private JLabel labelArtisteImage = new JLabel("<HTML><U>Image</U></HTML>");
	
	ImageIcon imageArtiste = new ImageIcon();
	JLabel imageArtisteAffichage = new JLabel(imageArtiste, JLabel.CENTER);
	
	public ScreenPrincipal(){
		
		// Menu Items
		menuFichier.add(menuFichierOuvrir);
		
		menuOperations.add(menuOperationsNewArtiste);
		menuOperations.add(menuOperationsNewAlbum);
		
		menuBar.add(menuFichier);
		menuBar.add(menuOperations);
		setJMenuBar(menuBar);
		
		// Contenu
		getContentPane().add(panneauPrincipal);
		panneauPrincipal.setLayout(null);
		
		labelNoArtisteSelected.setHorizontalAlignment(SwingConstants.CENTER);
		labelNoArtisteSelected.setBounds(357, 70, 180, 29);
		
		labelArtisteImage.setBounds(95, 150, 86, 20);
		panneauPrincipal.add(labelArtisteImage);
		
		labelArtisteImage.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxEstMembre.setBounds(225, 120, 20, 20);
		panneauPrincipal.add(checkBoxEstMembre);
		
		labelArtisteMembre.setBounds(20, 120, 188, 20);
		panneauPrincipal.add(labelArtisteMembre);
		
		textArtistePrenom.setBounds(126, 90, 119, 20);
		panneauPrincipal.add(textArtistePrenom);
		
		textArtisteNom.setBounds(126, 60, 119, 20);
		panneauPrincipal.add(textArtisteNom);
		
		labelSelectionArtistes.setBounds(20, 20, 50, 20);
		panneauPrincipal.add(labelSelectionArtistes);
		
		choixArtiste.setBounds(95, 20, 150, 20);
		panneauPrincipal.add(choixArtiste);
		
		labelArtisteNom.setBounds(20, 60, 86, 20);
		panneauPrincipal.add(labelArtisteNom);
		
		labelArtistePrenom.setBounds(20, 90, 96, 20);
		panneauPrincipal.add(labelArtistePrenom);
		
		imageArtisteAffichage.setBounds(20, 180, 225, 145);
		panneauPrincipal.add(imageArtisteAffichage);
		
	}
}
