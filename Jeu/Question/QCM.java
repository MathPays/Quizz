package Jeu.Question;


import java.util.*;
/**
 * Question à choix multiples, fille de la classe Question
 * ArrayList<String> reponses : Liste des réponses
 * int index : Index de la bonne réponse
 * @see Question
 */

/*
    ATTENTION ERREUR : ne fonctionne pas car la bonne réponse est toujours la première
    TODO :
    - Mélanger les réponses et garder la position de la bonne réponse
 */
public class QCM extends Question {
    private ArrayList<String> reponses;
    private int index;

    /**
     * Constructeur de la classe QCM
     * Création d'une question à choix multiples
     * @param enonce Intitulé de la question
     * @param niveau Difficulté de la question, de 1 à 3
     */
    public QCM(String enonce, int niveau) {
        super(enonce, niveau);
        this.reponses = new ArrayList<String>();
        this.index = 0;
    }

    /**
     * Ajouter une réponse possible à la question à choix multiples
     * @param reponse Intitulé de la réponse
     */
    public void addReponse(String reponse) {
        reponses.add(reponse);
    }

    public void deleteReponse(int index) {
        ArrayList<String> newReponses = new  ArrayList<String>();
        if (index >= reponses.size()) {
            return;
        }
        for (int i = 0; i < reponses.size(); i++) {
            if (i != index) {
                newReponses.add(reponses.get(i));
            }
        }
        this.reponses = newReponses;
    }

    /**
     * Changer la bonne réponse à la question
     * La bonne réponse est par défaut la première réponse (en position 0)
     * @param index Index de la nouvelle bonne réponse
     */
    public void setIndex(int index) {
        if (index < reponses.size()) {
            this.index = index;
        } else {
            System.out.println("Erreur, l'index de la réponse est incorrect.");
        }
    }

    /**
     * Vérifier si la réponse choisie par l'utilisateur est juste
     * @param index Index de la réponse choisie par l'utilisateur
     * @return true si la réponse est juste, false sinon
     */
    public boolean verifier(int index) {
        if (index-1 == this.index) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = super.toString();
        for (int i = 0; i < reponses.size(); i++) {
            result += "\n"+(i+1)+") "+reponses.get(i);
        }
        return result;
    }
}
