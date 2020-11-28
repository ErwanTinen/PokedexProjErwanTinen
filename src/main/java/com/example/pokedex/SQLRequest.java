package com.example.pokedex;

import java.sql.ResultSet;

/**
 * Cette classe va effectuer une requête précise SQL sur une BDD SQL donnée
 *
 */
public class SQLRequest extends SQLRequestMethod {

    /**
     * Cette variable contient la requête SQL que l'on souhaite effectuer
     */
    protected static String test = "SELECT * FROM pokemons WHERE id = ?";

    /**
     * Cette fonction permet d'obtenir le tableau SQL.
     * Il est recommandé de suivre ce schéma si l'on souhaite créer une autre classe effectuant une requête SQL
     * @param args
     * Contient l'id du pokemon recherché
     * @return
     * Renvoie un pointeur sur le tableau SQL obtenue avec la requête
     */
    public static ResultSet prompt(String args){
        SQLRequest.Setreq(test);
        return SQLRequest.run(args);
    }


}