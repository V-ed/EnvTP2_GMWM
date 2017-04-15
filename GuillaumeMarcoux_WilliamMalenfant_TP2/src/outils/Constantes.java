package outils;

public interface Constantes {
	
	final String[] COLUMNS_ARTISTES =
	{
		"nom", "prenom", "estMembre", "image"
	};
	final String[] COLUMNS_ALBUMS =
	{
		"titre",
		"prix",
		"genre",
		"anneeSortie",
		"maisonDistribution",
		"image",
		"idArtiste"
	};
	
	final String TABLE_NAME_ARTISTES = "artiste";
	final String TABLE_NAME_ALBUMS = "album";
	
	final static String ID_COLUMN_NAME_ARTISTES = "idArtiste";
	final static String ID_COLUMN_NAME_ALBUMS = "idAlbum";
	
}
