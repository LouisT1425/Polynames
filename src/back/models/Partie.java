package back.models;

import java.util.Random;

public class Partie {
    
    private String codePartie;
    private String maitreIntuition;
    private String maitreIndice;
    private int score;
    private String guess;
    private String indice;
    private int pourCombien;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public Partie(){
        StringBuilder code = new StringBuilder(6);
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(CHARACTERS.length()); // index prend la valeur d'un entier aléatoire compris entre 0 et la longueur de CHARACTERS.
            code.append(CHARACTERS.charAt(index)); // On ajoute au code le caractère à la position aléatoire index.
        }

        this.codePartie = code.toString();
    }

    public String getCodePartie(){
        return this.codePartie;
    }
}
