USE notapp-db;

CREATE TABLE users(
	id CHAR(36) NOT NULL,
	username VARCHAR(250) NOT NULL,
	email VARCHAR(250) NOT NULL,
	name VARCHAR(250) NOT NULL,
	lastname VARCHAR(250) NOT NULL,
	password VARCHAR(250) NOT NULL,

	-- KEYS
	PRIMARY KEY( id )
) ENGINE = InnoDB CHARSET = utf8;

CREATE TABLE categories(
	id CHAR(36) NOT NULL,
	name VARCHAR(250) NOT NULL,

	-- KEYS
	PRIMARY KEY( id )
) ENGINE = InnoDB CHARSET = utf8;

CREATE TABLE notes(
	id CHAR(36) NOT NULL,
	title VARCHAR(250) NOT NULL,
	body VARCHAR(250) NOT NULL,
	category CHAR(36) NOT NULL,
	owner CHAR(36) NOT NULL,

	-- KEYS
	PRIMARY KEY( id ),
	FOREIGN KEY( category ) REFERENCES categories( id )
    		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY( owner ) REFERENCES users( id )
    		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARSET = utf8;

INSERT INTO users( id, username, email, name, lastname, password) VALUES
    ('481f157c-feae-4139-8195-215b3fb4752e', 'superpepe', 'pepe@mail.com', 'pepe', 'pepote', '$2a$12$WpHoEAnNJu8X/WYkRJX2POLD0RXRrP3nBJ476iJMqJiyMWytCqOQO');