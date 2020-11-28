package com.example.pokedex;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Cette classe travaille uniquement avec les objets Json renvoyé par l'API pokemon, selon une requête HTTP :
 * https://pokeapi.co/api/v2/pokemon/***
 * où *** peut être remplacer par l'ID ou le nom
 * Elle lit et affiche id/nom/taille/poids du pokémon
 *
 */
public class DisplayJsonDex extends AbstractJson {


    /**
     *Cette méthode va uniquement afficher les informations désirées en Json
     * @param result
     * Le paramètre est une réponse HTTP au format Json.
     */
    public static boolean run(HttpResponse result){
        // On utilise cette fonction afin de mettre à jour la variable resultObject dont on tire les informations avec la méthode
        AbstractJson.parse(result);
        Boolean works = false;
        if (resultObject instanceof JSONObject) {
            JSONObject obj =(JSONObject)resultObject;
            System.out.println("=============================");
            System.out.println("Pokemon #" + obj.get("id"));
            System.out.println("nom " + obj.get("name"));
            System.out.println("Taille : " + obj.get("height"));
            System.out.println("Poids : " + obj.get("weight"));
            System.out.println("=============================");
            works = true; //Si on entre dans ce if, alors le test est réussi
        } else {
            System.err.println("Error, we expected a JSON Object from the API");
        }

        return works; //permet de vérifier que le code est allez au bout pour le test
    }


}
