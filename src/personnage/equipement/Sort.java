package personnage.equipement;

public class Sort {
    private String nom;
    private int niveauattaque;


    public Sort(String nom, int niveauattaque) {
        this.nom = nom;
        this.niveauattaque = niveauattaque;
    }
    public Sort(){}

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
