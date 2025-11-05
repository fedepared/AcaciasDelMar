
--
-- Table structure for table `asignaciones`
--

USE acacias_del_mar;

DROP TABLE IF EXISTS `asignaciones`;

CREATE TABLE `asignaciones` (
  `id_asignacion` int NOT NULL AUTO_INCREMENT,
  `id_vehiculo` int NOT NULL,
  `id_garage` int NOT NULL,
  `fecha_asignacion` date DEFAULT NULL,
  PRIMARY KEY (`id_asignacion`),
  KEY `asignacion_vehiculo_idx` (`id_vehiculo`),
  KEY `asignacion_garage_idx` (`id_garage`),
  CONSTRAINT `asignacion_garage` FOREIGN KEY (`id_garage`) REFERENCES `garages` (`id_garage`),
  CONSTRAINT `asignacion_vehiculo` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculos` (`id_vehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `asignaciones`
--

LOCK TABLES `asignaciones` WRITE;
/*!40000 ALTER TABLE `asignaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignaciones` ENABLE KEYS */;
UNLOCK TABLES;

-- Dump completed on 2025-10-30  9:23:27
