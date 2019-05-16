package personnage;


public abstract class Personnage {
    private String nom;
    private String image;
    private int vie;
    private int attaque;

    public Personnage() {
    }

    public Personnage(String nom, String image, int vie, int attaque) {
        this.nom = nom;
        this.image = image;
        this.vie = vie;
        this.attaque = attaque;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getName() {
        return nom;
    }

    public void setImage(String image) {
        this.image = nom;
    }

    public String getImage() {
        return image;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getVie() {
        return vie;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getAttaque() {
        return attaque;
    }


    public String toString() {
        return "1 nom : " + this.nom +
                "\n2 image : " + this.image +
                "\n3 vie : " + this.vie +
                "\n4 attaque : " + this.attaque;

    }
}
