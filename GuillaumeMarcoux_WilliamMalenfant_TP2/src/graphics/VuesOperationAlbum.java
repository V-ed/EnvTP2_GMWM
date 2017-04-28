package graphics;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import org.jdatepicker.impl.*;

import outils.Constantes;
import outils.ConstantesAffichage;
import objects.Album;
import objects.Artiste;
import objects.MySQLDatabase;

public class VuesOperationAlbum extends JDialog implements Constantes,
		ConstantesAffichage {
	
	private JTextField textTitre;
	private JTextField textPrix;
	private JTextField textGenre;
	private JTextField text;
	
	public VuesOperationAlbum(MySQLDatabase database, VueAlbums vueAlbum,
			int typeOperation, Album album){
		
		super(vueAlbum, true);
		
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
		
		textPrix = new JTextField();
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
		
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,
				new AbstractFormatter(){
					
					private String datePattern = "yyyy-MM-dd";
					private SimpleDateFormat dateFormatter = new SimpleDateFormat(
							datePattern);
					
					@Override
					public Object stringToValue(String text)
							throws ParseException{
						return dateFormatter.parseObject(text);
					}
					
					@Override
					public String valueToString(Object value)
							throws ParseException{
						if(value != null){
							Calendar cal = (Calendar)value;
							return dateFormatter.format(cal.getTime());
						}
						
						return "";
					}
					
				});
		GridBagConstraints gbc_datePicker = new GridBagConstraints();
		gbc_datePicker.fill = GridBagConstraints.HORIZONTAL;
		gbc_datePicker.insets = new Insets(0, 0, 5, 5);
		gbc_datePicker.gridx = 2;
		gbc_datePicker.gridy = 4;
		getContentPane().add(datePicker, gbc_datePicker);
		
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
		
		text = new JTextField();
		text.setColumns(10);
		GridBagConstraints gbc_text = new GridBagConstraints();
		gbc_text.insets = new Insets(0, 0, 5, 5);
		gbc_text.fill = GridBagConstraints.HORIZONTAL;
		gbc_text.gridx = 2;
		gbc_text.gridy = 5;
		getContentPane().add(text, gbc_text);
		
		JLabel lblArtiste = new JLabel(VIEW_OPERATION_ALBUM_LABEL_ARTISTE);
		lblArtiste.setFont(new Font(FONT_USED, Font.PLAIN, 16));
		GridBagConstraints gbc_lblArtiste = new GridBagConstraints();
		gbc_lblArtiste.anchor = GridBagConstraints.EAST;
		gbc_lblArtiste.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtiste.gridx = 1;
		gbc_lblArtiste.gridy = 6;
		getContentPane().add(lblArtiste, gbc_lblArtiste);
		
		JComboBox<Artiste> comboBox = new JComboBox<Artiste>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 6;
		getContentPane().add(comboBox, gbc_comboBox);
		
		JButton btnChooseFile = new JButton("Choisir Image");
		GridBagConstraints gbc_btnChooseFile = new GridBagConstraints();
		gbc_btnChooseFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChooseFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnChooseFile.gridx = 1;
		gbc_btnChooseFile.gridy = 7;
		getContentPane().add(btnChooseFile, gbc_btnChooseFile);
		
		JLabel lblPath = new JLabel("Path");
		lblPath.setFont(new Font(FONT_USED, Font.PLAIN, 16));
		GridBagConstraints gbc_lblPath = new GridBagConstraints();
		gbc_lblPath.anchor = GridBagConstraints.WEST;
		gbc_lblPath.insets = new Insets(0, 0, 5, 5);
		gbc_lblPath.gridx = 2;
		gbc_lblPath.gridy = 7;
		getContentPane().add(lblPath, gbc_lblPath);
		
		JButton btnConfirmer = new JButton("Confirmer");
		GridBagConstraints gbc_btnConfirmer = new GridBagConstraints();
		gbc_btnConfirmer.fill = GridBagConstraints.BOTH;
		gbc_btnConfirmer.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirmer.gridx = 1;
		gbc_btnConfirmer.gridy = 8;
		getContentPane().add(btnConfirmer, gbc_btnConfirmer);
		
		btnConfirmer.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				
			}
			
		});
		
		JButton btnAnnuler = new JButton("Annuler");
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
				
			}
		});
		
		setVisible(true);
		
	}
	
}
