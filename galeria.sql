-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-11-2022 a las 17:44:43
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `galeria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

--
-- Volcado de datos para la tabla `imagen`
--

INSERT INTO `imagen` (`id`, `image_id`, `image_url`, `nombre`) VALUES
(1, 'wqluc6zoni37azewvuva', 'http://res.cloudinary.com/dpjai1g99/image/upload/v1667572144/wqluc6zoni37azewvuva.jpg', '312974380_2311764982326663_390875097266849885_n');
(2, 'wqluc6zoni37azewvuva', 'http://res.cloudinary.com/dpjai1g99/image/upload/v1667572144/wqluc6zoni37azewvuva.jpg', '312974380_2311764982326663_390875097266849885_n');
(3, 'wqluc6zoni37azewvuva', 'http://res.cloudinary.com/dpjai1g99/image/upload/v1667572144/wqluc6zoni37azewvuva.jpg', '312974380_2311764982326663_390875097266849885_n');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `imagen`
--
ALTER TABLE `imagen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
