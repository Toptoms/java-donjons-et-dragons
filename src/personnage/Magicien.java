package personnage;


import personnage.equipement.Sort;

public class Magicien extends Personnage {
    private String philtre;
    private Sort sort;


    public Magicien() {
    }

    public Magicien(String nom, String image, int vie, int attaque, String philtre, String nomphiltre, int nivatk) {
        super(nom, image, vie, attaque);
        this.philtre = philtre;
        this.sort= new Sort(nomphiltre, nivatk);
    }

    public void setPhiltre(String philtre) {
        this.philtre = philtre;
    }

    public String getPhiltre() {
        return philtre;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort){this.sort = sort;}



    public String toString() {
        return super.toString() +
                "\n5 nom du philtre : " + this.philtre +
                "\n6 nom sort : " + this.sort.getName() +
                "\n7 nineau sort : " + this.sort.getNiveauattaque();

    }
}
