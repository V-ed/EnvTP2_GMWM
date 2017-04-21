package outils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import graphics.Vues;

public class GestionPanneauOperations implements ActionListener, ConstantesAffichage {
	
	private Vues vue;
	
	public GestionPanneauOperations(Vues vue){
		super();
		this.vue = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		String buttonText = ((JButton)e.getSource()).getText();
		
		switch(buttonText){
		case VIEW_OPERATIONS_AJOUTER:
			vue.actionAjouter();
			break;
		case VIEW_OPERATIONS_MODIFIER:
			vue.actionModifier();
			break;
		case VIEW_OPERATIONS_SUPPRIMER:
			vue.actionSupprimer();
			break;
		case VIEW_OPERATIONS_RECHERCHER:
			vue.actionRechercher();
			break;
		case VIEW_OPERATIONS_QUITTER:
			vue.dispose();
			break;
		default:
			break;
		}
		
	}
}