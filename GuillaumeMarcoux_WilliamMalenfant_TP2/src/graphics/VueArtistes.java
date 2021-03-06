package graphics;

import javax.swing.*;

import outils.OutilsFichiers;
import objects.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueArtistes extends VuesItems {
	
	private JLabel labelArtisteNumero;
	private JTextField textArtisteNumero;
	private JLabel labelArtisteNom;
	private JTextField textArtisteNom;
	private JLabel labelArtisteEstMembre;
	private JCheckBox checkBoxArtisteEstMembre;
	private JButton buttonArtisteAlbums;
	
	private ImagePanel imageArtisteAffichage;
	
	private SheetTable tableArtistes;
	
	public VueArtistes(MySQLDatabase database, JFrame parentFrame){
		
		super(database, parentFrame, true);
		
		setTitle(TITLE_VUE_ARTISTES + " - " + TITLE_PROJECT);
		
		tableArtistes.setSelectedItem(0);
		
		setVisible(true);
		
	}
	
	private void updateArtiste(Artiste nouvelArtiste){
		
		if(nouvelArtiste == null){
			
			textArtisteNumero.setText(String.valueOf(""));
			textArtisteNom.setText("");
			
			checkBoxArtisteEstMembre.setSelected(false);
			
			imageArtisteAffichage.repaint();
			
		}
		else{
			
			textArtisteNumero.setText(String.valueOf(nouvelArtiste.getID()));
			textArtisteNom.setText(nouvelArtiste.getFullName());
			
			checkBoxArtisteEstMembre.setSelected(nouvelArtiste.isMembre());
			
			imageArtisteAffichage.setImageArtiste(OutilsFichiers
					.getBufferedImageFromProject(DOSSIER_ARTISTES + "\\"
							+ nouvelArtiste.getImagePath()));
			
			imageArtisteAffichage.repaint();
			
		}
		
	}
	
	@Override
	protected JPanel createItemsView(){
		
		JPanel panelAffichageArtiste = new JPanel();
		
		GridBagLayout gbl_panelAffichageArtiste = new GridBagLayout();
		panelAffichageArtiste.setLayout(gbl_panelAffichageArtiste);
		
		labelArtisteNumero = new JLabel(VIEW_ARTISTE_LABEL_NUMERO);
		textArtisteNumero = new JTextField();
		labelArtisteNom = new JLabel(VIEW_ARTISTE_LABEL_NOM);
		textArtisteNom = new JTextField();
		labelArtisteEstMembre = new JLabel(VIEW_ARTISTE_LABEL_EST_MEMBRE);
		checkBoxArtisteEstMembre = new JCheckBox("");
		buttonArtisteAlbums = new JButton(VIEW_ARTISTE_BUTTON_ALBUMS);
		
		imageArtisteAffichage = new ImagePanel(
				OutilsFichiers.getImageFromResources(IMAGE_NO_IMAGE));
		
		buttonArtisteAlbums.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
				new VueAlbums(database, (JFrame)VueArtistes.this.getParent(),
						(Artiste)tableArtistes.getSelectedItem())
						.setVisible(true);
				
			}
		});
		
		GridBagConstraints gbc_labelArtisteNumero = new GridBagConstraints();
		gbc_labelArtisteNumero.weighty = 1.0;
		gbc_labelArtisteNumero.weightx = 0;
		gbc_labelArtisteNumero.gridx = 0;
		gbc_labelArtisteNumero.gridy = 1;
		panelAffichageArtiste.add(labelArtisteNumero, gbc_labelArtisteNumero);
		
		GridBagConstraints gbc_textArtisteNumero = new GridBagConstraints();
		gbc_textArtisteNumero.weighty = 1.0;
		gbc_textArtisteNumero.weightx = 1.0;
		gbc_textArtisteNumero.gridx = 1;
		gbc_textArtisteNumero.gridy = 1;
		gbc_textArtisteNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textArtisteNumero.insets = new Insets(0, 10, 0, 15);
		textArtisteNumero.setEditable(false);
		textArtisteNumero.setBackground(Color.WHITE);
		panelAffichageArtiste.add(textArtisteNumero, gbc_textArtisteNumero);
		
		GridBagConstraints gbc_labelArtisteNom = new GridBagConstraints();
		gbc_labelArtisteNom.weighty = 1.0;
		gbc_labelArtisteNom.weightx = 0;
		gbc_labelArtisteNom.gridx = 0;
		gbc_labelArtisteNom.gridy = 4;
		panelAffichageArtiste.add(labelArtisteNom, gbc_labelArtisteNom);
		
		GridBagConstraints gbc_textArtisteNom = new GridBagConstraints();
		gbc_textArtisteNom.weighty = 1.0;
		gbc_textArtisteNom.weightx = 1.0;
		gbc_textArtisteNom.gridx = 1;
		gbc_textArtisteNom.gridy = 4;
		gbc_textArtisteNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textArtisteNom.insets = new Insets(0, 10, 0, 15);
		textArtisteNom.setEditable(false);
		textArtisteNom.setBackground(Color.WHITE);
		panelAffichageArtiste.add(textArtisteNom, gbc_textArtisteNom);
		
		GridBagConstraints gbc_labelArtisteEstMembre = new GridBagConstraints();
		gbc_labelArtisteEstMembre.weighty = 1.0;
		gbc_labelArtisteEstMembre.weightx = 0;
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
		panelAffichageArtiste.add(imageArtisteAffichage,
				gbc_imageArtisteAffichage);
		
		GridBagConstraints gbc_checkBoxArtisteEstMembre = new GridBagConstraints();
		gbc_checkBoxArtisteEstMembre.weighty = 1.0;
		gbc_checkBoxArtisteEstMembre.weightx = 1.0;
		gbc_checkBoxArtisteEstMembre.gridx = 1;
		gbc_checkBoxArtisteEstMembre.gridy = 5;
		gbc_checkBoxArtisteEstMembre.anchor = GridBagConstraints.WEST;
		gbc_checkBoxArtisteEstMembre.insets = new Insets(0, 10, 0, 0);
		checkBoxArtisteEstMembre.setEnabled(false);
		panelAffichageArtiste.add(checkBoxArtisteEstMembre,
				gbc_checkBoxArtisteEstMembre);
		
		GridBagConstraints gbc_buttonArtisteAlbums = new GridBagConstraints();
		gbc_buttonArtisteAlbums.fill = GridBagConstraints.BOTH;
		gbc_buttonArtisteAlbums.weighty = 1.0;
		gbc_buttonArtisteAlbums.weightx = 1.0;
		gbc_buttonArtisteAlbums.gridx = 2;
		gbc_buttonArtisteAlbums.gridy = 5;
		panelAffichageArtiste.add(buttonArtisteAlbums, gbc_buttonArtisteAlbums);
		buttonArtisteAlbums.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		return panelAffichageArtiste;
		
	}
	
	@Override
	protected JPanel createChoixItemView(){
		
		JPanel panelChoixArtiste = new JPanel(new GridLayout());
		
		objetsTable = Artiste.getAllAsArrayList(database);
		
		tableArtistes = new SheetTable(objetsTable, new String[]
		{
			"Num�ro", "Nom", "Est membre"
		}){
			
			@Override
			public Object getValueAt(int rowIndex, int columnIndex){
				
				Artiste artiste = (Artiste)objetsTable.get(rowIndex);
				
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
			protected void actionOnSelect(boolean hasSelection){
				
				Artiste artisteSelectionne = null;
				
				if(hasSelection)
					artisteSelectionne = (Artiste)getSelectedItem();
				
				updateArtiste(artisteSelectionne);
				
			}
			
			@Override
			protected void actionOnDoubleClick(){
				actionModifier();
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex){
				
				switch(columnIndex){
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return Boolean.class;
				default:
					throw new IllegalArgumentException(
							"Index de colonne invalide: " + columnIndex);
				}
				
			}
			
		};
		
		panelChoixArtiste.add(tableArtistes.getScrollableTable());
		
		return panelChoixArtiste;
		
	}
	
	@Override
	public void actionAjouter(){
		
		VuesOperationArtiste vue = new VuesOperationArtiste(database, this,
				VuesOperationArtiste.AJOUTER, null);
		
		if(vue.hasConfirmed()){
			
			restoreResearch();
			
			tableArtistes.setSelectedItem(tableArtistes.getRowCount() - 1);
			
		}
		
	}
	
	@Override
	public void actionModifier(){
		
		VuesOperationArtiste vue = new VuesOperationArtiste(database, this,
				VuesOperationArtiste.MODIFIER,
				(Artiste)tableArtistes.getSelectedItem());
		
		if(vue.hasConfirmed()){
			
			tableArtistes.fireTableDataChanged();
			
			tableArtistes.setSelectedItem(0);
			
		}
		
	}
	
	@Override
	public void actionSupprimer(){
		
		boolean peutContinuer = true;
		
		Artiste artisteASupprimer = (Artiste)tableArtistes.getSelectedItem();
		
		Object[] albumsID = database.getAllContentOfColumn(
				database.selectEverythingFrom(Album.TABLE_NAME),
				Album.COLUMN_NAMES[Album.COLUMN_ARTIST]);
		
		for(int i = 0; i < albumsID.length; i++){
			if(artisteASupprimer.getID() == Integer
					.parseInt((String)albumsID[i])){
				peutContinuer = false;
				break;
			}
		}
		
		if(!peutContinuer){
			JOptionPane.showMessageDialog(VueArtistes.this,
					ERROR_ARTISTE_LINKED_TO_ALBUMS, COMMON_ERROR,
					JOptionPane.ERROR_MESSAGE);
		}
		else if(JOptionPane.showConfirmDialog(this, CONFIRM_DELETE_ARTISTE,
				COMMON_DELETE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			
			artisteASupprimer.removeFromDatabase();
			
			tableArtistes.removeItem(tableArtistes.getSelectedRow());
			
			tableArtistes.setSelectedItem(0);
			
		}
		
	}
	
	@Override
	public void actionRechercher(){
		
		if(getButtonRechercher().getText().equals(VIEW_OPERATIONS_RECHERCHER)){
			
			VuesOperationArtiste vue = new VuesOperationArtiste(database, this,
					VuesOperationArtiste.RECHERCHER, null);
			
			if(vue.hasConfirmed()){
				
				ArrayList<TableObject> artistesFound = Artiste
						.convertToArrayList(database, database
								.getAllContentWhere(Artiste.TABLE_NAME,
										vue.getColumnNames(), vue.getValues(),
										false));
				
				objetsTable = artistesFound;
				
				tableArtistes.setObjects(artistesFound);
				
				getButtonRechercher().setText(
						VIEW_OPERATIONS_RECHERCHER_ANNULER);
				getButtonRechercher()
						.setFont(
								getButtonRechercher().getFont().deriveFont(
										Font.ITALIC));
				
				tableArtistes.setSelectedItem(0);
				
			}
			
		}
		else{
			
			restoreResearch();
			
			tableArtistes.setSelectedItem(0);
			
		}
		
	}
	
	private void restoreResearch(){
		
		objetsTable = Artiste.getAllAsArrayList(database);
		
		tableArtistes.setObjects(objetsTable);
		
		getButtonRechercher().setText(VIEW_OPERATIONS_RECHERCHER);
		getButtonRechercher().setFont(
				getButtonRechercher().getFont().deriveFont(Font.BOLD));
		
	}
	
	public SheetTable getTable(){
		return tableArtistes;
	}
	
}
