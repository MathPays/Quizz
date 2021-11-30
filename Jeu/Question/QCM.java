package Jeu.Question;

import java.util.*;

/**
 * Question à choix multiples, fille de la classe Question
 * ArrayList<String> reponses : Liste des réponses
 * int index : Index de la bonne réponse
 * @see Question
 * @author Mathilde Paysant
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
     * @author Mathilde Paysant
     */
    public QCM(String enonce, int niveau) {
        super(enonce, niveau);
        this.reponses = new ArrayList<String>();
        this.index = 0;
    }

    public QCM(String enonce, int niveau, ArrayList<String> reponses) {
        super(enonce, niveau);
        this.reponses = reponses;
        this.index = 0;
    }

    /**
     * Ajouter une réponse possible à la question à choix multiples
     * @param reponse Intitulé de la réponse
     * @author Mathilde Paysant
     */
    public void addReponse(String reponse) {
        reponses.add(reponse);
    }

    public void deleteReponse(int index) {
        ArrayList<String> newReponses = new  ArrayList<String>();
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
     * @author Mathilde Paysant
     */
    public void setIndex(int index) {
        if (index < reponses.size()) {
            this.index = index;
        }
    }

    /**
     * Vérifier si la réponse choisie par l'utilisateur est juste
     * @param reponse Réponse de
     * @return true si la réponse est juste, false sinon
     * @author Mathilde Paysant
     */
    public boolean verifier(int reponse, int bonne) {
        return reponse == bonne;
    }

    public int afficherQuestion() {
        ArrayList<String> liste = new ArrayList<String>(reponses);
        Collections.shuffle(liste);
        String result = super.toString();
        for (int i = 0; i < liste.size(); i++) {
            result += "\n"+(i+1)+") "+liste.get(i);
        }
        System.out.println(result.toString());
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).equals(reponses.get(index))) {
                return i+1;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String result = super.toString();
        for (int i = 0; i < reponses.size(); i++) {
            result += "\n "+(i+1)+") "+reponses.get(i);
        }
        return result;
    }

    public boolean reponseIA(int bonne) {
        int r = (int) (Math.random() * ( reponses.size() - 0 ));
        System.out.println(r);
        if (r == bonne) {
            return true;
        }
        return false;
    }
}
