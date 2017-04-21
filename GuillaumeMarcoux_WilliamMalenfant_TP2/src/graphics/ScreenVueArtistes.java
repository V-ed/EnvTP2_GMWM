package graphics;

import javax.swing.*;

import outils.Constantes;
import outils.OutilsFichiers;
import objects.Artiste;
import objects.MySQLDatabase;
import objects.SheetTable;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.util.ArrayList;

public class ScreenVueArtistes extends JDialog implements Constantes {
	
	private JLabel labelNoArtisteSelected = new JLabel(
			"Veuillez s\u00E9lectionner un artiste!");
	
	ImageIcon imageArtiste = new ImageIcon();
	private JButton btnAjouter = new JButton("Ajouter");
	private JButton btnModifier = new JButton("Modifier");
	private JButton btnSupprimer = new JButton("Supprimer");
	private JButton btnRechercher = new JButton("Rechercher");
	private JButton btnQuitter = new JButton("Quitter");
	private final JLabel labelArtisteNumero = new JLabel("Num\u00E9ro :");
	private final JLabel textArtisteNumero = new JLabel("[dynamic]");
	private final JLabel labelArtisteNom = new JLabel("Nom :");
	private final JLabel textArtisteNom = new JLabel("[dynamic]");
	private final JLabel labelArtisteEstMembre = new JLabel("Membre?");
	private final JCheckBox checkBoxArtisteEstMembre = new JCheckBox("");
	private final JButton buttonArtisteAlbums = new JButton("Albums");
	private JLabel imageArtisteAffichage = new JLabel(
			"<HTML><I>image</I></HTML>", SwingConstants.CENTER);
	private SheetTable tableArtistes;
	
	private MySQLDatabase database;
	private ArrayList<Object> artistes = new ArrayList<>();
	
	public ScreenVueArtistes(MySQLDatabase database, JFrame parentFrame){
		
		super(parentFrame, true);
		
		this.database = database;
		
		setSize(600, 400);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{
			138, 341, 0
		};
		gridBagLayout.rowHeights = new int[]
		{
			158, 177, 0
		};
		gridBagLayout.columnWeights = new double[]
		{
			0.0, 1.0, Double.MIN_VALUE
		};
		gridBagLayout.rowWeights = new double[]
		{
			1.0, 1.0, Double.MIN_VALUE
		};
		getContentPane().setLayout(gridBagLayout);
		
		GridBagConstraints gbc_panelOperations = new GridBagConstraints();
		gbc_panelOperations.weighty = 1.0;
		gbc_panelOperations.gridheight = 2;
		gbc_panelOperations.insets = new Insets(15, 15, 15, 15);
		gbc_panelOperations.fill = GridBagConstraints.BOTH;
		gbc_panelOperations.gridx = 0;
		gbc_panelOperations.gridy = 0;
		getContentPane().add(createOperationsPanel(), gbc_panelOperations);
		
		GridBagConstraints gbc_panelVueArtiste = new GridBagConstraints();
		gbc_panelVueArtiste.insets = new Insets(5, 5, 5, 5);
		gbc_panelVueArtiste.fill = GridBagConstraints.BOTH;
		gbc_panelVueArtiste.gridx = 1;
		gbc_panelVueArtiste.gridy = 0;
		getContentPane().add(createArtisteView(), gbc_panelVueArtiste);
		
		GridBagConstraints gbc_panelChoixArtiste = new GridBagConstraints();
		gbc_panelChoixArtiste.insets = new Insets(5, 5, 5, 5);
		gbc_panelChoixArtiste.weighty = 1.0;
		gbc_panelChoixArtiste.weightx = 1.0;
		gbc_panelChoixArtiste.fill = GridBagConstraints.BOTH;
		gbc_panelChoixArtiste.gridx = 1;
		gbc_panelChoixArtiste.gridy = 1;
		getContentPane().add(createChoixArtisteView(), gbc_panelChoixArtiste);
		
		labelNoArtisteSelected.setHorizontalAlignment(SwingConstants.CENTER);
		labelNoArtisteSelected.setBounds(357, 70, 180, 29);
		
		setVisible(true);
		
	}
	
	private JPanel createOperationsPanel(){
		
		JPanel panelOperations = new JPanel();
		panelOperations.setLayout(new GridLayout(5, 1, 0, 0));
		
		panelOperations.add(btnAjouter);
		panelOperations.add(btnModifier);
		panelOperations.add(btnSupprimer);
		panelOperations.add(btnRechercher);
		panelOperations.add(btnQuitter);
		
		return panelOperations;
		
	}
	
