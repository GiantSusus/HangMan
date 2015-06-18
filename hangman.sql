-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema AndroidGame
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema AndroidGame
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AndroidGame` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `AndroidGame` ;

-- -----------------------------------------------------
-- Table `AndroidGame`.`Account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AndroidGame`.`Account` (
  `account_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(40) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `online_status` TINYINT(1) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `created_at` DATETIME NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AndroidGame`.`Statistics`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AndroidGame`.`Statistics` (
  `account_id` INT NOT NULL,
  `best_time` INT NULL,
  `games_played` INT NULL,
  `wins` INT NULL,
  `losses` INT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AndroidGame`.`FriendList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AndroidGame`.`FriendList` (
  `account_id` INT NOT NULL,
  `friend_id` VARCHAR(45) NOT NULL,
  `is_friend` TINYINT(1) NOT NULL)
ENGINE = InnoDB;

USE `AndroidGame` ;

-- -----------------------------------------------------
-- Placeholder table for view `AndroidGame`.`view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AndroidGame`.`view1` (`id` INT);

-- -----------------------------------------------------
-- View `AndroidGame`.`view1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `AndroidGame`.`view1`;
USE `AndroidGame`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
