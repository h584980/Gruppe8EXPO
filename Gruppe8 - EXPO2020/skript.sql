DROP SCHEMA IF EXISTS expo2020 CASCADE;
CREATE SCHEMA expo2020;
SET search_path = expo2020;

CREATE TABLE stand 
(
   navn 			CHARACTER VARYING (20),
   snittStemme		FLOAT,
   antallStemmer	INTEGER,
   PRIMARY KEY (navn)
);



CREATE TABLE stemme 
(
	id				CHARACTER VARYING (36),
  	verdi			INTEGER,
  	-- remoteAddress	CHARACTER VARYING (50),
  	standNavn		CHARACTER VARYING (30),
  	-- PRIMARY KEY (stand_navn), -- remoteAddress,
  	PRIMARY KEY (id),
  	FOREIGN KEY (standNavn) REFERENCES stand (navn)
);