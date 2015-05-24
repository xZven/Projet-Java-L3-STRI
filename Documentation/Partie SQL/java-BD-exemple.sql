-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Dim 24 Mai 2015 à 22:42
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `java`
--
CREATE DATABASE IF NOT EXISTS `java` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `java`;

-- --------------------------------------------------------

--
-- Structure de la table `batiment`
--

CREATE TABLE IF NOT EXISTS `batiment` (
  `nom` char(50) NOT NULL,
  `localisation` char(50) NOT NULL,
  `description` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `batiment`
--

INSERT INTO `batiment` (`nom`, `localisation`, `description`) VALUES
('Administration', 'Université Paul Sabatier, Toulouse', 'Batiment Administrattif'),
('Laboratoir LAPLACE', 'Université Paul Sabatier, Toulouse', 'Département de recherche en télécommunication'),
('Langues Vivante', 'Université Paul Sabatier, Toulouse', 'Département des langues'),
('STAPS', 'Université Paul Sabatier, Toulouse', 'Département Sport'),
('U2', 'Université Paul Sabatier, Toulouse', 'Département Biologie'),
('U3', 'Université Paul Sabatier, Toulouse', 'Ecole d''ingéieure UPSSITECH');

-- --------------------------------------------------------

--
-- Structure de la table `estconnectee`
--

CREATE TABLE IF NOT EXISTS `estconnectee` (
  `machine1` bigint(20) NOT NULL,
  `machine2` bigint(20) NOT NULL,
  PRIMARY KEY (`machine1`,`machine2`),
  KEY `fk_machine2` (`machine2`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `interfacereseau`
--

CREATE TABLE IF NOT EXISTS `interfacereseau` (
  `mac` char(17) NOT NULL,
  `ipv4` char(15) DEFAULT NULL,
  `ipv6` varchar(39) DEFAULT NULL,
  `etat` tinyint(1) NOT NULL,
  `machine` bigint(20) DEFAULT NULL,
  `typer` enum('Ethernet','Token Bus','Token Ring','Wifi 2.4','Bluetooth','ProfiBUS','CAN','ZigBee','Wifi 5.0') DEFAULT NULL,
  PRIMARY KEY (`mac`),
  KEY `fk_machine_interface` (`machine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `interfacereseau`
--

INSERT INTO `interfacereseau` (`mac`, `ipv4`, `ipv6`, `etat`, `machine`, `typer`) VALUES
('05:E6:A5:79:F7:D7', '16.50.4.13', NULL, 1, 14, 'Wifi 5.0'),
('20:3B:FA:EA:87:1F', '10.65.4.2', NULL, 1, 10, 'Wifi 2.4'),
('2F:C3:37:40:53:7F', '172.50.34.20', NULL, 1, 19, 'Ethernet'),
('2F:F5:D2:57:55:04', '16.50.4.15', NULL, 1, 16, 'Ethernet'),
('34-A3-6E-97-97-B9', '192.168.3.4', 'fd94:8d62:8eb1:33da::eui', 1, 4, 'Ethernet'),
('39:E6:7F:00:DF:21', '10.200.200.10', NULL, 1, 20, 'Ethernet'),
('3D:A0:FD:63:C7:B0', '172.50.30.12', NULL, 1, 8, 'Ethernet'),
('46:42:B9:6D:2F:FF', '10.65.4.3', NULL, 1, 11, 'Wifi 2.4'),
('6F-0B-BD-59-2E-F4', '192.168.3.3', NULL, 1, 3, 'Ethernet'),
('75:D2:69:98:49:2F', '10.65.4.1', NULL, 1, 9, 'Wifi 2.4'),
('86:20:25:18:79:07', 'none', 'none', 0, 21, 'Ethernet'),
('86:20:25:46:02:E5', 'none', 'none', 1, 23, 'Ethernet'),
('86:20:25:46:65:01', '10.0.0.1', NULL, 0, 22, 'Ethernet'),
('86:20:25:59:16:32', 'none', 'none', 0, 23, 'Ethernet'),
('86:20:25:81:B9:FB', 'none', 'none', 1, 23, 'Ethernet'),
('86:20:25:81:D7:49', 'none', 'none', 1, 23, 'Ethernet'),
('86:20:25:82:E3:32', 'none', 'none', 0, 24, 'Ethernet'),
('86:20:25:8D:A2:A0', 'none', 'none', 1, 24, 'Ethernet'),
('86:20:25:9A:C1:88', '192.168.20.1', NULL, 0, 22, 'Ethernet'),
('86:20:25:D8:40:07', 'none', 'none', 1, 23, 'Ethernet'),
('86:20:25:F4:48:38', '192.168.20.10', 'none', 0, 21, 'Ethernet'),
('8C:EA:9F:AF:C9:7C', '172.50.35.66', NULL, 1, 13, 'Ethernet'),
('BE:8F:92:19:E9:50', '16.50.4.14', NULL, 1, 15, 'Ethernet'),
('CB:9D:B6:3D:05:FA', '10.65.4.4', NULL, 1, 12, 'Wifi 2.4'),
('D1:80:5C:FF:0F:85', '172.50.30.10', 'fd94:8d62:8eb1:33da::eui', 0, 6, 'Ethernet'),
('D6-68-EF-FB-2B-8A', '192.168.3.5', 'fd94:8d62:8eb1:33da::eui', 1, 5, 'Ethernet'),
('DA-A9-75-DC-CD-E8', '192.168.3.2', 'fd94:8d62:8eb1:33da::eui', 1, 2, 'Ethernet'),
('EA:E0:E8:62:5A:8C', '172.50.30.11', NULL, 1, 7, 'Ethernet'),
('EB-D6-20-C2-51-06', '192.168.3.1', 'fd94:8d62:8eb1:33da:0:0:0:0', 1, 1, 'Ethernet'),
('ED:DF:16:D1:1D:FB', '172.60.10.1', NULL, 1, 17, 'Ethernet'),
('F6:7F:AF:33:00:4E', '172.60.10.2', '', 1, 18, 'Ethernet');

-- --------------------------------------------------------

--
-- Structure de la table `machine`
--

CREATE TABLE IF NOT EXISTS `machine` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` char(50) DEFAULT NULL,
  `marque` char(50) DEFAULT NULL,
  `modele` char(32) DEFAULT NULL,
  `os` char(150) NOT NULL,
  `firmware` char(150) NOT NULL,
  `etat` tinyint(1) NOT NULL,
  `salle` smallint(6) DEFAULT NULL,
  `typem` enum('Tablette','Ordinateur fixe','PDA','SmartPhone','Ordinateur portable','Routeur','Commutateur','Pont','Autre') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_salle` (`salle`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Contenu de la table `machine`
--

INSERT INTO `machine` (`id`, `nom`, `marque`, `modele`, `os`, `firmware`, `etat`, `salle`, `typem`) VALUES
(1, 'PC1', 'HP', 'Pavillon', 'Windows 8.1', 'UEFI', 1, 1, 'Ordinateur fixe'),
(2, 'PC2', 'HP', 'Pavillon', 'Windows 8.1', 'UEFI', 1, 1, 'Ordinateur fixe'),
(3, 'PC3', 'HP', 'Pavillon', 'Windows 8.1', 'UEFI', 1, 1, 'Ordinateur fixe'),
(4, 'PC4', 'HP', 'Pavillon', 'Windows 8.1', 'UEFI', 1, 1, 'Ordinateur fixe'),
(5, 'PC5', 'HP', 'Pavillon', 'Windows 8.1', 'UEFI', 1, 1, 'Ordinateur fixe'),
(6, 'Président', 'DELL', 'Unknown', 'Windows XX', 'UEFI', 1, 2, 'Ordinateur fixe'),
(7, 'Président Adjoint', 'DELL', 'Unknown', 'Windows XX', 'UEFI', 1, 2, 'Ordinateur fixe'),
(8, 'Secrétaire', 'DELL', 'Unknown', 'Windows XX', 'UEFI', 1, 2, 'Ordinateur fixe'),
(9, 'Etudiant 1', 'MSI', 'GamerArea 52', 'Windows 8.1', 'UEFI', 1, 3, 'Ordinateur portable'),
(10, 'Etudiant 2', 'MSI', 'GamerArea 52', 'Windows 8.1', 'UEFI', 1, 3, 'Ordinateur portable'),
(11, 'Etudiant 3', 'HP', 'Pavillon', 'Windows 8.1', 'UEFI', 1, 3, 'Ordinateur fixe'),
(12, 'Etudiant 4', 'HP', 'Pavillon', 'Windows 8.1', 'UEFI', 1, 3, 'Ordinateur fixe'),
(13, 'Secrétaria STAPS', 'HP', 'Pavillon', 'Windows 8.1', 'UEFI', 1, 9, 'Ordinateur fixe'),
(14, 'Chercheur 1', 'SAMSUNG Galaxy NoteS20', 'Galaxy Note S20', 'Android', 'UEFI', 1, 7, 'Tablette'),
(15, 'Chercheur 2', 'HP', 'Pavillon Home X361', 'Windows 10', 'UEFI', 1, 7, 'Ordinateur fixe'),
(16, 'Chercheur 3', 'ASUS', 'Destiny 9', 'Windows XP', 'UEFI', 1, 7, ''),
(17, 'Langue Anglaise', 'HP', 'Pavillon X360', 'Windows 7', 'UEFI', 1, 6, 'Ordinateur fixe'),
(18, 'Langue Espagnol', 'HP', 'Pavillon Z259', 'Windows 7', 'UEFI', 1, 6, 'Ordinateur fixe'),
(19, 'Secrétaria UPPSITECH', 'HP', 'Pavillon A894', 'Windows 7', 'UEFI', 1, 8, 'Ordinateur fixe'),
(20, 'Server STRI', 'DELL', 'PowerEdge T110 II', 'Windows Server 2008 R2', 'UEFI', 1, 4, ''),
(21, 'Routeur1 STRI', 'CISCO', 'Cisco 360', 'iOS v34.6 release 10', 'UEFI', 1, 4, 'Routeur'),
(22, 'Routeur2 STRI', 'CISCO', 'Cisco 360', 'iOS v31.9', 'UEFI', 1, 4, 'Routeur'),
(23, 'Switch1 STRI', 'CISCO', 'Buisness Switch 89', 'iOS v30.6', 'UEFI', 1, 5, 'Commutateur'),
(24, 'Switch2 STRI', 'CISCO', 'Buisness Switch 89', 'iOS v30.9', 'UEFI', 1, 5, 'Commutateur');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE IF NOT EXISTS `salle` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `numero` char(10) NOT NULL,
  `etage` smallint(6) NOT NULL,
  `nom` char(50) DEFAULT NULL,
  `batiment` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_batiment` (`batiment`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `salle`
--

INSERT INTO `salle` (`id`, `numero`, `etage`, `nom`, `batiment`) VALUES
(1, '209', 2, 'Salle TP Informatique', 'U3'),
(2, 'none', 1, 'Bureau Administratif', 'Administration'),
(3, 'Amphi', 0, 'Amphi Daurat', 'U3'),
(4, '212', 2, 'Salle TP1 STRI', 'U2'),
(5, '213', 2, 'Salle TP2 STRI', 'U2'),
(6, 'K 20', 0, 'Labo de langue', 'Langues Vivante'),
(7, '10', 1, 'Salle de réunion 5', 'Laboratoir LAPLACE'),
(8, 'none', 0, 'Secrétaria UPSSITECH', 'U3'),
(9, 'none', 1, 'Secrétaria STAPS', 'STAPS');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `estconnectee`
--
ALTER TABLE `estconnectee`
  ADD CONSTRAINT `fk_machine1` FOREIGN KEY (`machine1`) REFERENCES `machine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_machine2` FOREIGN KEY (`machine2`) REFERENCES `machine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `interfacereseau`
--
ALTER TABLE `interfacereseau`
  ADD CONSTRAINT `fk_machine_interface` FOREIGN KEY (`machine`) REFERENCES `machine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `machine`
--
ALTER TABLE `machine`
  ADD CONSTRAINT `fk_salle` FOREIGN KEY (`salle`) REFERENCES `salle` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `fk_batiment` FOREIGN KEY (`batiment`) REFERENCES `batiment` (`nom`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
