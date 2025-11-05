
--
-- Table structure for table `vehiculos`
--
USE acacias_del_mar;
DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculos` (
  `id_vehiculo` int NOT NULL AUTO_INCREMENT,
  `matricula` varchar(10) NOT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `id_tipo_vehiculo` int DEFAULT NULL,
  `profundidad` int DEFAULT NULL,
  `alto` int DEFAULT NULL,
  `ancho` int DEFAULT NULL,
  `id_socio_dueño` int NOT NULL,
  PRIMARY KEY (`id_vehiculo`),
  KEY `vehiculo_tipo_vehiculo_idx` (`id_tipo_vehiculo`),
  KEY `vehiculo_socio_idx` (`id_socio_dueño`),
  CONSTRAINT `vehiculo_socio` FOREIGN KEY (`id_socio_dueño`) REFERENCES `socios` (`id_socio`),
  CONSTRAINT `vehiculo_tipo_vehiculo` FOREIGN KEY (`id_tipo_vehiculo`) REFERENCES `tipos_vehiculo` (`id_tipo_vehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;
