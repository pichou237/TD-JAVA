package POO.Bibliotheque;

public class Bibliotheque {

    private String nom;
    private Livre[] livres = new Livre[100];
    private Membre[] membres = new Membre[50];
    private Emprunt[] emprunts = new Emprunt[200];

    private int nbLivres = 0;
    private int nbMembres = 0;
    private int nbEmprunts = 0;

    public Bibliotheque(String nom) {
        this.nom = nom;
    }

    public void ajouterLivre(Livre l) {
        if (nbLivres < 100) {
            livres[nbLivres] = l;
            nbLivres++;
            System.out.println("Livre ajouté avec succès !");
        }
    }

    public void inscrireMembre(Membre m) {
        if (nbMembres < 50) {
            membres[nbMembres] = m;
            nbMembres++;
            System.out.println("Membre inscrit !");
        }
    }

    public Livre rechercherLivreParTitre(String titre) {
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].getTitre().equalsIgnoreCase(titre)) {
                return livres[i];
            }
        }
        return null;
    }

    public Membre rechercherMembreParId(String id) {
        for (int i = 0; i < nbMembres; i++) {
            if (membres[i].getId().equalsIgnoreCase(id)) {
                return membres[i];
            }
        }
        return null;
    }

    public void effectuerEmprunt(String isbn, String idMembre, String date) {

        Livre livre = null;
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].getIsbn().equalsIgnoreCase(isbn)) livre = livres[i];
        }

        if (livre == null || !livre.isDisponible()) {
            System.out.println("Livre indisponible !");
            return;
        }

        Membre membre = rechercherMembreParId(idMembre);
        if (membre == null) {
            System.out.println("Membre introuvable !");
            return;
        }

        String dateRetour = "xx/xx/xxxx"; // tu peux calculer si tu veux

        emprunts[nbEmprunts] = new Emprunt(livre, membre, date, dateRetour);
        nbEmprunts++;

        System.out.println("Emprunt effectué !");
    }

    public void afficherLivresDisponibles() {
        System.out.println("===== Livres Disponibles =====");
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].isDisponible()) livres[i].afficherDetails();
        }
    }

    public void afficherStatistiques() {

        int dispo = 0;
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].isDisponible()) dispo++;
        }

        int etu = 0, ens = 0;
        for (int i = 0; i < nbMembres; i++) {
            if (membres[i] instanceof Etudiant) etu++;
            else ens++;
        }

        int empruntsEnCours = 0;
        for (int i = 0; i < nbEmprunts; i++) {
            if (!emprunts[i].isRendu()) empruntsEnCours++;
        }

        double taux = (double) empruntsEnCours / nbLivres * 100;

        System.out.println("===== Statistiques =====");
        System.out.println("Livres total : " + nbLivres);
        System.out.println("Livres disponibles : " + dispo);
        System.out.println("Étudiants : " + etu);
        System.out.println("Enseignants : " + ens);
        System.out.println("Emprunts en cours : " + empruntsEnCours);
        System.out.println("Taux d’occupation : " + taux + "%");
        System.out.println("========================");
    }
}
