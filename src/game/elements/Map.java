package game.elements;

import main.Pair;

import java.util.ArrayList;

public final class Map {
    private static Map instance = null;
    private String[][] terrain;

    private Map(final Pair<Integer, Integer> terrainDim, final ArrayList<String> terrainType) {
        terrain = new String[terrainDim.getKey()][terrainDim.getValue()];

        for (int i = 0; i < terrainDim.getKey(); i++) {
            for (int j = 0; j < terrainDim.getValue(); j++) {
                terrain[i][j] = String.valueOf(terrainType.get(i).charAt(j));
            }
        }
    }

    public static void getInstance(final Pair<Integer, Integer> terrainDim,
                                   final ArrayList<String> terrainType) {
        instance = new Map(terrainDim, terrainType);
    }

    public static Map getInstance() {
        return instance;
    }

    public String getTerrainType(final int xCoord, final int yCoord) {
        return terrain[xCoord][yCoord];
    }
}
