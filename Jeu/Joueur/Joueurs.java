package Jeu.Joueur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Liste des joueurs de la partie
 * ArrayList<Joueur> joueurs : Liste des joueurs de la partie
 * Joueur joueur : joueur dont le tour est en cours
 * @see Joueur
 * @author Mathilde Paysant
 */

/*
    TODO :
    - Ajouter une fonction toString affichant tous les joueurs de la partie
 */
public class Joueurs {
    private ArrayList<Joueur> joueurs;
    private Joueur joueur;

    public Joueurs() {
        this.joueurs = new ArrayList<Joueur>();
        this.joueur = null;
    }

    public void addJoueur(Joueur joueur) {
        joueurs.add(joueur);
    }

    /**
     * Création d'un joueur ainsi qu'ajout à la liste de joueurs
     * @author Mathilde Paysant
     */
    public void creerJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du joueur :");
        String nom = scanner.nextLine();
        joueurs.add(new Joueur(nom));
        System.out.println("Le joueur "+nom+" a été ajouté.\n");
    }

    /**
     * Suppression d'un joueur de la liste à la phase de création des joueurs
     * @author Mathilde Paysant
     */
    public void deleteJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro du joueur à supprimer : ");
        int num = scanner.nextInt();
        for (Joueur joueur: joueurs) {
            if (joueur.getNumero() == num) {
                joueurs.remove(joueur);
                break;
            }
        }
    }


    public int getNbJoueurs() {
        return joueurs.size();
    }

    /**
     * @return la liste des joueurs restants (non éliminés)
     * @author Thomas Gendron
     */
    public Joueurs getJoueursRestants() {
        Joueurs joueursRestants = new Joueurs();
        for (Joueur joueur : joueurs) {
            if (joueur.getEtat() == Etat.selectionne) {
                joueursRestants.addJoueur(joueur);
            }
        }
        return joueursRestants;
    }

    /**
     * Choix de 4 joueurs dans la liste des joueurs au hasard pour une partie
     * @return liste des 4 joueurs selectionnés
     * @author Mathilde Paysant
     */
    public Joueurs chooseRandomJoueurs() {
        Joueurs chosenJoueurs = new Joueurs();
        Random rand = new Random();
        ArrayList<Integer> liste = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            while (true) {
                int n = rand.nextInt(joueurs.size());
                if (!Arrays.asList(liste).contains(n)) {
                    liste.add(n);
                }
            }
        }
        for (int n : liste) {
            chosenJoueurs.addJoueur(joueurs.get(n));
            joueurs.get(n).setEtat(Etat.selectionne);
        }
        return chosenJoueurs;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * Change le joueur dont c'est le tour
     * @author Emmie Kieffer
     */
    public void nextJoueur() {
        if (joueur == null) {
            this.joueur = joueurs.get(0);
        } else {
            int n = joueurs.indexOf(joueur);
            if (n == joueurs.size()-1) {
                this.joueur = joueurs.get(0);
            } else {
                this.joueur = joueurs.get(n+1);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Joueur joueur: joueurs) {
            sb.append(joueur+"\n");
        }
        return sb.toString();
    }
}
