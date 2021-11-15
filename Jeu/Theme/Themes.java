package Jeu.Theme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Liste des thèmes d'une partie
 * @author Mathilde Paysant
 */
public class Themes {
    private ArrayList<Theme> themes;


    public Themes(ArrayList<Theme> listeThemes, int phase) {
        ArrayList<Theme> themes = new ArrayList<Theme>(listeThemes);
        switch (phase) {
            case 1 :
                this.themes = themes;
                break;
            case 2 :
                Collections.shuffle(themes);
                for (int i = 0; i < 4; i++) {
                    themes.remove(themes.size()-1);
                }
                this.themes = themes;
                break;
            case 3 :
                Collections.shuffle(themes);
                for (int i = 0; i < 7; i++) {
                    themes.remove(themes.size()-1);
                }
                this.themes = themes;
                break;
            default:
                System.out.println("Erreur, le numéro de phase est incorrect.");
                break;
        }
    }

    public void deleteTheme(Theme theme) {
        themes.remove(theme);
    }

    /**
     * Renvoyer le prochain thème dans la liste, au hasard si aucun thème préalablement sélectionné
     * @return theme suivant
     * @author Emmie Kieffer
     */
    public Theme getNextTheme() {
        Theme theme;
        for (int i = 0; i < themes.size(); i++) {
            if(themes.get(i).getSelection()) {
                if (i == themes.size()-1) {
                    theme = themes.get(0);
                } else {
                    theme = themes.get(i+1);
                }
                themes.get(i).setSelection(false);
                theme.setSelection(true);
                return theme;
            }
        }
        theme = themes.get((new Random()).nextInt(themes.size()));
        theme.setSelection(true);
        return theme;
    }




    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Theme theme : themes) {
            result.append(theme+"\n");
        }
        return String.valueOf(result);
    }
}
