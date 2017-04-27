package objects;

import java.util.ArrayList;

public class Artiste extends TableObject {
	
	public final static String TABLE_NAME = "artiste";
	public final static String[] COLUMN_NAMES =
	{
		"idArtiste", "nom", "prenom", "estMembre", "image"
	};
	
	public final static int COLUMN_LAST_NAME = 1;
	public final static int COLUMN_FIRST_NAME = 2;
	public final static int COLUMN_IS_MEMBER = 3;
	public final static int COLUMN_IMAGE_URL = 4;
	
	public Artiste(MySQLDatabase database, Object[] values){
		super(database, TABLE_NAME, COLUMN_NAMES[ID_COLUMN], COLUMN_NAMES,
				true, values);
	}
	
	public Artiste(MySQLDatabase database, String nom, String prenom,
			boolean estMembre, String imageURL){
		
		super(database, TABLE_NAME, COLUMN_NAMES[ID_COLUMN], COLUMN_NAMES,
				false, new Object[]
				{
					-1, nom, prenom, estMembre ? 1 : 0, imageURL
				});
		
	}
	
	public void modifyItem(String nom, String prenom, boolean estMembre,
			String imageURL){
		
		super.modifyItem(new Object[]
		{
			nom, prenom, estMembre ? 1 : 0, imageURL
		});
		
	}
	
	@Override
	public void modifyItem(TableObject modifiedObject){
		
		Artiste modifiedArtiste = (Artiste)modifiedObject;
		
		super.modifyItem(new Object[]
		{
			modifiedArtiste.getNom(),
			modifiedArtiste.getPrenom(),
			modifiedArtiste.isMembre() ? 1 : 0,
			modifiedArtiste.getImagePath()
		});
		
	}
	
	public String getFullName(){
		return values[COLUMN_FIRST_NAME] + " " + values[COLUMN_LAST_NAME];
	}
	
	public String getNom(){
		return (String)values[COLUMN_LAST_NAME];
	}
	
	public String getPrenom(){
		return (String)values[COLUMN_FIRST_NAME];
	}
	
	public boolean isMembre(){
		return (int)values[COLUMN_IS_MEMBER] == 1;
	}
	
	public String getImagePath(){
		return (String)values[COLUMN_IMAGE_URL];
	}
	
	public static ArrayList<TableObject> getAllAsArrayList(
			MySQLDatabase database){
		
		ArrayList<TableObject> liste = new ArrayList<>();
		
		ArrayList<Object[]> listeObjets = database
				.getAllContentofTable(TABLE_NAME);
		
		for(int i = 0; i < listeObjets.size(); i++){
			liste.add(new Artiste(database, listeObjets.get(i)));
		}
		
		return liste;
		
	}
	
}
