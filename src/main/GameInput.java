package main;

import java.util.ArrayList;

public final class GameInput {
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

    public GameInput(final Pair<Integer, Integer> terrainDim,
                     final ArrayList<String> terrainType, final int playersNumber,
                     final ArrayList<Triplet<String, Integer, Integer>> players,
                     final int roundsNumber, final ArrayList<String> moves) {
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

    public boolean isValidInput() {
        boolean membersInstantiated = terrainType != null && players != null && moves != null;
        boolean membersNotEmpty = playersNumber > 0 && roundsNumber > 0;

        return membersInstantiated && membersNotEmpty;
    }
}
