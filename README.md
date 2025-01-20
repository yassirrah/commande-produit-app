# Commande et Produit Microservices avec API Gateway, Eureka Server, Config Server, et UI

Ce projet implémente un système avec des microservices pour la gestion des `Commandes` (orders) et des `Produits` (products). Les microservices sont enregistrés avec **Eureka** pour la découverte de services, et **API Gateway** achemine les demandes vers le microservice approprié. Le système inclut également un **Config Server** pour la gestion centralisée de la configuration et une simple **interface utilisateur front-end** pour interagir avec les services.

## Structure du Projet

Le projet est divisé en plusieurs composants :

1. **Eureka Server** : Un registre de services pour gérer et découvrir les services.
2. **Config Server** : Fournit une configuration centralisée pour les microservices.
3. **API Gateway** : Achemine les demandes vers les microservices appropriés.
4. **Commande Service** : Gère les commandes (Commandes).
5. **Produit Service** : Gère les produits (Produits).

## Technologies Utilisées

- **Spring Boot** pour les microservices.
- **Spring Cloud Eureka** pour la découverte de services.
- **Spring Cloud Gateway** pour l'acheminement des demandes et l'API Gateway.
- **Spring Cloud Config Server** pour la gestion centralisée de la configuration.
- **Feign** pour la communication entre le `Commande Service` et le `Produit Service` afin de vérifier les ID des produits
- **GitHub** pour le contrôle de version et l'hébergement du dépôt.
