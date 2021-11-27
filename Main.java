import Jeu.Joueur.Joueur;
import Jeu.Joueur.Joueurs;
import Jeu.Question.QCM;
import Jeu.Question.Question;
import Jeu.Question.RC;
import Jeu.Question.VF;
import Jeu.Theme.Theme;
import Jeu.Theme.Themes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Définition des thèmes

        ArrayList<Theme> listeThemes = creationQuestions();

        Themes themes = new Themes(listeThemes,1);
        Theme theme = themes.getNextTheme();
        System.out.println(theme);

        Joueurs joueurs = creerJoueurs();
        joueurs.chooseRandomJoueurs();
        lierQuestion(theme,1,joueurs);
    }

    public static ArrayList<Theme> creationQuestions() {
        Theme histoire = new Theme("Histoire");
        Theme geo = new Theme("Géographie");
        Theme div = new Theme("Divertissement");
        Theme art = new Theme("Arts");
        Theme lit = new Theme("Littérature");
        Theme science = new Theme("Science");
        Theme nature = new Theme("Nature");
        Theme sport = new Theme("Sports");
        Theme cinema = new Theme("Cinéma");
        Theme maths = new Theme("Mathématiques");

        ArrayList<Theme> listeThemes = new ArrayList<Theme>();
        listeThemes.add(histoire);
        listeThemes.add(geo);
        /*listeThemes.add(div);
        listeThemes.add(art);
        listeThemes.add(lit);
        listeThemes.add(science);
        listeThemes.add(nature);
        listeThemes.add(sport);
        listeThemes.add(cinema);
        listeThemes.add(maths);*/

        //Ajout des questions du thème Histoire
        QCM h3 = new QCM("Qui a été le premier président des États-Unis ?",1);
        h3.addReponse("George Washington");
        h3.addReponse("John Adams");
        h3.addReponse("Alexander Hamilton");
        listeThemes.get(0).add(h3);

        QCM h10 = new QCM("Comment appelle-t-on les hommes des cavernes ?",1);
        h10.addReponse("Diplodocus");
        h10.addReponse("Ptéranodons");
        h10.addReponse("Troglodytes");
        h10.setIndex(2);
        listeThemes.get(0).add(h10);

        RC h6 = new RC("Combien d'années a duré la guerre de Cent Ans ?",1,"116");
        listeThemes.get(0).add(h6);

        RC h4 = new RC("En quelle année l'humanité a-t-elle posé le pied sur la Lune pour la première fois à bord du vaisseau spatial Apollo 11 ?",1,"1969");
        listeThemes.get(0).add(h4);

        VF h5 = new VF("Jules César a donné son nom au mois de juillet.",2,true);
        listeThemes.get(0).add(h5);

        QCM h7 = new QCM("Dans quelle ville vivait Marco Polo ?",2);
        h7.addReponse("Venice");
        h7.addReponse("Vienne");
        h7.addReponse("Budapest");
        listeThemes.get(0).add(h7);

        VF h9 = new VF("Anaximandre considérait l'eau comme un élément intégré dans toutes choses.",2,false);
        listeThemes.get(0).add(h9);

        RC h8 = new RC("En quelle année la Slovénie est-elle devenue indépendante de la Yougoslavie ?",3,"1991");
        listeThemes.get(0).add(h8);

        RC h2 = new RC("La chute de Constantinople a marqué la fin de l'Empire byzantin. En quelle année a-t-elle eu lieu ?",3,"1453");
        listeThemes.get(0).add(h2);

        RC h1 = new RC("Le Mozambique a été colonisé par un pays européen, lequel ?",3,"Portugal");
        listeThemes.get(0).add(h1);

        //Ajout des questions du thème Géographie
        VF g1 = new VF("L'Italie est le plus méridional des pays européens.",1,false);
        listeThemes.get(1).add(g1);
        QCM g3 = new QCM("Quelle est la capitale de l'Egypte ?",1);
        g3.addReponse("Le Caire");
        g3.addReponse("Alexandrie");
        g3.addReponse("Assouan");
        listeThemes.get(1).add(g3);
        RC g5 = new RC("Quel est le plus long fleuve de France ?", 1, "La Loire");
        listeThemes.get(1).add(g5);

        QCM g2 = new QCM("Quelle était la monnaie utilisée en Espagne avant l'euro ?",2);
        g2.addReponse("Le peseta");
        g2.addReponse("Le réal");
        g2.addReponse("Le peso");
        listeThemes.get(1).add(g2);
        QCM g4 = new QCM("De quelle origine nous vient le sauna ?",2);
        g4.addReponse("Des finlandais");
        g4.addReponse("Des indiens");
        g4.addReponse("Des australiens");
        listeThemes.get(1).add(g4);

        RC d1 = new RC("Dans quel film croise-t-on le coq Rocky chargé par Ginger la poule d'apprendre à voler à un poulailler menacé ?",1,"Chicken Run");
        return listeThemes;
    }

    /**
     * Permet à l'utilisateur de creer des joueurs
     * @return Liste des joueurs de la partie
     * @author Mathilde Paysant
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
                case 2 :
                    System.out.println(joueurs);
                    joueurs.deleteJoueur();
                    break;
                case 3 :
                    System.out.println(joueurs+"\n");
                    break;
                case 4 :
                    if (joueurs.getNbJoueurs() >= 4) {
                        System.out.println("Lancement de la partie...\n");
                        return joueurs;
                    } else {
                        System.out.println("Nombre de joueurs insuffisants, ajoutez des joueurs.\n");
                    }
            }
        }
    }

    /**
     * Permet de poser une question, de vérifier la réponse et de mettre à jour le score du joueur
     * @param joueur le joueur a qui on pose la question
     * @param question la question qui est posé
     * @param phase la phase de la partie
     * @author Emmie KIEFFER
     */
    public static void poserQuestion(Joueur joueur, Question question, int phase){
        final int POINT_PHASE_1=2;
        final int POINT_PHASE_2=3;
        final int POINT_PHASE_3=5;
        Scanner scanner = new Scanner(System.in);
        if (question instanceof QCM) {
            int i = ((QCM) question).afficherQuestion();
            int n = scanner.nextInt();
            if(((QCM) question).verifier(n,i)){
                switch (phase) {
                    case(1):
                        joueur.ajouterScore(POINT_PHASE_1);
                        System.out.println("Bonne réponse ! "+joueur.getNom()+" gagne "+POINT_PHASE_1+" points.\n");
                        break;
                    case(2):
                        joueur.ajouterScore(POINT_PHASE_2);
                        System.out.println("Bonne réponse ! "+joueur.getNom()+" gagne "+POINT_PHASE_2+" points.\n");
                        break;
                    case(3):
                        joueur.ajouterScore(POINT_PHASE_3);
                        System.out.println("Bonne réponse ! "+joueur.getNom()+" gagne "+POINT_PHASE_3+" points.\n");
                        break;
                }
            } else {
                System.out.println("Mauvaise réponse ! "+joueur.getNom()+" ne gagne aucun point.\n");
            }
        }
        else if (question instanceof RC){
            System.out.println(question);
            String n = scanner.nextLine();
            if(((RC) question).verifier(n)){
                switch (phase) {
                    case(1):
                        joueur.ajouterScore(POINT_PHASE_1);
                        System.out.println("Bonne réponse ! "+joueur.getNom()+" gagne "+POINT_PHASE_1+" points.\n");
                        break;
                    case(2):
                        joueur.ajouterScore(POINT_PHASE_2);
                        System.out.println("Bonne réponse ! "+joueur.getNom()+" gagne "+POINT_PHASE_2+" points.\n");
                        break;
                    case(3):
                        joueur.ajouterScore(POINT_PHASE_3);
                        System.out.println("Bonne réponse ! "+joueur.getNom()+" gagne "+POINT_PHASE_3+" points.\n");
                        break;
                }
            } else {
                System.out.println("Mauvaise réponse ! "+joueur.getNom()+" ne gagne aucun point.\n");
            }
        }
        else if(question instanceof VF){
            System.out.println(question);
            int n = scanner.nextInt();
            if(((VF) question).verifier(n)){
                switch (phase) {
                    case(1):
                        joueur.ajouterScore(POINT_PHASE_1);
                        System.out.println("Bonne réponse ! "+joueur.getNom()+" gagne "+POINT_PHASE_1+" points.\n");
                        break;
                    case(2):
                        joueur.ajouterScore(POINT_PHASE_2);
                        System.out.println("Bonne réponse ! "+joueur.getNom()+" gagne "+POINT_PHASE_2+" points.\n");
                        break;
                    case(3):
                        joueur.ajouterScore(POINT_PHASE_3);
                        System.out.println("Bonne réponse ! "+joueur.getNom()+" gagne "+POINT_PHASE_3+" points.\n");
                        break;
                }
            } else {
                System.out.println("Mauvaise réponse ! "+joueur.getNom()+" ne gagne aucun point.\n");
            }
        }
    }

    /**
     * Choix d'un thème tour à tour pour les joueurs restant en phase 2
     * @return la liste des joueurs et leurs choix de thèmes
     * @author Thomas Gendron
     */


    public static ArrayList<ArrayList> choisirTheme(ArrayList<Theme> listeThemes, Joueurs joueursSelectionnes) {
        ArrayList<Integer> aleatoire = new ArrayList<>();
        aleatoire.add(0);
        aleatoire.add(1);
        aleatoire.add(2);
        Collections.shuffle(aleatoire);
        ArrayList<ArrayList> choix = new ArrayList<>();
        choix.add(new ArrayList<Theme>());
        choix.add(new ArrayList<Theme>());
        choix.add(new ArrayList<Theme>());
        while (!listeThemes.isEmpty()) {
            for (int integer : aleatoire) {
                choix.add(new ArrayList<Theme>());
                Joueur j1 = joueursSelectionnes.getJoueur(integer);
                boolean verify;
                verify = false;
                while (!verify) {
                    System.out.println(j1.getNom() + ", choisissez un thème parmi : ");
                    for (int i = 0; i < listeThemes.size(); i++) {
                        System.out.println(i + 1 + ") " + listeThemes.get(i));
                    }
                    Scanner scanner = new Scanner(System.in);
                    int n = scanner.nextInt();
                    if (n > 0 && n <= listeThemes.size()) {
                        choix.get(integer).add(listeThemes.get(n - 1));
                        listeThemes.remove(n - 1);
                        verify = true;
                    }
                    else {
                        System.out.println("Thème indisponible ! \n");
                    }
                }
            }
        }
        return choix;
    }

     /**
      * Lier les question au joueurs pour ensuite leur poser
      * @param theme le theme des questions
      * @param phase la phase du jeu
      * @author Emmie KIEFFER
      */
     public static void lierQuestion(Theme theme, int phase, Joueurs joueurs){;
         ArrayList<Question> listeQuestions = theme.getQuestions(phase);

         ArrayList<Joueur> listeJoueurs = joueurs.getJoueursRestants().getJoueurs();
         System.out.println(listeJoueurs);
         Collections.shuffle(listeQuestions);
         for(int i=0;i<listeJoueurs.size();i++){
             System.out.println(listeJoueurs.get(i).getNom()+", à vous de jouer !");
             poserQuestion(listeJoueurs.get(i),listeQuestions.get(i),phase);
         }
     }
}
