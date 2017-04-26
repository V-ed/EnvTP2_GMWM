package graphics;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import objects.Artiste;
import objects.MySQLDatabase;
import outils.Constantes;
import outils.ConstantesAffichage;

public class VuesOperationArtiste extends JDialog implements Constantes,
		ConstantesAffichage {
	
	public final static int AJOUTER = 0;
	public final static int MODIFIER = 1;
	public final static int RECHERCHER = 2;
	
	private JTextField textNom;
	private JTextField textPrenom;
	private JLabel lblNom = new JLabel(VIEW_OPERATION_LABEL_NOM);
	private JLabel lblPrnom = new JLabel(VIEW_OPERATION_LABEL_PRENOM);
	private JLabel lblEstMembre = new JLabel(VIEW_OPERATION_LABEL_MEMBRE);
	private JLabel lblPath = new JLabel(VIEW_OPERATION_LABEL_PATH);
	private JButton btnChooseFile = new JButton(VIEW_OPERATION_BOUTON_IMAGE);
	private JCheckBox estMembre = new JCheckBox();
	private JButton btnConfirmer = new JButton();
	private JButton btnAnnuler = new JButton(VIEW_OPERATION_BOUTON_ANNULER);
	
	private boolean hasConfirmed = false;
	
	public VuesOperationArtiste(MySQLDatabase database, JDialog parentFrame,
			int typeOperation, Artiste artiste){
		
		super(parentFrame, true);
		
		setSize(550, 300);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{
			0, 87, 0, 87, 0, 0
		};
		gridBagLayout.rowHeights = new int[]
		{
			50, 50, 50, 60, 39, 0
		};
		gridBagLayout.columnWeights = new double[]
		{
			0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE
		};
		gridBagLayout.rowWeights = new double[]
		{
			0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE
		};
		
		gridBagLayout.columnWidths = new int[]
		{
			0, 87, 0, 87, 0, 0
		};
		gridBagLayout.rowHeights = new int[]
		{
			50, 50, 50, 60, 39, 0
		};
		gridBagLayout.columnWeights = new double[]
		{
			0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE
		};
		gridBagLayout.rowWeights = new double[]
		{
			0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE
		};
		
		getContentPane().setLayout(gridBagLayout);
		
		lblPrnom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPrnom = new GridBagConstraints();
		gbc_lblPrnom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrnom.gridx = 1;
		gbc_lblPrnom.gridy = 0;
		getContentPane().add(lblPrnom, gbc_lblPrnom);
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 0;
		getContentPane().add(textPrenom, gbc_textField_1);
		
		lblNom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 1;
		getContentPane().add(lblNom, gbc_lblNom);
		
		textNom = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		getContentPane().add(textNom, gbc_textField);
		textNom.setColumns(10);
		
		lblEstMembre.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblEstMembre = new GridBagConstraints();
		gbc_lblEstMembre.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstMembre.gridx = 1;
		gbc_lblEstMembre.gridy = 2;
		getContentPane().add(lblEstMembre, gbc_lblEstMembre);
		
		GridBagConstraints gbc_estMembre = new GridBagConstraints();
		gbc_estMembre.insets = new Insets(0, 0, 5, 5);
		gbc_estMembre.gridx = 2;
		gbc_estMembre.gridy = 2;
		getContentPane().add(estMembre, gbc_estMembre);
		
		GridBagConstraints gbc_btnChooseFile = new GridBagConstraints();
		gbc_btnChooseFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnChooseFile.gridx = 1;
		gbc_btnChooseFile.gridy = 3;
		getContentPane().add(btnChooseFile, gbc_btnChooseFile);
		
		lblPath.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPath = new GridBagConstraints();
		gbc_lblPath.anchor = GridBagConstraints.WEST;
		gbc_lblPath.gridwidth = 2;
		gbc_lblPath.insets = new Insets(0, 0, 5, 5);
		gbc_lblPath.gridx = 2;
		gbc_lblPath.gridy = 3;
		getContentPane().add(lblPath, gbc_lblPath);
		
		GridBagConstraints gbc_btnAjout = new GridBagConstraints();
		gbc_btnAjout.fill = GridBagConstraints.BOTH;
		gbc_btnAjout.insets = new Insets(0, 0, 0, 5);
		gbc_btnAjout.gridx = 1;
		gbc_btnAjout.gridy = 4;
		getContentPane().add(btnConfirmer, gbc_btnAjout);
		
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnuler.fill = GridBagConstraints.BOTH;
		gbc_btnAnnuler.gridx = 3;
		gbc_btnAnnuler.gridy = 4;
		getContentPane().add(btnAnnuler, gbc_btnAnnuler);
		
		btnAnnuler.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				dispose();
				
			}
		});
		
		btnChooseFile.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				String filePath = null;
				
				JFileChooser filechooser = new JFileChooser(FileSystemView
						.getFileSystemView().getHomeDirectory()
						.getAbsolutePath());
				filechooser.addChoosableFileFilter(new FileNameExtensionFilter(
						"Images", "jpg", "jpeg", "png", "gif", "bmp"));
				filechooser.setAcceptAllFileFilterUsed(false);
				
				if(filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					
					filePath = filechooser.getSelectedFile().getPath();
					
				}
				
				try{
					
					File file = new File(filePath);
					
					if(file.isFile()){
						lblPath.setText(filePath);
					}
					else{
						throw new Exception();
					}
					
				}
				catch(NullPointerException e1){
					
					lblPath.setText(VIEW_OPERATION_LABEL_PATH);
					
				}
				catch(Exception e2){
					
					JOptionPane.showConfirmDialog(null,
							"Le fichier n'existe pas", "Erreur",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		
		btnConfirmer.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				String nom = textNom.getText();
				
				String prenom = textPrenom.getText();
				
				try{
					if(!nom.matches("^[A-Z]([A-Za-z]|-)+$")
							&& !prenom.matches("^[A-Z]([A-Za-z]|-)+$")){
						
						throw new Exception(
								"Le nom et le prenom sont invalide. (lettres et \"-\" uniquement)");
						
					}
					else if(!nom.matches("^[A-Z]([A-Za-z]|-)+$")){
						
						throw new Exception(
								"Le nom est invalide. (lettres et \"-\" uniquement)");
						
					}
					else if(!prenom.matches("^[A-Z]([A-Za-z]|-)+$")){
						
						throw new Exception(
								"Le prenom est invalide. (lettres et \"-\" uniquement)");
						
					}
					
					switch(typeOperation){
					case AJOUTER:
						
						new Artiste(database, nom, prenom, estMembre
								.isSelected(), null).addToDatabase();
						
						dispose();
						
						break;
					
					case MODIFIER:
						
						artiste.modifyItem(nom, prenom, estMembre.isSelected(),
								null);
						
						dispose();
						
						break;
					
					case RECHERCHER:
						
						break;
					}
					
					hasConfirmed = true;
					
				}
				catch(Exception error){
					JOptionPane.showMessageDialog(null, error.getMessage());
				}
			}
		});
		
		switch(typeOperation){
		
		case AJOUTER:
			btnConfirmer.setText(VIEW_OPERATION_BOUTON_AJOUTER);
			setTitle("Ajout d'un artiste");
			break;
		
		case MODIFIER:
			btnConfirmer.setText(VIEW_OPERATION_BOUTON_MODIFIER);
			setTitle("Modification d'un artiste");
			setDefaultText(artiste);
			break;
		
		case RECHERCHER:
			btnConfirmer.setText(VIEW_OPERATION_BOUTON_RECHERCHER);
			setTitle("Recherche d'un artiste");
			break;
		}
		
		setVisible(true);
	}
	
	public void setDefaultText(Artiste artiste){
		
		textNom.setText(artiste.getNom());
		
		textPrenom.setText(artiste.getPrenom());
		
		this.estMembre.setSelected(artiste.isMembre());
		
		lblPath.setText(artiste.getImagePath());
		
	}
	
	public boolean hasConfirmed(){
		return hasConfirmed;
	}
	
}
