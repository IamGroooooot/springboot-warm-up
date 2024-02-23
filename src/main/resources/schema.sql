CREATE TABLE `user`
(
    `id`   bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(25) DEFAULT NULL,
    `age`  int         DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `fruit`
(
    `id`               bigint NOT NULL AUTO_INCREMENT,
    `warehousing_date` date        DEFAULT NULL,
    `price`            bigint      DEFAULT NULL,
    `is_sold`          tinyint(1)  DEFAULT '0',
    `name`             varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
