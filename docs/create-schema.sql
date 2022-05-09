CREATE DATABASE IF NOT EXISTS `censos`

USE `censos`

CREATE TABLE `user`
(
 `user_id`  bigint NOT NULL ,
 `username` varchar(45) NOT NULL ,
 `email`    varchar(45) NOT NULL ,
 `password` varchar(45) NOT NULL ,

PRIMARY KEY (`user_id`)
);

CREATE TABLE `form`
(
 `form_id`     bigint NOT NULL ,
 `code`        varchar(45) NOT NULL ,
 `name`        varchar(45) NOT NULL ,
 `description` varchar(200) NOT NULL ,
 `expired_at`  datetime NOT NULL ,
 `user_id`     bigint NOT NULL ,

PRIMARY KEY (`form_id`),
KEY `FK_35` (`user_id`),
CONSTRAINT `FK_32` FOREIGN KEY `FK_35` (`user_id`) REFERENCES `user` (`user_id`)
);

CREATE TABLE `field`
(
 `field_id` bigint NOT NULL ,
 `type`     varchar(45) NOT NULL ,

PRIMARY KEY (`field_id`)
);

CREATE TABLE `form_field`
(
 `form_field_id` bigint NOT NULL ,
 `form_id`       bigint NOT NULL ,
 `field_id`      bigint NOT NULL ,
 `description`   varchar(45) NOT NULL ,
 `data`          varchar(45) NOT NULL ,

PRIMARY KEY (`form_field_id`),
KEY `FK_40` (`field_id`),
CONSTRAINT `FK_38` FOREIGN KEY `FK_40` (`field_id`) REFERENCES `field` (`field_id`),
KEY `FK_43` (`form_id`),
CONSTRAINT `FK_41` FOREIGN KEY `FK_43` (`form_id`) REFERENCES `form` (`form_id`)
);

CREATE TABLE `answer`
(
 `answer_id`     bigint NOT NULL ,
 `answer`        varchar(45) NOT NULL ,
 `form_id`       bigint NOT NULL ,
 `form_field_id` bigint NOT NULL ,
 `user_id`       bigint NOT NULL ,

PRIMARY KEY (`answer_id`),
KEY `FK_50` (`user_id`),
CONSTRAINT `FK_48` FOREIGN KEY `FK_50` (`user_id`) REFERENCES `user` (`user_id`),
KEY `FK_53` (`form_field_id`),
CONSTRAINT `FK_51` FOREIGN KEY `FK_53` (`form_field_id`) REFERENCES `form_field` (`form_field_id`),
KEY `FK_59` (`form_id`),
CONSTRAINT `FK_57` FOREIGN KEY `FK_59` (`form_id`) REFERENCES `form` (`form_id`)
);
