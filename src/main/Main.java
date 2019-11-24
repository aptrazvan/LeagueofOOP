package main;

import GameElements.*;
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
        ArrayList<Triplet<String, Integer, Integer>> playerLocation = gameInput.getPlayers();
        int roundsNumber = gameInput.getRoundsNumber();
        ArrayList<String> moves = gameInput.getMoves();

        Map.getInstance(terrainDim, terrainType);

        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < playerLocation.size(); i++) {
            if (playerLocation.get(i).getFirst().equals("P")) {
                players.add(new Pyromancer(playerLocation.get(i).getSecond(), playerLocation.get(i).getThird()));
            }
            else if (playerLocation.get(i).getFirst().equals("K")) {
                players.add(new Knight(playerLocation.get(i).getSecond(), playerLocation.get(i).getThird()));
            }
            else if (playerLocation.get(i).getFirst().equals("W")) {
                players.add(new Wizard(playerLocation.get(i).getSecond(), playerLocation.get(i).getThird()));
            }
            else if (playerLocation.get(i).getFirst().equals("R")) {
                players.add(new Rogue(playerLocation.get(i).getSecond(), playerLocation.get(i).getThird()));
            }
        }

        Game game = new Game(roundsNumber, players, moves);

        game.play();
        game.listResults();

    }
}
