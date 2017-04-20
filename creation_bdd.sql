DROP DATABASE IF EXISTS gestionalbums;
CREATE DATABASE gestionalbums;
USE gestionalbums;

CREATE TABLE artiste (
	idArtiste int AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    estMembre BOOLEAN NOT NULL,
	image VARCHAR(30)
);

CREATE TABLE album (
	idAlbum int AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(40) NOT NULL,
    prix DECIMAL(5,2) NOT NULL,
    genre VARCHAR(12) NOT NULL,
    anneeSortie DATE NOT NULL,
    maisonDistribution VARCHAR(40) NOT NULL,
    image VARCHAR(30),
    idArtiste int,
    FOREIGN KEY (idArtiste) REFERENCES artiste(idArtiste)
);