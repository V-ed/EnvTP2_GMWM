package graphics;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import objects.MySQLDatabase;
import objects.TableObject;
import outils.*;

public abstract class VuesItems extends JDialog implements Constantes,
		ConstantesAffichage {
	
	protected MySQLDatabase database;
	protected ArrayList<TableObject> objetsTable = new ArrayList<>();
	
	public VuesItems(MySQLDatabase database, JFrame parentFrame, boolean isModal){
		
		super(parentFrame, isModal);
		
		setSize(900, 500);
		setLocationRelativeTo(parentFrame);
		
		this.database = database;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{
			138, 341, 0
		};
		gridBagLayout.rowHeights = new int[]
		{
			158, 177, 0
		};
		gridBagLayout.columnWeights = new double[]
		{
			0.0, 1.0, Double.MIN_VALUE
		};
		gridBagLayout.rowWeights = new double[]
		{
			1.0, 1.0, Double.MIN_VALUE
		};
		getContentPane().setLayout(gridBagLayout);
		
		GridBagConstraints gbc_panelOperations = new GridBagConstraints();
		gbc_panelOperations.weighty = 1.0;
		gbc_panelOperations.gridheight = 2;
		gbc_panelOperations.insets = new Insets(15, 15, 15, 15);
		gbc_panelOperations.fill = GridBagConstraints.BOTH;
		gbc_panelOperations.gridx = 0;
		gbc_panelOperations.gridy = 0;
		getContentPane().add(createOperationsPanel(), gbc_panelOperations);
		
		GridBagConstraints gbc_panelVueAlbum = new GridBagConstraints();
		gbc_panelVueAlbum.insets = new Insets(5, 5, 5, 5);
		gbc_panelVueAlbum.fill = GridBagConstraints.BOTH;
		gbc_panelVueAlbum.gridx = 1;
		gbc_panelVueAlbum.gridy = 0;
		getContentPane().add(createItemsView(), gbc_panelVueAlbum);
		
		GridBagConstraints gbc_panelChoixArtiste = new GridBagConstraints();
		gbc_panelChoixArtiste.insets = new Insets(5, 5, 5, 5);
		gbc_panelChoixArtiste.weighty = 1.0;
		gbc_panelChoixArtiste.weightx = 1.0;
		gbc_panelChoixArtiste.fill = GridBagConstraints.BOTH;
		gbc_panelChoixArtiste.gridx = 1;
		gbc_panelChoixArtiste.gridy = 1;
		getContentPane().add(createChoixItemView(), gbc_panelChoixArtiste);
		
	}
	
	protected JPanel createOperationsPanel(){
		
		JPanel panelOperations = new JPanel();
		
		GridLayout operationLayout = new GridLayout(5, 1, 0, 0);
		operationLayout.setVgap(5);
		
		panelOperations.setLayout(operationLayout);
		
		JButton btnAjouter = new JButton(VIEW_OPERATIONS_AJOUTER);
		JButton btnModifier = new JButton(VIEW_OPERATIONS_MODIFIER);
		JButton btnSupprimer = new JButton(VIEW_OPERATIONS_SUPPRIMER);
		JButton btnRechercher = new JButton(VIEW_OPERATIONS_RECHERCHER);
		JButton btnQuitter = new JButton(VIEW_OPERATIONS_QUITTER);
		
		GestionPanneauOperations gestionnaire = new GestionPanneauOperations(
				this);
		
		btnAjouter.addActionListener(gestionnaire);
		btnModifier.addActionListener(gestionnaire);
		btnSupprimer.addActionListener(gestionnaire);
		btnRechercher.addActionListener(gestionnaire);
		btnQuitter.addActionListener(gestionnaire);
		
		panelOperations.add(btnAjouter);
		panelOperations.add(btnModifier);
		panelOperations.add(btnSupprimer);
		panelOperations.add(btnRechercher);
		panelOperations.add(btnQuitter);
		
		return panelOperations;
		
	}
	
	protected abstract JPanel createItemsView();
	
	protected abstract JPanel createChoixItemView();
	
	public abstract void actionAjouter();
	
	public abstract void actionModifier();
	
	public abstract void actionSupprimer();
	
	public abstract void actionRechercher();
	
}
