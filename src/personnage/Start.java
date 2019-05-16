package personnage;


import java.util.ArrayList;
import java.util.Scanner;

public class Start {

    private ArrayList<Personnage> personnagetab = new ArrayList<>();
    private ArrayList<String> plateautab = new ArrayList<>();

    public void startmenu() {
        int choice;
        do {
            choice = demandeint("\n1 Creer un personnage " + "\n2 Afficher, modifier, supprimer les personnages"
                    + "\n3 Pour sortir");
            switch (choice) {
                case 1:
                    creatpersonnage();
                    break;
                case 2:
                    affichmodifsupperso();
                    break;
            }
        } while (choice != 3);

    }

    public void persodefini() {
        Personnage magicien = new Magicien("cedric", "brouillon", 5, 6, "aphrodisique", "bamboo", 6);
        personnagetab.add(magicien);
        Personnage guerrier = new Guerrier("flo", "charnu", 7, 8, "tonneau", "tirebouchon", 6);
        personnagetab.add(guerrier);
        Personnage guerrier1 = new Guerrier("tom", "charnu", 7, 8, "tonneau", "tirebouchon", 6);
        personnagetab.add(guerrier1);
        Personnage magicien1 = new Magicien("pablo", "friogo", 5, 6, "cocaoine", "bamboo", 6);
        personnagetab.add(magicien1);
        Personnage magicien2 = new Magicien("carl", "fingerscreen", 5, 6, "aphrodisique", "bamboo", 6);
        personnagetab.add(magicien2);


    }

    private void creatpersonnage() {
        int choice;
        do {
            choice = demandeint("1 Creer un guerrier \n" + "2 Creer un magicien \n" + "3 Retour au menu");
        } while (choice < 1 || choice > 3);
        if (choice == 3) {
            startmenu();
        } else
            creat(choice);
    }

    private void creat(int choice) {

        System.out.println("vous avez choisi de creer un guerrier");
        String nom = demande("entrer un nom :");
        String image = demande("renseigner une image :");
        if (choice == 1) {
            int vie = questionValeur("parametrer la vie :", 5, 10);
            int attaque = questionValeur("parametrer ton attaque :", 5, 10);
            String nombouclier = demande("nom d'un bouclier :");
            String nomarme = demande("renseigner le nom de l'equipement :");
            int niveauarme = questionValeur("parametrer le nieveau de l'equipement :", 5, 10);
            Personnage guerrier = new Guerrier(nom, image, vie, attaque, nombouclier, nomarme, niveauarme);
            personnagetab.add(guerrier);
        } else {
            int vie = questionValeur("parametrer la vie :", 3, 6);
            int attaque = questionValeur("parametrer ton attaque :", 8, 15);
            String nomsort = demande("nom d'un sort :");
            String nomphiltre = demande("renseigner le nom du philtre :");
            int niveauphiltre = questionValeur("parametrer le nieveau du philtre :", 5, 10);
            Personnage magicien = new Magicien(nom, image, vie, attaque, nomsort, nomphiltre, niveauphiltre);
            personnagetab.add(magicien);
        }
        System.out.println(personnagetab.get(personnagetab.size() - 1));
    }

    private void affichmodifsupperso() {
        int choice;
        int personnagechoisi = choixpersonnage();
        do {
            if (personnagetab.get(personnagechoisi).getClass().getSimpleName().equals("Guerrier")) {
                System.out.println(" Guerrier : \n" + personnagetab.get(personnagechoisi));
            } else
                System.out.println(" Magicien : \n" + personnagetab.get(personnagechoisi));

            choice = demandeint("\n1 Modifier \n" + "2 Supprimer \n" + "3 Retour au menu");
            switch (choice) {
                case 1:
                    modifpersonnage(personnagechoisi);
                    break;
                case 2:
                    supprimer(personnagechoisi);
                    break;
                case 3:
                    startmenu();
                    break;
            }
        } while (choice < 1 || choice > 3);
    }

