import Jeu.Joueur.IA;
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
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Définition des thèmes

        ArrayList<Theme> listeThemes = CreationQuestions.creationQuestions();

        Themes themes = new Themes(listeThemes,1);

        Joueurs joueurs = creerJoueurs();
        joueurs.chooseRandomJoueurs();
        while (true) {
            Theme theme = themes.getNextTheme();
            lierQuestion(theme,1,joueurs);
        }
        //
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
            System.out.println("Que souhaitez vous faire ?\n 1) Ajouter un joueur\n 2) Supprimer un joueur \n 3) Afficher les joueurs \n 4) Ajouter une IA \n 5) Lancer la partie");
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
                    joueurs.creerIA();
                    break;
                case 5 :
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
     * Affiche et incrémente le scores des joueurs
     * @param joueur joueur en cours
     * @param phase phase du jeu
     * @author Emmie Kieffer
     */
    public static void ajouterPoints(Joueur joueur, int phase) {
        final int POINT_PHASE_1=2;
        final int POINT_PHASE_2=3;
        final int POINT_PHASE_3=5;
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
    }

    /**
     * Permet de poser une question, de vérifier la réponse et de mettre à jour le score du joueur
     * @param joueur le joueur a qui on pose la question
     * @param question la question qui est posé
     * @param phase la phase de la partie
     * @author Emmie KIEFFER
     */
    public static void poserQuestion(Joueur joueur, Question question, int phase){
        Scanner scanner = new Scanner(System.in);
        //si le joueur est une IA
        if (joueur instanceof IA) {
            System.out.println("IA");
            if (question instanceof QCM) {
                int i = ((QCM) question).afficherQuestion();
                if (((QCM) question).reponseIA(i)) {
                    ajouterPoints(joueur, phase);
                } else {
                    System.out.println("Mauvaise réponse ! " + joueur.getNom() + " ne gagne aucun point.\n");
                }
            } else if (question instanceof RC) {
                System.out.println(question);
                if (((RC) question).reponseIA()) {
                    ajouterPoints(joueur, phase);
                } else {
                    System.out.println("Mauvaise réponse ! " + joueur.getNom() + " ne gagne aucun point.\n");
                }
            } else if(question instanceof VF){
                System.out.println(question);
                if(((VF) question).reponseIA()){
                    ajouterPoints(joueur,phase);
                } else {
                    System.out.println("Mauvaise réponse ! "+joueur.getNom()+" ne gagne aucun point.\n");
                }
            }
        } else {
            if (question instanceof QCM) {
                int i = ((QCM) question).afficherQuestion();
                int n = scanner.nextInt();
                if(((QCM) question).verifier(n,i)){
                    ajouterPoints(joueur,phase);
                } else {
                    System.out.println("Mauvaise réponse ! "+joueur.getNom()+" ne gagne aucun point.\n");
                }
            }
            else if (question instanceof RC){
                System.out.println(question);
                String n = scanner.nextLine();
                if(((RC) question).verifier(n)){
                    ajouterPoints(joueur,phase);
                } else {
                    System.out.println("Mauvaise réponse ! "+joueur.getNom()+" ne gagne aucun point.\n");
                }
            }
            else if(question instanceof VF){
                System.out.println(question);
                int n = scanner.nextInt();
                if(((VF) question).verifier(n)){
                    ajouterPoints(joueur,phase);
                } else {
                    System.out.println("Mauvaise réponse ! "+joueur.getNom()+" ne gagne aucun point.\n");
                }
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
        while (true) {
            for (int integer : aleatoire) {
                if (listeThemes.isEmpty()) {
                    return choix;
                }
                choix.add(new ArrayList<Theme>());
                Joueur j1 = joueursSelectionnes.getJoueur(integer);
                boolean verify;
                verify = false;
                if (j1 instanceof IA) {
                    System.out.println(j1.getNom() + ", choisissez un thème parmi : ");
                    for (int i = 0; i < listeThemes.size(); i++) {
                        System.out.println(i + 1 + ") " + listeThemes.get(i));
                    }
                    Random r = new Random();
                    //int n = r.nextInt(listeThemes.size());
                    int n = r.nextInt(listeThemes.size()-1) + 1;
                    System.out.println(n);
                    if (n > 0 && n <= listeThemes.size()) {
                        choix.get(integer).add(listeThemes.get(n - 1));
                        listeThemes.remove(n - 1);
                    }
                } else {
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
            System.out.println(listeThemes);
        }
    }

     /**
      * Lier les question au joueurs pour ensuite leur poser
      * @param theme le theme des questions
      * @param phase la phase du jeu
      * @param joueurs la liste des joueurs selectionnes
      * @author Emmie KIEFFER
      */
     public static void lierQuestion(Theme theme, int phase, Joueurs joueurs){;
         ArrayList<Question> listeQuestions = theme.getQuestions(phase);

         ArrayList<Joueur> listeJoueurs = joueurs.getJoueursRestants().getJoueurs();
         Collections.shuffle(listeQuestions);
         for(int i=0;i<listeJoueurs.size();i++){
             System.out.println(listeJoueurs.get(i).getNom()+", à vous de jouer !");
             poserQuestion(listeJoueurs.get(i),listeQuestions.get(i),phase);
         }
     }
}
