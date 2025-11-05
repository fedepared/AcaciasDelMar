--
-- Table structure for table `asignaciones_empleado_zona`
--
USE acacias_del_mar;
DROP TABLE IF EXISTS `asignaciones_empleado_zona`;

CREATE TABLE `asignaciones_empleado_zona` (
  `id_asignacion_empleado_zona` int NOT NULL AUTO_INCREMENT,
  `id_empleado` int NOT NULL,
  `id_zona` int NOT NULL,
  PRIMARY KEY (`id_asignacion_empleado_zona`),
  KEY `asignacion_empleado_idx` (`id_empleado`),
  KEY `asignacion_zona_idx` (`id_zona`),
  CONSTRAINT `asign_e_z_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`),
  CONSTRAINT `asign_e_z_zona` FOREIGN KEY (`id_zona`) REFERENCES `zonas` (`id_zona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


LOCK TABLES `asignaciones_empleado_zona` WRITE;
/*!40000 ALTER TABLE `asignaciones_empleado_zona` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignaciones_empleado_zona` ENABLE KEYS */;
UNLOCK TABLES;
