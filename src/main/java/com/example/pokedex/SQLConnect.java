package com.example.pokedex;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Cette classe permet la connection à la base de donnée SQL dont on a spécifié l'URL
 * Toute classe fille définissant des méthode en SQL doit descendre de cette classe
 */
public abstract class SQLConnect {
    /**
     *Cette variable contient les information à propos de la connection à la base SQL
     */
    protected static Connection conn ;

    /**
     * Cette fonction réalise la connection à la base SQL et insère cette information dans la variable conn
     * @param url
     * Contient l'url qui mène directement à la base de donnée SQL
     * @return
     * Renvoie conn, un objet de la classe Connection qui permet de se connecter à la base de donnée SQL.
     */
    public static Connection connect(String url){
        try{
            SQLiteConfig config = new SQLiteConfig();
            config.setEncoding(SQLiteConfig.Encoding.UTF8);

            conn = DriverManager.getConnection(url, config.toProperties());
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }

}
