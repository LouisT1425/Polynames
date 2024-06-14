package back.controllers;

import java.util.ArrayList;

import back.dao.CarteDAO;
import back.models.Carte;
import back.webserver.WebServerContext;
public class CartesController {

    public CartesController(){

    }

    public static ArrayList<Carte> findAll(WebServerContext context) {
        // Fonction permettant de renvoyer toutes les cartes de la base de donnée.
        ArrayList<Carte> carteListe = new ArrayList<>();
        CarteDAO cDAO = new CarteDAO();
        carteListe = cDAO.findAll();

        context.getResponse().json(cDAO.findAll());

        return carteListe;
    }

    public static ArrayList<Carte> findNumberOfCardsRandom(WebServerContext context){
        // fonction permettant de renvoyer n cartes randoms parmis celle de la bdd, ici par défaut 25
        ArrayList<Carte> carteListe = new ArrayList<>();
        CarteDAO cDAO = new CarteDAO();
        carteListe = cDAO.findNumberOfCardsRandom(25);

        context.getResponse().json(cDAO.findNumberOfCardsRandom(25));

        return carteListe;

    }
}
