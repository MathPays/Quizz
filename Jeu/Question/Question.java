package Jeu.Question;

/**
 * Question
 * String enonce : Enoncé de la question
 * int niveau : Difficulté de la question
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
     */
    public Question(String enonce, int niveau) {
        this.enonce = enonce;
        this.niveau = niveau;
    }

    public int getNiveau() {
        return niveau;
    }

    @Override
    public String toString() {
        return enonce;
    }
}
