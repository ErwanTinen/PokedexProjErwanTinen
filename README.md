
# Pokedex

by Erwan Tinen Touolac

After cloning this repository, if you have a Java environment on your machine, you can directly run the commands.


## Build the project

```
./gradlew build
```

## SQLite Database

Put your pokemon database in the ressource folder if you want to use one
Don't forget to change the path to the folder in the main.

## Run the application

Enter the id of the pokemon you are looking for
```
./gradlew run --args="PokemonID"
```

If you want information from a SQL database mention de name of the database as a
seconde argument.
EX:

```
./gradlew run --args="PokemonID pokemon.sqlite"
```


## Run the tests

```
./gradlew test
```