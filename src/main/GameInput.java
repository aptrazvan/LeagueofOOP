package main;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class GameInput {
    // DO NOT MODIFY
    private Pair<Integer, Integer> terrainDim;
    private ArrayList<String> terrainType;
    private int playersNumber;
    private ArrayList<Triplet<String, Integer, Integer>> players;
    private int roundsNumber;
    private ArrayList<String> moves;

    public GameInput() {
        terrainType = null;
        playersNumber = -1;
        players = null;
        roundsNumber = -1;
        moves = null;
    }

    public GameInput(Pair<Integer, Integer> terrainDim, ArrayList<String> terrainType, int playersNumber,
                     ArrayList<Triplet<String, Integer, Integer>> players, int roundsNumber, ArrayList<String> moves) {
        this.terrainDim = terrainDim;
        this.terrainType = terrainType;
        this.playersNumber = playersNumber;
        this.players = players;
        this.roundsNumber = roundsNumber;
        this.moves = moves;
    }

    public Pair<Integer, Integer> getTerrainDim() {
        return terrainDim;
    }

    public ArrayList<String> getTerrainType() {
        return terrainType;
    }

    public int getPlayersNumber() {
        return playersNumber;
    }

    public ArrayList<Triplet<String, Integer, Integer>> getPlayers() {
        return players;
    }

    public int getRoundsNumber() {
        return roundsNumber;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = terrainType != null && players != null && moves != null;
        boolean membersNotEmpty = playersNumber > 0 && roundsNumber > 0;

        return membersInstantiated && membersNotEmpty;
    }
}
