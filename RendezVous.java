package projetpoo;

import java.time.LocalDate;
import java.time.LocalTime;

public class RendezVous{
        private LocalDate date;
	private LocalTime heure;
	private Patient patient;
	private boolean medecinDisponible;

	public RendezVous(LocalDate date, LocalTime heure, Patient patient, boolean medecinDisponible) {
		this.date = date;
		this.heure = heure;
		this.patient = patient;
		this.medecinDisponible = medecinDisponible ;
	}

	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalTime getHeure() {
		return heure;
	}
	
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public boolean getMedecinDisponible() {
		return medecinDisponible;
	}
	
	public void setMedecinDisponible(boolean medecinDisponible) {
		this.medecinDisponible = medecinDisponible;
	}

	public void afficherRendezVous() {
		    System.out.println("Rendez-vous de " + patient.getNom() + " " + patient.getPrenom());
	        System.out.println("Date : " + date + " à " + heure);
	        System.out.println("Médecin disponible : " + medecinDisponible);
	        System.out.println("Informations du patient : " + patient);
	}

	  public void modifier(LocalDate nouvelleDate, LocalTime nouvelleHeure) {
	        this.date = nouvelleDate;
	        this.heure = nouvelleHeure;
	        System.out.println("Rendez-vous modifié pour " + patient.getNom() + " " + patient.getPrenom() + " le " + date + " à " + heure);
	    }

	    public void annuler() {
	        System.out.println("Rendez-vous annulé pour " + patient.getNom() + " " + patient.getPrenom());
	    }
	
	 public void planifier() {
	        if (medecinDisponible) {
	            System.out.println("Rendez-vous planifié pour " + patient.getNom() + " " + patient.getPrenom() + " le " + date + " à " + heure);
	        } else {
	            System.out.println("Le médecin n'est pas disponible.");
	        }
	    }

}
