create sequence interets_seq start with 1000
create sequence geeks_seq start with 1000
create sequence history_seq start with 1000

CREATE TABLE INTERETS (
id integer NOT NULL,
libelle VARCHAR(255) NOT NULL, 
primary KEY (id)
);

CREATE TABLE GEEKS (
id integer NOT NULL,
nom VARCHAR(255) NOT NULL,
prenom VARCHAR(255) NOT NULL,
sexe VARCHAR(1) NOT NULL,
age integer NOT NULL,
ville VARCHAR(255) NOT NULL,
mail VARCHAR(255) NOT NULL,
gravatar VARCHAR(255) NOT NULL,
primary KEY (id),
);

CREATE TABLE HISTORY (
id integer NOT NULL,
date timestamp NOT NULL,
geek integer NOT NULL,
primary KEY (id),
FOREIGN KEY (geek) REFERENCES GEEKS(id)
);

CREATE TABLE GEEKS_INTERETS (
interet_id integer NOT NULL,
geek_id integer NOT NULL,
primary KEY (interet_id,geek_id),
FOREIGN KEY (geek_id) REFERENCES GEEKS(id),
FOREIGN KEY (interet_id) REFERENCES INTERETS(id)
);

