
--
-- Table structure for table `socios`
--
USE acacias_del_mar;

DROP TABLE IF EXISTS `socios`;

CREATE TABLE `socios` (
  `id_socio` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(16) DEFAULT NULL,
  `fecha_de_ingreso` date NOT NULL,
  PRIMARY KEY (`id_socio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `socios`
--

LOCK TABLES `socios` WRITE;
/*!40000 ALTER TABLE `socios` DISABLE KEYS */;
/*!40000 ALTER TABLE `socios` ENABLE KEYS */;
UNLOCK TABLES;
