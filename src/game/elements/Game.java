package game.elements;

import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;

import static game.elements.Constants.BASE_XP;
import static game.elements.Constants.COEFFICIENT2;
import static game.elements.Constants.PLAYER_KILL_STATE;
import static game.elements.Constants.RESULTS_STATE;
import static game.elements.Constants.ROUND_STATE;

public final class Game {
    private int roundsNumber;
    private ArrayList<Player> players;
    private ArrayList<String> moves;
    private ArrayList<Angel> angels;

    public Game(final int rounds, final ArrayList<Player> playersList,
                final ArrayList<String> movesList,
                final ArrayList<Angel> angelsList) {
        roundsNumber = rounds;
        players = playersList;
        moves = movesList;
        angels = angelsList;
    }

    public void battle(final Player player1, final Player player2) {
        int isDeflect = 0;

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
            Subject.getInstance().setState(PLAYER_KILL_STATE, player2.getHeroClass(),
                    player1.getHeroClass(), player2.getId(), player1.getId());
            Subject.getInstance().setState(PLAYER_KILL_STATE, player1.getHeroClass(),
                    player2.getHeroClass(), player1.getId(), player2.getId());

            player1.takeDamage(player1.getHP());
            player2.takeDamage(player2.getHP());

        } else if (player2.getHP() <= 0) {
            Subject.getInstance().setState(PLAYER_KILL_STATE, player2.getHeroClass(),
                    player1.getHeroClass(), player2.getId(), player1.getId());

            player1.gainXP(Math.max(0, BASE_XP - (player1.getLevel()
                    - player2.getLevel()) * COEFFICIENT2));
            player1.levelUp();
            player2.setIncapacitated(true);


        } else if (player1.getHP() <= 0) {
            Subject.getInstance().setState(PLAYER_KILL_STATE, player1.getHeroClass(),
                    player2.getHeroClass(), player1.getId(), player2.getId());

            player2.gainXP(Math.max(0, BASE_XP - (player2.getLevel()
                    - player1.getLevel()) * COEFFICIENT2));
            player2.levelUp();
            player1.setIncapacitated(true);

        }

    }

    public void play() {
        int currentRound = 0;

        while (currentRound < roundsNumber) {
            Subject.getInstance().setState(ROUND_STATE, null, null, currentRound + 1, 0);

            for (Player player : players) {
                if (player.getHP() > 0) {
                    player.setIncapacitated(false);
                }

                player.resolveEffects();

                if (player.getHP() > 0) {
                    Context context = player.getContext();

                    if (context != null && !player.getIncapacitated()) {
                        context.executeStrategy(player);
                    }

                    player.setAbilityModifier();
                }
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

            for (Angel angel: angels) {
                if (angel.getRound() == currentRound) {
                    Subject.getInstance().setState(2, angel.getAngelClass(), null,
                            angel.getPosition()[0], angel.getPosition()[1]);
                    for (Player player: players) {
                        if (angel.equalsPosition(player.getPosition())) {
                            if (!(angel instanceof Spawner) && player.getHP() > 0) {
                                angel.interact(player);
                            } else if (angel instanceof Spawner && player.getHP() <= 0) {
                                angel.interact(player);
                            }
                        }

                    }
                }
            }

            currentRound++;
        }

    }

    public void listResults(final FileSystem fs) throws IOException {
        Subject.getInstance().setState(RESULTS_STATE, null, null, 0, 0);

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
