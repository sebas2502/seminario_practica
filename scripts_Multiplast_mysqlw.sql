-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema multiplastpedidos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema multiplastpedidos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `multiplastpedidos` DEFAULT CHARACTER SET utf8 ;
USE `multiplastpedidos` ;

-- -----------------------------------------------------
-- Table `multiplastpedidos`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `multiplastpedidos`.`Cliente` (
  `dniCliente` INT(8) NOT NULL,
  `apeNom` VARCHAR(80) NOT NULL,
  `direccion` VARCHAR(80) NOT NULL,
  `email` VARCHAR(100) NULL,
  PRIMARY KEY (`dniCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `multiplastpedidos`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `multiplastpedidos`.`Pedido` (
  `nroPedido` INT NOT NULL AUTO_INCREMENT,
  `dniCliente` INT(8) NOT NULL,
  `fechaEntrega` DATE NOT NULL,
  `descripcion` VARCHAR(100) NULL,
  `estado` VARCHAR(45) NOT NULL,
  `tipoEntrega` VARCHAR(45) NOT NULL,
  `importe` DOUBLE NOT NULL,
  PRIMARY KEY (`nroPedido`),
  INDEX `dniCliente_idx` (`dniCliente` ASC) VISIBLE,
  CONSTRAINT `dniCliente`
    FOREIGN KEY (`dniCliente`)
    REFERENCES `multiplastpedidos`.`Cliente` (`dniCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `multiplastpedidos`.`Sucursal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `multiplastpedidos`.`Sucursal` (
  `nroSucursal` INT NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`nroSucursal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `multiplastpedidos`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `multiplastpedidos`.`Producto` (
  `codPoducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NOT NULL,
  `descripcion` VARCHAR(150) NULL,
  `precio` DOUBLE NOT NULL,
  PRIMARY KEY (`codPoducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `multiplastpedidos`.`DetallePedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `multiplastpedidos`.`DetallePedido` (
  `idDetallePedido` INT NOT NULL,
  `codProdcuto` INT(8) NOT NULL,
  `nroPedido` INT(8) NOT NULL,
  `cantidad` INT(8) NOT NULL,
  PRIMARY KEY (`idDetallePedido`),
  INDEX `codProducto_idx` (`codProdcuto` ASC) VISIBLE,
  INDEX `nroPedido_idx` (`nroPedido` ASC) VISIBLE,
  CONSTRAINT `codProducto`
    FOREIGN KEY (`codProdcuto`)
    REFERENCES `multiplastpedidos`.`Producto` (`codPoducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `nroPedido`
    FOREIGN KEY (`nroPedido`)
    REFERENCES `multiplastpedidos`.`Pedido` (`nroPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
