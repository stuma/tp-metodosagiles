ALTER TABLE `licencia`
    ADD CONSTRAINT `fk_tipo_licencia_id` FOREIGN KEY (`tipo_licencia_id`) REFERENCES `tipo_licencia` (`id`),
    ADD CONSTRAINT `fk_titular_id` FOREIGN KEY (`titular_id`) REFERENCES `titular` (`id`);