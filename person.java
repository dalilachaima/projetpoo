package projetpoo;
public class person {
	 private String nom;
	 private String prenom;
	 private int date_de_naissance ;
	 private String lieu_de_naissance;
	 private String sex;
	 private String address;
	 private int nmbtelephone;
	 private String groupage;
	 
	public person(String nom,String prenom,int date_de_naissance,String lieu_de_naissance,String sex,String address,int nmbtelephone,String groupage){
		this.address=address;
		this.date_de_naissance=date_de_naissance;
		this.groupage=groupage;
		this.lieu_de_naissance=lieu_de_naissance;
		this.nmbtelephone=nmbtelephone;
		this.nom=nom;
		this.prenom=prenom;
		this.sex=sex;
	 };
	 
	 
	 
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getDate_de_naissance() {
		return date_de_naissance;
	}
	public void setDate_de_naissance(int date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}
	public String getLieu_de_naissance() {
		return lieu_de_naissance;
	}
	public void setLieu_de_naissance(String lieu_de_naissance) {
		this.lieu_de_naissance = lieu_de_naissance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNmbtelephone() {
		return nmbtelephone;
	}
	public void setNmbtelephone(int nmbtelephone) {
		this.nmbtelephone = nmbtelephone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getGroupage() {
		return groupage;
	}
	public void setGroupage(String groupage) {
		this.groupage = groupage;
	}
	
	 public void afficher_info() {
		 System.out.println("NOM: "+ nom +"PRENOM: "+ prenom + "DATE DE NAISSANCE : "+ date_de_naissance + "LIEU DE NAISSANCE : " + lieu_de_naissance +"SEX: "+sex+"ADDRESS: "+address+"GROUPAGE: "+groupage +"NUMERO DE TELEPHONE: " + nmbtelephone );
	 }
	}


