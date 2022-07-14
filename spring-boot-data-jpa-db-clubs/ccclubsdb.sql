-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-07-2022 a las 20:30:29
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ccclubsdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clubs`
--

CREATE TABLE `clubs` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `published` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clubs`
--

INSERT INTO `clubs` (`id`, `description`, `published`, `title`) VALUES
(1, 'Aldosivi', b'1', 'Aldosivi'),
(2, 'Asociación Atlética Argentinos Juniors', b'1', 'Argentinos Juniors'),
(3, 'Arsenal Fútbol Club', b'1', 'Arsenal'),
(4, 'Club Atlético Tucumán', b'1', 'Atletico Tucuman'),
(5, 'Club Atlético Banfield', b'1', 'Bandfield'),
(6, 'Club Atlético Barracas Central', b'1', 'Barracas Central'),
(7, 'Club Atlético Boca Juniors', b'1', 'Boca Juniors'),
(8, 'Club Atlético Central Córdoba', b'1', 'Central Cordoba'),
(9, 'Club Atlético Colón', b'1', 'Colon'),
(10, 'Club Social y Deportivo Defensa y Justicia', b'1', 'Defensa y Justicia'),
(11, 'Club Estudiantes de La Plata', b'1', 'Estudiantes'),
(12, 'Club de Gimnasia y Esgrima La Plata', b'1', 'Gimnasia'),
(13, 'Club Deportivo Godoy Cruz Antonio Tomba', b'1', 'Godoy Cruz'),
(14, 'Club Atlético Huracán', b'1', 'Huracan'),
(15, 'Club Atlético Independiente', b'1', 'Independiente'),
(16, 'Club Atlético Lanús', b'1', 'Lanus'),
(17, 'Club Atlético Newell’s Old Boys', b'1', 'Newell’s'),
(18, 'Club Atlético Patronato', b'1', 'Patronato'),
(19, 'Club Atlético Platense', b'1', 'Platense'),
(20, 'Racing Club', b'1', 'Racing'),
(21, 'Club Atlético River Plate', b'1', 'River Plate'),
(22, 'Club Atlético Rosario Central', b'1', 'Rosario Central'),
(23, 'Club Atlético San Lorenzo de Almagro', b'1', 'San Lorenzo'),
(24, 'Club Atlético Sarmiento', b'1', 'Sarmiento'),
(25, 'Club Atlético Talleres', b'1', 'Talleres'),
(26, 'Club Atlético Tigre', b'1', 'Tigre'),
(27, 'Club Atletico Union', b'1', 'Union'),
(28, 'Club Atlético Vélez Sarsfield', b'1', 'Velez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(30);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clubs`
--
ALTER TABLE `clubs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clubs`
--
ALTER TABLE `clubs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
