package graphics;

import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import objects.MySQLDatabase;
import outils.ConstantesAffichage;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class VuesAjoutArtiste extends JDialog implements ConstantesAffichage{
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNom = new JLabel(VIEW_AJOUT_LABEL_NOM);
	private JLabel lblPrnom = new JLabel(VIEW_AJOUT_LABEL_PRENOM);
	private JLabel lblEstMembre = new JLabel(VIEW_AJOUT_LABEL_MEMBRE);
	private JLabel lblTemp = new JLabel(VIEW_AJOUT_LABEL_PATH);
	private JButton btnChooseFile = new JButton(VIEW_AJOUT_BOUTON_IMAGE);
	private JCheckBox chckbxNewCheckBox = new JCheckBox();
	private JButton btnNewButton = new JButton(VIEW_AJOUT_BOUTON_AJOUTER);
	private JButton btnAnnuler = new JButton(VIEW_AJOUT_BOUTON_ANNULER);
	
	public VuesAjoutArtiste(MySQLDatabase database, JDialog parentFrame) {
		super(parentFrame, true);
		
		setBounds(620, 320, 550, 300);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 87, 0, 87, 0, 0};
		gridBagLayout.rowHeights = new int[]{50, 50, 50, 60, 39, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		lblPrnom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPrnom = new GridBagConstraints();
		gbc_lblPrnom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrnom.gridx = 1;
		gbc_lblPrnom.gridy = 0;
		getContentPane().add(lblPrnom, gbc_lblPrnom);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblNom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 1;
		getContentPane().add(lblNom, gbc_lblNom);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 1;
		getContentPane().add(textField_1, gbc_textField_1);
		
		lblEstMembre.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblEstMembre = new GridBagConstraints();
		gbc_lblEstMembre.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstMembre.gridx = 1;
		gbc_lblEstMembre.gridy = 2;
		getContentPane().add(lblEstMembre, gbc_lblEstMembre);
		
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 2;
		getContentPane().add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		GridBagConstraints gbc_btnChooseFile = new GridBagConstraints();
		gbc_btnChooseFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnChooseFile.gridx = 1;
		gbc_btnChooseFile.gridy = 3;
		getContentPane().add(btnChooseFile, gbc_btnChooseFile);
		
		lblTemp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTemp = new GridBagConstraints();
		gbc_lblTemp.anchor = GridBagConstraints.WEST;
		gbc_lblTemp.gridwidth = 2;
		gbc_lblTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemp.gridx = 2;
		gbc_lblTemp.gridy = 3;
		getContentPane().add(lblTemp, gbc_lblTemp);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnuler.fill = GridBagConstraints.BOTH;
		gbc_btnAnnuler.gridx = 3;
		gbc_btnAnnuler.gridy = 4;
		getContentPane().add(btnAnnuler, gbc_btnAnnuler);
		
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		
		setVisible(true);
	}
	
}
