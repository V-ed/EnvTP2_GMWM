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

INSERT INTO artiste (nom, prenom, estMembre, image) VALUES ('Cooper', 'John', true, 'johnCooper.jpg');
INSERT INTO artiste (nom, prenom, estMembre, image) VALUES ('Peters', 'Lori', true, 'loriPeters.jpg');
INSERT INTO artiste (nom, prenom, estMembre, image) VALUES ('Ledger', 'Jen', false, 'jenLedger.jpg');
INSERT INTO artiste (nom, prenom, estMembre, image) VALUES ('Cooper', 'Korey', false, 'koreyCooper.jpg');
INSERT INTO artiste (nom, prenom, estMembre, image) VALUES ('Morrison', 'Seth', false, 'sethMorrison.jpg');

INSERT INTO album (titre, prix, genre, anneeSortie, maisonDistribution, image, idArtiste) Values ('Rise', 50.99, 'Rock', '2013-06-25', 'CPM Distribution', 'rise.jpg', 1);
INSERT INTO album (titre, prix, genre, anneeSortie, maisonDistribution, image, idArtiste) Values ('Collide', 25, 'Classique', '2003-11-18', 'Tonality', 'collide.jpg', 2);
INSERT INTO album (titre, prix, genre, anneeSortie, maisonDistribution, image, idArtiste) Values ('Alien Youth', 50.99, 'Punk', '2001-08-28', 'TRX Distribution', 'alienYouth.jpg', 3);
INSERT INTO album (titre, prix, genre, anneeSortie, maisonDistribution, image, idArtiste) Values ('Awake', 45.99, 'Rock', '2009-08-25', 'Howard Benson', 'awake.jpg', 4);
INSERT INTO album (titre, prix, genre, anneeSortie, maisonDistribution, image, idArtiste) Values ('Comatose', 70.99, 'Rock', '2006-10-03', 'Howard Benson', 'comatose.jpg', 4);