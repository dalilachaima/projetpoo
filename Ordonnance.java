package projetpoo;

import java.util.List;
import java.time.LocalDate;

public class Ordonnance {

    private Medecin medecin;
    private Patient patient;
    private List<String> medicaments;
    private String instructions;
    private LocalDate dateDePrescription;

    // Constructeur complet
    public Ordonnance(Medecin medecin, Patient patient, List<String> medicaments, String instructions, LocalDate dateDePrescription) {
        this.medecin = medecin;
        this.patient = patient;
        this.medicaments = medicaments;
        this.instructions = instructions;
        this.dateDePrescription = dateDePrescription;
    }

    // Constructeur sans instructions
    public Ordonnance(Medecin medecin, Patient patient, List<String> medicaments, LocalDate dateDePrescription) {
        this(medecin, patient, medicaments, null, dateDePrescription);
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

        return "Docteur: " + medecin.getNom() + " " + medecin.getPrenom() + " Spécialité: " + medecin.getSpecialty()
                + "\nPrescription Pour: " + abre + ". " + patient.getNom() + " " + patient.getPrenom() + " né(e) le " + patient.getDate_de_naissance()
                + "\nDate de Prescription: " + dateDePrescription + "\nMédicaments: " + medicaments
                + "\nInstructions: " + instructions;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<String> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<String> medicaments) {
        this.medicaments = medicaments;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public LocalDate getDateDePrescription() {
        return dateDePrescription;
    }

    public void setDateDePrescription(LocalDate dateDePrescription) {
        this.dateDePrescription = dateDePrescription;
    }
}
