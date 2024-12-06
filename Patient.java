package projetpoo;

public class Patient extends Person  {

	private DossierMedical dossierMedical;
	 private float poids;
	 private float taille;
	 public Patient(String nom,String prenom, String date_de_naissance,String lieu_de_naissance,String sexe,String address,int nmbtelephone,String groupage, float poids , float taille) {
	        super(nom,prenom,date_de_naissance,lieu_de_naissance,sexe,address,nmbtelephone, groupage);
	        this.poids=poids;
	        this.taille= taille;
	        this.dossierMedical = new DossierMedical();
	    }
	 public void ajouterObservation(String observation) {
		 dossierMedical.ajouterObservation(observation);
		}

		public void ajouterOrdonnance(String ordonnance) {
			dossierMedical.ajouterOrdonnance(ordonnance);
		}

		public void ajouterAntecedent(String antecedent) {
			dossierMedical.ajouterAntecedent(antecedent);
		}

		public void ajoutermaladie_chronique(String maladie_chronique) {
			dossierMedical.ajoutermaladie_chronique(maladie_chronique);
		}

		public void ajoutermaladie_virale(String maladie_virale) {
			dossierMedical.ajoutermaladie_virale(maladie_virale);
		}

		public void ajoutercomplication_anterieures(String complication_anterieures) {
			dossierMedical.ajoutercomplication_anterieures(complication_anterieures);
		}


		public void ajouteranalyse(String analyse) {
			dossierMedical.ajouteranalyse(analyse);
		}

		public void ajouterradio(String radio) {
			dossierMedical.ajouterradio(radio);
		}

		public void ajouterechographie(String echographie) {
			dossierMedical.ajouterechographie(echographie);
		}
		public void ajouterscanner(String scanner) {
			dossierMedical.ajouterscanner(scanner);
		}

		public void ajouterallergie(String allergie) {
			dossierMedical.ajouterallergie(allergie);
		}

		public void ajouterchirurgie(String chirurgie) {
			dossierMedical.ajouterchirurgie(chirurgie);
		}
		 public void afficherDossier() {
		        System.out.println("Dossier Médical de " + getNom() + " " + getPrenom());
		        dossierMedical.afficherDossier();
		    }


}
