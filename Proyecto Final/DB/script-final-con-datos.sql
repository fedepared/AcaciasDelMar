-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.32-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para acacias_del_mar
CREATE DATABASE IF NOT EXISTS `acacias_del_mar` /*!40100 DEFAULT CHARACTER SET armscii8 COLLATE armscii8_bin */;
USE `acacias_del_mar`;

-- Volcando estructura para tabla acacias_del_mar.asignaciones
CREATE TABLE IF NOT EXISTS `asignaciones` (
  `id_asignacion` int(11) NOT NULL AUTO_INCREMENT,
  `id_vehiculo` int(11) NOT NULL,
  `id_garage` int(11) NOT NULL,
  `fecha_asignacion` date DEFAULT NULL,
  PRIMARY KEY (`id_asignacion`),
  KEY `asignacion_vehiculo_idx` (`id_vehiculo`),
  KEY `asignacion_garage_idx` (`id_garage`),
  CONSTRAINT `asignacion_garage` FOREIGN KEY (`id_garage`) REFERENCES `garages` (`id_garage`),
  CONSTRAINT `asignacion_vehiculo` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculos` (`id_vehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla acacias_del_mar.asignaciones: ~0 rows (aproximadamente)
INSERT INTO `asignaciones` (`id_asignacion`, `id_vehiculo`, `id_garage`, `fecha_asignacion`) VALUES
	(1, 1, 1, '2025-10-01');

-- Volcando estructura para tabla acacias_del_mar.asignaciones_empleado_zona
CREATE TABLE IF NOT EXISTS `asignaciones_empleado_zona` (
  `id_asignacion_empleado_zona` int(11) NOT NULL AUTO_INCREMENT,
  `id_empleado` int(11) NOT NULL,
  `id_zona` int(11) NOT NULL,
  PRIMARY KEY (`id_asignacion_empleado_zona`),
  KEY `asignacion_empleado_idx` (`id_empleado`),
  KEY `asignacion_zona_idx` (`id_zona`),
  CONSTRAINT `asign_e_z_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`),
  CONSTRAINT `asign_e_z_zona` FOREIGN KEY (`id_zona`) REFERENCES `zonas` (`id_zona`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla acacias_del_mar.asignaciones_empleado_zona: ~0 rows (aproximadamente)
INSERT INTO `asignaciones_empleado_zona` (`id_asignacion_empleado_zona`, `id_empleado`, `id_zona`) VALUES
	(1, 1, 1);

-- Volcando estructura para tabla acacias_del_mar.compras_garages
CREATE TABLE IF NOT EXISTS `compras_garages` (
  `id_compras_garages` int(11) NOT NULL AUTO_INCREMENT,
  `id_socio` int(11) NOT NULL,
  `id_garage` int(11) NOT NULL,
  `fecha_compra` date NOT NULL,
  PRIMARY KEY (`id_compras_garages`),
  KEY `compra_garage_idx` (`id_garage`),
  KEY `compra_socio_idx` (`id_socio`),
  CONSTRAINT `compra_garage_garage` FOREIGN KEY (`id_garage`) REFERENCES `garages` (`id_garage`),
  CONSTRAINT `compra_garage_socio` FOREIGN KEY (`id_socio`) REFERENCES `socios` (`id_socio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla acacias_del_mar.compras_garages: ~0 rows (aproximadamente)
INSERT INTO `compras_garages` (`id_compras_garages`, `id_socio`, `id_garage`, `fecha_compra`) VALUES
	(2, 1, 1, '2025-11-10');

-- Volcando estructura para tabla acacias_del_mar.empleados
CREATE TABLE IF NOT EXISTS `empleados` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` int(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `especialidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla acacias_del_mar.empleados: ~0 rows (aproximadamente)
INSERT INTO `empleados` (`id_empleado`, `codigo`, `nombre`, `apellido`, `direccion`, `telefono`, `especialidad`) VALUES
	(1, 45658, 'juan', 'lopez', 'av esmeralda 2020', '1164977753', 'tecnico');

-- Volcando estructura para tabla acacias_del_mar.garages
CREATE TABLE IF NOT EXISTS `garages` (
  `id_garage` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `lectura_contador_luz` int(11) DEFAULT NULL,
  `tiene_servicios_contratados` bit(1) NOT NULL,
  `id_zona` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_garage`),
  KEY `zona_garage_idx` (`id_zona`),
  CONSTRAINT `garage_zona` FOREIGN KEY (`id_zona`) REFERENCES `zonas` (`id_zona`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla acacias_del_mar.garages: ~0 rows (aproximadamente)
INSERT INTO `garages` (`id_garage`, `numero`, `lectura_contador_luz`, `tiene_servicios_contratados`, `id_zona`) VALUES
	(1, 1234, 6500, b'1', 1);

-- Volcando estructura para tabla acacias_del_mar.socios
CREATE TABLE IF NOT EXISTS `socios` (
  `id_socio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(16) DEFAULT NULL,
  `fecha_de_ingreso` date NOT NULL,
  PRIMARY KEY (`id_socio`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla acacias_del_mar.socios: ~0 rows (aproximadamente)
INSERT INTO `socios` (`id_socio`, `nombre`, `apellido`, `direccion`, `telefono`, `fecha_de_ingreso`) VALUES
	(1, 'joaquin', 'gonzalez', 'av siempre viva 123', '1164395586', '2025-02-01');

-- Volcando estructura para tabla acacias_del_mar.tipos_vehiculo
CREATE TABLE IF NOT EXISTS `tipos_vehiculo` (
  `id_tipo_vehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_tipo_vehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla acacias_del_mar.tipos_vehiculo: ~4 rows (aproximadamente)
INSERT INTO `tipos_vehiculo` (`id_tipo_vehiculo`, `denominacion`) VALUES
	(1, 'motorhome'),
	(2, 'casa rodante de arrastre'),
	(3, 'caravana'),
	(4, 'trailer');

-- Volcando estructura para tabla acacias_del_mar.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) DEFAULT NULL,
  `pass` varchar(128) NOT NULL,
  `tipo_usuario` varchar(15) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla acacias_del_mar.usuarios: ~2 rows (aproximadamente)
INSERT INTO `usuarios` (`id_usuario`, `nombre`, `pass`, `tipo_usuario`) VALUES
	(1, 'federico', '$2a$10$Vc54/MAvHr6cppGiZAXVpu7xFF1c5B8uDKNnydGc85oUpWq5Qvls6', 'ADMINISTRADOR'),
	(2, 'empleado', '$2a$10$k/SqxTtkO.XIeqCsrDlZE.b3mRxNoiwMMj0yut71G47FUtDr0yPFK', 'EMPLEADO'),
	(3, 'socio', '$2a$10$0NdibIrzzwr.cAtBK4tbZe9HnYhBg7ehSUHYKCQzw/xQ0pmT2bQeG', 'SOCIO');

-- Volcando estructura para tabla acacias_del_mar.vehiculos
CREATE TABLE IF NOT EXISTS `vehiculos` (
  `id_vehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(10) NOT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `id_tipo_vehiculo` int(11) DEFAULT NULL,
  `profundidad` int(11) DEFAULT NULL,
  `alto` int(11) DEFAULT NULL,
  `ancho` int(11) DEFAULT NULL,
  `id_socio_dueño` int(11) NOT NULL,
  PRIMARY KEY (`id_vehiculo`),
  KEY `vehiculo_tipo_vehiculo_idx` (`id_tipo_vehiculo`),
  KEY `vehiculo_socio_idx` (`id_socio_dueño`),
  CONSTRAINT `vehiculo_socio` FOREIGN KEY (`id_socio_dueño`) REFERENCES `socios` (`id_socio`),
  CONSTRAINT `vehiculo_tipo_vehiculo` FOREIGN KEY (`id_tipo_vehiculo`) REFERENCES `tipos_vehiculo` (`id_tipo_vehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla acacias_del_mar.vehiculos: ~0 rows (aproximadamente)
INSERT INTO `vehiculos` (`id_vehiculo`, `matricula`, `marca`, `id_tipo_vehiculo`, `profundidad`, `alto`, `ancho`, `id_socio_dueño`) VALUES
	(1, '4654651', 'peugeot', 2, 1000, 1000, 1000, 1),
	(2, '1234514', 'renault sandero', 3, 500, 500, 500, 1);

-- Volcando estructura para tabla acacias_del_mar.zonas
CREATE TABLE IF NOT EXISTS `zonas` (
  `id_zona` int(11) NOT NULL AUTO_INCREMENT,
  `letra` char(1) DEFAULT NULL,
  `id_tipo_vehiculo` int(11) DEFAULT NULL,
  `profundidad` int(11) DEFAULT NULL,
  `ancho` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_zona`),
  KEY `zona_tipo_vehiculo_idx` (`id_tipo_vehiculo`),
  CONSTRAINT `zona_tipo_vehiculo` FOREIGN KEY (`id_tipo_vehiculo`) REFERENCES `tipos_vehiculo` (`id_tipo_vehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla acacias_del_mar.zonas: ~0 rows (aproximadamente)
INSERT INTO `zonas` (`id_zona`, `letra`, `id_tipo_vehiculo`, `profundidad`, `ancho`) VALUES
	(1, 'a', 1, 1000, 1000);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
