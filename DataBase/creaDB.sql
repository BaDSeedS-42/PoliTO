SET storage_engine=InnoDB;
SET FOREIGN_KEY_CHECKS=1;
CREATE DATABASE IF NOT EXISTS CAMPIONATO_CICLISTICO;
USE CAMPIONATO_CICLISTICO;

DROP TABLE IF EXISTS CLASSIFICA_INDIVIDUALE;
DROP TABLE IF EXISTS CICLISTA;
DROP TABLE IF EXISTS SQUADRA;
DROP TABLE IF EXISTS TAPPA;

CREATE TABLE SQUADRA(CodS INTEGER CHECK(CodS>0),
					 NomeS CHAR(50) NOT NULL,
					 AnnoFondazione INTEGER NOT NULL,
					 SedeLegale CHAR(50),
					 PRIMARY KEY(CodS),
					 CONSTRAINT chk_AnnoFondazione CHECK(AnnoFondazione>1899 AND AnnoFondazione<2001));

CREATE TABLE CICLISTA(CodC CHAR(50),
		    		  Nome CHAR(50) NOT NULL,
					  Cognome CHAR(50) NOT NULL,
					  Nazionalita CHAR(50) NOT NULL,
					  CodS INTEGER NOT NULL CHECK(CodS>0) REFERENCES SQUADRA(CodS),
					  AnnoNascita INTEGER NOT NULL,
					  PRIMARY KEY(CodC),
					  CONSTRAINT chk_AnnoNascita CHECK(AnnoNascita>1899 AND AnnoNascita<2001));

CREATE TABLE TAPPA(Edizione INTEGER CHECK(Edizione>0),
				   CodT INTEGER CHECK(CodT>0),
				   CittaPartenza CHAR(50) NOT NULL,
				   CittaArrivo CHAR(50) NOT NULL,
				   Lunghezza INTEGER NOT NULL CHECK(Lunghezza>0),
				   Dislivello INTEGER NOT NULL CHECK(Dislivello>0),
				   GradoDifficolta INTEGER NOT NULL CHECK(GradoDifficolta>0 AND GradoDifficolta<11),
				   PRIMARY KEY(Edizione, CodT));
				   
CREATE TABLE CLASSIFICA_INDIVIDUALE(CodC CHAR(50) REFERENCES CICLISTA(CodC),
		      						CodT INTEGER CHECK(CodT>0) REFERENCES TAPPA(CodT),
		      						Edizione INTEGER CHECK(Edizione>0) REFERENCES TAPPA(Edizione),
		      						Posizione INTEGER NOT NULL CHECK(Posizione>0),
		      						PRIMARY KEY(CodC, CodT, Edizione));