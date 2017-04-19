package outils;

public interface Constantes {
	
	final static int ID_COLUMN = 0;
	
	final String[] COLUMNS_ARTISTES =
	{
		"idArtiste", "nom", "prenom", "estMembre", "image"
	};
	final String[] COLUMNS_ALBUMS =
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
	
	final String TABLE_NAME_ARTISTES = "artiste";
	final String TABLE_NAME_ALBUMS = "album";
	
}
