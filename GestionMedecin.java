package projetpoo;
import java.util.List;
import java.util.ArrayList;
public class GestionMedecin {
    private static Map<String, Medecin> medecins = new HashMap<>();

    public static void ajouter(Medecin medecin) {
        if (!medecins.containsKey(medecin.getNom())) {
            medecins.put(medecin.getNom(), medecin);
            System.out.println("Médecin ajouté avec succès !");
        } else {
            System.out.println("Erreur : Un médecin avec ce nom existe déjà.");
        }
    }

    public static Medecin trouverMedecin(String nom) {
        return medecins.get(nom);
    }

    public static void modifier(String nom, Medecin medecin) {
        if (medecins.containsKey(nom)) {
            medecins.put(nom, medecin);
            System.out.println("Médecin modifié avec succès !");
        } else {
            System.out.println("Erreur : Médecin introuvable.");
        }
    }

    public static void supprimer(String nom) {
        if (medecins.containsKey(nom)) {
            medecins.remove(nom);
            System.out.println("Médecin supprimé avec succès !");
        } else {
            System.out.println("Erreur : Médecin introuvable.");
        }
    }

    public static Map<String, Medecin> getMedecin() {
        return medecins;
    }



    public static Map<String, Medecin> getMedecins() {
        return medecins;
    }
}
