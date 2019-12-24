package game.elements;

import fileio.FileSystem;

import java.io.IOException;

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
                case 0:
                    if (firstPosition != 1) {
                        fs.writeWord("\n");
                    }

                    fs.writeWord("~~ Round " + firstPosition + " ~~\n");
                    break;
                case 1:
                    fs.writeWord("\n~~ Results ~~\n");
                    break;
                case 2:
                    fs.writeWord("Angel " + firstName + " was spawned at "
                            + firstPosition + " " + secondPosition + "\n");
                    break;
                case 3:
                    fs.writeWord(firstName + " helped " + secondName + " " + secondPosition + "\n");
                    break;
                case 4:
                    fs.writeWord(firstName + " hit " + secondName + " " + secondPosition + "\n");
                    break;
                case 5:
                    fs.writeWord("Player " + firstName + " " + firstPosition
                            + " was killed by " + secondName + " " + secondPosition + "\n");
                    break;
                case 6:
                    fs.writeWord(firstName + " " + firstPosition
                            + " reached level " + secondPosition + "\n");
                    break;
                case 7:
                    fs.writeWord("Player " + firstName + " "
                            + firstPosition + " was killed by an angel\n");
                    break;
                case 8:
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
