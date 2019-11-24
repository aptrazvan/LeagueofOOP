package main;

import java.util.ArrayList;

import fileio.FileSystem;
import javafx.util.Pair;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        Pair<Integer, Integer> terrainDim = null;
        ArrayList<String> terrainType = new ArrayList<>();
        int playersNumber = -1;
        ArrayList<Triplet<String, Integer, Integer>> players = new ArrayList<>();
        int roundsNumber = -1;
        ArrayList<String> moves = new ArrayList<>();

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            terrainDim = new Pair(fs.nextInt(), fs.nextInt());

            for (int i = 0; i < terrainDim.getKey(); i++) {
                terrainType.add(fs.nextWord());
            }

            playersNumber = fs.nextInt();

            for (int i = 0; i < playersNumber; i++) {
                players.add(new Triplet<String, Integer, Integer>(fs.nextWord(), fs.nextInt(), fs.nextInt()));
            }

            roundsNumber = fs.nextInt();
            String word;

            for (int i = 0; i < roundsNumber; i++) {
                //moves.add(fs.nextWord());
                word = fs.nextWord();

                for (int j = 0; j < playersNumber; j++) {
                    moves.add(String.valueOf(word.charAt(j)));
                }
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(terrainDim, terrainType, playersNumber, players, roundsNumber, moves);
    }
}
