import Jeu.Question.QCM;
import Jeu.Question.RC;
import Jeu.Question.VF;
import Jeu.Theme.Theme;

import java.util.ArrayList;

public class CreationQuestions {

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

        //Ajout des questions du thème Histoire
        QCM h3 = new QCM("Qui a été le premier président des États-Unis ?",1);
        h3.addReponse("George Washington");
        h3.addReponse("John Adams");
        h3.addReponse("Alexander Hamilton");
        histoire.add(h3);
        QCM h10 = new QCM("Comment appelle-t-on les hommes des cavernes ?",1);
        h10.addReponse("Diplodocus");
        h10.addReponse("Ptéranodons");
        h10.addReponse("Troglodytes");
        h10.setIndex(2);
        histoire.add(h10);
        RC h6 = new RC("Combien d'années a duré la guerre de Cent Ans ?",1,"116");
        histoire.add(h6);
        RC h4 = new RC("En quelle année l'humanité a-t-elle posé le pied sur la Lune pour la première fois à bord du vaisseau spatial Apollo 11 ?",1,"1969");
        histoire.add(h4);

        VF h5 = new VF("Jules César a donné son nom au mois de juillet.",2,true);
        histoire.add(h5);
        QCM h7 = new QCM("Dans quelle ville vivait Marco Polo ?",2);
        h7.addReponse("Venice");
        h7.addReponse("Vienne");
        h7.addReponse("Budapest");
        histoire.add(h7);
        VF h9 = new VF("Anaximandre considérait l'eau comme un élément intégré dans toutes choses.",2,false);
        histoire.add(h9);

        RC h8 = new RC("En quelle année la Slovénie est-elle devenue indépendante de la Yougoslavie ?",3,"1991");
        histoire.add(h8);
        RC h2 = new RC("La chute de Constantinople a marqué la fin de l'Empire byzantin. En quelle année a-t-elle eu lieu ?",3,"1453");
        histoire.add(h2);
        RC h1 = new RC("Le Mozambique a été colonisé par un pays européen, lequel ?",3,"Portugal");
        histoire.add(h1);

        //Ajout des questions du thème Géographie
        VF g1 = new VF("L'Italie est le plus méridional des pays européens.",1,false);
        geo.add(g1);
        QCM g3 = new QCM("Quelle est la capitale de l'Egypte ?",1);
        g3.addReponse("Le Caire");
        g3.addReponse("Alexandrie");
        g3.addReponse("Assouan");
        geo.add(g3);
        RC g5 = new RC("Quel est le plus long fleuve de France ?", 1, "La Loire");
        geo.add(g5);
        VF g7 = new VF("La Guyana fait partie de la France.",1,false);
        geo.add(g7);

        QCM g2 = new QCM("Quelle était la monnaie utilisée en Espagne avant l'euro ?",2);
        g2.addReponse("Le peseta");
        g2.addReponse("Le réal");
        g2.addReponse("Le peso");
        geo.add(g2);
        QCM g4 = new QCM("De quelle origine nous vient le sauna ?",2);
        g4.addReponse("Des finlandais");
        g4.addReponse("Des indiens");
        g4.addReponse("Des australiens");
        geo.add(g4);
        QCM g6 = new QCM("Avec quel pays Singapour a-t-il une frontière terrestre ?",2);
        g6.addReponse("Malaisie");
        g6.addReponse("Thaïlande");
        g6.addReponse("Indonésie");
        geo.add(g6);
        VF g9 = new VF("Bordeaux est au sud de Washington.",2,false);
        geo.add(g9);
        QCM g8 = new QCM("Quelle est la capitale des Maldives ?",3);
        g8.addReponse("Malé");
        g8.addReponse("Mahé");
        g8.addReponse("Saint-Louis");
        geo.add(g8);
        RC g10 = new RC("A quel pays appartient le Groënland ?",3,"Danemark");
        geo.add(g10);
        RC g11 = new RC("Quel est le nom du volcan de la Réunion ?",3,"Le python de la fournaise");
        geo.add(g11);
        QCM g12 = new QCM("A quel pays appartient l'île de Pâques ?",3);
        g12.addReponse("Chili");
        g12.addReponse("Mexique");
        g12.addReponse("Nouvelle-Zélande");
        geo.add(g12);

