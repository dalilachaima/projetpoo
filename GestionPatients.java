package projetpoo;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate; 
public class GestionPatients {
    private ArrayList<FichePatient> patients;

    public GestionPatients() {
        this.patients = new ArrayList<>();
    }

    public void ajouter(Scanner scanner) {
        System.out.print("Nom : ");
        String nom = scanner.nextLine().trim();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine().trim();
        System.out.print("Adresse : ");
        String adresse = scanner.nextLine().trim();
        System.out.print("Téléphone : ");
        int numeroTelephone = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Date de naissance (YYYY-MM-DD) : ");
        LocalDate dateNaissance = LocalDate.parse(scanner.nextLine().trim());
        System.out.print("Sexe (H/F) : ");
        String sexe = scanner.nextLine().trim().toUpperCase();

        FichePatient patient = new FichePatient(nom, prenom, dateNaissance, adresse, sexe, adresse, numeroTelephone, "O+", new TerrainMedical());
        System.out.println("Mettez à jour le terrain médical du patient :");
        patient.getTerrainMedical().mettreAJourTerrain(scanner);

        patients.add(patient);
        System.out.println("Patient ajouté avec succès !");
    }

    public void modifier(Scanner scanner) {
        System.out.print("Entrez le nom du patient à modifier : ");
        String nom = scanner.nextLine().trim();
        FichePatient patient = trouverPatient(nom);

        if (patient != null) {
            System.out.print("Nouveau prénom : ");
            patient.setPrenom(scanner.nextLine().trim());
            System.out.print("Nouvelle adresse : ");
            patient.setAddress(scanner.nextLine().trim());
            System.out.print("Nouveau téléphone : ");
            patient.setNumeroTelephone(Integer.parseInt(scanner.nextLine().trim()));
            System.out.print("Nouvelle date de naissance (YYYY-MM-DD) : ");
            patient.setDate_de_naissance(LocalDate.parse(scanner.nextLine().trim()));
            System.out.print("Nouveau sexe (H/F) : ");
            patient.setSexe(scanner.nextLine().trim().toUpperCase());
            System.out.println("Mettez à jour le terrain médical du patient :");
            patient.getTerrainMedical().mettreAJourTerrain(scanner);

            System.out.println("Fiche patient modifiée avec succès !");
        } else {
            System.out.println("Patient introuvable.");
        }
    }

    public void supprimer(Scanner scanner) {
        System.out.print("Entrez le nom du patient à supprimer : ");
        String nom = scanner.nextLine().trim();
        FichePatient patient = trouverPatient(nom);

        if (patient != null) {
            patients.remove(patient);
            System.out.println("Patient supprimé avec succès !");
        } else {
            System.out.println("Patient introuvable.");
        }
    }

    public void afficher() {
        if (patients.isEmpty()) {
            System.out.println("Aucune fiche patient disponible.");
        } else {
            for (FichePatient patient : patients) {
                System.out.println("\n--- Fiche Patient ---");
                patient.afficherFiche();
            }
        }
    }

    public FichePatient trouverPatient(String nom) {
        for (FichePatient patient : patients) {
            if (patient.getNom().equalsIgnoreCase(nom)) {
                  return patient;
            }
        }
        return null;
    }

}