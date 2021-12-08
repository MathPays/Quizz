import Jeu.Joueur.IA;
import Jeu.Joueur.Joueur;
import Jeu.Joueur.Joueurs;
import Jeu.Question.QCM;
import Jeu.Question.Question;
import Jeu.Question.RC;
import Jeu.Question.VF;
import Jeu.Theme.Theme;
import Jeu.Theme.Themes;

import java.util.*;

public class Main {
    /**
     * Main regroupant les fonctions : gestions de la partie
     * @author Antoine AOUAT
     */
    public static void main(String[] args) {
        ArrayList<Theme> listeThemes = CreationQuestions.creationQuestions();
        Joueurs joueurs = creerJoueurs();
        joueurs.chooseRandomJoueurs();

        /**
         * PHASE 1
         */
        Themes themes = new Themes(listeThemes, 1);

        for (int i = 0; i < 10; i++){
            lierQuestion(themes.getNextTheme(), 1, joueurs);
        }
        joueurs.elimineDernier();

        /**
         * PHASE 2 Marche pour Vrai joueurs mais pas IA  TO DO : elim
         */

        themes = new Themes(listeThemes, 2);
        choisirTheme(themes,joueurs.getJoueursRestants());
        joueurs.elimineDernier();

        /**
         * PHASE 3
         */
        themes = new Themes(listeThemes, 3);
        for (int i = 0; i < 3; i++){
            lierQuestion(themes.getNextTheme(), 3, joueurs);
        }
        joueurs.elimineDernier();
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
            try {
                int n = scanner.nextInt();
                switch (n) {
                    case 1 :
                        joueurs.creerJoueur();
                        break;
                    case 2 :
                        System.out.println(joueurs);
                        //joueurs.deleteJoueur();
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
                        break;
                    default:
                        System.out.println("Entrez un nombre valide.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrez un nombre valide.");
            }
        }
    }

    /**
     * Affiche et incrémente le score des joueurs
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
    public static void choisirTheme(Themes themes, Joueurs joueursSelectionnes) {
        ArrayList<Theme> listeThemes = themes.getThemes();
        ArrayList<Integer> aleatoire = new ArrayList<>();
        aleatoire.add(0);
        aleatoire.add(1);
        aleatoire.add(2);
        Collections.shuffle(aleatoire);
        ArrayList<ArrayList<Theme>> choix = new ArrayList<>();
        choix.add(new ArrayList<Theme>());
        choix.add(new ArrayList<Theme>());
        choix.add(new ArrayList<Theme>());
        while (true) {
            for (int integer : aleatoire) {
                if (listeThemes.isEmpty()) {
                    lierQuestions(choix, joueursSelectionnes);
                    return;
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
                    int n = 1;
                    if (listeThemes.size() > 1) {
                        n = r.nextInt(listeThemes.size()-1) + 1;
                    }
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
        }
    }

    /**
     * Lier les questions dans les thèmes choisis aux joueurs
     * @param choix choix des themes par joueur
     * @param joueursSelectionnes joueurs en jeu
     */
    public static void lierQuestions(ArrayList<ArrayList<Theme>> choix, Joueurs joueursSelectionnes) {
        Joueur[] joueurs = joueursSelectionnes.getJoueurs();
        for (int i =0; i < 3; i++) {
            for (Theme theme:choix.get(i)) {
                System.out.println(joueurs[i].getNom()+", à vous de jouer !");
                poserQuestion(joueurs[i], theme.getRandomQuestion(2), 2);
            }
        }
    }

     /**
      * Lier les questions aux joueurs pour ensuite leur poser
      * @param theme le theme des questions
      * @param phase la phase du jeu
      * @param joueurs la liste des joueurs selectionnes
      * @author Emmie KIEFFER
      */
     public static void lierQuestion(Theme theme, int phase, Joueurs joueurs){;
         ArrayList<Question> listeQuestions = theme.getQuestions(phase);

         Joueur[] listeJoueurs = joueurs.getJoueursRestants().getJoueurs();
         Collections.shuffle(listeQuestions);
         for(int i=0;i<joueurs.getNbJoueursSelectionnes();i++){
             System.out.println(listeJoueurs[i].getNom()+", à vous de jouer !");
             poserQuestion(listeJoueurs[i],listeQuestions.get(i),phase);
         }
     }
}
