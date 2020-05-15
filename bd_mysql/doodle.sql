-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : ven. 15 mai 2020 à 17:12
-- Version du serveur :  5.7.24
-- Version de PHP : 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `doodle`
--

-- --------------------------------------------------------

--
-- Structure de la table `alimentation`
--

CREATE TABLE `alimentation` (
  `id` bigint(20) NOT NULL,
  `libellePreferenceAlimentation` varchar(255) DEFAULT NULL,
  `participant_mail` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `allergies`
--

CREATE TABLE `allergies` (
  `id` bigint(20) NOT NULL,
  `libelleAllergie` varchar(255) DEFAULT NULL,
  `participant_mail` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `choixparticipants`
--

CREATE TABLE `choixparticipants` (
  `idChoix` bigint(20) NOT NULL,
  `choix` date DEFAULT NULL,
  `lieu` varchar(255) DEFAULT NULL,
  `note_id` bigint(20) DEFAULT NULL,
  `participant_mail` varchar(255) DEFAULT NULL,
  `propo_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `createur`
--

CREATE TABLE `createur` (
  `CREATEUR_ID` varchar(255) NOT NULL,
  `motPass` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `createur`
--

INSERT INTO `createur` (`CREATEUR_ID`, `motPass`, `nom`, `prenom`) VALUES
('a@gmail.com', 'azerty', 'keita', 'issa'),
('moussa@gmail.com', 'azerty', 'kone', 'moussa'),
('sekou@gmail.com', NULL, 'sekou', 'keita'),
('ss@gamil.com', NULL, 'qss', 'sss'),
('yao@gmail.com', NULL, 'yao', 'geaon');

-- --------------------------------------------------------

--
-- Structure de la table `datesondage`
--

CREATE TABLE `datesondage` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `propostiondate_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `datesondage`
--

INSERT INTO `datesondage` (`id`, `date`, `propostiondate_id`) VALUES
(1, '2020-05-15', 3),
(2, '2020-05-15', 3),
(3, '2020-05-15', 3),
(4, '2020-05-15', 3),
(5, '2020-05-15', 3),
(6, '2020-05-13', 3),
(7, '2020-09-02', 1),
(8, '2020-09-08', 1),
(9, '2020-05-17', 3),
(10, '2020-09-12', 1);

-- --------------------------------------------------------

--
-- Structure de la table `lieusondage`
--

CREATE TABLE `lieusondage` (
  `id` bigint(20) NOT NULL,
  `lieuSondage` varchar(255) DEFAULT NULL,
  `propoLieu_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `participants`
--

CREATE TABLE `participants` (
  `mail` varchar(255) NOT NULL,
  `motpass` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `sondage_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `participants`
--

INSERT INTO `participants` (`mail`, `motpass`, `nom`, `prenom`, `sondage_id`) VALUES
('keita@gmail.com', NULL, 'keita', 'issa', 3);

-- --------------------------------------------------------

--
-- Structure de la table `reunion`
--

CREATE TABLE `reunion` (
  `id` bigint(20) NOT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `SondageDateID` bigint(20) DEFAULT NULL,
  `SondageLieuID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reunion`
--

INSERT INTO `reunion` (`id`, `intitule`, `SondageDateID`, `SondageLieuID`) VALUES
(1, NULL, 3, NULL),
(2, NULL, 3, NULL),
(3, NULL, 3, NULL),
(4, NULL, 3, NULL),
(5, NULL, 3, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `sondage`
--

CREATE TABLE `sondage` (
  `sondage_type` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `nomSondage` varchar(255) DEFAULT NULL,
  `utilisateur_CREATEUR_ID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sondage`
--

INSERT INTO `sondage` (`sondage_type`, `id`, `nomSondage`, `utilisateur_CREATEUR_ID`) VALUES
('SondageDate', 1, 'sondagetype23', 'a@gmail.com'),
('SondageDate', 2, 'sondagetype', 'a@gmail.com'),
('SondageDate', 3, 'testtest', 'moussa@gmail.com'),
('SondageDate', 4, 'testtesttest', 'moussa@gmail.com'),
('SondageDate', 5, 'testtest', 'moussa@gmail.com');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `alimentation`
--
ALTER TABLE `alimentation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_k9hkyoipxixhhng7snqkwib8v` (`participant_mail`);

--
-- Index pour la table `allergies`
--
ALTER TABLE `allergies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_q44bk3gfyh6986uo86rpg10v8` (`participant_mail`);

--
-- Index pour la table `choixparticipants`
--
ALTER TABLE `choixparticipants`
  ADD PRIMARY KEY (`idChoix`),
  ADD KEY `FK_ln8q40kvi3l51msxe0l6k8luk` (`note_id`),
  ADD KEY `FK_rl7v60h7ofmu46pn4ud0obdmn` (`participant_mail`),
  ADD KEY `FK_dnfle4ki16y53wwk2jd6ymyfp` (`propo_id`);

--
-- Index pour la table `createur`
--
ALTER TABLE `createur`
  ADD PRIMARY KEY (`CREATEUR_ID`);

--
-- Index pour la table `datesondage`
--
ALTER TABLE `datesondage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_8u8odjj6ja0yhvngwri8cjnme` (`propostiondate_id`);

--
-- Index pour la table `lieusondage`
--
ALTER TABLE `lieusondage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_4dqwonhq46eo4ecjoxg1qeohw` (`propoLieu_id`);

--
-- Index pour la table `participants`
--
ALTER TABLE `participants`
  ADD PRIMARY KEY (`mail`),
  ADD KEY `FK_8124s7u60pp94i8wiu8onimwc` (`sondage_id`);

--
-- Index pour la table `reunion`
--
ALTER TABLE `reunion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_k5qbea4qc2muxvfawut242pcs` (`SondageDateID`),
  ADD KEY `FK_4yjgblis0nlrqu2701cpvxdm5` (`SondageLieuID`);

--
-- Index pour la table `sondage`
--
ALTER TABLE `sondage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_ewe3t57elcneup7ehjlds1v3e` (`utilisateur_CREATEUR_ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `alimentation`
--
ALTER TABLE `alimentation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `allergies`
--
ALTER TABLE `allergies`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `choixparticipants`
--
ALTER TABLE `choixparticipants`
  MODIFY `idChoix` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `datesondage`
--
ALTER TABLE `datesondage`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `lieusondage`
--
ALTER TABLE `lieusondage`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reunion`
--
ALTER TABLE `reunion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `sondage`
--
ALTER TABLE `sondage`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `alimentation`
--
ALTER TABLE `alimentation`
  ADD CONSTRAINT `FK_k9hkyoipxixhhng7snqkwib8v` FOREIGN KEY (`participant_mail`) REFERENCES `participants` (`mail`);

--
-- Contraintes pour la table `allergies`
--
ALTER TABLE `allergies`
  ADD CONSTRAINT `FK_q44bk3gfyh6986uo86rpg10v8` FOREIGN KEY (`participant_mail`) REFERENCES `participants` (`mail`);

--
-- Contraintes pour la table `choixparticipants`
--
ALTER TABLE `choixparticipants`
  ADD CONSTRAINT `FK_dnfle4ki16y53wwk2jd6ymyfp` FOREIGN KEY (`propo_id`) REFERENCES `sondage` (`id`),
  ADD CONSTRAINT `FK_ln8q40kvi3l51msxe0l6k8luk` FOREIGN KEY (`note_id`) REFERENCES `sondage` (`id`),
  ADD CONSTRAINT `FK_rl7v60h7ofmu46pn4ud0obdmn` FOREIGN KEY (`participant_mail`) REFERENCES `participants` (`mail`);

--
-- Contraintes pour la table `datesondage`
--
ALTER TABLE `datesondage`
  ADD CONSTRAINT `FK_8u8odjj6ja0yhvngwri8cjnme` FOREIGN KEY (`propostiondate_id`) REFERENCES `sondage` (`id`);

--
-- Contraintes pour la table `lieusondage`
--
ALTER TABLE `lieusondage`
  ADD CONSTRAINT `FK_4dqwonhq46eo4ecjoxg1qeohw` FOREIGN KEY (`propoLieu_id`) REFERENCES `sondage` (`id`);

--
-- Contraintes pour la table `participants`
--
ALTER TABLE `participants`
  ADD CONSTRAINT `FK_8124s7u60pp94i8wiu8onimwc` FOREIGN KEY (`sondage_id`) REFERENCES `sondage` (`id`);

--
-- Contraintes pour la table `reunion`
--
ALTER TABLE `reunion`
  ADD CONSTRAINT `FK_4yjgblis0nlrqu2701cpvxdm5` FOREIGN KEY (`SondageLieuID`) REFERENCES `sondage` (`id`),
  ADD CONSTRAINT `FK_k5qbea4qc2muxvfawut242pcs` FOREIGN KEY (`SondageDateID`) REFERENCES `sondage` (`id`);

--
-- Contraintes pour la table `sondage`
--
ALTER TABLE `sondage`
  ADD CONSTRAINT `FK_ewe3t57elcneup7ehjlds1v3e` FOREIGN KEY (`utilisateur_CREATEUR_ID`) REFERENCES `createur` (`CREATEUR_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
