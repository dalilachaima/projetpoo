package projetpoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AgendaMedecin {
	private List<RendezVous> listeRendezVous;

    public AgendaMedecin() {
        this.listeRendezVous = new ArrayList<>();
    }

    public boolean vérifierDisponibilité(LocalDate date, LocalTime heure) {
        for (RendezVous rdv : listeRendezVous) {
            if (rdv.getDate().equals(date) && rdv.getHeure().equals(heure)) {
                return false;
            }
        }
        return true;
    }

    public boolean ajouterRendezVous(RendezVous rendezVous) {
        if (rendezVous.getDate().isBefore(LocalDate.now()) || 
            (rendezVous.getDate().equals(LocalDate.now()) && rendezVous.getHeure().isBefore(LocalTime.now()))) {
            System.out.println("Le rendez-vous ne peut pas être pris dans le passé.");
            return false;
        }
        if (vérifierDisponibilité(rendezVous.getDate(), rendezVous.getHeure())) {
            listeRendezVous.add(rendezVous);
            System.out.println("Rendez-vous ajouté pour " + rendezVous.getPatient().getNom() + " " + rendezVous.getPatient().getPrenom() +
                               " le " + rendezVous.getDate() + " à " + rendezVous.getHeure());
            return true;
        } else {
            System.out.println("Le médecin n'est pas disponible à cette heure.");
            return false;
        }
    }

    public List<RendezVous> getListeRendezVous() {
        return listeRendezVous;
    }

    private void trierRendezVous() {
        for (int i = 0; i < listeRendezVous.size(); i++) {
            for (int j = i + 1; j < listeRendezVous.size(); j++) {
                RendezVous rdv1 = listeRendezVous.get(i);
                RendezVous rdv2 = listeRendezVous.get(j);
                if (rdv1.getDate().isAfter(rdv2.getDate()) || 
                    (rdv1.getDate().equals(rdv2.getDate()) && rdv1.getHeure().isAfter(rdv2.getHeure()))) {
                    listeRendezVous.set(i, rdv2);
                    listeRendezVous.set(j, rdv1);
                }
            }
        }
    }

    public void setListeRendezVous(List<RendezVous> listeRendezVous) {
        this.listeRendezVous = listeRendezVous;
    }

    public void afficherAgenda() {
        if (listeRendezVous.isEmpty()) {
            System.out.println("Aucun rendez-vous planifié.");
        } else {
            System.out.println("Liste des rendez-vous planifiés :");
            for (RendezVous rdv : listeRendezVous) {
                rdv.afficherRendezVous();
            }
        }
    }
}
