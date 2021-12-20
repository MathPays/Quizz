package Jeu.Question;

/**
 * Question
 * String enonce : Enoncé de la question
 * int niveau : Difficulté de la question
 * @author Mathilde Paysant
 */

/*
    TODO :
    - Possibilité de ne pas prendre en compte la casse de la réponse fournie
 */
public abstract class Question {
    private String enonce;
    private int niveau;

    /**
     * Constructeur de la classe Question
     * Création d'une question, utilisée pour la création de QCM, RC et VF
     * @param enonce Enoncé de la question
     * @param niveau Difficulté de la question
     * @see Question
     * @author Mathilde Paysant
     */
    public Question(String enonce, int niveau) {
        this.enonce = enonce;
        if (niveau > 0 && niveau < 4) {
            this.niveau = niveau;
        } else {
            throw new IllegalArgumentException("Le niveau doit être compris entre 1 et 3");
        }

    }

    public int getNiveau() {
        return niveau;
    }

    @Override
    public String toString() {
        return enonce;
    }
}
