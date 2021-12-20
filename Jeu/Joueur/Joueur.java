package Jeu.Joueur;

import java.util.Random;

/**
 * Liste des joueurs de la partie
 * int numero : Numéro unique du joueur
 * String nom : Nom choisi par le joueur
 * int score : Score du joueur
 * Etat etat : Etat du joueur
 * @see Etat
 */

public class Joueur {
    public static int nombre = 100;

    private final int numero;
    private final String nom;
    private int score;
    private Etat etat;

    /**
     * Constructeur de la classe Joueur.
     * Création d'un joueur avec un numéro incrémenté, un score à 0 et l'état "En Attente"
     * @param nom Nom choisi par le joueur
     * @author Mathilde Paysant
     */
    public Joueur(String nom) {
        this.numero = nombre;
        this.nombre += 10;
        this.nom = nom;
        this.score = 0;
        this.etat = Etat.enAttente;
    }

    /**
     * Constructeur de la classe Joueur.
     * N'est utilisé que pour la création d'une IA car nom aléatoire
     * @author Mathilde Paysant
     */
    protected Joueur() {
        String noms[] = { "HAL-9000", "DoD", "WALL-E", "Metropolis", "Decepticon", "C-3PO", "R2-D2", "Empereur Zurg", "Bay-max", "Terminator", "Astro", "Robocop", "Optimus Prime" };
        Random Dice = new Random();
        int n = Dice.nextInt(noms.length);
        this.nom = noms[n];
        this.numero = nombre;
        this.nombre += 10;
        this.score = 0;
        this.etat = Etat.enAttente;
    }

    public String getNom() {
        return nom;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
    public Etat getEtat() {
        return etat;
    }

    public void ajouterScore(int score){
        this.score+=score;
    }

    public int getNumero() {
        return numero;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return nom+" (joueur "+numero+") : "+score+" points ["+etat+"]";
    }
}