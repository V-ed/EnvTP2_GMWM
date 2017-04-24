package graphics;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import objects.MySQLDatabase;
import objects.TableObject;
import outils.Constantes;
import outils.ConstantesAffichage;

public abstract class Vues extends JDialog implements Constantes, ConstantesAffichage {

	protected MySQLDatabase database;
	protected ArrayList<TableObject> objetsTable = new ArrayList<>();
	
	public Vues(JFrame parentFrame, boolean modal) {
		super(parentFrame, modal);
	}
	
	public abstract void actionAjouter();

	public abstract void actionModifier();

	public abstract void actionSupprimer();

	public abstract void actionRechercher();

}
