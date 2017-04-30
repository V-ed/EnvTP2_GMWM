package outils;

public interface Constantes {
	
	final int ID_COLUMN = 0;
	
	final String REGEX_NAME = "^[A-Z]([A-Za-z]|-| )+$";
	
	final String REGEX_TITRE = "^[A-Z]([A-Za-z]|-| )+$";
	final String REGEX_GENRE = "^[A-Z]([A-Za-z]|-| )+$";
	final String REGEX_MAISON = "^[A-Z]([a-zA-Z]|-| )*$";
	
	final String[] POSSIBLE_EXTENSIONS =
	{
		"jpg", "jpeg", "png", "gif", "bmp"
	};
	
	final String FONT_USED = "Times New Roman";
	
	final int AJOUTER = 0;
	final int MODIFIER = 1;
	final int RECHERCHER = 2;
	
	final String PROJECT_IMAGES_FOLDER_NAME = "images";
	
}
