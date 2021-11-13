package Jeu.Joueur;

import Jeu.Question.Question;

/**
 * Etat d'un joueur dans la partie
 * selectionne : joueur selectionne jouant dans la partie
 * gagnant : gagnant de la partie
 * superGagnant : gagnant des parties
 * elimine : joueur éliminé
 * enAttente : en attente d'entrer dans la partie
 * @author Mathilde Paysant
 */

/*
    TODO :
    - Ajouter un toString à chaque état
 */
public enum Etat {
    selectionne, gagnant, superGagnant, elimine, enAttente;
}