        //Ajout des questions du thème Science
        QCM sc1 = new QCM("Quelle est la distance Terre-Lune ?",1);
        sc1.addReponse("~400 000 km");
        sc1.addReponse("~600 000 km");
        sc1.addReponse("~1 200 000 km");
        science.add(sc1);
        RC sc3 = new RC("Comment appelle-t-on un scientifique qui étudie les volcans ?",1,"Vulcanologue");
        science.add(sc3);
        VF sc8 = new VF("L'uretère est le conduit qui permet d'écouler l'urine dehors.",1,false);
        science.add(sc8);
        QCM sc9 = new QCM("Quelle est la vitesse de la lumière ?",1);
        sc9.addReponse("300 000 km/s");
        sc9.addReponse("300 000 m/s");
        sc9.addReponse("300 000 km/h");
        science.add(sc9);

        VF sc4 = new VF("0°Celsius est supérieur à 0°Fahrenheit.",2,true);
        science.add(sc4);
        RC sc5 = new RC("Quelle est la 7ème planète du Système Solaire en partant du Soleil ?",2,"Uranus");
        science.add(sc5);
        QCM sc6 = new QCM("Quelle est la force maximale sur l'échelle de Richter ?",2);
        sc6.addReponse("Pas de limite");
        sc6.addReponse("9");
        sc6.addReponse("10");
        science.add(sc6);

        QCM sc2 = new QCM("Comment obtient-on du laiton ?",3);
        sc2.addReponse("Alliage cuivre et zinc");
        sc2.addReponse("Alliage plomb et zinc");
        sc2.addReponse("Alliage cuivre et plomb");
        science.add(sc2);
        QCM sc7 = new QCM("Quel est l'ordre de grandeur du noyau d'un atome ?",3);
        sc7.addReponse("10E-15 m");
        sc7.addReponse("10E-10 m");
        sc7.addReponse("10E-31 m");
        science.add(sc7);


        //Ajout des questions du thème Nature
        QCM n1 = new QCM("Quelle est la principale plante à l'origine de la tequila ?",1);
        n1.addReponse("L'agave");
        n1.addReponse("Le seigle");
        n1.addReponse("La pomme de terre");
        n1.addReponse("L'aloe vera");
        nature.add(n1);
        QCM n6 = new QCM("Quelle partie de la carotte mange-t-on ?",1);
        n6.addReponse("La racine");
        n6.addReponse("Le fruit");
        n6.addReponse("Les feuilles");
        nature.add(n6);
        RC n4 = new RC("Il existe un mois durant lequel il peut y avoir moins de quatre phases lunaire. Quel est-il ?",1,"Février");
        nature.add(n4);
        VF n9 = new VF("L'ornitologie est l'étude des ornithorinques.",1,false);
        nature.add(n9);

        QCM n7 = new QCM("Parmi ces métaux, lequel n'est pas précieux ?",2);
        n7.addReponse("L'or");
        n7.addReponse("L'argent");
        n7.addReponse("Le plomb");
        nature.add(n7);
        QCM n5 = new QCM("Qu'étudie un phycologue ?",2);
        n5.addReponse("Les algues");
        n5.addReponse("Les coquillages");
        n5.addReponse("Les oursins");
        nature.add(n5);
        VF n3 = new VF("Le règne des Fungi est un des 5 règnes lesquels les organismes vivants sont divisés",2,true);
        nature.add(n3);

        QCM n2 = new QCM("Quel oiseau se nourrit uniquement d'os ?",3);
        n2.addReponse("L'urubu à tête rouge'");
        n2.addReponse("Le gypaète barbu");
        n2.addReponse("Le milan à queue fourchue");
        n2.addReponse("L'élanien blac");
        nature.add(n2);
        QCM n8 = new QCM("Quel est le nom donné à l'étude des mousses ?", 3);
        n8.addReponse("La bryologie");
        n8.addReponse("La mycologie");
        n8.addReponse("L'entomologie");
        n8.addReponse("La protozoologie");
        n8.addReponse("L'ichtyologie");
        nature.add(n8);

