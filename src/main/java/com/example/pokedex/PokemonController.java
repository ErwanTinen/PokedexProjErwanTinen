package com.example.pokedex;

import org.apache.http.HttpResponse;

import java.sql.ResultSet;

/**
 * Cette classe va activer les autres élements du package (vue et modèle) afin qu'on passe d'une requête
 * de l'utilisateur à l'affichage du pokedex.
 * Ici c'est un controler specialisé pour obtenir le résultat demandé par le TP
 */
public class PokemonController {

    /**
     * Cette variable stock le chemin menant au dossier où il y a les bases de données SQL
     */
    protected String databaseURL;

    /**
     * Cette variable stock l'entrée en console
     */
    protected String[] args;
    /**
     * Ce booleén permet de terminer si c'est bien un chiffre qui est rentré
     */
    boolean isNumber = false;
    /**
     * Ce booléen permet de dire à la fonction si c'est bien la base de donnée qu'il faut questionner
     */
    boolean useDataBase = false;


    PokemonController(String[] args){
        this.args = args;
    }

    PokemonController(String[] args,String databaseURL  ){
        this.databaseURL = databaseURL + args[1];
        this.args = args;
    }

    /**
     * Cette fonction est la fonction principal qui articule tout les autres sous fonction de la classe
     * on test au fur et à mesure la requête entrée par l'utilisateur pour savoir quoi renvoyer.
     * Il faut avoir rentré un id en argument pour que cela fonctionne.
     */
    public void call(){
        this.testIntegerArg();
        if (isNumber){
            this.whichRequest();
            if (useDataBase){
                this.SQLcall();
            }
            else this.HTTPcall();
        }
    }

    /**
     * Cette fonction met à jour la variable isNumber pour la transformer en true si un id a bien été rentrée
     */
    private void testIntegerArg (){
        //Cet id n'est pas dans le dex, parfait pour l'initialisation
        int i = 9999;
        try {
            i = Integer.parseInt(args[0]);
            this.isNumber = true;
        } catch (NumberFormatException e) {
            System.err.println("You didn't use an integer, please use one");
            e.printStackTrace();
        }
    }

    /**
     * Cette fonction permet de faire appel à la base SQL en passant pour les classes statiques dévellopés
     * à cet effet. La classe vue questionné est TraitementSql.
     */
    private void SQLcall(){
        SQLConnect.connect(this.databaseURL);
        ResultSet rs = SQLRequest.prompt(this.args[0]);
        TraitementSql.run(rs);
    }

    /**
     * Cette fonction permet de faire appel à l'API et intérogge la classe de type vue DisplayJsonDex
     * pour exposer les informations.
     */
    private void HTTPcall(){
        HttpResponse response = HTTPRequest.run("https://pokeapi.co/api/v2/pokemon/" + args[0]);
        DisplayJsonDex.run(response);
    }

    /**
     * Cette fonction met à jour la variable useDataBase pour savoir si il faut utiliser ou non les informations de
     * la base de donnée (donc utilisé l'API dans l'autre cas).
     */
    private void whichRequest (){
        int len = this.args.length;
        int i = Integer.parseInt(args[0]);
        if ((len == 2) && (isNumber)&& (i >= 1 ) && ( i <= 5)) {
            this.useDataBase =true;
        }

    }

}
