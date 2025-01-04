package projetpoo;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionPatients gestionPatients = new GestionPatients();
        AgendaMedecin agendaMedecin = new AgendaMedecin();

        while (true) {
            afficherMenu();
            int choix = obtenirChoixUtilisateur(scanner);

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
                    ajouterRendezVous(scanner, gestionPatients, agendaMedecin);
                    break;
                case 6:
                    agendaMedecin.afficherAgenda();
                    break;
                case 7:
                    ajouterMedecin(scanner);
                    break;
                case 8:
                    modifierMedecin(scanner);
                    break;
                case 9:
                    supprimerMedecin(scanner);
                    break;
                case 10:
                    afficherListeMedecins();
                    break;
                case 11:
                    quitterApplication(scanner);
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void afficherMenu() {
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
    }

    private static int obtenirChoixUtilisateur(Scanner scanner) {
        try {
            System.out.print("Entrez votre choix : ");
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Choix invalide. Veuillez entrer un nombre.");
            return -1;
        }
    }

    private static void ajouterRendezVous(Scanner scanner, GestionPatients gestionPatients, AgendaMedecin agendaMedecin) {
        System.out.print("Entrez le nom du patient pour le rendez-vous : ");
        String nomPatient = scanner.nextLine().trim();
        FichePatient patient = gestionPatients.trouverPatient(nomPatient);
        if (patient == null) {
            System.out.println("Patient introuvable.");
            return;
        }

        LocalDate date = lireDate(scanner, "Entrez la date du rendez-vous (YYYY-MM-DD) : ");
        LocalTime heure = lireHeure(scanner, "Entrez l'heure du rendez-vous (HH:MM) : ");

        System.out.print("Le médecin est-il disponible ? (true/false) : ");
        boolean medecinDisponible = Boolean.parseBoolean(scanner.nextLine().trim());

        RendezVous rendezVous = new RendezVous(date, heure, patient, medecinDisponible);
        agendaMedecin.ajouterRendezVous(rendezVous);
    }

    private static void ajouterMedecin(Scanner scanner) {
        try {
            Medecin medecin = lireMedecin(scanner);
            GestionMedecin.ajouter(medecin);
            System.out.println("Médecin ajouté avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du médecin : " + e.getMessage());
        }
    }

    private static void modifierMedecin(Scanner scanner) {
        System.out.print("Entrez le nom du médecin à modifier : ");
        String nomMedecin = scanner.nextLine().trim();
        Medecin medecin = GestionMedecin.trouverMedecin(nomMedecin);
        if (medecin == null) {
            System.out.println("Médecin introuvable.");
            return;
        }

        try {
            Medecin medecinModifie = lireMedecin(scanner);
            GestionMedecin.modifier(nomMedecin, medecinModifie);
            System.out.println("Médecin modifié avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur lors de la modification du médecin : " + e.getMessage());
        }
    }

    private static void supprimerMedecin(Scanner scanner) {
        System.out.print("Entrez le nom du médecin à supprimer : ");
        String nomMedecin = scanner.nextLine().trim();
        Medecin medecin = GestionMedecin.trouverMedecin(nomMedecin);
        if (medecin == null) {
            System.out.println("Médecin introuvable.");
            return;
        }

        System.out.print("Êtes-vous sûr de vouloir supprimer ce médecin ? (oui/non) : ");
        String confirmation = scanner.nextLine().trim();
        if (confirmation.equalsIgnoreCase("oui")) {
            GestionMedecin.supprimer(nomMedecin);
            System.out.println("Médecin supprimé avec succès !");
        } else {
            System.out.println("Suppression annulée.");
        }
    }

    private static void afficherListeMedecins() {
        System.out.println("Liste des médecins :");
        for (Medecin medecin : GestionMedecin.getMedecins().values()) {
            medecin.afficherInfo();
        }
    }

    private static LocalDate lireDate(Scanner scanner, String message) {
        LocalDate date = null;
        while (date == null) {
            try {
                System.out.print(message);
                date = LocalDate.parse(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Format de date invalide. Veuillez réessayer.");
            }
        }
        return date;
    }

    private static LocalTime lireHeure(Scanner scanner, String message) {
        LocalTime heure = null;
        while (heure == null) {
            try {
                System.out.print(message);
                heure = LocalTime.parse(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Format d'heure invalide. Veuillez réessayer.");
            }
        }
        return heure;
    }

    private static Medecin lireMedecin(Scanner scanner) {
        System.out.print("Nom : ");
        String nomMedecin = scanner.nextLine().trim();
        System.out.print("Prénom : ");
        String prenomMedecin = scanner.nextLine().trim();
        LocalDate dateNaissanceMedecin = lireDate(scanner, "Date de naissance (YYYY-MM-DD) : ");
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

        return new Medecin(nomMedecin, prenomMedecin, dateNaissanceMedecin, lieuNaissanceMedecin, sexeMedecin, adresseMedecin, telephoneMedecin, groupageMedecin, specialiteMedecin, hopitalMedecin, numeroLicenseMedecin);
    }

    private static void quitterApplication(Scanner scanner) {
        System.out.println("Au revoir !");
        scanner.close();
    }
}
