package graphics;

import javax.swing.*;

import objects.*;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class VueAlbums extends VuesItems {
	
	private ImageIcon imageAlbum;
	private JLabel labelArtisteNumero;
	private JTextField textArtisteNumero;
	private JLabel labelArtisteNom;
	private JTextField textArtisteNom;
	private JLabel labelArtisteEstMembre;
	private JCheckBox checkBoxArtisteEstMembre;
	private JButton buttonArtisteAlbums;
	private JLabel imageArtisteAffichage;
	
	private SheetTable tableAlbums;
	
	public VueAlbums(MySQLDatabase database, JFrame parentFrame){
		
		super(database, parentFrame, true);
		
		this.database = database;
		
		tableAlbums.setSelectedItem(0);
		
		setVisible(true);
		
	}
	
	private void updateAlbum(Album nouvelAlbum){
		
		//		textArtisteNumero.setText("" + nouvelArtiste.getID());
		//		textArtisteNom.setText(nouvelArtiste.getFullName());
		//		
		//		checkBoxArtisteEstMembre.setSelected(nouvelArtiste.isMembre());
		//		
		//		imageArtiste = OutilsFichiers.getImageFromFile(nouvelArtiste
		//				.getImagePath());
		
	}
	
	@Override
	protected JPanel createItemsView(){
		
		JPanel panelAffichageAlbum = new JPanel();
		
		GridBagLayout gbl_panelAffichageArtiste = new GridBagLayout();
		panelAffichageAlbum.setLayout(gbl_panelAffichageArtiste);
		
		imageAlbum = new ImageIcon();
		labelArtisteNumero = new JLabel(VIEW_ARTISTE_LABEL_NUMERO);
		textArtisteNumero = new JTextField();
		labelArtisteNom = new JLabel(VIEW_ARTISTE_LABEL_NOM);
		textArtisteNom = new JTextField();
		labelArtisteEstMembre = new JLabel(VIEW_ARTISTE_LABEL_EST_MEMBRE);
		checkBoxArtisteEstMembre = new JCheckBox("");
		buttonArtisteAlbums = new JButton(VIEW_ARTISTE_BUTTON_ALBUMS);
		imageArtisteAffichage = new JLabel("", SwingConstants.CENTER);
		
		GridBagConstraints gbc_labelArtisteNumero = new GridBagConstraints();
		gbc_labelArtisteNumero.weighty = 1.0;
		gbc_labelArtisteNumero.weightx = 0;
		gbc_labelArtisteNumero.gridx = 0;
		gbc_labelArtisteNumero.gridy = 1;
		panelAffichageAlbum.add(labelArtisteNumero, gbc_labelArtisteNumero);
		
		GridBagConstraints gbc_textArtisteNumero = new GridBagConstraints();
		gbc_textArtisteNumero.weighty = 1.0;
		gbc_textArtisteNumero.weightx = 1.0;
		gbc_textArtisteNumero.gridx = 1;
		gbc_textArtisteNumero.gridy = 1;
		gbc_textArtisteNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textArtisteNumero.insets = new Insets(0, 10, 0, 15);
		textArtisteNumero.setEditable(false);
		textArtisteNumero.setBackground(Color.WHITE);
		panelAffichageAlbum.add(textArtisteNumero, gbc_textArtisteNumero);
		
		GridBagConstraints gbc_labelArtisteNom = new GridBagConstraints();
		gbc_labelArtisteNom.weighty = 1.0;
		gbc_labelArtisteNom.weightx = 0;
		gbc_labelArtisteNom.gridx = 0;
		gbc_labelArtisteNom.gridy = 4;
		panelAffichageAlbum.add(labelArtisteNom, gbc_labelArtisteNom);
		
		GridBagConstraints gbc_textArtisteNom = new GridBagConstraints();
		gbc_textArtisteNom.weighty = 1.0;
		gbc_textArtisteNom.weightx = 1.0;
		gbc_textArtisteNom.gridx = 1;
		gbc_textArtisteNom.gridy = 4;
		gbc_textArtisteNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textArtisteNom.insets = new Insets(0, 10, 0, 15);
		textArtisteNom.setEditable(false);
		textArtisteNom.setBackground(Color.WHITE);
		panelAffichageAlbum.add(textArtisteNom, gbc_textArtisteNom);
		
		GridBagConstraints gbc_labelArtisteEstMembre = new GridBagConstraints();
		gbc_labelArtisteEstMembre.weighty = 1.0;
		gbc_labelArtisteEstMembre.weightx = 0;
		gbc_labelArtisteEstMembre.gridx = 0;
		gbc_labelArtisteEstMembre.gridy = 5;
		panelAffichageAlbum.add(labelArtisteEstMembre,
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
		
		panelAffichageAlbum.add(imageArtisteAffichage,
				gbc_imageArtisteAffichage);
		
		GridBagConstraints gbc_checkBoxArtisteEstMembre = new GridBagConstraints();
		gbc_checkBoxArtisteEstMembre.weighty = 1.0;
		gbc_checkBoxArtisteEstMembre.weightx = 1.0;
		gbc_checkBoxArtisteEstMembre.gridx = 1;
		gbc_checkBoxArtisteEstMembre.gridy = 5;
		gbc_checkBoxArtisteEstMembre.anchor = GridBagConstraints.WEST;
		gbc_checkBoxArtisteEstMembre.insets = new Insets(0, 10, 0, 0);
		checkBoxArtisteEstMembre.setEnabled(false);
		panelAffichageAlbum.add(checkBoxArtisteEstMembre,
				gbc_checkBoxArtisteEstMembre);
		
		GridBagConstraints gbc_buttonArtisteAlbums = new GridBagConstraints();
		gbc_buttonArtisteAlbums.fill = GridBagConstraints.BOTH;
		gbc_buttonArtisteAlbums.weighty = 1.0;
		gbc_buttonArtisteAlbums.weightx = 1.0;
		gbc_buttonArtisteAlbums.gridx = 2;
		gbc_buttonArtisteAlbums.gridy = 5;
		panelAffichageAlbum.add(buttonArtisteAlbums, gbc_buttonArtisteAlbums);
		
		return panelAffichageAlbum;
		
	}
	
	@Override
	protected JPanel createChoixItemView(){
		
		JPanel panelChoixAlbum = new JPanel(new GridLayout());
		
		ArrayList<Object[]> listeObjets = database
				.getAllContentofTable(TABLE_NAME_ALBUMS);
		
		for(int i = 0; i < listeObjets.size(); i++){
			objetsTable.add(new Album(database, listeObjets.get(i)));
		}
		
		tableAlbums = new SheetTable(objetsTable, new String[]
		{
			"Titre", "Artiste", "Genre", "Prix"
		}){
			
			@Override
			public Object getValueAt(int rowIndex, int columnIndex){
				
				Album album = (Album)objetsTable.get(rowIndex);
				
				switch(columnIndex){
				case 0:
					return album.getTitre();
				case 1:
					return album.getArtiste().getFullName();
				case 2:
					return album.getGenre();
				case 3:
					return (new DecimalFormat("0.00 $"))
							.format(album.getPrix());
				default:
					return null;
				}
				
			}
			
			@Override
			protected void actionOnSelect(){
				
				Album albumSelectionne = (Album)getSelectedItem();
				
				updateAlbum(albumSelectionne);
				
			}
			
		};
		
		panelChoixAlbum.add(tableAlbums.getScrollableTable());
		
		return panelChoixAlbum;
		
	}
	
	@Override
	public void actionAjouter(){
		
	}
	
	@Override
	public void actionModifier(){
		
	}
	
	@Override
	public void actionSupprimer(){
		
	}
	
	@Override
	public void actionRechercher(){
		
	}
	
}
