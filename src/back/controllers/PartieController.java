package back.controllers;

import java.sql.SQLException;

import back.dao.PartieDAO;
import back.webserver.WebServerContext;

public class PartieController {

    public PartieController(){

    }

    public static void createGame(WebServerContext context){
        // Fonction permettant de créer une game et de lui attribuer un partieCode aléatoire pour la rejoindre.
        try{
            PartieDAO pDAO = new PartieDAO();
            String codePartie = pDAO.createGame();
            context.getResponse().json("Game created with code : " + codePartie);
        } catch(Exception e){
            context.getResponse().json("Error creating new game : " + e.getMessage());
        }
    }

    public static void addPlayer(WebServerContext context) {
        // Fonction permettant d'ajouter un joueur à un rôle à une partie(repérée par son partieCode vu dans createGame).
        String pseudo = context.getRequest().getParam("Pseudo");
        String role = context.getRequest().getParam("Role");
        String partieCode = context.getRequest().getParam("PartieCode");
        
        try {
            PartieDAO pDAO = new PartieDAO();
            pDAO.addPlayer(pseudo, role, partieCode);
            context.getResponse().json("Player " + pseudo + " added to game with code : " + partieCode);
        } catch (Exception e) {
            context.getResponse().json("Error adding new player: " + e.getMessage());
        }
    }
    
    public static void getPartieIDFromPartieCode(WebServerContext context) {
        // Fonction permettant de retrouver l'ID(dans la bdd) de la partie à partir du partieCode.
        String partieID = context.getRequest().getParam("PartieCode");
        try{
            PartieDAO pDAO = new PartieDAO();
            int partieIDResult = pDAO.getPartieIDFromPartieCode(partieID);
            context.getResponse().json(partieIDResult);
        } catch (Exception e) {
            context.getResponse().json("Error getting partieID: " + e.getMessage());
        }
    }
}
