package objects;

public class Artiste extends TableObject {
	
	public Artiste(Database database, String... values){
		
		super(database, TABLE_NAME_ARTISTES, ID_COLUMN_NAME_ARTISTES,
				COLUMNS_ARTISTES, values);
		
	}
	
}
