package objects;

public class Album extends TableObject {
	
	public Album(MySQLDatabase database, Object... values){
		
		super(database, TABLE_NAME_ALBUMS, ID_COLUMN_NAME_ALBUMS,
				COLUMNS_ALBUMS, values);
		
	}
	
}
