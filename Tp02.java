import java.util.Scanner;

public class TP1 {

    // Un seul Scanner pour tout le programme (static pour que toutes les méthodes l'utilisent)
    static Scanner sc = new Scanner(System.in);

    
    // EXERCICE 1 : saisir les noms et les notes de n étudiants,
    //              puis afficher ces informations

    static void exercice1() {
        System.out.print("Nombre d'etudiants : ");
        int n = sc.nextInt();
        sc.nextLine();                 // vide le retour à la ligne laissé par nextInt()

        // Deux tableaux "parallèles" : noms[i] et notes[i] concernent le même étudiant
        String[] noms = new String[n];
        double[] notes = new double[n];

        //  Saisie
        for (int i = 0; i < n; i++) {
            System.out.print("Nom de l'etudiant " + (i + 1) + " : ");
            noms[i] = sc.nextLine();   // nextLine() pour lire un nom (avec espaces possibles)

            System.out.print("Note de " + noms[i] + " : ");
            notes[i] = sc.nextDouble();
            sc.nextLine();             // vide le retour à la ligne laissé par nextDouble()
        }

        // Affichage 
        System.out.println("\n Liste des etudiants ");
        for (int i = 0; i < n; i++) {
            System.out.println(noms[i] + " : " + notes[i]);
        }
    }

    // EXERCICE 2 : afficher la catégorie d'un enfant selon son âge
    //   poussin : 6-7 ans | pupille : 8-9 ans
    //   minime : 10-11 ans | cadet : 12 ans et plus
 
    static void exercice2() {
        System.out.print("Age de l'enfant : ");
        int age = sc.nextInt();
        sc.nextLine();

        // Les conditions sont testées dans l'ordre : la première vraie est exécutée
        if (age >= 6 && age <= 7) {
            System.out.println("Categorie : poussin");
        } else if (age >= 8 && age <= 9) {
            System.out.println("Categorie : pupille");
        } else if (age >= 10 && age <= 11) {
            System.out.println("Categorie : minime");
        } else if (age >= 12) {
            System.out.println("Categorie : cadet");
        } else {
            // Cas non prévu par l'énoncé : enfant de moins de 6 ans
            System.out.println("Pas de categorie (age inferieur a 6 ans)");
        }
    }

   
    // EXERCICE 3 : afficher les nombres pairs entre 0 et N

    static void exercice3() {
        System.out.print("Entrez N : ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Nombres pairs entre 0 et " + n + " :");
        for (int i = 0; i <= n; i++) {
            // Un nombre est pair si le reste de sa division par 2 est 0
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

 
    // EXERCICE 4 : afficher les arguments de la ligne de commande
    //   Exemple : java TP1 arg1 arg2 arg3

    static void exercice4(String[] args) {
        // args.length = nombre d'arguments donnés au lancement du programme
        if (args.length == 0) {
            System.out.println("Aucun argument. Lancez : java TP1 arg1 arg2 arg3");
        } else {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);   // args[0] = premier argument, etc.
            }
        }
    }

  
    // PROGRAMME PRINCIPAL : menu pour choisir l'exercice 

    public static void main(String[] args) {
        int choix;

        do {
            System.out.println("\n TP1 : Elements de base du langage Java ");
            System.out.println("1. Exercice 1 : etudiants (noms et notes)");
            System.out.println("2. Exercice 2 : categorie d'un enfant");
            System.out.println("3. Exercice 3 : nombres pairs jusqu'a N");
            System.out.println("4. Exercice 4 : arguments de la ligne de commande");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            System.out.println();
            switch (choix) {
                case 1: exercice1();     break;
                case 2: exercice2();     break;
                case 3: exercice3();     break;
                case 4: exercice4(args); break;   // on passe args reçu par main
                case 0: System.out.println("Au revoir !"); break;
                default: System.out.println("Choix invalide.");
            }
        } while (choix != 0);   // le menu se répète jusqu'à ce qu'on tape 0

        sc.close();
    }
}
