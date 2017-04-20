package appstart;

import java.sql.Date;
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
			
			MySQLDatabase database = new MySQLDatabase("localhost",
					"gestionalbums", "root", password);
			
			//Test Artiste
			//Test Ajout Artiste
			Artiste testAjout = new Artiste(database, "Lajouter", "Roger",
					true, null);
			
			testAjout.addToDatabase();
			
			//Test Modification Artiste
			Artiste testModif = new Artiste(database, "Nom de Famille",
					"Prénom", true, null);
			
			testModif.addToDatabase();
			
			testModif.modifyItem("Lapierre", "George", false, null);
			
			//Test Suppression Artiste
			Artiste testSupp = new Artiste(database, "Leffacer", "Paul", true,
					null);
			
			testSupp.addToDatabase();
			
			database.removeFromTable(Constantes.TABLE_NAME_ARTISTES,
					Constantes.COLUMNS_ARTISTES[Constantes.ID_COLUMN],
					testSupp);
			
			//test Album
			//Creation Artiste pour test
			Artiste testAlbumArtiste = new Artiste(database, "LAlbum", "Steph",
					false, null);
			
			testAlbumArtiste.addToDatabase();
			
			//Test Ajout Album
			Album lul = new Album(database, "SoundOfSilence", 999, "Classique",
					Date.valueOf("1998-12-25"), "MaisonEditer", null,
					testAlbumArtiste);
			
			lul.addToDatabase();
			
			//Test Modification Album
			Album testAlbumModif = new Album(database, "qwer", 100, "qwer",
					Date.valueOf("5555-05-05"), "tatute", null, testAjout);
			
			testAlbumModif.addToDatabase();
			
			testAlbumModif.modifyItem("MusixMix", 79, "mix",
					Date.valueOf("2017-02-17"), "MaisonMixeur", null,
					testAlbumArtiste);
			
			//Test Suppression Album
			Album testAlbumSupp = new Album(database, "Highway To Hell", 666,
					"ROCK", Date.valueOf("6666-06-06"), "Satan Inc.", null,
					testModif);
			
			testAlbumSupp.addToDatabase();
			
			database.removeFromTable(Constantes.TABLE_NAME_ALBUMS,
					Constantes.COLUMNS_ALBUMS[Constantes.ID_COLUMN],
					testAlbumSupp);
			
			ArrayList<Object[]> contenuArtistes = database
					.getAllContentofTable(Constantes.TABLE_NAME_ARTISTES);
			
			ArrayList<Object[]> contenuAlbums = database
					.getAllContentofTable(Constantes.TABLE_NAME_ALBUMS);
			
			System.out.println("Artistes");
			for(int i = 0; i < contenuArtistes.size(); i++){
				for(int j = 0; j < contenuArtistes.get(i).length; j++){
					System.out.print(contenuArtistes.get(i)[j] + " | ");
				}
				System.out.println("\n");
			}
			
			System.out.println("Albums");
			for(int i = 0; i < contenuAlbums.size(); i++){
				for(int j = 0; j < contenuAlbums.get(i).length; j++){
					System.out.print(contenuAlbums.get(i)[j] + " | ");
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
