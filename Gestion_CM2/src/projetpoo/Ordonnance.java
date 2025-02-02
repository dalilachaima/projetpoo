package projetpoo;

import java.util.List;
import java.time.LocalDate;

public class Ordonnance {

    private Medecin medecin;
    private FichePatient patient;
    private List<String> medicaments;
    private String dosage;
    private String duree;
    private LocalDate dateDePrescription;

    // Constructeur complet
    public Ordonnance(Medecin medecin, FichePatient patient, List<String> medicaments, String dosage, String duree, LocalDate dateDePrescription) {
        if (medecin == null) {
            System.out.println("Error: Medecin is null in Ordonnance constructor");
        }
        if (patient == null) {
            System.out.println("Error: Patient is null in Ordonnance constructor");
        }
        if (dateDePrescription == null) {
            System.out.println("Error: Date is null in Ordonnance constructor");
        }
        
        this.medecin = medecin;
        this.patient = patient;
        this.medicaments = medicaments;
        this.dosage = dosage;
        this.duree = duree;
        this.dateDePrescription = dateDePrescription;
    }

    public Ordonnance(FichePatient patient2, Medecin medecin2, String medicament, String dosage2, String duree2,
			LocalDate dateOrdonnance) {
		// TODO Auto-generated constructor stub
	}

	// Affichage de l'ordonnance
    @Override
    public String toString() {
        String abre;
        if (patient.getSexe().equalsIgnoreCase("F")) {
            abre = "Mme";
        } else {
            abre = "M";
        }

        return "Docteur: " + medecin.getNom() + " "  + " Spécialité: " + medecin.getSpecialty()
                + "\nPrescription Pour: " + abre + ". " + patient.getNom() + " "  + " né(e) le " + patient.getDate_de_naissance()
                + "\nDate de Prescription: " + dateDePrescription + "\nMédicaments: " + medicaments
                + "\nDosage: " + dosage + "\nDurée: " + duree;
    }

    public void afficherOrdonnance() {
        System.out.println(this.toString());
    }

    // Getters et setters
    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public FichePatient getPatient() {
        return patient;
    }

    public void setPatient(FichePatient patient) {
        this.patient = patient;
    }

    public List<String> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<String> medicaments) {
        this.medicaments = medicaments;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public LocalDate getDateDePrescription() {
        return dateDePrescription;
    }

    public void setDateDePrescription(LocalDate dateDePrescription) {
        this.dateDePrescription = dateDePrescription;
    }

    public LocalDate getDateOrdonnance() {
        return dateDePrescription;
    }
}
