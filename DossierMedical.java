package projetpoo;
import java.util.List;
import java.util.ArrayList;
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
    this.maladie_chronique= new ArrayList<>();
    this.maladie_virale= new ArrayList<>();
    this.complication_anterieures= new ArrayList<>();
    this.analyse= new ArrayList<>();
    this.radio= new ArrayList<>();
    this.echographie= new ArrayList<>();
    this.scanner= new ArrayList<>();
    this.allergie= new ArrayList<>();
    this.chirurgie= new ArrayList<>();
}
public void ajouterObservation(String observation) {
    observations.add(observation);
}

public void ajouterOrdonnance(String ordonnance) {
    ordonnances.add(ordonnance);
}

public void ajouterAntecedent(String antecedent) {
    antecedents.add(antecedent);
}

public void ajoutermaladie_chronique(String maladie_chronique) {
    observations.add(maladie_chronique);
}

public void ajoutermaladie_virale(String maladie_virale) {
    ordonnances.add(maladie_virale);
}

public void ajoutercomplication_anterieures(String complication_anterieures) {
    antecedents.add(complication_anterieures);
}


public void ajouteranalyse(String analyse) {
    observations.add(analyse);
}

public void ajouterradio(String radio) {
    ordonnances.add(radio);
}

public void ajouterechographie(String echographie) {
    antecedents.add(echographie);
}
public void ajouterscanner(String scanner) {
    observations.add(scanner);
}

public void ajouterallergie(String allergie) {
    ordonnances.add(allergie);
}

public void ajouterchirurgie(String chirurgie) {
    antecedents.add(chirurgie);
}
public void afficherDossier() {
	    System.out.println("Observations : " + observations);
	    System.out.println("Ordonnances : " + ordonnances);
	    System.out.println("Antécédents : " + antecedents); 
	    System.out.println("maladie_chronique : " + maladie_chronique);
	    System.out.println("maladie_virale : " + maladie_virale);
	    System.out.println("complication_anterieures : " + complication_anterieures);
	    System.out.println("analyse : " + analyse);
	    System.out.println(" radio : " +  radio);
	    System.out.println("echographie : " + echographie);
	    System.out.println("scanner : " + scanner);
	    System.out.println(" allergie : " +  allergie);
	    System.out.println("chirurgie: " + chirurgie);
	    
}
}
