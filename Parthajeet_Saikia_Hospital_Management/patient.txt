CREATE TABLE `patients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) DEFAULT NULL,
  `bgroup` varchar(50) DEFAULT NULL,
  `disease` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci