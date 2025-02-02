package projetpoo;

import java.time.LocalDate;

public class Person {
    private String nom;
    private LocalDate date_de_naissance;
    private String lieu_de_naissance;
    private String sexe;
    private String address;
    private int numeroTelephone;
    private String groupage;

    public Person(String nom, LocalDate date_de_naissance, String lieu_de_naissance,
                  String sexe, String address, int numeroTelephone, String groupage) {
        this.nom = nom;
        this.date_de_naissance = date_de_naissance;
        this.lieu_de_naissance = lieu_de_naissance;
        this.sexe = sexe;
        this.address = address;
        setNumeroTelephone(numeroTelephone);
        setGroupage(groupage);
    }

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

  
    public LocalDate getDate_de_naissance() { return date_de_naissance; }
    public void setDate_de_naissance(LocalDate date_de_naissance) { this.date_de_naissance = date_de_naissance; }

    public String getLieu_de_naissance() { return lieu_de_naissance; }
    public void setLieu_de_naissance(String lieu_de_naissance) { this.lieu_de_naissance = lieu_de_naissance; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }

    public int getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(int numeroTelephone) {
        if (String.valueOf(numeroTelephone).length() == 10 && numeroTelephone > 0) {
            this.numeroTelephone = numeroTelephone;
        } else {
            throw new IllegalArgumentException("Le numéro de téléphone doit contenir exactement 10 chiffres et être un nombre positif.");
        }
    }


    public String getGroupage() { return groupage; }
    public void setGroupage(String groupage) {
        if (groupage.matches("^(A|B|AB|O)[+-]$")) { this.groupage = groupage; }
        else { throw new IllegalArgumentException("Le groupage doit être valide (exemple : A+, B-, O+)."); }
    }
}
