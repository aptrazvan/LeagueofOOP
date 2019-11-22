package main;

import javafx.util.Pair;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        GameInputLoader gameInputLoader = new GameInputLoader("/home/apetroaie/Labs/POO/Project/src/main/input.in",
                "/home/apetroaie/Labs/POO/Project/src/main/output.out");
        GameInput gameInput = gameInputLoader.load();

        Pair<Integer, Integer> terrainDim = gameInput.getTerrainDim();
        ArrayList<String> terrainType = gameInput.getTerrainType();
        int playersNumber = gameInput.getPlayersNumber();
        ArrayList<Triplet<String, Integer, Integer>> players = gameInput.getPlayers();
        int roundsNumber = gameInput.getRoundsNumber();
        ArrayList<String> moves = gameInput.getMoves();

        System.out.println(roundsNumber);
        System.out.println(moves);
    }
}
