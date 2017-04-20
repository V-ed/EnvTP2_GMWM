package objects;

public class Artiste extends TableObject {
	
	public Artiste(MySQLDatabase database, Object[] values){
		super(database, TABLE_NAME_ARTISTES, COLUMNS_ARTISTES[ID_COLUMN],
				COLUMNS_ARTISTES, values);
	}
	
	public Artiste(MySQLDatabase database, String nom, String prenom,
			boolean estMembre, String imageURL){
		
		super(database, TABLE_NAME_ARTISTES, COLUMNS_ARTISTES[ID_COLUMN],
				COLUMNS_ARTISTES, new Object[]
				{
					nom, prenom, estMembre ? 1 : 0, imageURL
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
		return values[1] + " " + values[0];
	}
	
}
