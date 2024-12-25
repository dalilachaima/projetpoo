package projetpoo;

import java.time.LocalDate;

public class Medecin extends Person  {
	 private String specialty;
	    private String hospital;
	    private String licenseNumber;

	    public Medecin(String nom, String prenom, LocalDate date_de_naissance, String lieu_de_naissance,
	                   String sexe, String address, int numeroTelephone, String groupage,
	                   String specialty, String hospital, String licenseNumber) {
	        super(nom, prenom, date_de_naissance, lieu_de_naissance, sexe, address, numeroTelephone, groupage);
	        this.specialty = specialty;
	        this.hospital = hospital;
	        this.licenseNumber = licenseNumber;
	    }

	    // Getters et Setters
	    public String getSpecialty() { return specialty; }
	    public void setSpecialty(String specialty) { this.specialty = specialty; }

	    public String getHospital() { return hospital; }
	    public void setHospital(String hospital) { this.hospital = hospital; }

	    public String getLicenseNumber() { return licenseNumber; }
	    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

	    // Méthode pour afficher les informations du médecin
	    public void afficherInfo() {
	        System.out.println("Nom : " + getNom());
	        System.out.println("Prénom : " + getPrenom());
	        System.out.println("Date de naissance : " + getDate_de_naissance());
	        System.out.println("Lieu de naissance : " + getLieu_de_naissance());
	        System.out.println("Sexe : " + getSexe());
	        System.out.println("Adresse : " + getAddress());
	        System.out.println("Numéro de téléphone : " + getNumeroTelephone());
	        System.out.println("Groupage sanguin : " + getGroupage());
	        System.out.println("Spécialité : " + specialty);
	        System.out.println("Hôpital : " + hospital);
	        System.out.println("Numéro de licence : " + licenseNumber);
	    }
	}
