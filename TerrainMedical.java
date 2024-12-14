package projetpoo;
import java.util.ArrayList;
import java.util.List;
public class TerrainMedical { 
	
	public Object getTerrainMedical() {
	    List<String> terrainsMedicaux = new ArrayList<>();
	    terrainsMedicaux.add("Hôpital Général"); 
	    terrainsMedicaux.add("Clinique Privée"); 
	    terrainsMedicaux.add("Centre de Santé Communautaire"); 
	    int terrainId = 2; 
	    if (terrainId > 0 && terrainId <= terrainsMedicaux.size()) {
	        return terrainsMedicaux.get(terrainId - 1); 
	    } else {
	        return "Terrain médical introuvable";
	    }
	}
	

}
