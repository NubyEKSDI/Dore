-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 08, 2024 at 01:02 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `peminjaman_uppk`
--

-- --------------------------------------------------------

--
-- Table structure for table `borrow_records`
--

CREATE TABLE `borrow_records` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `equipment_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `borrowed_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `returned_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrow_records`
--

INSERT INTO `borrow_records` (`id`, `user_id`, `equipment_id`, `quantity`, `borrowed_at`, `returned_at`) VALUES
(1, 3, 2, 2, '2024-07-07 07:31:49', NULL),
(2, 5, 1, 4, '2024-07-07 13:28:23', '2024-07-07 13:28:23'),
(3, 5, 1, 1, '2024-07-07 13:37:37', '2024-07-07 13:37:37'),
(4, 5, 1, 1, '2024-07-07 13:38:08', '2024-07-07 13:38:08'),
(5, 7, 1, 1, '2024-07-07 13:54:44', '2024-07-07 13:54:44'),
(6, 7, 1, 5, '2024-07-07 13:57:55', '2024-07-07 13:57:55'),
(7, 7, 1, 5, '2024-07-07 14:17:00', '2024-07-07 14:17:00'),
(8, 9, 2, 5, '2024-07-07 18:54:06', '2024-07-07 18:54:06'),
(9, 9, 2, 95, '2024-07-07 18:54:45', '2024-07-07 18:54:45'),
(10, 9, 2, 5, '2024-07-07 19:20:43', '2024-07-07 19:20:43'),
(11, 9, 2, 5, '2024-07-07 19:24:25', '2024-07-07 19:24:25'),
(12, 9, 2, 5, '2024-07-07 19:41:58', '2024-07-07 19:41:58'),
(13, 9, 2, 10, '2024-07-07 19:27:48', '2024-07-07 19:27:48'),
(14, 9, 2, 10, '2024-07-07 19:41:58', '2024-07-07 19:41:58'),
(15, 9, 2, 10, '2024-07-07 19:41:58', '2024-07-07 19:41:58'),
(16, 9, 2, 10, '2024-07-07 19:41:58', '2024-07-07 19:41:58'),
(17, 9, 2, 10, '2024-07-07 19:41:58', '2024-07-07 19:41:58'),
(18, 9, 2, 10, '2024-07-07 19:40:24', '2024-07-07 19:40:24'),
(19, 9, 2, 10, '2024-07-07 19:41:26', '2024-07-07 19:41:26'),
(20, 9, 2, 10, '2024-07-07 19:41:58', '2024-07-07 19:41:58'),
(21, 9, 2, 20, '2024-07-07 19:42:39', '2024-07-07 19:42:39'),
(22, 9, 4, 5, '2024-07-07 19:44:59', '2024-07-07 19:44:59'),
(23, 9, 4, 10, '2024-07-07 19:52:34', '2024-07-07 19:52:51'),
(24, 9, 4, 20, '2024-07-07 19:53:12', '2024-07-07 19:53:20'),
(25, 9, 4, 20, '2024-07-07 19:55:17', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `equipment`
--

CREATE TABLE `equipment` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `equipment`
--

INSERT INTO `equipment` (`id`, `name`, `quantity`) VALUES
(1, 'Projector', 190),
(2, 'Mic', 110),
(3, 'speaker', 100),
(4, 'kursi', 30);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nrp` varchar(50) DEFAULT NULL,
  `jurusan` varchar(255) DEFAULT NULL,
  `access_level` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `name`, `nrp`, `jurusan`, `access_level`) VALUES
(1, 'john_doe', '$2a$08$/zdCZ2Gt1LmeNEGjxnVdCuMNxcryPOmvJ/Y59ih.xtUliBd92PC5a', 'John Doe', '123456', 'Computer Science', 0),
(2, 'admin_user', '$2a$08$w/CWR9QLpfKaGbA5qHdqiePspgeEpyfQ49osSbPy/YEjm/Pq/oTlC', NULL, NULL, NULL, 1),
(3, 'user', '$2a$08$OGS8ra/eOqth2Rk8zmuxwOkpYxRV2kPn4IPS.3lpunoHfpP7p9ila', 'contoh', 'c0202', 'elektro', 0),
(4, 'admin', '$2a$08$bNKDf4F2p4rXuMA8aRTlYu5tmV2R3QVtFOox/YNqI4P9RHTQ/w2iW', NULL, NULL, NULL, 1),
(5, 'dore', '$2a$08$n7IxYJaY81n555YUsCFkO.2dZCv7g.KkUQoJRpfmiqZdhWaANdDVK', NULL, NULL, NULL, 1),
(6, 'aaaaa', '$2a$08$JfVcnrFwW7/6Iimq49gu7ujdszeUfW43af3qNTisuTVMEoxciUoEG', 'a', 'a', 'a', 0),
(7, 'aa', '$2a$08$w6Tz9ZZcDoB56WzgsZLTdewbsEGK9L8930siiAfgy.Tq/OoQsQMTu', 'a', 'a', 'a', 0),
(8, 'aa', '$2a$08$VmRs/d0nabboNp9bhrR2XOYbLUErPPsLqhcBtUra041JZtY11uerS', 'a', 'a', 'a', 0),
(9, 'nubi', '$2a$08$3.a31ibs5ACXpRBCW3TtfeesuECleAf7IFlSh3ApHnyQoyJTKvvy.', 'nubi', 'c11210000', 'elektro', 0),
(10, '', '$2a$08$VR8aZixyRWNpkQRQ3UCO5eCnK21JdUdrbrf8cuqaEDKwrAyu9p6bO', NULL, NULL, NULL, 1),
(11, 'hans', '$2a$08$MyAV9Gm3dVqZHFNbfDJmgOk2EXH2urBm62iAM2OBVQWQbv84kY7dq', NULL, NULL, NULL, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `borrow_records`
--
ALTER TABLE `borrow_records`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `equipment`
--
ALTER TABLE `equipment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `borrow_records`
--
ALTER TABLE `borrow_records`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `equipment`
--
ALTER TABLE `equipment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
