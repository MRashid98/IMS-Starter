drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`customer_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`item_id` INT(11) NOT NULL AUTO_INCREMENT,
	`item_name` VARCHAR(40) NULL DEFAULT NULL,
	`price` DECIMAL(19,4) NULL DEFAULT NULL,
	PRIMARY KEY (`item_id`)
); 

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  FOREIGN KEY `customer_id` (`customer_id`) REFERENCES `customers` (`customer_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orderItem` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`order_id` int(11) DEFAULT NULL,
	`item_id` int(11) DEFAULT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY `order_id` (`order_id`) REFERENCES `orders` (`order_id`),
	FOREIGN KEY `item_id` (`item_id`) REFERENCES `items` (`item_id`)
);