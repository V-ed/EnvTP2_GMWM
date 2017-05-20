package outils;

public interface Constantes {
	
	final int ID_COLUMN = 0;
	
	final String REGEX_NAME = "^[A-Z]([A-Za-z]|-| )+$";
	
	final String REGEX_TITRE = "^[A-Z]([A-Za-z]|-| )+$";
	final String REGEX_GENRE = "^[A-Z]([A-Za-z]|-| )+$";
	final String REGEX_MAISON = "^[A-Z]([a-zA-Z]|-| )*$";
	
	final String FILECHOOSER_DISPLAY_IMAGES = "Images - .jpg, .jpeg, .png, .gif";
	final String[] POSSIBLE_EXTENSIONS =
	{
		"jpg", "jpeg", "png", "gif"
	};
	
	final String FONT_USED = "Times New Roman";
	
	final int AJOUTER = 0;
	final int MODIFIER = 1;
	final int RECHERCHER = 2;
	
	final String PROJECT_IMAGES_FOLDER_NAME = "images";
	
	final String LABEL_NAME = "artiste";
	
	final String IMAGE_ARTISTE_MOUSE_ON = "artiste_mouse_on.jpg";
	final String IMAGE_ALBUM_MOUSE_ON = "album_mouse_on.jpg";
	final String IMAGE_ARTISTE_MOUSE_OUT = "artiste_mouse_out.jpg";
	final String IMAGE_ALBUM_MOUSE_OUT = "album_mouse_out.jpg";
	final String IMAGE_CONNECT_USER = "utilisateur.png";
	final String IMAGE_CONNECT_KEY = "cle.png";
	final String IMAGE_CONNECT_CHECK = "crochet_1.png";
	final String IMAGE_CONNECT_CROSS = "croix_1.png";
	final String IMAGE_NO_IMAGE = "no_image.png";
	
	final String DOSSIER_ARTISTES = "artistes";
	final String DOSSIER_ALBUMS = "albums";
	
}
