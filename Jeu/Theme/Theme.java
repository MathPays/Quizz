package Jeu.Theme;

import Jeu.Question.Question;

import java.util.ArrayList;

public class Theme {
    private String nom;
    private boolean selection;
    private ArrayList<Question> questions;

    public Theme(String nom) {
        this.nom = nom;
        this.selection = false;
        this.questions = new ArrayList<Question>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public ArrayList<Question> getQuestions(int niveau) {
        ArrayList<Question> result = new ArrayList<Question>();
        for (Question question : questions) {
            if (question.getNiveau() == niveau) {
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
