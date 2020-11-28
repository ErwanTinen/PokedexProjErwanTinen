package com.example.pokedex;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Cette classe abstraite existe uniquement pour que tout autre classe de requête SQL descende d'elle.
 * En effet, elle contient la méthode qui va renvoyer un pointeur sur le tableau.
 * Et la méthode qui permet de "set" une requête.
 * Il suffit donc de faire des classes filles redéfinissant la variable req.
 *
 * Attention, cette classe ne fonctionne qu'avec des requêtes avec "WHERE id=?"
 */
public abstract class SQLRequestMethod extends SQLConnect {

    /**
     * Cette variable contiendra la requête SQL et sera modifié via le setter utilisé par les classes filles
     */
    protected static String req = "";

    /**
     * Cette classe est simplement un setter pour la variable txt.
     * Elle doit être utilisé par les classes filles souhaitant faire des requêtes SQL.
     * @param txt
     * Variable contenant la requête SQL
     */
    protected static void Setreq(String txt){
        req = txt;
    }

    /**
     * Cette fonction doit être utilisé par les classes filles selon un schéma prédéfini.
     * Cette fonction renvoie un pointeur sur un tableau SQL qui peut ensuite être exploité.
     *
     * @param args
     * Contient l'id du pokemon recherché
     * @return
     * Un pointeur sur le tableau SQL désiré
     */
    public static ResultSet run(String args) {
        ResultSet rs = null;

        int i = Integer.parseInt(args);
        try {
            PreparedStatement stmt  = conn.prepareStatement(req);
            stmt.setInt(1, i);
            rs    = stmt.executeQuery();
            rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;

    }
}

