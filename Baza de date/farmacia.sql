-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: aug. 15, 2022 la 10:45 PM
-- Versiune server: 10.1.37-MariaDB
-- Versiune PHP: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `farmacia`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `categorie`
--

CREATE TABLE `categorie` (
  `nume` varchar(50) NOT NULL,
  `idMedicament` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `categorie`
--

INSERT INTO `categorie` (`nume`, `idMedicament`) VALUES
('Analgezic', 2),
('Antibiotic', 4),
('Analgezic', 3),
('Analgezic', 1),
('Antibiotic', 5);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `comanda`
--

CREATE TABLE `comanda` (
  `id` int(50) NOT NULL,
  `idFarmacie` int(50) NOT NULL,
  `numePacient` varchar(50) NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `comanda`
--

INSERT INTO `comanda` (`id`, `idFarmacie`, `numePacient`, `data`) VALUES
(1, 2, 'Ion', '2022-05-11'),
(2, 2, 'Popescu', '2022-08-09'),
(3, 1, 'Gica', '2022-08-25'),
(4, 2, 'Motu', '2022-08-21'),
(5, 4, 'Gina', '2020-11-04'),
(6, 1, 'Lenuta', '2022-08-06'),
(7, 1, 'Popa', '2020-07-05'),
(8, 1, 'Gina', '2022-04-04'),
(9, 4, 'Trica', '2022-11-26'),
(10, 4, 'Puscas', '2021-11-21');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `farmacie`
--

CREATE TABLE `farmacie` (
  `id` int(50) NOT NULL,
  `nume` varchar(50) NOT NULL,
  `adresa` varchar(50) NOT NULL,
  `oras` varchar(50) NOT NULL,
  `telefon` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `farmacie`
--

INSERT INTO `farmacie` (`id`, `nume`, `adresa`, `oras`, `telefon`) VALUES
(1, 'Farmacia Vlad', 'Strada Nuferilor, 24', 'Timisoara', '0256433762'),
(2, 'Farmacia Dona', 'Strada Velescu, 36', 'Timisoara', '0246753981'),
(3, 'Farmacia Vona', 'Strada Busuioc, 5', 'Bucuresti', '0724673532'),
(4, 'Farmacia Calliope', 'Strada Excelentei, 24', 'Timisoara', '0756487510');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `medicament`
--

CREATE TABLE `medicament` (
  `id` int(50) NOT NULL,
  `nume` varchar(50) NOT NULL,
  `cost` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `medicament`
--

INSERT INTO `medicament` (`id`, `nume`, `cost`) VALUES
(1, 'Nurofen', 25),
(2, 'Parasinus', 17),
(3, 'Algocalmin', 12),
(4, 'Augumentin', 30),
(5, 'Ibufen', 27);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `serie`
--

CREATE TABLE `serie` (
  `idComanda` int(50) NOT NULL,
  `idMedicament` int(50) NOT NULL,
  `cantitate` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `serie`
--

INSERT INTO `serie` (`idComanda`, `idMedicament`, `cantitate`) VALUES
(1, 2, 3),
(1, 1, 1),
(2, 1, 2),
(2, 3, 3),
(2, 2, 1),
(3, 1, 1),
(4, 1, 5),
(4, 3, 2),
(5, 3, 2),
(5, 5, 1),
(6, 4, 2),
(6, 2, 3),
(7, 4, 1),
(7, 3, 2),
(7, 2, 2),
(8, 5, 2),
(9, 2, 2),
(9, 4, 1),
(10, 3, 5);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `stoc`
--

CREATE TABLE `stoc` (
  `idFarmacie` int(50) NOT NULL,
  `idMedicament` int(50) NOT NULL,
  `cantitate` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Eliminarea datelor din tabel `stoc`
--

INSERT INTO `stoc` (`idFarmacie`, `idMedicament`, `cantitate`) VALUES
(1, 1, 120),
(1, 2, 400),
(1, 3, 376),
(1, 4, 100),
(1, 5, 250),
(2, 1, 0),
(2, 2, 333),
(2, 5, 249),
(3, 2, 444),
(3, 3, 370),
(3, 4, 0),
(4, 1, 470),
(4, 3, 245),
(4, 4, 464),
(4, 5, 343),
(2, 3, 329),
(2, 4, 0),
(3, 1, 546),
(3, 5, 0),
(4, 2, 0);

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `comanda`
--
ALTER TABLE `comanda`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `farmacie`
--
ALTER TABLE `farmacie`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pentru tabele eliminate
--

--
-- AUTO_INCREMENT pentru tabele `comanda`
--
ALTER TABLE `comanda`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pentru tabele `farmacie`
--
ALTER TABLE `farmacie`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pentru tabele `medicament`
--
ALTER TABLE `medicament`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
