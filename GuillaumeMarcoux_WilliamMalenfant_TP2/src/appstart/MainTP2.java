package appstart;

import java.sql.ResultSet;
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
			
			Artiste test = new Artiste(database, "Test Method name",
					"Test method first name", "0");
			
			//			test.addToDatabase();
			
			//			database.removeFromTable(Constantes.TABLE_NAME_ARTISTES,
			//					Constantes.ID_COLUMN_NAME_ARTISTES, 5);
			
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
