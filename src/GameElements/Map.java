package GameElements;

import javafx.util.Pair;

import java.util.ArrayList;

public class Map {
    private String[][] terrain;

    public Map(Pair<Integer, Integer> terrainDim, ArrayList<String> terrainType) {
        terrain = new String[terrainDim.getKey()][terrainDim.getValue()];

        for (int i = 0; i < terrainDim.getKey(); i++) {
            for(int j = 0; j < terrainDim.getValue(); j++) {
                terrain[i][j] = String.valueOf(terrainType.get(i).charAt(j));
            }
        }
    }

    public String getTerrainType(int xCoord, int yCoord) {
        return terrain[xCoord][yCoord];
    }
}
