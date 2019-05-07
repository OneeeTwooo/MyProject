CREATE TABLE `Damage_cost` (
	`id_damage` int NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`cost` FLOAT(50) NOT NULL,
	`is_deleted` varchar(10) NOT NULL,
	`create_when` DATETIME NOT NULL,
	`modify_when` DATETIME NOT NULL,
	PRIMARY KEY (`id_damage`)
);

CREATE TABLE `damage_rent` (
	`id_damage_rent` int NOT NULL AUTO_INCREMENT,
	`id_damage` int NOT NULL,
	`id_rent` int NOT NULL,
	PRIMARY KEY (`id_damage_rent`)
);

CREATE TABLE `rents` (
	`id_rent` int NOT NULL AUTO_INCREMENT,
	`id_user` int NOT NULL,
	`id_car` int NOT NULL,
	`rental_start_date` DATETIME NOT NULL,
	`rental_finish_date` DATETIME NOT NULL,
	`created_when` DATETIME NOT NULL,
	`modify_when` DATETIME NOT NULL,
	PRIMARY KEY (`id_rent`)
);

CREATE TABLE `cars` (
	`id_car` int NOT NULL AUTO_INCREMENT,
	`gos_number` varchar(10) NOT NULL UNIQUE,
	`mark` varchar(20) NOT NULL,
	`model` varchar(20) NOT NULL,
	`year_out` DATE NOT NULL,
	`type` varchar(4) NOT NULL,
	`full_cost` FLOAT NOT NULL,
	`cost_1_day` FLOAT NOT NULL,
	`is_deleted` varchar(10) NOT NULL,
	`created_when` DATETIME NOT NULL,
	`modify_when` DATETIME NOT NULL,
	PRIMARY KEY (`id_car`)
);

CREATE TABLE `role_names` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `name_role` varchar(45) NOT NULL,
  `type_role` varchar(45) NOT NULL,
  PRIMARY KEY (`id_role`)
);

CREATE TABLE `user_role` (
	`id_user_role` int NOT NULL AUTO_INCREMENT,
	`id_role` int NOT NULL,
	`id_user` int NOT NULL,
	PRIMARY KEY (`id_user_role`)
);

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `id_passport` varchar(12) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `created_when` datetime NOT NULL,
  `modify_when` datetime NOT NULL,
  PRIMARY KEY (`id_user`)
);

ALTER TABLE `damage_rent` ADD CONSTRAINT `damage_rent_fk0` FOREIGN KEY (`id_damage`) REFERENCES `Damage_cost`(`id_damage`);

ALTER TABLE `damage_rent` ADD CONSTRAINT `damage_rent_fk1` FOREIGN KEY (`id_rent`) REFERENCES `rents`(`id_rent`);

ALTER TABLE `rents` ADD CONSTRAINT `rents_fk0` FOREIGN KEY (`id_user`) REFERENCES `users`(`id_user`);

ALTER TABLE `cars` ADD CONSTRAINT `cars_fk0` FOREIGN KEY (`id_car`) REFERENCES `rents`(`id_car`);

ALTER TABLE `user_role` ADD CONSTRAINT `user_role_fk0` FOREIGN KEY (`id_role`) REFERENCES `role_names`(`id_role`);

ALTER TABLE `user_role` ADD CONSTRAINT `user_role_fk1` FOREIGN KEY (`id_user`) REFERENCES `users`(`id_user`);
