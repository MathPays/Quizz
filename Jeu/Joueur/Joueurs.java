package Jeu.Joueur;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Liste des joueurs de la partie
 * ArrayList<Joueur> joueurs : Liste des joueurs de la partie
 * Joueur joueur : joueur dont le tour est en cours
 * @see Joueur
 * @author Mathilde Paysant
 */
public class Joueurs {
    private Joueur [] joueurs;
    private int index;

    public Joueurs() {
        this.joueurs = new Joueur[20];
        this.index = 0;
    }

    public void addJoueur(Joueur joueur) {
        joueurs[index] = joueur;
        index++;
    }

    /**
     * Création d'un joueur ainsi qu'ajout à la liste de joueurs
     * @author Mathilde Paysant
     */
    public void creerJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du joueur :");
        String nom = scanner.nextLine();
        try {
            joueurs[index] = new Joueur(nom);
            index++;
            System.out.println("Le joueur "+nom+" a été ajouté.\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Le nombre maximal de joueurs a été atteint.");
        }
    }

    /**
     * Création d'une IA ainsi qu'ajout à la liste de joueurs
     * @author Mathilde Paysant
     */
    public void creerIA() {
        IA ia = new IA();
        try {
            joueurs[index] = ia;
            index++;
            System.out.println("Le joueur "+ia.getNom()+" a été ajouté.\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Le nombre maximal de joueurs a été atteint.");
        }
    }

    /**
     * Suppression d'un joueur de la liste à la phase de création des joueurs
     * @author Mathilde Paysant
     */
    public void deleteJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro du joueur à supprimer : ");
        int num = scanner.nextInt();
        Joueur[] newJoueurs = new Joueur[joueurs.length];
        int newIndex = 0;
        for (int i = 0; i < index; i++) {
            if (joueurs[i].getNumero() != num) {
                newJoueurs[newIndex] = joueurs[i];
                newIndex++;
            } else {
                System.out.println("Le joueur "+joueurs[i].getNom()+" a été supprimé.\n");
            }
        }
        this.joueurs = newJoueurs;
        this.index = newIndex;
    }


    public int getNbJoueurs() {
        return index;
    }

    /**
     * @return la liste des joueurs restants (non éliminés)
     * @author Thomas Gendron
     */
    public Joueurs getJoueursRestants() {
        Joueurs joueursRestants = new Joueurs();
        for (Joueur joueur: joueurs) {
            if (joueur != null && joueur.getEtat() == Etat.selectionne) {
                joueursRestants.addJoueur(joueur);
            }
        }
        return joueursRestants;
    }

    public Joueur getJoueur(int index) {
        return joueurs[index];
    }

    /**
     * @return dernier joueur selectionne, return null si aucun ou plusieurs joueurs ont été trouvé
     * @author Mathilde Paysant
     */
    public Joueur getJoueurFinal() {
        Joueur joueur = null;
        for (int i = 0; i < index; i++) {
            if (joueurs[i].getEtat().equals(Etat.selectionne)) {
                if (joueur != null) {
                    System.out.println("Erreur : plusieurs joueurs détectés");
                    return null;
                } else {
                    joueur = joueurs[i];
                }
            }
        }
        if (joueur != null) {
            return joueur;
        }
        System.out.println("Erreur : aucun joueur détecté");
        return null;
    }

    /**
     * Choix de 4 joueurs dans la liste des joueurs au hasard pour une partie
     * @author Mathilde Paysant
     */
    public void chooseRandomJoueurs() {
        Random rand = new Random();
        ArrayList<Integer> liste = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            while (true) {
                int n = rand.nextInt(index);
                if (!liste.contains(n)) {
                    liste.add(n);
                    break;
                }
            }
        }
        for (int n : liste) {
            joueurs[n].setEtat(Etat.selectionne);
        }
    }

    /**
     * Création d'un objet Joueurs contenant uniquement les joueurs avec l'état selectionne
     * @return Joueurs contenant uniquement les joueurs avec l'état selectionne
     * @author Mathilde Paysant
     */
    public int getNbJoueursSelectionnes() {
        int n = 0;
        for (int i =0; i < index;i++) {
            if (joueurs[i].getEtat() == Etat.selectionne) {
                n++;
            }
        }
        return n;
    }

    /**
     * Elimination du joueur ayant le score le plus bas
     * @author Mathilde Paysant
     */
    public void elimineDernier() {
        int index = 0;
        int score = -1;
        for (int i =0; i < this.index; i++) {
            if ((joueurs[i].getScore() < score || score == -1) && joueurs[i].getEtat().equals(Etat.selectionne)) {
                score = joueurs[i].getScore();
                index = i;
            }
        }
        joueurs[index].setEtat(Etat.elimine);
        System.out.println(joueurs[index].getNom()+" a été éliminé.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Joueur joueur: joueurs) {
            if (joueur != null) {
                sb.append(joueur+"\n");
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }
}
