package POO.Bibliotheque;

public abstract class Membre {

    // Attributs
    protected String id;
    protected String nom;
    protected String email;

    // Constructeur
    public Membre(String id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Méthodes abstraites
    public abstract int getNombreMaxEmprunts();
    public abstract int getDureeEmprunt();

    // Méthode commune d'affichage (optionnelle)
    public void afficherInfo() {
        System.out.println("ID : " + id);
        System.out.println("Nom : " + nom);
        System.out.println("Email : " + email);
    }
}
