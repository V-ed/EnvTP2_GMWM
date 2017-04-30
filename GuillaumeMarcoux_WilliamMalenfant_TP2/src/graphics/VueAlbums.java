package graphics;

import javax.swing.*;

import outils.OutilsFichiers;
import objects.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.util.ArrayList;

public class VueAlbums extends VuesItems {
	
	private ImageIcon imageAlbum;
	private JLabel imageAlbumAffichage;
	private JLabel labelAlbumNumero;
	private JTextField textAlbumNumero;
	private JLabel labelAlbumTitre;
	private JTextField textAlbumTitre;
	private JLabel labelAlbumPrix;
	private JTextField textAlbumPrix;
	private JLabel labelAlbumGenre;
	private JLabel labelAlbumDateSortie;
	private JLabel lblMaison;
	private JTextField textAlbumGenre;
	private JTextField textAlbumDateSortie;
	private JTextField textAlbumMaison;
	
	private SheetTable tableAlbums;
	
	public VueAlbums(MySQLDatabase database, JFrame parentFrame){
		
		super(database, parentFrame, true);
		
		setTitle(TITLE_VUE_ALBUMS + " - " + TITLE_PROJECT);
		
		this.database = database;
		
		tableAlbums.setSelectedItem(0);
		
	}
	
	public VueAlbums(MySQLDatabase database, JFrame parentFrame, Artiste artiste){
		
		this(database, parentFrame);
		
		ArrayList<Object[]> listeObjets = database.getAllContentWhere(
				Album.TABLE_NAME, new String[]
				{
					Album.COLUMN_NAMES[Album.COLUMN_ARTIST]
				}, new Object[]
				{
					artiste.getID()
				}, true);
		
		objetsTable.clear();
		
		for(int i = 0; i < listeObjets.size(); i++){
			objetsTable.add(new Album(database, listeObjets.get(i)));
		}
		
		tableAlbums.setSelectedItem(0);
		
		tableAlbums.setObjects(objetsTable);
		
	}
	
	private void updateAlbum(Album nouvelAlbum){
		
		if(nouvelAlbum == null){
			
			textAlbumNumero.setText("");
			textAlbumTitre.setText("");
			textAlbumPrix.setText("");
			textAlbumGenre.setText("");
			textAlbumDateSortie.setText("");
			textAlbumMaison.setText("");
			//			imageAlbum = OutilsFichiers.getImageFromFile(); // TODO add path to default NO_IMAGE file
			
		}
		else{
			
			textAlbumNumero.setText(String.valueOf(nouvelAlbum.getID()));
			textAlbumTitre.setText(nouvelAlbum.getTitre());
			textAlbumPrix.setText(nouvelAlbum.getFormattedPrix());
			textAlbumGenre.setText(nouvelAlbum.getGenre());
			textAlbumDateSortie
					.setText(nouvelAlbum.getAnneeSortie().toString());
			textAlbumMaison.setText(nouvelAlbum.getMaisonDistribution());
			imageAlbum = OutilsFichiers.getImageFromProject(nouvelAlbum
					.getImagePath());
			
			repaint();
			
		}
		
	}
	
	@Override
	public void windowRepainted(){
		
	}
	
