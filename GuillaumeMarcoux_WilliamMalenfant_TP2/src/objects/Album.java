package objects;

import java.sql.Date;

public class Album extends TableObject {
	
	private final int COLUMN_TITLE = 1;
	private final int COLUMN_PRICE = 2;
	private final int COLUMN_GENRE = 3;
	private final int COLUMN_RELEASE_DATE = 4;
	private final int COLUMN_DISTRIBUTION = 5;
	private final int COLUMN_IMAGE_URL = 6;
	private final int COLUMN_ARTIST = 7;
	
	public Album(MySQLDatabase database, Object[] values){
		super(database, TABLE_NAME_ALBUMS, COLUMNS_ALBUMS[ID_COLUMN],
				COLUMNS_ALBUMS, true, values);
	}
	
	public Album(MySQLDatabase database, String titre, double prix,
			String genre, Date anneeSortie, String maisonDistribution,
			String imageURL, Artiste artiste){
		
		super(database, TABLE_NAME_ALBUMS, COLUMNS_ALBUMS[ID_COLUMN],
				COLUMNS_ALBUMS, false, new Object[]
				{
					-1,
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
	
	public String getTitre(){
		return (String)values[COLUMN_TITLE];
	}
	
	public double getPrix(){
		return (double)values[COLUMN_PRICE];
	}
	
	public String getGenre(){
		return (String)values[COLUMN_GENRE];
	}
	
	public Date getAnneeSortie(){
		return (Date)values[COLUMN_RELEASE_DATE];
	}
	
	public String getMaisonDistribution(){
		return (String)values[COLUMN_DISTRIBUTION];
	}
	
	public String getImageURL(){
		return (String)values[COLUMN_IMAGE_URL];
	}
	
	public Artiste getArtiste(){
		return (Artiste)values[COLUMN_ARTIST];
	}
	
}
