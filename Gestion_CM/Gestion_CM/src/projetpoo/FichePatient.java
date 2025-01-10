package projetpoo;

import java.time.LocalDate;

public class FichePatient extends Person {
    private boolean newPatient;
    private TerrainMedical terrainMedical;
    private DossierMedical dossierMedical;

    public FichePatient(String nom, String prenom, LocalDate date_de_naissance, String lieu_de_naissance,
                        String sexe, String address, int numeroTelephone, String groupage, TerrainMedical terrainMedical) {
        super(nom, prenom, date_de_naissance, lieu_de_naissance, sexe, address, numeroTelephone, groupage);
        this.terrainMedical = terrainMedical != null ? terrainMedical : new TerrainMedical();
        this.setNewPatient(false);
        this.dossierMedical = new DossierMedical();
    }

    // Marque le patient comme nouveau
    public void ecrireFiche() { this.setNewPatient(true); }

    // Setter pour mettre à jour l'adresse
    @Override
    public void setAddress(String address) { super.setAddress(address); }

    // Getter pour obtenir le terrain médical
    public TerrainMedical getTerrainMedical() { return terrainMedical; }

    // Méthode pour afficher les informations du patient
    public void afficherFiche() {
        System.out.println("Nom : " + getNom());
        System.out.println("Prénom : " + getPrenom());
        System.out.println("Date de naissance : " + getDate_de_naissance());
        System.out.println("Lieu de naissance : " + getLieu_de_naissance());
        System.out.println("Sexe : " + getSexe());
        System.out.println("Adresse : " + getAddress());
        System.out.println("Numéro de téléphone : " + getNumeroTelephone());
        System.out.println("Groupage sanguin : " + getGroupage());
        System.out.println("Terrain médical : ");
        terrainMedical.afficherTerrain();
    }

    // Méthode pour afficher le dossier médical du patient
    public void afficherDossier() {
        dossierMedical.afficherDossier();
    }

    // Getter pour savoir si c'est un nouveau patient
    public boolean isNewPatient() {
        return newPatient;
    }

    // Setter pour définir si c'est un nouveau patient
    public void setNewPatient(boolean newPatient) {
        this.newPatient = newPatient;
    }

    // Getter pour obtenir le dossier médical
    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }
}