	@Override
	protected JPanel createItemsView(){
		
		JPanel panelAffichageAlbum = new JPanel();
		
		GridBagLayout gbl_panelAffichageArtiste = new GridBagLayout();
		gbl_panelAffichageArtiste.rowWeights = new double[]
		{
			0.0, 0.0, 0.0, 1.0, 1.0, 1.0
		};
		gbl_panelAffichageArtiste.columnWeights = new double[]
		{
			0.0, 1.0, 0.0, 0.0
		};
		panelAffichageAlbum.setLayout(gbl_panelAffichageArtiste);
		
		imageAlbum = new ImageIcon();
		imageAlbumAffichage = new JLabel("", SwingConstants.CENTER);
		labelAlbumNumero = new JLabel(VIEW_ARTISTE_LABEL_NUMERO);
		textAlbumNumero = new JTextField();
		labelAlbumTitre = new JLabel(VIEW_OPERATION_ALBUM_LABEL_TITLE);
		textAlbumTitre = new JTextField();
		labelAlbumPrix = new JLabel(VIEW_OPERATION_ALBUM_LABEL_PRICE);
		textAlbumPrix = new JTextField();
		labelAlbumGenre = new JLabel(VIEW_OPERATION_ALBUM_LABEL_GENRE);
		textAlbumGenre = new JTextField();
		labelAlbumDateSortie = new JLabel(VIEW_OPERATION_ALBUM_LABEL_ANNEE);
		textAlbumDateSortie = new JTextField();
		lblMaison = new JLabel(VIEW_OPERATION_ALBUM_LABEL_MAISON);
		textAlbumMaison = new JTextField();
		
		GridBagConstraints gbc_labelAlbumNumero = new GridBagConstraints();
		gbc_labelAlbumNumero.insets = new Insets(0, 0, 5, 5);
		gbc_labelAlbumNumero.weighty = 1.0;
		gbc_labelAlbumNumero.weightx = 0;
		gbc_labelAlbumNumero.gridx = 0;
		gbc_labelAlbumNumero.gridy = 0;
		panelAffichageAlbum.add(labelAlbumNumero, gbc_labelAlbumNumero);
		
		GridBagConstraints gbc_textAlbumNumero = new GridBagConstraints();
		gbc_textAlbumNumero.weighty = 1.0;
		gbc_textAlbumNumero.weightx = 1.0;
		gbc_textAlbumNumero.gridx = 1;
		gbc_textAlbumNumero.gridy = 0;
		gbc_textAlbumNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAlbumNumero.insets = new Insets(0, 10, 5, 15);
		textAlbumNumero.setEditable(false);
		textAlbumNumero.setBackground(Color.WHITE);
		panelAffichageAlbum.add(textAlbumNumero, gbc_textAlbumNumero);
		
		GridBagConstraints gbc_labelAlbumTitre = new GridBagConstraints();
		gbc_labelAlbumTitre.insets = new Insets(0, 0, 5, 5);
		gbc_labelAlbumTitre.weighty = 1.0;
		gbc_labelAlbumTitre.weightx = 0;
		gbc_labelAlbumTitre.gridx = 0;
		gbc_labelAlbumTitre.gridy = 1;
		panelAffichageAlbum.add(labelAlbumTitre, gbc_labelAlbumTitre);
		
		GridBagConstraints gbc_textAlbumTitre = new GridBagConstraints();
		gbc_textAlbumTitre.weighty = 1.0;
		gbc_textAlbumTitre.weightx = 1.0;
		gbc_textAlbumTitre.gridx = 1;
		gbc_textAlbumTitre.gridy = 1;
		gbc_textAlbumTitre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAlbumTitre.insets = new Insets(0, 10, 5, 15);
		textAlbumTitre.setEditable(false);
		textAlbumTitre.setBackground(Color.WHITE);
		panelAffichageAlbum.add(textAlbumTitre, gbc_textAlbumTitre);
		
		GridBagConstraints gbc_imageAlbumAffichage = new GridBagConstraints();
		gbc_imageAlbumAffichage.fill = GridBagConstraints.BOTH;
		gbc_imageAlbumAffichage.weighty = 1.0;
		gbc_imageAlbumAffichage.weightx = 1.0;
		gbc_imageAlbumAffichage.gridwidth = 2;
		gbc_imageAlbumAffichage.gridheight = 6;
		gbc_imageAlbumAffichage.gridx = 2;
		gbc_imageAlbumAffichage.gridy = 0;
		
		imageAlbumAffichage.setBorder(BorderFactory
				.createLineBorder(Color.BLACK));
		
		panelAffichageAlbum.add(imageAlbumAffichage, gbc_imageAlbumAffichage);
		
		GridBagConstraints gbc_labelAlbumPrix = new GridBagConstraints();
		gbc_labelAlbumPrix.insets = new Insets(0, 0, 5, 5);
		gbc_labelAlbumPrix.weighty = 1.0;
		gbc_labelAlbumPrix.weightx = 0;
		gbc_labelAlbumPrix.gridx = 0;
		gbc_labelAlbumPrix.gridy = 2;
		panelAffichageAlbum.add(labelAlbumPrix, gbc_labelAlbumPrix);
		
		textAlbumPrix.setEditable(false);
		textAlbumPrix.setBackground(Color.WHITE);
		GridBagConstraints gbc_textAlbumPrix = new GridBagConstraints();
		gbc_textAlbumPrix.insets = new Insets(0, 10, 5, 15);
		gbc_textAlbumPrix.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAlbumPrix.gridx = 1;
		gbc_textAlbumPrix.gridy = 2;
		panelAffichageAlbum.add(textAlbumPrix, gbc_textAlbumPrix);
		
		GridBagConstraints gbc_labelAlbumGenre = new GridBagConstraints();
		gbc_labelAlbumGenre.insets = new Insets(0, 0, 5, 5);
		gbc_labelAlbumGenre.gridx = 0;
		gbc_labelAlbumGenre.gridy = 3;
		panelAffichageAlbum.add(labelAlbumGenre, gbc_labelAlbumGenre);
		
		textAlbumGenre.setEditable(false);
		textAlbumGenre.setBackground(Color.WHITE);
		GridBagConstraints gbc_textAlbumGenre = new GridBagConstraints();
		gbc_textAlbumGenre.insets = new Insets(0, 10, 5, 15);
		gbc_textAlbumGenre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAlbumGenre.gridx = 1;
		gbc_textAlbumGenre.gridy = 3;
		panelAffichageAlbum.add(textAlbumGenre, gbc_textAlbumGenre);
		
		GridBagConstraints gbc_labelAlbumDateSortie = new GridBagConstraints();
		gbc_labelAlbumDateSortie.insets = new Insets(0, 0, 5, 5);
		gbc_labelAlbumDateSortie.gridx = 0;
		gbc_labelAlbumDateSortie.gridy = 4;
		panelAffichageAlbum.add(labelAlbumDateSortie, gbc_labelAlbumDateSortie);
		
		textAlbumDateSortie.setEditable(false);
		textAlbumDateSortie.setBackground(Color.WHITE);
		GridBagConstraints gbc_textAlbumDateSortie = new GridBagConstraints();
		gbc_textAlbumDateSortie.insets = new Insets(0, 10, 5, 15);
		gbc_textAlbumDateSortie.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAlbumDateSortie.gridx = 1;
		gbc_textAlbumDateSortie.gridy = 4;
		panelAffichageAlbum.add(textAlbumDateSortie, gbc_textAlbumDateSortie);
		
		GridBagConstraints gbc_lblMaison = new GridBagConstraints();
		gbc_lblMaison.insets = new Insets(0, 0, 0, 5);
		gbc_lblMaison.gridx = 0;
		gbc_lblMaison.gridy = 5;
		panelAffichageAlbum.add(lblMaison, gbc_lblMaison);
		
		textAlbumMaison.setEditable(false);
		textAlbumMaison.setBackground(Color.WHITE);
		GridBagConstraints gbc_textAlbumMaison = new GridBagConstraints();
		gbc_textAlbumMaison.insets = new Insets(0, 10, 5, 15);
		gbc_textAlbumMaison.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAlbumMaison.gridx = 1;
		gbc_textAlbumMaison.gridy = 5;
		panelAffichageAlbum.add(textAlbumMaison, gbc_textAlbumMaison);
		
		return panelAffichageAlbum;
		
	}
	
