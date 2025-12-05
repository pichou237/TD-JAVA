package POO.Bibliotheque;

public class Etudiant extends Membre {

    // Attribut spécifique
    private String filiere;

    // Constructeur
    public Etudiant(String id, String nom, String email, String filiere) {
        super(id, nom, email); // Appel du constructeur parent
        this.filiere = filiere;
    }

    // Getter et Setter de filiere
    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    // Redéfinition des méthodes abstraites
    @Override
    public int getNombreMaxEmprunts() {
        return 3; // Étudiant peut emprunter 3 livres
    }

    @Override
    public int getDureeEmprunt() {
        return 14; // 14 jours pour l'étudiant
    }

    // Méthode afficherInfo
    @Override
    public void afficherInfo() {
        System.out.println("===== Étudiant =====");
        super.afficherInfo();
        System.out.println("Filière : " + filiere);
        System.out.println("Nombre max emprunts : " + getNombreMaxEmprunts());
        System.out.println("Durée d'emprunt : " + getDureeEmprunt() + " jours");
        System.out.println("=====================");
    }
}
