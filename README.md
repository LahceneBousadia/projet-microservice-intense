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

## Microservice "my-movie"  
__Explication__  
Ce microservice est un projet Spring-Boot développé pour gérer les informations sur les films et les acteurs. Il a été conçu pour fournir une solution pour stocker, afficher et filtrer les informations sur les films et les acteurs.  

__Utilisation__  
  - Clonez le projet à partir du référentiel Github.  
  - Exécutez la commande __'mvn clean install'__ pour construire le projet.  
  - Exécutez la commande __'mvn spring-boot:run'__ pour démarrer le microservice ou sinon executez la classe main __'MyMovieApplication.java'__.  
  - L'URL pour accéder à la documentation Swagger pour ce microservice serait: __'http://localhost:8011/swagger-ui.html'__.  
  - Vous devriez également être en mesure d'accéder à la liste des films disponibles en utilisant l'URL suivante: __'http://localhost:8011/films'.__  
  - Pour accéder à un film spécifique en fonction de son titre, vous pouvez utiliser l'URL suivante: __'http://localhost:8011/titre/{titre}'__.  
  - Et pour accéder à un film spécifique en fonction de son année de sortie, vous pouvez utiliser l'URL suivante: __'http://localhost:8011/annee/{annee}'__.  

## Microservice "my-finder"  
__Explication__  
Le microservice my-finder est une application Spring Boot qui accède à tout ce qui est exposé par my-movie et l'expose à son tour sur un endpoint particulier. Si un ou plusieurs endpoints de my-movie sont indisponibles, my-finder ne plante pas mais affiche simplement un message d'indisponibilité ou une alternative.  

__Endpoints exposés__  
Ce microservice expose les endpoints suivants :  

/movies : renvoie la liste des films disponibles  
/movies/{id} : renvoie les détails d'un film spécifique  
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
