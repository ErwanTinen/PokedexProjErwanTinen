package com.example.pokedex;


import org.apache.http.HttpResponse;
import java.sql.ResultSet;
import org.apache.http.client.methods.HttpGet;

import java.sql.SQLException;

public class Pokedex {



    public static void main(String[] args) {
        System.out.println("It's working !");
        if (args.length > 0) {
            System.out.println("Vous avez fourni l'argument " + args[0]);
        }

        // Il est important de modifier le chemin de la base de donnée pour que cela fonctionne
        String databaseURL= "jdbc:sqlite:D:\\Ecole\\Cours\\2A\\TP3\\Bonne pratique dev logi\\Proj\\emse_solid_lesson\\PokedexProject\\ressuources\\";

        int len = args.length;

        //  Selon que la base de donnée soit mentionné ou pas on va inclure le chemin de la base de donnée
        // Les processus de la base de donnée Dex verifierons ensuite si le chemin est vlaide
        PokemonController Dex;
        switch (len) {
            case 2:
                Dex = new PokemonController(args, databaseURL);
                break;
            default:
                Dex = new PokemonController(args);

                break;
        }
        Dex.call();

    }

    public String getName() {
        return "Hello";
    }
}
