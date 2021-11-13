package Jeu.Joueur;

/**
 * Liste des joueurs de la partie
 * int numero : Numéro unique du joueur
 * String nom : Nom choisi par le joueur
 * int score : Score du joueur
 * Etat etat : Etat du joueur
 * @see Etat
 */

/*
    TODO :
    - Incrémenter le score du joueur
    - Remettre le score à 0
 */
public class Joueur {
    public static int nombre = 100;

    private int numero;
    private String nom;
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

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return nom+" (joueur "+numero+") : "+score+" points ["+etat+"]";
    }
}
