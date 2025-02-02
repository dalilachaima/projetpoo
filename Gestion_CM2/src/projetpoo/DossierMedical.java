package projetpoo;

import java.util.ArrayList;
import java.util.List;

public class DossierMedical {
    private List<String> observations;
    private List<String> ordonnances;
    private List<String> antecedents;
    private List<String> maladie_chronique;
    private List<String> maladie_virale;
    private List<String> complication_anterieures;
    private List<String> analyse;
    private List<String> radio;
    private List<String> echographie;
    private List<String> scanner;
    private List<String> allergie;
    private List<String> chirurgie;

    public DossierMedical() {
        this.observations = new ArrayList<>();
        this.ordonnances = new ArrayList<>();
        this.antecedents = new ArrayList<>();
        this.maladie_chronique = new ArrayList<>();
        this.maladie_virale = new ArrayList<>();
        this.complication_anterieures = new ArrayList<>();
        this.analyse = new ArrayList<>();
        this.radio = new ArrayList<>();
        this.echographie = new ArrayList<>();
        this.scanner = new ArrayList<>();
        this.allergie = new ArrayList<>();
        this.chirurgie = new ArrayList<>();
    }

    // Méthodes pour ajouter des détails médicaux
    public void ajouterObservation(String observation) { observations.add(observation); }
    public void ajouterOrdonnance(String ordonnance) { ordonnances.add(ordonnance); }
    public void ajouterAntecedent(String antecedent) { antecedents.add(antecedent); }
    public void ajouterMaladieChronique(String maladieChronique) { maladie_chronique.add(maladieChronique); }
    public void ajouterMaladieVirale(String maladieVirale) { maladie_virale.add(maladieVirale); }
    public void ajouterComplicationAnterieure(String complicationAnterieure) { complication_anterieures.add(complicationAnterieure); }
    public void ajouterAnalyse(String analyse) { this.analyse.add(analyse); }
    public void ajouterRadio(String radio) { this.radio.add(radio); }
    public void ajouterEchographie(String echographie) { this.echographie.add(echographie); }
    public void ajouterScanner(String scanner) { this.scanner.add(scanner); }
    public void ajouterAllergie(String allergie) { this.allergie.add(allergie); }
    public void ajouterChirurgie(String chirurgie) { this.chirurgie.add(chirurgie); }

    public void afficherDossier() {
        System.out.println("Observations : " + observations);
        System.out.println("Ordonnances : " + ordonnances);
        System.out.println("Antécédents : " + antecedents);
        System.out.println("Maladies Chroniques : " + maladie_chronique);
        System.out.println("Maladies Virales : " + maladie_virale);
        System.out.println("Complications Antérieures : " + complication_anterieures);
        System.out.println("Analyses : " + analyse);
        System.out.println("Radios : " + radio);
        System.out.println("Échographies : " + echographie);
        System.out.println("Scanners : " + scanner);
        System.out.println("Allergies : " + allergie);
        System.out.println("Chirurgies : " + chirurgie);
        
    }

  
        public void modifierObservation(int index, String observation) { observations.set(index, observation); }
        public void modifierOrdonnance(int index, String ordonnance) { ordonnances.set(index, ordonnance); }
        public void modifierAntecedent(int index, String antecedent) { antecedents.set(index, antecedent); }
        public void modifierMaladieChronique(int index, String maladieChronique) { maladie_chronique.set(index, maladieChronique); }
        public void modifierMaladieVirale(int index, String maladieVirale) { maladie_virale.set(index, maladieVirale); }
        public void modifierComplicationAnterieure(int index, String complicationAnterieure) { complication_anterieures.set(index, complicationAnterieure); }
        public void modifierAnalyse(int index, String analyse) { this.analyse.set(index, analyse); }
        public void modifierRadio(int index, String radio) { this.radio.set(index, radio); }
        public void modifierEchographie(int index, String echographie) { this.echographie.set(index, echographie); }
        public void modifierScanner(int index, String scanner) { this.scanner.set(index, scanner); }
        public void modifierAllergie(int index, String allergie) { this.allergie.set(index, allergie); }
        public void modifierChirurgie(int index, String chirurgie) { this.chirurgie.set(index, chirurgie); }

        // Getters pour accéder aux listes
        public List<String> getObservations() { return observations; }
        public List<String> getOrdonnances() { return ordonnances; }
        public List<String> getAntecedents() { return antecedents; }
        public List<String> getMaladie_chronique() { return maladie_chronique; }
        public List<String> getMaladie_virale() { return maladie_virale; }
        public List<String> getComplication_anterieures() { return complication_anterieures; }
        public List<String> getAnalyse() { return analyse; }
        public List<String> getRadio() { return radio; }
        public List<String> getEchographie() { return echographie; }
        public List<String> getScanner() { return scanner; }
        public List<String> getAllergie() { return allergie; }
        public List<String> getChirurgie() { return chirurgie; }
    }


