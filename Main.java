import Jeu.Etat;
import Jeu.Joueur;
import Jeu.Joueurs;
import Jeu.Question.QCM;
import Jeu.Question.RC;
import Jeu.Question.VF;
import Jeu.Theme.Theme;
import Jeu.Theme.Themes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Définition des thèmes
        Theme histoire = new Theme("Histoire");
        Theme geo = new Theme("Géographie");
        Theme div = new Theme("Divertissement");
        Theme art = new Theme("Arts");
        Theme lit = new Theme("Littérature");
        Theme science = new Theme("Science");
        Theme nature = new Theme("Nature");
        Theme sport = new Theme("Sports");
        Theme loisirs = new Theme("Loisirs");
        Theme maths = new Theme("Mathématiques");

        ArrayList<Theme> listeThemes = new ArrayList<Theme>();
        listeThemes.add(histoire);
        listeThemes.add(geo);
        listeThemes.add(div);
        listeThemes.add(art);
        listeThemes.add(lit);
        listeThemes.add(science);
        listeThemes.add(nature);
        listeThemes.add(sport);
        listeThemes.add(loisirs);
        listeThemes.add(maths);

        /*Themes themes = new Themes(listeThemes,1);
        System.out.println(themes);
        for (int i = 0; i < 10; i++) {
            System.out.println(themes.getNextTheme());
        }*/


        //Ajout des questions du thème Histoire
        RC h1 = new RC("Le Mozambique a été colonisé par un pays européen, lequel ?",3,"Portugal");
        histoire.addQuestion(h1);
        RC h2 = new RC("La chute de Constantinople a marqué la fin de l'Empire byzantin. En quelle année a-t-elle eu lieu ?",3,"1453");
        histoire.addQuestion(h2);
        QCM h3 = new QCM("Qui a été le premier président des États-Unis ?",1);
        h3.addReponse("George Washington");
        h3.addReponse("John Adams");
        h3.addReponse("Alexander Hamilton");
        histoire.addQuestion(h3);
        RC h4 = new RC("En quelle année l'humanité a-t-elle posé le pied sur la Lune pour la première fois à bord du vaisseau spatial Apollo 11 ?",1,"1969");
        histoire.addQuestion(h4);
        VF h5 = new VF("Jules César a donné son nom au mois de juillet.",2,true);
        histoire.addQuestion(h5);
        RC h6 = new RC("Combien d'années a duré la guerre de Cent Ans ?",1,"116");
        histoire.addQuestion(h6);
        QCM h7 = new QCM("Dans quelle ville vivait Marco Polo ?",2);
        h7.addReponse("Venice");
        h7.addReponse("Vienne");
        h7.addReponse("Budapest");
        histoire.addQuestion(h7);
        RC h8 = new RC("En quelle année la Slovénie est-elle devenue indépendante de la Yougoslavie ?",3,"1991");
        histoire.addQuestion(h8);
        VF h9 = new VF("Anaximandre considérait l'eau comme un élément intégré dans toutes choses.",2,false);
        histoire.addQuestion(h9);
        QCM h10 = new QCM("Comment appelle-t-on les hommes des cavernes ?",1);
        h10.addReponse("Diplodocus");
        h10.addReponse("Ptéranodons");
        h10.addReponse("Troglodytes");
        h10.setIndex(2);
        histoire.addQuestion(h10);

        //Ajout des questions du thème Géographie
        VF g1 = new VF("L'Italie est le plus méridional des pays européens.",1,false);
        QCM g2 = new QCM("Quelle était la monnaie utilisée en Espagne avant l'euro ?",2);
        g2.addReponse("Le peseta");
        g2.addReponse("Le réal");
        g2.addReponse("Le peso");


        RC d1 = new RC("Dans quel film croise-t-on le coq Rocky chargé par Ginger la poule d'apprendre à voler à un poulailler menacé ?",1,"Chicken Run");

        creerJoueurs();




    }

    /**
     * Permet à l'utilisateur de creer des joueurs
     * @return Liste des joueurs de la partie
     */

    /*
        TODO :
        - Possibilité de supprimer un joueur
        - Quitter la fonction en lancant la partie
     */
    public static Joueurs creerJoueurs() {
        Joueurs joueurs = new Joueurs();
        while (true) {
            Scanner scanner =new Scanner(System.in);
            System.out.println("Que souhaitez vous faire ?\n 1) Ajouter un joueur\n 2) Supprimer un joueur \n 3) Afficher les joueurs \n 4) Lancer la partie");
            int n = scanner.nextInt();
            switch (n) {
                case 1 :
                    joueurs.creerJoueur();
                    break;
                case 3 :
                    System.out.println(joueurs+"\n");
            }

        }
    }
}
