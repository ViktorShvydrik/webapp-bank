DROP SCHEMA IF EXISTS `bank`;

CREATE SCHEMA IF NOT EXISTS `bank`
CHARACTER SET `utf8`;

USE `bank`;

CREATE TABLE clients (id_client INT AUTO_INCREMENT,
					login VARCHAR(50) UNIQUE,
					pass VARCHAR(50) NOT NULL,
					status INT(1) DEFAULT 0,
					access INT(1) DEFAULT 2,
					PRIMARY KEY (id_client));
                    
INSERt INTO clients (login, pass, access) VALUES ('admin', 'admin', 1);
INSERt INTO clients (login, pass, access) VALUES ('user', 'user', 0);
INSERt INTO clients (login, pass, access) VALUES ('operator', 'operator', 2);
INSERt INTO clients (login, pass) VALUES ('3333', '3333');


CREATE TABLE accounts (id_account INT AUTO_INCREMENT,
					id_client int not null,
					status int DEFAULT 0,
					account int UNIQUE,
					money int DEFAULT 0,
					cards int DEFAULT 0,
					PRIMARY KEY (id_account),
                    FOREIGN KEY (id_client) REFERENCES clients (id_client));
                    
INSERT INTO accounts (id_client, account, money) VALUES ( 1, 0, 10000);
INSERT INTO accounts (id_client, account, money, cards) VALUES ( 1, 496472681, 20000, 2);
INSERT INTO accounts (id_client, account, money, cards) VALUES ( 1, 778979919, 30000, 1);

CREATE TABLE clientInf (id_client int,
					name VARCHAR(50) NOT NULL,
					secondName VARCHAR(50) NOT NULL,
					email VARCHAR(50) NOT NULL,
					accounts int DEFAULT 0,
					FOREIGN KEY (id_client) REFERENCES clients (id_client));
					
					
INSERt INTO clientInf (id_client, name, secondName, email, accounts) VALUES (1,'admin', 'admin', 'admin@admin.ru', 1);
INSERt INTO clientInf (id_client, name, secondName, email) VALUES (3,'operator', 'operator', 'operator@operator.ru');    
                    
CREATE TABLE cards(id_card int AUTO_INCREMENT primary key,
					id_account int,
                    id_client int,
					number_card int unique,
					status int DEFAULT 0,
                    FOREIGN KEY (id_client) REFERENCES clients (id_client),
					FOREIGN KEY (id_account) REFERENCES accounts (id_account));
                    
 INSERT INTO   cards (id_account,  id_client, number_card) VALUES  ( 2, 1, FLOOR(90000001*RAND()+10000000));
  INSERT INTO   cards (id_account,  id_client, number_card) VALUES  ( 2, 1, FLOOR(90000001*RAND()+10000000));
   INSERT INTO   cards (id_account,  id_client, number_card) VALUES  ( 3, 1, FLOOR(90000001*RAND()+10000000));
                    
CREATE TABLE transfers (id_transfers int AUTO_INCREMENT,
					id_client int,
					money int DEFAULT 0,
					id_account int,
					FOREIGN KEY (id_client) REFERENCES clients (id_client),
					FOREIGN KEY (id_account) REFERENCES accounts (id_account),
					PRIMARY KEY (id_transfers));                    
                                        
                    