	@Override
	protected JPanel createChoixItemView(){
		
		JPanel panelChoixAlbum = new JPanel(new GridLayout());
		
		ArrayList<Object[]> listeObjets = database
				.getAllContentofTable(Album.TABLE_NAME);
		
		for(int i = 0; i < listeObjets.size(); i++){
			objetsTable.add(new Album(database, listeObjets.get(i)));
		}
		
		tableAlbums = new SheetTable(objetsTable, new String[]
		{
			"Numéro", "Titre", "Artiste", "Genre", "Prix"
		}){
			
			@Override
			public Object getValueAt(int rowIndex, int columnIndex){
				
				Album album = (Album)objetsTable.get(rowIndex);
				
				switch(columnIndex){
				case 0:
					return album.getID();
				case 1:
					return album.getTitre();
				case 2:
					return album.getArtiste().getFullName();
				case 3:
					return album.getGenre();
				case 4:
					return album.getFormattedPrix();
				default:
					return null;
				}
				
			}
			
			@Override
			protected void actionOnSelect(boolean hasSelection){
				
				Album albumSelectionne = null;
				
				if(hasSelection)
					albumSelectionne = (Album)getSelectedItem();
				
				updateAlbum(albumSelectionne);
				
			}
			
			@Override
			protected void actionOnDoubleClick(){
				actionModifier();
			}
			
		};
		
		panelChoixAlbum.add(tableAlbums.getScrollableTable());
		
		return panelChoixAlbum;
		
	}
	
