package back.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import back.database.PolyNameDataBase;
import back.models.Partie;

public class PartieDAO {
     private PolyNameDataBase db = null;

    public PartieDAO() {
        try {
            this.db = new PolyNameDataBase();
        } catch (SQLException err) {
            System.out.println("Error creating CarteDAO: " + err.getMessage());
        }
    }

    public String createGame() {
        // Crée une partie dans la bdd et lui associe un code aléatoire.
        Partie partie = new Partie();
        try {
            PreparedStatement ps = db.prepareStatement("INSERT INTO partie (codePartie) VALUE (?)");
            System.out.println(partie.getCodePartie());
            ps.setString(1, partie.getCodePartie());
            ps.executeUpdate();
            System.out.println("Game created with code : " + partie.getCodePartie());
            return partie.getCodePartie();
        } catch(SQLException err) {
            System.out.println("Could not query database: " + err.getMessage());
            return "";
        }
    }

    public int getPartieIDFromPartieCode(String partieCode){
        // Renvoie l'id de la partie qui a le partieCode.
        int partieCodeResult = 0;
        try {
            PreparedStatement ps = db.prepareStatement("SELECT partieID FROM partie WHERE codePartie = ?");
            ps.setString(1, partieCode);
            ResultSet results = ps.executeQuery();
    
            // Move the cursor to the first row
            if (results.next()) {
                partieCodeResult = results.getInt("partieID");
            }
        } catch(SQLException err) {
            System.out.println("Could not query database: " + err.getMessage());
        }
        return partieCodeResult;
    }


    public void addPlayer(String pseudo, String role, String partieCode) {
        // Ajoute un joueur à une partie en spécifiant son rôle.
        String sql = "UPDATE partie SET " + role + " = ? WHERE codePartie = ?";
    
        try {
            PreparedStatement ps = db.prepareStatement(sql);
            ps.setString(1, pseudo);
            ps.setString(2, partieCode);
            int rowsUpdated = ps.executeUpdate();
    
            if (rowsUpdated > 0) {
                System.out.println("Joueur ajouté avec succès.");
            } else {
                System.out.println("Aucune partie trouvée avec l'ID spécifié.");
            }
        } catch (SQLException err) {
            System.out.println("Could not query database: " + err.getMessage());
        }
    }
    
    
}
