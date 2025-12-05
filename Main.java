package POO.Bibliotheque;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bibliotheque b = new Bibliotheque("Bibliothèque ENSPD");

        // Livres de test
        b.ajouterLivre(new Livre("001", "Java", "Martin", 2020));
        b.ajouterLivre(new Livre("002", "Python", "Durand", 2019));
        b.ajouterLivre(new Livre("003", "POO", "Paul", 2021));

        // Membres de test
        b.inscrireMembre(new Etudiant("E01", "Alice", "alice@gmail.com", "Informatique"));
        b.inscrireMembre(new Enseignant("T01", "Dr Mbi", "mbi@univ.cm", "Mathématiques"));

        int choix;

        do {
            System.out.println("  ||====== BIBLIOTHÈQUE ENSPD ====== ||");
            System.out.println("  ||=================================||");
            System.out.println("  ||======1. Ajouter un livre ====== ||");
            System.out.println("  ||======2. Inscrire un membre =====||");
            System.out.println("  ||======3. Effectuer un emprunt ===||");
            System.out.println("  ||======4. Retourner un livre =====||");
            System.out.println("  ||======5. Rechercher un livre ====||");
            System.out.println("  ||======6. Livres disponibles =====||");
            System.out.println("  ||======7. Statistiques ===========||");
            System.out.println("  ||======0. Quitter ================||");
            System.out.println("  ||==========    Choix : ===========||");

            System.out.print("Entrez votre choix: ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {

                case 1:
                    System.out.print("ISBN : "); String i = sc.nextLine();
                    System.out.print("Titre : "); String t = sc.nextLine();
                    System.out.print("Auteur : "); String a = sc.nextLine();
                    System.out.print("Année : "); int an = sc.nextInt();
                    sc.nextLine();
                    b.ajouterLivre(new Livre(i, t, a, an));
                    break;

                case 2:
                    System.out.print("ID : "); String id = sc.nextLine();
                    System.out.print("Nom : "); String no = sc.nextLine();
                    System.out.print("Email : "); String em = sc.nextLine();
                    System.out.println("1. Étudiant | 2. Enseignant");
                    int type = sc.nextInt();
                    sc.nextLine();

                    if (type == 1) {
                        System.out.print("Filière : ");
                        String fi = sc.nextLine();
                        b.inscrireMembre(new Etudiant(id, no, em, fi));
                    } else {
                        System.out.print("Département : ");
                        String dep = sc.nextLine();
                        b.inscrireMembre(new Enseignant(id, no, em, dep));
                    }
                    break;

                case 3:
                    System.out.print("ISBN : "); String is = sc.nextLine();
                    System.out.print("ID Membre : "); String im = sc.nextLine();
                    System.out.print("Date emprunt : "); String d = sc.nextLine();
                    b.effectuerEmprunt(is, im, d);
                    break;

                case 5:
                    System.out.print("Titre : ");
                    String tt = sc.nextLine();
                    Livre l = b.rechercherLivreParTitre(tt);
                    if (l != null) l.afficherDetails();
                    else System.out.println("Livre introuvable.");
                    break;

                case 6:
                    b.afficherLivresDisponibles();
                    break;

                case 7:
                    b.afficherStatistiques();
                    break;
            }

        } while (choix != 0);

        System.out.println("Merci ! Fin du programme.");
        sc.close();
    }
}
