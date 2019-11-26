package main;

import game.elements.Game;
import game.elements.Knight;
import game.elements.Map;
import game.elements.Player;
import game.elements.Pyromancer;
import game.elements.Rogue;
import game.elements.Wizard;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private Main() {

    }

    public static void main(final String[] args) throws IOException {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        Pair<Integer, Integer> terrainDim = gameInput.getTerrainDim();
        ArrayList<String> terrainType = gameInput.getTerrainType();
        ArrayList<Triplet<String, Integer, Integer>> playerLocation = gameInput.getPlayers();
        int roundsNumber = gameInput.getRoundsNumber();
        ArrayList<String> moves = gameInput.getMoves();

        Map.getInstance(terrainDim, terrainType);

        ArrayList<Player> players = new ArrayList<>();

        for (Triplet<String, Integer, Integer> stringIntegerIntegerTriplet : playerLocation) {
            switch (stringIntegerIntegerTriplet.getFirst()) {
                case "P":
                    players.add(new Pyromancer(stringIntegerIntegerTriplet.getSecond(),
                            stringIntegerIntegerTriplet.getThird()));
                    break;
                case "K":
                    players.add(new Knight(stringIntegerIntegerTriplet.getSecond(),
                            stringIntegerIntegerTriplet.getThird()));
                    break;
                case "W":
                    players.add(new Wizard(stringIntegerIntegerTriplet.getSecond(),
                            stringIntegerIntegerTriplet.getThird()));
                    break;
                case "R":
                    players.add(new Rogue(stringIntegerIntegerTriplet.getSecond(),
                            stringIntegerIntegerTriplet.getThird()));
                    break;
                default:
                    break;
            }
        }

        Game game = new Game(roundsNumber, players, moves);

        game.play();
        game.listResults(args[0], args[1]);

    }
}
