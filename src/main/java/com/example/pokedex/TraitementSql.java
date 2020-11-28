package com.example.pokedex;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Cette classe traite les information du tableau SQL reçu et les affiche.
 * Ici le traitement colle à ce que renvoie SQLRequest.
 * Pour tout autre classe du type SQLRequest renvoyant un tableau SQL il est conseillé
 * de refaire une classe de traitement adaptée à la requête SQL et aux informations recherché.
 */

public class TraitementSql {

    //Cette classe va traiter le tableau SQL rendu dans le pointeur afin d'extirper les informations sur le pokémon.

    /**
     * Cette fonction affiche les informations du pokedex dans la BDD locale
     * @param rs
     * Le tableau SQL (une ligne) avec les informations du pokemon recherché.
     */
    public static void run(ResultSet rs) {
        try {
            System.out.println("=============================");
            System.out.println("ID : " + rs.getString("id"));
            System.out.println("Nom : " + rs.getString("name"));
            System.out.println("Taille : " + rs.getString("height"));
            System.out.println("Poids : " + rs.getString("weight"));
            System.out.println("Description : " + rs.getString("description"));
            System.out.println("=============================");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

