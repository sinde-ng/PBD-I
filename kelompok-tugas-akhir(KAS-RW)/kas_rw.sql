-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2023 at 02:24 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kas_rw`
--

-- --------------------------------------------------------

--
-- Table structure for table `kas_warga`
--

CREATE TABLE `kas_warga` (
  `id_kas` int(11) NOT NULL,
  `nik` varchar(15) NOT NULL,
  `tanggal_bayar` date NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kas_warga`
--

INSERT INTO `kas_warga` (`id_kas`, `nik`, `tanggal_bayar`, `jumlah`) VALUES
(1, '334567890', '2023-01-03', 20000),
(2, '25234134', '2023-01-04', 15000),
(3, '334567890', '2023-01-04', 15000);

-- --------------------------------------------------------

--
-- Table structure for table `warga`
--

CREATE TABLE `warga` (
  `nik` varchar(15) NOT NULL,
  `nama` varchar(35) NOT NULL,
  `no_rumah` varchar(5) NOT NULL,
  `status` enum('Kawin','Belum Kawin') NOT NULL,
  `jabatan` enum('Ketua RT','Wakil RT','Ketua RW','Wakil RW','Sekretaris','Bendahara','Seksi','Warga') NOT NULL,
  `rt` int(2) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `warga`
--

INSERT INTO `warga` (`nik`, `nama`, `no_rumah`, `status`, `jabatan`, `rt`) VALUES
('25234134', 'Watashi', 'C-78', 'Kawin', 'Sekretaris', 02),
('334567890', 'Slamet', 'B-05', 'Kawin', 'Seksi', 26),
('676990', 'Youru', 'C-77', 'Belum Kawin', 'Ketua RT', 12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kas_warga`
--
ALTER TABLE `kas_warga`
  ADD PRIMARY KEY (`id_kas`),
  ADD KEY `nik` (`nik`);

--
-- Indexes for table `warga`
--
ALTER TABLE `warga`
  ADD PRIMARY KEY (`nik`),
  ADD UNIQUE KEY `no_rumah` (`no_rumah`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kas_warga`
--
ALTER TABLE `kas_warga`
  MODIFY `id_kas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kas_warga`
--
ALTER TABLE `kas_warga`
  ADD CONSTRAINT `kas_warga_ibfk_1` FOREIGN KEY (`nik`) REFERENCES `warga` (`nik`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
