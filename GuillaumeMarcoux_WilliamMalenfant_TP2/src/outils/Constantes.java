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
	
	final String LABEL_NAME = "artiste";
	
	final String IMAGE_ARTISTE_MOUSE_ON = "/images/artiste_mouse_on.jpg";
	final String IMAGE_ALBUM_MOUSE_ON = "/images/album_mouse_on.jpg";
	final String IMAGE_ARTISTE_MOUSE_OUT = "/images/artiste_mouse_out.jpg";
	final String IMAGE_ALBUM_MOUSE_OUT = "/images/album_mouse_out.jpg";
	
}
