package Jeu.Question;

public class TestQuestion {
    public static void main(String[] args) {
        //TEST QCM
        QCM qcm = new QCM("Enoncé",1);
        System.out.println("TEST QCM :");
        System.out.println(qcm);
        System.out.println("\nTEST addReponse : ");
        qcm.addReponse("Réponse 1");
        qcm.addReponse("Réponse 2");
        qcm.addReponse("Réponse 3");
        qcm.addReponse("Réponse 4");
        System.out.println(qcm);
        System.out.println("\nTEST deleteReponse : ");
        qcm.deleteReponse(0);
        System.out.println(qcm);
        System.out.println("\nTEST setIndex : ");
        qcm.setIndex(2);
        System.out.println(qcm);
        System.out.println("\nTEST verifier : mauvaise réponse");
        System.out.println(qcm.verifier(1,2));
        System.out.println("\nTEST verifier : bonne réponse");
        System.out.println(qcm.verifier(2,2));
        System.out.println("\nTEST afficherQuestion :");
        qcm.afficherQuestion();
        System.out.println("\nTEST reponseIA :");
        System.out.println(qcm.reponseIA(2));

        //TEST RC
        RC rc = new RC("Enoncé",1,"Réponse");
        System.out.println("\nTEST RC :");
        System.out.println(rc);
        System.out.println("\nTEST verifier : \"Réponse\"");
        System.out.println(rc.verifier("Réponse"));
        System.out.println("\nTEST verifier : \"réponse\"");
        System.out.println(rc.verifier("réponse"));
        System.out.println("\nTEST verifier : \"ezgzrg\"");
        System.out.println(rc.verifier("ezgzrg"));
        System.out.println("\nTEST reponseIA :");
        rc.reponseIA();

        //TEST VF
        VF vf = new VF("Enoncé",3,true);
        System.out.println("\nTEST VF :");
        System.out.println(vf);
        System.out.println("\nTEST verifier : mauvaise réponse");
        System.out.println(vf.verifier(2));
        System.out.println("\nTEST verifier : bonne réponse");
        System.out.println(vf.verifier(1));
        System.out.println("\nTEST reponseIA :");
        System.out.println(vf.reponseIA());
    }
}
