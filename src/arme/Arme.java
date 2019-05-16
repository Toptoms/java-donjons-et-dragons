package personnage.arme;

public class Arme {
    private String nom;
    private int niveauattaque;


    public Arme(String nom, int niveauattaque) {
        this.nom = nom;
        this.niveauattaque = niveauattaque;
    }

    public String getName() {
        return nom;
    }

    public int getNiveauattaque() {
        return niveauattaque;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setNiveauattaque(int niveauattaque) {
        this.niveauattaque = niveauattaque;
    }
}
