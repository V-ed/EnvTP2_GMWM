package objects;

import java.sql.Date;

public class Album extends TableObject {
	
	public Album(MySQLDatabase database, Object[] values){
		super(database, TABLE_NAME_ALBUMS, COLUMNS_ALBUMS[ID_COLUMN],
				COLUMNS_ALBUMS, values);
	}
	
	public Album(MySQLDatabase database, String titre, double prix,
			String genre, Date anneeSortie, String maisonDistribution,
			String imageURL, Artiste artiste){
		
		super(database, TABLE_NAME_ALBUMS, COLUMNS_ALBUMS[ID_COLUMN],
				COLUMNS_ALBUMS, new Object[]
				{
					titre,
					prix,
					genre,
					anneeSortie,
					maisonDistribution,
					imageURL,
					artiste
				});
		
	}
	
	public void modifyItem(String titre, double prix, String genre,
			Date anneeSortie, String maisonDistribution, String imageURL,
			Artiste artiste){
		
		super.modifyItem(new Object[]
		{
			titre,
			prix,
			genre,
			anneeSortie,
			maisonDistribution,
			imageURL,
			artiste
		});
		
	}
	
}
