package graphics;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import outils.OutilsFichiers;
import objects.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.util.ArrayList;

public class VueArtistes extends VuesItems {
	
	private ImageIcon imageArtiste;
	private JLabel labelArtisteNumero;
	private JTextField textArtisteNumero;
	private JLabel labelArtisteNom;
	private JTextField textArtisteNom;
	private JLabel labelArtisteEstMembre;
	private JCheckBox checkBoxArtisteEstMembre;
	private JButton buttonArtisteAlbums;
	private JLabel imageArtisteAffichage;
	
	private SheetTable tableArtistes;
	
	public VueArtistes(MySQLDatabase database, JFrame parentFrame){
		
		super(database, parentFrame, true);
		
		tableArtistes.setSelectedItem(0);
		
		setVisible(true);
		
	}
	
	private void updateArtiste(Artiste nouvelArtiste){
		
		textArtisteNumero.setText(String.valueOf(nouvelArtiste.getID()));
		textArtisteNom.setText(nouvelArtiste.getFullName());
		
		checkBoxArtisteEstMembre.setSelected(nouvelArtiste.isMembre());
		
		imageArtiste = OutilsFichiers.getImageFromFile(nouvelArtiste
				.getImagePath());
		
	}
	
	@Override
	protected JPanel createItemsView(){
		
		JPanel panelAffichageArtiste = new JPanel();
		
		GridBagLayout gbl_panelAffichageArtiste = new GridBagLayout();
		panelAffichageArtiste.setLayout(gbl_panelAffichageArtiste);
		
		imageArtiste = new ImageIcon();
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
		
		imageArtisteAffichage.setBorder(BorderFactory
				.createLineBorder(Color.BLACK));
		
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
		
		return panelAffichageArtiste;
		
	}
	
	@Override
	protected JPanel createChoixItemView(){
		
		JPanel panelChoixArtiste = new JPanel(new GridLayout());
		
		ArrayList<Object[]> listeObjets = database
				.getAllContentofTable(TABLE_NAME_ARTISTES);
		
		for(int i = 0; i < listeObjets.size(); i++){
			objetsTable.add(new Artiste(database, listeObjets.get(i)));
		}
		
		tableArtistes = new SheetTable(objetsTable, new String[]
		{
			"Numéro", "Nom", "Est membre"
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
			protected void actionOnSelect(){
				
				Artiste artisteSelectionne = (Artiste)getSelectedItem();
				
				updateArtiste(artisteSelectionne);
				
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
		
		DefaultTableCellRenderer idRenderer = new DefaultTableCellRenderer();
		idRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		idRenderer.setFont(idRenderer.getFont().deriveFont(Font.BOLD));
		
		tableArtistes.getTable().getColumnModel().getColumn(0)
				.setCellRenderer(idRenderer);
		
		panelChoixArtiste.add(tableArtistes.getScrollableTable());
		
		return panelChoixArtiste;
		
	}
	
	@Override
	public void actionAjouter(){
		
		new VuesAjoutArtiste(database, this);
		
		tableArtistes.fireTableDataChanged();
		
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
