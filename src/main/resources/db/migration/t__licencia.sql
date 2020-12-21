DROP TABLE IF EXISTS `licencia`;
CREATE TABLE IF NOT EXISTS `licencia`
(
    `id`                int(11) NOT NULL,
    `fecha_emision`     date         DEFAULT NULL,
    `fecha_vencimiento` date         DEFAULT NULL,
    `tipo_licencia_id`  int(11)      DEFAULT NULL,
    `titular_id`        int(11)      DEFAULT NULL,
    `observaciones`     varchar(255) DEFAULT NULL,
    `numero_copias`     int(11)      DEFAULT NULL,
    `pendiente`         tinyint(1)   DEFAULT '1',
    PRIMARY KEY (`id`),
    KEY `fk_tipo_licencia_id` (`tipo_licencia_id`),
    KEY `fk_titular_id` (`titular_id`)
);