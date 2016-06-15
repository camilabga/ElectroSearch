SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `ElectroSearch`.`professor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ElectroSearch`.`professor` ;

CREATE TABLE IF NOT EXISTS `ElectroSearch`.`professor` (
  `matricula` VARCHAR(30) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(50) NOT NULL,
  `disciplina` VARCHAR(100) NOT NULL,
  `professor_matricula` VARCHAR(30) NULL,
  PRIMARY KEY (`matricula`),
  INDEX `fk_professor_professor1_idx` (`professor_matricula` ASC),
  CONSTRAINT `fk_professor_professor1`
    FOREIGN KEY (`professor_matricula`)
    REFERENCES `ElectroSearch`.`professor` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ElectroSearch`.`tal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ElectroSearch`.`tal` ;

CREATE TABLE IF NOT EXISTS `ElectroSearch`.`tal` (
  `matricula` VARCHAR(30) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(50) NOT NULL,
  `disciplina` VARCHAR(100) NOT NULL,
  `professor_matricula` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`matricula`),
  INDEX `fk_tal_professor_idx` (`professor_matricula` ASC),
  CONSTRAINT `fk_tal_professor`
    FOREIGN KEY (`professor_matricula`)
    REFERENCES `ElectroSearch`.`professor` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ElectroSearch`.`itens`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ElectroSearch`.`itens` ;

CREATE TABLE IF NOT EXISTS `ElectroSearch`.`itens` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `tipo` VARCHAR(100) NOT NULL,
  `disponivel` TINYINT(1) NOT NULL,
  `datasheet` VARCHAR(100) NOT NULL,
  `descricao` VARCHAR(600) NOT NULL,
  `data` DATE NOT NULL,
  `tal_matricula` VARCHAR(30) NULL,
  `professor_matricula` VARCHAR(30) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_itens_tal1_idx` (`tal_matricula` ASC),
  INDEX `fk_itens_professor1_idx` (`professor_matricula` ASC),
  CONSTRAINT `fk_itens_tal1`
    FOREIGN KEY (`tal_matricula`)
    REFERENCES `ElectroSearch`.`tal` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itens_professor1`
    FOREIGN KEY (`professor_matricula`)
    REFERENCES `ElectroSearch`.`professor` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO camilabga;
 DROP USER camilabga;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'camilabga' IDENTIFIED BY 'abcd1234';

GRANT ALL ON `ElectroSearch`.* TO 'camilabga';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
