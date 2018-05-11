-- MySQL Workbench Synchronization
-- Generated: 2018-05-11 17:42
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Hector

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `equipo2db`.`Cliente` (
  `IdCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `CliNombre` TEXT NOT NULL,
  `CliApellidos` TEXT NOT NULL,
  `CliTelefono` TEXT NOT NULL,
  `CliDireccion` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`IdCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `equipo2db`.`Producto` (
  `IdProduco` INT(11) NOT NULL AUTO_INCREMENT,
  `ProNombre` TEXT NOT NULL,
  `ProPrecioVenta` INT(11) NOT NULL,
  `ProPrecioCompra` INT(11) NOT NULL,
  `ProCantidad` INT(11) NOT NULL,
  `Proveedor_id` INT(11) NOT NULL,
  PRIMARY KEY (`IdProduco`, `Proveedor_id`),
  INDEX `fk_Producto_Proveedor1_idx` (`Proveedor_id` ASC),
  CONSTRAINT `fk_Producto_Proveedor1`
    FOREIGN KEY (`Proveedor_id`)
    REFERENCES `equipo2db`.`Proveedor` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `equipo2db`.`Venta` (
  `IdVenta` VARCHAR(10) NOT NULL,
  `VenFecha` DATETIME NOT NULL,
  `VenTotal` INT(11) NOT NULL,
  `Cliente_Id` INT(11) NOT NULL,
  `Usuario_id` INT(11) NOT NULL,
  PRIMARY KEY (`IdVenta`, `Cliente_Id`, `Usuario_id`),
  INDEX `fk_Venta_Cliente_idx` (`Cliente_Id` ASC),
  INDEX `fk_Venta_Usuario1_idx` (`Usuario_id` ASC),
  CONSTRAINT `fk_Venta_Cliente`
    FOREIGN KEY (`Cliente_Id`)
    REFERENCES `equipo2db`.`Cliente` (`IdCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `equipo2db`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `equipo2db`.`Factura` (
  `idFactura` INT(11) NOT NULL,
  `FacFecha` DATETIME NOT NULL,
  `Venta_Id` VARCHAR(10) NOT NULL,
  `FacNIF` TEXT NOT NULL,
  PRIMARY KEY (`idFactura`, `Venta_Id`),
  INDEX `fk_Factura_Venta1_idx` (`Venta_Id` ASC),
  CONSTRAINT `fk_Factura_Venta1`
    FOREIGN KEY (`Venta_Id`)
    REFERENCES `equipo2db`.`Venta` (`IdVenta`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `equipo2db`.`Usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `UsuNombre` TEXT NOT NULL,
  `UsuApellidos` TEXT NOT NULL,
  `UsuAdmin` TINYINT(1) NULL DEFAULT NULL,
  `UsuNick` TEXT NOT NULL,
  `UsuPass` TEXT NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `equipo2db`.`Proveedor` (
  `idProveedor` INT(11) NOT NULL,
  `ProvNombre` TEXT NOT NULL,
  PRIMARY KEY (`idProveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `equipo2db`.`Compra` (
  `idCompra` VARCHAR(10) NOT NULL,
  `ComTotal` INT(11) NOT NULL,
  `ComFecha` DATETIME NOT NULL,
  `Proveedor_id` INT(11) NOT NULL,
  PRIMARY KEY (`idCompra`, `Proveedor_id`),
  INDEX `fk_Compra_Proveedor1_idx` (`Proveedor_id` ASC),
  CONSTRAINT `fk_Compra_Proveedor1`
    FOREIGN KEY (`Proveedor_id`)
    REFERENCES `equipo2db`.`Proveedor` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `equipo2db`.`Compra_has_Producto` (
  `Compra_id` VARCHAR(10) NOT NULL,
  `Producto_Id` INT(11) NOT NULL,
  `CPCantidad` INT(11) NOT NULL,
  PRIMARY KEY (`Compra_id`, `Producto_Id`),
  INDEX `fk_Compra_has_Producto_Producto1_idx` (`Producto_Id` ASC),
  INDEX `fk_Compra_has_Producto_Compra1_idx` (`Compra_id` ASC),
  CONSTRAINT `fk_Compra_has_Producto_Compra1`
    FOREIGN KEY (`Compra_id`)
    REFERENCES `equipo2db`.`Compra` (`idCompra`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_has_Producto_Producto1`
    FOREIGN KEY (`Producto_Id`)
    REFERENCES `equipo2db`.`Producto` (`IdProduco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `equipo2db`.`Venta_has_Producto` (
  `Venta_Id` VARCHAR(10) NOT NULL,
  `Producto_Id` INT(11) NOT NULL,
  `VPCantidad` INT(11) NOT NULL,
  PRIMARY KEY (`Venta_Id`, `Producto_Id`),
  INDEX `fk_Venta_has_Producto_Producto1_idx` (`Producto_Id` ASC),
  INDEX `fk_Venta_has_Producto_Venta1_idx` (`Venta_Id` ASC),
  CONSTRAINT `fk_Venta_has_Producto_Venta1`
    FOREIGN KEY (`Venta_Id`)
    REFERENCES `equipo2db`.`Venta` (`IdVenta`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_has_Producto_Producto1`
    FOREIGN KEY (`Producto_Id`)
    REFERENCES `equipo2db`.`Producto` (`IdProduco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
