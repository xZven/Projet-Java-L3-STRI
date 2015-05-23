-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 23 Mai 2015 à 15:17
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `java`
--

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
('Elysee', 'Toulouse', NULL),
('STAPS', 'Toulouse', 'Pour ceux qui aiment le sport !'),
('U2', 'Toulouse', NULL),
('U3', 'Toulouse', NULL),
('U4', 'Toulouse', NULL);

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

--
-- Contenu de la table `estconnectee`
--

INSERT INTO `estconnectee` (`machine1`, `machine2`) VALUES
(5, 1),
(5, 3),
(5, 4),
(1, 5),
(3, 5),
(4, 5);

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
('1', NULL, NULL, 0, NULL, 'Ethernet'),
('2', '1.1.1.1', NULL, 1, 2, 'Wifi 2.4'),
('3', NULL, '::1', 0, 3, 'Ethernet');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `machine`
--

INSERT INTO `machine` (`id`, `nom`, `marque`, `modele`, `os`, `firmware`, `etat`, `salle`, `typem`) VALUES
(1, 'durdur', 'HP', 'Pavillon', 'Windows 8.1', 'UEFI', 1, NULL, 'Ordinateur fixe'),
(2, 'manon', NULL, NULL, 'Windows 7', 'UEFI', 0, 3, 'Ordinateur portable'),
(3, 'gregory', 'HP', NULL, 'Ubuntu 12.04', 'Grub4.0', 1, 2, 'Ordinateur portable'),
(4, NULL, NULL, NULL, 'IOS Cisco', '4.2.9879', 1, 2, 'Routeur'),
(5, NULL, NULL, NULL, 'IOS Cisco', '2.36.128', 1, 2, 'Commutateur');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `salle`
--

INSERT INTO `salle` (`id`, `numero`, `etage`, `nom`, `batiment`) VALUES
(1, '126', 1, NULL, 'Elysee'),
(2, '1', 0, 'Meeting', 'U3'),
(3, '208', 2, NULL, 'U2');

-- --------------------------------------------------------

--
-- Structure de la table `uniteprocesseur`
--

CREATE TABLE IF NOT EXISTS `uniteprocesseur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fabriquant` char(50) DEFAULT NULL,
  `nom` char(50) NOT NULL,
  `machine` bigint(20) DEFAULT NULL,
  `typep` enum('gpu','cpu','autre') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_machine` (`machine`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `uniteprocesseur`
--

INSERT INTO `uniteprocesseur` (`id`, `fabriquant`, `nom`, `machine`, `typep`) VALUES
(1, 'Nvidia', 'GeForce 8850', 2, 'gpu'),
(2, 'Intel', 'i5 3700', 2, 'cpu'),
(3, 'Intel', 'i7 4700', 1, 'cpu'),
(4, 'Ati', 'Radeon 8070', 1, 'gpu'),
(5, 'AMD', 'FX 8350', 3, 'cpu'),
(6, 'Nvidia', 'GeForce 8800', NULL, 'gpu');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `estconnectee`
--
ALTER TABLE `estconnectee`
  ADD CONSTRAINT `fk_machine2` FOREIGN KEY (`machine2`) REFERENCES `machine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_machine1` FOREIGN KEY (`machine1`) REFERENCES `machine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

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

--
-- Contraintes pour la table `uniteprocesseur`
--
ALTER TABLE `uniteprocesseur`
  ADD CONSTRAINT `fk_machine` FOREIGN KEY (`machine`) REFERENCES `machine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
