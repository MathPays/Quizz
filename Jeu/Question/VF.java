package Jeu.Question;

/**
 * Question avec réponse vrai ou faux, fille de la classe Question
 * boolean reponse : Bonne réponse à la question
 * @see Question
 */

public class VF extends Question {
    private boolean reponse;

    /**
     * Constructeur de la classe VF
     * Création d'une question avec réponse vrai ou faux
     * @param enonce Intitulé de la question
     * @param niveau Difficulté de la question, de 1 à 3
     * @param reponse Réponse attendue
     */
    public VF(String enonce, int niveau, boolean reponse) {
        super(enonce, niveau);
        this.reponse = reponse;
    }

    /**
     * Vérifier si la réponse choisie par l'utilisateur est juste
     * @param reponse Nombre entré par l'utilisateur
     * @return true si la réponse est juste, false sinon
     */
    public boolean verifier(int reponse) {
        if ((reponse == 1 && this.reponse) || (reponse == 2 && !this.reponse)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString()+"\n1) Vrai \n2)Faux";
    }
}
