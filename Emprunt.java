package POO.Bibliotheque;

public class Emprunt {

    // Attributs
    private Livre livre;
    private Membre membre;
    private String dateEmprunt;
    private String dateRetourPrevue;
    private boolean rendu;

    // Constructeur
    public Emprunt(Livre livre, Membre membre, String dateEmprunt, String dateRetourPrevue) {
        this.livre = livre;
        this.membre = membre;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevue = dateRetourPrevue;
        this.rendu = false;

        // Le livre devient indisponible automatiquement
        this.livre.setDisponible(false);
    }

    // Getters
    public Livre getLivre() {
        return livre;
    }

    public Membre getMembre() {
        return membre;
    }

    public String getDateEmprunt() {
        return dateEmprunt;
    }

    public String getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public boolean isRendu() {
        return rendu;
    }


    // Méthode pour retourner le livre
    public void retournerLivre() {
        if (!rendu) {
            this.livre.setDisponible(true);
            this.rendu = true;
            System.out.println("Le livre '" + livre.getTitre() + "' a été retourné avec succès.");
        } else {
            System.out.println("Ce livre a déjà été retourné !");
        }
    }

    // Affichage des détails de l'emprunt
    public void afficherEmprunt() {
        System.out.println("===== Détails de l'emprunt =====");
        System.out.println("Livre : " + livre.getTitre() + " (ISBN: " + livre.getIsbn() + ")");
        System.out.println("Membre : " + membre.getNom() + " (" + membre.getId() + ")");
        System.out.println("Date d'emprunt : " + dateEmprunt);
        System.out.println("Date retour prévue : " + dateRetourPrevue);
        System.out.println("Rendu : " + (rendu ? "Oui" : "Non"));
        System.out.println("================================");
    }
}
