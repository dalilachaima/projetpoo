package projetpoo;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionPatients {
    private ArrayList<FichePatient> patients;

    public GestionPatients() {
        this.patients = new ArrayList<>();
    }

    public void ajouter(FichePatient patient) {
        patients.add(patient);
    }

    public ArrayList<FichePatient> getPatients() {
        return patients;
    }

    public FichePatient trouverPatient(String nom) {
        for (FichePatient patient : patients) {
            if (patient.getNom().equalsIgnoreCase(nom)) {
                return patient;
            }
        }
        return null;
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

	public void modifier(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	public void afficher() {
		// TODO Auto-generated method stub
		
	}

	public void ajouter(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}
}
