# Projet Microservice M2 INTENSE 2022/2023  
## Dans le but de la validation du module Développement par composants logiciels encadré par Mr. Marwen SAIDI  
__Technologies suivantes :__  
  - Java (1.8/11)  
  - Spring Boot 1.x.x  
  - Maven 3.x.x  

__Outils utilisés :__  
  - Actuator  
  - Circuit breaker : Hystrix (Netflix)  
  - Discovery Eureka  
  - Swagger 2  

## Microservice "my-movie" Port: 8011  
__Explication__  
Ce microservice est un projet Spring-Boot développé pour gérer les informations sur les films et les acteurs. Il a été conçu pour fournir une solution pour stocker, afficher et filtrer les informations sur les films et les acteurs.  

__Utilisation__  
  - Clonez le projet à partir du référentiel Github.  
  - Exécutez la commande __'mvn clean install'__ pour construire le projet.  
  - Exécutez la commande __'mvn spring-boot:run'__ pour démarrer le microservice ou sinon executez la classe main __'MyMovieApplication.java'__.  
  - L'URL pour accéder à la documentation Swagger pour ce microservice serait: __'http://localhost:8011/swagger-ui.html'__.  
__Films:__  
  - Pour obtenir la liste de tous les films : __'http://localhost:8011/films'.__  
  - Pour obtenir un film par titre : __'http://localhost:8011/titre/{titre}'__.  
  - Pour obtenir la liste des films selon l'année de sortie : __'http://localhost:8011/annee/{annee}'__. 

__Acteurs:__  
  - Pour obtenir la liste de tous les acteurs : __'http://localhost:8011/acteurs'.__  
  - Pour obtenir un acteur par nom : __'http://localhost:8011/nom/{nom}'__.  
  - Pour obtenir la liste des acteurs pour un film donné : __'http://localhost:8011/film/{titre}'__.  


## Microservice "my-finder" Port: 8080  
__Explication__  
Le microservice my-finder est une application Spring Boot qui accède à tout ce qui est exposé par my-movie et l'expose à son tour sur un endpoint particulier. Si un ou plusieurs endpoints de my-movie sont indisponibles, my-finder ne plante pas mais affiche simplement un message d'indisponibilité ou une alternative.  

__Endpoints exposés__  
Ce microservice expose les endpoints suivants :  

/films : renvoie la liste des films disponibles  
/films/{id} : renvoie les détails d'un film spécifique  
/health : renvoie l'état de santé du microservice my-movie  

__Utilisation de Swagger2__  
Swagger2 est utilisé pour décrire les méthodes exposées par ce microservice. Les développeurs peuvent utiliser l'interface Swagger pour tester les fonctionnalités de my-finder.  

__Vérification de l'état de santé__  
My-finder inclut une méthode pour vérifier l'état de santé de my-movie. Si my-movie est en bonne santé, le statut HTTP 200 OK est renvoyé. Sinon, le statut HTTP 500 Internal Server Error est renvoyé.  

__Endpoint actuator Prometheus__  
My-finder expose l'endpoint actuator Prometheus qui peut être utilisé pour surveiller les métriques de l'application.  

__Eureka Client__  
My-finder est enregistré en tant que client Eureka, ce qui permet à l'application de s'inscrire dans un cluster Eureka.  

__Dashboard Hystrix__  
My-finder inclut un dashboard Hystrix qui peut être utilisé pour surveiller la disponibilité et la performance de l'application.  

## Microservice "my-dashboard" Port: 8761  
Il expose un tableau de bord Eureka pour les microservices qui s'enregistrent avec lui.  

Il est important de noter que ce microservice est l'administrateur de Eureka.  

__Les fonctionnalités principales de ce microservice comprennent :__  

  - Exposition du tableau de bord Eureka
  - Exposition du dashboard Hystrix du microservice "my-finder"
  - URL du tableau de bord Eureka
  - L'URL du tableau de bord Eureka est accessible via l'URL suivante : __'http://localhost:8761/eureka'__  
  - Le dashboard Hystrix est accessible via l'URL suivante : __'http://localhost:8761/eureka'__  
  
