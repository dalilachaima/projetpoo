package projetpoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerrainMedical {
    private List<String> terrainsMedicaux;

    public TerrainMedical() {
        this.terrainsMedicaux = new ArrayList<>();
    }

    public void ajouterTerrain(String terrain) {
        terrainsMedicaux.add(terrain);
    }

    public List<String> getTerrainsMedicaux() {
        return terrainsMedicaux;
    }

    public String getTerrain(int terrainId) {
        if (terrainId > 0 && terrainId <= terrainsMedicaux.size()) {
            return terrainsMedicaux.get(terrainId - 1);
        } else {
            return "Terrain médical introuvable";
        }
    }

    public void mettreAJourTerrain(Scanner scanner) {
        System.out.println("Entrez les détails du terrain médical (tapez 'fin' pour terminer) :");
        while (true) {
            String terrain = scanner.nextLine().trim();
            if ("fin".equalsIgnoreCase(terrain)) {
                break;
            }
            ajouterTerrain(terrain);
        }
    }

    public void afficherTerrain() {
        System.out.println("Terrains Médicaux : " + terrainsMedicaux);
    }
}

