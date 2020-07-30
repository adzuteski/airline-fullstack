-- -----------------------------------------------------
-- Schema full-stack-ecommerce
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `airline-project-backand`;

CREATE SCHEMA `airline-project-backand`;
USE `airline-project-backand` ;


-- -----------------------------------------------------
-- Table `airline-project-backand`.`flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airline-project-backand`.`flight`(
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `flight_number` VARCHAR(255) DEFAULT NULL,
  `origin` VARCHAR(255) DEFAULT NULL,
  `destination` VARCHAR(255) DEFAULT NULL,
  `price` DECIMAL(13,2) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Add sample data
-- -----------------------------------------------------


INSERT INTO FLIGHT (FLIGHT_NUMBER, ORIGIN, DESTINATION, PRICE)
VALUES ('F336', 'Skopje', 'Dubai','38.85');

INSERT INTO FLIGHT (FLIGHT_NUMBER, ORIGIN, DESTINATION, PRICE)
VALUES ('F589', 'London', 'Ohrid','48.35');

INSERT INTO FLIGHT (FLIGHT_NUMBER, ORIGIN, DESTINATION, PRICE)
VALUES ('F829', 'Tel-Aviv', 'Franfurt','50.00');

INSERT INTO FLIGHT (FLIGHT_NUMBER, ORIGIN, DESTINATION, PRICE)
VALUES ('F359', 'Skopje', 'Istanbul','29.98');

INSERT INTO FLIGHT (FLIGHT_NUMBER, ORIGIN, DESTINATION, PRICE)
VALUES ('F735', 'New York', 'Berlin','80.25');
