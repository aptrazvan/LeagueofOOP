package main;

import game.elements.Angel;
import game.elements.AngelFactory;
import game.elements.Game;
import game.elements.Map;
import game.elements.Player;
import game.elements.PlayerFactory;
import game.elements.TheGreatWizard;

import java.io.IOException;
import java.util.ArrayList;

public final class Main {

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

        PlayerFactory playerFactory = new PlayerFactory();
        ArrayList<Player> players = new ArrayList<>();

        for (Triplet<String, Integer, Integer> stringIntegerIntegerTriplet : playerLocation) {
            players.add(playerFactory.getPlayer(stringIntegerIntegerTriplet));
            players.get(players.size() - 1).setId(players.size() - 1);
        }

        ArrayList<Integer> angelsNumber = gameInput.getAngelsNumber();
        ArrayList<String> angelsLocation = gameInput.getAngels();

        AngelFactory angelFactory = new AngelFactory();
        ArrayList<Angel> angels = new ArrayList<>();
        int angelCounter = 0;

        for (int i = 0; i < roundsNumber; i++) {
            for (int j = 0; j < angelsNumber.get(i); j++) {
                int index = angelsLocation.get(angelCounter).indexOf(",");
                String angelName = angelsLocation.get(angelCounter).substring(0, index);
                String position = angelsLocation.get(angelCounter).substring(index + 1);

                int indexPositionX = position.indexOf(",");
                int positionX = Integer.parseInt(position.substring(0, indexPositionX));
                int positionY = Integer.parseInt(position.substring(indexPositionX + 1));

                angels.add(angelFactory.getAngel(angelName, i, positionX, positionY));

                angelCounter++;
            }
        }

        TheGreatWizard.getInstance().setPath(args[0], args[1]);

        Game game = new Game(roundsNumber, players, moves, angels);

        game.play();

        game.listResults(TheGreatWizard.getInstance().getFile());

    }
}
