package main;

import game.elements.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class Main {

    private Main() {

    }

    public static void main(final String[] args) throws IOException {
        String filePath = (new File("")).getAbsolutePath();
        String path1 = filePath.concat("/src/main/input.in");
        String path2 = filePath.concat("/src/main/output.out");
        //GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInputLoader gameInputLoader = new GameInputLoader(path1, path2);
        GameInput gameInput = gameInputLoader.load();

        Pair<Integer, Integer> terrainDim = gameInput.getTerrainDim();
        ArrayList<String> terrainType = gameInput.getTerrainType();
        ArrayList<Triplet<String, Integer, Integer>> playerLocation = gameInput.getPlayers();
        int roundsNumber = gameInput.getRoundsNumber();
        ArrayList<String> moves = gameInput.getMoves();

        Map.getInstance(terrainDim, terrainType);

        PlayerFactory playerFactory = new PlayerFactory();
        ArrayList<Player> players = new ArrayList<>();

        for (Triplet<String, Integer, Integer> stringIntegerIntegerTriplet : playerLocation) {
            players.add(playerFactory.getPlayer(stringIntegerIntegerTriplet));
            /*switch (stringIntegerIntegerTriplet.getFirst()) {
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
            }*/
        }

        Game game = new Game(roundsNumber, players, moves);

        game.play();
        //game.listResults(args[0], args[1]);
        game.listResults(path1, path2);

    }
}
