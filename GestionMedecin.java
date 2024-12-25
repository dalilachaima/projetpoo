package projetpoo;
import java.util.List;
import java.util.ArrayList;
public class GestionMedecin {
	  private List<Medecin> medecins;

	    public GestionMedecin() {
	        medecins = new ArrayList<>();
	    }

	    public void ajouter(Medecin medecin) {
	        medecins.add(medecin);
	        
	    }

	    public void modifier(String nom, Medecin medecinModifie) {
	        for (int i = 0; i < medecins.size(); i++) {
	            if (medecins.get(i).getNom().equalsIgnoreCase(nom)) {
	                medecins.set(i, medecinModifie);
	                return;
	            }
	        }
	    }

	    public void supprimer(String nom) {
	        medecins.removeIf(m -> m.getNom().equalsIgnoreCase(nom));
	    }

	    public List<Medecin> getMedecins() {
	        return medecins;
	    }

	    public Medecin trouverMedecin(String nom) {
	        for (Medecin medecin : medecins) {
	            if (medecin.getNom().equalsIgnoreCase(nom)) {
	                return medecin;
	            }
	        }
	        return null;
	    }
	}