	@Override
	public void actionAjouter(){
		
		new VuesOperationAlbum(database, VueAlbums.this, AJOUTER, null);
		
	}
	
	@Override
	public void actionModifier(){
		
		VuesOperationAlbum vue = new VuesOperationAlbum(database, this,
				VuesOperationAlbum.MODIFIER,
				(Album)tableAlbums.getSelectedItem());
		
		if(vue.hasConfirmed()){
			tableAlbums.fireTableDataChanged();
			tableAlbums.setSelectedItem(0);
		}
		
	}
	
	@Override
	public void actionSupprimer(){
		
		if(JOptionPane.showConfirmDialog(this,
				"Êtes-vous sur de vouloir supprimer cet artiste?", "Supprimer",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			
			((Album)tableAlbums.getSelectedItem()).removeFromDatabase();
			
			tableAlbums.removeItem(tableAlbums.getSelectedRow());
			
			tableAlbums.setSelectedItem(0);
		}
		
	}
	
	@Override
	public void actionRechercher(){
		
		if(getButtonRechercher().getText().equals(VIEW_OPERATIONS_RECHERCHER)){
			
			VuesOperationAlbum vue = new VuesOperationAlbum(database, this,
					VueAlbums.RECHERCHER, null);
			
			if(vue.hasConfirmed()){
				
				ArrayList<Object[]> liste = database.getAllContentWhere(
						Album.TABLE_NAME, vue.getColumnNames(),
						vue.getValues(), true);
				
				ArrayList<TableObject> albumsFound = Album.convertToArrayList(
						database, liste);
				
				objetsTable = albumsFound;
				
				tableAlbums.setObjects(albumsFound);
				
				getButtonRechercher().setText(
						VIEW_OPERATIONS_RECHERCHER_ANNULER);
				getButtonRechercher()
						.setFont(
								getButtonRechercher().getFont().deriveFont(
										Font.ITALIC));
				
				tableAlbums.setSelectedItem(0);
				
			}
			
		}
		else{
			
			restoreResearch();
			
			tableAlbums.setSelectedItem(0);
			
		}
		
	}
	
	private void restoreResearch(){
		
		objetsTable = Album.getAllAsArrayList(database);
		
		tableAlbums.setObjects(objetsTable);
		
		getButtonRechercher().setText(VIEW_OPERATIONS_RECHERCHER);
		getButtonRechercher().setFont(
				getButtonRechercher().getFont().deriveFont(Font.BOLD));
		
	}
	
	public SheetTable getTable(){
		return tableAlbums;
	}
	
}
