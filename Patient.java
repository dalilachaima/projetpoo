package projetpoo;
import java.time.LocalDate;

public class Patient extends Person {
    private DossierMedical dossierMedical;
    private float poids;
    private float taille;

    public Patient(String nom, String prenom, LocalDate date_de_naissance, String lieu_de_naissance,
                   String sexe, String address, int numeroTelephone, String groupage, float poids, float taille) {
        super(nom, prenom, date_de_naissance, lieu_de_naissance, sexe, address, numeroTelephone, groupage);
        setPoids(poids);
        setTaille(taille);
        this.dossierMedical = new DossierMedical();
    }

    // Getters et Setters
    public float getPoids() { return poids; }
    public void setPoids(float poids) {
        if (poids > 0) { this.poids = poids; }
        else { throw new IllegalArgumentException("Le poids doit être un nombre positif."); }
    }

    public float getTaille() { return taille; }
    public void setTaille(float taille) {
        if (taille > 0) { this.taille = taille; }
        else { throw new IllegalArgumentException("La taille doit être un nombre positif."); }
    }

    // Méthodes pour gérer le dossier médical
    public void ajouterObservation(String observation) { dossierMedical.ajouterObservation(observation); }
    public void ajouterOrdonnance(String ordonnance) { dossierMedical.ajouterOrdonnance(ordonnance); }
    public void ajouterAntecedent(String antecedent) { dossierMedical.ajouterAntecedent(antecedent); }

    public void ajouterDetailsMedical(String type, String detail) {
        switch (type.toLowerCase()) {
            case "maladie chronique": dossierMedical.ajouterMaladieChronique(detail); break;
            case "maladie virale": dossierMedical.ajouterMaladieVirale(detail); break;
            case "complication anterieure": dossierMedical.ajouterComplicationAnterieure(detail); break;
            case "analyse": dossierMedical.ajouterAnalyse(detail); break;
            case "radio": dossierMedical.ajouterRadio(detail); break;
            case "echographie": dossierMedical.ajouterEchographie(detail); break;
            case "scanner": dossierMedical.ajouterScanner(detail); break;
            case "allergie": dossierMedical.ajouterAllergie(detail); break;
            case "chirurgie": dossierMedical.ajouterChirurgie(detail); break;
            default: throw new IllegalArgumentException("Type médical inconnu : " + type);
        }
    }

    public void afficherDossier() {
        System.out.println("\n=== Dossier Médical ===");
        System.out.println("Nom: " + getNom());
        System.out.println("Prénom: " + getPrenom());
        System.out.println("Date de Naissance: " + getDate_de_naissance());
        System.out.println("Lieu de Naissance: " + getLieu_de_naissance());
        System.out.println("Sexe: " + getSexe());
        System.out.println("Poids: " + poids + " kg");
        System.out.println("Taille: " + taille + " cm");
        System.out.println("Groupage: " + getGroupage());
        System.out.println("\nContenu du Dossier Médical:");
        dossierMedical.afficherDossier();
    }

	
}