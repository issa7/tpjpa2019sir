# Compte rendu de backend du projet Doodle
l'objectif du projet est de faire une application de prise de rendez vous de type Doodle.
D'abord ce application nous permet de creer un sondage par un ulisateur avec differents type de choix de date ou lieu.
Par la suite,les participants participe au sondage grace a leur mail.

## architecture du projet
cette partie du projet correspond au partie backend du projet. Elle est divisé en trois couche 
### couche JPA 
cette couche contient des classes java et ces classes java sont tronformés par la suite en Entité JPA, ses entités sont rendu persistant pour etre enregister dans la base de données
###  couche DAO
cette couche contient des classes dao qui permet de regrouper les accès aux données persistantes dans les classes objets. il permet 
d'abstraire la facon dont les données sont stockées au niveau des objets metiers. Ainsi le changement de mode de stockage ne remet pas en cause le reste de l'application
### Couche service 
cette couche permet definir les service notre API propose. nous avons utilisé l'APi JAX RS et le Framework Jersey qui permet de definir les service web selon l'architecture REST 

## Diagramme de classe de la partie JPA 
![Diagramme de classe](diagrammeClasse.gif)
