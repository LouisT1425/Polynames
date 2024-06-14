package back;

import back.controllers.CartesController;
import back.controllers.PartieController;
import back.dao.CartesChoisiesDAO;
import back.dao.PartieDAO;
import back.controllers.CartesChoisiesController;
import back.webserver.WebServer;
import back.webserver.WebServerContext;
import back.webserver.WebServerResponse;

public class App {
    public static void main(String[] args) throws Exception {
        WebServer webserver = new WebServer();

        webserver.listen(8080);

        // J'ai eu des problèmes de CORS que je n'ai pas réussi à résoudre. Au départ j'ai essayé d'implémenter le code dans WebServerResponse.initCors() mais je n'ai pas réussi.
        // Les lignes ci-dessous sont donc des exemples pour voir si le front marche bien comme il faut.

        CartesChoisiesDAO ccDAO = new CartesChoisiesDAO();
        PartieDAO pDAO = new PartieDAO();

        String codePartie = pDAO.createGame();
        pDAO.addPlayer("Louis", "maitreIntuition", codePartie);
        ccDAO.drawCards(pDAO.getPartieIDFromPartieCode(codePartie));
        

        // Routes de l'API pour les requêtes :

        webserver.getRouter().get("/25Cartes", (WebServerContext context) -> { 
            System.out.println("Received request for /25Cartes");
            CartesController.findNumberOfCardsRandom(context); // Renvoie 25 cartes aléatoires parmis les cartes de la bdd.
        });

        webserver.getRouter().get("/Cartes", (WebServerContext context) -> { 
            System.out.println("Received request for /Cartes");
            CartesController.findAll(context);  // Renvoie toutes les cartes de la bdd.
        });

        webserver.getRouter().get("/getCarteID/:partieID", (WebServerContext context) -> {
            System.out.println("Received request for /getCarteID");
            CartesChoisiesController.getCarteIDByPartieID(context); // renvoie l'id des cartes associées à une partie.
        });

        webserver.getRouter().get("/drawCards/:partieID", (WebServerContext context) -> {
            System.out.println("Received request for /drawCards");
            CartesChoisiesController.drawCards(context); // Tire 25 cartes aléatoires et les associent à une partie.
        });

        webserver.getRouter().post("/createGame", (WebServerContext context) -> {
            System.out.println("Received request for /createGame");
            PartieController.createGame(context); // Crée une partie et lui associe un code aléatoire pour s'y connecter.
        });

        webserver.getRouter().post("/addPlayer/:Pseudo/:Role/:PartieCode", (WebServerContext context) -> {
            System.out.println("Received request for /addPlayer");
            PartieController.addPlayer(context); // Ajoute un joueur en spécifiant son rôle à une partie.
        });

        webserver.getRouter().get("/getPartieIDFrom/:PartieCode", (WebServerContext context) -> {
            System.out.println("Received request for /getPartieIDFrom");
            PartieController.getPartieIDFromPartieCode(context); // Renvoie l'id de la partie(partieID dans la bdd) à partir du code de la partie.
        });
    }
}
