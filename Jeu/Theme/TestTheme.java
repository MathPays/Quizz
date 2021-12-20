package Jeu.Theme;

import Jeu.Question.VF;

import java.util.ArrayList;

public class TestTheme {
    public static void main(String[] args) {
        //TEST Theme
        Theme t1 = new Theme("Thème 1");
        System.out.println("TEST Thème :");
        System.out.println(t1);
        System.out.println("\nTEST add + getQuestions :");
        t1.add(new VF("Enoncé",2,true));
        t1.add(new VF("Enoncé 2",2,false));
        System.out.println(t1.getQuestions(2));
        System.out.println("\nTEST getRandomQuestion :");
        System.out.println(t1.getRandomQuestion());

        //TEST Themes
        ArrayList<Theme> liste = new ArrayList<>();
        liste.add(t1);
        liste.add(new Theme("Thème 2"));
        liste.add(new Theme("Thème 3"));
        liste.add(new Theme("Thème 4"));
        liste.add(new Theme("Thème 5"));
        liste.add(new Theme("Thème 6"));
        liste.add(new Theme("Thème 7"));
        liste.add(new Theme("Thème 8"));
        liste.add(new Theme("Thème 9"));
        liste.add(new Theme("Thème 10"));
        System.out.println("\nTEST Thèmes : phase 1");
        System.out.println(new Themes(liste,1));
        System.out.println("\nTEST Thèmes : phase 2");
        System.out.println(new Themes(liste,2));
        System.out.println("\nTEST Thèmes : phase 3");
        System.out.println(new Themes(liste,3));
    }
}
