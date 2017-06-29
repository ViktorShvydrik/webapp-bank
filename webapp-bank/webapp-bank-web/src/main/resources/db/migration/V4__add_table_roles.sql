USE `bank`;

CREATE TABLE `roles` (
	`id` INTEGER NOT NULL PRIMARY KEY auto_increment,
	`role_name` VARCHAR(255) NOT NULL,
	`role_desc` TEXT NOT NULL
);

-- ************************ Test Data for table roles ************************ 
INSERT INTO `roles` (`id`, `role_name`, `role_desc`) VALUES (1, 'administrator', 'Role for Administrators');
INSERT INTO `roles` (`id`, `role_name`, `role_desc`) VALUES (2, 'moderator', 'Role for Moderators');
INSERT INTO `roles` (`id`, `role_name`, `role_desc`) VALUES (3, 'regular_user', 'Role for Regular Users');

ALTER TABLE clients ADD CONSTRAINT fk_clients_roles FOREIGN KEY (access) REFERENCES roles (id);