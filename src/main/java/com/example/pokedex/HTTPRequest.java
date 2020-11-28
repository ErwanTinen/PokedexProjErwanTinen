package com.example.pokedex;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * Cette classe a pour unique but l'acquisition des données en JSON en transmettant une requête HTTP à l'api
 * Ce code fonctionne avec toute sorte de requête HTTP, mais l'on préfèrera utilisé le site de L'API pokemon dans
 * le cadre du TP
 */
public abstract class HTTPRequest {

    /**
     * Cette variable va contenir la réponse à la requête http qui sera renvoyé
     */
    public static HttpResponse result ;



    /**
     *Cette fonction va renvoyer la requête http spécifié en paramètre par l'URL
     * @param url
     * Le paramètre est un URL (on considère que l'information est issue du site PKMN API)
     * @return
     * Le code renvoie une réponse HTTP au format json
     */
    public static HttpResponse run(String url) {
        try {

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url); //On concatène avec args pour avoir l'id correct
            request.addHeader("content-type", "application/json");
            result = httpClient.execute(request);
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        } return result;
    }
}
