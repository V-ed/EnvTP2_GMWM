package graphics;

import javax.swing.*;

import objects.MySQLDatabase;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class ScreenVueArtistes extends JFrame {
	
	private JLabel labelNoArtisteSelected = new JLabel(
			"Veuillez s\u00E9lectionner un artiste!");
	
	ImageIcon imageArtiste = new ImageIcon();
	private JButton btnAjouter = new JButton("Ajouter");
	private JButton btnModifier = new JButton("Modifier");
	private JButton btnSupprimer = new JButton("Supprimer");
	private JButton btnRechercher = new JButton("Rechercher");
	private JButton btnQuitter = new JButton("Quitter");
	private final JLabel label = new JLabel("Num\u00E9ro :");
	private final JLabel label_1 = new JLabel("[dynamic]");
	private final JLabel label_2 = new JLabel("Nom :");
	private final JLabel label_3 = new JLabel("[dynamic]");
	private final JLabel label_4 = new JLabel(
			"Membre de l\u2019Association des artistes?");
	private final JCheckBox checkBox = new JCheckBox("");
	private final JButton button = new JButton("Albums");
	private final JLabel label_5 = new JLabel("test", SwingConstants.CENTER);
	
	private MySQLDatabase database;
	
	public ScreenVueArtistes(MySQLDatabase database){
		
		this.database = database;
		
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
			1.0, 1.0, Double.MIN_VALUE
		};
		gridBagLayout.rowWeights = new double[]
		{
			1.0, 1.0, Double.MIN_VALUE
		};
		getContentPane().setLayout(gridBagLayout);
		
		GridBagConstraints gbc_panelOperations = new GridBagConstraints();
		gbc_panelOperations.gridheight = 2;
		gbc_panelOperations.insets = new Insets(15, 15, 15, 15);
		gbc_panelOperations.fill = GridBagConstraints.BOTH;
		gbc_panelOperations.gridx = 0;
		gbc_panelOperations.gridy = 0;
		getContentPane().add(createOperationsPanel(), gbc_panelOperations);
		
		GridBagConstraints gbc_panelVueArtiste = new GridBagConstraints();
		gbc_panelVueArtiste.fill = GridBagConstraints.BOTH;
		gbc_panelVueArtiste.gridx = 1;
		gbc_panelVueArtiste.gridy = 0;
		getContentPane().add(createArtisteView(), gbc_panelVueArtiste);
		
		GridBagConstraints gbc_panelChoixArtiste = new GridBagConstraints();
		gbc_panelChoixArtiste.fill = GridBagConstraints.BOTH;
		gbc_panelChoixArtiste.gridx = 1;
		gbc_panelChoixArtiste.gridy = 1;
		getContentPane().add(createChoixArtisteView(), gbc_panelChoixArtiste);
		
		labelNoArtisteSelected.setHorizontalAlignment(SwingConstants.CENTER);
		labelNoArtisteSelected.setBounds(357, 70, 180, 29);
		
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
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.gridwidth = 2;
		gbc_label_5.gridheight = 3;
		gbc_label_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_5.gridx = 2;
		gbc_label_5.gridy = 0;
		panelAffichageArtiste.add(label_5, gbc_label_5);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panelAffichageArtiste.add(label, gbc_label);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		panelAffichageArtiste.add(label_1, gbc_label_1);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 3;
		panelAffichageArtiste.add(label_2, gbc_label_2);
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 3;
		panelAffichageArtiste.add(label_3, gbc_label_3);
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 0, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 5;
		panelAffichageArtiste.add(label_4, gbc_label_4);
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox.gridx = 1;
		gbc_checkBox.gridy = 5;
		panelAffichageArtiste.add(checkBox, gbc_checkBox);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 3;
		gbc_button.gridy = 5;
		panelAffichageArtiste.add(button, gbc_button);
		
		return panelAffichageArtiste;
		
	}
	
	private JPanel createChoixArtisteView(){
		
		JPanel panelChoixArtiste = new JPanel();
		
		
		
		return panelChoixArtiste;
		
	}
}
