package back.models;

public class Carte {
	private int carteID;
    private String mot;
    private String couleur = "NULL";
    private boolean guessed = false;
    private int posX;
    private int posY;

    public Carte(String mot){
        this.mot = mot;
    }

	public void setID(int ID){
		this.carteID = ID;
	}

	public int getID(){
		return this.carteID;
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public boolean isGuessed() {
		return guessed;
	}

	public void setGuessed(boolean guessed) {
		this.guessed = guessed;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

    
}
