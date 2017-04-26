package objects;

public class Artiste extends TableObject {
	
	public final static int COLUMN_LAST_NAME = 1;
	public final static int COLUMN_FIRST_NAME = 2;
	public final static int COLUMN_IS_MEMBER = 3;
	public final static int COLUMN_IMAGE_URL = 4;
	
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
			getID(), nom, prenom, estMembre ? 1 : 0, imageURL
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
	
}
