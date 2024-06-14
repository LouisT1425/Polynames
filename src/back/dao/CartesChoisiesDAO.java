package back.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import back.database.PolyNameDataBase;
import back.models.Carte;

public class CartesChoisiesDAO {
    private PolyNameDataBase db = null;

    public CartesChoisiesDAO() {
        try {
            this.db = new PolyNameDataBase();
        } catch (SQLException err) {
            System.out.println("Error creating CarteDAO: " + err.getMessage());
        }
    }

    public void drawCards(int partieID){
        // Fonction permettant de tirer 25 cartes aléatoires de la bdd et de les associer à une partie. 
        CarteDAO cDAO = new CarteDAO();
        ArrayList<Carte> carteListe = cDAO.findNumberOfCardsRandom(25);
        try {
            for(int i = 0; i < 25; i++){
                PreparedStatement ps = db.prepareStatement("INSERT INTO cartes_choisies (partieID, carteID) VALUES (?, ?)");
                ps.setInt(1, partieID);
                ps.setInt(2, carteListe.get(i).getID());
                ps.executeUpdate();
            }
        } catch (Exception err){
            System.err.println("Erreur dans drawCards " + err );
        }
    }
    
    public ArrayList<Carte> getCarteByPartieID(int partieID){
        // Permet de renvoyer les cartes associées à une certaine partie.
        ArrayList<Carte> carteListe = new ArrayList<>();
        try{
            for(int i = 0; i < 25; i++) {
                PreparedStatement ps = db.prepareStatement("SELECT * FROM carte WHERE carteID = ?");
                ps.setInt(1, getCarteIDByPartieID(partieID).get(i));
                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                }
            }
        }
    }
    

    public ArrayList<Integer> getCarteIDByPartieID(int partieID){
        // Permet de renvoyer les id des cartes associées à une certaine partie.
        ArrayList<Integer> carteIDListe = new ArrayList<>();
        try {
            PreparedStatement ps = db.prepareStatement("SELECT carteID FROM cartes_choisies WHERE partieID = ?");
            ps.setInt(1, partieID);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                carteIDListe.add(rs.getInt("carteID"));
            }
        } catch (SQLException err) {
            System.err.println("Erreur dans addCarte " + err);
        }
        return carteIDListe;
    }
}
