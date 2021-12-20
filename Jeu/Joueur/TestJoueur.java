package Jeu.Joueur;

public class TestJoueur {
    public static void main(String[] args) {
        //TEST Joueur
        Joueur j1 = new Joueur("Joueur");
        System.out.println("TEST Joueur : "+j1);
        j1.setEtat(Etat.elimine);
        System.out.println("TEST setEtat : "+j1);
        j1.ajouterScore(30);
        System.out.println("TEST ajouterScore : "+j1);

        //TEST IA
        IA j3 = new IA();
        System.out.println("TEST IA"+j3);
        System.out.println("\n");

        //TEST Joueurs
        Joueurs joueurs = new Joueurs();
        System.out.println("TEST Joueurs : liste vide attendue "+joueurs);
        joueurs.addJoueur(j1);
        System.out.println("\nTEST addJoueur : \n"+joueurs);
        joueurs.creerJoueur();
        System.out.println("\nTEST creerJoueur : \n"+joueurs);
        joueurs.creerIA();
        System.out.println("TEST creerIA : \n"+joueurs);
        joueurs.deleteJoueur();
        System.out.println("\nTEST deleteJoueur : \n"+joueurs);
        joueurs.creerIA();
        joueurs.creerIA();
        joueurs.creerIA();
        joueurs.creerIA();
        joueurs.chooseRandomJoueurs();
        System.out.println("TEST chooseRandomJoueurs : \n"+joueurs);
        Joueurs joueursRestants = joueurs.getJoueursRestants();
        System.out.println("\nTEST getJoueursRestants : \n"+joueursRestants);
        System.out.println("\nTEST getJoueurFinal : erreur attendue");
        joueurs.getJoueurFinal();
        Joueurs joueurs1 = new Joueurs();
        System.out.println("\nTEST getJoueurFinal : erreur attendue");
        joueurs1.getJoueurFinal();
        joueurs1.addJoueur(j1);
        joueurs1.addJoueur(j3);
        j3.setEtat(Etat.selectionne);
        System.out.println("\nTEST getJoueurFinal : aucune erreur attendue");
        System.out.println(joueurs1.getJoueurFinal());
        j1.setEtat(Etat.selectionne);
        j1.ajouterScore(30);
        joueurs1.elimineDernier();
        System.out.println("TEST elimineDernier : \n"+joueurs1);
    }
}