	private JPanel createArtisteView(){
		
		JPanel panelAffichageArtiste = new JPanel();
		
		GridBagLayout gbl_panelAffichageArtiste = new GridBagLayout();
		panelAffichageArtiste.setLayout(gbl_panelAffichageArtiste);
		
		GridBagConstraints gbc_imageArtisteAffichage = new GridBagConstraints();
		gbc_imageArtisteAffichage.fill = GridBagConstraints.BOTH;
		gbc_imageArtisteAffichage.weighty = 1.0;
		gbc_imageArtisteAffichage.weightx = 1.0;
		gbc_imageArtisteAffichage.gridwidth = 3;
		gbc_imageArtisteAffichage.gridheight = 4;
		gbc_imageArtisteAffichage.gridx = 2;
		gbc_imageArtisteAffichage.gridy = 0;
		
		imageArtisteAffichage.setBorder(BorderFactory
				.createLineBorder(Color.BLACK));
		
		panelAffichageArtiste.add(imageArtisteAffichage,
				gbc_imageArtisteAffichage);
		
		GridBagConstraints gbc_labelArtisteNumero = new GridBagConstraints();
		gbc_labelArtisteNumero.weighty = 1.0;
		gbc_labelArtisteNumero.weightx = 1.0;
		gbc_labelArtisteNumero.gridx = 0;
		gbc_labelArtisteNumero.gridy = 1;
		panelAffichageArtiste.add(labelArtisteNumero, gbc_labelArtisteNumero);
		
		GridBagConstraints gbc_textArtisteNumero = new GridBagConstraints();
		gbc_textArtisteNumero.weighty = 1.0;
		gbc_textArtisteNumero.weightx = 1.0;
		gbc_textArtisteNumero.gridx = 1;
		gbc_textArtisteNumero.gridy = 1;
		panelAffichageArtiste.add(textArtisteNumero, gbc_textArtisteNumero);
		
		GridBagConstraints gbc_labelArtisteNom = new GridBagConstraints();
		gbc_labelArtisteNom.weighty = 1.0;
		gbc_labelArtisteNom.weightx = 1.0;
		gbc_labelArtisteNom.gridx = 0;
		gbc_labelArtisteNom.gridy = 4;
		panelAffichageArtiste.add(labelArtisteNom, gbc_labelArtisteNom);
		
		GridBagConstraints gbc_textArtisteNom = new GridBagConstraints();
		gbc_textArtisteNom.gridwidth = 3;
		gbc_textArtisteNom.weighty = 1.0;
		gbc_textArtisteNom.weightx = 1.0;
		gbc_textArtisteNom.gridx = 1;
		gbc_textArtisteNom.gridy = 4;
		panelAffichageArtiste.add(textArtisteNom, gbc_textArtisteNom);
		
		GridBagConstraints gbc_labelArtisteEstMembre = new GridBagConstraints();
		gbc_labelArtisteEstMembre.weighty = 1.0;
		gbc_labelArtisteEstMembre.weightx = 1.0;
		gbc_labelArtisteEstMembre.gridx = 0;
		gbc_labelArtisteEstMembre.gridy = 5;
		panelAffichageArtiste.add(labelArtisteEstMembre,
				gbc_labelArtisteEstMembre);
		
		GridBagConstraints gbc_checkBoxArtisteEstMembre = new GridBagConstraints();
		gbc_checkBoxArtisteEstMembre.weighty = 1.0;
		gbc_checkBoxArtisteEstMembre.weightx = 1.0;
		gbc_checkBoxArtisteEstMembre.gridx = 1;
		gbc_checkBoxArtisteEstMembre.gridy = 5;
		panelAffichageArtiste.add(checkBoxArtisteEstMembre,
				gbc_checkBoxArtisteEstMembre);
		
		GridBagConstraints gbc_buttonArtisteAlbums = new GridBagConstraints();
		gbc_buttonArtisteAlbums.fill = GridBagConstraints.BOTH;
		gbc_buttonArtisteAlbums.gridheight = 2;
		gbc_buttonArtisteAlbums.weighty = 1.0;
		gbc_buttonArtisteAlbums.weightx = 1.0;
		gbc_buttonArtisteAlbums.gridx = 4;
		gbc_buttonArtisteAlbums.gridy = 4;
		panelAffichageArtiste.add(buttonArtisteAlbums, gbc_buttonArtisteAlbums);
		
		return panelAffichageArtiste;
		
	}
	
	private JPanel createChoixArtisteView(){
		
		JPanel panelChoixArtiste = new JPanel(new GridLayout());
		
		ArrayList<Object[]> listeObjets = database
				.getAllContentofTable(TABLE_NAME_ARTISTES);
		
		for(int i = 0; i < listeObjets.size(); i++){
			artistes.add(new Artiste(database, listeObjets.get(i)));
		}
		
		tableArtistes = new SheetTable(artistes, new String[]
		{
			"Numéro", "Nom", "Est membre"
		}){
			
			@Override
			public Object getValueAt(int rowIndex, int columnIndex){
				
				Artiste artiste = (Artiste)artistes.get(rowIndex);
				
				switch(columnIndex){
				case 0:
					return artiste.getID();
				case 1:
					return artiste.getFullName();
				case 2:
					return artiste.isMembre();
				default:
					return null;
				}
				
			}
			
			@Override
			public void actionOnSelect(){
				
				Artiste artisteSelectionne = (Artiste)getSelectedItem();
				
				updateArtiste(artisteSelectionne);
				
			}
			
		};
		
		panelChoixArtiste.add(tableArtistes.getScrollableTable());
		
		return panelChoixArtiste;
		
	}
	
	private void updateArtiste(Artiste nouvelArtiste){
		
		textArtisteNumero.setText("" + nouvelArtiste.getID());
		textArtisteNom.setText(nouvelArtiste.getFullName());
		
		checkBoxArtisteEstMembre.setSelected(nouvelArtiste.isMembre());
		
		imageArtiste = OutilsFichiers.getImageFromFile(nouvelArtiste
				.getImagePath());
		
	}
}
