USE `bank`;


CREATE TABLE clients (id_client INT AUTO_INCREMENT,
					login VARCHAR(50) UNIQUE,
					pass VARCHAR(50) NOT NULL,
					status INT(1) DEFAULT 0,
					access INT(1) DEFAULT 3,
					PRIMARY KEY (id_client));

INSERt INTO clients (login, pass, access) VALUES ('admin', 'admin', 1);

USE `bank`;

CREATE TABLE accounts (id_account INT AUTO_INCREMENT,
					id_client int not null,
					status int DEFAULT 0,
					account int UNIQUE,
					money int DEFAULT 0,
					cards int DEFAULT 0,
					PRIMARY KEY (id_account),
                    FOREIGN KEY (id_client) REFERENCES clients (id_client));
                    
INSERT INTO accounts (id_client, account, money) VALUES ( 1, 1, 10000);

CREATE TABLE clientInf (id_client int,
					name VARCHAR(50) NOT NULL,
					secondName VARCHAR(50) NOT NULL,
					email VARCHAR(50) NOT NULL,
					accounts int DEFAULT 0,
					FOREIGN KEY (id_client) REFERENCES clients (id_client));
					
 INSERt INTO clientInf (id_client, name, secondName, email, accounts) VALUES (1,'admin', 'admin', 'admin@admin.ru', 1);
                    
CREATE TABLE cards(id_card int AUTO_INCREMENT primary key,
					id_account int,
                    id_client int,
					number_card int unique,
					status int DEFAULT 0,
                    FOREIGN KEY (id_client) REFERENCES clients (id_client),
					FOREIGN KEY (id_account) REFERENCES accounts (id_account));

                    
CREATE TABLE transfers (id_transfers int AUTO_INCREMENT,
					id_accountCA int,
					money int DEFAULT 0,
					id_accountCB int,
					FOREIGN KEY (id_accountCA) REFERENCES accounts (id_account),
					FOREIGN KEY (id_accountCB) REFERENCES accounts (id_account),
					PRIMARY KEY (id_transfers));   