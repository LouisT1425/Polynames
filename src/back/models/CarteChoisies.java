package back.models;

public class CarteChoisies {
    private int partieID;
    private int carteID;

    public CarteChoisies(int partieID, int carteID){
        // Lien entre une partie et ses cartes.
        this.partieID = partieID;
        this.carteID = carteID;
    }
}
