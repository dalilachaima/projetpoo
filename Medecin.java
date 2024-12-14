package projetpoo;

import java.time.LocalDate;

public class Medecin extends Person  {

	private String specialty; 
    private String hospital;  
    private String licenseNumber;
    public Medecin() {
    	super(getNom(), prenom,getDate_de_naissance(),getLieu_de_naissance(), sexe,address,numeroTelephone, getGroupage());
        this.specialty;
        this.hospital;
        this.licenseNumber;
       
    }
    
}
