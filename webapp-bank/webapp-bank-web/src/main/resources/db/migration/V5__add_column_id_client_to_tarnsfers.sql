USE `bank`;


ALTER TABLE `transfers` ADD COLUMN `id_client` INT NOT NULL AFTER `id_accountCB`;
ALTER TABLE `transfers` ADD CONSTRAINT `fk3`  FOREIGN KEY (`id_client`)  REFERENCES `clients` (`id_client`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;