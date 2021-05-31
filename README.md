# annuaire

Avant tout je tiens à m'excuser pour la qualité du travail fourni dans ce projet qui n'est pas extravagante. 
Malgré le fait d'avoir investi de nombreuses heures à essayer de créer un client web fonctionnel je n'ai pas réussi. En fait je n'ai encore jamais développé un client web avec un front.
Pour ce qui est du serveur, j'ai créé une base de données Postgres et j'ai déployé le serveur sur un serveur Tomcat 9. J'y ai créé les différentes Servlets du CRUD ainsi que les tags et les jsp.


## Prérequis ##

1. Pour le base de donnée il s'agit d'un bdd PosgreSQL. Si vous n'avez pas encore Postgres d'installé vous pouvez le télécharger ici: 
https://www.postgresql.org/download/

2. Pour le serveur j'ai utilisé un Apache Tomcat, pareil si vous ne l'avez pas encore installé il est disponible ici:
https://tomcat.apache.org/download-90.cgi

## Pour démarrer le serveur ##

1. Il faut que vous accédiez à votre PostgreSQL pour créer une nouvelle base de données vierge, personellement je l'ai nommé "annuaire" mais le nom n'est pas important.
2. Ouvrez le projet "Serveur" dans votre environnement de développement, et ouvrez le fichier ENVIRONEMENT.properties qui se situe dans dans le dossier src/main/resources/utils et renseignez l'url de votre pase de donnée, votre nom d'utilisateur et votre mot de passe dans les champs dédié.
3. Dans src/main/java/utils/DatabaseMigration.java exécutez la méthode main. Celle-ci va vous créer la table personne dans votre bdd et insérer les données automatiquement.
4. Maintenant vous devriez avoir une base de donnée fonctionnelle, maintenant il vous suffit de créer une run configuration avec votre serveur tomcat et de lancer le projet.
