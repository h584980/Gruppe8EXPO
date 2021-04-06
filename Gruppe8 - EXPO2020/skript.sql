DROP SCHEMA IF EXISTS expo2020 CASCADE;
CREATE SCHEMA expo2020;
SET search_path = expo2020;

CREATE TABLE arrangement 
(
   navn 			CHARACTER VARYING (200),
   startDato 		DATE, 
   sluttDato 		DATE, 
   startTid 		TIME, 
   sluttTid 		TIME, 
   PRIMARY KEY (navn)
);

CREATE TABLE stand 
(
   navn 				CHARACTER VARYING (200),
   arrangementNavn		CHARACTER VARYING (200),
   PRIMARY KEY (navn),
   FOREIGN KEY (arrangementNavn) REFERENCES arrangement (navn)
);

CREATE TABLE stemme 
(
	id				CHARACTER VARYING (36),
  	verdi			INTEGER,
  	standNavn		CHARACTER VARYING (200),
  	PRIMARY KEY (id),
  	FOREIGN KEY (standNavn) REFERENCES stand (navn)
);