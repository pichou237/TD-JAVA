package POO.Bibliotheque;

public class Enseignant extends Membre {

    // Attribut spécifique
    private String departement;

    // Constructeur
    public Enseignant(String id, String nom, String email, String departement) {
        super(id, nom, email);
        this.departement = departement;
    }

    // Getter / Setter
    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    // Redéfinition des méthodes abstraites
    @Override
    public int getNombreMaxEmprunts() {
        return 5; // Enseignant peut emprunter 5 livres
    }

    @Override
    public int getDureeEmprunt() {
        return 30; // 30 jours pour l'enseignant
    }

    // Méthode afficherInfo
    @Override
    public void afficherInfo() {
        System.out.println("===== Enseignant =====");
        super.afficherInfo();
        System.out.println("Département : " + departement);
        System.out.println("Nombre max emprunts : " + getNombreMaxEmprunts());
        System.out.println("Durée d'emprunt : " + getDureeEmprunt() + " jours");
        System.out.println("======================");
    }
}
