package projetpoo;
import java.time.LocalDate;

public class FichePatient extends Person {
	   private boolean newpatient;
	   private TerrainMedical terrainMedical;
	    public FichePatient(String nom,String prenom,LocalDate date_de_naissance,String lieu_de_naissance,String sexe,String address,int numeroTelephone,String groupage,TerrainMedical terrainMedical) {
	    	 super(nom,prenom,date_de_naissance,lieu_de_naissance,sexe,address, numeroTelephone, groupage);
	        this.terrainMedical = new TerrainMedical();
	    }
		public void ecrireFiche() {
			newpatient=true;
	
		}
		public void setAdresse(String trim) {
			
			
		}
}
