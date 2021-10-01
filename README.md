## Exemple Spring Boot Data MongoDB - CRUD
Spring Data est un projet parapluie qui contient de nombreux sous-modules, chacun spécifique à une base de données particulière.
Dans ce projet, nous couvrirons Spring Data MongoDB en créant une application qui stocke et récupère les données de MongoDB, 
une base de données NoSQL basée sur des documents.<br/>

Dans ce projet, nous verrons comment créer une API REST en Java avec Spring Boot avec une base de données 
NoSQL MongoDB et des requêtes POST/GET/PUT/DELETE et des requêtes personnalisées d'une classe de modèle de collection `Candidate`.

### Qu'est-ce que MongoDB ?
---
**MongoDB** est une base de données NoSQL orientée document qui stocke des documents de type JSON 
avec des schémas dynamiques. Il est couramment utilisé pour le stockage de données à haut volume.

### Termes de la base de données NoSQL
---
* **Base de données** : C'est un conteneur pour les collections et peut être considéré comme similaire à une base de données SGBDR, qui est un conteneur pour les tables.
* **Collection** : C'est l'équivalent des Tables dans le SGBDR, mais contrairement à une collection, il a un schéma dynamique. Une collection existe dans une base de données.
* **Document** : C'est un enregistrement unique dans une collection MongoDB. Il peut être considéré comme une ligne dans le SGBDR.
* **Field** : Un document a zéro ou plusieurs champs. C'est comme une colonne SGBDR ayant une paire clé-valeur.

### Prérequis
---
Pour ce projet, vous auriez besoin des spécifications suivantes :
- Spring Boot v2.0+
- JDK v1.8+
- Maven 3+ ou Gradle 4+ - outil de construction
- Tout IDE prenant en charge Java et Spring Boot (Spring Tool Suite (STS), IntelliJ, VSC, NetBeans, etc.)
- Postman, curl ou n'importe quel client HTTP pour tester l'API REST
- Mongo 4.4

### Dependances Maven
---
Dans ce projet nous allons utiliser les dependances Maven suivants :<br/>
- **Spring Web** - Pour inclure Spring MVC et utilise le tomcat comme conteneur intégré par défaut.
- **spring-boot-starter-data-mongodb** - Stocke les données et les récupère à partir de MongoDB.
- **Spring Boot DevTools** - dépendance pour les rechargements automatiques ou le rechargement en direct des applications.
- **Mapstruct** un mappeur Java Bean. Cette API contient des fonctions qui mappent automatiquement entre deux Java Beans (DO to DTO et DTO to DO).
- **springdoc-openapi-ui** dépendances pour la documentation de l'API Swagger 3.

### Architecture technique
---
Cette image présente l'architecture globale du projet.<br/><br/>
![Archi_technique](https://user-images.githubusercontent.com/75081354/135291725-ce0ff30f-d992-4579-82ba-55c4da07505c.jpg)

Le module au cœur du Spring Framework (Spring Core) repose fondamentalement sur un seul principe de conception objet : 
l’inversion de contrôle.<br/>
	
L'**Inversion de contrôle (Spring IOC)** permet au développeur de s'occuper uniquement du code metier (Exigences fonctionnelles) 
et c'est le Framework qui s'occupe du code technique (Exigences Techniques).

### Exigences technique
---
* Un client web (Browser) communique avec le serveur web (Apache) en utilisant le protocole HTTP
* Les données sont stockées dans MongoDB
* L'application est composé de 4 couches :
	- La couche de données (model) pour les classes entités (DO et DTO).
	- La couche DAO (Spring Data, MongoRepository) pour interagir avec la base de données MongoDB.
	- La couche métier pour le traitement de la logique métier.
	- La couche infrastructure (controller) basée sur Rest API pour traiter la logique d'entreprise.

### Annotations
---
* `@Document` : Ceci marque la classe comme un objet de domaine qui sera persisté dans la base de données. Le nom de collection par défaut utilisé est le nom de la classe (premier caractère en minuscule).
* `@Id` : Ceci marque le champ utilisé à des fins d'identité.
* `@Indexed(unique = true)` : Ceci est appliqué au champ qui sera indexé avec une contrainte d'unique.

### Tester les APIs REST
---
`$ mvn spring-boot:run`<br/>

Pour tester les APIs vous pouvez utiliser Postman, Swagger, curl ou n'importe quel candidate HTTP :<br/>
* POST `/api/candidates/add` - Enregistrer le détail candidat vers la base de données
* PUT `/api/candidates/update` - Mettre à jour le candidat existant à partir de la base de données
* GET `/api/candidates/findall` - Récupérer tous les candidats de la base de données
* GET `/api/candidates/get/{id}` - Récupérer un seul candidat à partir de la base de données
* GET `/api/candidates/findByName?page=0&size=5&name=mot-clé` - Consulter les candidats dont le nom contient un mot clé + pagination
* GET `/api/candidates/findByEmail?email=mot-clé` - Consulter un candidat dont l'email contient un mot clé
* GET `/api/candidates/findByExp?exp=#` - Consulter les candidats dont Exp contient à une valeur donnée
* GET `/api/candidates/findByExpBetween?from=#&to=#` - Consulter les candidats dont Exp contient entre les valeurs données
* DELETE `/api/candidates/delete/{id}` - Supprimer un candidat existant de la base de données
* DELETE ALL `/api/candidates/deleteall` - Supprimer tous les candidats de la base de données

Une fois l'application lancer il faut vérifier que le swagger est UP en checkant l'url suivante : `http://localhost:8080/v3/api-docs` <br/>
Utilisez un client REST comme postman pour importer la collection des WS en utilisant url : `http://localhost:8080/v3/api-docs`

### Conclusion
---
Dans ce projet, nous avons expliqué comment utiliser Spring Data MongoDB pour se connecter à un serveur MongoDB. 
Nous avons effectué une opération CRUD simple et écrit des requêtes personnalisées.		
