package game.elements;

import fileio.FileSystem;

import java.io.IOException;

import static game.elements.Constants.ANGEL_HELP_STATE;
import static game.elements.Constants.ANGEL_HIT_STATE;
import static game.elements.Constants.ANGEL_KILL_STATE;
import static game.elements.Constants.ANGEL_SPAWNED_STATE;
import static game.elements.Constants.ANGEL_SPAWNER_STATE;
import static game.elements.Constants.PLAYER_KILL_STATE;
import static game.elements.Constants.PLAYER_LEVEL_UP_STATE;
import static game.elements.Constants.RESULTS_STATE;
import static game.elements.Constants.ROUND_STATE;

public class TheGreatWizard extends Observer {
    private static TheGreatWizard instance = null;
    private String mInputPath;
    private String mOutputPath;
    private FileSystem fs;

    public static TheGreatWizard getInstance() {
        if (instance == null) {
            instance = new TheGreatWizard();
        }

        return instance;
    }

    public final void setPath(final String inputPath, final String outpuPath) {
        mInputPath = inputPath;
        mOutputPath = outpuPath;

        try {
            fs = new FileSystem(mInputPath, mOutputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final FileSystem getFile() {
        return fs;
    }

    @Override
    public final void update(final int state, final String firstName, final String secondName,
                       final int firstPosition, final int secondPosition) {
        try {
            switch (state) {
                case ROUND_STATE:
                    if (firstPosition != 1) {
                        fs.writeWord("\n");
                    }

                    fs.writeWord("~~ Round " + firstPosition + " ~~\n");
                    break;
                case RESULTS_STATE:
                    fs.writeWord("\n~~ Results ~~\n");
                    break;
                case ANGEL_SPAWNED_STATE:
                    fs.writeWord("Angel " + firstName + " was spawned at "
                            + firstPosition + " " + secondPosition + "\n");
                    break;
                case ANGEL_HELP_STATE:
                    fs.writeWord(firstName + " helped " + secondName + " " + secondPosition + "\n");
                    break;
                case ANGEL_HIT_STATE:
                    fs.writeWord(firstName + " hit " + secondName + " " + secondPosition + "\n");
                    break;
                case PLAYER_KILL_STATE:
                    fs.writeWord("Player " + firstName + " " + firstPosition
                            + " was killed by " + secondName + " " + secondPosition + "\n");
                    break;
                case PLAYER_LEVEL_UP_STATE:
                    fs.writeWord(firstName + " " + firstPosition
                            + " reached level " + secondPosition + "\n");
                    break;
                case ANGEL_KILL_STATE:
                    fs.writeWord("Player " + firstName + " "
                            + firstPosition + " was killed by an angel\n");
                    break;
                case ANGEL_SPAWNER_STATE:
                    fs.writeWord("Player " + firstName + " "
                            + firstPosition + " was brought to life by an angel\n");
                    break;
                default:
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
