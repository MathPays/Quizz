package Jeu.Question;


/**
 * Question avec réponse courte, fille de la classe Question
 * String reponse : Bonne réponse à la question
 * @see Question
 * @author Mathilde Paysant
 */

/*
    TODO :
    - Possibilité de ne pas prendre en compte la casse de la réponse fournie
 */
public class RC extends Question {
    private String reponse;

    /**
     * Constructeur de la classe RC
     * Création d'une question avec réponse courte
     * @param enonce Intitulé de la question
     * @param niveau Difficulté de la question, de 1 à 3
     * @param reponse Réponse attendue
     * @author Mathilde Paysant
     */
    public RC(String enonce, int niveau, String reponse) {
        super(enonce, niveau);
        this.reponse = reponse;
    }

    /**
     * Vérifier si la réponse choisie par l'utilisateur est juste
     * @param reponse Chaine de caractères entrée par l'utilisateur
     * @return true si la réponse est juste, false sinon
     * @author Mathilde Paysant
     */
    public boolean verifier(String reponse) {
        if (this.reponse.equals(reponse)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Répondez en tapant votre réponse.";
    }

    public boolean reponseIA() {
        int r = (int) Math.random() * (10 - 0);
        if (r == 0) {
            System.out.println(reponse);
            return true;
        } else {
            System.out.println("Je ne sais pas.");
            return false;
        }
    }
}
