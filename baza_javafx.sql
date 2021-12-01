-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 01, 2021 at 11:56 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.3.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `baza_javafx`
--

-- --------------------------------------------------------

--
-- Table structure for table `blok_lista`
--

CREATE TABLE `blok_lista` (
  `ID` int(50) UNSIGNED NOT NULL,
  `Ime` varchar(255) NOT NULL,
  `Prezime` varchar(255) NOT NULL,
  `BrojTelefona` varchar(255) NOT NULL,
  `IDImenika` int(50) UNSIGNED DEFAULT NULL,
  `IDKorisnika` int(50) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `blok_lista`
--

INSERT INTO `blok_lista` (`ID`, `Ime`, `Prezime`, `BrojTelefona`, `IDImenika`, `IDKorisnika`) VALUES
(12, 'Marija', 'Marić', '063/111-111', 46, 26);

-- --------------------------------------------------------

--
-- Table structure for table `favoriti`
--

CREATE TABLE `favoriti` (
  `ID` int(50) UNSIGNED NOT NULL,
  `Ime` varchar(255) NOT NULL,
  `Prezime` varchar(255) NOT NULL,
  `BrojTelefona` varchar(255) NOT NULL,
  `IDImenika` int(50) UNSIGNED DEFAULT NULL,
  `IDKorisnika` int(50) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `favoriti`
--

INSERT INTO `favoriti` (`ID`, `Ime`, `Prezime`, `BrojTelefona`, `IDImenika`, `IDKorisnika`) VALUES
(18, 'Luka', 'Lukić', '123456', 41, 15),
(19, 'Mate', 'Lukić', '063/555-666', 44, 26),
(20, 'Luka', 'Matić', '063/222-333', 45, 26);

-- --------------------------------------------------------

--
-- Table structure for table `imenik`
--

CREATE TABLE `imenik` (
  `ID` int(50) UNSIGNED NOT NULL,
  `Ime` varchar(255) NOT NULL,
  `Prezime` varchar(255) NOT NULL,
  `BrojTelefona` varchar(255) NOT NULL,
  `IDKorisnika` int(50) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `imenik`
--

INSERT INTO `imenik` (`ID`, `Ime`, `Prezime`, `BrojTelefona`, `IDKorisnika`) VALUES
(41, 'Luka', 'Lukić', '063/555-555', 15),
(43, 'Mate', 'Matić', '063/222-222', 15),
(44, 'Mate', 'Lukić', '063/555-666', 26),
(45, 'Luka', 'Matić', '063/222-333', 26);

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `ID` int(50) UNSIGNED NOT NULL,
  `KorisnickoIme` varchar(255) NOT NULL,
  `Lozinka` varchar(255) NOT NULL,
  `Uloga` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`ID`, `KorisnickoIme`, `Lozinka`, `Uloga`) VALUES
(1, 'mstojic@sum.ba', '123456', 'Administrator'),
(2, 'foroz@sum.ba', '123456', 'Administrator'),
(3, 'apejčinović@sum.ba', '123456', 'Administrator'),
(15, 'NekiKorisnik', '123', 'Korisnik'),
(26, 'NekiKorisnik2', '123', 'Korisnik'),
(27, 'NekiAdministrator', '123', 'Administrator');

-- --------------------------------------------------------

--
-- Table structure for table `podaci`
--

CREATE TABLE `podaci` (
  `ID` int(50) UNSIGNED NOT NULL,
  `Ime` varchar(255) NOT NULL,
  `Prezime` varchar(255) NOT NULL,
  `BrojTelefona` varchar(255) NOT NULL,
  `Adresa` varchar(255) NOT NULL,
  `IDKorisnika` int(50) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `podaci`
--

INSERT INTO `podaci` (`ID`, `Ime`, `Prezime`, `BrojTelefona`, `Adresa`, `IDKorisnika`) VALUES
(5, 'Matej', 'Stojić', '123456', 'NekaAdresa', 1),
(7, 'Andrej', 'Pejičinović', '123 456 789', 'NekaAdresa', 3),
(10, 'Filip', 'Oroz', '063 555 555', 'NekaAdresa', 2),
(13, 'Ivan', 'Ivanić', '063/222-222', 'Adresa BB', 15),
(16, 'Luka', 'Lukić', '063/111-111', 'Adresa BB', 26),
(17, 'Neki', 'Administrator', '000/000-000', 'NekaAdresa', 27);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blok_lista`
--
ALTER TABLE `blok_lista`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDKorisnika` (`IDKorisnika`),
  ADD KEY `IDImenika` (`IDImenika`) USING BTREE;

--
-- Indexes for table `favoriti`
--
ALTER TABLE `favoriti`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDImenika` (`IDImenika`) USING BTREE,
  ADD KEY `IDKorisnika` (`IDKorisnika`);

--
-- Indexes for table `imenik`
--
ALTER TABLE `imenik`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDImenika` (`IDKorisnika`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `podaci`
--
ALTER TABLE `podaci`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDKorisnika` (`IDKorisnika`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blok_lista`
--
ALTER TABLE `blok_lista`
  MODIFY `ID` int(50) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `favoriti`
--
ALTER TABLE `favoriti`
  MODIFY `ID` int(50) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `imenik`
--
ALTER TABLE `imenik`
  MODIFY `ID` int(50) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `ID` int(50) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `podaci`
--
ALTER TABLE `podaci`
  MODIFY `ID` int(50) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `blok_lista`
--
ALTER TABLE `blok_lista`
  ADD CONSTRAINT `korisnikBlokListaFK` FOREIGN KEY (`IDKorisnika`) REFERENCES `korisnik` (`ID`);

--
-- Constraints for table `favoriti`
--
ALTER TABLE `favoriti`
  ADD CONSTRAINT `imenikFavoritiFK` FOREIGN KEY (`IDImenika`) REFERENCES `imenik` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `korisnikFavoritiFK` FOREIGN KEY (`IDKorisnika`) REFERENCES `korisnik` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `imenik`
--
ALTER TABLE `imenik`
  ADD CONSTRAINT `korisnikImenikFK` FOREIGN KEY (`IDKorisnika`) REFERENCES `korisnik` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `podaci`
--
ALTER TABLE `podaci`
  ADD CONSTRAINT `korisnikPodaciFK` FOREIGN KEY (`IDKorisnika`) REFERENCES `korisnik` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
