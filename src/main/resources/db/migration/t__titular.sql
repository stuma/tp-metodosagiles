DROP TABLE IF EXISTS `titular`;
CREATE TABLE IF NOT EXISTS `titular`
(
    `id`               int(11) NOT NULL,
    `dni`              int(11)      DEFAULT NULL,
    `nombre`           varchar(255) DEFAULT NULL,
    `apellido`         varchar(255) DEFAULT NULL,
    `direccion`        varchar(255) DEFAULT NULL,
    `factor_rh`        varchar(255) DEFAULT NULL,
    `fecha_nacimiento` date         DEFAULT NULL,
    `donante`          tinyint(1)   DEFAULT '1',
    PRIMARY KEY (`id`)
);