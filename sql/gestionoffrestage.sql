-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  localhost
-- Généré le :  Jeu 27 Avril 2017 à 10:46
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestionoffrestage`
--

-- --------------------------------------------------------

--
-- Structure de la table `authentification`
--

CREATE TABLE `authentification` (
  `IDAUTHETIFICATION` int(11) NOT NULL,
  `IDENTIFIANT` varchar(50) NOT NULL,
  `MOTDEPASSE` varchar(100) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `IDTYPE` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `authentification`
--

INSERT INTO `authentification` (`IDAUTHETIFICATION`, `IDENTIFIANT`, `MOTDEPASSE`, `TYPE`, `IDTYPE`) VALUES
(8, 'balbali@gmail.com', '99341aa1b387bfa6df81157a5707362f', 'admin', 0),
(9, 'sara@gmail.com', '5bd537fc3789b5482e4936968f0fde95', 'etudiant', 4),
(10, 'moussa@gmail.com', '639583119441bd84c373c314afd2814d', 'etudiant', 6),
(11, 'rado@gmail.com', 'a18ddce0bdfadd4733e22281498a68ef', 'entreprise', 7),
(14, 'rh@airbus.com', 'd6ef7e1f49eb5f1ffc9a036ced1497d2', 'entreprise', 0),
(15, 'rh@ibisc.fr', 'bd096d6985e19c79006bf3ea56d72fc0', 'entreprise', 0),
(22, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', 0),
(23, 'etu', '30cb132e323a5b4ea923ae211aeabf33', 'etudiant', 0),
(24, 'ent', '645ec79f22bec5efe970061d395cf7c4', 'entreprise', 0);

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE `entreprise` (
  `IDE` int(10) UNSIGNED NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `ADRESSENUMERORUE` varchar(50) NOT NULL,
  `ADRESSECODEPOSTAL` int(5) UNSIGNED NOT NULL,
  `ADRESSEVILLE` varchar(50) NOT NULL,
  `MAIL` varchar(30) NOT NULL,
  `TELEPHONE` varchar(30) NOT NULL,
  `SECTEURACTIVITE` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `entreprise`
--

INSERT INTO `entreprise` (`IDE`, `NOM`, `ADRESSENUMERORUE`, `ADRESSECODEPOSTAL`, `ADRESSEVILLE`, `MAIL`, `TELEPHONE`, `SECTEURACTIVITE`) VALUES
(6, 'epiconcept', '4 Passage de la Boule Blanche', 75012, 'Paris', 'job@epiconcept.com', '01 53 02 40 60', 'santé'),
(7, 'L\'opticien professionnel', '1 avenue Paul Eluard', 75017, ' Paris 17e', 'rh@opticien.fr', '0123875432', 'informatique'),
(8, 'Montem Concept', '11 bd de France', 91000, 'Evry', 'rh@montem.fr', '657893265', 'devellopement'),
(9, 'Afii assurances', '21 rue bois guillaume', 91000, 'Evry', 'rh@afii.fr', '643578631', 'Comptabilité'),
(10, 'beapi', '6 av François Mitterand', 77000, 'paris', 'rh@beapi.fr', '654627142', 'web'),
(11, 'Changed', 'Changed-3', 2344, 'Changed', 'value-6@g.com', '6578923', 'value-8');

-- --------------------------------------------------------

--
-- Structure de la table `offrestage`
--

CREATE TABLE `offrestage` (
  `IDO` int(10) UNSIGNED NOT NULL,
  `IDE` int(10) UNSIGNED NOT NULL,
  `LIBELLEOFFRE` varchar(50) NOT NULL,
  `DESCRIPTIFOFFRE` text NOT NULL,
  `DOMAINEOFFRE` varchar(50) NOT NULL,
  `DATEDEBUTOFFRE` date NOT NULL,
  `DUREEOFFRE` int(10) UNSIGNED NOT NULL,
  `CHEMINOFFRE` varchar(50) NOT NULL,
  `VALIDE` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `offrestage`
--

INSERT INTO `offrestage` (`IDO`, `IDE`, `LIBELLEOFFRE`, `DESCRIPTIFOFFRE`, `DOMAINEOFFRE`, `DATEDEBUTOFFRE`, `DUREEOFFRE`, `CHEMINOFFRE`, `VALIDE`) VALUES
(7, 6, 'DevOps', 'intégré(e) au sein de l’équipe infrastructure d’EpiConcept, vous faites partie d\'une équipe de spécialistes « les plateformes » supports pour les équipes projets.', 'santé', '2017-05-03', 2, 'http://www.epiconcept.fr/', 1),
(8, 8, 'stage developpement informatique h/f Evry', 'Analyse et développement d\'un logiciel de relation client, de gestion de document et commercial et base de donnée avec windev et sql.\r\n\r\nMise en production monté en charge et test\r\n\r\nRéalisation des documentations commerciales', 'devellopement', '2017-04-01', 3, 'https://www.bacplusdeux.com/stage/offre-stage', 0),
(9, 7, 'CHARGE DE SUPPORT EN UNIVERS WEB & MOBILE', 'Rattaché au responsable du support dans un environnement demandant rapidité, autonomie et flexibilité, vous suivez l\'état de la production de nos clients et accomplissez les différentes missions du support permettant d\'assurer la qualité du service.\r\n\r\nAmour de l\'informatique, débrouillardise, curiosité et gout du challenge vous accompagnerons dans ce poste tout en bénéficiant dune formation interne pour votre prise de vos fonctions.', 'devellopement', '2017-04-01', 2, 'http://www.kapstages.com/fiche/offre/150130', 1),
(10, 9, 'stage developpement web front-end', 'Nous recherchons un développeur Web en Stage pour rejoindre notre start-up !\r\n\r\nEn tant que développeur Web, vous serez amené à travailler sur des projets en interne orientés :\r\nRefonte de site web\r\nDéveloppement de modules supplémentaires\r\nDéveloppement d\'applications Data Driven\r\nCorrection de bugs ', 'télécom (Développement, Génie logiciel)', '2017-05-02', 6, 'http://jobs-stages.letudiant.fr/stages', 0),
(11, 10, 'Développeur Web Javascript', 'La mission que nous proposons est destinée à un profil technique assumé.\r\nNous cherchons notre prochain développeur F/H Web désireux de développer un code clean, scalable et robuste ; quelqu\'un prêt à s\'investir pleinement avec une équipe forte et motivée pour intervenir dans un environnement agile au sein d\'une Startup en hyper croissance ! ', 'Comptabilite', '2017-06-01', 2, 'http://jobs-stages.letudiant.fr', 0),
(12, 11, 'Stage chargé de marketing web e-CRM', 'Rattaché(e) au chef de projet e-CRM (équipe Audience et Business Développement), vous participerez à l’animation et au pilotage quotidien des campagnes d’e-mailings des sites du groupe (www.lexpress.fr, www.cotemaison.fr).\r\n\r\nVos principales missions seront :\r\n\r\n• Prendre en charge la création et la gestion de campagne d’emailings (éditoriaux et promotionnels) :\r\n- Suivi quotidien du planning d’envoi', 'web', '2017-08-01', 3, 'http://jobs-stages.letudiant.fr', 1),
(13, 6, 'devellopeur full stack', 'php\nmysql\nhtml, css, javascript', 'Developpement', '2017-04-22', 3, '', 1);

-- --------------------------------------------------------

--
-- Structure de la table `postuler`
--

CREATE TABLE `postuler` (
  `IdPostuler` int(11) NOT NULL,
  `IdOffre` int(11) UNSIGNED NOT NULL,
  `IdUtilisateur` int(11) UNSIGNED NOT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `postuler`
--

INSERT INTO `postuler` (`IdPostuler`, `IdOffre`, `IdUtilisateur`, `statut`) VALUES
(1, 10, 6, 0);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `IDUTILISATEUR` int(11) UNSIGNED NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) NOT NULL,
  `SEXE` varchar(30) NOT NULL,
  `ADRESSE` text NOT NULL,
  `MAIL` varchar(30) NOT NULL,
  `DESCRIPTION` text NOT NULL,
  `DATE` date NOT NULL,
  `ADMINISTRATEUR` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`IDUTILISATEUR`, `NOM`, `PRENOM`, `SEXE`, `ADRESSE`, `MAIL`, `DESCRIPTION`, `DATE`, `ADMINISTRATEUR`) VALUES
(4, 'meslaha', 'sara', 'femme', '23 bd de France\r\n91000 evry', 'sara@gmail.com', 'cherche un stage dans le cadre de la licence miage', '2017-04-12', 0),
(5, 'andria', 'rado', '', '21 route de narbonne\r\n31400 toulouse', 'rado@gmail.com', 'cherche un stage dans le cadre de la licence miage', '2017-04-05', 0),
(6, 'ambidina', 'moussa', 'homme', '23 rue corrot\r\n91380 st michel sur orge', 'moussa@gmail.com', 'cherche un stage dans le cadre de la licence miage', '2017-04-11', 0),
(8, 'nonTest', 'prTest', 'Femme', 'adrTest', 'mail@test.fr', 'descTest', '2017-04-13', 0),
(9, 'n1Test', 'prTst', 'Femme', 'adTest', 'm@mail.com', 'descr', '2017-04-21', 0);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `authentification`
--
ALTER TABLE `authentification`
  ADD PRIMARY KEY (`IDAUTHETIFICATION`);

--
-- Index pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`IDE`);

--
-- Index pour la table `offrestage`
--
ALTER TABLE `offrestage`
  ADD PRIMARY KEY (`IDO`,`IDE`),
  ADD KEY `fk_ide_offrestage` (`IDE`);

--
-- Index pour la table `postuler`
--
ALTER TABLE `postuler`
  ADD PRIMARY KEY (`IdPostuler`),
  ADD KEY `IdOffre` (`IdOffre`),
  ADD KEY `IdUtilisateur` (`IdUtilisateur`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`IDUTILISATEUR`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `authentification`
--
ALTER TABLE `authentification`
  MODIFY `IDAUTHETIFICATION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT pour la table `entreprise`
--
ALTER TABLE `entreprise`
  MODIFY `IDE` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT pour la table `offrestage`
--
ALTER TABLE `offrestage`
  MODIFY `IDO` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `postuler`
--
ALTER TABLE `postuler`
  MODIFY `IdPostuler` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `IDUTILISATEUR` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `offrestage`
--
ALTER TABLE `offrestage`
  ADD CONSTRAINT `fk_ide_offrestage` FOREIGN KEY (`IDE`) REFERENCES `entreprise` (`IDE`);

--
-- Contraintes pour la table `postuler`
--
ALTER TABLE `postuler`
  ADD CONSTRAINT `postuler_ibfk_1` FOREIGN KEY (`IdOffre`) REFERENCES `offrestage` (`IDO`),
  ADD CONSTRAINT `postuler_ibfk_2` FOREIGN KEY (`IdUtilisateur`) REFERENCES `utilisateur` (`IDUTILISATEUR`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
