package game.elements;

import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;

import static game.elements.Constants.BASE_XP;
import static game.elements.Constants.COEFFICIENT2;

public final class Game {
    private int roundsNumber;
    private ArrayList<Player> players;
    private ArrayList<String> moves;

    public Game(final int rounds, final ArrayList<Player> playersList,
                final ArrayList<String> movesList) {
        roundsNumber = rounds;
        players = playersList;
        moves = movesList;
    }

    public void battle(final Player player1, final Player player2) {
        int isDeflect = 0;
        System.out.println("Battle: " + player1.getHeroClass() + " " + player2.getHeroClass());
        System.out.println(player1.getHP() + " " + player2.getHP());

        for (int i = 0; i < player1.getAbilities().size(); i++) {
            if (!(player1.getAbilities().get(i) instanceof Deflect)) {
                player2.accept(player1.getAbilities().get(i));
            } else {
                isDeflect = 1;
            }

            if (!(player2.getAbilities().get(i) instanceof Deflect)) {
                player1.accept(player2.getAbilities().get(i));
            } else {
                isDeflect = 2;
            }

            if (isDeflect == 1) {
                int damage = ((Wizard) player1).getDamageReceived();
                ((Deflect) player1.getAbilities().get(1)).setDamage(damage);
                player2.accept(player1.getAbilities().get(1));
            } else if (isDeflect == 2) {
                int damage = ((Wizard) player2).getDamageReceived();
                ((Deflect) player2.getAbilities().get(1)).setDamage(damage);
                player1.accept(player2.getAbilities().get(1));
            }

        }

        if (player1.getHP() <= 0 && player2.getHP() <= 0) {
            player1.gainXP(Math.max(0, BASE_XP - (player1.getLevel()
                    - player2.getLevel()) * COEFFICIENT2));
            player2.gainXP(Math.max(0, BASE_XP - (player2.getLevel()
                    - player1.getLevel()) * COEFFICIENT2));
            player1.levelUp();
            player2.levelUp();
            player1.takeDamage(player1.getHP());
            player2.takeDamage(player2.getHP());
        } else if (player2.getHP() <= 0) {
            player1.gainXP(Math.max(0, BASE_XP - (player1.getLevel()
                    - player2.getLevel()) * COEFFICIENT2));
            player1.levelUp();
            player2.setIncapacitated(true);
        } else if (player1.getHP() <= 0) {
            player2.gainXP(Math.max(0, BASE_XP - (player2.getLevel()
                    - player1.getLevel()) * COEFFICIENT2));
            player2.levelUp();
            player1.setIncapacitated(true);
        }

        System.out.println(player1.getHP() + " " + player2.getHP());

    }

    public void play() {
        int currentRound = 0;

        while (currentRound < roundsNumber) {

            for (Player player : players) {
                if (player.getHP() > 0) {
                    player.setIncapacitated(false);
                }

                player.resolveEffects();
            }

            for (int i = 0; i < players.size(); i++) {
                if (!players.get(i).getIncapacitated()) {
                    players.get(i).move(moves.get(i + currentRound * players.size()));
                }
            }

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

    public void listResults(final String mInputPath, final String mOutputPath) throws IOException {
        String classType;
        FileSystem fs = new FileSystem(mInputPath, mOutputPath);

        for (Player player : players) {
            if (player.getHP() <= 0) {
                fs.writeWord(player.getHeroClass().charAt(0) + " dead" + "\n");
            } else {
                fs.writeWord(player.getHeroClass().charAt(0) + " "
                        + player.getLevel() + " " + player.getXP() + " " + player.getHP()
                        + " " + player.getPosition()[0] + " " + player.getPosition()[1] + "\n");

            }
        }
        fs.close();
    }


}
