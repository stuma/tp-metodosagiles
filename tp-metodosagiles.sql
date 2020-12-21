-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 21-12-2020 a las 04:57:34
-- Versión del servidor: 5.7.26
-- Versión de PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tp-metodosagiles`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licencia`
--

DROP TABLE IF EXISTS `licencia`;
CREATE TABLE IF NOT EXISTS `licencia` (
  `id` int(11) NOT NULL,
  `fecha_emision` date DEFAULT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  `tipo_licencia_id` int(11) DEFAULT NULL,
  `titular_id` int(11) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `numero_copias` int(11) DEFAULT NULL,
  `pendiente` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_tipo_licencia_id` (`tipo_licencia_id`),
  KEY `fk_titular_id` (`titular_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_licencia`
--

DROP TABLE IF EXISTS `tipo_licencia`;
CREATE TABLE IF NOT EXISTS `tipo_licencia` (
  `id` int(11) NOT NULL,
  `valor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `titular`
--

DROP TABLE IF EXISTS `titular`;
CREATE TABLE IF NOT EXISTS `titular` (
  `id` int(11) NOT NULL,
  `dni` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `factor_rh` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `donante` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `licencia`
--
ALTER TABLE `licencia`
  ADD CONSTRAINT `fk_tipo_licencia_id` FOREIGN KEY (`tipo_licencia_id`) REFERENCES `tipo_licencia` (`id`),
  ADD CONSTRAINT `fk_titular_id` FOREIGN KEY (`titular_id`) REFERENCES `titular` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
