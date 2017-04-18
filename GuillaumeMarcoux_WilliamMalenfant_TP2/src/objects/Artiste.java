package objects;

public class Artiste extends TableObject {
	
	public Artiste(MySQLDatabase database, String nom, String prenom,
			boolean estMembre, String image){
		
		super(database, TABLE_NAME_ARTISTES, ID_COLUMN_NAME_ARTISTES,
				COLUMNS_ARTISTES, new Object[]
				{
					nom, prenom, estMembre ? 1 : 0, image
				});
		
	}
	
}
