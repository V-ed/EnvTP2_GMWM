package objects;

import java.util.ArrayList;

public class Artiste extends TableObject {
	
	private final int COLUMN_LAST_NAME = 1;
	private final int COLUMN_FIRST_NAME = 2;
	private final int COLUMN_IS_MEMBER = 3;
	private final int COLUMN_IMAGE_URL = 4;
	
	public Artiste(MySQLDatabase database, Object[] values){
		super(database, TABLE_NAME_ARTISTES, COLUMNS_ARTISTES[ID_COLUMN],
				COLUMNS_ARTISTES, true, values);
	}
	
	public Artiste(MySQLDatabase database, String nom, String prenom,
			boolean estMembre, String imageURL){
		
		super(database, TABLE_NAME_ARTISTES, COLUMNS_ARTISTES[ID_COLUMN],
				COLUMNS_ARTISTES, false, new Object[]
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
	
	public ArrayList<Artiste> fillArrayListFrom(ArrayList<Object[]> objectsList){
		
		ArrayList<Artiste> newList = new ArrayList<>();
		
		for(int i = 0; i < objectsList.size(); i++){
			newList.add(new Artiste(database, objectsList.get(i)));
		}
		
		return newList;
		
	}
	
}
