package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.rmi.CORBA.UtilDelegate;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.time.chrono.JapaneseDate;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class VueOperationAlbum extends JDialog {
	private JTextField textTitre;
	private JTextField textPrix;
	private JTextField textGenre;
	private JTextField text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VueOperationAlbum dialog = new VueOperationAlbum();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VueOperationAlbum() {
		setBounds(100, 100, 530, 532);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
			
			
		
			JLabel lblTitre = new JLabel("Titre :");
			lblTitre.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			GridBagConstraints gbc_lblTitre = new GridBagConstraints();
			gbc_lblTitre.anchor = GridBagConstraints.EAST;
			gbc_lblTitre.insets = new Insets(0, 0, 5, 5);
			gbc_lblTitre.gridx = 1;
			gbc_lblTitre.gridy = 1;
			getContentPane().add(lblTitre, gbc_lblTitre);
		
		
			textTitre = new JTextField();
			GridBagConstraints gbc_textTitre = new GridBagConstraints();
			gbc_textTitre.insets = new Insets(0, 0, 5, 5);
			gbc_textTitre.fill = GridBagConstraints.HORIZONTAL;
			gbc_textTitre.gridx = 2;
			gbc_textTitre.gridy = 1;
			getContentPane().add(textTitre, gbc_textTitre);
			textTitre.setColumns(10);
		
		
			JLabel lblPrix = new JLabel("Prix :");
			lblPrix.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			GridBagConstraints gbc_lblPrix = new GridBagConstraints();
			gbc_lblPrix.anchor = GridBagConstraints.EAST;
			gbc_lblPrix.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrix.gridx = 1;
			gbc_lblPrix.gridy = 3;
			getContentPane().add(lblPrix, gbc_lblPrix);
		
		
			textPrix = new JTextField();
			textPrix.setColumns(10);
			GridBagConstraints gbc_textPrix = new GridBagConstraints();
			gbc_textPrix.anchor = GridBagConstraints.WEST;
			gbc_textPrix.insets = new Insets(0, 0, 5, 5);
			gbc_textPrix.gridx = 2;
			gbc_textPrix.gridy = 3;
			getContentPane().add(textPrix, gbc_textPrix);
		
		
			JLabel lblGenre = new JLabel("Genre :");
			lblGenre.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			GridBagConstraints gbc_lblGenre = new GridBagConstraints();
			gbc_lblGenre.anchor = GridBagConstraints.EAST;
			gbc_lblGenre.insets = new Insets(0, 0, 5, 5);
			gbc_lblGenre.gridx = 1;
			gbc_lblGenre.gridy = 5;
			getContentPane().add(lblGenre, gbc_lblGenre);
		
		
			textGenre = new JTextField();
			textGenre.setColumns(10);
			GridBagConstraints gbc_textGenre = new GridBagConstraints();
			gbc_textGenre.insets = new Insets(0, 0, 5, 5);
			gbc_textGenre.fill = GridBagConstraints.HORIZONTAL;
			gbc_textGenre.gridx = 2;
			gbc_textGenre.gridy = 5;
			getContentPane().add(textGenre, gbc_textGenre);
		
		
			JLabel lblAnneDeSortie = new JLabel("Ann\u00E9e de Sortie :");
			lblAnneDeSortie.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			GridBagConstraints gbc_lblAnneDeSortie = new GridBagConstraints();
			gbc_lblAnneDeSortie.anchor = GridBagConstraints.EAST;
			gbc_lblAnneDeSortie.insets = new Insets(0, 0, 5, 5);
			gbc_lblAnneDeSortie.gridx = 1;
			gbc_lblAnneDeSortie.gridy = 7;
			getContentPane().add(lblAnneDeSortie, gbc_lblAnneDeSortie);
			
		
			JLabel lblMaisonDeDistribution = new JLabel("Maison de distribution :");
			lblMaisonDeDistribution.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			GridBagConstraints gbc_lblMaisonDeDistribution = new GridBagConstraints();
			gbc_lblMaisonDeDistribution.anchor = GridBagConstraints.EAST;
			gbc_lblMaisonDeDistribution.insets = new Insets(0, 0, 5, 5);
			gbc_lblMaisonDeDistribution.gridx = 1;
			gbc_lblMaisonDeDistribution.gridy = 9;
			getContentPane().add(lblMaisonDeDistribution, gbc_lblMaisonDeDistribution);
		
		
			text = new JTextField();
			text.setColumns(10);
			GridBagConstraints gbc_text = new GridBagConstraints();
			gbc_text.insets = new Insets(0, 0, 5, 5);
			gbc_text.fill = GridBagConstraints.HORIZONTAL;
			gbc_text.gridx = 2;
			gbc_text.gridy = 9;
			getContentPane().add(text, gbc_text);
		
		
			JLabel lblArtiste = new JLabel("Artiste :");
			lblArtiste.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			GridBagConstraints gbc_lblArtiste = new GridBagConstraints();
			gbc_lblArtiste.anchor = GridBagConstraints.EAST;
			gbc_lblArtiste.insets = new Insets(0, 0, 5, 5);
			gbc_lblArtiste.gridx = 1;
			gbc_lblArtiste.gridy = 11;
			getContentPane().add(lblArtiste, gbc_lblArtiste);
		
		
			JComboBox comboBox = new JComboBox();
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.gridwidth = 4;
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 2;
			gbc_comboBox.gridy = 11;
			getContentPane().add(comboBox, gbc_comboBox);
		
		
			JButton btnChoisirimage = new JButton("ChoisirImage");
			GridBagConstraints gbc_btnChoisirimage = new GridBagConstraints();
			gbc_btnChoisirimage.anchor = GridBagConstraints.EAST;
			gbc_btnChoisirimage.insets = new Insets(0, 0, 5, 5);
			gbc_btnChoisirimage.gridx = 1;
			gbc_btnChoisirimage.gridy = 13;
			getContentPane().add(btnChoisirimage, gbc_btnChoisirimage);
		
		
			JLabel lblPath = new JLabel("Path");
			lblPath.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			GridBagConstraints gbc_lblPath = new GridBagConstraints();
			gbc_lblPath.anchor = GridBagConstraints.WEST;
			gbc_lblPath.insets = new Insets(0, 0, 5, 5);
			gbc_lblPath.gridx = 2;
			gbc_lblPath.gridy = 13;
			getContentPane().add(lblPath, gbc_lblPath);
		
		
			JButton btnConfirmer = new JButton("Confirmer");
			GridBagConstraints gbc_btnConfirmer = new GridBagConstraints();
			gbc_btnConfirmer.fill = GridBagConstraints.BOTH;
			gbc_btnConfirmer.gridheight = 2;
			gbc_btnConfirmer.insets = new Insets(0, 0, 0, 5);
			gbc_btnConfirmer.gridx = 1;
			gbc_btnConfirmer.gridy = 15;
			getContentPane().add(btnConfirmer, gbc_btnConfirmer);
		
		
			JButton btnAnnuler = new JButton("Annuler");
			GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
			gbc_btnAnnuler.gridwidth = 5;
			gbc_btnAnnuler.gridheight = 2;
			gbc_btnAnnuler.fill = GridBagConstraints.BOTH;
			gbc_btnAnnuler.gridx = 3;
			gbc_btnAnnuler.gridy = 15;
			getContentPane().add(btnAnnuler, gbc_btnAnnuler);
		
	}

}
