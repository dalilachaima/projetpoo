package projetpoo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;






public class Menu {
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel lblWelcome, welcomeImage;
    private Map<String, FichePatient> patients;
    private Map<String, RendezVous> rendezVousMap;
    private Map<String, Ordonnance> ordonnances;
    private Map<String, Medicament> medicaments;
    private Map<String, Medecin> medecins;
    private GestionPatients gestionPatients = new GestionPatients();
    private GestionFichesPatients gestionFichesPatients = new GestionFichesPatients();
    private GestionMedecin gestionMedecin = new GestionMedecin();
    private List<Paiement> paiementlist;
    private DefaultTableModel paymentTableModel = new DefaultTableModel(new String[]{"Patient", "Montant", "Date", "Méthode de Paiement"}, 0);
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
    	paiementlist = new ArrayList<>();
        setPatients(new HashMap<>());
        rendezVousMap = new HashMap<>();
        ordonnances = new HashMap<>();
        medicaments = new HashMap<>();
        
        setMedecins(new HashMap<>());
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Cabinet Médical");
        frame.setBounds(100, 100, 900, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        mainPanel = new BackgroundPanel("C:\\Users\\GLOBAL INFO LAGA\\Pictures\\Screenshots\\x.jpg");
        mainPanel.setBorder(new LineBorder(new Color(70, 130, 180), 4));
        mainPanel.setLayout(new BorderLayout(10, 10));

        lblWelcome = new JLabel("Bienvenue à votre cabinet médical");
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 26));
        lblWelcome.setForeground(new Color(0, 51, 102));
        mainPanel.add(lblWelcome, BorderLayout.NORTH);

        welcomeImage = new JLabel(new ImageIcon("C:\\Users\\GLOBAL INFO LAGA\\Pictures\\Screenshots\\welcome_image.jpg"));
        mainPanel.add(welcomeImage, BorderLayout.CENTER);

        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        JPanel panel = new BackgroundPanel("https://i.pinimg.com/736x/31/27/02/31270202a6520c7b2b716343324e7b39.jpg");
        panel.setBorder(new LineBorder(new Color(70, 130, 180), 4));
        panel.setPreferredSize(new Dimension(900, 60));
        panel.setLayout(new BorderLayout());

        JLabel lblNewLabel = new JLabel("Cabinet Médical");
        lblNewLabel.setForeground(new Color(0, 0, 128));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
        panel.add(lblNewLabel, BorderLayout.CENTER);

        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JPanel sidebar = new JPanel();
        sidebar.setBorder(new LineBorder(new Color(70, 130, 180), 4));
        sidebar.setBackground(new Color(245, 245, 245));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(200, 650));
        frame.getContentPane().add(sidebar, BorderLayout.WEST);

        String[] buttons = {"Fiche Patient", "Rendez-vous", "Médecins", "Médicaments", "Ordonnances", "Paiements", "Dossiers Médicaux", "Aide"};

        for (String text : buttons) {
            JButton button = createSidebarButton(text);
            sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
            sidebar.add(button);
            button.addActionListener(e -> {
                try {
                    handleButtonAction(e.getActionCommand());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }

        showHomeScreen();
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(180, 40));
        button.setBackground(new Color(135, 206, 250));
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Serif", Font.BOLD, 16));
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

    private void handleButtonAction(String actionCommand) throws Exception {
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
            case "Dossiers Médicaux":
                showDossierOptionsDialog();
                break;
            case "Paiements":
                showPaiementOptionsDialog();
                break;
            case "Aide":
                showAideSupportDialog();
                break;
            default:
                lblWelcome.setText("Bienvenue à votre cabinet médical");
                break;
        }
    }

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
            default:
                JOptionPane.showMessageDialog(null, "Option invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

private void showAddPatientDialog() {
    JTextField nomField = new JTextField();
    JTextField dateNaissanceField = new JTextField();
    JTextField lieuNaissanceField = new JTextField();
    JTextField sexeField = new JTextField();
    JTextField adresseField = new JTextField();
    JTextField telephoneField = new JTextField();
    JTextField groupageField = new JTextField();
    JTextField poidsField = new JTextField();
    JTextField tailleField = new JTextField();

    Object[] message = {
        "Nom:", nomField,
        "Date de Naissance (YYYY-MM-DD):", dateNaissanceField,
        "Lieu de Naissance:", lieuNaissanceField,
        "Sexe (H/F):", sexeField,
        "Adresse:", adresseField,
        "Téléphone:", telephoneField,
        "Groupage:", groupageField,
        "Poids (kg):", poidsField,
        "Taille (m):", tailleField,
    };

    boolean validInput = false;
    while (!validInput) {
        int option = JOptionPane.showConfirmDialog(null, message, "Ajouter Patient", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String nom = nomField.getText().trim();
                LocalDate dateNaissance = LocalDate.parse(dateNaissanceField.getText().trim());
                String lieuNaissance = lieuNaissanceField.getText().trim();
                String sexe = sexeField.getText().trim().toUpperCase();
                String adresse = adresseField.getText().trim();
                int telephone = Integer.parseInt(telephoneField.getText().trim());
                String groupage = groupageField.getText().trim().toUpperCase();
                float poids = Float.parseFloat(poidsField.getText().trim());
                float taille = Float.parseFloat(tailleField.getText().trim());

                if (nom.isEmpty() || adresse.isEmpty() || sexe.isEmpty()) {
                    throw new IllegalArgumentException("Tous les champs obligatoires doivent être remplis.");
                }

                if (!sexe.equals("H") && !sexe.equals("F")) {
                    throw new IllegalArgumentException("Le sexe doit être 'H' ou 'F'.");
                }

                if (!groupage.matches("^(A|B|AB|O)[+-]$")) {
                    throw new IllegalArgumentException("Le groupage doit être 'A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+' ou 'O-'.");
                }

                FichePatient patient = new FichePatient(nom, dateNaissance, lieuNaissance, sexe, adresse, telephone, groupage, poids, taille, new TerrainMedical());
                gestionPatients.ajouter(patient);
                gestionFichesPatients.ajouterFiche(patient);

                JOptionPane.showMessageDialog(null, "Patient ajouté :\nNom: " + nom + "\nDate de Naissance: " + dateNaissance + "\nLieu de Naissance: " + lieuNaissance + "\nSexe: " + sexe + "\nAdresse: " + adresse + "\nTéléphone: " + telephone + "\nGroupage: " + groupage + "\nPoids: " + poids + "kg\nTaille: " + taille + "m");
                validInput = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            validInput = true; 
        }
    }
}

private void showEditPatientDialog() {
    SwingUtilities.invokeLater(() -> {
        try {
            JTextField nomField = new JTextField();
            Object[] message = {
                "Entrez le nom du patient à modifier :", nomField
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Modifier Patient", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String nom = nomField.getText().trim();
                System.out.println("Recherche du patient avec le nom : " + nom);

                if (nom == null || nom.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Erreur : Nom du patient vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                FichePatient patient = gestionPatients.trouverPatient(nom);
                if (patient == null) {
                    JOptionPane.showMessageDialog(null, "Erreur : Patient introuvable.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Patient introuvable");
                    return;
                }

                JTextField adresseField = new JTextField(patient.getAddress());
                JTextField telephoneField = new JTextField(String.valueOf(patient.getNumeroTelephone()));
                JTextField dateNaissanceField = new JTextField(patient.getDate_de_naissance().toString());
                JTextField lieuNaissanceField = new JTextField(patient.getLieu_de_naissance());
                JTextField sexeField = new JTextField(patient.getSexe());
                JTextField groupageField = new JTextField(patient.getGroupage());
                JTextField poidsField = new JTextField(String.valueOf(patient.getPoids()));
                JTextField tailleField = new JTextField(String.valueOf(patient.getTaille()));

                Object[] modifyMessage = {
                    "Adresse :", adresseField,
                    "Téléphone :", telephoneField,
                    "Date de naissance (YYYY-MM-DD) :", dateNaissanceField,
                    "Lieu de Naissance :", lieuNaissanceField,
                    "Sexe (H/F) :", sexeField,
                    "Groupage :", groupageField,
                    "Poids (kg) :", poidsField,
                    "Taille (m) :", tailleField,
                };

                int modifyOption = JOptionPane.showConfirmDialog(null, modifyMessage, "Modifier Patient", JOptionPane.OK_CANCEL_OPTION);
                if (modifyOption == JOptionPane.OK_OPTION) {
                    try {
                        String adresse = adresseField.getText().trim();
                        if (adresse.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Erreur : Adresse est vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        int telephone;
                        try {
                            telephone = Integer.parseInt(telephoneField.getText().trim());
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Erreur : Le numéro de téléphone doit être un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        LocalDate dateNaissance;
                        try {
                            dateNaissance = LocalDate.parse(dateNaissanceField.getText().trim());
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erreur : La date de naissance doit être au format YYYY-MM-DD.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String sexe = sexeField.getText().trim().toUpperCase();
                        if (!sexe.equals("H") && !sexe.equals("F")) {
                            JOptionPane.showMessageDialog(null, "Erreur : Le sexe doit être 'H' ou 'F'.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String lieuNaissance = lieuNaissanceField.getText().trim();
                        if (lieuNaissance.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Erreur : Lieu de naissance est vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String groupage = groupageField.getText().trim();
                        if (!groupage.matches("^(A|B|AB|O)[+-]$")) {
                            JOptionPane.showMessageDialog(null, "Erreur : Le groupage doit être 'A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+' ou 'O-'.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        float poids;
                        try {
                            poids = Float.parseFloat(poidsField.getText().trim());
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Erreur : Le poids doit être un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        float taille;
                        try {
                            taille = Float.parseFloat(tailleField.getText().trim());
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Erreur : La taille doit être un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        patient.setAddress(adresse);
                        patient.setNumeroTelephone(telephone);
                        patient.setDate_de_naissance(dateNaissance);
                        patient.setLieu_de_naissance(lieuNaissance);
                        patient.setSexe(sexe);
                        patient.setGroupage(groupage);
                        patient.setPoids(poids);
                        patient.setTaille(taille);

                        JOptionPane.showMessageDialog(null, "Patient modifié :\nNom : " + nom + "\nAdresse : " + adresse + "\nTéléphone : " + telephone + "\nDate de Naissance : " + dateNaissance + "\nSexe : " + sexe + "\nLieu de Naissance : " + lieuNaissance + "\nGroupage : " + groupage + "\nPoids : " + poids + "kg\nTaille : " + taille + "m");
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    });
}

    private void showDeletePatientDialog() {
        JTextField nomField = new JTextField();
        Object[] message = {
            "Entrez le nom du patient à supprimer:", nomField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Supprimer Patient", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nom = nomField.getText().trim();
            FichePatient patient = gestionPatients.trouverPatient(nom);
            if (patient == null) {
                JOptionPane.showMessageDialog(null, "Erreur: Patient introuvable.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer le patient " + nom + "?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                gestionPatients.getPatients().remove(patient);
                JOptionPane.showMessageDialog(null, "Patient supprimé : " + nom);
            }
        }
    }

private void showViewPatientsDialog() {
    String[] columnNames = {"Nom", "Adresse", "Téléphone", "Date de Naissance", "Sexe", "Groupage", "Poids (kg)", "Taille (m)"};
    ArrayList<FichePatient> patientsList = gestionPatients.getPatients();
    Object[][] data = new Object[patientsList.size()][8]; // Augmenter la taille du tableau pour inclure tous les champs
    int i = 0;
    for (FichePatient patient : patientsList) {
        data[i][0] = patient.getNom();
        data[i][1] = patient.getAddress();
        data[i][2] = patient.getNumeroTelephone();
        data[i][3] = patient.getDate_de_naissance().toString();
        data[i][4] = patient.getSexe();
        data[i][5] = patient.getGroupage();
        data[i][6] = patient.getPoids();
        data[i][7] = patient.getTaille();
        i++;
    }

    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);

    JFrame frame = new JFrame("Liste des Patients");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(800, 600);
    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
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
        while (true) {
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
                    String medecinDispoStr = medecinDispoField.getText().trim();

                    if (!medecinDispoStr.equalsIgnoreCase("true") && !medecinDispoStr.equalsIgnoreCase("false")) {
                        throw new IllegalArgumentException("Médecin Disponible doit être 'true' ou 'false'.");
                    }

                    boolean medecinDispo = Boolean.parseBoolean(medecinDispoStr);

                    FichePatient patient = gestionPatients.trouverPatient(nomPatient);
                    if (patient == null) {
                        throw new IllegalArgumentException("Patient introuvable.");
                    }

                    RendezVous rendezVous = new RendezVous(date, heure, patient, medecinDispo);
                    rendezVousMap.put(nomPatient + date.toString() + heure.toString(), rendezVous);

                    JOptionPane.showMessageDialog(null, "Rendez-vous ajouté :\nDate: " + date + "\nHeure: " + heure + "\nNom du Patient: " + nomPatient + "\nMédecin Disponible: " + medecinDispo);
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                break;
            }
        }
    }

    private void showViewRendezVousDialog() {
        String[] columnNames = {"Date", "Heure", "Patient", "Médecin Disponible"};
        Object[][] data = new Object[rendezVousMap.size()][4];
        int i = 0;
        for (RendezVous rdv : rendezVousMap.values()) {
            data[i][0] = rdv.getDate().toString();
            data[i][1] = rdv.getHeure().toString();
            data[i][2] = rdv.getPatient().getNom();
            data[i][3] = rdv.isMedecinDisponible();
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

    @SuppressWarnings("static-access")
	private void showAddMedecinDialog() {
        while (true) {
            JTextField nomField = new JTextField();
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
                "Date de Naissance (YYYY-MM-DD):", dateNaissanceField,
                "Lieu de Naissance:", lieuNaissanceField,
                "Sexe (H/F):", sexeField,
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
                    if (nom.isEmpty()) throw new IllegalArgumentException("Nom est vide.");

                    LocalDate dateNaissance = LocalDate.parse(dateNaissanceField.getText().trim());
                    String lieuNaissance = lieuNaissanceField.getText().trim();
                    if (lieuNaissance.isEmpty()) throw new IllegalArgumentException("Lieu de Naissance est vide.");

                    String sexe = sexeField.getText().trim().toUpperCase();
                    if (!sexe.equals("H") && !sexe.equals("F")) throw new IllegalArgumentException("Le sexe doit être 'H' ou 'F'.");

                    String adresse = adresseField.getText().trim();
                    if (adresse.isEmpty()) throw new IllegalArgumentException("Adresse est vide.");

                    int telephone = Integer.parseInt(telephoneField.getText().trim());
                    if (String.valueOf(telephone).length() != 10) throw new IllegalArgumentException("Le numéro de téléphone doit contenir exactement 10 chiffres.");

                    String groupage = groupageField.getText().trim();
                    if (!groupage.matches("^(A|B|AB|O)[+-]$")) throw new IllegalArgumentException("Le groupage doit être valide (exemple : A+, B-, O+).");

                    String specialite = specialiteField.getText().trim();
                    if (specialite.isEmpty()) throw new IllegalArgumentException("Spécialité est vide.");

                    String hopital = hopitalField.getText().trim();
                    if (hopital.isEmpty()) throw new IllegalArgumentException("Hôpital est vide.");

                    String numeroLicense = numeroLicenseField.getText().trim();
                    if (numeroLicense.isEmpty()) throw new IllegalArgumentException("Numéro de License est vide.");

                    Medecin medecin = new Medecin(nom, dateNaissance, lieuNaissance, sexe, adresse, telephone, groupage, specialite, hopital, numeroLicense);
                    gestionMedecin.ajouter(medecin);
                    JOptionPane.showMessageDialog(null, "Médecin ajouté :\nNom: " + nom + "\nDate de Naissance: " + dateNaissance + "\nLieu de Naissance: " + lieuNaissance + "\nSexe: " + sexe + "\nAdresse: " + adresse + "\nTéléphone: " + telephone + "\nGroupage: " + groupage + "\nSpécialité: " + specialite + "\nHôpital: " + hopital + "\nNuméro de License: " + numeroLicense);
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                break;
            }
        }
    }

    @SuppressWarnings("static-access")
	private void showEditMedecinDialog() {
        while (true) {
            JTextField nomField = new JTextField();
            Object[] message = {
                "Entrez le nom du médecin à modifier:", nomField
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Modifier Médecin", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String nom = nomField.getText().trim();
                Medecin medecin = gestionMedecin.trouverMedecin(nom);
                if (medecin == null) {
                    JOptionPane.showMessageDialog(null, "Erreur: Médecin introuvable.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

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
                    "Date de Naissance (YYYY-MM-DD):", dateNaissanceField,
                    "Lieu de Naissance:", lieuNaissanceField,
                    "Sexe (H/F):", sexeField,
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
                        LocalDate dateNaissance = LocalDate.parse(dateNaissanceField.getText().trim());
                        String lieuNaissance = lieuNaissanceField.getText().trim();
                        if (lieuNaissance.isEmpty()) throw new IllegalArgumentException("Lieu de Naissance est vide.");

                        String sexe = sexeField.getText().trim().toUpperCase();
                        if (!sexe.equals("H") && !sexe.equals("F")) throw new IllegalArgumentException("Le sexe doit être 'H' ou 'F'.");

                        String adresse = adresseField.getText().trim();
                        if (adresse.isEmpty()) throw new IllegalArgumentException("Adresse est vide.");

                        int telephone = Integer.parseInt(telephoneField.getText().trim());
                        if (String.valueOf(telephone).length() != 10) throw new IllegalArgumentException("Le numéro de téléphone doit contenir exactement 10 chiffres.");

                        String groupage = groupageField.getText().trim();
                        if (!groupage.matches("^(A|B|AB|O)[+-]$")) throw new IllegalArgumentException("Le groupage doit être valide (exemple : A+, B-, O+).");

                        String specialite = specialiteField.getText().trim();
                        if (specialite.isEmpty()) throw new IllegalArgumentException("Spécialité est vide.");

                        String hopital = hopitalField.getText().trim();
                        if (hopital.isEmpty()) throw new IllegalArgumentException("Hôpital est vide.");

                        String numeroLicense = numeroLicenseField.getText().trim();
                        if (numeroLicense.isEmpty()) throw new IllegalArgumentException("Numéro de License est vide.");

                        medecin.setDate_de_naissance(dateNaissance);
                        medecin.setLieu_de_naissance(lieuNaissance);
                        medecin.setSexe(sexe);
                        medecin.setAddress(adresse);
                        medecin.setNumeroTelephone(telephone);
                        medecin.setGroupage(groupage);
                        medecin.setSpecialty(specialite);
                        medecin.setHospital(hopital);
                        medecin.setLicenseNumber(numeroLicense);

                        gestionMedecin.modifier(nom, medecin);
                        JOptionPane.showMessageDialog(null, "Médecin modifié :\nNom: " + nom + "\nDate de Naissance: " + dateNaissance + "\nLieu de Naissance: " + lieuNaissance + "\nSexe: " + sexe + "\nAdresse: " + adresse + "\nTéléphone: " + telephone + "\nGroupage: " + groupage + "\nSpécialité: " + specialite + "\nHôpital: " + hopital + "\nNuméro de License: " + numeroLicense);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                        continue;
                    }
                }
            } else {
                break;
            }
        }
    }

    @SuppressWarnings("static-access")
	private void showDeleteMedecinDialog() {
        while (true) {
            JTextField nomField = new JTextField();
            Object[] message = {
                "Entrez le nom du médecin à supprimer:", nomField
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Supprimer Médecin", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                try {
                    String nom = nomField.getText().trim();
                    Medecin medecin = gestionMedecin.trouverMedecin(nom);
                    if (medecin == null) {
                        throw new IllegalArgumentException("Médecin introuvable.");
                    }

                    int confirm = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer le médecin " + nom + "?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        gestionMedecin.supprimer(nom);
                        JOptionPane.showMessageDialog(null, "Médecin supprimé : " + nom);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                break;
            }
        }
    }

    @SuppressWarnings("static-access")
	private void showViewMedecinsDialog() {
        String[] columnNames = {"Nom", "Date de Naissance", "Lieu de Naissance", "Sexe", "Adresse", "Téléphone", "Groupage", "Spécialité", "Hôpital", "Numéro de License"};
        Object[][] data = new Object[gestionMedecin.getMedecins().size()][10];
        int i = 0;
        for (Medecin medecin : gestionMedecin.getMedecins().values()) {
            data[i][0] = medecin.getNom();
            data[i][1] = medecin.getDate_de_naissance().toString();
            data[i][2] = medecin.getLieu_de_naissance();
            data[i][3] = medecin.getSexe();
            data[i][4] = medecin.getAddress();
            data[i][5] = medecin.getNumeroTelephone();
            data[i][6] = medecin.getGroupage();
            data[i][7] = medecin.getSpecialty();
            data[i][8] = medecin.getHospital();
            data[i][9] = medecin.getLicenseNumber();
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
        while (true) {
            JTextField nomField = new JTextField();
            JTextField descriptionField = new JTextField();
            JTextField prixField = new JTextField();

            Object[] message = {
                "Nom:", nomField,
                "Description:", descriptionField,
                "Prix (Dinars):", prixField,
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
                    JOptionPane.showMessageDialog(null, "Médicament ajouté :\nNom: " + nom + "\nDescription: " + description + "\nPrix: " + prix + "DA");
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erreur: Le prix doit être un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                break;
            }
        }
    }

    private void showViewMedicamentDialog() {
        String[] columnNames = {"Nom", "Description", "Prix (DA)"};
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
    JTextField medecinField = new JTextField();
    JTextField medicamentField = new JTextField();
    JTextField dosageField = new JTextField();
    JTextField dureeField = new JTextField();
    JTextField dateOrdonnanceField = new JTextField();

    Object[] message = {
        "Nom du Patient:", nomPatientField,
        "Nom du Médecin:", medecinField,
        "Médicaments:(séparé par des vérgules)", medicamentField,
        "Dosage:(combien de fois par jour)", dosageField,
        "Durée:(nbr de jours)", dureeField,
        "Date de l'Ordonnance (YYYY-MM-DD):", dateOrdonnanceField,
    };

    boolean validInput = false;
    while (!validInput) {
        int option = JOptionPane.showConfirmDialog(null, message, "Ajouter Ordonnance", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String nomPatient = nomPatientField.getText().trim();
                String nomMedecin = medecinField.getText().trim();
                List<String> medicaments = Arrays.asList(medicamentField.getText().trim());
                String dosage = dosageField.getText().trim();
                String duree = dureeField.getText().trim();
                LocalDate dateOrdonnance = LocalDate.parse(dateOrdonnanceField.getText().trim());

                // Vérification de l'existence du patient
                FichePatient patient = gestionPatients.trouverPatient(nomPatient);
                if (patient == null) {
                    throw new IllegalArgumentException("Patient introuvable.");
                }

                // Vérification de l'existence du médecin
                @SuppressWarnings("static-access")
				Medecin medecin = gestionMedecin.trouverMedecin(nomMedecin);
                if (medecin == null) {
                    throw new IllegalArgumentException("Médecin introuvable.");
                }

                // Ajout de l'ordonnance
                Ordonnance ordonnance = new Ordonnance(medecin, patient, medicaments, dosage, duree, dateOrdonnance);
                ordonnances.put(nomPatient + medicamentField.getText().trim(), ordonnance);

                JOptionPane.showMessageDialog(null, "Ordonnance ajoutée :\nPatient: " + nomPatient + "\nMédecin: " + nomMedecin + "\nMédicament: " + medicamentField.getText().trim() + "\nDosage: " + dosage + "\nDurée: " + duree + "\nDate de l'Ordonnance: " + dateOrdonnance);
                validInput = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            validInput = true;
        }
    }
}

private void showViewOrdonnancesDialog() {
    String[] columnNames = {"Patient", "Médecin", "Médicament", "Dosage", "Durée", "Date de l'Ordonnance"};
    Object[][] data = new Object[ordonnances.size()][6];
    int i = 0;
    for (Ordonnance ordonnance : ordonnances.values()) {
        if (ordonnance.getPatient() != null && ordonnance.getMedecin() != null) {
            data[i][0] = ordonnance.getPatient().getNom();
            data[i][1] = ordonnance.getMedecin().getNom();
            data[i][2] = ordonnance.getMedicaments();
            data[i][3] = ordonnance.getDosage();
            data[i][4] = ordonnance.getDuree();
            data[i][5] = ordonnance.getDateOrdonnance().toString();
            i++;
        }
    }

    // Ajuster la taille des données pour correspondre aux entrées non-nulles
    Object[][] trimmedData = new Object[i][6];
    System.arraycopy(data, 0, trimmedData, 0, i);

    DefaultTableModel model = new DefaultTableModel(trimmedData, columnNames);
    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);

    JFrame frame = new JFrame("Liste des Ordonnances");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(800, 600);
    frame.getContentPane().add(scrollPane);
    frame.setVisible(true);
}


private void showPaiementOptionsDialog() { 
    String[] options = {"Ajouter Paiement", "Voir Paiements"};
    int choice = JOptionPane.showOptionDialog(null, "Choisissez une option", "Paiements", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
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
    JTextField methodePaiementField = new JTextField();

    Object[] message = {
        "Nom du Patient:", nomPatientField,
        "Montant:(DA)", montantField,
        "Date (YYYY-MM-DD):", dateField,
        "Méthode de Paiement:", methodePaiementField,
    };

    int option = JOptionPane.showConfirmDialog(null, message, "Ajouter Paiement", JOptionPane.OK_CANCEL_OPTION);
    if (option == JOptionPane.OK_OPTION) {
        try {
            String nomPatient = nomPatientField.getText().trim();
            double montant = Double.parseDouble(montantField.getText().trim());
            LocalDate date = LocalDate.parse(dateField.getText().trim());
            String methodePaiement = methodePaiementField.getText().trim();

            if (montant < 0) {
                throw new IllegalArgumentException("Le montant ne peut pas être négatif.");
            }

            // Vérification de l'existence du patient
            FichePatient patient = gestionPatients.trouverPatient(nomPatient);
            if (patient == null) {
                throw new IllegalArgumentException("Patient introuvable.");
            }

            // Ajout du paiement
            Paiement paiement = new Paiement(patient, montant, date, methodePaiement);
            paiementlist.add(paiement); // Ajouter à la liste
            paymentTableModel.addRow(new Object[]{nomPatient, montant, date.toString(), methodePaiement}); // Mettre à jour le modèle de table

            JOptionPane.showMessageDialog(null, "Paiement ajouté :\nPatient: " + nomPatient + "\nMontant: " + montant + "\nDate: " + date + "\nMéthode de Paiement: " + methodePaiement);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erreur: Le montant doit être un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}

private void showViewPaiementsDialog() {
    JTable table = new JTable(paymentTableModel); 
    JScrollPane scrollPane = new JScrollPane(table);

    JFrame frame = new JFrame("Liste des Paiements");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(800, 600);
    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    frame.setVisible(true);
}

private void showDossierOptionsDialog() {
    String patientName = JOptionPane.showInputDialog(null, "Entrez le nom du patient:");
    if (patientName != null && !patientName.trim().isEmpty()) {
        FichePatient patient = gestionPatients.trouverPatient(patientName.trim());
        if (patient != null) {
            String[] options = {"Voir Antécédents", "Ajouter Antécédent"};
            int choice = JOptionPane.showOptionDialog(null, "Choisissez une option", "Dossiers Médicaux",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    showViewPatientHistoryDialog(patient);
                    break;
                case 1:
                    DefaultTableModel tableModel = new DefaultTableModel();
                    showAddAntecedentDialog(patient, tableModel);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Option invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Patient non trouvé.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    private void showViewPatientHistoryDialog(FichePatient patient) {
        DossierMedical dossier = patient.getDossierMedical();

        StringBuilder history = new StringBuilder();
        history.append("=== HISTORIQUE MÉDICAL ===\n\n");
        appendCategory(history, "Maladies Chroniques", dossier.getMaladie_chronique());
        appendCategory(history, "Maladies Virales", dossier.getMaladie_virale());
        appendCategory(history, "Complications Antérieures", dossier.getComplication_anterieures());
        appendCategory(history, "Analyses", dossier.getAnalyse());
        appendCategory(history, "Radios", dossier.getRadio());
        appendCategory(history, "Échographies", dossier.getEchographie());
        appendCategory(history, "Scanners", dossier.getScanner());
        appendCategory(history, "Allergies", dossier.getAllergie());
        appendCategory(history, "Chirurgies", dossier.getChirurgie());

        JTextArea textArea = new JTextArea(history.toString());
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));

        JOptionPane.showMessageDialog(null, scrollPane, "Historique Médical de " + patient.getNom(), JOptionPane.INFORMATION_MESSAGE);
    }

    private void appendCategory(StringBuilder history, String category, java.util.List<String> items) {
        if (items != null && !items.isEmpty()) {
            history.append("### ").append(category).append(" ###\n");
            for (String item : items) {
                history.append("- ").append(item).append("\n");
            }
            history.append("\n");
        }
    }

    private void showAddAntecedentDialog(FichePatient patient, DefaultTableModel tableModel) {
        JTextField newAntecedentField = new JTextField();
        String[] options = {"Maladies Chroniques", "Maladies Virales", "Complications Antérieures", "Analyses", "Radios", "Échographies", "Scanners", "Allergies", "Chirurgies"};
        JComboBox<String> comboBox = new JComboBox<>(options);

        Object[] message = {
            "Sélectionnez la catégorie:", comboBox,
            "Entrez le détail:", newAntecedentField,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Ajouter un antécédent", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String category = (String) comboBox.getSelectedItem();
            String detail = newAntecedentField.getText().trim();
            if (!detail.isEmpty()) {
                switch (category) {
                    case "Maladies Chroniques":
                        patient.getDossierMedical().ajouterMaladieChronique(detail);
                        break;
                    case "Maladies Virales":
                        patient.getDossierMedical().ajouterMaladieVirale(detail);
                        break;
                    case "Complications Antérieures":
                        patient.getDossierMedical().ajouterComplicationAnterieure(detail);
                        break;
                    case "Analyses":
                        patient.getDossierMedical().ajouterAnalyse(detail);
                        break;
                    case "Radios":
                        patient.getDossierMedical().ajouterRadio(detail);
                        break;
                    case "Échographies":
                        patient.getDossierMedical().ajouterEchographie(detail);
                        break;
                    case "Scanners":
                        patient.getDossierMedical().ajouterScanner(detail);
                        break;
                    case "Allergies":
                        patient.getDossierMedical().ajouterAllergie(detail);
                        break;
                    case "Chirurgies":
                        patient.getDossierMedical().ajouterChirurgie(detail);
                        break;
                }
                tableModel.addRow(new Object[]{category, detail});
                JOptionPane.showMessageDialog(null, "Antécédent ajouté avec succès !");
            } else {
                JOptionPane.showMessageDialog(null, "Erreur: Le détail ne peut pas être vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showAideSupportDialog() {
        JTextArea textArea = new JTextArea();
        textArea.setText("=== AIDE ET SUPPORT ===\n\n" + "Bienvenue dans la section Aide et Support!\n\n" + "Pour toute assistance, veuillez contacter notre support technique.\n\n" + "Email:CabinetMedical@gmail.com\n" + "Téléphone: +213 123456789\n\n"); 
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setEditable(false); 
        JOptionPane.showMessageDialog(frame, textArea, "Aide et Support", JOptionPane.INFORMATION_MESSAGE);
    }

	public Map<String, FichePatient> getPatients() {
		return patients;
	}

	public void setPatients(Map<String, FichePatient> patients) {
		this.patients = patients;
	}

	public Map<String, Medecin> getMedecins() {
		return medecins;
	}

	public void setMedecins(Map<String, Medecin> medecins) {
		this.medecins = medecins;
	}
}

    