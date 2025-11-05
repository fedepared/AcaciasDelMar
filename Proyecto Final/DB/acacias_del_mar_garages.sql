
-- Table structure for table `garages`
--acacias_del_mar
USE acacias_del_mar;
DROP TABLE IF EXISTS `garages`;
CREATE TABLE `garages` (
  `id_garage` int NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  `lectura_contador_luz` int DEFAULT NULL,
  `tiene_servicios_contratados` tinyint NOT NULL,
  `id_zona` int DEFAULT NULL,
  PRIMARY KEY (`id_garage`),
  KEY `zona_garage_idx` (`id_zona`),
  CONSTRAINT `garage_zona` FOREIGN KEY (`id_zona`) REFERENCES `zonas` (`id_zona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `garages`
--

LOCK TABLES `garages` WRITE;
/*!40000 ALTER TABLE `garages` DISABLE KEYS */;
/*!40000 ALTER TABLE `garages` ENABLE KEYS */;
UNLOCK TABLES;
