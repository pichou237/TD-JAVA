package POO.Bibliotheque;

import java.time.LocalDate;
import java.util.Date;

public class Livre {

    // Attributs
    private String isbn;
    private String titre;
    private String auteur;
    private int anneePublication;
    private boolean disponible;

    // Constructeur principal
    public Livre(String _isbn, String _titre, String _auteur, int _anneePublication, boolean _disponible) {
        this.isbn = _isbn;
        this.titre = _titre;
        this.auteur = _auteur;
        this.anneePublication = _anneePublication;
        this.disponible = _disponible;
    }

    // Constructeur secondaire avec valeur par défaut
    public Livre(String _isbn, String _titre, String _auteur, int _anneePublication) {
        this(_isbn, _titre, _auteur, _anneePublication, true);
    }

    // les getters

    public String getIsbn() {
        return isbn;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public boolean isDisponible() {
        return disponible;
    }


    // les setters

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // methode getAge qui retourne l'age du livre
    public int getAge(){
    //   Date date = new Date();
        int anneeActuelle = LocalDate.now().getYear();
        return anneeActuelle - this.anneePublication;
    }

    // methode pour afficher les informations d'un livre
    public void afficherDetails() {
        System.out.println("===== Informations du Livre =====");
        System.out.println("ISBN : " + isbn);
        System.out.println("Titre : " + titre);
        System.out.println("Auteur : " + auteur);
        System.out.println("Année de publication : " + anneePublication);
        System.out.println("Disponible : " + (disponible ? "Oui" : "Non"));
        System.out.println("Âge du livre : " + getAge() + " ans");
        System.out.println("=================================");
    }

}
