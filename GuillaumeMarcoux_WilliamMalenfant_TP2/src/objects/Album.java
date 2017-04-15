package objects;

public class Album extends TableObject {
	
	protected Album(Database database, String... values){
		super(database, TABLE_NAME_ALBUMS, ID_COLUMN_NAME_ALBUMS,
				COLUMNS_ALBUMS, values);
	}
	
}
