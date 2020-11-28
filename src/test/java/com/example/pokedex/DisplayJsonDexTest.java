package com.example.pokedex;


import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * Simple class de test pour le display qui est de type vue
 * comme quoi la dependency inversion est vérifié.
 */
public class DisplayJsonDexTest {

    public String testURL = "https://pokeapi.co/api/v2/pokemon/1";
    HttpResponse result = HTTPRequest.run(testURL);


    @Test
    public void run(){
        DisplayJsonDex vue = new DisplayJsonDex();
        Assert.assertEquals(true, vue.run(result));

    }
}