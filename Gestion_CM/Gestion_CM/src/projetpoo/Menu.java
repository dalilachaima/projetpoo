package projetpoo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel lblWelcome, welcomeImage;
    private Map<String, Patient> patients; // Simuler une base de données de patients
    private Map<String, RendezVous> rendezVousMap; // Simuler une base de données de rendez-vous
    private Map<String, Ordonnance> ordonnances; // Simuler une base de données d'ordonnances
    private Map<String, Medicament> medicaments; // Simuler une base de données de médicaments
    private Map<String, Paiement> paiements; // Simuler une base de données de paiements

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Menu window = new Menu();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Menu() {
        patients = new HashMap<>();
        rendezVousMap = new HashMap<>();
        ordonnances = new HashMap<>();
        medicaments = new HashMap<>();
        paiements = new HashMap<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Cabinet Médical");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        mainPanel = new BackgroundPanel("C:\\Users\\GLOBAL INFO LAGA\\Pictures\\Screenshots\\x.jpg");
        mainPanel.setBorder(new LineBorder(new Color(128, 128, 255), 4));
        mainPanel.setBounds(170, 50, 604, 500);
        frame.getContentPane().add(mainPanel);
        mainPanel.setLayout(null);

        lblWelcome = new JLabel("Bienvenue à votre cabinet médical");
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
        lblWelcome.setForeground(Color.BLACK);
        lblWelcome.setBounds(10, 11, 584, 60);
        mainPanel.add(lblWelcome);

        welcomeImage = new JLabel(new ImageIcon("C:\\Users\\GLOBAL INFO LAGA\\Pictures\\Screenshots\\welcome_image.jpg"));
        welcomeImage.setBounds(200, 100, 200, 200);
        mainPanel.add(welcomeImage);

        JPanel panel = new BackgroundPanel("https://i.pinimg.com/736x/31/27/02/31270202a6520c7b2b716343324e7b39.jpg");
        panel.setBorder(new LineBorder(new Color(128, 128, 255), 4));
        panel.setBounds(10, 0, 764, 50);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Cabinet Médical");
        lblNewLabel.setForeground(new Color(0, 0, 128));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 26));
        lblNewLabel.setBounds(10, 10, 744, 30);
        panel.add(lblNewLabel);

        JPanel sidebar = new JPanel();
        sidebar.setBorder(new LineBorder(new Color(128, 128, 255), 4));
        sidebar.setBounds(10, 60, 150, 500);
        sidebar.setBackground(new Color(240, 255, 255));
        frame.getContentPane().add(sidebar);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        String[] buttons = {"Fiche Patient", "Rendez-vous", "Médecins", "Médicaments", "Ordonnances", "Paiements", "Aide"};
        for (String text : buttons) {
            JButton button = createSidebarButton(text);
            sidebar.add(button);
            button.addActionListener(e -> handleButtonAction(e.getActionCommand()));
        }

        showHomeScreen();
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(140, 30));
        button.setBackground(new Color(135, 206, 250));
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        button.setFocusPainted(false);
        button.addMouseListener(new ButtonMouseListener(button, button.getBackground()));
        return button;
    }

    private class ButtonMouseListener extends MouseAdapter {
        private JButton button;
        private Color baseColor;

        public ButtonMouseListener(JButton button, Color baseColor) {
            this.button = button;
            this.baseColor = baseColor;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            button.setBackground(button.getBackground().darker());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            button.setBackground(baseColor);
        }
    }

    private void handleButtonAction(String actionCommand) {
        switch (actionCommand) {
            case "Fiche Patient":
                showPatientOptionsDialog();
                break;
            case "Rendez-vous":
                showRendezVousOptionsDialog();
                break;
            case "Médecins":
                showMedecinOptionsDialog();
                break;
            case "Médicaments":
                showMedicamentOptionsDialog();
                break;
            case "Ordonnances":
                showOrdonnanceOptionsDialog();
                break;
            case "Paiements":
                showPaiementOptionsDialog();
               
            case "Aide":
            	showAideSupportDialog();
                break;
            default:
                lblWelcome.setText("Bienvenue à votre cabinet médical");
                break;
        }
    }

    private void showAideSupportDialog() {
    	JTextArea textArea = new JTextArea();
    	textArea.setText("=== AIDE ET SUPPORT ===\n\n" + "Bienvenue dans la section Aide et Support!\n\n" + "Pour toute assistance, veuillez contacter notre support technique.\n\n" + "Email:CabinetMedical@gmail.com\n" + "Téléphone: +213 123456789\n\n"); 
    	textArea.setFont(new Font("Arial", Font.PLAIN, 14));
    	textArea.setEditable(false); 
    JOptionPane.showMessageDialog(frame, textArea, "Aide et Support", JOptionPane.INFORMATION_MESSAGE); }

    private void showHomeScreen() {
        lblWelcome.setText("Bienvenue à votre cabinet médical");
        welcomeImage.setVisible(true);
    }
    
    

    private void showPatientOptionsDialog() {
        String[] options = {"Ajouter Patient", "Modifier Patient", "Supprimer Patient", "Voir Patients"};
        int choice = JOptionPane.showOptionDialog(null, "Choisissez une option", "Patients",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                showAddPatientDialog();
                break;
            case 1:
                showEditPatientDialog();
                break;
            case 2:
                showDeletePatientDialog();
                break;
            case 3:
                showViewPatientsDialog();
                break;
        }
    }

    private void showAddPatientDialog() {
        JTextField nomField = new JTextField();
        JTextField prenomField = new JTextField();
        JTextField adresseField = new JTextField();
        JTextField telephoneField = new JTextField();
        JTextField dateNaissanceField = new JTextField();
        JTextField sexeField = new JTextField();
        JTextField lieuNaissanceField = new JTextField();
        JTextField groupageField = new JTextField();
        JTextField poidsField = new JTextField();
        JTextField tailleField = new JTextField();

        Object[] message = {
            "Nom:", nomField,
            "Prénom:", prenomField,
            "Adresse:", adresseField,
            "Téléphone:", telephoneField,
            "Date de naissance (YYYY-MM-DD):", dateNaissanceField,
            "Lieu de Naissance:", lieuNaissanceField,
            "Sexe (H/F):", sexeField,
            "Groupage:", groupageField,
            "Poids:", poidsField,
            "Taille:", tailleField,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Ajouter Patient", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String nom = nomField.getText().trim();
                String prenom = prenomField.getText().trim();
                String adresse = adresseField.getText().trim();
                int telephone = Integer.parseInt(telephoneField.getText().trim());
                LocalDate dateNaissance = LocalDate.parse(dateNaissanceField.getText().trim());
                String sexe = sexeField.getText().trim().toUpperCase();
                String lieuNaissance = lieuNaissanceField.getText().trim();
                String groupage = groupageField.getText().trim();
                double poids = Double.parseDouble(poidsField.getText().trim());
                double taille = Double.parseDouble(tailleField.getText().trim());

                if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || sexe.isEmpty()) {
                    throw new IllegalArgumentException("Tous les champs obligatoires doivent être remplis.");
                }

                patients.put(nom, new Patient(nom, prenom, adresse, telephone, dateNaissance, sexe, lieuNaissance, groupage, poids, taille));

                JOptionPane.showMessageDialog(null, "Patient ajouté :\nNom: " + nom + "\nPrénom: " + prenom + "\nAdresse: " + adresse + "\nTéléphone: " + telephone + "\nDate de Naissance: " + dateNaissance + "\nSexe: " + sexe);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showEditPatientDialog() {
        JTextField nomField = new JTextField();
        Object[] message = {
            "Entrez le nom du patient à modifier:", nomField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Modifier Patient", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nom = nomField.getText().trim();
            Patient patient = patients.get(nom);
            if (patient == null) {
                JOptionPane.showMessageDialog(null, "Erreur: Patient introuvable.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JTextField prenomField = new JTextField(patient.getPrenom());
            JTextField adresseField = new JTextField(patient.getAdresse());
            JTextField telephoneField = new JTextField(String.valueOf(patient.getTelephone()));
            JTextField dateNaissanceField = new JTextField(patient.getDateNaissance().toString());
            JTextField sexeField = new JTextField(patient.getSexe());
            JTextField lieuNaissanceField = new JTextField(patient.getLieuNaissance());
            JTextField groupageField = new JTextField(patient.getGroupage());
            JTextField poidsField = new JTextField(String.valueOf(patient.getPoids()));
            JTextField tailleField = new JTextField(String.valueOf(patient.getTaille()));

            Object[] modifyMessage = {
                "Prénom:", prenomField,
                "Adresse:", adresseField,
                "Téléphone:", telephoneField,
                "Date de naissance (YYYY-MM-DD):", dateNaissanceField,
                "Lieu de Naissance:", lieuNaissanceField,
                "Sexe (H/F):", sexeField,
                "Groupage:", groupageField,
                "Poids:", poidsField,
                "Taille:", tailleField,
            };

            int modifyOption = JOptionPane.showConfirmDialog(null, modifyMessage, "Modifier Patient", JOptionPane.OK_CANCEL_OPTION);
            if (modifyOption == JOptionPane.OK_OPTION) {
                try {
                    String prenom = prenomField.getText().trim();
                    String adresse = adresseField.getText().trim();
                    int telephone = Integer.parseInt(telephoneField.getText().trim());
                    LocalDate dateNaissance = LocalDate.parse(dateNaissanceField.getText().trim());
                    String sexe = sexeField.getText().trim().toUpperCase();
                    String lieuNaissance = lieuNaissanceField.getText().trim();
                    String groupage = groupageField.getText().trim();
                    double poids = Double.parseDouble(poidsField.getText().trim());
                    double taille = Double.parseDouble(tailleField.getText().trim());

                    patient.setPrenom(prenom);
                    patient.setAdresse(adresse);
                    patient.setTelephone(telephone);
                    patient.setDateNaissance(dateNaissance);
                    patient.setSexe(sexe);
                    patient.setLieuNaissance(lieuNaissance);
                    patient.setGroupage(groupage);
                    patient.setPoids(poids);
                    patient.setTaille(taille);

                    JOptionPane.showMessageDialog(null, "Patient modifié :\nNom: " + nom + "\nPrénom: " + prenom + "\nAdresse: " + adresse + "\nTéléphone: " + telephone + "\nDate de Naissance: " + dateNaissance + "\nSexe: " + sexe);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void showDeletePatientDialog() {
        JTextField nomField = new JTextField();
        Object[] message = {
            "Entrez le nom du patient à supprimer:", nomField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Supprimer Patient", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nom = nomField.getText().trim();
            Patient patient = patients.get(nom);
            if (patient == null) {
                JOptionPane.showMessageDialog(null, "Erreur: Patient introuvable.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer le patient " + nom + "?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                patients.remove(nom);
                JOptionPane.showMessageDialog(null, "Patient supprimé : " + nom);
            }
        }
    }

    private void showViewPatientsDialog() {
        String[] columnNames = {"Nom", "Prénom", "Adresse", "Téléphone", "Date de Naissance", "Sexe"};
        Object[][] data = new Object[patients.size()][6];
        int i = 0;
        for (Patient patient : patients.values()) {
            data[i][0] = patient.getNom();
            data[i][1] = patient.getPrenom();
            data[i][2] = patient.getAdresse();
            data[i][3] = patient.getTelephone();
            data[i][4] = patient.getDateNaissance();
            data[i][5] = patient.getSexe();
            i++;
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Liste des Patients");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().add(scrollPane);
        frame.setVisible(true);
    }

    private void showRendezVousOptionsDialog() {
        String[] options = {"Ajouter Rendez-vous", "Voir Rendez-vous"};
        int choice = JOptionPane.showOptionDialog(null, "Choisissez une option", "Rendez-vous",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            showAddRendezVousDialog();
        } else if (choice == 1) {
            showViewRendezVousDialog();
        }
    }

    private void showAddRendezVousDialog() {
        JTextField dateField = new JTextField();
        JTextField heureField = new JTextField();
        JTextField nomPatientField = new JTextField();
        JTextField medecinDispoField = new JTextField();

        Object[] message = {
            "Date (YYYY-MM-DD):", dateField,
            "Heure (HH:MM):", heureField,
            "Nom du Patient:", nomPatientField,
            "Médecin Disponible (true/false):", medecinDispoField,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Ajouter Rendez-vous", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                LocalDate date = LocalDate.parse(dateField.getText().trim());
                LocalTime heure = LocalTime.parse(heureField.getText().trim());
                String nomPatient = nomPatientField.getText().trim();
                boolean medecinDispo = Boolean.parseBoolean(medecinDispoField.getText().trim());

                Patient patient = patients.get(nomPatient);
                if (patient == null) {
                    throw new IllegalArgumentException("Patient introuvable.");
                }

                RendezVous rendezVous = new RendezVous(date, heure, patient, medecinDispo);
                rendezVousMap.put(nomPatient + date.toString() + heure.toString(), rendezVous);

                JOptionPane.showMessageDialog(null, "Rendez-vous ajouté :\nDate: " + date + "\nHeure: " + heure + "\nNom du Patient: " + nomPatient + "\nMédecin Disponible: " + medecinDispo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showViewRendezVousDialog() {
        String[] columnNames = {"Date", "Heure", "Patient", "Médecin Disponible"};
        Object[][] data = new Object[rendezVousMap.size()][4];
        int i = 0;
        for (RendezVous rdv : rendezVousMap.values()) {
            data[i][0] = rdv.getDate();
            data[i][1] = rdv.getHeure();
            data[i][2] = rdv.getPatient().getNom() + " " + rdv.getPatient().getPrenom();
            data[i][3] = rdv.isMedecinDispo();
            i++;
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Liste des Rendez-vous");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().add(scrollPane);
        frame.setVisible(true);
    }

    private void showMedecinOptionsDialog() {
        String[] options = {"Ajouter Médecin", "Modifier Médecin", "Supprimer Médecin", "Voir Médecins"};
        int choice = JOptionPane.showOptionDialog(null, "Choisissez une option", "Médecins",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                showAddMedecinDialog();
                break;
            case 1:
                showEditMedecinDialog();
                break;
            case 2:
                showDeleteMedecinDialog();
                break;
            case 3:
                showViewMedecinsDialog();
                break;
        }
    }

    private void showAddMedecinDialog() {
        JTextField nomField = new JTextField();
        JTextField prenomField = new JTextField();
        JTextField dateNaissanceField = new JTextField();
        JTextField lieuNaissanceField = new JTextField();
        JTextField sexeField = new JTextField();
        JTextField adresseField = new JTextField();
        JTextField telephoneField = new JTextField();
        JTextField groupageField = new JTextField();
        JTextField specialiteField = new JTextField();
        JTextField hopitalField = new JTextField();
        JTextField numeroLicenseField = new JTextField();

        Object[] message = {
            "Nom:", nomField,
            "Prénom:", prenomField,
            "Date de Naissance (YYYY-MM-DD):", dateNaissanceField,
            "Lieu de Naissance:", lieuNaissanceField,
            "Sexe:", sexeField,
            "Adresse:", adresseField,
            "Téléphone:", telephoneField,
            "Groupage:", groupageField,
            "Spécialité:", specialiteField,
            "Hôpital:", hopitalField,
            "Numéro de License:", numeroLicenseField,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Ajouter Médecin", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String nom = nomField.getText().trim();
                String prenom = prenomField.getText().trim();
                LocalDate dateNaissance = LocalDate.parse(dateNaissanceField.getText().trim());
                String lieuNaissance = lieuNaissanceField.getText().trim();
                String sexe = sexeField.getText().trim().toUpperCase();
                String adresse = adresseField.getText().trim();
                int telephone = Integer.parseInt(telephoneField.getText().trim());
                String groupage = groupageField.getText().trim();
                String specialite = specialiteField.getText().trim();
                String hopital = hopitalField.getText().trim();
                String numeroLicense = numeroLicenseField.getText().trim();

                projetpoo.Medecin medecin = new projetpoo.Medecin(nom, prenom, dateNaissance, lieuNaissance, sexe, adresse, telephone, groupage, specialite, hopital, numeroLicense);
                GestionMedecin.ajouter(medecin);
                JOptionPane.showMessageDialog(null, "Médecin ajouté :\nNom: " + nom + "\nPrénom: " + prenom + "\nDate de Naissance: " + dateNaissance + "\nLieu de Naissance: " + lieuNaissance + "\nSexe: " + sexe + "\nAdresse: " + adresse + "\nTéléphone: " + telephone + "\nGroupage: " + groupage + "\nSpécialité: " + specialite + "\nHôpital: " + hopital + "\nNuméro de License: " + numeroLicense);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showEditMedecinDialog() {
        JTextField nomField = new JTextField();
        Object[] message = {
            "Entrez le nom du médecin à modifier:", nomField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Modifier Médecin", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nom = nomField.getText().trim();
            projetpoo.Medecin medecin = GestionMedecin.trouverMedecin(nom);
            if (medecin == null) {
                JOptionPane.showMessageDialog(null, "Erreur: Médecin introuvable.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JTextField prenomField = new JTextField(medecin.getPrenom());
            JTextField dateNaissanceField = new JTextField(medecin.getDate_de_naissance().toString());
            JTextField lieuNaissanceField = new JTextField(medecin.getLieu_de_naissance());
            JTextField sexeField = new JTextField(medecin.getSexe());
            JTextField adresseField = new JTextField(medecin.getAddress());
            JTextField telephoneField = new JTextField(String.valueOf(medecin.getNumeroTelephone()));
            JTextField groupageField = new JTextField(medecin.getGroupage());
            JTextField specialiteField = new JTextField(medecin.getSpecialty());
            JTextField hopitalField = new JTextField(medecin.getHospital());
            JTextField numeroLicenseField = new JTextField(medecin.getLicenseNumber());

            Object[] modifyMessage = {
                "Prénom:", prenomField,
                "Date de Naissance (YYYY-MM-DD):", dateNaissanceField,
                "Lieu de Naissance:", lieuNaissanceField,
                "Sexe:", sexeField,
                "Adresse:", adresseField,
                "Téléphone:", telephoneField,
                "Groupage:", groupageField,
                "Spécialité:", specialiteField,
                "Hôpital:", hopitalField,
                "Numéro de License:", numeroLicenseField,
            };

            int modifyOption = JOptionPane.showConfirmDialog(null, modifyMessage, "Modifier Médecin", JOptionPane.OK_CANCEL_OPTION);
            if (modifyOption == JOptionPane.OK_OPTION) {
                try {
                    String prenom = prenomField.getText().trim();
                    LocalDate dateNaissance = LocalDate.parse(dateNaissanceField.getText().trim());
                    String lieuNaissance = lieuNaissanceField.getText().trim();
                    String sexe = sexeField.getText().trim().toUpperCase();
                    String adresse = adresseField.getText().trim();
                    int telephone = Integer.parseInt(telephoneField.getText().trim());
                    String groupage = groupageField.getText().trim();
                    String specialite = specialiteField.getText().trim();
                    String hopital = hopitalField.getText().trim();
                    String numeroLicense = numeroLicenseField.getText().trim();

                    medecin.setPrenom(prenom);
                    medecin.setDate_de_naissance(dateNaissance);
                    medecin.setLieu_de_naissance(lieuNaissance);
                    medecin.setSexe(sexe);
                    medecin.setAddress(adresse);
                    medecin.setNumeroTelephone(telephone);
                    medecin.setGroupage(groupage);
                    medecin.setSpecialty(specialite);
                    medecin.setHospital(hopital);
                    medecin.setLicenseNumber(numeroLicense);

                    GestionMedecin.modifier(nom, medecin);
                    JOptionPane.showMessageDialog(null, "Médecin modifié :\nNom: " + nom + "\nPrénom: " + prenom + "\nDate de Naissance: " + dateNaissance + "\nLieu de Naissance: " + lieuNaissance + "\nSexe: " + sexe + "\nAdresse: " + adresse + "\nTéléphone: " + telephone + "\nGroupage: " + groupage + "\nSpécialité: " + specialite + "\nHôpital: " + hopital + "\nNuméro de License: " + numeroLicense);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void showDeleteMedecinDialog() {
        JTextField nomField = new JTextField();
        Object[] message = {
            "Entrez le nom du médecin à supprimer:", nomField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Supprimer Médecin", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nom = nomField.getText().trim();
            projetpoo.Medecin medecin = GestionMedecin.trouverMedecin(nom);
            if (medecin == null) {
                JOptionPane.showMessageDialog(null, "Erreur: Médecin introuvable.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer le médecin " + nom + "?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                GestionMedecin.supprimer(nom);
                JOptionPane.showMessageDialog(null, "Médecin supprimé : " + nom);
            }
        }
    }

    private void showViewMedecinsDialog() {
        String[] columnNames = {"Nom", "Prénom", "Date de Naissance", "Lieu de Naissance", "Sexe", "Adresse", "Téléphone", "Groupage", "Spécialité", "Hôpital", "Numéro de License"};
        Object[][] data = new Object[GestionMedecin.getMedecins().size()][11];
        int i = 0;
        for (projetpoo.Medecin medecin : GestionMedecin.getMedecins().values()) {
            data[i][0] = medecin.getNom();
            data[i][1] = medecin.getPrenom();
            data[i][2] = medecin.getDate_de_naissance();
            data[i][3] = medecin.getLieu_de_naissance();
            data[i][4] = medecin.getSexe();
            data[i][5] = medecin.getAddress();
            data[i][6] = medecin.getNumeroTelephone();
            data[i][7] = medecin.getGroupage();
            data[i][8] = medecin.getSpecialty();
            data[i][9] = medecin.getHospital();
            data[i][10] = medecin.getLicenseNumber();
            i++;
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Liste des Médecins");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().add(scrollPane);
        frame.setVisible(true);
    }

    private void showMedicamentOptionsDialog() {
        String[] options = {"Ajouter Médicament", "Voir Médicaments"};
        int choice = JOptionPane.showOptionDialog(null, "Choisissez une option", "Médicaments",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            showAddMedicamentDialog();
        } else if (choice == 1) {
            showViewMedicamentDialog();
        }
    }

    private void showAddMedicamentDialog() {
        JTextField nomField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField prixField = new JTextField();

        Object[] message = {
            "Nom:", nomField,
            "Description:", descriptionField,
            "Prix:", prixField,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Ajouter Médicament", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String nom = nomField.getText().trim();
                String description = descriptionField.getText().trim();
                double prix = Double.parseDouble(prixField.getText().trim());

                if (prix < 0) {
                    throw new IllegalArgumentException("Le prix ne peut pas être négatif.");
                }

                medicaments.put(nom, new Medicament(nom, description, prix));
                JOptionPane.showMessageDialog(null, "Médicament ajouté :\nNom: " + nom + "\nDescription: " + description + "\nPrix: " + prix);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erreur: Le prix doit être un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showViewMedicamentDialog() {
        String[] columnNames = {"Nom", "Description", "Prix"};
        Object[][] data = new Object[medicaments.size()][3];
        int i = 0;
        for (Medicament medicament : medicaments.values()) {
            data[i][0] = medicament.getNom();
            data[i][1] = medicament.getDescription();
            data[i][2] = medicament.getPrix();
            i++;
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Liste des Médicaments");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().add(scrollPane);
        frame.setVisible(true);
    }

    private void showOrdonnanceOptionsDialog() {
        String[] options = {"Ajouter Ordonnance", "Voir Ordonnances"};
        int choice = JOptionPane.showOptionDialog(null, "Choisissez une option", "Ordonnances",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            showAddOrdonnanceDialog();
        } else if (choice == 1) {
            showViewOrdonnancesDialog();
        }
    }

    private void showAddOrdonnanceDialog() {
        JTextField nomPatientField = new JTextField();
        JTextField medicamentField = new JTextField();
        JTextField dosageField = new JTextField();
        JTextField dureeField = new JTextField();

        Object[] message = {
            "Nom du Patient:", nomPatientField,
            "Médicament:", medicamentField,
            "Dosage:", dosageField,
            "Durée:", dureeField,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Ajouter Ordonnance", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String nomPatient = nomPatientField.getText().trim();
                String medicament = medicamentField.getText().trim();
                String dosage = dosageField.getText().trim();
                String duree = dureeField.getText().trim();

                Patient patient = patients.get(nomPatient);
                if (patient == null) {
                    throw new IllegalArgumentException("Patient introuvable.");
                }

                Ordonnance ordonnance = new Ordonnance(patient, medicament, dosage, duree);
                ordonnances.put(nomPatient + medicament, ordonnance);

                JOptionPane.showMessageDialog(null, "Ordonnance ajoutée :\nPatient: " + nomPatient + "\nMédicament: " + medicament + "\nDosage: " + dosage + "\nDurée: " + duree);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showViewOrdonnancesDialog() {
        String[] columnNames = {"Patient", "Médicament", "Dosage", "Durée"};
        Object[][] data = new Object[ordonnances.size()][4];
        int i = 0;
        for (Ordonnance ordonnance : ordonnances.values()) {
            data[i][0] = ordonnance.getPatient().getNom() + " " + ordonnance.getPatient().getPrenom();
            data[i][1] = ordonnance.getMedicament();
            data[i][2] = ordonnance.getDosage();
            data[i][3] = ordonnance.getDuree();
            i++;
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Liste des Ordonnances");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().add(scrollPane);
        frame.setVisible(true);
    }

    private void showPaiementOptionsDialog() {
        String[] options = {"Ajouter Paiement", "Voir Paiements"};
        int choice = JOptionPane.showOptionDialog(null, "Choisissez une option", "Paiements",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            showAddPaiementDialog();
        } else if (choice == 1) {
            showViewPaiementsDialog();
        }
    }

    private void showAddPaiementDialog() {
        JTextField nomPatientField = new JTextField();
        JTextField montantField = new JTextField();
        JTextField dateField = new JTextField();

        Object[] message = {
            "Nom du Patient:", nomPatientField,
            "Montant:", montantField,
            "Date (YYYY-MM-DD):", dateField,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Ajouter Paiement", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String nomPatient = nomPatientField.getText().trim();
                double montant = Double.parseDouble(montantField.getText().trim());
                LocalDate date = LocalDate.parse(dateField.getText().trim());

                if (montant < 0) {
                    throw new IllegalArgumentException("Le montant ne peut pas être négatif.");
                }

                Patient patient = patients.get(nomPatient);
                if (patient == null) {
                    throw new IllegalArgumentException("Patient introuvable.");
                }

                Paiement paiement = new Paiement(patient, montant, date);
                paiements.put(nomPatient + date.toString(), paiement);

                JOptionPane.showMessageDialog(null, "Paiement ajouté :\nPatient: " + nomPatient + "\nMontant: " + montant + "\nDate: " + date);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erreur: Le montant doit être un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showViewPaiementsDialog() {
        String[] columnNames = {"Patient", "Montant", "Date"};
        Object[][] data = new Object[paiements.size()][3];
        int i = 0;
        for (Paiement paiement : paiements.values()) {
            data[i][0] = paiement.getPatient().getNom() + " " + paiement.getPatient().getPrenom();
            data[i][1] = paiement.getMontant();
            data[i][2] = paiement.getDate();
            i++;
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Liste des Paiements");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().add(scrollPane);
        frame.setVisible(true);
    }

    // Définir les classes internes pour Patient, RendezVous, Medecin, Ordonnance, Medicament et Paiement

    class Patient {
        private String nom;
        private String prenom;
        private String adresse;
        private int telephone;
        private LocalDate dateNaissance;
        private String sexe;
        private String lieuNaissance;
        private String groupage;
        private double poids;
        private double taille;

        public Patient(String nom, String prenom, String adresse, int telephone, LocalDate dateNaissance, String sexe, String lieuNaissance, String groupage, double poids, double taille) {
            this.nom = nom;
            this.prenom = prenom;
            this.adresse = adresse;
            this.telephone = telephone;
            this.dateNaissance = dateNaissance;
            this.sexe = sexe;
            this.lieuNaissance = lieuNaissance;
            this.groupage = groupage;
            this.poids = poids;
            this.taille = taille;
        }

        public String getNom() { return nom; }
        public String getPrenom() { return prenom; }
        public String getAdresse() { return adresse; }
        public int getTelephone() { return telephone; }
        public LocalDate getDateNaissance() { return dateNaissance; }
        public String getSexe() { return sexe; }
        public String getLieuNaissance() { return lieuNaissance; }
        public String getGroupage() { return groupage; }
        public double getPoids() { return poids; }
        public double getTaille() { return taille; }

        public void setPrenom(String prenom) { this.prenom = prenom; }
        public void setAdresse(String adresse) { this.adresse = adresse; }
        public void setTelephone(int telephone) { this.telephone = telephone; }
        public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }
        public void setSexe(String sexe) { this.sexe = sexe; }
        public void setLieuNaissance(String lieuNaissance) { this.lieuNaissance = lieuNaissance; }
        public void setGroupage(String groupage) { this.groupage = groupage; }
        public void setPoids(double poids) { this.poids = poids; }
        public void setTaille(double taille) { this.taille = taille; }
    }

    class RendezVous {
        private LocalDate date;
        private LocalTime heure;
        private Patient patient;
        private boolean medecinDispo;

        public RendezVous(LocalDate date, LocalTime heure, Patient patient, boolean medecinDispo) {
            this.date = date;
            this.heure = heure;
            this.patient = patient;
            this.medecinDispo = medecinDispo;
        }

        public LocalDate getDate() { return date; }
        public LocalTime getHeure() { return heure; }
        public Patient getPatient() { return patient; }
        public boolean isMedecinDispo() { return medecinDispo; }
    }

    class Medecin {
        private String nom;
        private String prenom;
        private LocalDate dateNaissance;
        private String lieuNaissance;
        private String sexe;
        private String adresse;
        private int telephone;
        private String groupage;
        private String specialite;
        private String hopital;
        private String numeroLicense;

        public Medecin(String nom, String prenom, LocalDate dateNaissance, String lieuNaissance, String sexe, String adresse, int telephone, String groupage, String specialite, String hopital, String numeroLicense) {
            this.nom = nom;
            this.prenom = prenom;
            this.dateNaissance = dateNaissance;
            this.lieuNaissance = lieuNaissance;
            this.sexe = sexe;
            this.adresse = adresse;
            this.telephone = telephone;
            this.groupage = groupage;
            this.specialite = specialite;
            this.hopital = hopital;
            this.numeroLicense = numeroLicense;
        }

        public String getNom() { return nom; }
        public String getPrenom() { return prenom; }
        public LocalDate getDate_de_naissance() { return dateNaissance; }
        public String getLieu_de_naissance() { return lieuNaissance; }
        public String getSexe() { return sexe; }
        public String getAddress() { return adresse; }
        public int getNumeroTelephone() { return telephone; }
        public String getGroupage() { return groupage; }
        public String getSpecialty() { return specialite; }
        public String getHospital() { return hopital; }
        public String getLicenseNumber() { return numeroLicense; }

        public void setPrenom(String prenom) { this.prenom = prenom; }
        public void setDate_de_naissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }
        public void setLieu_de_naissance(String lieuNaissance) { this.lieuNaissance = lieuNaissance; }
        public void setSexe(String sexe) { this.sexe = sexe; }
        public void setAddress(String adresse) { this.adresse = adresse; }
        public void setNumeroTelephone(int telephone) { this.telephone = telephone; }
        public void setGroupage(String groupage) { this.groupage = groupage; }
        public void setSpecialty(String specialite) { this.specialite = specialite; }
        public void setHospital(String hopital) { this.hopital = hopital; }
        public void setLicenseNumber(String numeroLicense) { this.numeroLicense = numeroLicense; }

        public void afficherInfo() {
            System.out.println("Nom : " + getNom());
            System.out.println("Prénom : " + getPrenom());
            System.out.println("Date de naissance : " + getDate_de_naissance());
            System.out.println("Lieu de naissance : " + getLieu_de_naissance());
            System.out.println("Sexe : " + getSexe());
            System.out.println("Adresse : " + getAddress());
            System.out.println("Numéro de téléphone : " + getNumeroTelephone());
            System.out.println("Groupage sanguin : " + getGroupage());
            System.out.println("Spécialité : " + getSpecialty());
            System.out.println("Hôpital : " + getHospital());
            System.out.println("Numéro de licence : " + getLicenseNumber());
            System.out.println("------------------------------------------");
        }


		


    }

    class Ordonnance {
        private Patient patient;
        private String medicament;
        private String dosage;
        private String duree;

        public Ordonnance(Patient patient, String medicament, String dosage, String duree) {
            this.patient = patient;
            this.medicament = medicament;
            this.dosage = dosage;
            this.duree = duree;
        }

        public Patient getPatient() { return patient; }
        public String getMedicament() { return medicament; }
        public String getDosage() { return dosage; }
        public String getDuree() { return duree; }
    }

    class Medicament {
        private String nom;
        private String description;
        private double prix;

        public Medicament(String nom, String description, double prix) {
            this.nom = nom;
            this.description = description;
            this.prix = prix;
        }

        public String getNom() { return nom; }
        public String getDescription() { return description; }
        public double getPrix() { return prix; }
    }

    class Paiement {
        private Patient patient;
        private double montant;
        private LocalDate date;

        public Paiement(Patient patient, double montant, LocalDate date) {
            this.patient = patient;
            this.montant = montant;
            this.date = date;
        }

        public Patient getPatient() { return patient; }
        public double getMontant() { return montant; }
        public LocalDate getDate() { return date; }
    }

   
}