    private void modifpersonnage(int personnagechoisi) {
        int choiceint;

        do {
            choiceint = demandeint("Que veux tu modifier ? 0 pour sortir");
            switch (choiceint) {
                case 1:
                    personnagetab.get(personnagechoisi).setNom(demande("changer de nom"));
                    break;
                case 2:
                    personnagetab.get(personnagechoisi).setImage(demande("changer l'image"));
                    break;
                case 3:
                    if (personnagetab.get(personnagechoisi).getClass().getSimpleName().equals("Guerrier")) {
                        personnagetab.get(personnagechoisi).setVie(questionValeur("changer la vie :", 5, 10));
                    } else personnagetab.get(personnagechoisi).setVie(questionValeur("changer la vie :", 3, 6));
                    break;
                case 4:
                    if (personnagetab.get(personnagechoisi).getClass().getSimpleName().equals("Guerrier")) {
                        personnagetab.get(personnagechoisi).setAttaque(questionValeur("parametrer ton attaque :", 5, 10));
                    } else
                        personnagetab.get(personnagechoisi).setAttaque(questionValeur("parametrer ton attaque :", 8, 15));
                    break;
                case 5:
                    if (personnagetab.get(personnagechoisi).getClass().getSimpleName().equals("Guerrier")) {
                        ((Guerrier) personnagetab.get(personnagechoisi)).setBouclier(demande("changer le nom du bouclier :"));
                    } else
                        ((Magicien) personnagetab.get(personnagechoisi)).setPhiltre(demande("changer le nom du Philtre :"));
                    ;
                    break;
                case 6:
                    if (personnagetab.get(personnagechoisi).getClass().getSimpleName().equals("Guerrier")) {
                        ((Guerrier) personnagetab.get(personnagechoisi)).getArme().setNom(demande("renseigner le nom de l'equipement :"));
                    } else
                        ((Magicien) personnagetab.get(personnagechoisi)).getSort().setNom(demande("changer le nom du sort :"));
                    break;
                case 7:
                    if (personnagetab.get(personnagechoisi).getClass().getSimpleName().equals("Guerrier")) {
                        ((Guerrier) personnagetab.get(personnagechoisi)).getArme().setNiveauattaque(questionValeur(
                                "parametrer le nieveau de l'equipement :", 5, 10));
                    } else
                        ((Magicien) personnagetab.get(personnagechoisi)).getSort().setNiveauattaque(questionValeur(
                                "parametrer le nieveau de l'equipement :", 5, 10));
                    break;
            }
        } while (choiceint != 0);
    }

    private int choixpersonnage() {
        int choiceint;
        int i;
        for (i = 0; i < personnagetab.size(); i++) {
            if (personnagetab.get(i) != null) {
                if (personnagetab.get(i).getClass().getSimpleName().equals("Guerrier")) {
                    System.out.println(i + " Guerrier : " + personnagetab.get(i).getName());
                } else
                    System.out.println(i + " Magicien : " + personnagetab.get(i).getName());
            }
        }
        do {
            choiceint = demandeint("entrer le numero du personnage à afficher ");
        } while (choiceint < 0 || choiceint > i);
        return choiceint;
    }

    private void supprimer(int personnagechoisi) {
        personnagetab.remove(personnagechoisi);
    }

    private static String demande(String question) {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        return sc.nextLine();
    }

    private static int demandeint(String question) {
        int rep;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println(question);
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("saisie incorrecte");
            rep = demandeint(question);
        }
        return rep;
    }

    private static int questionValeur(String question, int minv, int maxv) {
        int value;
        try {
            do {
                Scanner sc = new Scanner(System.in);
                System.out.println(question + " entre " + minv + " et " + maxv);
                value = sc.nextInt();
            } while (value < minv || value > maxv);
        } catch (Exception e) {
            System.out.println("saisie incorrecte");
            value = questionValeur(question, minv, maxv);
        }
        return value;
    }

    private void plateaucase(int longeur) {
        for (int i = 0; i < longeur; i++) {
            int nombrefou = (int) (Math.random() * (3 - 1)) + 1;
            switch (nombrefou) {
                case 1:
                    plateautab.add("rien");
                    break;
                case 2:
                    plateautab.add("plus");
                    break;
                case 3:
                    plateautab.add("moin");
                    break;
            }
        }

    }

}
