package projetpoo;
import java.time.LocalDate;

public class Patient extends Person  {

	private DossierMedical dossierMedical;
	 private float poids;
	 private float taille;
	 public Patient(String nom,String prenom, LocalDate date_de_naissance,String lieu_de_naissance,String sexe,String address,int numeroTelephone,String groupage, float poids , float taille) {
	        super(nom,prenom,date_de_naissance,lieu_de_naissance,sexe,address, numeroTelephone, groupage);
	        setPoids(poids);
	        setTaille(taille);
	        this.dossierMedical = new DossierMedical();
	    }
	 public float getPoids() {
	        return poids;
	    }

	    public void setPoids(float poids) {
	        if (poids > 0) {
	            this.poids = poids;
	        } else {
	            throw new IllegalArgumentException("Le poids doit être un nombre positif.");
	        }
	    }

	    public float getTaille() {
	        return taille;
	    }

	    public void setTaille(float taille) {
	        if (taille > 0) {
	            this.taille = taille;
	        } else {
	            throw new IllegalArgumentException("La taille doit être un nombre positif.");
	        }
	    }
	    
	 public void ajouterObservation(String observation) {
		 dossierMedical.ajouterObservation(observation);
		}

		public void ajouterOrdonnance(String ordonnance) {
			dossierMedical.ajouterOrdonnance(ordonnance);
		}

		public void ajouterAntecedent(String antecedent) {
			dossierMedical.ajouterAntecedent(antecedent);
		}

		 public void ajouterDetailsMedical(String type, String detail) {
		        switch (type.toLowerCase()) {
		            case "maladie chronique":
		                dossierMedical.ajoutermaladie_chronique(detail);
		                break;
		            case "maladie virale":
		                dossierMedical.ajoutermaladie_virale(detail);
		                break;
		            case "complication anterieure":
		                dossierMedical.ajoutercomplication_anterieures(detail);
		                break;
		            case "analyse":
		                dossierMedical.ajouteranalyse(detail);
		                break;
		            case "radio":
		                dossierMedical.ajouterradio(detail);
		                break;
		            case "echographie":
		                dossierMedical.ajouterechographie(detail);
		                break;
		            case "scanner":
		                dossierMedical.ajouterscanner(detail);
		                break;
		            case "allergie":
		                dossierMedical.ajouterallergie(detail);
		                break;
		            case "chirurgie":
		                dossierMedical.ajouterchirurgie(detail);
		                break;
		            default:
		                throw new IllegalArgumentException("Type médical inconnu : " + type);
		        }
		    }
		 public void afficherDossier() {
		        System.out.println("\n=== Dossier Médical ===");
		        System.out.println("Nom: " + getNom());
		        System.out.println("Prénom: " + getPrenom());
		        System.out.println("DATE DE NAISSANCE: " + getDate_de_naissance());
		        System.out.println("LIEU DE NAISSANCE: " + getLieu_de_naissance());
		        System.out.println("SEXE: " + getSexe());
		        System.out.println("Poids: " + poids + " kg");
		        System.out.println("Taille: " + taille + " cm");
		        System.out.println("Groupage: " + getGroupage());
		        System.out.println("\nContenu du Dossier Médical:");
		        dossierMedical.afficherDossier();
		    }
		 public void afficherPatients() {
			 System.out.println("Nom: " + getNom());
		        System.out.println("Prénom: " + getPrenom());
		        System.out.println("DATE DE NAISSANCE: " + getDate_de_naissance());
		        System.out.println("LIEU DE NAISSANCE: " + getLieu_de_naissance());
		        System.out.println("SEXE: " + getSexe());
		        System.out.println("Poids: " + poids + " kg");
		        System.out.println("Taille: " + taille + " cm");
		        System.out.println("Groupage: " + getGroupage());
		}


}
