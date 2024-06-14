package back.controllers;

import java.util.ArrayList;

import back.dao.CartesChoisiesDAO;
import back.webserver.WebServerContext;

public class CartesChoisiesController {

    public CartesChoisiesController(){}
    
    public static void drawCards(WebServerContext context) {
        // Fonction permettant de tirer 25 cartes aléatoires et de les associer à la partie d'id partieID.
        try {
            int partieID = Integer.parseInt(context.getRequest().getParam("partieID"));
            CartesChoisiesDAO ccDAO = new CartesChoisiesDAO();
            ccDAO.drawCards(partieID);
            context.getResponse().ok("Cartes drawn");
        } catch (Exception e) {
            context.getResponse().ok("Error drawing cards: " + e.getMessage());
        }
    }

    public static void getCarteIDByPartieID(WebServerContext context) {
        // Fonction permettant de renvoyer l'ID de toutes les cartes associées  à un certain partieID.
        int partieID = Integer.parseInt(context.getRequest().getParam("partieID"));
        System.err.println(partieID);
        CartesChoisiesDAO ccDAO = new CartesChoisiesDAO();
        ArrayList<Integer> carteIDListe = ccDAO.getCarteIDByPartieID(partieID);
        
        context.getResponse().json(carteIDListe);
    }
}
