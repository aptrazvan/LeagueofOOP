package GameElements;

import java.util.ArrayList;

public class Game {
    int roundsNumber;
    ArrayList<Player> players;
    ArrayList<String> moves;

    public Game(int roundsNumber, ArrayList<Player> players, ArrayList<String> moves) {
        this.roundsNumber = roundsNumber;
        this.players = players;
        this.moves = moves;
    }

    public void battle(Player player1, Player player2) {
        for (int i = 0; i < player1.getAbilities().size(); i++) {
            player2.accept(player1.getAbilities().get(i));
            System.out.println(player2.getHP());
            player1.accept(player2.getAbilities().get(i));
            System.out.println(player2.getHP());
        }

        if (player1.getHP() <= 0 && player2.getHP() <= 0) {
            player1.gainXP(Math.max(0, 200 - (player1.getLevel() - player2.getLevel()) * 40));
            player2.gainXP(Math.max(0, 200 - (player2.getLevel() - player1.getLevel()) * 40));
            player1.levelUp();
            player2.levelUp();
            player1.setIncapacitated(true);
            player2.setIncapacitated(true);
        }
        else if (player2.getHP() <= 0) {
            player1.gainXP(Math.max(0, 200 - (player1.getLevel() - player2.getLevel()) * 40));
            player1.levelUp();
            player2.setIncapacitated(true);
        }
        else if (player1.getHP() <= 0) {
            player2.gainXP(Math.max(0, 200 - (player2.getLevel() - player1.getLevel()) * 40));
            player2.levelUp();
            player1.setIncapacitated(true);
        }
    }

    public void play() {
//        System.out.println(players.get(0).getPosition()[1]);
//        System.out.println(players.get(1).getHeroClass());
//        players.get(1).accept(players.get(0).getAbilities().get(1));
        int currentRound = 0;
        int movesCounter = 0;

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getHP() > 0) {
                players.get(i).setIncapacitated(false);
            }

            players.get(i).resolveEffects();
        }

        while (currentRound < roundsNumber) {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getIncapacitated() == false) {
                    players.get(i).move(moves.get(i + currentRound * players.size()));
                }
            }

            movesCounter += players.size();

            for (int i = 0; i < players.size() - 1; i++) {
                for (int j = i + 1; j < players.size(); j++) {
                    if (players.get(i).equalsPosition(players.get(j).getPosition())
                            && players.get(i).getHP() > 0 && players.get(j).getHP() > 0) {
                        battle(players.get(i), players.get(j));
                    }
                }
            }

            currentRound++;
        }

    }

    public void listResults() {
        String classType;

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getHP() <= 0) {
                System.out.println(players.get(i).getHeroClass() + " dead");
            }
            else {
                System.out.println(players.get(i).getHeroClass() + " " + players.get(i).getLevel() + " " + players.get(i).getXP() +
                        " " + players.get(i).getHP() + " " + players.get(i).getPosition()[0] + " " + players.get(i).getPosition()[1]);
            }
        }
    }


}
