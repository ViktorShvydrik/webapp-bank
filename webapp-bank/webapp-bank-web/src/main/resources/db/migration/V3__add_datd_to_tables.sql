USE `bank`;


INSERt INTO clients (login, pass, access) VALUES ('user', 'user', 0);
INSERt INTO clients (login, pass, access) VALUES ('operator', 'operator', 2);
INSERt INTO clients (login, pass) VALUES ('3333', '3333');


INSERT INTO accounts (id_client, account, money, cards) VALUES ( 1, 496472681, 20000, 2);
INSERT INTO accounts (id_client, account, money, cards) VALUES ( 1, 778979919, 30000, 1);

INSERt INTO clientInf (id_client, name, secondName, email) VALUES (3,'operator', 'operator', 'operator@operator.ru');   

 INSERT INTO   cards (id_account,  id_client, number_card) VALUES  ( 2, 1, FLOOR(90000001*RAND()+10000000));
  INSERT INTO   cards (id_account,  id_client, number_card) VALUES  ( 2, 1, FLOOR(90000001*RAND()+10000000));
   INSERT INTO   cards (id_account,  id_client, number_card) VALUES  ( 3, 1, FLOOR(90000001*RAND()+10000000));