package objects;

import java.math.BigDecimal;
import java.sql.Date;

public class Album extends TableObject {
	
	final int COLUMN_TITLE = 1;
	final int COLUMN_PRICE = 2;
	final int COLUMN_GENRE = 3;
	final int COLUMN_RELEASE_DATE = 4;
	final int COLUMN_DISTRIBUTION = 5;
	final int COLUMN_IMAGE_URL = 6;
	final int COLUMN_ARTIST = 7;
	
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
		return ((BigDecimal)values[COLUMN_PRICE]).doubleValue();
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
		return new Artiste(database, database.getAllContentofTable(
				TABLE_NAME_ARTISTES).get((int)values[COLUMN_ARTIST]));
	}
}
