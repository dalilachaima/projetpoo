package projetpoo;
import java.time.LocalDate;
import java.time.LocalTime;
public class RendezVous {
	  private LocalDate date;
	    private LocalTime heure;
	    private FichePatient patient;
	    private boolean medecinDisponible;

	    public RendezVous(LocalDate date, LocalTime heure, FichePatient patient2, boolean medecinDisponible) {
	        this.date = date;
	        this.heure = heure;
	        this.patient = patient2;
	        this.medecinDisponible = medecinDisponible;
	    }
	    public LocalDate getDate() { return date; }
	    public void setDate(LocalDate date) { this.date = date; }

	    public LocalTime getHeure() { return heure; }
	    public void setHeure(LocalTime heure) { this.heure = heure; }

	    public FichePatient getPatient() { return patient; }
	    public void setPatient(FichePatient patient) { this.patient = patient; }

	    public boolean isMedecinDisponible() { return medecinDisponible; }
	    public void setMedecinDisponible(boolean medecinDisponible) { this.medecinDisponible = medecinDisponible; }

	    public boolean isDateValid() {
	        return !date.isBefore(LocalDate.now()) || (date.equals(LocalDate.now()) && heure.isAfter(LocalTime.now()));
	    }

	    public void afficherRendezVous() {
	        System.out.println("Rendez-vous de " + patient.getNom() + " " + patient.getPrenom());
	        System.out.println("Date : " + date + " à " + heure);
	        System.out.println("Médecin disponible : " + medecinDisponible);
	        System.out.println("Informations du patient : ");
	        patient.afficherDossier();
	    }

	    public void modifier(LocalDate nouvelleDate, LocalTime nouvelleHeure) {
	        if (!nouvelleDate.isBefore(LocalDate.now()) || (nouvelleDate.equals(LocalDate.now()) && nouvelleHeure.isAfter(LocalTime.now()))) {
	            this.date = nouvelleDate;
	            this.heure = nouvelleHeure;
	            System.out.println("Rendez-vous modifié pour " + patient.getNom() + " " + patient.getPrenom() + " le " + date + " à " + heure);
	        } else {
	            System.out.println("Date/heure invalide.");
	        }
	    }

	    public void annuler() {
	        System.out.println("Rendez-vous annulé pour " + patient.getNom() + " " + patient.getPrenom());
	    }

	    public boolean planifier() {
	        if (medecinDisponible) {
	            System.out.println("Rendez-vous planifié pour " + patient.getNom() + " " + patient.getPrenom() + " le " + date + " à " + heure);
	            return true;
	        } else {
	            System.out.println("Le médecin n'est pas disponible.");
	            return false;
	        }
	    }
	}
