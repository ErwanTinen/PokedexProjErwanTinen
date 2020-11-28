package com.example.pokedex;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Cette classe a pour vocation d'être la classe mère de toute forme de classe du type "DisplayJsonDex"
 * Le paramètre resultObject contient le text au format dont on tire les informations.
 * Ainsi, Si l'on veut programmer un autre display, on le fait hérité de cette classe abstraite et on traite les données
 * contenues dans resultObject
 */
public abstract class AbstractJson {

    /**
     * Cette variable stock l'objet Json qui est ensuite utilisé par une classe qui affichera les informations
     * contennue
     */
    protected static Object resultObject ;

    /**
     * Cette fonction a pour unique but de set le paramètre resultObject
     *
     * @param result
     * Ce paramètre est la réponse renvoyé par la requête HTTP (dans le contexte, la réponse de l'API pokemon)
     */
    public static void parse(HttpResponse result) {
        String jsonResponse = "";

        try {
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

            JSONParser parser = new JSONParser();
            resultObject = parser.parse(jsonResponse);

        } catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(jsonResponse);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
