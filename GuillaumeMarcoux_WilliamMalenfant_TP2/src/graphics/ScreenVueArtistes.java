package graphics;

import javax.swing.*;

import outils.Constantes;
import outils.ConstantesAffichage;
import outils.OutilsFichiers;
import objects.Artiste;
import objects.MySQLDatabase;
import objects.SheetTable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScreenVueArtistes extends JDialog implements Constantes,
		ConstantesAffichage {
	
	private JLabel labelNoArtisteSelected = new JLabel(
			"Veuillez s\u00E9lectionner un artiste!");
	
	ImageIcon imageArtiste = new ImageIcon();
	private JButton btnAjouter = new JButton(VIEW_OPERATIONS_AJOUTER);
	private JButton btnModifier = new JButton(VIEW_OPERATIONS_MODIFIER);
	private JButton btnSupprimer = new JButton(VIEW_OPERATIONS_SUPPRIMER);
	private JButton btnRechercher = new JButton(VIEW_OPERATIONS_RECHERCHER);
	private JButton btnQuitter = new JButton(VIEW_OPERATIONS_QUITTER);
	private JLabel labelArtisteNumero = new JLabel(VIEW_ARTISTE_LABEL_NUMERO);
	private JLabel textArtisteNumero = new JLabel();
	private JLabel labelArtisteNom = new JLabel(VIEW_ARTISTE_LABEL_NOM);
	private JLabel textArtisteNom = new JLabel();
	private JLabel labelArtisteEstMembre = new JLabel(
			VIEW_ARTISTE_LABEL_EST_MEMBRE);
	private JCheckBox checkBoxArtisteEstMembre = new JCheckBox("");
	private JButton buttonArtisteAlbums = new JButton(
			VIEW_ARTISTE_BUTTON_ALBUMS);
	private JLabel imageArtisteAffichage = new JLabel("", SwingConstants.CENTER);
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
		
		tableArtistes.setSelectedItem(0);
		
		setVisible(true);
		
	}
	
	private JPanel createOperationsPanel(){
		
		JPanel panelOperations = new JPanel();
		panelOperations.setLayout(new GridLayout(5, 1, 0, 0));
		
		GestionPanneauOperations gestionnaire = new GestionPanneauOperations(
				this);
		
		btnAjouter.addActionListener(gestionnaire);
		btnModifier.addActionListener(gestionnaire);
		btnSupprimer.addActionListener(gestionnaire);
		btnRechercher.addActionListener(gestionnaire);
		btnQuitter.addActionListener(gestionnaire);
		
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
		textArtisteNumero.setOpaque(true);
		textArtisteNumero.setBackground(Color.WHITE);
		textArtisteNumero
				.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textArtisteNumero.setPreferredSize(new Dimension(100, 20));
		panelAffichageArtiste.add(textArtisteNumero, gbc_textArtisteNumero);
		
		GridBagConstraints gbc_labelArtisteNom = new GridBagConstraints();
		gbc_labelArtisteNom.weighty = 1.0;
		gbc_labelArtisteNom.weightx = 1.0;
		gbc_labelArtisteNom.gridx = 0;
		gbc_labelArtisteNom.gridy = 4;
		panelAffichageArtiste.add(labelArtisteNom, gbc_labelArtisteNom);
		
		GridBagConstraints gbc_textArtisteNom = new GridBagConstraints();
		gbc_textArtisteNom.weighty = 1.0;
		gbc_textArtisteNom.weightx = 1.0;
		gbc_textArtisteNom.gridx = 1;
		gbc_textArtisteNom.gridy = 4;
		textArtisteNom.setOpaque(true);
		textArtisteNom.setBackground(Color.WHITE);
		textArtisteNom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textArtisteNom.setPreferredSize(new Dimension(100, 20));
		panelAffichageArtiste.add(textArtisteNom, gbc_textArtisteNom);
		
		GridBagConstraints gbc_labelArtisteEstMembre = new GridBagConstraints();
		gbc_labelArtisteEstMembre.weighty = 1.0;
		gbc_labelArtisteEstMembre.weightx = 1.0;
		gbc_labelArtisteEstMembre.gridx = 0;
		gbc_labelArtisteEstMembre.gridy = 5;
		panelAffichageArtiste.add(labelArtisteEstMembre,
				gbc_labelArtisteEstMembre);
		
		GridBagConstraints gbc_imageArtisteAffichage = new GridBagConstraints();
		gbc_imageArtisteAffichage.insets = new Insets(0, 0, 5, 0);
		gbc_imageArtisteAffichage.fill = GridBagConstraints.BOTH;
		gbc_imageArtisteAffichage.weighty = 1.0;
		gbc_imageArtisteAffichage.weightx = 1.0;
		gbc_imageArtisteAffichage.gridwidth = 2;
		gbc_imageArtisteAffichage.gridheight = 5;
		gbc_imageArtisteAffichage.gridx = 2;
		gbc_imageArtisteAffichage.gridy = 0;
		
		imageArtisteAffichage.setBorder(BorderFactory
				.createLineBorder(Color.BLACK));
		
		panelAffichageArtiste.add(imageArtisteAffichage,
				gbc_imageArtisteAffichage);
		
		GridBagConstraints gbc_checkBoxArtisteEstMembre = new GridBagConstraints();
		gbc_checkBoxArtisteEstMembre.weighty = 1.0;
		gbc_checkBoxArtisteEstMembre.weightx = 1.0;
		gbc_checkBoxArtisteEstMembre.gridx = 1;
		gbc_checkBoxArtisteEstMembre.gridy = 5;
		panelAffichageArtiste.add(checkBoxArtisteEstMembre,
				gbc_checkBoxArtisteEstMembre);
		
		GridBagConstraints gbc_buttonArtisteAlbums = new GridBagConstraints();
		gbc_buttonArtisteAlbums.fill = GridBagConstraints.BOTH;
		gbc_buttonArtisteAlbums.weighty = 1.0;
		gbc_buttonArtisteAlbums.weightx = 1.0;
		gbc_buttonArtisteAlbums.gridx = 2;
		gbc_buttonArtisteAlbums.gridy = 5;
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
					return artiste.isMembre() ? "oui" : "non";
				default:
					return null;
				}
				
			}
			
			@Override
			protected void actionOnSelect(){
				
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
	
	public void actionAjouter(){
		
	}
	
	public void actionModifier(){
		
	}
	
	public void actionSupprimer(){
		
	}
	
	public void actionRechercher(){
		
	}
	
}

class GestionPanneauOperations implements ActionListener, ConstantesAffichage {
	
	private ScreenVueArtistes vue;
	
	public GestionPanneauOperations(ScreenVueArtistes vue){
		super();
		this.vue = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		String buttonText = ((JButton)e.getSource()).getText();
		
		switch(buttonText){
		case VIEW_OPERATIONS_AJOUTER:
			vue.actionAjouter();
			break;
		case VIEW_OPERATIONS_MODIFIER:
			vue.actionModifier();
			break;
		case VIEW_OPERATIONS_SUPPRIMER:
			vue.actionSupprimer();
			break;
		case VIEW_OPERATIONS_RECHERCHER:
			vue.actionRechercher();
			break;
		case VIEW_OPERATIONS_QUITTER:
			vue.dispose();
			break;
		default:
			break;
		}
		
	}
}
