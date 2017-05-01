package outils;

public interface ConstantesAffichage {
	
	// Views operations button texts
	final String VIEW_OPERATIONS_AJOUTER = "Ajouter";
	final String VIEW_OPERATIONS_MODIFIER = "Modifier";
	final String VIEW_OPERATIONS_SUPPRIMER = "Supprimer";
	final String VIEW_OPERATIONS_RECHERCHER = "Rechercher";
	final String VIEW_OPERATIONS_RECHERCHER_ANNULER = "Annuler recherche";
	final String VIEW_OPERATIONS_QUITTER = "Quitter";
	
	// View addition of Artiste
	final String VIEW_ARTISTE_LABEL_NUMERO = "Num\u00E9ro :";
	final String VIEW_ARTISTE_LABEL_NOM = "Nom :";
	final String VIEW_ARTISTE_LABEL_EST_MEMBRE = "Membre?";
	final String VIEW_ARTISTE_BUTTON_ALBUMS = "Albums";
	
	// View connection
	final String VIEW_CONNECT_HEADER = "Connexion au Programme";
	final String VIEW_CONNECT_USERNAME = "Nom d'utilisateur :";
	final String VIEW_CONNECT_PASSWORD = "Mot de passe :";
	final String VIEW_CONNECT_VALIDER = "Valider";
	final String VIEW_CONNECT_QUITTER = "Quitter";
	
	// View principal
	final String VIEW_PRINCIPAL_ARTISTES = "Artistes";
	final String VIEW_PRINCIPAL_ALBUMS = "Albums";
	final String VIEW_PRINCIPAL_QUITTER = "Quitter";
	
	// View for all operations (Ajouter, Modifier, Rechercher) for Artiste
	final String VIEW_OPERATION_ARTISTE_LABEL_NOM = "Nom :";
	final String VIEW_OPERATION_ARTISTE_LABEL_PRENOM = "Prenom :";
	final String VIEW_OPERATION_ARTISTE_LABEL_MEMBRE = "Est Membre :";
	
	// View for all operations (Ajouter, Modifier, Rechercher) for Album
	final String VIEW_OPERATION_ALBUM_LABEL_TITLE = "Titre :";
	final String VIEW_OPERATION_ALBUM_LABEL_PRICE = "Prix :";
	final String VIEW_OPERATION_ALBUM_LABEL_GENRE = "Genre :";
	final String VIEW_OPERATION_ALBUM_LABEL_ANNEE = "Ann\u00E9e de Sortie :";
	final String VIEW_OPERATION_ALBUM_LABEL_MAISON = "Maison de distribution :";
	final String VIEW_OPERATION_ALBUM_LABEL_ARTISTE = "Artiste :";
	
	// Views for common operations
	final String VIEW_OPERATION_COMMON_BOUTON_IMAGE = "Choisir Image";
	final String VIEW_OPERATION_COMMON_LABEL_NO_PATH = "Pas d'image";
	final String VIEW_OPERATION_COMMON_BOUTON_ANNULER = "Annuler";
	
	// Error messages
	final String ERROR_INVALID_NOM_PRENOM = "Le nom et le pr\u00E9nom sont invalide. (lettres et \"-\" uniquement et doit commencer par une majuscule)";
	final String ERROR_INVALID_NOM = "Le nom est invalide. (lettres et \"-\" uniquement et doit commencer par une majuscule)";
	final String ERROR_INVALID_PRENOM = "Le pr\u00E9nom est invalide. (lettres et \"-\" uniquement et doit commencer par une majuscule)";
	final String ERROR_FILE_NOT_EXIST = "Le fichier n'existe pas";
	
	final String ERROR_INVALID_FIELDS = "Certains champs sont invalide (Lettres, \"-\" et \" \" uniquement)";
	final String ERROR_INVALID_TITRE = "Le titre est invalide (Lettres, \"-\" et \" \" uniquement)";
	final String ERROR_INVALID_GENRE = "Le genre est invalide (Lettres, \"-\" et \" \" uniquement)";
	final String ERROR_INVALID_MAISON = "La maison de distribution est invalide (Lettres, \"-\" et \" \" uniquement)";
	final String ERROR_INVALID_DATE = "Veuillez entrer une date";
	final String ERROR_ALBUM_AJOUT_NO_ARTISTE = "Vous ne pouvez pas cr\u00E9er d'album sans avoir au moins un artiste!";
	final String ERROR_IMPOSSIBLE_CONNECTION = "Erreur, Connection impossible (verifier l'identifiant et le mot de passe)";
	final String ERROR_ARTISTE_LINKED_TO_ALBUMS = "Cet artiste est reli\u00E9 \u00E0 au moins un album et ne peut \u00EAtre supprim\u00E9!";
	final String ERROR_ARTISTE_ALREADY_EXISTS = "Un artiste ayant ce pr\u00E9nom et ce nom existe d\u00E9j\u00E0!";
	final String ERROR_ALBUM_ALREADY_EXISTS = "Un album ayant ce titre existe d\u00E9j\u00E0!";
	
	// Confirmations
	final String CONFIRM_DELETE_ARTISTE = "\u00CAtes-vous s\u00FBr de vouloir supprimer cet artiste?";
	final String CONFIRM_DELETE_ALBUM = "\u00CAtes-vous sur de vouloir supprimer cet album?";
	final String CONFIRM_QUIT = "Voulez-vous vraiment quitter?";
	
	// Titles
	final String TITLE_PROJECT = "GMWM - TP2";
	final String TITLE_AJOUT_ARTISTE = "Ajout d'un artiste";
	final String TITLE_MODIF_ARTISTE = "Modification d'un artiste";
	final String TITLE_RECHERCHE_ARTISTE = "Recherche d'un artiste";
	final String TITLE_VUE_ARTISTES = "Les artistes!";
	final String TITLE_VUE_ALBUMS = "Les albums!";
	final String TITLE_CONNECT = "Connexion";
	final String TITLE_PRINCIPAL = "Menu Principal";
	final String TITLE_ERROR_CONNECTION = "Erreur de connection";
	
	// Common messages
	final String COMMON_ERROR = "Erreur";
	final String COMMON_DELETE = "Supprimer";
	final String COMMON_QUIT = "Quitter";
	
}
