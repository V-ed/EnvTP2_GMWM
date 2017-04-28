package outils;

public interface Constantes {
	
	final int ID_COLUMN = 0;
	
	final String REGEX_NAME = "^[A-Z]([A-Za-z]|-)+$";
	
	final String[] POSSIBLE_EXTENSIONS =
	{
		"jpg", "jpeg", "png", "gif", "bmp"
	};
	
	final String FONT_USED = "Times New Roman";
	
	public final static int AJOUTER = 0;
	public final static int MODIFIER = 1;
	public final static int RECHERCHER = 2;
	
}
