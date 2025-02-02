package projetpoo;

import java.time.LocalDate;

class Paiement {
    private Patient patient;
    private double montant;
    private LocalDate date;
    private String methodePaiement; // Added field for payment method

    public Paiement(Patient patient, double montant, LocalDate date, String methodePaiement) {
        if (patient == null) {
            System.out.println("Error: Patient is null in Paiement constructor");
        }
        if (date == null) {
            System.out.println("Error: Date is null in Paiement constructor");
        }

        this.patient = patient;
        this.montant = montant;
        this.date = date;
        this.methodePaiement = methodePaiement; // Initialize the payment method
    }

    public Paiement(FichePatient patient2, double montant2, LocalDate date2, String methodePaiement2) {
		// TODO Auto-generated constructor stub
	}

	public Patient getPatient() { return patient; }
    public double getMontant() { return montant; }
    public LocalDate getDate() { return date; }
    public String getMethodePaiement() { return methodePaiement; } // Getter for payment method

	public void add(Paiement paiement) {
		// TODO Auto-generated method stub
		
	}
}



