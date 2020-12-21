DROP TABLE IF EXISTS `tipo_licencia`;
CREATE TABLE IF NOT EXISTS `tipo_licencia`
(
    `id`    int(11) NOT NULL,
    `valor` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);