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
import java.util.ArrayList;

import objects.Artiste;
import objects.MySQLDatabase;
import outils.*;

public class VuesOperationArtiste extends JDialog implements Constantes,
		ConstantesAffichage {
	
	private JTextField textNom;
	private JTextField textPrenom;
	private JLabel lblNom = new JLabel(VIEW_OPERATION_ARTISTE_LABEL_NOM);
	private JLabel lblPrnom = new JLabel(VIEW_OPERATION_ARTISTE_LABEL_PRENOM);
	private JLabel lblEstMembre = new JLabel(
			VIEW_OPERATION_ARTISTE_LABEL_MEMBRE);
	private JLabel lblPath = new JLabel(VIEW_OPERATION_COMMON_LABEL_NO_PATH);
	private JButton btnChooseFile = new JButton(
			VIEW_OPERATION_COMMON_BOUTON_IMAGE);
	private JCheckBox estMembre = new JCheckBox();
	private JButton btnConfirmer = new JButton();
	private JButton btnAnnuler = new JButton(
			VIEW_OPERATION_COMMON_BOUTON_ANNULER);
	
	private boolean hasConfirmed = false;
	
	private String[] columnNames;
	private Object[] values;
	
	public VuesOperationArtiste(MySQLDatabase database, VueArtistes vueArtiste,
			int typeOperation, Artiste artiste){
		
		super(vueArtiste, true);
		
		setSize(550, 300);
		setLocationRelativeTo(vueArtiste);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
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
		
		lblPrnom.setFont(new Font(FONT_USED, Font.PLAIN, 16));
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
		
		lblNom.setFont(new Font(FONT_USED, Font.PLAIN, 16));
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
		
		lblEstMembre.setFont(new Font(FONT_USED, Font.PLAIN, 16));
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
		
		lblPath.setFont(new Font(FONT_USED, Font.PLAIN, 16));
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
						"Images", POSSIBLE_EXTENSIONS));
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
					
					lblPath.setText(VIEW_OPERATION_COMMON_LABEL_NO_PATH);
					
				}
				catch(Exception e2){
					
					JOptionPane.showConfirmDialog(null, ERROR_FILE_NOT_EXIST,
							COMMON_ERROR, JOptionPane.DEFAULT_OPTION,
							JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		
		btnConfirmer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
				String nom = textNom.getText();
				
				String prenom = textPrenom.getText();
				
				String filePath = null;
				
				String currentArtisteImage = lblPath.getText();
				
				if(!currentArtisteImage
						.equals(VIEW_OPERATION_COMMON_LABEL_NO_PATH)){
					
					if(artiste == null){
						
						filePath = OutilsFichiers
								.copyImageToProject(currentArtisteImage);
						
					}
					else{
						if(!currentArtisteImage.equals(artiste.getImagePath())){
							filePath = OutilsFichiers
									.copyImageToProject(currentArtisteImage);
						}
					}
					
				}
				
				try{
					if(typeOperation != RECHERCHER){
						
						if(!nom.matches(REGEX_NAME)
								&& !prenom.matches(REGEX_NAME)){
							
							throw new Exception(ERROR_INVALID_NOM_PRENOM);
							
						}
						else if(!nom.matches(REGEX_NAME)){
							
							throw new Exception(ERROR_INVALID_NOM);
							
						}
						else if(!prenom.matches(REGEX_NAME)){
							
							throw new Exception(ERROR_INVALID_PRENOM);
							
						}
						
					}
					
					switch(typeOperation){
					case AJOUTER:
						
						Artiste nouvArtiste = new Artiste(database, nom,
								prenom, estMembre.isSelected(), filePath);
						
						// TODO Don't add the current Artiste if it already exists in the database.
						
						database.selectEverythingFrom(Artiste.TABLE_NAME);
						
						vueArtiste.getTable().addItem(nouvArtiste);
						
						nouvArtiste.addToDatabase();
						
						break;
					
					case MODIFIER:
						
						artiste.modifyItem(nom, prenom, estMembre.isSelected(),
								filePath);
						
						break;
					
					case RECHERCHER:
						
						ArrayList<String> columnList = new ArrayList<>();
						ArrayList<Object> valuesList = new ArrayList<>();
						
						if(!nom.isEmpty()){
							columnList
									.add(Artiste.COLUMN_NAMES[Artiste.COLUMN_LAST_NAME]);
							valuesList.add(nom);
						}
						if(!prenom.isEmpty()){
							columnList
									.add(Artiste.COLUMN_NAMES[Artiste.COLUMN_FIRST_NAME]);
							valuesList.add(prenom);
						}
						columnList
								.add(Artiste.COLUMN_NAMES[Artiste.COLUMN_IS_MEMBER]);
						valuesList.add(estMembre.isSelected());
						if(filePath != null){
							columnList
									.add(Artiste.COLUMN_NAMES[Artiste.COLUMN_IMAGE_URL]);
							valuesList.add(filePath);
						}
						
						columnNames = columnList.toArray(new String[columnList
								.size()]);
						values = valuesList.toArray();
						
						break;
					}
					
					hasConfirmed = true;
					
					dispose();
					
				}
				catch(Exception error){
					JOptionPane.showMessageDialog(null, error.getMessage());
				}
				
			}
		});
		
		switch(typeOperation){
		
		case AJOUTER:
			btnConfirmer.setText(VIEW_OPERATIONS_AJOUTER);
			setTitle(TITLE_AJOUT_ARTISTE + " - " + TITLE_PROJECT);
			break;
		
		case MODIFIER:
			btnConfirmer.setText(VIEW_OPERATIONS_MODIFIER);
			setTitle(TITLE_MODIF_ARTISTE + " - " + TITLE_PROJECT);
			setDefaultText(artiste);
			break;
		
		case RECHERCHER:
			btnConfirmer.setText(VIEW_OPERATIONS_RECHERCHER);
			setTitle(TITLE_RECHERCHE_ARTISTE + " - " + TITLE_PROJECT);
			break;
		}
		
		setVisible(true);
		
	}
	
	public void setDefaultText(Artiste artiste){
		
		textNom.setText(artiste.getNom());
		
		textPrenom.setText(artiste.getPrenom());
		
		this.estMembre.setSelected(artiste.isMembre());
		
		if(artiste.getImagePath() == null)
			lblPath.setText(VIEW_OPERATION_COMMON_LABEL_NO_PATH);
		else
			lblPath.setText(artiste.getImagePath());
		
	}
	
	public boolean hasConfirmed(){
		return hasConfirmed;
	}
	
	public String[] getColumnNames(){
		return columnNames;
	}
	
	public Object[] getValues(){
		return values;
	}
	
}
