package outils;

public interface Constantes {
	
	final int ID_COLUMN = 0;
	
	final String REGEX_NAME = "^[A-Z]([A-Za-z]|-)+$";
	
	final String[] POSSIBLE_EXTENSIONS =
	{
		"jpg", "jpeg", "png", "gif", "bmp"
	};
	
	final String FONT_USED = "Times New Roman";
	
	final static int AJOUTER = 0;
	final static int MODIFIER = 1;
	final static int RECHERCHER = 2;
	
	final static String PROJECT_IMAGES_FOLDER_NAME = "images";
	
}
