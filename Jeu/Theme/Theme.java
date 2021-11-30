package Jeu.Theme;

import Jeu.Question.Question;

import java.util.ArrayList;

/**
 * Groupe de question d'un theme
 * @author Mathilde Paysant
 */
public class Theme {
    private final String nom;
    private boolean selection;
    private ArrayList<Question> questions;

    public Theme(String nom) {
        this.nom = nom;
        this.selection = false;
        this.questions = new ArrayList<Question>();
    }

    /**
     * Ajouter une question au theme
     * @param question question à ajouter au theme
     * @author Mathilde Paysant
     */
    public void add(Question question) {
        questions.add(question);
    }

    /**
     * Renvoyer les questions d'un certain niveau (-1 si tous les niveaux)
     * @param niveau niveau des questions à retourner
     * @return question d'un certain niveau
     * @author Mathilde Paysant
     */
    public ArrayList<Question> getQuestions(int niveau) {
        ArrayList<Question> result = new ArrayList<Question>();
        for (Question question : questions) {
            if (question.getNiveau() == niveau || niveau == -1) {
                result.add(question);
            }
        }
        return result;
    }

    public void setSelection(boolean selection) {
        this.selection = selection;
    }

    public boolean getSelection() {
        return selection;
    }

    @Override
    public String toString() {
        return nom;
    }
}
