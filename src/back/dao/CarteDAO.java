package back.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import back.database.PolyNameDataBase;
import back.models.Carte;

public class CarteDAO {
    
    private PolyNameDataBase db = null;

    public CarteDAO() {
        try {
            this.db = new PolyNameDataBase();
        } catch (SQLException err) {
            System.out.println("Error creating CarteDAO: " + err.getMessage());
        }
    }

    public ArrayList<Carte> findAll() {
        // Permet de renvoyer toutes les cartes de la bdd.
        ArrayList<Carte> carteListe = new ArrayList<>();

        try {
            PreparedStatement ps = db.prepareStatement("SELECT * FROM carte");
            ResultSet results = ps.executeQuery();
            
            while (results.next()) {
                String mot = results.getString("mot");
                int id = results.getInt("carteID");

                Carte carte = new Carte(mot); // On crée une instance de carte
                carte.setID(id);
                carteListe.add(carte); // Que l'on ajoute à la liste des cartes
            }
        } catch (SQLException prerr) {
            System.out.println("Could not query database: " + prerr.getMessage());
        }
        return carteListe;
    }


    public ArrayList<Carte> findNumberOfCardsRandom(int numberOfCards){
        // Fonction permettant de renvoyer n cartes aléatoires parmis celles de la bdd.
        ArrayList<Carte> carteListe = new ArrayList<>();

        try {
            PreparedStatement ps = db.prepareStatement("SELECT * FROM carte ORDER BY RAND() LIMIT ?");
            ps.setInt(1, numberOfCards);
            ResultSet results = ps.executeQuery();
            
            while (results.next()) {
                String mot = results.getString("mot");
                int id = results.getInt("carteID");

                Carte carte = new Carte(mot);
                carte.setID(id);
                carteListe.add(carte);
            }
        } catch (SQLException prerr) {
            System.out.println("Could not query database: " + prerr.getMessage());
        }
        return carteListe;
    }
}
