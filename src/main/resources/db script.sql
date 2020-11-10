CREATE table `tipo_licencia`
(
    `id`    int(11) NOT NULL,
    `valor` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE table `titular`
(
    `id`               int(11) NOT NULL,
    `dni`              int(11)      DEFAULT NULL,
    `nombre`           varchar(255) DEFAULT NULL,
    `apellido`         varchar(255) DEFAULT NULL,
    `direccion`        varchar(255) DEFAULT NULL,
    `factor_rh`        varchar(255) DEFAULT NULL,
    `fecha_nacimiento` date         DEFAULT NULL,
    `donante`          boolean      DEFAULT TRUE,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE table `licencia`
(
    `id`                int(11) NOT NULL,
    `fecha_emision`     date         DEFAULT NULL,
    `fecha_vencimiento` date         DEFAULT NULL,
    `tipo_licencia_id`  int(11)      DEFAULT NULL,
    `titular_id`        int(11)      DEFAULT NULL,
    `observaciones`     varchar(255) DEFAULT NULL,
    `numero_copias`     int(11)      DEFAULT NULL,
    `pendiente`         boolean      DEFAULT TRUE,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

ALTER TABLE licencia
    ADD CONSTRAINT fk_tipo_licencia_id FOREIGN KEY (tipo_licencia_id) REFERENCES tipo_licencia (id);
ALTER TABLE licencia
    ADD CONSTRAINT fk_titular_id FOREIGN KEY (titular_id) REFERENCES titular (id);

