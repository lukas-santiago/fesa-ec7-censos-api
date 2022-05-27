CREATE DATABASE IF NOT EXISTS `censos`

USE `censos`
CREATE TABLE `field` (
  `field_id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`field_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `form` (
  `form_id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `expired_at` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`form_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `form_execution` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `form_field_id` bigint DEFAULT NULL,
  `form_id` bigint DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `form_field` (
  `form_field_id` bigint NOT NULL AUTO_INCREMENT,
  `data` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `field_id` bigint DEFAULT NULL,
  `form_id` bigint DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`form_field_id`),
  KEY `FKbmfw9o6lhfphgei7m249xeb0t` (`field_id`),
  KEY `FKbgdx9knhcvbjyxlq9iv0x04es` (`form_id`),
  CONSTRAINT `FKbgdx9knhcvbjyxlq9iv0x04es` FOREIGN KEY (`form_id`) REFERENCES `form` (`form_id`),
  CONSTRAINT `FKbmfw9o6lhfphgei7m249xeb0t` FOREIGN KEY (`field_id`) REFERENCES `field` (`field_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
