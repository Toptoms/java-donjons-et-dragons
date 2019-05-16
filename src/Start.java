package personnage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {
    private Personnage[] personnagetab;
    private int i;

    public Start(int size) {
        personnagetab = new Personnage[size];
    }

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
            int vie = questionValeur("parametrer la vie :", 5, 10);
            int attaque = questionValeur("parametrer ton attaque :", 5, 10);
            if (choice == 1) {
                String bouclier = demande("nom d'un bouclier :");
                String nomarme = demande("renseigner le nom de l'arme :");
                int niveauarme = questionValeur("parametrer le nieveau de l'arme :", 5, 10);
                Personnage guerrier = new Guerrier(nom, image, vie, attaque, bouclier, nomarme, niveauarme);
                personnagetab[i] = guerrier;
            } else {
                String sort = demande("nom d'un sort :");
                String nomphiltre = demande("renseigner le nom du philtre :");
                int niveauphiltre = questionValeur("parametrer le nieveau du philtre :", 5, 10);
                Personnage magicien = new Guerrier(nom, image, vie, attaque, sort, nomphiltre, niveauphiltre);
                personnagetab[i] = magicien;
            }
            i = i + 1;
            System.out.println(personnagetab[i]);
        }

    private void affichmodifsupperso() {
        int choice;
        int personnagechoisi = choixpersonnage();
        do {
            if (personnagetab[personnagechoisi].getClass().getSimpleName().equals("Guerrier")) {
                System.out.println(" Guerrier : " + personnagetab[personnagechoisi]);
            } else
                System.out.println(" Magicien : " + personnagetab[personnagechoisi]);

            choice = demandeint("1 Modifier \n" + "2 Supprimer \n" + "3 Retour au menu");
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
                    personnagetab[personnagechoisi].setNom(demande("changer de nom"));
                    break;
                case 2:
                    personnagetab[personnagechoisi].setImage(demande("changer l'image"));
                    break;
                case 3:
                    personnagetab[personnagechoisi].setVie(questionValeur("changer la vie :", 5, 10));
                    ;
                    break;
                case 4:
                    personnagetab[personnagechoisi].setAttaque(questionValeur("parametrer ton attaque :", 5, 10));
                    break;
                case 5:
                    if (personnagetab[personnagechoisi].getClass().getSimpleName().equals("Guerrier")) {
                        ((Guerrier) personnagetab[personnagechoisi]).setBouclier(demande("changer le nom du bouclier :"));
                    } else
                        //((Magicien) personnagetab[personnagechoisi]).setSort(demande("changer le nom du sort :")) ;
                        break;
                case 6:
                    if (personnagetab[personnagechoisi].getClass().getSimpleName().equals("Guerrier")) {
                        ((Guerrier) personnagetab[personnagechoisi]).getArme().setNom(demande("renseigner le nom de l'arme :"));
                    } else
                        // ((Magicien) personnagetab[personnagechoisi]).getPhiltre().setNom(demande("changer le nom du filtre :"));
                        break;
                case 7:
                    if (personnagetab[personnagechoisi].getClass().getSimpleName().equals("Guerrier")) {
                        ((Guerrier) personnagetab[personnagechoisi]).getArme().setNiveauattaque(questionValeur(
                                "parametrer le nieveau de l'arme :", 5, 10));
                    } else
                        //((Magicien) personnagetab[personnagechoisi]).getPhiltre().setNiveauattaque(demande("changer le nom du filtre :"));
                        break;
            }
        } while (choiceint != 0);
    }

    private int choixpersonnage() {
        int choiceint;
        int i;
        for (i = 0; i < personnagetab.length; i++) {
            if (personnagetab[i] != null) {
                if (personnagetab[i].getClass().getSimpleName().equals("Guerrier")) {
                    System.out.println(i + " Guerrier : " + personnagetab[i].getName());
                } else
                    System.out.println(i + " Magicien : " + personnagetab[i].getName());
            }
        }
        do {

            choiceint = demandeint("entrer le numero du personnage à afficher ");

        } while (choiceint < 0 || choiceint > i);
        return choiceint;
    }

    private void supprimer(int personnagechoisi) {
        personnagetab[personnagechoisi] = null;
    }

    private static String demande(String question) {
            Scanner sc = new Scanner(System.in);
            System.out.println(question);
            return sc.nextLine();

    }

    private static int demandeint(String question)  throws InputMismatchException {
        int rep;
        try {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        return sc.nextInt();
        }catch (Exception e){
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
        }catch (Exception e){
            System.out.println("saisie incorrecte");
            value = questionValeur(question, minv,  maxv);
        }
        return value;
    }
}
