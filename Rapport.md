# Pokedex

par Erwan Tinen Touolac

## Introduction

On dévellope 8 classes en tout 7 d'entre elles servent de composant de base à notre programme. Et une d'entre elle est un controleur qui va mettre en relation toutes ces classes ainsi que toutes leurs fonction afin d'afficher dans la console les informations du pokedex de l'API ou de la base de données local

La liste est la suivante :
AbstractJson
DisplayJsonDex
HTTPRequest
Pokedex
Pokemon Controller
SQLConnect
SQLRequest
SQLRequestMethod
TraitementSql

## Résumé des classes crée

Le classe pokedex possède la méthode main qui va simplement executer PokemonController afin de lancer le processus complet.

La classe PokemonController manipule les classes non abstraites afin d'effectuer une requête.
Attention ! Cette classe a été conçu spécialement pour renvoyer ce qui est demandé par le TP. Si l'on souhaite étendre le code et renvoyer d'autres information à l'image, il faut coder une autre classe en se basant sur PokemonController afin d'eviter les erreurs.

### Processus HTTP

HttpRequest : classe très généralisé qui renvoie simplement la réponse à une requête http précise.
On préferera l'utilisé ici avec l'url qui nous donnera des informations sur le pokemon.

AbstractJson : Classe abstraite qui rempli une responsabilité qui est de parse les données Json et de les rendres disponibles à toute les classes filles à travers la variable resultObject.

DisplayJsonDex : descend d'AbstractJson et va uniquement afficher le contenue de la requête HTTP.

### Processus SQL

SQLConnect : Permet la connection à la base SQL dont on a spécifié l'URL.

SQLRequestMethod : Classe abstraite qui descend de SQLConnect et possède la méthode permettant definir une requête SQL ainsi que celle permettant de se connecter à la base de donnée.  Toute classe fille définissant une requête SQL doit descendre de cette classe.


SQLRequest : Descend de SQLRequestMethod qui définit une requête SQL et l'effectue.

TraitementSQL : Classe qui permet l'affichage des données extraite du tableau SQL.

## Respect des principes SOLID

### Principe Single responsability
Le premier principe est bien respecté si on regarde le résumé des classes. Chaque classe rempli un rôle précis et les fonctions employés ont un seul et unique but.

### Principe Open-closed
Le code est très ouvert à l'extansion, Il faut parfois cependant modifier le code de la classe PokemonController pour avoir le résultat souhaiter à l'écran, ou coder entièrement un nouveau controleur en se basant sur PokemonController. 

Les classes mères sont explicitement défini (voir JavaDoc et résumé). Par exemple si l'on souhaite avoir d'autres informations de l'API, on crée une classe similaire à DisplayJson qui descend de AbstractJson.

Pareil si l'on souhaite créer une autre requête SQL, il faut créer une classe fille de SQLRequestMethod et se baser sur SQLRequest.
D'aileurs si cela est fait, il est conseillé de créer une autre classe TraitementSql pour s'assurer que l'on travaille avec les bonnes colonnes obtenues après la requête

### Principe Liskov substitution

Si l'on respecte l'esprit general du code, il est facile de remplacer les classes utilisée par d'autres codées dans le même resprit (par exemple une classe similaire à DisplayJsonDex).

Un test sur DisplayJsonDex permet de montrer que le principe est compris.

### Principe D

Les classes descendent systématiquement d'abstraction quand cela est possible. On peut obxserver la relation entre SQLConnect, SQLRequestMethod et SQLRequest.

## Ajout de fonctionnalité 

On pourrait imaginer que l'on puisse faire d'autre classes types DisplayJsonDex, TraitementSQL, et SQLRequest afin d'afficher des données différentes, sachant nottament que l'API est vraiment riche en donnée.

On peut aussi imaginer des recherches par nom (j'ai essayé de faire quelques test et ça fonctionnait bien).

On pourrait même étendre l'exploitation de l'API à la recherche de capacité.

Il serait interessant aussi d'étendre la base de donnée SQL pour avoir plus d'information.

## Remarques

Alors la recherche dans la base de donnée SQL marchait lorsque je lançais le programme depuis intelliJ mais pas depuis la console pour une raison que j'ignore.