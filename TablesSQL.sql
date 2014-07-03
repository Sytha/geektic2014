CREATE TABLE INTERETS (
id integer NOT NULL,
libelle VARCHAR(255), 
primary KEY (id)
);

CREATE TABLE GEEKS (
id integer NOT NULL,
nom VARCHAR(255),
prenom VARCHAR(255),
sexe VARCHAR(1),
ville VARCHAR(255),
interet integer,
mail VARCHAR(255),
gravatar VARCHAR(255),
primary KEY (id),
FOREIGN KEY (interet) REFERENCES INTERETS(id)
);

CREATE TABLE HISTORY (
id integer NOT NULL,
date DATE,
geek integer,
primary KEY (id),
FOREIGN KEY (geek) REFERENCES GEEKS(id)
);