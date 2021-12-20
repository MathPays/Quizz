package Jeu.Question;

/**
 * Question avec réponse vrai ou faux, fille de la classe Question
 * boolean reponse : Bonne réponse à la question
 * @see Question
 * @author Mathilde Paysant
 */

public class VF extends Question {
    private final boolean reponse;

    /**
     * Constructeur de la classe VF
     * Création d'une question avec réponse vrai ou faux
     * @param enonce Intitulé de la question
     * @param niveau Difficulté de la question, de 1 à 3
     * @param reponse Réponse attendue
     * @author Mathilde Paysant
     */
    public VF(String enonce, int niveau, boolean reponse) {
        super(enonce, niveau);
        this.reponse = reponse;
    }

    /**
     * Vérifier si la réponse choisie par l'utilisateur est juste
     * @param reponse Nombre entré par l'utilisateur
     * @return true si la réponse est juste, false sinon
     * @author Mathilde Paysant
     */
    public boolean verifier(int reponse) {
        if (this.reponse && reponse == 1) {
            return true;
        } else if (!this.reponse && reponse == 2) {
            return true;
        }
        return false;
    }

    public boolean reponseIA() {
        int r = (int) (Math.random() * ( 2 )+1);
        if (r == 1) {
            System.out.println(r);
            return true;
        } else {
            System.out.println(r);
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString()+"\n 1) Vrai \n 2) Faux";
    }
}
