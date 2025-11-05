
--
-- Table structure for table `compras_garages`
--
USE acacias_del_mar;
DROP TABLE IF EXISTS `compras_garages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras_garages` (
  `id_compras_garages` int NOT NULL AUTO_INCREMENT,
  `id_socio` int NOT NULL,
  `id_garage` int NOT NULL,
  `fecha_compra` date NOT NULL,
  PRIMARY KEY (`id_compras_garages`),
  KEY `compra_garage_idx` (`id_garage`),
  KEY `compra_socio_idx` (`id_socio`),
  CONSTRAINT `compra_garage_garage` FOREIGN KEY (`id_garage`) REFERENCES `garages` (`id_garage`),
  CONSTRAINT `compra_garage_socio` FOREIGN KEY (`id_socio`) REFERENCES `socios` (`id_socio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


LOCK TABLES `compras_garages` WRITE;
/*!40000 ALTER TABLE `compras_garages` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras_garages` ENABLE KEYS */;
UNLOCK TABLES;
