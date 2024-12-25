package projetpoo;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
public class Main {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        GestionPatients gestionPatients = new GestionPatients();
	        AgendaMedecin agendaMedecin = new AgendaMedecin();
	        GestionMedecin gestionMedecin = new GestionMedecin();
	        // Menu pour interagir avec l'utilisateur
	        while (true) {
	            System.out.println("\n=== Menu Principal ===");
	            System.out.println("1. Ajouter une fiche patient");
	            System.out.println("2. Modifier une fiche patient");
	            System.out.println("3. Supprimer une fiche patient");
	            System.out.println("4. Afficher toutes les fiches patients");
	            System.out.println("5. Ajouter un rendez-vous");
	            System.out.println("6. Afficher l'agenda des rendez-vous");
	            System.out.println("7. Ajouter un médecin");
	            System.out.println("8. Modifier un médecin");
	            System.out.println("9. Supprimer un médecin");
	            System.out.println("10. Afficher la liste des médecins");
	            System.out.println("11. Quitter");

	            int choix = Integer.parseInt(scanner.nextLine().trim());

	            switch (choix) {
	                case 1:
	                    gestionPatients.ajouter(scanner);
	                    break;
	                case 2:
	                    gestionPatients.modifier(scanner);
	                    break;
	                case 3:
	                    gestionPatients.supprimer(scanner);
	                    break;
	                case 4:
	                    gestionPatients.afficher();
	                    break;
	                case 5:
	                    System.out.print("Entrez le nom du patient pour le rendez-vous : ");
	                    String nomPatient = scanner.nextLine().trim();
	                    FichePatient patient = gestionPatients.trouverPatient(nomPatient);
	                    if (patient == null) {
	                        System.out.println("Patient introuvable.");
	                        break;
	                    }
	                    System.out.print("Entrez la date du rendez-vous (YYYY-MM-DD) : ");
	                    LocalDate date = LocalDate.parse(scanner.nextLine().trim());
	                    System.out.print("Entrez l'heure du rendez-vous (HH:MM) : ");
	                    LocalTime heure = LocalTime.parse(scanner.nextLine().trim());
	                    System.out.print("Le médecin est-il disponible ? (true/false) : ");
	                    boolean medecinDisponible = Boolean.parseBoolean(scanner.nextLine().trim());

	                    // Créer un objet RendezVous avec les paramètres appropriés
	                    RendezVous rendezVous = new RendezVous(date, heure, patient, medecinDisponible);
	                    agendaMedecin.ajouterRendezVous(rendezVous);
	                    break;
	                case 6:
	                    agendaMedecin.afficherAgenda();
	                    break;
	                case 7:
	                    System.out.print("Nom : ");
	                    String nomMedecin = scanner.nextLine().trim();
	                    System.out.print("Prénom : ");
	                    String prenomMedecin = scanner.nextLine().trim();
	                    System.out.print("Date de naissance (YYYY-MM-DD) : ");
	                    LocalDate dateNaissanceMedecin = LocalDate.parse(scanner.nextLine().trim());
	                    System.out.print("Lieu de naissance : ");
	                    String lieuNaissanceMedecin = scanner.nextLine().trim();
	                    System.out.print("Sexe : ");
	                    String sexeMedecin = scanner.nextLine().trim();
	                    System.out.print("Adresse : ");
	                    String adresseMedecin = scanner.nextLine().trim();
	                    System.out.print("Téléphone : ");
	                    int telephoneMedecin = Integer.parseInt(scanner.nextLine().trim());
	                    System.out.print("Groupage : ");
	                    String groupageMedecin = scanner.nextLine().trim();
	                    System.out.print("Spécialité : ");
	                    String specialiteMedecin = scanner.nextLine().trim();
	                    System.out.print("Hôpital : ");
	                    String hopitalMedecin = scanner.nextLine().trim();
	                    System.out.print("Numéro de licence : ");
	                    String numeroLicenseMedecin = scanner.nextLine().trim();

	                    Medecin medecin = new Medecin(nomMedecin, prenomMedecin, dateNaissanceMedecin, lieuNaissanceMedecin, sexeMedecin, adresseMedecin, telephoneMedecin, groupageMedecin, specialiteMedecin, hopitalMedecin, numeroLicenseMedecin);
	                    gestionMedecin.ajouter(medecin);
	                    System.out.println("Médecin ajouté avec succès !");
	                    break;
	                case 8:
	                    System.out.print("Entrez le nom du médecin à modifier : ");
	                    nomMedecin = scanner.nextLine().trim();
	                    medecin = gestionMedecin.trouverMedecin(nomMedecin);
	                    if (medecin == null) {
	                        System.out.println("Médecin introuvable.");
	                        break;
	                    }

	                    System.out.print("Nouveau prénom : ");
	                    medecin.setPrenom(scanner.nextLine().trim());
	                    System.out.print("Nouvelle date de naissance (YYYY-MM-DD) : ");
	                    medecin.setDate_de_naissance(LocalDate.parse(scanner.nextLine().trim()));
	                    System.out.print("Nouveau lieu de naissance : ");
	                    medecin.setLieu_de_naissance(scanner.nextLine().trim());
	                    System.out.print("Nouveau sexe : ");
	                    medecin.setSexe(scanner.nextLine().trim());
	                    System.out.print("Nouvelle adresse : ");
	                    medecin.setAddress(scanner.nextLine().trim());
	                    System.out.print("Nouveau téléphone : ");
	                    medecin.setNumeroTelephone(Integer.parseInt(scanner.nextLine().trim()));
	                    System.out.print("Nouveau groupage : ");
	                    medecin.setGroupage(scanner.nextLine().trim());
	                    System.out.print("Nouvelle spécialité : ");
	                    medecin.setSpecialty(scanner.nextLine().trim());
	                    System.out.print("Nouvel hôpital : ");
	                    medecin.setHospital(scanner.nextLine().trim());
	                    System.out.print("Nouveau numéro de licence : ");
	                    medecin.setLicenseNumber(scanner.nextLine().trim());
	                    gestionMedecin.modifier(nomMedecin, medecin);

	                    System.out.println("Médecin modifié avec succès !");
	                    break;
	                case 9:
	                    System.out.print("Entrez le nom du médecin à supprimer : ");
	                    nomMedecin = scanner.nextLine().trim();
	                    medecin = gestionMedecin.trouverMedecin(nomMedecin);
	                    if (medecin == null) {
	                        System.out.println("Médecin introuvable.");
	                        break;
	                    }
	                    gestionMedecin.supprimer(nomMedecin);
	                    System.out.println("Médecin supprimé avec succès !");
	                    break;
	                case 10:
	                    System.out.println("Liste des médecins :");
	                    for (Medecin m : gestionMedecin.getMedecins()) {
	                        m.afficherInfo();
	                    }
	                    break;
	                case 11:
	                    System.out.println("Au revoir !");
	                    scanner.close();
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Choix invalide. Veuillez réessayer.");
	            }
	        }
	    }
	}
