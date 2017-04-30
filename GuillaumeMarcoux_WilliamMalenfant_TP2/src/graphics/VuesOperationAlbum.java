package graphics;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import outils.*;
import objects.Album;
import objects.Artiste;
import objects.DatePicker;
import objects.MySQLDatabase;
import objects.TableObject;

public class VuesOperationAlbum extends JDialog implements Constantes,
		ConstantesAffichage {
	
	private JTextField textTitre;
	private JTextField textPrix;
	private JTextField textGenre;
	private DatePicker datePicker;
	private JTextField textMaison;
	private JComboBox<Artiste> comboBox;
	private JLabel lblPath;
	private ArrayList<TableObject> listArtistes;
	
	private boolean hasConfirmed = false;
	
	private String[] columnNames;
	private Object[] values;
	
	public VuesOperationAlbum(MySQLDatabase database, VueAlbums vueAlbum,
			int typeOperation, Album album){
		
		super(vueAlbum, true);
		
		listArtistes = Artiste.getAllAsArrayList(database);
		
		setSize(530, 532);
		setLocationRelativeTo(vueAlbum);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{
			25, 73, 200, 37, 0
		};
		gridBagLayout.rowHeights = new int[]
		{
			10, 57, 64, 53, 52, 55, 56, 79, 48, 10, 0
		};
		gridBagLayout.columnWeights = new double[]
		{
			0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE
		};
		gridBagLayout.rowWeights = new double[]
		{
			0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE
		};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblTitre = new JLabel(VIEW_OPERATION_ALBUM_LABEL_TITLE);
		lblTitre.setFont(new Font(FONT_USED, Font.PLAIN, 16));
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
		
		JLabel lblPrix = new JLabel(VIEW_OPERATION_ALBUM_LABEL_PRICE);
		lblPrix.setFont(new Font(FONT_USED, Font.PLAIN, 16));
		GridBagConstraints gbc_lblPrix = new GridBagConstraints();
		gbc_lblPrix.anchor = GridBagConstraints.EAST;
		gbc_lblPrix.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrix.gridx = 1;
		gbc_lblPrix.gridy = 2;
		getContentPane().add(lblPrix, gbc_lblPrix);
		
		textPrix = new JFormattedTextField(new Double(0));
		textPrix.setColumns(10);
		GridBagConstraints gbc_textPrix = new GridBagConstraints();
		gbc_textPrix.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPrix.insets = new Insets(0, 0, 5, 5);
		gbc_textPrix.gridx = 2;
		gbc_textPrix.gridy = 2;
		getContentPane().add(textPrix, gbc_textPrix);
		
		JLabel lblGenre = new JLabel(VIEW_OPERATION_ALBUM_LABEL_GENRE);
		lblGenre.setFont(new Font(FONT_USED, Font.PLAIN, 16));
		GridBagConstraints gbc_lblGenre = new GridBagConstraints();
		gbc_lblGenre.anchor = GridBagConstraints.EAST;
		gbc_lblGenre.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenre.gridx = 1;
		gbc_lblGenre.gridy = 3;
		getContentPane().add(lblGenre, gbc_lblGenre);
		
		textGenre = new JTextField();
		textGenre.setColumns(10);
		GridBagConstraints gbc_textGenre = new GridBagConstraints();
		gbc_textGenre.insets = new Insets(0, 0, 5, 5);
		gbc_textGenre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textGenre.gridx = 2;
		gbc_textGenre.gridy = 3;
		getContentPane().add(textGenre, gbc_textGenre);
		
		JLabel lblAnneDeSortie = new JLabel(VIEW_OPERATION_ALBUM_LABEL_ANNEE);
		lblAnneDeSortie.setFont(new Font(FONT_USED, Font.PLAIN, 16));
		GridBagConstraints gbc_lblAnneDeSortie = new GridBagConstraints();
		gbc_lblAnneDeSortie.anchor = GridBagConstraints.EAST;
		gbc_lblAnneDeSortie.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnneDeSortie.gridx = 1;
		gbc_lblAnneDeSortie.gridy = 4;
		getContentPane().add(lblAnneDeSortie, gbc_lblAnneDeSortie);
		
		datePicker = new DatePicker();
		GridBagConstraints gbc_datePicker = new GridBagConstraints();
		gbc_datePicker.fill = GridBagConstraints.HORIZONTAL;
		gbc_datePicker.insets = new Insets(0, 0, 5, 5);
		gbc_datePicker.gridx = 2;
		gbc_datePicker.gridy = 4;
		getContentPane().add(datePicker.getInterface(), gbc_datePicker);
		
		JLabel lblMaisonDeDistribution = new JLabel(
				VIEW_OPERATION_ALBUM_LABEL_MAISON);
		lblMaisonDeDistribution.setFont(new Font(FONT_USED, Font.PLAIN, 16));
		GridBagConstraints gbc_lblMaisonDeDistribution = new GridBagConstraints();
		gbc_lblMaisonDeDistribution.anchor = GridBagConstraints.EAST;
		gbc_lblMaisonDeDistribution.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaisonDeDistribution.gridx = 1;
		gbc_lblMaisonDeDistribution.gridy = 5;
		getContentPane().add(lblMaisonDeDistribution,
				gbc_lblMaisonDeDistribution);
		
		textMaison = new JTextField();
		textMaison.setColumns(10);
		GridBagConstraints gbc_textMaison = new GridBagConstraints();
		gbc_textMaison.insets = new Insets(0, 0, 5, 5);
		gbc_textMaison.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMaison.gridx = 2;
		gbc_textMaison.gridy = 5;
		getContentPane().add(textMaison, gbc_textMaison);
		
		JLabel lblArtiste = new JLabel(VIEW_OPERATION_ALBUM_LABEL_ARTISTE);
		lblArtiste.setFont(new Font(FONT_USED, Font.PLAIN, 16));
		GridBagConstraints gbc_lblArtiste = new GridBagConstraints();
		gbc_lblArtiste.anchor = GridBagConstraints.EAST;
		gbc_lblArtiste.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtiste.gridx = 1;
		gbc_lblArtiste.gridy = 6;
		getContentPane().add(lblArtiste, gbc_lblArtiste);
		
		comboBox = new JComboBox<Artiste>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 6;
		getContentPane().add(comboBox, gbc_comboBox);
		
		if(typeOperation == RECHERCHER)
			comboBox.addItem(null);
		for(int i = 0; i < listArtistes.size(); i++){
			comboBox.addItem((Artiste)listArtistes.get(i));
		}
		
		JButton btnChooseFile = new JButton("Choisir Image");
		GridBagConstraints gbc_btnChooseFile = new GridBagConstraints();
		gbc_btnChooseFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChooseFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnChooseFile.gridx = 1;
		gbc_btnChooseFile.gridy = 7;
		getContentPane().add(btnChooseFile, gbc_btnChooseFile);
		
		lblPath = new JLabel(VIEW_OPERATION_COMMON_LABEL_NO_PATH);
		lblPath.setFont(new Font(FONT_USED, Font.PLAIN, 16));
		GridBagConstraints gbc_lblPath = new GridBagConstraints();
		gbc_lblPath.anchor = GridBagConstraints.WEST;
		gbc_lblPath.insets = new Insets(0, 0, 5, 5);
		gbc_lblPath.gridx = 2;
		gbc_lblPath.gridy = 7;
		getContentPane().add(lblPath, gbc_lblPath);
		
		JButton btnConfirmer = new JButton();
		GridBagConstraints gbc_btnConfirmer = new GridBagConstraints();
		gbc_btnConfirmer.fill = GridBagConstraints.BOTH;
		gbc_btnConfirmer.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirmer.gridx = 1;
		gbc_btnConfirmer.gridy = 8;
		getContentPane().add(btnConfirmer, gbc_btnConfirmer);
		
		btnConfirmer.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				String titre = textTitre.getText();
				
				double prix = -1;
				if(!textPrix.getText().isEmpty())
					prix = Double.parseDouble(textPrix.getText());
				
				String genre = textGenre.getText();
				
				Date annee = null;
				
				if(datePicker.isChanged())
					annee = datePicker.getDate();
				
				String maison = textMaison.getText();
				
				String filePath = null;
				
				String currentAlbumImage = lblPath.getText();
				
				if(!currentAlbumImage
						.equals(VIEW_OPERATION_COMMON_LABEL_NO_PATH)){
					
					if(album == null){
						
						filePath = OutilsFichiers
								.copyImageToProject(currentAlbumImage);
						
					}
					else{
						if(!currentAlbumImage.equals(album.getImagePath())){
							filePath = OutilsFichiers
									.copyImageToProject(currentAlbumImage);
						}
					}
					
				}
				
				Artiste artiste = (Artiste)comboBox.getSelectedItem();
				
				try{
					
					if(typeOperation != RECHERCHER){
						
						if(!titre.matches(REGEX_TITRE)
								&& !genre.matches(REGEX_GENRE)
								&& !maison.matches(REGEX_MAISON)){
							
							throw new Exception(ERROR_INVALID_FIELDS);
							
						}
						else if(!titre.matches(REGEX_TITRE)){
							
							throw new Exception(ERROR_INVALID_TITRE);
							
						}
						else if(!genre.matches(REGEX_GENRE)){
							
							throw new Exception(ERROR_INVALID_GENRE);
							
						}
						else if(!maison.matches(REGEX_MAISON)){
							
							throw new Exception(ERROR_INVALID_MAISON);
							
						}
						else if(!datePicker.isChanged()){
							
							throw new Exception(ERROR_INVALID_DATE);
							
						}
						
					}
					
					switch(typeOperation){
					case AJOUTER:
						
						Album nouvAlbum = new Album(database, titre, prix,
								genre, annee, maison, filePath, artiste);
						
						// TODO Do not add the Album if the new Album already exists in the database.
						
						vueAlbum.getTable().addItem(nouvAlbum);
						
						nouvAlbum.addToDatabase();
						
						break;
					
					case MODIFIER:
						
						album.modifyItem(titre, prix, genre, annee, maison,
								filePath, artiste.getID());
						
						break;
					
					case RECHERCHER:
						
						ArrayList<String> columnList = new ArrayList<>();
						ArrayList<Object> valuesList = new ArrayList<>();
						
						if(!titre.isEmpty()){
							columnList
									.add(Album.COLUMN_NAMES[Album.COLUMN_TITLE]);
							valuesList.add(titre);
						}
						
						if(prix != -1){
							columnList
									.add(Album.COLUMN_NAMES[Album.COLUMN_PRICE]);
							valuesList.add(prix);
						}
						
						if(!genre.isEmpty()){
							columnList
									.add(Album.COLUMN_NAMES[Album.COLUMN_GENRE]);
							valuesList.add(genre);
						}
						
						if(annee != null){
							columnList
									.add(Album.COLUMN_NAMES[Album.COLUMN_RELEASE_DATE]);
							valuesList.add(annee);
						}
						
						if(!maison.isEmpty()){
							columnList
									.add(Album.COLUMN_NAMES[Album.COLUMN_DISTRIBUTION]);
							valuesList.add(maison);
						}
						
						if(filePath != null){
							columnList
									.add(Album.COLUMN_NAMES[Album.COLUMN_IMAGE_URL]);
							valuesList.add(filePath);
						}
						
						if(artiste != null){
							columnList
									.add(Album.COLUMN_NAMES[Album.COLUMN_ARTIST]);
							valuesList.add(artiste.getID());
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
		
		JButton btnAnnuler = new JButton(VIEW_OPERATION_COMMON_BOUTON_ANNULER);
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnuler.fill = GridBagConstraints.VERTICAL;
		gbc_btnAnnuler.gridx = 2;
		gbc_btnAnnuler.gridy = 8;
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
						PROJECT_IMAGES_FOLDER_NAME, POSSIBLE_EXTENSIONS));
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
		
		switch(typeOperation){
		
		case AJOUTER:
			btnConfirmer.setText(VIEW_OPERATIONS_AJOUTER);
			setTitle(TITLE_AJOUT_ARTISTE + " - " + TITLE_PROJECT);
			break;
		
		case MODIFIER:
			btnConfirmer.setText(VIEW_OPERATIONS_MODIFIER);
			setTitle(TITLE_MODIF_ARTISTE + " - " + TITLE_PROJECT);
			setDefaultText(album);
			break;
		
		case RECHERCHER:
			btnConfirmer.setText(VIEW_OPERATIONS_RECHERCHER);
			setTitle(TITLE_RECHERCHE_ARTISTE + " - " + TITLE_PROJECT);
			break;
		}
		
		setVisible(true);
		
	}
	
	public void setDefaultText(Album album){
		
		textTitre.setText(album.getTitre());
		
		textPrix.setText(String.valueOf(album.getPrix()));
		
		textGenre.setText(album.getGenre());
		
		textMaison.setText(album.getMaisonDistribution());
		
		Calendar date = Calendar.getInstance();
		
		date.setTime(album.getAnneeSortie());
		
		datePicker.setDate(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
				date.get(Calendar.DAY_OF_MONTH));
		
		comboBox.setSelectedItem(album.getArtiste());
		
		lblPath.setText(album.getImagePath());
		
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