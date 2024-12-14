package projetpoo;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class GestionFichesPatients {
	private List<FichePatient> fichesPatients;

    public GestionFichesPatients() {
        this.fichesPatients = new ArrayList<>();
    }

    public void ajouterFiche(FichePatient fiche) {
        fichesPatients.add(fiche);
    }

    public List<FichePatient> getFichesPatients() {
        return new ArrayList<>(fichesPatients);
    }

    @Override
    public String toString() {
        return "GestionFichesPatients[fichesPatients=" + fichesPatients + "]";
    }
}