        //Ajout des questions du thème cinéma
        QCM c1 = new QCM("Comment s'appelle l'antagoniste principal de la saga Harry Potter ?",1);
        c1.addReponse("Lord Voldemort");
        c1.addReponse("Severus Rogue");
        c1.addReponse("Lucius Malefoy");
        c1.addReponse("Dolores Ombrages");
        cinema.add(c1);
        QCM c2 = new QCM("Dans la saga du Seigneur des Anneaux, qui a forgé l'Anneau Unique ?",1);
        c2.addReponse("Sauron");
        c2.addReponse("Bilbon Sacquet");
        c2.addReponse("Golum");
        c2.addReponse("Saroumane");
        cinema.add(c2);
        RC c3 = new RC("Quels sont les inventeurs du cinéma ?",1,"Les Frères Lumières");
        cinema.add(c3);
        VF c4 = new VF("Dans la saga Pirates des Caraïbes, Johnny Depp joue le rôle de Will Turner.",1,false);
        cinema.add(c4);

        QCM c5 = new QCM("Qui a réalisé Pulp Fiction ?",2);
        c5.addReponse("Quentin Tarantino");
        c5.addReponse("Martin Scorsese");
        c5.addReponse("Roger Avery");
        c5.addReponse("David Fincher");
        cinema.add(c5);
        RC c6 = new RC("Combien de films la saga Destination Finale compte-t-elle à l'heure actuelle ?",2,"5");
        cinema.add(c6);
        VF c7 = new VF("Avatar est le plus gros succès du Cinéma.",2,true);
        cinema.add(c7);

        QCM c8 = new QCM("De quoi souffre Léonard Shelby dans Memento ?",3);
        c8.addReponse("Son cerveau est incapable de créer de nouveaux souvenirs.");
        c8.addReponse("Il est amnésique.");
        c8.addReponse("Il se met à bégayer.");
        c8.addReponse("Il est aveugle.");
        cinema.add(c8);
        RC c9 = new RC("En quelle année Francis Ford Coppola a-t-il remporté sa 1ère Palme d'Or au Festival de Cannes ?",3,"1974");
        cinema.add(c9);

        //Ajout des questions du thème Littérature
        QCM l1 = new QCM("Qui a écrit Bel Ami ?",1);
        l1.addReponse("Guy de Maupassant");
        l1.addReponse("Gustave Flaubert");
        l1.addReponse("Emile Zola");
        l1.addReponse("Charles Beaudelaire");
        lit.add(l1);
        QCM l2 = new QCM("Quel livre a été écrit par Stephen King ?",1);
        l2.addReponse("Misery");
        l2.addReponse("Gone Girl");
        l2.addReponse("Ne t'éloigne pas");
        l2.addReponse("Dark Places");
        lit.add(l2);
        VF l7 = new VF("Howard Philip Lovecraft a écris L'Appel de Cthulhu",1,true);
        lit.add(l7);

        VF l4 = new VF("Louis Aragon a écrit le recueil Les Fleurs du Mal",1,false);
        lit.add(l4);

        QCM l5 = new QCM("Parmi les livres écrits par Stephen King, lequel n'a pas été adapté au cinéma ?",2);
        l5.addReponse("Minuit 2");
        l5.addReponse("Shining");
        l5.addReponse("Carrie");
        l5.addReponse("Cujo");
        lit.add(l5);
        RC l6 = new RC("Qui a écrit la nouvelle Hellraiser ?",2,"Clive Barker");
        lit.add(l6);
        RC l3 = new RC("Comment s'appelle le célèbre ensemble de textes écrit par Honoré de Balzac ?",2,"La Comédie Humaine");
        lit.add(l3);


        RC l8 = new RC("Qui a écrit le livre Gone Girl, ayant inspiré le film éponyme de David Fincher ?",3,"Gillian Flyn");
        lit.add(l8);
        RC l9 = new RC("En quelle année a été publiée Les Misérables ?",3,"1862");
        lit.add(l9);

        //Ajout des questions du thème Maths
        RC m1 = new RC("Combien de temps fait 1h40 + 1h40 ?",1,"3h20");
        maths.add(m1);
        QCM m2 = new QCM("Quelle est la surface d'un carré de 10 cm de côté ?",1);
        m2.addReponse("100 cm2");
        m2.addReponse("10 cm2");
        m2.addReponse("1000 cm2");
        maths.add(m2);
        VF m3 = new VF("D'après Thalès, a^2 + b^2 = c^2",1,false);
        maths.add(m3);
        QCM m4 = new QCM("Combien de côtés possède un hexagone ?",1);
        m4.addReponse("8");
        m4.addReponse("3");
        m4.addReponse("6");
        m4.setIndex(2);
        maths.add(m4);
        RC m5 = new RC("Quelle est la moyenne de 4.9 et 44.1 ?",2,"24,5");
        maths.add(m5);
        VF m6 = new VF("Le centre de gravité d'un triangle est le point de concours des médianes.",2,true);
        RC m7 = new RC("3600 secondes sont égales à (en heure):",2,"1 heure");
        maths.add(m7);
        RC m8 = new RC("9-9/9+9-9/9=",3,"16");
        maths.add(m8);
        QCM m9 = new QCM("Quel est le carré du quart du tiers de 12 ?",3);
        m9.addReponse("9");
        m9.addReponse("1");
        m9.addReponse("3");
        m9.addReponse("2");
        m9.setIndex(1);
        maths.add(m9);

