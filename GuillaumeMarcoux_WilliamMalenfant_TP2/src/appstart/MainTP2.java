package appstart;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import outils.Database;

public class MainTP2 {
	
	public static void main(String[] args){
		
		String password = JOptionPane.showInputDialog("Entrez le mot de"
				+ " passe de la base de donnée.");
		
		try{
			
			Database database = new Database("gestionalbums", password);
			
			String[] parameters = {"nom", "prenom", "estMembre"};
			String[] values = {"Test Method name", "Test method first name", "0"};
			
//			database.addToTable("artiste", parameters, values);
			
			ResultSet artistsData = database
					.executeQuery("SELECT * FROM artiste");
			
			String[] noms = database.getAllContentOfColumn(artistsData, "prenom");
			
			for(int i = 0; i < noms.length; i++){
				System.out.println(noms[i]);
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
