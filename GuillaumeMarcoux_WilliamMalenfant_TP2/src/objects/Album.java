package objects;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Album extends TableObject {
	
	public final static String TABLE_NAME = "album";
	
	public final static String[] COLUMN_NAMES =
	{
		"idAlbum",
		"titre",
		"prix",
		"genre",
		"anneeSortie",
		"maisonDistribution",
		"image",
		"idArtiste"
	};
	
	final int COLUMN_TITLE = 1;
	final int COLUMN_PRICE = 2;
	final int COLUMN_GENRE = 3;
	final int COLUMN_RELEASE_DATE = 4;
	final int COLUMN_DISTRIBUTION = 5;
	final int COLUMN_IMAGE_URL = 6;
	final int COLUMN_ARTIST = 7;
	
	public Album(MySQLDatabase database, Object[] values){
		super(database, TABLE_NAME, COLUMN_NAMES[ID_COLUMN], COLUMN_NAMES,
				true, values);
	}
	
	public Album(MySQLDatabase database, String titre, double prix,
			String genre, Date anneeSortie, String maisonDistribution,
			String imageURL, Artiste artiste){
		
		super(database, TABLE_NAME, COLUMN_NAMES[ID_COLUMN], COLUMN_NAMES,
				false, new Object[]
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
		
		super.modifyItem(false, new Object[]
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
	
	public String getFormattedPrix(){
		return new DecimalFormat("0.00 $").format(getPrix());
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
		return new Artiste(database, database.getRowContentOfTableWhere(
				Artiste.TABLE_NAME, Artiste.COLUMN_NAMES[ID_COLUMN],
				String.valueOf((int)values[COLUMN_ARTIST])));
	}
	
	public static ArrayList<TableObject> getAllAsArrayList(
			MySQLDatabase database){
		
		ArrayList<TableObject> liste = new ArrayList<>();
		
		ArrayList<Object[]> listeObjets = database
				.getAllContentofTable(TABLE_NAME);
		
		for(int i = 0; i < listeObjets.size(); i++){
			liste.add(new Album(database, listeObjets.get(i)));
		}
		
		return liste;
		
	}
	
}
