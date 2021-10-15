-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 15, 2021 at 04:25 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `cus_id` varchar(10) NOT NULL,
  `cus_name` varchar(25) NOT NULL,
  `dl_no` varchar(15) NOT NULL,
  `nic_no` varchar(15) NOT NULL,
  `address` varchar(50) NOT NULL,
  `contact_one` varchar(15) NOT NULL,
  `contact_two` varchar(15) NOT NULL,
  `occupation` varchar(25) NOT NULL,
  `office_tel` varchar(15) NOT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cus_id`, `cus_name`, `dl_no`, `nic_no`, `address`, `contact_one`, `contact_two`, `occupation`, `office_tel`) VALUES
('0019', 'Shehan', 'B4030627', '973400037V', '483/16B Kelaniya', '0703194961', '0775481354', 'System_Admin-KPMG', '0112906143'),
('0020', 'Jayantha', '1051056552', '983400037V', '67/15 Galedanda,Kelaniya', '0772379820', '0775481354', 'Accountant - Ceylinko', '0112906143');

-- --------------------------------------------------------

--
-- Stand-in structure for view `monthsale`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `monthsale`;
CREATE TABLE IF NOT EXISTS `monthsale` (
`year('date')` int(4)
,`month('date')` int(2)
,`sum('total')` double
);

-- --------------------------------------------------------

--
-- Table structure for table `orderx`
--

DROP TABLE IF EXISTS `orderx`;
CREATE TABLE IF NOT EXISTS `orderx` (
  `ord_id` int(10) NOT NULL,
  `cus_id` varchar(10) NOT NULL,
  `reserved_date` varchar(50) NOT NULL,
  `vehicle_no` varchar(10) NOT NULL,
  `start_date` varchar(50) NOT NULL,
  `end_date` varchar(50) DEFAULT NULL,
  `str_km` int(10) NOT NULL,
  `end_km` int(10) DEFAULT NULL,
  `dmg_claim` int(10) DEFAULT '0',
  `total` int(10) DEFAULT NULL,
  `adv_paid` int(10) DEFAULT NULL,
  `Final_Payment` int(10) DEFAULT '0',
  `Ord_State` tinyint(1) DEFAULT '0',
  `Contact_One` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ord_id`),
  KEY `cus_id` (`cus_id`),
  KEY `vehicle_no` (`vehicle_no`),
  KEY `vehicle_no_2` (`vehicle_no`),
  KEY `cus_id_2` (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderx`
--

INSERT INTO `orderx` (`ord_id`, `cus_id`, `reserved_date`, `vehicle_no`, `start_date`, `end_date`, `str_km`, `end_km`, `dmg_claim`, `total`, `adv_paid`, `Final_Payment`, `Ord_State`, `Contact_One`) VALUES
(2, '0019', '2021-09-23', 'CAS-8806', '2021-09-23', '2021-09-25', 58000, 58400, 0, 20000, 6000, 14000, 1, '0703194961'),
(3, '0019', '2021-09-23', 'CAG-8645', '2021-09-23', '2021-09-25', 56000, NULL, 0, 19000, 7000, 0, 0, '0703194961');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `u_id` int(11) NOT NULL,
  `u_name` varchar(60) NOT NULL,
  `u_pass` varchar(25) NOT NULL,
  `u_type` varchar(25) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`u_id`, `u_name`, `u_pass`, `u_type`, `email`) VALUES
(0, 'admin', 'Xuq6t7Fr/Dg=', 'Admin', 'colartslsl@gmail.com'),
(1, 'Ravi', 'Xuq6t7Fr/Dg=', 'Normal', 'yasith97@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE IF NOT EXISTS `vehicle` (
  `vehicle_no` varchar(10) NOT NULL,
  `mod_yom` varchar(25) NOT NULL,
  `color` varchar(15) NOT NULL,
  `no_seats` varchar(10) NOT NULL,
  `pu_date` varchar(250) NOT NULL,
  `pu_price` int(10) NOT NULL,
  `ins_no` varchar(15) NOT NULL,
  `ins_ex_dt` varchar(250) NOT NULL,
  `rl_ex_dt` varchar(250) NOT NULL,
  `lst_ser_km` int(10) NOT NULL,
  `cu_km` int(10) NOT NULL,
  `tr_rp_km` int(10) NOT NULL,
  `day_rate` int(10) NOT NULL,
  `ex_km_rate` int(10) NOT NULL,
  `Availability` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`vehicle_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`vehicle_no`, `mod_yom`, `color`, `no_seats`, `pu_date`, `pu_price`, `ins_no`, `ins_ex_dt`, `rl_ex_dt`, `lst_ser_km`, `cu_km`, `tr_rp_km`, `day_rate`, `ex_km_rate`, `Availability`) VALUES
('CAA-4562', 'Prius 2013', 'White', '5', '01-09-2021', 6500000, '45646-Ceylinko', '30-09-2021', '30-09-2021', 98000, 103500, 90000, 4500, 45, 9),
('CAG-8645', 'Civic-2018', 'Red', '5', '23-09-2021', 7200000, '55610-Ceylinko', '30-09-2021', '30-09-2021', 58000, 56000, 50000, 4500, 50, 0),
('CAQ-7006', 'Vezel-2015', 'Maroon', '5', '01-09-2021', 6500000, '45652-CoOp', '16-08-2021', '23-09-2021', 56000, 58000, 55000, 4500, 50, 9),
('CAS-8806', 'Prius-2016', 'White', '5', '01-09-2021', 9900000, '456587-Ceylinko', '30-09-2021', '30-09-2021', 56000, 58400, 50000, 5000, 50, 1),
('CAY-7863', 'Stingray-2017', 'Black', '5', '23-09-2021', 5200000, '46215-Ceylinko', '30-09-2021', '30-09-2021', 70000, 72000, 35000, 3500, 40, 1),
('CBB-5052', 'Vitz-2018', 'White', '5', '23-09-2021', 6200000, '46525-Ceylinko', '30-09-2021', '30-09-2021', 45000, 46500, 0, 4000, 40, 1),
('KY-2066', 'Aqua-2013', 'Blue', '5', '19-05-2021', 3800000, '5689-SLINS', '30-09-2021', '30-09-2021', 105000, 106000, 100000, 3500, 100, 1);

-- --------------------------------------------------------

--
-- Structure for view `monthsale`
--
DROP TABLE IF EXISTS `monthsale`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `monthsale`  AS  select year('date') AS `year('date')`,month('date') AS `month('date')`,sum('total') AS `sum('total')` from `orderx` group by year('year'),month('date') ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderx`
--
ALTER TABLE `orderx`
  ADD CONSTRAINT `orderx_ibfk_1` FOREIGN KEY (`vehicle_no`) REFERENCES `vehicle` (`vehicle_no`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
