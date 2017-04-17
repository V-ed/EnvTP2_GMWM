package appstart;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import outils.Constantes;
import objects.*;

public class MainTP2 {
	
	public static void main(String[] args){
		
		String password = JOptionPane.showInputDialog("Entrez le mot de"
				+ " passe de la base de donnée.");
		
		try{
			
			Database database = new Database("gestionalbums", password);
			
			Artiste lol = new Artiste(database, "Nom de Famille", "Prénom",
					"0", null);
//			
			lol.addToDatabase();
//			
			lol.modifyItem("Famille modif", "Nope.avi", "1", null);
			
			ArrayList<Object[]> contenuArtistes = database
					.getAllContentofTable(Constantes.TABLE_NAME_ARTISTES);
			
			for(int i = 0; i < contenuArtistes.size(); i++){
				for(int j = 0; j < contenuArtistes.get(i).length; j++){
					System.out.print(contenuArtistes.get(i)[j] + " | ");
				}
				System.out.println("\n");
			}
			
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
}