        //Ajout des questions du thème Sport
        VF s1 = new VF("Messi porte le maillot 30 au PSG ?",1,true);
        sport.add(s1);
        RC s2 = new RC("Qui a gagné la coupe du monde 2018 ?",1,"France");
        sport.add(s2);
        QCM s3 = new QCM("Que signifie GRS ?",1);
        s3.addReponse("Gymnastique Rythmique et Sportive");
        s3.addReponse("Génération Rapide de Sprint");
        s3.addReponse("Génération Réussite de Saut");
        sport.add(s3);
        RC s4 = new RC("Quelle est la durée en minutes d'un match de football ?",1,"90");
        sport.add(s4);
        RC s5 = new RC("Dans quel sport emploi-t-on les termes suivants : split, spare, strike ?",2,"bowling");
        sport.add(s5);
        VF s6 = new VF("Le basket est un sport olympique.",2,true);
        sport.add(s6);
        QCM s7 = new QCM("Quelle est la distance du marathon ?",2);
        s7.addReponse("30,1 km");
        s7.addReponse("42,195 km");
        s7.addReponse("50 km");
        s7.setIndex(2);
        sport.add(s7);
        QCM s8 = new QCM("Quelle est la périodicité des jeux Olympiques d'été ?",3);
        s8.addReponse("Tous les deux ans");
        s8.addReponse("Tous les trois ans");
        s8.addReponse("Tous les quatre ans");
        s8.setIndex(2);
        sport.add(s8);
        RC s9 = new RC("Combien de titres de moto Valentino Rossi a-t-il remporté ?",3,"9");
        sport.add(s9);

        //Ajout des questions du thème Art
        RC a1 = new RC("Qui a peint \"Guernica\" ?",1,"Picasso");
        art.add(a1);
        QCM a2 = new QCM("Quel était le nom artistique que Vincent Van Gogh utilisait pour signer ses œuvres ?",1);
        a2.addReponse("Vincent");
        a2.addReponse("Van Gogh");
        a2.addReponse("Gogh");
        art.add(a2);
        VF a3 = new VF("Raphaël a peint la Chapelle Sixtine.",1,false);
        art.add(a3);
        QCM a4 = new QCM("Qui a peint \"Le Cri\" ?",1);
        a4.addReponse("Edvard Munch");
        a4.addReponse("Vassily Kandinsky");
        a4.addReponse("Henri Matisse");
        a4.addReponse("Paul Cézanne");
        art.add(a4);

        RC a5 = new RC("Nommez la période d'art et d'architecture extravagante qui a prévalu en Europe pendant la majeure partie du 17e siècle.",2,"Baroque");
        art.add(a5);
        VF a6 = new VF("Léonard de Vinci était un peintre mais également navigateur.",2,false);
        art.add(a6);
        QCM a7 = new QCM("De quel mouvement Kandinsky est-il le précurseur ?",2);
        a7.addReponse("L'abstrait");
        a7.addReponse("Le cubisme");
        a7.addReponse("L'impressionnisme");
        a7.addReponse("Le dadaïsme");
        art.add(a7);

        RC a8 = new RC("The American Gothic est l'une des peintures les plus reconnaissables au monde. Qui l'a peint ?",3,"Grant Wood");
        art.add(a8);
        RC a9 = new RC("Qui a été la première personne vivante à avoir vu ses œuvres exposées au Louvre ?",3,"Georges Braque");
        art.add(a9);

        ArrayList<Theme> listeThemes = new ArrayList<Theme>();
        listeThemes.add(histoire);
        listeThemes.add(geo);
        listeThemes.add(nature);
        listeThemes.add(lit);
        listeThemes.add(cinema);
        listeThemes.add(science);
        listeThemes.add(maths);
        listeThemes.add(sport);
        listeThemes.add(art);
        /*listeThemes.add(div);*/

        return listeThemes;
    }
}
