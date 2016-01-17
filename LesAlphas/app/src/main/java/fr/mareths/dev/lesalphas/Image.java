package fr.mareths.dev.lesalphas;

public class Image {

    private int idDroite;
    private int idGauche;

    public int getIdGauche() {
        return idGauche;
    }

    public int getIdDroite() {
        return idDroite;
    }

    public Image(int idDroite, int idGauche) {
        this.idDroite = idDroite;
        this.idGauche = idGauche;
    }
}
