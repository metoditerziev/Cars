CREATE TABLE
  IF NOT EXISTS persons (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    national_id VARCHAR(255) UNIQUE
  );

CREATE TABLE IF NOT EXISTS `users` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `email` varchar(255) NOT NULL,
   `enabled` int NOT NULL,
   `mobile_phone` varchar(255) NOT NULL,
   `password` varchar(255) NOT NULL,
   `username` varchar(255) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
 ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci