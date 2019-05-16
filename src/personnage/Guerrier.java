package personnage;


import personnage.equipement.Arme;

public class Guerrier extends Personnage {

    private String bouclier;
    private Arme arme;

    public Guerrier() {
    }

    public Guerrier(String nom, String image, int vie, int attaque, String bouclier, String nomarme, int nivatk) {
        super(nom, image, vie, attaque);
        this.bouclier = bouclier;
        this.arme = new Arme(nomarme, nivatk);
    }

    public void setBouclier(String bouclier) {
        this.bouclier = bouclier;
    }

    public String getBouclier() {
        return bouclier;
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme){this.arme = arme;}

    public String toString() {
        return super.toString() +
                "\n5 nom du bouclier : " + this.bouclier +
                "\n6 nom equipement : " + this.arme.getName() +
                "\n7 nineau equipement : " + this.arme.getNiveauattaque();

    }
}
